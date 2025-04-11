package com.example.parking.test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.example.parking.factory.PaymentMethodFactory;
import com.example.parking.iterator.ParkingSpaceIterator;
import com.example.parking.model.Booking;
import com.example.parking.model.Car;
import com.example.parking.model.Client;
import com.example.parking.model.FacultyMember;
import com.example.parking.model.Manager;
import com.example.parking.model.ParkingLot;
import com.example.parking.model.ParkingSpace;
import com.example.parking.model.payment.PaymentMethod;
import com.example.parking.service.ClientService;
import com.example.parking.dao.ClientDAO;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;

public class ClientServiceTest {
    // Dummy PaymentMethod implementation for testing.
    private static class DummyPaymentMethod extends PaymentMethod {
        boolean paymentProcessed = false;
        boolean refundProcessed = false;

        public DummyPaymentMethod() {
            // Use the constructor with one double parameter.
            super(0);
        }

        @Override
        public boolean processPayment(double amount) {
            paymentProcessed = true;
            return true;
        }

        @Override
        public void processRefund(double amount) {
            refundProcessed = true;
        }
    }

    // Dummy ParkingLot for Manager tests.
    private static class TestParkingLot extends ParkingLot {
        public TestParkingLot(String id, String name, String location) {
            super(id, name, location);
        }
    }

    // Dummy ParkingSpaceIterator for Manager tests.
    private static class TestParkingSpaceIterator extends ParkingSpaceIterator {
        public TestParkingSpaceIterator(List<ParkingSpace> spaces, boolean isEnabledOnly) {
            super(spaces, isEnabledOnly);
        }
    }

    private ClientService clientService;
    
