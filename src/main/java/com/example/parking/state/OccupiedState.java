package com.example.parking.state;
import com.example.parking.model.ParkingSpace;
public class OccupiedState implements ParkingSpaceState {
    @Override
    public void occupy(ParkingSpace space, String licensePlate) {
        System.out.println("Parking space " + space.getId() + " is already occupied by car with license plate: " + space.getLicensePlate());
    }

    @Override
    public void vacate(ParkingSpace space) {
        space.setOccupied(false, null);
        space.setState(new AvailableState());
        System.out.println("Parking space " + space.getId() + " is now available.");
    }

    @Override
    public void enable(ParkingSpace space) {
        System.out.println("Parking space " + space.getId() + " is already enabled.");
    }

    @Override
    public void disable(ParkingSpace space) {
        space.setState(new DisabledState());
        System.out.println("Parking space " + space.getId() + " has been disabled.");
    }
}