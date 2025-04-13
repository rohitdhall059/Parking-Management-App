package com.example.parking.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.parking.model.Car;
import com.example.parking.model.ParkingSpace;
import com.example.parking.state.AvailableState;
import com.example.parking.state.DisabledState;
import com.example.parking.state.OccupiedState;

public class AvailableStateTest {

    private AvailableState availableState;
    private ParkingSpace parkingSpace;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        availableState = new AvailableState();
        parkingSpace = new ParkingSpace("A1", 10.0);
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testOccupyEnabledSpace() {
        // Setup
        parkingSpace.enable();
        String licensePlate = "ABC123";

        // Execute
        availableState.occupy(parkingSpace, licensePlate);

        // Verify
        String output = outputStream.toString();
        assertTrue(output.contains("Parking space A1 is now occupied by car with license plate: ABC123"));
        assertTrue(parkingSpace.isOccupied());
        assertEquals(licensePlate, parkingSpace.getLicensePlate());
    }

    @Test
    void testOccupyDisabledSpace() {
        // Setup
        parkingSpace.disable();
        String licensePlate = "ABC123";

        // Execute
        availableState.occupy(parkingSpace, licensePlate);

        // Verify
        String output = outputStream.toString();
        assertTrue(output.contains("Cannot occupy disabled parking space A1"));
        assertFalse(parkingSpace.isOccupied());
        assertNull(parkingSpace.getLicensePlate());
    }

    @Test
    void testVacate() {
        // Execute
        availableState.vacate(parkingSpace);

        // Verify
        String output = outputStream.toString();
        assertTrue(output.contains("Parking space A1 is already available."));
        assertFalse(parkingSpace.isOccupied());
        assertNull(parkingSpace.getLicensePlate());
    }

    @Test
    void testEnable() {
        // Execute
        availableState.enable(parkingSpace);

        // Verify
        String output = outputStream.toString();
        assertTrue(output.contains("Parking space A1 is already enabled."));
        assertTrue(parkingSpace.isEnabled());
    }

    @Test
    void testDisable() {
        // Execute
        availableState.disable(parkingSpace);

        // Verify
        String output = outputStream.toString();
        assertTrue(output.contains("Parking space A1 has been disabled."));
        assertFalse(parkingSpace.isEnabled());
        assertTrue(parkingSpace.getState() instanceof DisabledState);
    }

    @Test
    void testStateTransitions() {
        // Test transition to OccupiedState
        parkingSpace.enable();
        availableState.occupy(parkingSpace, "ABC123");
        assertTrue(parkingSpace.getState() instanceof OccupiedState);

        // Reset to AvailableState
        parkingSpace.setState(new AvailableState());
        parkingSpace.enable();

        // Test transition to DisabledState
        availableState.disable(parkingSpace);
        assertTrue(parkingSpace.getState() instanceof DisabledState);
    }

    @Test
    void testMultipleOperations() {
        // Test sequence of operations
        parkingSpace.enable();
        assertTrue(parkingSpace.isEnabled());
        assertFalse(parkingSpace.isOccupied());

        availableState.occupy(parkingSpace, "ABC123");
        assertTrue(parkingSpace.isOccupied());
        assertEquals("ABC123", parkingSpace.getLicensePlate());

        // Reset to AvailableState
        parkingSpace.setState(new AvailableState());
        parkingSpace.enable();

        availableState.disable(parkingSpace);
        assertFalse(parkingSpace.isEnabled());
        assertTrue(parkingSpace.getState() instanceof DisabledState);
    }
    @Test
    void testOccupyAlreadyOccupiedSpace() {
        // Setup
        parkingSpace.enable();
        parkingSpace.setOccupied(true, new Car("XYZ789")); // Manually occupy the space
        String licensePlate = "ABC123";

        // Execute
        availableState.occupy(parkingSpace, licensePlate);

        // Verify
        String output = outputStream.toString();
        assertTrue(output.contains("Parking space A1 is already occupied.")); // You may need to add this message in your AvailableState class
        assertTrue(parkingSpace.isOccupied());
        assertEquals("XYZ789", parkingSpace.getLicensePlate()); // Ensure the original license plate remains
    }

