package com.example.parking.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.example.parking.dao.CSVBookingDAO;
import com.example.parking.dao.CSVClientDAO;
import com.example.parking.dao.ClientDAO;
import com.example.parking.dao.ParkingSpaceDAO;
import com.example.parking.factory.PaymentMethodFactory;
import com.example.parking.model.Booking;
import com.example.parking.model.Car;
import com.example.parking.model.Client;
import com.example.parking.model.ParkingSpace;
import com.example.parking.model.Student;
import com.example.parking.model.Visitor;
import com.example.parking.model.payment.PaymentMethod;

public class CSVDAOTest {
    @TempDir
    Path tempDir;

    private CSVBookingDAO bookingDAO;
    private CSVClientDAO clientDAO;
    private File bookingsFile;
    private File clientsFile;

    @Mock
    private ClientDAO mockClientDAO;

    @Mock
    private ParkingSpaceDAO mockParkingSpaceDAO;

    @Mock
    private ParkingSpace mockParkingSpace;

    private Student testStudent;
    private Visitor testVisitor;

    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        
        // Setup for BookingDAO tests
        bookingsFile = tempDir.resolve("bookings.csv").toFile();
        bookingDAO = new CSVBookingDAO(mockClientDAO, mockParkingSpaceDAO);

        // Setup for ClientDAO tests
        clientsFile = tempDir.resolve("clients.csv").toFile();
        clientDAO = new CSVClientDAO(clientsFile.getAbsolutePath());

        // Create concrete client implementations instead of mocks
        testStudent = new Student("C123", "John Doe", "john@university.edu", "password123", 
                                "STU001", "Computer Science", "3rd");
        testVisitor = new Visitor("C124", "Jane Smith", "jane@email.com", "pass123",
                                "Conference Attendee", "VIS001");

