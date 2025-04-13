package com.example.parking.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.parking.model.ParkingSpace;
import com.example.parking.model.Student;

public class StudentTest {
    private Student student;
    private ParkingSpace parkingSpace;

    @BeforeEach
    void setUp() {
        student = new Student("S123", "John Doe", "john@university.edu", "password123", 
                            "STU001", "Computer Science", "3rd");
        parkingSpace = new ParkingSpace("P1", 10.0); // rate of $10.0
    }

    @Test
    void testStudentConstructor() {
        assertNotNull(student);
        assertEquals("John Doe", student.getName());
        assertEquals("john@university.edu", student.getEmail());
        assertEquals("STU001", student.getStudentId());
        assertEquals("Computer Science", student.getDepartment());
        assertEquals("3rd", student.getYear());
    }

    @Test
    void testGettersAndSetters() {
        student.setDepartment("Mathematics");
        assertEquals("Mathematics", student.getDepartment());
        assertEquals("Mathematics", student.getMajor()); // Testing getMajor alias

        student.setYear("4th");
        assertEquals("4th", student.getYear());

        student.setStudentId("STU002");
        assertEquals("STU002", student.getStudentId());
    }

    @Test
    void testDiscountRate() {
        assertEquals(0.15, student.getDiscountRate(), 0.001);
    }

    @Test
    void testParkingRate() {
        assertTrue(student.getParkingRate() > 0);
    }

    @Test
    void testRequiresValidation() {
        assertFalse(student.requiresValidation());
        
        Student invalidStudent = new Student("S124", "Jane Doe", "jane@university.edu", 
                                          "password123", null, "Physics", "2nd");
        assertTrue(invalidStudent.requiresValidation());

        Student emptyIdStudent = new Student("S125", "Bob Smith", "bob@university.edu", 
                                           "password123", "", "Chemistry", "1st");
        assertTrue(emptyIdStudent.requiresValidation());
    }

    @Test
    void testUpdate() {
        parkingSpace.occupy("ABC123");
        student.update(parkingSpace);
        // This test verifies that the update method doesn't throw exceptions
        // and handles both occupied and available states
        
        parkingSpace.vacate();
        student.update(parkingSpace);
    }

    @Test
    void testToString() {
        String studentString = student.toString();
        assertTrue(studentString.contains("STU001"));
        assertTrue(studentString.contains("Computer Science"));
        assertTrue(studentString.contains("3rd"));
        assertTrue(studentString.contains("John Doe"));
    }
} 
