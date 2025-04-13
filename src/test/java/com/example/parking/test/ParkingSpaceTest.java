package com.example.parking.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.parking.model.Car;
import com.example.parking.model.ParkingSpace;
import com.example.parking.model.Sensor;
import com.example.parking.observer.Observer;
import com.example.parking.state.AvailableState;
import com.example.parking.state.DisabledState;
import com.example.parking.state.OccupiedState;


class ParkingSpaceTest {

    private ParkingSpace parkingSpace;
    private Observer mockObserver;

    @BeforeEach
    void setUp() {
        parkingSpace = new ParkingSpace("A1", 10.0);
        mockObserver = mock(Observer.class); // Initialize the mock observer here
    }

    @Test
    void test1_initialState() {
        assertFalse(parkingSpace.isBooked());
        assertFalse(parkingSpace.isDisabled());
        assertEquals("Available", parkingSpace.getStatus());
    }

    @Test
    void test2_enable() {
        parkingSpace.enable();
        assertFalse(parkingSpace.isDisabled());
        assertEquals("Available", parkingSpace.getStatus());
    }

    @Test
    void test3_disable() {
        parkingSpace.enable();
        parkingSpace.disable();
        assertTrue(parkingSpace.isDisabled());
        assertFalse(parkingSpace.isBooked());
        assertEquals("Disabled", parkingSpace.getStatus());
    }

    @Test
    void test4_occupy() {
        parkingSpace.enable();
        parkingSpace.occupy("ABC123");
        assertTrue(parkingSpace.isBooked());
        assertEquals("ABC123", parkingSpace.getLicensePlate());
        assertEquals("Occupied", parkingSpace.getStatus());
    }

    @Test
    void test5_vacate() {
        parkingSpace.enable();
        parkingSpace.occupy("ABC123");
        parkingSpace.vacate();
        assertFalse(parkingSpace.isBooked());
        assertNull(parkingSpace.getLicensePlate());
        assertEquals("Available", parkingSpace.getStatus());
    }

    @Test
    void test6_getCarInfo() {
        parkingSpace.enable();
        parkingSpace.occupy("ABC123");
        assertEquals("Car with license plate: ABC123", parkingSpace.getCarInfo());
        parkingSpace.vacate();
        assertEquals("No car", parkingSpace.getCarInfo());
    }

    @Test
    void test7_setRate() {
        parkingSpace.setRate(15.0);
        assertEquals(15.0, parkingSpace.getRate());
    }

    @Test
    void test8_attachObserver() {
        parkingSpace.clearObservers(); // Clear any existing observers
        Sensor sensor = new Sensor("Sensor1", parkingSpace); // Attach the sensor
        assertEquals(1, parkingSpace.getObservers().size()); // Expecting 1 observer
    }

    @Test
    void test9_detachObserver() {
        parkingSpace.clearObservers(); // Clear any existing observers
        Sensor sensor = new Sensor("Sensor1", parkingSpace);
        assertEquals(1, parkingSpace.getObservers().size());
        parkingSpace.detach(sensor);
        assertEquals(0, parkingSpace.getObservers().size());
    }

    @Test
    void test10_free() {
        parkingSpace.enable();
        parkingSpace.occupy("ABC123");
        parkingSpace.vacate();
        assertFalse(parkingSpace.isBooked());
        assertEquals("Available", parkingSpace.getStatus());
    }
    @Test
void test11_invalidSpaceId() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        new ParkingSpace(null, 10.0);
    });
    assertEquals("Space ID cannot be null or empty", exception.getMessage());

    exception = assertThrows(IllegalArgumentException.class, () -> {
        new ParkingSpace("", 10.0);
    });
    assertEquals("Space ID cannot be null or empty", exception.getMessage());
}

@Test
void test12_invalidRate() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        new ParkingSpace("A1", -5.0);
    });
    assertEquals("Rate cannot be negative", exception.getMessage());
}

