package com.example.parking.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import com.example.parking.strategy.StudentPricing;
import com.example.parking.strategy.FacultyPricing;
import com.example.parking.strategy.NonFacultyStaffPricing;
import com.example.parking.strategy.VisitorPricing;
import org.junit.jupiter.api.Test;

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
        double expectedRate = 10.0; // Example expected rate for faculty members
        assertEquals(expectedRate, facultyPricing.getRate(), "The rate for faculty members should be 10.0");
    }

    @Test
    void testGetRateForNonFaculty() {
        double expectedRate = 8.0; // Example expected rate for non-faculty staff
        assertEquals(expectedRate, nonFacultyPricing.getRate(), "The rate for non-faculty staff should be 8.0");
    }

    @Test
    void testGetRateForVisitor() {
        double expectedRate = 15.0; // Example expected rate for visitors
        assertEquals(expectedRate, visitorPricing.getRate(), "The rate for visitors should be 15.0");
    }

    @Test
    void testStudentPricingEdgeCases() {
        // Assuming there are edge cases for student pricing
        studentPricing.setRate(0.0); // Set to zero for testing
        assertEquals(0.0, studentPricing.getRate(), "The rate for students should be 0.0 when set to zero");
        
        studentPricing.setRate(-5.0); // Set to negative for testing
        assertTrue(studentPricing.getRate() >= 0, "The rate for students should not be negative");
    }

    @Test
    void testFacultyPricingEdgeCases() {
        facultyPricing.setRate(0.0);
        assertEquals(0.0, facultyPricing.getRate(), "The rate for faculty members should be 0.0 when set to zero");
        
        facultyPricing.setRate(-10.0);
        assertTrue(facultyPricing.getRate() >= 0, "The rate for faculty members should not be negative");
    }

    @Test
    void testNonFacultyPricingEdgeCases() {
        nonFacultyPricing.setRate(0.0);
        assertEquals(0.0, nonFacultyPricing.getRate(), "The rate for non-faculty staff should be 0.0 when set to zero");
        
        nonFacultyPricing.setRate(-8.0);
        assertTrue(nonFacultyPricing.getRate() >= 0, "The rate for non-faculty staff should not be negative");
    }

    @Test
    void testVisitorPricingEdgeCases() {
        visitorPricing.setRate(0.0);
        assertEquals(0.0, visitorPricing.getRate(), "The rate for visitors should be 0.0 when set to zero");
        
        visitorPricing.setRate(-15.0);
        assertTrue(visitorPricing.getRate() >= 0, "The rate for visitors should not be negative");
    }
}