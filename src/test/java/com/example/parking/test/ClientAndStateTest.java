package com.example.parking.test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.parking.model.FacultyMember;
import com.example.parking.model.NonFacultyStaff;
import com.example.parking.model.ParkingSpace;
import com.example.parking.state.AvailableState;
import com.example.parking.state.DisabledState;
import com.example.parking.state.OccupiedState;

public class ClientAndStateTest {
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;
    private ParkingSpace parkingSpace;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        parkingSpace = new ParkingSpace("A1", 10.0);
    }

    // ===== FacultyMember Tests =====

    @Test
    void testFacultyMemberConstructor() {
        FacultyMember faculty = new FacultyMember("FM001", "John Smith", "john@example.com", "password", "F123", "Computer Science");
        
        assertEquals("FM001", faculty.getId());
        assertEquals("John Smith", faculty.getName());
        assertEquals("john@example.com", faculty.getEmail());
        assertEquals("F123", faculty.getFacultyId());
        assertEquals("Computer Science", faculty.getDepartment());
    }

    @Test
    void testFacultyMemberGettersAndSetters() {
        FacultyMember faculty = new FacultyMember("FM001", "John Smith", "john@example.com", "password", "F123", "Computer Science");
        
        faculty.setDepartment("Mathematics");
        assertEquals("Mathematics", faculty.getDepartment());
        
        faculty.setFacultyId("F456");
        assertEquals("F456", faculty.getFacultyId());
    }

    @Test
    void testFacultyMemberParkingRate() {
        FacultyMember faculty = new FacultyMember("FM001", "John Smith", "john@example.com", "password", "F123", "Computer Science");
        assertEquals(8.0, faculty.getParkingRate()); // From FacultyPricing class
    }

    @Test
    void testFacultyMemberValidation() {
        FacultyMember faculty = new FacultyMember("FM001", "John Smith", "john@example.com", "password", "F123", "Computer Science");
        assertFalse(faculty.requiresValidation());
        
        faculty.setFacultyId(null);
        assertTrue(faculty.requiresValidation());
        
        faculty.setFacultyId("");
        assertTrue(faculty.requiresValidation());
    }

    @Test
    void testFacultyMemberObserver() {
        FacultyMember faculty = new FacultyMember("FM001", "John Smith", "john@example.com", "password", "F123", "Computer Science");
        
        faculty.update(parkingSpace);
        String output = outputStream.toString();
        assertTrue(output.contains("Faculty John Smith: Parking space A1 status changed to available"));
        
        parkingSpace.occupy("ABC123");
        faculty.update(parkingSpace);
        output = outputStream.toString();
        assertTrue(output.contains("Faculty John Smith: Parking space A1 status changed to occupied"));
        assertTrue(output.contains("Details: Car with license plate: ABC123"));
    }

    @Test
    void testFacultyMemberDiscount() {
        FacultyMember faculty = new FacultyMember("FM001", "John Smith", "john@example.com", "password", "F123", "Computer Science");
        assertEquals(0.15, faculty.getDiscountRate());
    }

    @Test
    void testFacultyMemberToString() {
        FacultyMember faculty = new FacultyMember("FM001", "John Smith", "john@example.com", "password", "F123", "Computer Science");
        String str = faculty.toString();
        assertTrue(str.contains("FacultyMember"));
        assertTrue(str.contains("F123"));
        assertTrue(str.contains("Computer Science"));
    }

    // ===== NonFacultyStaff Tests =====

    @Test
    void testNonFacultyStaffConstructor() {
        NonFacultyStaff staff = new NonFacultyStaff("NF001", "Jane Doe", "jane@example.com", "password", "S123", "Administration");
        
        assertEquals("NF001", staff.getId());
        assertEquals("Jane Doe", staff.getName());
        assertEquals("jane@example.com", staff.getEmail());
        assertEquals("S123", staff.getStaffId());
        assertEquals("Administration", staff.getOffice());
    }

    @Test
    void testNonFacultyStaffGettersAndSetters() {
        NonFacultyStaff staff = new NonFacultyStaff("NF001", "Jane Doe", "jane@example.com", "password", "S123", "Administration");
        
        staff.setStaffId("S456");
        assertEquals("S456", staff.getStaffId());
        
        staff.setOffice("HR");
        assertEquals("HR", staff.getOffice());
        
        staff.setEmail("new.email@example.com");
        assertEquals("new.email@example.com", staff.getEmail());
    }

    @Test
    void testNonFacultyStaffParkingRate() {
        NonFacultyStaff staff = new NonFacultyStaff("NF001", "Jane Doe", "jane@example.com", "password", "S123", "Administration");
        assertEquals(10.0, staff.getParkingRate()); // From NonFacultyStaffPricing class
    }

    @Test
    void testNonFacultyStaffValidation() {
        NonFacultyStaff staff = new NonFacultyStaff("NF001", "Jane Doe", "jane@example.com", "password", "S123", "Administration");
        assertFalse(staff.requiresValidation());
        
        staff.setStaffId(null);
        assertTrue(staff.requiresValidation());
        
        staff.setStaffId("");
        assertTrue(staff.requiresValidation());
    }

    @Test
    void testNonFacultyStaffObserver() {
        NonFacultyStaff staff = new NonFacultyStaff("NF001", "Jane Doe", "jane@example.com", "password", "S123", "Administration");
        
        staff.update(parkingSpace);
        String output = outputStream.toString();
        assertTrue(output.contains("NonFacultyStaff Jane Doe: Parking space A1 status changed to available"));
        
        parkingSpace.occupy("ABC123");
        staff.update(parkingSpace);
        output = outputStream.toString();
        assertTrue(output.contains("NonFacultyStaff Jane Doe: Parking space A1 status changed to occupied"));
        assertTrue(output.contains("Details: Car with license plate: ABC123"));
    }

    @Test
    void testNonFacultyStaffDiscount() {
        NonFacultyStaff staff = new NonFacultyStaff("NF001", "Jane Doe", "jane@example.com", "password", "S123", "Administration");
        assertEquals(0.1, staff.getDiscountRate());
    }

    @Test
    void testNonFacultyStaffToString() {
        NonFacultyStaff staff = new NonFacultyStaff("NF001", "Jane Doe", "jane@example.com", "password", "S123", "Administration");
        String str = staff.toString();
        assertTrue(str.contains("NonFacultyStaff"));
        assertTrue(str.contains("S123"));
        assertTrue(str.contains("Administration"));
    }

    // ===== AvailableState Tests =====

    @Test
    void testAvailableStateOccupyEnabled() {
        AvailableState state = new AvailableState();
        parkingSpace.enable();
        state.occupy(parkingSpace, "ABC123");
        
        String output = outputStream.toString();
        assertTrue(output.contains("Parking space A1 is now occupied by car with license plate: ABC123"));
        assertTrue(parkingSpace.getState() instanceof OccupiedState);
    }

    @Test
    void testAvailableStateOccupyDisabled() {
        AvailableState state = new AvailableState();
        parkingSpace.disable();
        state.occupy(parkingSpace, "ABC123");
        
        String output = outputStream.toString();
        assertTrue(output.contains("Cannot occupy disabled parking space A1"));
        assertTrue(parkingSpace.getState() instanceof DisabledState);
    }

    @Test
    void testAvailableStateVacate() {
        AvailableState state = new AvailableState();
        state.vacate(parkingSpace);
        
        String output = outputStream.toString();
        assertTrue(output.contains("Parking space A1 is already available."));
    }

    @Test
    void testAvailableStateEnable() {
        AvailableState state = new AvailableState();
        state.enable(parkingSpace);
        
        String output = outputStream.toString();
        assertTrue(output.contains("Parking space A1 is already enabled."));
    }

    @Test
    void testAvailableStateDisable() {
        AvailableState state = new AvailableState();
        state.disable(parkingSpace);
        
        String output = outputStream.toString();
        assertTrue(output.contains("Parking space A1 has been disabled."));
        assertTrue(parkingSpace.getState() instanceof DisabledState);
    }

    // ===== DisabledState Tests =====

    @Test
    void testDisabledStateOccupy() {
        DisabledState state = new DisabledState();
        state.occupy(parkingSpace, "ABC123");
        
        String output = outputStream.toString();
        assertTrue(output.contains("Cannot occupy disabled parking space A1"));
    }

    @Test
    void testDisabledStateVacate() {
        DisabledState state = new DisabledState();
        state.vacate(parkingSpace);
        
        String output = outputStream.toString();
        assertTrue(output.contains("Cannot vacate disabled parking space A1"));
    }

    @Test
    void testDisabledStateEnable() {
        DisabledState state = new DisabledState();
        state.enable(parkingSpace);
        
        String output = outputStream.toString();
        assertTrue(output.contains("Parking space A1 has been enabled."));
        assertTrue(parkingSpace.getState() instanceof AvailableState);
    }

    @Test
    void testDisabledStateDisable() {
        DisabledState state = new DisabledState();
        state.disable(parkingSpace);
        
        String output = outputStream.toString();
        assertTrue(output.contains("Parking space A1 is already disabled."));
    }
}