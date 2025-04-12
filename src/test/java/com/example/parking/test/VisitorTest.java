package com.example.parking.test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.parking.model.ParkingSpace;
import com.example.parking.model.Visitor;

public class VisitorTest {
    private Visitor visitor;
    private Date testDate;
    private ParkingSpace parkingSpace;

    @BeforeEach
    void setUp() {
        visitor = new Visitor("V123", "Jane Smith", "jane@email.com", "pass123",
                            "Conference Attendee", "VIS001");
        testDate = new Date();
        parkingSpace = new ParkingSpace("P1", 15.0); // rate of $15.0
    }

    @Test
    void testVisitorConstructor() {
        assertNotNull(visitor);
        assertEquals("Jane Smith", visitor.getName());
        assertEquals("jane@email.com", visitor.getEmail());
        assertEquals("Conference Attendee", visitor.getvisitInformation());
        assertEquals("VIS001", visitor.getVisitorId());
    }

    @Test
    void testGettersAndSetters() {
        visitor.setvisitInformation("Workshop Participant");
        assertEquals("Workshop Participant", visitor.getvisitInformation());

        visitor.setVisitorId("VIS002");
        assertEquals("VIS002", visitor.getVisitorId());

        visitor.setVisitDate(testDate);
        assertEquals(testDate, visitor.getVisitDate());
    }

    @Test
    void testDiscountRate() {
        assertEquals(0.1, visitor.getDiscountRate(), 0.001);
    }

    @Test
    void testParkingRate() {
        assertTrue(visitor.getParkingRate() > 0);
    }

    @Test
    void testUpdate() {
        parkingSpace.occupy("XYZ789");
        visitor.update(parkingSpace);
        assertTrue(parkingSpace.isBooked());
        assertEquals("XYZ789", parkingSpace.getLicensePlate());
        
        // Testing both occupied and available states
        parkingSpace.vacate();
        visitor.update(parkingSpace);
        assertFalse(parkingSpace.isBooked());
        assertNull(parkingSpace.getLicensePlate());
    }

    @Test
    void testToString() {
        visitor.setVisitDate(testDate);
        String visitorString = visitor.toString();
        assertTrue(visitorString.contains("Conference Attendee"));
        assertTrue(visitorString.contains("VIS001"));
        assertTrue(visitorString.contains(testDate.toString()));
        assertTrue(visitorString.contains("Jane Smith"));
    }
} 