    @Test
    void testDisableAlreadyDisabledSpace() {
        // Setup
        parkingSpace.disable(); // Manually disable the space

        // Execute
        availableState.disable(parkingSpace);

        // Verify
        String output = outputStream.toString();
        assertTrue(output.contains("Parking space A1 is already disabled.")); // You may need to add this message in your AvailableState class
        assertFalse(parkingSpace.isEnabled());
        assertTrue(parkingSpace.getState() instanceof DisabledState);
    }

    @Test
    void testVacateOccupiedSpace() {
        // Setup
        parkingSpace.enable();
        parkingSpace.setOccupied(true, new Car("XYZ789")); // Manually occupy the space

        // Execute
        availableState.vacate(parkingSpace);

        // Verify
        String output = outputStream.toString();
        assertTrue(output.contains("Parking space A1 is now vacated.")); // You may need to add this message in your AvailableState class
        assertFalse(parkingSpace.isOccupied());
        assertNull(parkingSpace.getLicensePlate());
    }
    @Test
    void testOccupyWhenAlreadyOccupied() {
        // Setup
        parkingSpace.enable();
        parkingSpace.setOccupied(true, new Car("XYZ789")); // Manually occupy the space
        String licensePlate = "ABC123";

        // Execute
        availableState.occupy(parkingSpace, licensePlate);

        // Verify
        String output = outputStream.toString();
        assertTrue(output.contains("Parking space A1 is already occupied.")); // Ensure this message is in AvailableState
        assertTrue(parkingSpace.isOccupied());
        assertEquals("XYZ789", parkingSpace.getLicensePlate()); // Ensure the original license plate remains
    }

    @Test
    void testVacateWhenAlreadyAvailable() {
        // Execute
        availableState.vacate(parkingSpace);

        // Verify
        String output = outputStream.toString();
        assertTrue(output.contains("Parking space A1 is already available."));
        assertFalse(parkingSpace.isOccupied());
        assertNull(parkingSpace.getLicensePlate());
    }

    @Test
    void testDisableWhenAlreadyDisabled() {
        // Setup
        parkingSpace.disable(); // Manually disable the space

        // Execute
        availableState.disable(parkingSpace);

        // Verify
        String output = outputStream.toString();
        assertTrue(output.contains("Parking space A1 is already disabled."));
        assertFalse(parkingSpace.isEnabled());
        assertTrue(parkingSpace.getState() instanceof DisabledState);
    }

    @Test
    void testEnableWhenAlreadyEnabled() {
        // Setup
        parkingSpace.enable(); // Ensure the space is enabled

        // Execute
        availableState.enable(parkingSpace);

        // Verify
        String output = outputStream.toString();
        assertTrue(output.contains("Parking space A1 is already enabled."));
        assertTrue(parkingSpace.isEnabled());
    }

    @Test
    void testStateTransitionsAfterMultipleOperations() {
        // Test sequence of operations
        parkingSpace.enable();
        availableState.occupy(parkingSpace, "ABC123");
        assertTrue(parkingSpace.isOccupied());
        assertEquals("ABC123", parkingSpace.getLicensePlate());

        // Vacate the space
        availableState.vacate(parkingSpace);
        assertFalse(parkingSpace.isOccupied());
        assertNull(parkingSpace.getLicensePlate());

        // Disable the space
        availableState.disable(parkingSpace);
        assertFalse(parkingSpace.isEnabled());
        assertTrue(parkingSpace.getState() instanceof DisabledState);

        // Enable the space again
        parkingSpace.enable();
        assertTrue(parkingSpace.isEnabled());
        assertTrue(parkingSpace.getState() instanceof AvailableState);
    }
} 