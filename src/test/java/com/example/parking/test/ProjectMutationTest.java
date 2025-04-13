package com.example.parking.test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import com.example.parking.dao.BookingDAO;
import com.example.parking.dao.ClientDAO;
import com.example.parking.dao.ParkingSpaceDAO;
import com.example.parking.model.Booking;
import com.example.parking.model.Client;
import com.example.parking.model.ParkingSpace;
import com.example.parking.model.Car;
import com.example.parking.model.payment.CreditCard;
import com.example.parking.model.payment.PaymentMethod;
import com.example.parking.service.BookingService;

public class ProjectMutationTest {
    private BookingDAO bookingDAO;
    private ClientDAO clientDAO;
    private ParkingSpaceDAO parkingSpaceDAO;
    private BookingService bookingService;
    private Client testClient;
    private ParkingSpace testSpace;
    private PaymentMethod testPayment;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @BeforeEach
    void setUp() {
        bookingDAO = mock(BookingDAO.class);
        clientDAO = mock(ClientDAO.class);
        parkingSpaceDAO = mock(ParkingSpaceDAO.class);
        bookingService = new BookingService(bookingDAO, clientDAO, parkingSpaceDAO);
        
        testClient = new Client("C001", "Test User", "test@example.com", "password") {
            @Override
            public double getDiscountRate() {
                return 0.15;
            }

            @Override
            public String getType() {
                return "TEST";
            }
        };
        
        testSpace = new ParkingSpace("PS001", 10.0);
        testPayment = new CreditCard("Test User", "1234567890123456", "12/25", 1000.0);
        startTime = LocalDateTime.now();
        endTime = startTime.plusHours(2);
        
        when(clientDAO.getById("C001")).thenReturn(testClient);
        when(parkingSpaceDAO.getById("PS001")).thenReturn(testSpace);
    }

    @Test
    void testClientDiscount() {
        assertEquals(0.15, testClient.getDiscountRate(), "Client discount rate should be 0.15");
        assertEquals("TEST", testClient.getType(), "Client type should be TEST");
    }

    @Test
    void testBookingCreation() {
        // Test successful booking creation
        Booking booking = bookingService.createBooking("C001", "PS001", startTime, endTime, testPayment);
        
        assertNotNull(booking, "Booking should not be null");
        assertEquals(testClient, booking.getClient(), "Client should match");
        assertEquals(testSpace, booking.getSpaceId(), "Space should match");
        assertEquals(startTime, booking.getStartTime(), "Start time should match");
        assertEquals(endTime, booking.getEndTime(), "End time should match");
        assertEquals("CONFIRMED", booking.getStatus(), "Status should be CONFIRMED");
        
        verify(bookingDAO).save(any(Booking.class));
    }

    @Test
    void testBookingCreationWithInvalidClient() {
        when(clientDAO.getById("INVALID")).thenReturn(null);
        
        assertThrows(IllegalArgumentException.class, () -> 
            bookingService.createBooking("INVALID", "PS001", startTime, endTime, testPayment),
            "Should throw exception for invalid client"
        );
    }

    @Test
    void testBookingCreationWithInvalidSpace() {
        when(parkingSpaceDAO.getById("INVALID")).thenReturn(null);
        
        assertThrows(IllegalArgumentException.class, () -> 
            bookingService.createBooking("C001", "INVALID", startTime, endTime, testPayment),
            "Should throw exception for invalid space"
        );
    }

    @Test
    void testBookingCreationWithOccupiedSpace() {
        ParkingSpace occupiedSpace = new ParkingSpace("PS002", 10.0);
        occupiedSpace.setOccupied(true, new Car("ABC123"));
        when(parkingSpaceDAO.getById("PS002")).thenReturn(occupiedSpace);
        
        assertThrows(IllegalStateException.class, () -> 
            bookingService.createBooking("C001", "PS002", startTime, endTime, testPayment),
            "Should throw exception for occupied space"
        );
    }

    @Test
    void testBookingCreationWithInvalidTimeRange() {
        LocalDateTime invalidEndTime = startTime.minusHours(1);
        
        assertThrows(IllegalArgumentException.class, () -> 
            bookingService.createBooking("C001", "PS001", startTime, invalidEndTime, testPayment),
            "Should throw exception for invalid time range"
        );
    }

    @Test
    void testBookingCancellation() {
        Booking booking = new Booking("B001", testClient, testSpace, startTime, endTime, testPayment);
        when(bookingDAO.getById("B001")).thenReturn(booking);
        
        bookingService.cancelBooking("B001");
        
        assertEquals("CANCELLED", booking.getStatus(), "Booking status should be CANCELLED");
        verify(bookingDAO).update(booking);
    }

    @Test
    void testBookingCancellationWithInvalidId() {
        when(bookingDAO.getById("INVALID")).thenReturn(null);
        
        assertThrows(IllegalArgumentException.class, () -> 
            bookingService.cancelBooking("INVALID"),
            "Should throw exception for invalid booking ID"
        );
    }

    @Test
    void testBookingCancellationAlreadyCancelled() {
        Booking booking = new Booking("B001", testClient, testSpace, startTime, endTime, testPayment);
        booking.setStatus("CANCELLED");
        when(bookingDAO.getById("B001")).thenReturn(booking);
        
        assertThrows(IllegalStateException.class, () -> 
            bookingService.cancelBooking("B001"),
            "Should throw exception for already cancelled booking"
        );
    }

    @Test
    void testGetAllBookings() {
        List<Booking> bookings = Arrays.asList(
            new Booking("B001", testClient, testSpace, startTime, endTime, testPayment),
            new Booking("B002", testClient, testSpace, startTime.plusDays(1), endTime.plusDays(1), testPayment)
        );
        when(bookingDAO.getAll()).thenReturn(bookings);
        
        List<Booking> result = bookingService.getAllBookings();
        
        assertEquals(2, result.size(), "Should return all bookings");
        verify(bookingDAO).getAll();
    }

    @Test
    void testGetBookingsByClient() {
        List<Booking> clientBookings = Arrays.asList(
            new Booking("B001", testClient, testSpace, startTime, endTime, testPayment)
        );
        when(bookingDAO.getByClientId("C001")).thenReturn(clientBookings);
        
        List<Booking> result = bookingService.getBookingsByClient("C001");
        
        assertEquals(1, result.size(), "Should return client's bookings");
        assertEquals("C001", result.get(0).getClient().getId(), "Should match client ID");
        verify(bookingDAO).getByClientId("C001");
    }
} 