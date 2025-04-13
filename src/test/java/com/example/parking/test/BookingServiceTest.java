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
        ParkingSpace mockSpace = mock(ParkingSpace.class); // Create a mock for ParkingSpace
        when(mockSpace.getId()).thenReturn(spaceId); // Stub getId method
        when(mockSpace.getRate()).thenReturn(10.0); // Stub getRate method
        when(mockSpace.isBooked()).thenReturn(false); // Stub isBooked method
        
        when(clientDAO.getById(clientId)).thenReturn(mockClient);
        when(parkingSpaceDAO.getById(spaceId)).thenReturn(mockSpace);
        
        // Execute
        Booking booking = bookingService.createBooking(clientId, spaceId, startTime, endTime, paymentMethod);
        
        // Verify
        assertNotNull(booking);
        assertEquals(clientId, booking.getClient().getId());
        assertEquals(spaceId, booking.getParkingSpace().getId());
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
        ParkingSpace mockSpace = mock(ParkingSpace.class); // Create a mock for ParkingSpace
        
        when(clientDAO.getById(clientId)).thenReturn(mockClient);
        when(parkingSpaceDAO.getById(spaceId)).thenReturn(mockSpace);
        when(mockSpace.isBooked()).thenReturn(true); // Stub isBooked to return true
        
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

    @Test
    void testBookingSetters() {
        // Setup initial booking
        Client initialClient = new FacultyMember("FM001", "John Doe", "john@example.com", "password", "CS101", "Computer Science");
        ParkingSpace initialSpace = new ParkingSpace("A1", 10.0);
        LocalDateTime initialStartTime = LocalDateTime.now();
        LocalDateTime initialEndTime = initialStartTime.plusHours(2);
        PaymentMethod paymentMethod = new CreditCard("John Doe", "1234567890123456", "12/25", 1000.0);
        
        Booking booking = new Booking("B001", initialClient, initialSpace, initialStartTime, initialEndTime, paymentMethod);
        
        // Test setBookingId
        booking.setBookingId("B002");
        assertEquals("B002", booking.getBookingId());
        
        // Test setClient
        Client newClient = new FacultyMember("FM002", "Jane Doe", "jane@example.com", "password", "CS102", "Mathematics");
        booking.setClient(newClient);
        assertEquals(newClient, booking.getClient());
        assertEquals("FM002", booking.getClientId());
        
        // Test setSpaceId
        ParkingSpace newSpace = new ParkingSpace("A2", 12.0);
        booking.setSpaceId(newSpace);
        assertEquals(newSpace, booking.getSpaceId());
        assertEquals("A2", booking.getSpaceId().getId());
        
        // Test setStartTime
        LocalDateTime newStartTime = LocalDateTime.now().plusDays(1);
        booking.setStartTime(newStartTime);
        assertEquals(newStartTime, booking.getStartTime());
        
        // Test setEndTime
        LocalDateTime newEndTime = newStartTime.plusHours(3);
        booking.setEndTime(newEndTime);
        assertEquals(newEndTime, booking.getEndTime());
        
        // Verify toString still works with updated values
        String bookingString = booking.toString();
        assertTrue(bookingString.contains("B002"));
        assertTrue(bookingString.contains("FM002"));
        assertTrue(bookingString.contains("A2"));
    }
    @Test
    void testCreateBookingWithInvalidTimeRange() {
        // Setup
        String clientId = "FM001";
        String spaceId = "A1";
        LocalDateTime startTime = LocalDateTime.now().plusHours(3);
        LocalDateTime endTime = LocalDateTime.now().plusHours(1);
        PaymentMethod paymentMethod = new CreditCard("John Doe", "1234567890123456", "12/25", 1000.0);
        
        Client mockClient = new FacultyMember(clientId, "John Doe", "john@example.com", "password", "CS101", "Computer Science");
        ParkingSpace mockSpace = mock(ParkingSpace.class);
        
        when(clientDAO.getById(clientId)).thenReturn(mockClient);
        when(parkingSpaceDAO.getById(spaceId)).thenReturn(mockSpace);
        when(mockSpace.isBooked()).thenReturn(false);
        
        // Execute and Verify
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bookingService.createBooking(clientId, spaceId, startTime, endTime, paymentMethod);
        });
        
        assertTrue(exception.getMessage().contains("End time must be after start time"));
    }

    @Test
    void testCompleteNonExistentBooking() {
        // Setup
        String bookingId = "NONEXISTENT";
        
        when(bookingDAO.getById(bookingId)).thenReturn(null);
        
        // Execute and Verify
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bookingService.completeBooking(bookingId);
        });
        
        assertTrue(exception.getMessage().contains("Booking not found"));
    }

    @Test
    void testCancelAlreadyCancelledBooking() {
        // Setup
        String bookingId = "B001";
        
        Client mockClient = new FacultyMember("FM001", "John Doe", "john@example.com", "password", "CS101", "Computer Science");
        ParkingSpace mockSpace = new ParkingSpace("A1", 10.0);
        Booking mockBooking = new Booking(bookingId, mockClient, mockSpace, LocalDateTime.now(), LocalDateTime.now().plusHours(2), null);
        mockBooking.setStatus("CANCELLED");
        
        when(bookingDAO.getById(bookingId)).thenReturn(mockBooking);
        
        // Execute and Verify
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            bookingService.cancelBooking(bookingId);
        });
        
        assertTrue(exception.getMessage().contains("Booking is already cancelled"));
    }

    @Test
    void testGetNonExistentBooking() {
        // Setup
        String bookingId = "NONEXISTENT";
        
        when(bookingDAO.getById(bookingId)).thenReturn(null);
        
        // Execute and Verify
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bookingService.getBooking(bookingId);
        });
        
        assertTrue(exception.getMessage().contains("Booking not found"));
    }

    @Test
    void testGetBookingsByClientWithNoBookings() {
        // Setup
        String clientId = "FM001";
        
        when(bookingDAO.getByClientId(clientId)).thenReturn(new ArrayList<>()); // No bookings
        
        // Execute
        List<Booking> result = bookingService.getBookingsByClient(clientId);
        
        // Verify
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetBookingsBySpaceWithNoBookings() {
        // Setup
        String spaceId = "A1";
        
        when(bookingDAO.getAll()).thenReturn(new ArrayList<>()); // No bookings
        
        // Execute
        List<Booking> result = bookingService.getBookingsBySpace(spaceId);
        
        // Verify
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
    @Test
    void testGetBookingsBySpaceWithExistingBookings() {
        // Setup
        String spaceId = "A1";
        Client mockClient = new FacultyMember("FM001", "John Doe", "john@example.com", "password", "CS101", "Computer Science");
        Booking mockBooking1 = new Booking("B001", mockClient, new ParkingSpace(spaceId, 10.0), LocalDateTime.now(), LocalDateTime.now().plusHours(2), null);
        Booking mockBooking2 = new Booking("B002", mockClient, new ParkingSpace(spaceId, 10.0), LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(5), null);
        
        List<Booking> mockBookings = new ArrayList<>();
        mockBookings.add(mockBooking1);
        mockBookings.add(mockBooking2);
        
        when(bookingDAO.getAll()).thenReturn(mockBookings);
        
        // Execute
        List<Booking> result = bookingService.getBookingsBySpace(spaceId);
        
        // Verify
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("B001", result.get(0).getBookingId());
        assertEquals("B002", result.get(1).getBookingId());
    }

    @Test
    void testCheckout() {
        // Setup
        String bookingId = "B001";
        Client mockClient = new FacultyMember("FM001", "John Doe", "john@example.com", "password", "CS101", "Computer Science");
        ParkingSpace mockSpace = new ParkingSpace("A1", 10.0);
        Booking mockBooking = new Booking(bookingId, mockClient, mockSpace, LocalDateTime.now(), LocalDateTime.now().plusHours(2), null);
        mockBooking.setTotalCost(100.0); // Set total cost

        when(bookingDAO.getById(bookingId)).thenReturn(mockBooking);

        // Execute
        bookingService.checkoutBooking(bookingId); // Call the service method

        // Verify
        assertEquals("Checked Out", mockBooking.getStatus());
        assertEquals(90.0, mockBooking.getTotalCost()); // Total cost should be reduced by deposit
        verify(bookingDAO).update(mockBooking); // Verify that update was called
    }

    @Test
    void testCreateBookingWithInvalidPaymentMethod() {
        // Setup
        String clientId = "FM001";
        String spaceId = "A1";
        LocalDateTime startTime = LocalDateTime.now().plusHours(1);
        LocalDateTime endTime = LocalDateTime.now().plusHours(3);
        
        Client mockClient = new FacultyMember(clientId, "John Doe", "john@example.com", "password", "CS101", "Computer Science");
        ParkingSpace mockSpace = new ParkingSpace(spaceId, 10.0);
        
        when(clientDAO.getById(clientId)).thenReturn(mockClient);
        when(parkingSpaceDAO.getById(spaceId)).thenReturn(mockSpace);
        
        // Execute and Verify
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bookingService.createBooking(clientId, spaceId, startTime, endTime, null); // Null payment method
        });
        
        assertTrue(exception.getMessage().contains("Invalid payment method"));
    }
}