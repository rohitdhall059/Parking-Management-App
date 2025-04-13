package com.example.parking.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.parking.strategy.FacultyPricing;
import com.example.parking.strategy.NonFacultyStaffPricing;
import com.example.parking.strategy.StudentPricing;
import com.example.parking.strategy.VisitorPricing;

class PricingStrategyTest {
    private StudentPricing studentPricing;
    private FacultyPricing facultyPricing;
    private NonFacultyStaffPricing nonFacultyPricing;
    private VisitorPricing visitorPricing;

    @BeforeEach
    void setUp() {
        studentPricing = new StudentPricing();
        facultyPricing = new FacultyPricing();
        nonFacultyPricing = new NonFacultyStaffPricing();
        visitorPricing = new VisitorPricing();
    }

    @Test
    void testGetRateForStudent() {
        double expectedRate = 5.0; // Example expected rate for students
        assertEquals(expectedRate, studentPricing.getRate(), "The rate for students should be 5.0");
    }

    @Test
    void testGetRateForFacultyMember() {
        double expectedRate = 8.0; // Example expected rate for faculty members
        assertEquals(expectedRate, facultyPricing.getRate(), "The rate for faculty members should be 8.0");
    }

    @Test
    void testGetRateForNonFaculty() {
        double expectedRate = 10.0; // Example expected rate for non-faculty staff
        assertEquals(expectedRate, nonFacultyPricing.getRate(), "The rate for non-faculty staff should be 10.0");
    }

    @Test
    void testGetRateForVisitor() {
        double expectedRate = 15.0; // Example expected rate for visitors
        assertEquals(expectedRate, visitorPricing.getRate(), "The rate for visitors should be 15.0");
    }

    @Test
    void testGetTypeForStudent() {
        String expectedType = "STUDENT"; // Expected type for students
        assertEquals(expectedType, studentPricing.getType(), "The type for students should be STUDENT");
    }

    @Test
    void testGetTypeForFaculty() {
        String expectedType = "FACULTY"; // Expected type for faculty
        assertEquals(expectedType, facultyPricing.getType(), "The type for faculty should be FACULTY");
    }

    @Test
    void testGetTypeForNonFaculty() {
        String expectedType = "NON_FACULTY_STAFF"; // Expected type for non-faculty staff
        assertEquals(expectedType, nonFacultyPricing.getType(), "The type for non-faculty staff should be NON_FACULTY_STAFF");
    }

    @Test
    void testGetTypeForVisitor() {
        String expectedType = "VISITOR"; // Expected type for visitors
        assertEquals(expectedType, visitorPricing.getType(), "The type for visitors should be VISITOR");
    }

    @Test
    void testStudentPricingEdgeCases() {
        // Attempting to set the rate should throw an exception
        assertThrows(UnsupportedOperationException.class, () -> {
            studentPricing.setRate(0.0);
        }, "Setting the rate should throw an UnsupportedOperationException");
    }

    @Test
    void testFacultyPricingEdgeCases() {
        // Assert that the rate is fixed at 8.0
        assertEquals(8.0, facultyPricing.getRate(), "The rate for faculty members should always be 8.0");

        // Attempting to set the rate should throw an exception
        assertThrows(UnsupportedOperationException.class, () -> {
            facultyPricing.setRate(0.0);
        }, "Setting the rate should throw an UnsupportedOperationException");

        assertThrows(UnsupportedOperationException.class, () -> {
            facultyPricing.setRate(-10.0);
        }, "Setting the rate should throw an UnsupportedOperationException");
    }

    @Test
    void testNonFacultyPricingEdgeCases() {
        // Attempting to set the rate should throw an exception
        assertThrows(UnsupportedOperationException.class, () -> {
            nonFacultyPricing.setRate(0.0);
        }, "Setting the rate should throw an UnsupportedOperationException");
    }

    @Test
    void testVisitorPricingEdgeCases() {
        // Attempting to set the rate should throw an exception
        assertThrows(UnsupportedOperationException.class, () -> {
            visitorPricing.setRate(0.0);
        }, "Setting the rate should throw an UnsupportedOperationException");
    }
}