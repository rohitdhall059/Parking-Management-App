package com.example.parking.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.parking.dao.BookingDAO;
import com.example.parking.dao.ClientDAO;
import com.example.parking.dao.ParkingSpaceDAO;
import com.example.parking.model.Booking;
import com.example.parking.model.Client;
import com.example.parking.model.FacultyMember;
import com.example.parking.model.ParkingSpace;
import com.example.parking.model.payment.CreditCard;
import com.example.parking.model.payment.PaymentMethod;
import com.example.parking.service.BookingService;

public class BookingServiceTest {

    private BookingService bookingService;
    
    @Mock
    private BookingDAO bookingDAO;
    
    @Mock
    private ClientDAO clientDAO;
    
    @Mock
    private ParkingSpaceDAO parkingSpaceDAO;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bookingService = new BookingService(bookingDAO, clientDAO, parkingSpaceDAO);
    }
    
    @Test
    void testCreateBookingSuccess() {
        // Setup
        String clientId = "FM001";
        String spaceId = "A1";
        LocalDateTime startTime = LocalDateTime.now().plusHours(1);
        LocalDateTime endTime = LocalDateTime.now().plusHours(3);
        PaymentMethod paymentMethod = new CreditCard("John Doe", "1234567890123456", "12/25", 1000.0);
        
        Client mockClient = new FacultyMember(clientId, "John Doe", "john@example.com", "password", "CS101", "Computer Science");
        ParkingSpace mockSpace = new ParkingSpace(spaceId, 10.0);
        
        when(clientDAO.getById(clientId)).thenReturn(mockClient);
        when(parkingSpaceDAO.getById(spaceId)).thenReturn(mockSpace);
        when(mockSpace.isOccupied()).thenReturn(false);
        
        // Execute
        Booking booking = bookingService.createBooking(clientId, spaceId, startTime, endTime, paymentMethod);
        
        // Verify
        assertNotNull(booking);
        assertEquals(clientId, booking.getClientId());
        assertEquals(spaceId, booking.getSpaceId());
        assertEquals(startTime, booking.getStartTime());
        assertEquals(endTime, booking.getEndTime());
        assertEquals("CONFIRMED", booking.getStatus());
        verify(bookingDAO).save(booking);
        verify(parkingSpaceDAO).update(mockSpace);
    }
    
    @Test
    void testCreateBookingWithNonExistentClient() {
        // Setup
        String clientId = "NONEXISTENT";
        String spaceId = "A1";
        LocalDateTime startTime = LocalDateTime.now().plusHours(1);
        LocalDateTime endTime = LocalDateTime.now().plusHours(3);
        PaymentMethod paymentMethod = new CreditCard("John Doe", "1234567890123456", "12/25", 1000.0);
        
        when(clientDAO.getById(clientId)).thenReturn(null);
        
        // Execute and Verify
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bookingService.createBooking(clientId, spaceId, startTime, endTime, paymentMethod);
        });
        
        assertTrue(exception.getMessage().contains("Client not found"));
    }
    
    @Test
    void testCreateBookingWithNonExistentParkingSpace() {
        // Setup
        String clientId = "FM001";
        String spaceId = "NONEXISTENT";
        LocalDateTime startTime = LocalDateTime.now().plusHours(1);
        LocalDateTime endTime = LocalDateTime.now().plusHours(3);
        PaymentMethod paymentMethod = new CreditCard("John Doe", "1234567890123456", "12/25", 1000.0);
        
        Client mockClient = new FacultyMember(clientId, "John Doe", "john@example.com", "password", "CS101", "Computer Science");
        
        when(clientDAO.getById(clientId)).thenReturn(mockClient);
        when(parkingSpaceDAO.getById(spaceId)).thenReturn(null);
        
        // Execute and Verify
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bookingService.createBooking(clientId, spaceId, startTime, endTime, paymentMethod);
        });
        
        assertTrue(exception.getMessage().contains("Parking space not found"));
    }
    
    @Test
    void testCreateBookingWithOccupiedSpace() {
        // Setup
        String clientId = "FM001";
        String spaceId = "A1";
        LocalDateTime startTime = LocalDateTime.now().plusHours(1);
        LocalDateTime endTime = LocalDateTime.now().plusHours(3);
        PaymentMethod paymentMethod = new CreditCard("John Doe", "1234567890123456", "12/25", 1000.0);
        
        Client mockClient = new FacultyMember(clientId, "John Doe", "john@example.com", "password", "CS101", "Computer Science");
        ParkingSpace mockSpace = new ParkingSpace(spaceId, 10.0);
        
        when(clientDAO.getById(clientId)).thenReturn(mockClient);
        when(parkingSpaceDAO.getById(spaceId)).thenReturn(mockSpace);
        when(mockSpace.isOccupied()).thenReturn(true);
        
        // Execute and Verify
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            bookingService.createBooking(clientId, spaceId, startTime, endTime, paymentMethod);
        });
        
        assertTrue(exception.getMessage().contains("Parking space is already occupied"));
    }
    
    @Test
    void testCancelBooking() {
        // Setup
        String bookingId = "B001";
        
        Client mockClient = new FacultyMember("FM001", "John Doe", "john@example.com", "password", "CS101", "Computer Science");
        ParkingSpace mockSpace = new ParkingSpace("A1", 10.0);
        Booking mockBooking = new Booking(bookingId, mockClient, mockSpace, LocalDateTime.now(), LocalDateTime.now().plusHours(2), null);
        mockBooking.setStatus("CONFIRMED");
        
        when(bookingDAO.getById(bookingId)).thenReturn(mockBooking);
        
        // Execute
        bookingService.cancelBooking(bookingId);
        
        // Verify
        assertEquals("CANCELLED", mockBooking.getStatus());
        verify(bookingDAO).update(mockBooking);
        verify(parkingSpaceDAO).update(mockSpace);
    }
    
    @Test
    void testCancelNonExistentBooking() {
        // Setup
        String bookingId = "NONEXISTENT";
        
        when(bookingDAO.getById(bookingId)).thenReturn(null);
        
        // Execute and Verify
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bookingService.cancelBooking(bookingId);
        });
        
        assertTrue(exception.getMessage().contains("Booking not found"));
    }
    
    @Test
    void testGetAllBookings() {
        // Setup
        List<Booking> mockBookings = new ArrayList<>();
        Client mockClient = new FacultyMember("FM001", "John Doe", "john@example.com", "password", "CS101", "Computer Science");
        ParkingSpace mockSpace = new ParkingSpace("A1", 10.0);
        
        mockBookings.add(new Booking("B001", mockClient, mockSpace, LocalDateTime.now(), LocalDateTime.now().plusHours(2), null));
        mockBookings.add(new Booking("B002", mockClient, mockSpace, LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(5), null));
        
        when(bookingDAO.getAll()).thenReturn(mockBookings);
        
        // Execute
        List<Booking> result = bookingService.getAllBookings();
        
        // Verify
        assertEquals(2, result.size());
        assertEquals("B001", result.get(0).getBookingId());
        assertEquals("B002", result.get(1).getBookingId());
    }
    
    @Test
    void testGetBooking() {
        // Setup
        String bookingId = "B001";
        Client mockClient = new FacultyMember("FM001", "John Doe", "john@example.com", "password", "CS101", "Computer Science");
        ParkingSpace mockSpace = new ParkingSpace("A1", 10.0);
        Booking mockBooking = new Booking(bookingId, mockClient, mockSpace, LocalDateTime.now(), LocalDateTime.now().plusHours(2), null);
        
        when(bookingDAO.getById(bookingId)).thenReturn(mockBooking);
        
        // Execute
        Booking result = bookingService.getBooking(bookingId);
        
        // Verify
        assertNotNull(result);
        assertEquals(bookingId, result.getBookingId());
    }
    
    @Test
    void testCompleteBooking() {
        // Setup
        String bookingId = "B001";
        
        Client mockClient = new FacultyMember("FM001", "John Doe", "john@example.com", "password", "CS101", "Computer Science");
        ParkingSpace mockSpace = new ParkingSpace("A1", 10.0);
        Booking mockBooking = new Booking(bookingId, mockClient, mockSpace, LocalDateTime.now(), LocalDateTime.now().plusHours(2), null);
        mockBooking.setStatus("CONFIRMED");
        
        when(bookingDAO.getById(bookingId)).thenReturn(mockBooking);
        
        // Execute
        bookingService.completeBooking(bookingId);
        
        // Verify
        assertEquals("COMPLETED", mockBooking.getStatus());
        verify(bookingDAO).update(mockBooking);
        verify(parkingSpaceDAO).update(mockSpace);
    }
    
    @Test
    void testGetBookingsByClient() {
        // Setup
        String clientId = "FM001";
        List<Booking> mockBookings = new ArrayList<>();
        Client mockClient = new FacultyMember(clientId, "John Doe", "john@example.com", "password", "CS101", "Computer Science");
        ParkingSpace mockSpace = new ParkingSpace("A1", 10.0);
        
        mockBookings.add(new Booking("B001", mockClient, mockSpace, LocalDateTime.now(), LocalDateTime.now().plusHours(2), null));
        mockBookings.add(new Booking("B002", mockClient, mockSpace, LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(5), null));
        
        when(bookingDAO.getByClientId(clientId)).thenReturn(mockBookings);
        
        // Execute
        List<Booking> result = bookingService.getBookingsByClient(clientId);
        
        // Verify
        assertEquals(2, result.size());
        assertEquals("B001", result.get(0).getBookingId());
        assertEquals("B002", result.get(1).getBookingId());
    }
}