@Test
void test13_occupyDisabledSpace() {
    parkingSpace.disable();
    parkingSpace.occupy("ABC123");
    assertFalse(parkingSpace.isBooked()); // Should not be booked
    assertNull(parkingSpace.getLicensePlate()); // License plate should be null
    assertEquals("Disabled", parkingSpace.getStatus()); // Status should be disabled
}

@Test
void test14_vacateAlreadyVacatedSpace() {
    parkingSpace.enable();
    parkingSpace.vacate(); // Vacate when already available
    assertFalse(parkingSpace.isBooked());
    assertNull(parkingSpace.getLicensePlate());
    assertEquals("Available", parkingSpace.getStatus());
}

@Test
void test15_disableAlreadyDisabledSpace() {
    parkingSpace.disable(); // First disable
    parkingSpace.disable(); // Try to disable again
    assertTrue(parkingSpace.isDisabled());
    assertFalse(parkingSpace.isBooked());
    assertEquals("Disabled", parkingSpace.getStatus());
}

@Test
void test16_enableAlreadyEnabledSpace() {
    parkingSpace.enable(); // First enable
    parkingSpace.enable(); // Try to enable again
    assertFalse(parkingSpace.isDisabled());
    assertEquals("Available", parkingSpace.getStatus());
}

@Test
void test17_observerNotification() {
    parkingSpace.clearObservers(); // Clear any existing observers
    TestObserver observer = new TestObserver();
    parkingSpace.attach(observer);

    parkingSpace.enable();
    assertTrue(observer.isNotified()); // Observer should be notified

    observer.reset(); // Reset notification status
    parkingSpace.occupy("ABC123");
    assertTrue(observer.isNotified()); // Observer should be notified

    observer.reset(); // Reset notification status
    parkingSpace.vacate();
    assertTrue(observer.isNotified()); // Observer should be notified

    observer.reset(); // Reset notification status
    parkingSpace.disable();
    assertTrue(observer.isNotified()); // Observer should be notified

    observer.reset(); // Reset notification status
    parkingSpace.enable();
    assertTrue(observer.isNotified()); // Observer should be notified
}

    // TestObserver class to simulate observer behavior
    class TestObserver implements Observer {
        private boolean notified = false;

        @Override
        public void update(ParkingSpace parkingSpace) {
            notified = true; // Set notified to true when update is called
        }

        public boolean isNotified() {
            return notified; // Return the notification status
        }

        public void reset() {
            notified = false; // Reset the notification status
        }
    }
     @Test
    void testGetStateWhenAvailable() {
        // The parking space should be in the available state initially
        assertTrue(parkingSpace.getState() instanceof AvailableState);
    }

    @Test
    void testGetStateWhenOccupied() {
        // Occupy the parking space
        parkingSpace.occupy("ABC123");
        
        // The parking space should now be in the occupied state
        assertTrue(parkingSpace.getState() instanceof OccupiedState);
    }

    @Test
    void testGetStateWhenDisabled() {
        // Disable the parking space
        parkingSpace.disable();
        
        // The parking space should now be in the disabled state
        assertTrue(parkingSpace.getState() instanceof DisabledState);
    }
    @Test
    void testToString() {
        // Initial state
        String expectedString = "ParkingSpace{" +
                "spaceId='A1'" +
                ", isBooked=false" +
                ", isDisabled=false" +
                ", rate=10.0" +
                ", licensePlate='null'" +
                '}';
        
        // Verify the initial state
        assertEquals(expectedString, parkingSpace.toString());

        // Change the state to booked
        parkingSpace.occupy("ABC123");
        
        // Update expected string after occupying
        expectedString = "ParkingSpace{" +
                "spaceId='A1'" +
                ", isBooked=true" +
                ", isDisabled=false" +
                ", rate=10.0" +
                ", licensePlate='ABC123'" +
                '}';
        
        // Verify the state after occupying
        assertEquals(expectedString, parkingSpace.toString());

        // Disable the parking space
        parkingSpace.disable();
        
        // Update expected string after disabling
        expectedString = "ParkingSpace{" +
                "spaceId='A1'" +
                ", isBooked=false" +
                ", isDisabled=true" +
                ", rate=10.0" +
                ", licensePlate='null'" +
                '}';
        
        // Verify the state after disabling
        assertEquals(expectedString, parkingSpace.toString());
    }
    @Test
    void testSetState() {
        // Create a new ParkingSpace
        ParkingSpace parkingSpace = new ParkingSpace("A1", 10.0);
        
        // Initially, it should be in AvailableState
        assertTrue(parkingSpace.getState() instanceof AvailableState);
        
        // Set the state to OccupiedState
        parkingSpace.setState(new OccupiedState());
        
        // Verify that the state has changed to OccupiedState
        assertTrue(parkingSpace.getState() instanceof OccupiedState);
        
        // Set the state to DisabledState
        parkingSpace.setState(new DisabledState());
        
        // Verify that the state has changed to DisabledState
        assertTrue(parkingSpace.getState() instanceof DisabledState);
        
        // Set the state back to AvailableState
        parkingSpace.setState(new AvailableState());
        
        // Verify that the state has changed back to AvailableState
        assertTrue(parkingSpace.getState() instanceof AvailableState);
    }
    @Test
    void testFree() {
        // Create a new ParkingSpace and occupy it
        ParkingSpace parkingSpace = new ParkingSpace("A1", 10.0);
        parkingSpace.occupy("ABC123");
        
        // Verify that the parking space is booked
        assertTrue(parkingSpace.isBooked());
        assertTrue(parkingSpace.getState() instanceof OccupiedState);
        
        // Free the parking space
        parkingSpace.free();
        
        // Verify that the parking space is now available
        assertFalse(parkingSpace.isBooked());
        assertTrue(parkingSpace.getState() instanceof AvailableState);
        assertNull(parkingSpace.getLicensePlate()); // License plate should be null after freeing
    }
    @Test
    void testSetOccupiedWithCar() {
        // Create a Car object
        Car car = new Car("ABC123", "Toyota", "Camry", "Blue");
        
        // Set the parking space as occupied with the car
        parkingSpace.setOccupied(true, car);
        
        // Verify that the license plate is set correctly
        assertEquals("ABC123", parkingSpace.getLicensePlate());
    }

    @Test
    void testSetOccupiedWithNullCar() {
        // Set the parking space as occupied with a null car
        parkingSpace.setOccupied(true, null);
        
        // Verify that the license plate is set to null
        assertNull(parkingSpace.getLicensePlate());
    }

    @Test
    void testObserverUpdateExceptionHandling() {
        // Setup the observer to throw an exception when updated
        doThrow(new RuntimeException("Observer error")).when(mockObserver).update(parkingSpace);
        
        // Attach the observer
        parkingSpace.attach(mockObserver);
        
        // Call a method that triggers notifyObservers
        parkingSpace.occupy("ABC123");
        
        // Verify that the exception was caught and handled
        // Since we are not throwing the exception, we just want to ensure that the test completes without failure
        assertTrue(true); // If we reach this point, it means the exception was handled
    }

    @Test
    void testOccupyWhenDisabled() {
        // Disable the parking space
        parkingSpace.disable();
        
        // Try to occupy the disabled parking space
        parkingSpace.occupy("ABC123");
        
        // Verify that the parking space is not booked
        assertFalse(parkingSpace.isBooked());
        assertTrue(parkingSpace.isDisabled());
    }

    @Test
    void testOccupyWhenAlreadyBooked() {
        // Occupy the parking space
        parkingSpace.occupy("ABC123");
        
        // Try to occupy the already booked parking space
        parkingSpace.occupy("XYZ789");
        
        // Verify that the parking space is still booked with the first car
        assertTrue(parkingSpace.isBooked());
        assertEquals("ABC123", parkingSpace.getLicensePlate());
    }
}