        // Setup mock behavior for BookingDAO tests
        when(mockParkingSpace.getId()).thenReturn("P123");
        when(mockParkingSpace.getRate()).thenReturn(10.0);
        when(mockClientDAO.getById("C123")).thenReturn(testStudent);
        when(mockClientDAO.getById("C124")).thenReturn(testVisitor);
        when(mockParkingSpaceDAO.getById(anyString())).thenReturn(mockParkingSpace);
    }

    // ===== CSVBookingDAO Tests =====

    @Test
    void testSaveBooking() {
        // Create a test booking
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusHours(2);
        PaymentMethod paymentMethod = PaymentMethodFactory.createPaymentMethod("CREDIT", "1234567890", "123");
        
        Booking booking = new Booking("B123", testStudent, mockParkingSpace, startTime, endTime, paymentMethod);
        booking.setStatus("ACTIVE");

        // Save the booking
        assertDoesNotThrow(() -> bookingDAO.save(booking));

        // Verify the booking was saved by retrieving it
        Booking retrieved = bookingDAO.getById("B123");
        assertNotNull(retrieved);
        assertEquals("B123", retrieved.getBookingId());
        assertEquals(testStudent.getId(), retrieved.getClient().getId());
        assertEquals(mockParkingSpace.getId(), retrieved.getParkingSpace().getId());
    }

    @Test
    void testGetBookingById() {
        // First save a booking
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusHours(2);
        PaymentMethod paymentMethod = PaymentMethodFactory.createPaymentMethod("CREDIT", "1234567890", "123");
        
        Booking booking = new Booking("B123", testStudent, mockParkingSpace, startTime, endTime, paymentMethod);
        booking.setStatus("ACTIVE");
        bookingDAO.save(booking);

        // Test retrieving the booking
        Booking retrieved = bookingDAO.getById("B123");
        assertNotNull(retrieved);
        assertEquals("B123", retrieved.getBookingId());
    }

    @Test
    void testGetBookingByIdNotFound() {
        Booking retrieved = bookingDAO.getById("NONEXISTENT");
        assertNull(retrieved);
    }

    @Test
    void testGetAllBookings() {
        // Save multiple bookings
        LocalDateTime startTime = LocalDateTime.now();
        PaymentMethod paymentMethod = PaymentMethodFactory.createPaymentMethod("CREDIT", "1234567890", "123");
        
        Booking booking1 = new Booking("B123", testStudent, mockParkingSpace, startTime, startTime.plusHours(2), paymentMethod);
        Booking booking2 = new Booking("B124", testVisitor, mockParkingSpace, startTime, startTime.plusHours(3), paymentMethod);
        
        bookingDAO.save(booking1);
        bookingDAO.save(booking2);

        List<Booking> allBookings = bookingDAO.getAll();
        assertNotNull(allBookings);
        assertTrue(allBookings.size() >= 2);
    }

    @Test
    void testUpdateBooking() {
        // First save a booking
        LocalDateTime startTime = LocalDateTime.now();
        PaymentMethod paymentMethod = PaymentMethodFactory.createPaymentMethod("CREDIT", "1234567890", "123");
        
        Booking booking = new Booking("B123", testStudent, mockParkingSpace, startTime, startTime.plusHours(2), paymentMethod);
        booking.setStatus("ACTIVE");
        bookingDAO.save(booking);

        // Update the booking
        booking.setStatus("COMPLETED");
        assertDoesNotThrow(() -> bookingDAO.update(booking));

        // Verify the update
        Booking updated = bookingDAO.getById("B123");
        assertNotNull(updated);
        assertEquals("COMPLETED", updated.getStatus());
    }

    @Test
    void testDeleteBooking() {
        // First save a booking
        LocalDateTime startTime = LocalDateTime.now();
        PaymentMethod paymentMethod = PaymentMethodFactory.createPaymentMethod("CREDIT", "1234567890", "123");
        
        Booking booking = new Booking("B123", testStudent, mockParkingSpace, startTime, startTime.plusHours(2), paymentMethod);
        bookingDAO.save(booking);

        // Delete the booking
        assertDoesNotThrow(() -> bookingDAO.delete("B123"));

        // Verify the deletion
        Booking deleted = bookingDAO.getById("B123");
        assertNull(deleted);
    }

    @Test
    void testGetBookingsByClientId() {
        // Save multiple bookings for the same client
        LocalDateTime startTime = LocalDateTime.now();
        PaymentMethod paymentMethod = PaymentMethodFactory.createPaymentMethod("CREDIT", "1234567890", "123");
        
        Booking booking1 = new Booking("B123", testStudent, mockParkingSpace, startTime, startTime.plusHours(2), paymentMethod);
        Booking booking2 = new Booking("B124", testStudent, mockParkingSpace, startTime, startTime.plusHours(3), paymentMethod);
        
        bookingDAO.save(booking1);
        bookingDAO.save(booking2);

        List<Booking> clientBookings = bookingDAO.getByClientId("C123");
        assertNotNull(clientBookings);
        assertTrue(clientBookings.size() >= 2);
        assertTrue(clientBookings.stream().allMatch(b -> b.getClient().getId().equals("C123")));
    }

    @Test
    void testBookingAmountCalculation() {
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusHours(2);
        PaymentMethod paymentMethod = PaymentMethodFactory.createPaymentMethod("CREDIT", "1234567890", "123");
        
        Booking booking = new Booking("B123", testStudent, mockParkingSpace, startTime, endTime, paymentMethod);
        bookingDAO.save(booking);

        Booking retrieved = bookingDAO.getById("B123");
        assertNotNull(retrieved);
        // Expected amount: 2 hours * $10.0 * (1 - 0.15 discount) = $17.0
        assertEquals(17.0, retrieved.getAmount(), 0.01);
    }

    @Test
    void testBookingWithDifferentClientTypes() {
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusHours(2);
        PaymentMethod paymentMethod = PaymentMethodFactory.createPaymentMethod("CREDIT", "1234567890", "123");
        
        // Test with Student (15% discount)
        Booking studentBooking = new Booking("B123", testStudent, mockParkingSpace, startTime, endTime, paymentMethod);
        bookingDAO.save(studentBooking);
        Booking retrievedStudent = bookingDAO.getById("B123");
        assertEquals(17.0, retrievedStudent.getAmount(), 0.01); // 2 hours * $10 * (1 - 0.15)
        
        // Test with Visitor (no discount)
        Booking visitorBooking = new Booking("B124", testVisitor, mockParkingSpace, startTime, endTime, paymentMethod);
        bookingDAO.save(visitorBooking);
        Booking retrievedVisitor = bookingDAO.getById("B124");
        assertEquals(20.0, retrievedVisitor.getAmount(), 0.01); // 2 hours * $10 * (1 - 0.0)
    }

    @Test
    void testBookingWithDifferentDurations() {
        LocalDateTime startTime = LocalDateTime.now();
        PaymentMethod paymentMethod = PaymentMethodFactory.createPaymentMethod("CREDIT", "1234567890", "123");
        
        // Test with 1 hour
        LocalDateTime endTime1 = startTime.plusHours(1);
        Booking booking1 = new Booking("B123", testStudent, mockParkingSpace, startTime, endTime1, paymentMethod);
        bookingDAO.save(booking1);
        Booking retrieved1 = bookingDAO.getById("B123");
        assertEquals(8.5, retrieved1.getAmount(), 0.01); // 1 hour * $10 * (1 - 0.15)
        
        // Test with 3 hours
        LocalDateTime endTime2 = startTime.plusHours(3);
        Booking booking2 = new Booking("B124", testStudent, mockParkingSpace, startTime, endTime2, paymentMethod);
        bookingDAO.save(booking2);
        Booking retrieved2 = bookingDAO.getById("B124");
        assertEquals(25.5, retrieved2.getAmount(), 0.01); // 3 hours * $10 * (1 - 0.15)
    }

    @Test
    void testBookingWithDifferentPaymentMethods() {
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusHours(2);
        
        // Test with CREDIT payment
        PaymentMethod creditPayment = PaymentMethodFactory.createPaymentMethod("CREDIT", "1234567890", "123");
        Booking creditBooking = new Booking("B123", testStudent, mockParkingSpace, startTime, endTime, creditPayment);
        bookingDAO.save(creditBooking);
        Booking retrievedCredit = bookingDAO.getById("B123");
        assertEquals("CREDIT", retrievedCredit.getPaymentMethod().getType());
        
        // Test with DEBIT payment
        PaymentMethod debitPayment = PaymentMethodFactory.createPaymentMethod("DEBIT", "9876543210", "456");
        Booking debitBooking = new Booking("B124", testStudent, mockParkingSpace, startTime, endTime, debitPayment);
        bookingDAO.save(debitBooking);
        Booking retrievedDebit = bookingDAO.getById("B124");
        assertEquals("DEBIT", retrievedDebit.getPaymentMethod().getType());
    }

    @Test
    void testBookingWithNullClient() {
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusHours(2);
        PaymentMethod paymentMethod = PaymentMethodFactory.createPaymentMethod("CREDIT", "1234567890", "123");
        
        // This should throw an exception when trying to save
        Booking booking = new Booking("B123", null, mockParkingSpace, startTime, endTime, paymentMethod);
        assertThrows(RuntimeException.class, () -> bookingDAO.save(booking));
    }

    @Test
    void testBookingWithNullParkingSpace() {
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusHours(2);
        PaymentMethod paymentMethod = PaymentMethodFactory.createPaymentMethod("CREDIT", "1234567890", "123");
        
        // This should throw an exception when trying to save
        Booking booking = new Booking("B123", testStudent, null, startTime, endTime, paymentMethod);
        assertThrows(RuntimeException.class, () -> bookingDAO.save(booking));
    }

    @Test
    void testBookingWithInvalidDates() {
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.minusHours(1); // End time before start time
        PaymentMethod paymentMethod = PaymentMethodFactory.createPaymentMethod("CREDIT", "1234567890", "123");
        
        Booking booking = new Booking("B123", testStudent, mockParkingSpace, startTime, endTime, paymentMethod);
        bookingDAO.save(booking);
        
        // The amount should be 0 since the duration is negative
        Booking retrieved = bookingDAO.getById("B123");
        assertEquals(0.0, retrieved.getAmount(), 0.01);
    }

    // ===== CSVClientDAO Tests =====

    @Test
    void testSaveStudent() {
        Student student = new Student("ST123", "John Doe", "john@university.edu", "password123",
                                    "STU001", "Computer Science", "3rd");
        Car car = new Car("ABC123");
        student.setCar(car);

        assertDoesNotThrow(() -> clientDAO.save(student));

        Client retrieved = clientDAO.getById("ST123");
        assertNotNull(retrieved);
        assertTrue(retrieved instanceof Student);
        assertEquals("John Doe", retrieved.getName());
        assertEquals("john@university.edu", retrieved.getEmail());
        assertNotNull(retrieved.getCar());
        assertEquals("ABC123", retrieved.getCar().getLicensePlate());
    }

    @Test
    void testSaveVisitor() {
        Visitor visitor = new Visitor("VI123", "Jane Smith", "jane@email.com", "pass123",
                                    "Conference Attendee", "VIS001");
        Car car = new Car("XYZ789");
        visitor.setCar(car);

        assertDoesNotThrow(() -> clientDAO.save(visitor));

        Client retrieved = clientDAO.getById("VI123");
        assertNotNull(retrieved);
        assertTrue(retrieved instanceof Visitor);
        assertEquals("Jane Smith", retrieved.getName());
        assertEquals("jane@email.com", retrieved.getEmail());
        assertNotNull(retrieved.getCar());
        assertEquals("XYZ789", retrieved.getCar().getLicensePlate());
    }

    @Test
    void testGetClientByIdNotFound() {
        Client retrieved = clientDAO.getById("NONEXISTENT");
        assertNull(retrieved);
    }

    @Test
    void testGetAllClients() {
        // Save multiple clients
        Student student = new Student("ST123", "John Doe", "john@university.edu", "password123",
                                    "STU001", "Computer Science", "3rd");
        Visitor visitor = new Visitor("VI123", "Jane Smith", "jane@email.com", "pass123",
                                    "Conference Attendee", "VIS001");

        clientDAO.save(student);
        clientDAO.save(visitor);

        List<Client> allClients = clientDAO.getAll();
        assertNotNull(allClients);
        assertTrue(allClients.size() >= 2);
    }

    @Test
    void testUpdateClient() {
        // First save a client
        Student student = new Student("ST123", "John Doe", "john@university.edu", "password123",
                                    "STU001", "Computer Science", "3rd");
        clientDAO.save(student);

        // Create a new student with updated information
        Student updatedStudent = new Student("ST123", "John Updated", "john@university.edu", "password123",
                                           "STU001", "Computer Science", "3rd");
        
        // Update the client
        assertDoesNotThrow(() -> clientDAO.update(updatedStudent));

        // Verify the update
        Client retrieved = clientDAO.getById("ST123");
        assertNotNull(retrieved);
        assertEquals("John Updated", retrieved.getName());
    }

    @Test
    void testDeleteClient() {
        // First save a client
        Student student = new Student("ST123", "John Doe", "john@university.edu", "password123",
                                    "STU001", "Computer Science", "3rd");
        clientDAO.save(student);

        // Delete the client
        assertDoesNotThrow(() -> clientDAO.delete("ST123"));

        // Verify the deletion
        Client deleted = clientDAO.getById("ST123");
        assertNull(deleted);
    }

    @Test
    void testClientWithoutCar() {
        Student student = new Student("ST123", "John Doe", "john@university.edu", "password123",
                                    "STU001", "Computer Science", "3rd");
        // Don't set a car

        assertDoesNotThrow(() -> clientDAO.save(student));

        Client retrieved = clientDAO.getById("ST123");
        assertNotNull(retrieved);
        assertNull(retrieved.getCar());
    }

    @Test
    void testClientTypeDetection() {
        // Test Student type detection
        Student student = new Student("ST123", "John Doe", "john@university.edu", "password123",
                                    "STU001", "Computer Science", "3rd");
        clientDAO.save(student);
        Client retrievedStudent = clientDAO.getById("ST123");
        assertTrue(retrievedStudent instanceof Student);

        // Test Visitor type detection
        Visitor visitor = new Visitor("VI123", "Jane Smith", "jane@email.com", "pass123",
                                    "Conference Attendee", "VIS001");
        clientDAO.save(visitor);
        Client retrievedVisitor = clientDAO.getById("VI123");
        assertTrue(retrievedVisitor instanceof Visitor);
    }

    @Test
    void testClientWithSpecialCharacters() {
        // Test with special characters in name and email
        Student student = new Student("ST123", "John O'Doe-Smith", "john.o'doe@university.edu", "password123",
                                    "STU001", "Computer Science", "3rd");
        clientDAO.save(student);
        
        Client retrieved = clientDAO.getById("ST123");
        assertNotNull(retrieved);
        assertEquals("John O'Doe-Smith", retrieved.getName());
        assertEquals("john.o'doe@university.edu", retrieved.getEmail());
    }

    @Test
    void testClientWithLongValues() {
        // Test with long values for name and email
        String longName = "a".repeat(100);
        String longEmail = "b".repeat(50) + "@example.com";
        
        Student student = new Student("ST123", longName, longEmail, "password123",
                                    "STU001", "Computer Science", "3rd");
        clientDAO.save(student);
        
        Client retrieved = clientDAO.getById("ST123");
        assertNotNull(retrieved);
        assertEquals(longName, retrieved.getName());
        assertEquals(longEmail, retrieved.getEmail());
    }

    @Test
    void testClientWithEmptyValues() {
        // Test with empty values for name and email
        Student student = new Student("ST123", "", "", "password123",
                                    "STU001", "Computer Science", "3rd");
        clientDAO.save(student);
        
        Client retrieved = clientDAO.getById("ST123");
        assertNotNull(retrieved);
        assertEquals("", retrieved.getName());
        assertEquals("", retrieved.getEmail());
    }

    @Test
    void testClientWithNullValues() {
        // Test with null values for name and email
        Student student = new Student("ST123", null, null, "password123",
                                    "STU001", "Computer Science", "3rd");
        clientDAO.save(student);
        
        Client retrieved = clientDAO.getById("ST123");
        assertNotNull(retrieved);
        assertNull(retrieved.getName());
        assertNull(retrieved.getEmail());
    }

    @Test
    void testClientWithDifferentStatuses() {
        // Test with different status values
        Student student = new Student("ST123", "John Doe", "john@university.edu", "password123",
                                    "STU001", "Computer Science", "3rd");
        student.setStatus("ACTIVE");
        clientDAO.save(student);
        
        Client retrieved = clientDAO.getById("ST123");
        assertNotNull(retrieved);
        assertEquals("ACTIVE", retrieved.getStatus());
        
        // Update status
        student.setStatus("INACTIVE");
        clientDAO.update(student);
        
        retrieved = clientDAO.getById("ST123");
        assertEquals("INACTIVE", retrieved.getStatus());
    }

    @Test
    void testClientWithDifferentCarLicensePlates() {
        // Test with different car license plates
        Student student = new Student("ST123", "John Doe", "john@university.edu", "password123",
                                    "STU001", "Computer Science", "3rd");
        Car car = new Car("ABC123");
        student.setCar(car);
        clientDAO.save(student);
        
        Client retrieved = clientDAO.getById("ST123");
        assertNotNull(retrieved);
        assertNotNull(retrieved.getCar());
        assertEquals("ABC123", retrieved.getCar().getLicensePlate());
        
        // Update car
        Car newCar = new Car("XYZ789");
        student.setCar(newCar);
        clientDAO.update(student);
        
        retrieved = clientDAO.getById("ST123");
        assertEquals("XYZ789", retrieved.getCar().getLicensePlate());
    }

    @Test
    void testClientWithInvalidId() {
        // Test with an invalid client ID format
        Student student = new Student("INVALID", "John Doe", "john@university.edu", "password123",
                                    "STU001", "Computer Science", "3rd");
        clientDAO.save(student);
        
        // The client should still be saved, but the type detection might not work correctly
        Client retrieved = clientDAO.getById("INVALID");
        assertNotNull(retrieved);
    }

    @Test
    void testFileIOException() {
        // Create a read-only file to simulate IOException
        File readOnlyFile = tempDir.resolve("readonly.csv").toFile();
        try {
            readOnlyFile.createNewFile();
            readOnlyFile.setReadOnly();
        } catch (IOException e) {
            fail("Failed to create read-only file: " + e.getMessage());
        }
        
        CSVClientDAO readOnlyDAO = new CSVClientDAO(readOnlyFile.getAbsolutePath());
        
        // Attempting to save should throw an exception
        Student student = new Student("ST123", "John Doe", "john@university.edu", "password123",
                                    "STU001", "Computer Science", "3rd");
        assertThrows(RuntimeException.class, () -> readOnlyDAO.save(student));
    }
} 