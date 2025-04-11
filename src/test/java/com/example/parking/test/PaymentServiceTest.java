package com.example.parking.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    
    @Mock
    private PaymentMethod mockPaymentMethod;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        paymentService = new PaymentService(bookingDAO);
    }
    
    @Test
    void testProcessPayment() {
        // Setup
        Client mockClient = new FacultyMember("FM001", "John Doe", "john@example.com", "password", "CS101", "Computer Science");
        ParkingSpace mockSpace = new ParkingSpace("A1", 10.0);
        Booking mockBooking = new Booking("B001", mockClient, mockSpace, LocalDateTime.now(), LocalDateTime.now().plusHours(2), mockPaymentMethod);
        mockBooking.setAmount(20.0);
        
        when(mockPaymentMethod.processPayment(20.0)).thenReturn(true);
        
        // Execute
        paymentService.processPayment(mockBooking);
        
        // Verify
        assertEquals("PAID", mockBooking.getStatus());
        verify(bookingDAO).update(mockBooking);
        verify(mockPaymentMethod).processPayment(20.0);
    }
    
    @Test
    void testProcessPaymentWithNoPaymentMethod() {
        // Setup
        Client mockClient = new FacultyMember("FM001", "John Doe", "john@example.com", "password", "CS101", "Computer Science");
        ParkingSpace mockSpace = new ParkingSpace("A1", 10.0);
        Booking mockBooking = new Booking("B001", mockClient, mockSpace, LocalDateTime.now(), LocalDateTime.now().plusHours(2), null);
        
        // Execute and Verify
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            paymentService.processPayment(mockBooking);
        });
        
        assertTrue(exception.getMessage().contains("No payment method specified"));
    }
    
    @Test
    void testProcessPaymentFailure() {
        // Setup
        Client mockClient = new FacultyMember("FM001", "John Doe", "john@example.com", "password", "CS101", "Computer Science");
        ParkingSpace mockSpace = new ParkingSpace("A1", 10.0);
        Booking mockBooking = new Booking("B001", mockClient, mockSpace, LocalDateTime.now(), LocalDateTime.now().plusHours(2), mockPaymentMethod);
        mockBooking.setAmount(20.0);
        
        when(mockPaymentMethod.processPayment(20.0)).thenReturn(false);
        
        // Execute and Verify
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            paymentService.processPayment(mockBooking);
        });
        
        assertTrue(exception.getMessage().contains("Payment processing failed"));
    }
    
    @Test
    void testProcessRefund() {
        // Setup
        Client mockClient = new FacultyMember("FM001", "John Doe", "john@example.com", "password", "CS101", "Computer Science");
        ParkingSpace mockSpace = new ParkingSpace("A1", 10.0);
        Booking mockBooking = new Booking("B001", mockClient, mockSpace, LocalDateTime.now(), LocalDateTime.now().plusHours(2), mockPaymentMethod);
        mockBooking.setAmount(20.0);
        
        // Execute
        paymentService.processRefund(mockBooking);
        
        // Verify
        assertEquals("REFUNDED", mockBooking.getStatus());
        verify(bookingDAO).update(mockBooking);
        verify(mockPaymentMethod).processRefund(16.0); // 80% of 20.0
    }
    
    @Test
    void testProcessRefundWithNoPaymentMethod() {
        // Setup
        Client mockClient = new FacultyMember("FM001", "John Doe", "john@example.com", "password", "CS101", "Computer Science");
        ParkingSpace mockSpace = new ParkingSpace("A1", 10.0);
        Booking mockBooking = new Booking("B001", mockClient, mockSpace, LocalDateTime.now(), LocalDateTime.now().plusHours(2), null);
        
        // Execute and Verify
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            paymentService.processRefund(mockBooking);
        });
        
        assertTrue(exception.getMessage().contains("No payment method specified"));
    }
    
    @Test
    void testGetUnpaidBookings() {
        // Setup
        List<Booking> mockBookings = new ArrayList<>();
        Client mockClient = new FacultyMember("FM001", "John Doe", "john@example.com", "password", "CS101", "Computer Science");
        ParkingSpace mockSpace = new ParkingSpace("A1", 10.0);
        
        Booking confirmedBooking = new Booking("B001", mockClient, mockSpace, LocalDateTime.now(), LocalDateTime.now().plusHours(2), null);
        confirmedBooking.setStatus("CONFIRMED");
        
        Booking paidBooking = new Booking("B002", mockClient, mockSpace, LocalDateTime.now(), LocalDateTime.now().plusHours(2), null);
        paidBooking.setStatus("PAID");
        
        mockBookings.add(confirmedBooking);
        mockBookings.add(paidBooking);
        
        when(bookingDAO.getAll()).thenReturn(mockBookings);
        
        // Execute
        List<Booking> result = paymentService.getUnpaidBookings();
        
        // Verify
        assertEquals(1, result.size());
        assertEquals("B001", result.get(0).getBookingId());
    }
    
    @Test
    void testGetRefundedBookings() {
        // Setup
        List<Booking> mockBookings = new ArrayList<>();
        Client mockClient = new FacultyMember("FM001", "John Doe", "john@example.com", "password", "CS101", "Computer Science");
        ParkingSpace mockSpace = new ParkingSpace("A1", 10.0);
        
        Booking refundedBooking = new Booking("B001", mockClient, mockSpace, LocalDateTime.now(), LocalDateTime.now().plusHours(2), null);
        refundedBooking.setStatus("REFUNDED");
        
        Booking paidBooking = new Booking("B002", mockClient, mockSpace, LocalDateTime.now(), LocalDateTime.now().plusHours(2), null);
        paidBooking.setStatus("PAID");
        
        mockBookings.add(refundedBooking);
        mockBookings.add(paidBooking);
        
        when(bookingDAO.getAll()).thenReturn(mockBookings);
        
        // Execute
        List<Booking> result = paymentService.getRefundedBookings();
        
        // Verify
        assertEquals(1, result.size());
        assertEquals("B001", result.get(0).getBookingId());
    }
}