package com.example.parking.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.example.parking.model.Car;
import com.example.parking.model.ParkingSpace;
import com.example.parking.state.AvailableState;
import com.example.parking.state.BookedState; 
import com.example.parking.state.DisabledState;
import com.example.parking.state.OccupiedState;
public class StateTest {
   public static class TestParkingSpace extends ParkingSpace {
    private boolean enabledFlag;

    public TestParkingSpace(String spaceId, double rate) {
        super(spaceId, rate);
        this.enabledFlag = true;
    }

    @Override
    public void setEnabled(boolean b) {
        this.enabledFlag = b;
    }

    public boolean isEnabledFlag() {
        return enabledFlag;
    }
}

@Test
public void testOccupiedStateOccupy() {
    TestParkingSpace space = new TestParkingSpace("PS1", 10.0);
    space.setOccupied(true, new Car("ABC123"));
    space.setState(new OccupiedState());
    ((OccupiedState) space.getState()).occupy(space, "XYZ789");
    assertEquals("ABC123", space.getLicensePlate());
    assertTrue(space.getState() instanceof OccupiedState);
}

@Test
public void testOccupiedStateVacate() {
    TestParkingSpace space = new TestParkingSpace("PS2", 10.0);
    space.setOccupied(true, new Car("ABC123"));
    space.setState(new OccupiedState());
    ((OccupiedState) space.getState()).vacate(space);
    assertFalse(space.isBooked());
    assertNull(space.getLicensePlate());
    assertTrue(space.getState() instanceof AvailableState);
}

@Test
public void testOccupiedStateEnable() {
    TestParkingSpace space = new TestParkingSpace("PS3", 10.0);
    space.setOccupied(true, new Car("ABC123"));
    space.setState(new OccupiedState());
    ((OccupiedState) space.getState()).enable(space);
    assertTrue(space.getState() instanceof OccupiedState);
}

@Test
public void testOccupiedStateDisable() {
    TestParkingSpace space = new TestParkingSpace("PS4", 10.0);
    space.setOccupied(true, new Car("ABC123"));
    space.setState(new OccupiedState());
    ((OccupiedState) space.getState()).disable(space);
    assertTrue(space.getState() instanceof DisabledState);
}

@Test
public void testBookedStateOccupy() {
    TestParkingSpace space = new TestParkingSpace("PS5", 10.0);
    space.setOccupied(true, new Car("ABC123"));
    space.setState(new BookedState());
    ((BookedState) space.getState()).occupy(space, "XYZ789");
    assertEquals("ABC123", space.getLicensePlate());
    assertTrue(space.getState() instanceof BookedState);
}

@Test
public void testBookedStateVacate() {
    TestParkingSpace space = new TestParkingSpace("PS6", 10.0);
    space.setOccupied(true, new Car("ABC123"));
    space.setState(new BookedState());
    ((BookedState) space.getState()).vacate(space);
    assertFalse(space.isBooked());
    assertNull(space.getLicensePlate());
    assertTrue(space.getState() instanceof AvailableState);
}

@Test
public void testBookedStateEnable() {
    TestParkingSpace space = new TestParkingSpace("PS7", 10.0);
    space.setOccupied(true, new Car("ABC123"));
    space.setState(new BookedState());
    ((BookedState) space.getState()).enable(space);
    assertTrue(space.getState() instanceof BookedState);
}

@Test
public void testBookedStateDisable() {
    TestParkingSpace space = new TestParkingSpace("PS8", 10.0);
    space.setOccupied(true, new Car("ABC123"));
    space.setState(new BookedState());
    ((BookedState) space.getState()).disable(space);
    assertFalse(space.isEnabledFlag());
    assertTrue(space.getState() instanceof DisabledState);
}

@Test
public void testDisabledStateOccupy() {
    TestParkingSpace space = new TestParkingSpace("PS9", 10.0);
    space.setOccupied(false, null);
    space.setState(new DisabledState());
    ((DisabledState) space.getState()).occupy(space, "XYZ789");
    assertFalse(space.isBooked());
    assertNull(space.getLicensePlate());
    assertTrue(space.getState() instanceof DisabledState);
}

@Test
public void testDisabledStateEnable() {
    TestParkingSpace space = new TestParkingSpace("PS10", 10.0);
    space.setEnabled(false);
    space.setState(new DisabledState());
    ((DisabledState) space.getState()).enable(space);
    assertTrue(space.isEnabledFlag());
    assertTrue(space.getState() instanceof AvailableState);
}

}