    @Mock
    private ClientDAO clientDAO;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        clientService = new ClientService(clientDAO);
    }

    // -------------------- Booking Tests --------------------

    @Test
    public void testBookingConstructorAndGetters() {
        Client client = new FacultyMember("F001", "Dr. Smith", "smith@example.com", "password", "FAC001", "Math");
        ParkingSpace space = new ParkingSpace("PS100", 10.0);
        PaymentMethod pm = PaymentMethodFactory.getDefaultPaymentMethod();
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusHours(2);
        Booking booking = new Booking("B001", client, space, start, end, pm);
        
        assertEquals("B001", booking.getBookingId());
        assertEquals(client, booking.getClient());
        assertEquals(space, booking.getSpaceId());
        assertEquals(start, booking.getStartTime());
        assertEquals(end, booking.getEndTime());
        assertEquals("Active", booking.getStatus());
        String str = booking.toString();
        assertTrue(str.contains(client.getId()));
        assertTrue(str.contains(space.getId()));
    }

    @Test
    public void testCreateBookingValid() {
        Client client = new FacultyMember("F002", "Dr. Jones", "jones@example.com", "password", "FAC002", "Physics");
        ParkingSpace space = new ParkingSpace("PS101", 12.0);
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusHours(3);
        Booking booking = Booking.createBooking("B002", client, space, start, end, "faculty");
        // For faculty, PricingStrategyFactory should return a FacultyPricing strategy with rate 8.0.
        long hours = ChronoUnit.HOURS.between(start, end);
        double expectedCost = hours * 8.0;
        assertEquals(expectedCost, booking.getTotalCost(), 0.01);
    }

    @Test
    public void testCreateBookingInvalidTime() {
        Client client = new FacultyMember("F003", "Dr. Brown", "brown@example.com", "password", "FAC003", "Chemistry");
        ParkingSpace space = new ParkingSpace("PS102", 15.0);
        LocalDateTime start = LocalDateTime.now().plusHours(2);
        LocalDateTime end = LocalDateTime.now();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> 
            Booking.createBooking("B003", client, space, start, end, "faculty")
        );
        assertTrue(ex.getMessage().contains("Start time must be before end time"));
    }

    @Test
    public void testCheckout() {
        Client client = new FacultyMember("F004", "Dr. White", "white@example.com", "password", "FAC004", "Biology");
        ParkingSpace space = new ParkingSpace("PS103", 20.0);
        PaymentMethod pm = new DummyPaymentMethod();
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusHours(4);
        Booking booking = new Booking("B004", client, space, start, end, pm);
        booking.setTotalCost(80.0);
        booking.checkout();
        // Deposit of 10.0 should be deducted.
        assertEquals(70.0, booking.getTotalCost(), 0.01);
        assertEquals("Checked Out", booking.getStatus());
    }

    @Test
    public void testCalculateRefund() {
        Client client = new FacultyMember("F005", "Dr. Green", "green@example.com", "password", "FAC005", "History");
        ParkingSpace space = new ParkingSpace("PS104", 18.0);
        PaymentMethod pm = new DummyPaymentMethod();
        // Set start time 2 hours ago and end time 2 hours in the future.
        LocalDateTime start = LocalDateTime.now().minusHours(2);
        LocalDateTime end = LocalDateTime.now().plusHours(2);
        Booking booking = new Booking("B005", client, space, start, end, pm);
        booking.setTotalCost(72.0);
        double refund = booking.calculateRefund();
        assertTrue(refund > 0);
        long totalMinutes = ChronoUnit.MINUTES.between(start, end);
        long minutesLeft = ChronoUnit.MINUTES.between(LocalDateTime.now(), end);
        double expectedRefund = (72.0 / totalMinutes) * minutesLeft;
        assertEquals(expectedRefund, refund, 0.5);
    }

    @Test
    public void testExtendParkingTime() {
        Client client = new FacultyMember("F006", "Dr. Black", "black@example.com", "password", "FAC006", "Geology");
        ParkingSpace space = new ParkingSpace("PS105", 10.0);
        PaymentMethod pm = new DummyPaymentMethod();
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusHours(2);
        Booking booking = new Booking("B006", client, space, start, end, pm);
        booking.setTotalCost(20.0);
        LocalDateTime newEnd = end.plusHours(1);
        booking.extendParkingTime(newEnd, "faculty");
        assertEquals(newEnd, booking.getEndTime());
        // Additional cost: 1 hour * faculty rate (8.0) = 8.0, total becomes 28.0.
        assertEquals(28.0, booking.getTotalCost(), 0.01);
    }

    @Test
    public void testCancelBooking() {
        Client client = new FacultyMember("F007", "Dr. Violet", "violet@example.com", "password", "FAC007", "Art");
        ParkingSpace space = new ParkingSpace("PS106", 12.0);
        PaymentMethod pm = new DummyPaymentMethod();
        // Set start time 70 minutes ago to take the refund branch.
        LocalDateTime start = LocalDateTime.now().minusMinutes(70);
        LocalDateTime end = LocalDateTime.now().plusHours(1);
        Booking booking = new Booking("B007", client, space, start, end, pm);
        booking.cancelBooking();
        assertEquals("Canceled", booking.getStatus());
    }

    @Test
    public void testProcessPaymentAndRefund() {
        Client client = new FacultyMember("F008", "Dr. Indigo", "indigo@example.com", "password", "FAC008", "Music");
        ParkingSpace space = new ParkingSpace("PS107", 14.0);
        DummyPaymentMethod dpm = new DummyPaymentMethod();
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusHours(3);
        Booking booking = new Booking("B008", client, space, start, end, dpm);
        booking.processPayment(42.0);
        assertTrue(dpm.paymentProcessed);
        booking.processRefund(42.0);
        assertTrue(dpm.refundProcessed);
    }

    @Test
    public void testSetAmountAndGetAmount() {
        Client client = new FacultyMember("F009", "Dr. Magenta", "magenta@example.com", "password", "FAC009", "Literature");
        ParkingSpace space = new ParkingSpace("PS108", 16.0);
        PaymentMethod pm = PaymentMethodFactory.getDefaultPaymentMethod();
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusHours(2);
        Booking booking = new Booking("B009", client, space, start, end, pm);
        booking.setAmount(50.0);
        assertEquals(50.0, booking.getAmount(), 0.01);
    }

    @Test
    public void testSetOccupiedInBooking() {
        Client client = new FacultyMember("F010", "Dr. Orange", "orange@example.com", "password", "FAC010", "Philosophy");
        ParkingSpace space = new ParkingSpace("PS109", 16.0);
        PaymentMethod pm = PaymentMethodFactory.getDefaultPaymentMethod();
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusHours(2);
        Booking booking = new Booking("B010", client, space, start, end, pm);
        Car car = new Car("XYZ123", "Honda", "Civic", "Blue");
        booking.setOccupied(true, car);
        assertTrue(space.isBooked());
        assertEquals("XYZ123", space.getLicensePlate());
    }

    // ------------------ Manager Tests ------------------

    @Test
    public void testManagerGetters() {
        Manager manager = new Manager("M001", "Supervisor", "Alice Manager");
        assertEquals("M001", manager.getId());
        assertEquals("Supervisor", manager.getRole());
        assertEquals("Alice Manager", manager.getName());
    }

    @Test
    public void testManageParkingLot() {
        Manager manager = new Manager("M002", "Supervisor", "Bob Manager");
        TestParkingLot lot = new TestParkingLot("PL001", "Central Parking", "Downtown");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        manager.manageParkingLot(lot);

        System.setOut(originalOut);
        String output = baos.toString();
        assertTrue(output.contains("Managing parking lot: Central Parking"));
    }

    @Test
    public void testManageParkingSpace() {
        Manager manager = new Manager("M003", "Supervisor", "Carol Manager");
        ParkingSpace space = new ParkingSpace("PS201", 12.5);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        manager.manageParkingSpace(space);

        System.setOut(originalOut);
        String output = baos.toString();
        assertTrue(output.contains("Managing parking space with ID: PS201"));
    }

    @Test
    public void testViewParkingSpaces() {
        Manager manager = new Manager("M004", "Supervisor", "Dave Manager");
        ParkingSpace ps1 = new ParkingSpace("PS301", 10.0);
        ParkingSpace ps2 = new ParkingSpace("PS302", 15.0);
        List<ParkingSpace> spaces = Arrays.asList(ps1, ps2);
        TestParkingSpaceIterator iterator = new TestParkingSpaceIterator(spaces, true);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        manager.viewParkingSpaces(iterator);

        System.setOut(originalOut);
        String output = baos.toString();
        assertTrue(output.contains("PS301"));
        assertTrue(output.contains("PS302"));
    }

    @Test
    void testRegisterClientSuccess() {
        // Setup
        String type = "FM";
        String name = "John Smith";
        String email = "john@example.com";
        
        when(clientDAO.getAll()).thenReturn(new ArrayList<>());
        
        // Execute
        Client result = clientService.registerClient(type, name, email);
        
        // Verify
        assertNotNull(result);
        assertEquals(name, result.getName());
        assertEquals(email, result.getEmail());
        verify(clientDAO).save(result);
    }
    
    @Test
    void testRegisterClientWithExistingEmail() {
        // Setup
        String type = "FM";
        String name = "John Smith";
        String email = "existing@example.com";
        
        Client existingClient = new FacultyMember("FM001", "Existing User", email, "password", "F123", "Computer Science");
        when(clientDAO.getAll()).thenReturn(Arrays.asList(existingClient));
        
        // Execute & Verify
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            clientService.registerClient(type, name, email);
        });
        
        assertTrue(exception.getMessage().contains("Client with this email already exists"));
        verify(clientDAO, never()).save(any());
    }
    
    @Test
    void testGetClientSuccess() {
        // Setup
        String clientId = "FM001";
        Client mockClient = new FacultyMember(clientId, "John Smith", "john@example.com", "password", "F123", "Computer Science");
        when(clientDAO.getById(clientId)).thenReturn(mockClient);
        
        // Execute
        Client result = clientService.getClient(clientId);
        
        // Verify
        assertNotNull(result);
        assertEquals(clientId, result.getId());
        assertEquals("John Smith", result.getName());
    }
    
    @Test
    void testGetClientNotFound() {
        // Setup
        String clientId = "NONEXISTENT";
        when(clientDAO.getById(clientId)).thenReturn(null);
        
        // Execute
        Client result = clientService.getClient(clientId);
        
        // Verify
        assertNull(result);
    }
    
    @Test
    void testGetAllClients() {
        // Setup
        List<Client> mockClients = Arrays.asList(
            new FacultyMember("FM001", "John Smith", "john@example.com", "password", "F123", "Computer Science"),
            new FacultyMember("FM002", "Jane Doe", "jane@example.com", "password", "F124", "Physics")
        );
        when(clientDAO.getAll()).thenReturn(mockClients);
        
        // Execute
        List<Client> result = clientService.getAllClients();
        
        // Verify
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("FM001", result.get(0).getId());
        assertEquals("FM002", result.get(1).getId());
    }
    
    @Test
    void testUpdateClientStatusSuccess() {
        // Setup
        String clientId = "FM001";
        Client mockClient = new FacultyMember(clientId, "John Smith", "john@example.com", "password", "F123", "Computer Science");
        when(clientDAO.getById(clientId)).thenReturn(mockClient);
        
        // Execute
        clientService.updateClientStatus(clientId, "INACTIVE");
        
        // Verify
        assertEquals("INACTIVE", mockClient.getStatus());
        verify(clientDAO).update(mockClient);
    }
    
    @Test
    void testUpdateClientStatusNotFound() {
        // Setup
        String clientId = "NONEXISTENT";
        when(clientDAO.getById(clientId)).thenReturn(null);
        
        // Execute & Verify
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            clientService.updateClientStatus(clientId, "INACTIVE");
        });
        
        assertTrue(exception.getMessage().contains("Client not found"));
        verify(clientDAO, never()).update(any());
    }
    
    @Test
    void testActivateClient() {
        // Setup
        String clientId = "FM001";
        Client mockClient = new FacultyMember(clientId, "John Smith", "john@example.com", "password", "F123", "Computer Science");
        when(clientDAO.getById(clientId)).thenReturn(mockClient);
        
        // Execute
        clientService.activateClient(clientId);
        
        // Verify
        assertEquals("ACTIVE", mockClient.getStatus());
        verify(clientDAO).update(mockClient);
    }
    
    @Test
    void testDeactivateClient() {
        // Setup
        String clientId = "FM001";
        Client mockClient = new FacultyMember(clientId, "John Smith", "john@example.com", "password", "F123", "Computer Science");
        when(clientDAO.getById(clientId)).thenReturn(mockClient);
        
        // Execute
        clientService.deactivateClient(clientId);
        
        // Verify
        assertEquals("INACTIVE", mockClient.getStatus());
        verify(clientDAO).update(mockClient);
    }
    
    @Test
    void testSuspendClient() {
        // Setup
        String clientId = "FM001";
        Client mockClient = new FacultyMember(clientId, "John Smith", "john@example.com", "password", "F123", "Computer Science");
        when(clientDAO.getById(clientId)).thenReturn(mockClient);
        
        // Execute
        clientService.suspendClient(clientId);
        
        // Verify
        assertEquals("SUSPENDED", mockClient.getStatus());
        verify(clientDAO).update(mockClient);
    }
    
    @Test
    void testDeleteClient() {
        // Setup
        String clientId = "FM001";
        
        // Execute
        clientService.deleteClient(clientId);
        
        // Verify
        verify(clientDAO).delete(clientId);
    }
    
    @Test
    void testLoginSuccess() {
        // Setup
        String email = "john@example.com";
        String password = "password";
        Client mockClient = new FacultyMember("FM001", "John Smith", email, password, "F123", "Computer Science");
        when(clientDAO.getAll()).thenReturn(Arrays.asList(mockClient));
        
        // Execute
        Client result = clientService.login(email, password);
        
        // Verify
        assertNotNull(result);
        assertEquals(email, result.getEmail());
        assertEquals("John Smith", result.getName());
    }
    
    @Test
    void testLoginFailure() {
        // Setup
        String email = "john@example.com";
        String password = "wrongpassword";
        Client mockClient = new FacultyMember("FM001", "John Smith", email, "password", "F123", "Computer Science");
        when(clientDAO.getAll()).thenReturn(Arrays.asList(mockClient));
        
        // Execute
        Client result = clientService.login(email, password);
        
        // Verify
        assertNull(result);
    }
}