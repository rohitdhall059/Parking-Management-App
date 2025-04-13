package com.example.parking.state;
import com.example.parking.model.Car;
import com.example.parking.model.ParkingSpace;

public class AvailableState implements ParkingSpaceState {
    @Override
    public void occupy(ParkingSpace space, String licensePlate) {
        if (space.isOccupied()) {
            System.out.println("Parking space " + space.getId() + " is already occupied.");
            return;
        }
        if (!space.isDisabled()) {
            space.setOccupied(true, new Car(licensePlate));
            space.setState(new OccupiedState());
            System.out.println("Parking space " + space.getId() + " is now occupied by car with license plate: " + licensePlate);
        } else {
            System.out.println("Cannot occupy disabled parking space " + space.getId());
        }
    }

    @Override
    public void vacate(ParkingSpace space) {
        if (space.isOccupied()) {
            space.setOccupied(false, null); // Vacate the space
            space.setState(new AvailableState()); // Set state to Available
            System.out.println("Parking space " + space.getId() + " is now vacated.");
        } else {
            System.out.println("Parking space " + space.getId() + " is already available.");
    }
}

    @Override
    public void enable(ParkingSpace space) {
        System.out.println("Parking space " + space.getId() + " is already enabled.");
    }

    @Override
    public void disable(ParkingSpace space) {
        if (!space.isEnabled()) {
            System.out.println("Parking space " + space.getId() + " is already disabled.");
            return;
        }
        space.setEnabled(false);
        space.setState(new DisabledState());
        System.out.println("Parking space " + space.getId() + " has been disabled.");
    }
}