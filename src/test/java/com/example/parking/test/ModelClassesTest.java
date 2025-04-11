package com.example.parking.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.example.parking.model.Booking;
import com.example.parking.model.Car;
import com.example.parking.model.Client;
import com.example.parking.model.FacultyMember;
import com.example.parking.model.NonFacultyStaff;
import com.example.parking.model.ParkingSpace;
import com.example.parking.model.Student;
import com.example.parking.model.Visitor;
import com.example.parking.model.payment.CreditCard;
import com.example.parking.model.payment.DebitCard;
import com.example.parking.model.payment.MobilePayment;
import com.example.parking.model.payment.PaymentMethod;

public class ModelClassesTest {

    @Test
    void testCarModel() {
        // Test constructor and getters
        Car car = new Car("ABC123", "Toyota", "Camry", "Blue");
        
        assertEquals("ABC123", car.getLicensePlate());
        assertEquals("Toyota", car.getMake());
        assertEquals("Camry", car.getModel());
        assertEquals("Blue", car.getColor());
        
        // Test setters
        car.setLicensePlate("XYZ789");
        car.setMake("Honda");
        car.setModel("Civic");
        car.setColor("Red");
        
        assertEquals("XYZ789", car.getLicensePlate());
        assertEquals("Honda", car.getMake());
        assertEquals("Civic", car.getModel());
        assertEquals("Red", car.getColor());
        
        // Test toString method
        String carString = car.toString();
        assertTrue(carString.contains("XYZ789"));
        assertTrue(carString.contains("Honda"));
        assertTrue(carString.contains("Civic"));
        assertTrue(carString.contains("Red"));
    }
    
    @Test
    void testClientSubclasses() {
        // Test FacultyMember
        FacultyMember faculty = new FacultyMember("FM001", "John Smith", "john@example.com", "password", "F123", "Computer Science");
        assertEquals("FM001", faculty.getId());
        assertEquals("John Smith", faculty.getName());
        assertEquals("john@example.com", faculty.getEmail());
        assertEquals("F123", faculty.getFacultyId());
        assertEquals("Computer Science", faculty.getDepartment());
        assertEquals(0.15, faculty.getDiscountRate()); // 15% discount
        
        // Test NonFacultyStaff
        NonFacultyStaff staff = new NonFacultyStaff("NF001", "Jane Doe", "jane@example.com", "password", "S123", "Administration");
        assertEquals("NF001", staff.getId());
        assertEquals("Jane Doe", staff.getName());
        assertEquals("jane@example.com", staff.getEmail());
        assertEquals("S123", staff.getStaffId());
        assertEquals("Administration", staff.getOffice());
        assertEquals(0.1, staff.getDiscountRate()); // 10% discount
        
        // Test Student
        Student student = new Student("ST001", "Bob Johnson", "bob@example.com", "password", "B123", "Physics", "Junior");
        assertEquals("ST001", student.getId());
        assertEquals("Bob Johnson", student.getName());
        assertEquals("bob@example.com", student.getEmail());
        assertEquals("B123", student.getStudentId());
        assertEquals("Physics", student.getMajor());
        assertEquals("Junior", student.getYear());
        assertEquals(0.15, student.getDiscountRate()); // 15% discount
        
        // Test Visitor
        Visitor visitor = new Visitor("VI001", "Alice Brown", "alice@example.com", "password", "Conference", "V123");
        assertEquals("VI001", visitor.getId());
        assertEquals("Alice Brown", visitor.getName());
        assertEquals("alice@example.com", visitor.getEmail());
        assertEquals("Conference", visitor.getvisitInformation());
        assertEquals("V123", visitor.getVisitorId());
        assertEquals(0.1, visitor.getDiscountRate()); // 10% discount
        
        // Test setting car for a client
        Car car = new Car("ABC123", "Toyota", "Camry", "Blue");
        faculty.setCar(car);
        assertEquals(car, faculty.getCar());
    }
    
    @Test
    void testParkingSpace() {
        // Test constructor and initial state
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        assertEquals("A1", space.getId());
        assertEquals(10.0, space.getRate());
        assertFalse(space.isOccupied());
        assertTrue(space.isEnabled());
        
        // Test occupation methods
        space.occupy("ABC123");
        assertTrue(space.isOccupied());
        assertEquals("ABC123", space.getLicensePlate());
        
        space.vacate();
        assertFalse(space.isOccupied());
        assertNull(space.getLicensePlate());
        
        // Test enable/disable methods
        space.disable();
        assertFalse(space.isEnabled());
        
        space.enable();
        assertTrue(space.isEnabled());
        
        // Test getting status as string
        space.occupy("XYZ789");
        assertEquals("Occupied", space.getStatus());
        
        space.vacate();
        assertEquals("Available", space.getStatus());
        
        space.disable();
        assertEquals("Disabled", space.getStatus());
    }
    
    @Test
    void testPaymentMethods() {
        // Test CreditCard
        CreditCard creditCard = new CreditCard("John Doe", "1234567890123456", "12/25", 1000.0);
        assertEquals(1000.0, creditCard.getAmount());
        assertTrue(creditCard.processPayment(500.0));
        
        // Test DebitCard
        DebitCard debitCard = new DebitCard("1234567890123456", "John Doe", "1234", 1000.0);
        assertEquals(1000.0, debitCard.getAmount());
        assertTrue(debitCard.processPayment(500.0));
        
        // Test MobilePayment
        MobilePayment mobilePayment = new MobilePayment("1234567890", 1000.0);
        assertEquals(1000.0, mobilePayment.getAmount());
        assertTrue(mobilePayment.processPayment(500.0));
        
        // Test setting amount
        creditCard.setAmount(2000.0);
        assertEquals(2000.0, creditCard.getAmount());
    }
    
    @Test
    void testBooking() {
        // Setup
        Client client = new FacultyMember("FM001", "John Smith", "john@example.com", "password", "F123", "Computer Science");
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusHours(2);
        PaymentMethod paymentMethod = new CreditCard("John Smith", "1234567890123456", "12/25", 1000.0);
        
        // Test constructor and getters
        Booking booking = new Booking("B001", client, space, startTime, endTime, paymentMethod);
        
        assertEquals("B001", booking.getBookingId());
        assertEquals(client.getId(), booking.getClientId());
        assertEquals(space.getId(), booking.getSpaceId());
        assertEquals(startTime, booking.getStartTime());
        assertEquals(endTime, booking.getEndTime());
        assertEquals(paymentMethod, booking.getPaymentMethod());
        
        // Test setting amount
        booking.setAmount(50.0);
        assertEquals(50.0, booking.getAmount());
        
        // Test setting status
        booking.setStatus("CONFIRMED");
        assertEquals("CONFIRMED", booking.getStatus());
        
        // Test toString method
        String bookingString = booking.toString();
        assertTrue(bookingString.contains("B001"));
        assertTrue(bookingString.contains(client.getId()));
        assertTrue(bookingString.contains(space.getId()));
    }
}