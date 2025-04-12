package com.example.parking.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.parking.dao.BookingDAO;
import com.example.parking.model.Booking;
import com.example.parking.model.Client;
import com.example.parking.model.FacultyMember;
import com.example.parking.model.ParkingSpace;
import com.example.parking.model.payment.PaymentMethod;
import com.example.parking.service.PaymentService;

public class PaymentServiceTest {

    private PaymentService paymentService;
    
    @Mock
    private BookingDAO bookingDAO;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        paymentService = new PaymentService(bookingDAO);
    }
    
    @Test
    void testProcessPaymentSuccess() {
        // Setup
        Client client = new FacultyMember("FM001", "John Smith", "john@example.com", "password", "F123", "Computer Science");
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        PaymentMethod paymentMethod = new CreditCard("John Smith", "1234567890123456", "12/25", 1000.0);
        Booking booking = new Booking("B001", client, space, LocalDateTime.now(), LocalDateTime.now().plusHours(2), paymentMethod);
        booking.setAmount(50.0);
        
        // Execute
        paymentService.processPayment(booking);
        
        // Verify
        assertEquals("PAID", booking.getStatus());
        verify(bookingDAO).update(booking);
    }
    
    @Test
    void testProcessPaymentNoPaymentMethod() {
        // Setup
        Client client = new FacultyMember("FM001", "John Smith", "john@example.com", "password", "F123", "Computer Science");
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        Booking booking = new Booking("B001", client, space, LocalDateTime.now(), LocalDateTime.now().plusHours(2), null);
        booking.setAmount(50.0);
        
        // Execute & Verify
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            paymentService.processPayment(booking);
        });
        
        assertTrue(exception.getMessage().contains("No payment method specified"));
        verify(bookingDAO, never()).update(any());
    }
    
    @Test
    void testProcessPaymentFailed() {
        // Setup
        Client client = new FacultyMember("FM001", "John Smith", "john@example.com", "password", "F123", "Computer Science");
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        PaymentMethod paymentMethod = mock(PaymentMethod.class);
        when(paymentMethod.processPayment(anyDouble())).thenReturn(false);
        
        Booking booking = new Booking("B001", client, space, LocalDateTime.now(), LocalDateTime.now().plusHours(2), paymentMethod);
        booking.setAmount(50.0);
        
        // Execute & Verify
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            paymentService.processPayment(booking);
        });
        
        assertTrue(exception.getMessage().contains("Payment processing failed"));
        verify(bookingDAO, never()).update(any());
    }
    
    @Test
    void testProcessRefundSuccess() {
        // Setup
        Client client = new FacultyMember("FM001", "John Smith", "john@example.com", "password", "F123", "Computer Science");
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        PaymentMethod paymentMethod = new CreditCard("John Smith", "1234567890123456", "12/25", 1000.0);
        Booking booking = new Booking("B001", client, space, LocalDateTime.now(), LocalDateTime.now().plusHours(2), paymentMethod);
        booking.setAmount(100.0);
        
        // Execute
        paymentService.processRefund(booking);
        
        // Verify
        assertEquals("REFUNDED", booking.getStatus());
        verify(bookingDAO).update(booking);
    }
    
    @Test
    void testProcessRefundNoPaymentMethod() {
        // Setup
        Client client = new FacultyMember("FM001", "John Smith", "john@example.com", "password", "F123", "Computer Science");
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        Booking booking = new Booking("B001", client, space, LocalDateTime.now(), LocalDateTime.now().plusHours(2), null);
        booking.setAmount(100.0);
        
        // Execute & Verify
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            paymentService.processRefund(booking);
        });
        
        assertTrue(exception.getMessage().contains("No payment method specified"));
        verify(bookingDAO, never()).update(any());
    }
    
    @Test
    void testProcessRefundFailed() {
        // Setup
        Client client = new FacultyMember("FM001", "John Smith", "john@example.com", "password", "F123", "Computer Science");
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        PaymentMethod paymentMethod = mock(PaymentMethod.class);
        doThrow(new RuntimeException("Refund failed")).when(paymentMethod).processRefund(anyDouble());
        
        Booking booking = new Booking("B001", client, space, LocalDateTime.now(), LocalDateTime.now().plusHours(2), paymentMethod);
        booking.setAmount(100.0);
        
        // Execute & Verify
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            paymentService.processRefund(booking);
        });
        
        assertTrue(exception.getMessage().contains("Refund processing failed"));
        verify(bookingDAO, never()).update(any());
    }
    
    @Test
    void testGetUnpaidBookings() {
        // Setup
        Client client = new FacultyMember("FM001", "John Smith", "john@example.com", "password", "F123", "Computer Science");
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        PaymentMethod paymentMethod = new CreditCard("John Smith", "1234567890123456", "12/25", 1000.0);
        
        Booking unpaidBooking = new Booking("B001", client, space, LocalDateTime.now(), LocalDateTime.now().plusHours(2), paymentMethod);
        unpaidBooking.setStatus("CONFIRMED");
        
        Booking paidBooking = new Booking("B002", client, space, LocalDateTime.now(), LocalDateTime.now().plusHours(2), paymentMethod);
        paidBooking.setStatus("PAID");
        
        when(bookingDAO.getAll()).thenReturn(Arrays.asList(unpaidBooking, paidBooking));
        
        // Execute
        List<Booking> result = paymentService.getUnpaidBookings();
        
        // Verify
        assertEquals(1, result.size());
        assertEquals("B001", result.get(0).getBookingId());
    }
    
    @Test
    void testGetRefundedBookings() {
        // Setup
        Client client = new FacultyMember("FM001", "John Smith", "john@example.com", "password", "F123", "Computer Science");
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        PaymentMethod paymentMethod = new CreditCard("John Smith", "1234567890123456", "12/25", 1000.0);
        
        Booking refundedBooking = new Booking("B001", client, space, LocalDateTime.now(), LocalDateTime.now().plusHours(2), paymentMethod);
        refundedBooking.setStatus("REFUNDED");
        
        Booking paidBooking = new Booking("B002", client, space, LocalDateTime.now(), LocalDateTime.now().plusHours(2), paymentMethod);
        paidBooking.setStatus("PAID");
        
        when(bookingDAO.getAll()).thenReturn(Arrays.asList(refundedBooking, paidBooking));
        
        // Execute
        List<Booking> result = paymentService.getRefundedBookings();
        
        // Verify
        assertEquals(1, result.size());
        assertEquals("B001", result.get(0).getBookingId());
    }
}