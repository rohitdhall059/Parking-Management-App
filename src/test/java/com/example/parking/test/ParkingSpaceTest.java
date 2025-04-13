package com.example.parking.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.parking.model.ParkingSpace;
import com.example.parking.model.Sensor;


class ParkingSpaceTest {

    private ParkingSpace parkingSpace;

    @BeforeEach
    void setUp() {
        parkingSpace = new ParkingSpace("A1", 10.0);
    }

    @Test
    void test1_initialState() {
        assertFalse(parkingSpace.isBooked());
        assertTrue(parkingSpace.isDisabled());
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
        Sensor sensor = new Sensor("Sensor1", parkingSpace);
        parkingSpace.attach(sensor);
        assertEquals(1, parkingSpace.getObservers().size());
    }

    @Test
    void test9_detachObserver() {
        Sensor sensor = new Sensor("Sensor1", parkingSpace);
        parkingSpace.attach(sensor);
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
}