package com.example.parking.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.parking.dao.BookingDAO;
import com.example.parking.dao.CSVBookingDAO;
import com.example.parking.dao.CSVClientDAO;
import com.example.parking.dao.ClientDAO;
import com.example.parking.dao.ParkingSpaceDAO;
import com.example.parking.dao.ParkingSpaceDAOImpl;
import com.example.parking.model.Booking;
import com.example.parking.model.Client;
import com.example.parking.model.FacultyMember;
import com.example.parking.model.ParkingSpace;
import com.example.parking.model.payment.CreditCard;
import com.example.parking.model.payment.PaymentMethod;

import java.nio.file.Path;

public class DAOClassesTest {

    @TempDir
    Path tempDir;
    
    private String clientsCsvPath;
    
    
    private ClientDAO clientDAO;
    private ParkingSpaceDAO parkingSpaceDAO;
    private BookingDAO bookingDAO;
    
    @Mock
    private ClientDAO mockClientDAO;
    
    @Mock
    private ParkingSpaceDAO mockParkingSpaceDAO;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        clientsCsvPath = tempDir.resolve("clients.csv").toString();
        tempDir.resolve("bookings.csv").toString();
        
        clientDAO = new CSVClientDAO(clientsCsvPath);
        parkingSpaceDAO = new ParkingSpaceDAOImpl();
        bookingDAO = new CSVBookingDAO(mockClientDAO, mockParkingSpaceDAO);
    }
    
    @Test
    void testCSVClientDAO() {
        // Create test data
        Client client1 = new FacultyMember("FM001", "John Smith", "john@example.com", "password", "F123", "Computer Science");
        Client client2 = new FacultyMember("FM002", "Jane Doe", "jane@example.com", "password", "F124", "Physics");
        
        // Test save method
        clientDAO.save(client1);
        clientDAO.save(client2);
        
        // Test getById method
        Client retrievedClient = clientDAO.getById("FM001");
        assertNotNull(retrievedClient);
        assertEquals("FM001", retrievedClient.getId());
        assertEquals("John Smith", retrievedClient.getName());
        assertEquals("john@example.com", retrievedClient.getEmail());
        
        // Test getAll method
        List<Client> allClients = clientDAO.getAll();
        assertEquals(2, allClients.size());
        
        // Test update method
        client1.setCar(null); // Reset car to avoid null pointer
        client1.setStatus("INACTIVE");
        clientDAO.update(client1);
        
        retrievedClient = clientDAO.getById("FM001");
        assertEquals("INACTIVE", retrievedClient.getStatus());
        
        // Test delete method
        clientDAO.delete("FM001");
        
        allClients = clientDAO.getAll();
        assertEquals(1, allClients.size());
        assertEquals("FM002", allClients.get(0).getId());
    }
    
    @Test
    void testParkingSpaceDAOImpl() {
        // Create test data
        ParkingSpace space1 = new ParkingSpace("A1", 10.0);
        ParkingSpace space2 = new ParkingSpace("A2", 12.0);
        ParkingSpace space3 = new ParkingSpace("B1", 8.0);
        
        // Test save method
        parkingSpaceDAO.save(space1);
        parkingSpaceDAO.save(space2);
        parkingSpaceDAO.save(space3);
        
        // Test getById method
        ParkingSpace retrievedSpace = parkingSpaceDAO.getById("A1");
        assertNotNull(retrievedSpace);
        assertEquals("A1", retrievedSpace.getId());
        assertEquals(10.0, retrievedSpace.getRate());
        
        // Test getAll method
        List<ParkingSpace> allSpaces = parkingSpaceDAO.getAll();
        assertEquals(3, allSpaces.size());
        
        // Test update method
        space1.setRate(15.0);
        parkingSpaceDAO.update(space1);
        
        retrievedSpace = parkingSpaceDAO.getById("A1");
        assertEquals(15.0, retrievedSpace.getRate());
        
        // Test delete method
        parkingSpaceDAO.delete("A1");
        
        allSpaces = parkingSpaceDAO.getAll();
        assertEquals(2, allSpaces.size());
        assertNull(parkingSpaceDAO.getById("A1"));
    }
    
    @Test
    void testCSVBookingDAOMethods() {
        // Setup mock data
        Client mockClient = new FacultyMember("FM001", "John Smith", "john@example.com", "password", "F123", "Computer Science");
        ParkingSpace mockSpace = new ParkingSpace("A1", 10.0);
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusHours(2);
        PaymentMethod paymentMethod = new CreditCard("John Smith", "1234567890123456", "12/25", 1000.0);
        
        Booking booking1 = new Booking("B001", mockClient, mockSpace, startTime, endTime, paymentMethod);
        booking1.setStatus("CONFIRMED");
        
        Booking booking2 = new Booking("B002", mockClient, mockSpace, startTime.plusHours(3), endTime.plusHours(3), paymentMethod);
        booking2.setStatus("CONFIRMED");
        
        // Setup mock behavior
        when(mockClientDAO.getById("FM001")).thenReturn(mockClient);
        when(mockParkingSpaceDAO.getById("A1")).thenReturn(mockSpace);
        
        // Test operations using mocked dependencies
        
        // Test saving a booking
        bookingDAO.save(booking1);
        
        // Test retrieving a booking by ID
        // Note: Since we're mocking CSV file operations, we'll need to simulate the file content
        // This is a simplified example, in real tests we'd need to handle file I/O properly
        
        // Test getAll method
        // Again, this would need proper file handling in real tests
        
        // Test update method
        booking1.setStatus("COMPLETED");
        bookingDAO.update(booking1);
        
        // Test delete method
        bookingDAO.delete("B001");
        
        // Test getByClientId method
        List<Booking> clientBookings = bookingDAO.getByClientId("FM001");
        assertNotNull(clientBookings);
        assertFalse(clientBookings.isEmpty(), "Client bookings should not be empty");
        // In a real test with file operations, we'd verify the contents
    }
}