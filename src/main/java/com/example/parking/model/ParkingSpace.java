package com.example.parking.model;

import java.util.ArrayList;
import java.util.List;

import com.example.parking.observer.Observer;
import com.example.parking.state.AvailableState;
import com.example.parking.state.DisabledState;
import com.example.parking.state.OccupiedState;
import com.example.parking.state.ParkingSpaceState;

public class ParkingSpace {
    private String spaceId;
    private boolean isBooked;
    private boolean isDisabled;
    private double rate;
    private String licensePlate;
    private List<Observer> observers;
    private ParkingSpaceState state;

    public ParkingSpace(String spaceId, double rate) {
        if (spaceId == null || spaceId.isEmpty()) {
            throw new IllegalArgumentException("Space ID cannot be null or empty");
        }
        if (rate < 0) {
            throw new IllegalArgumentException("Rate cannot be negative");
        }
        this.spaceId = spaceId;
        this.rate = rate;
        this.isBooked = false;
        this.isDisabled = false; // Default to enabled
        this.observers = new ArrayList<>();
        this.state = new AvailableState();
    }
    
    // Observer methods
    public void attach(Observer observer) {
        observers.add(observer);
        notifyObservers();
    }

    public void detach(Observer observer) {
        observers.remove(observer);
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            try {
                observer.update(this);
            } catch (Exception e) {
                // Log the exception or handle it as needed
                System.err.println("Observer update failed: " + e.getMessage());
            }
        }
    }

    public void enable() {
        if (isDisabled) {
            this.isDisabled = false;
            this.state = new AvailableState();
            notifyObservers(); // Notify observers when enabling
        }
    }
    
    public void disable() {
        if (!isDisabled) {
            this.isDisabled = true;
            this.isBooked = false;
            this.licensePlate = null;
            this.state = new DisabledState();
            notifyObservers(); // Notify observers when disabling
        }
    }
    
    public void occupy(String licensePlate) {
        if (!isDisabled && !isBooked) { // Only occupy if not disabled and not booked
            this.isBooked = true;
            this.licensePlate = licensePlate;
            this.state = new OccupiedState();
            notifyObservers(); // Notify observers when occupying
        }
    }
    
    public void vacate() {
        if (isBooked) {
            this.isBooked = false;
            this.licensePlate = null;
            this.state = new AvailableState();
            notifyObservers(); // Notify observers when vacating
        }
    }

    // Getters/Setters
    public String getSpaceId() {
        return spaceId;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public boolean isOccupied() {
        return isBooked;
    }

    public boolean isDisabled() {
        return isDisabled;
    }
    
    public boolean isEnabled() {
        return !isDisabled;
    }

    public double getRate() {
        return rate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public ParkingSpaceState getState() {
        return state;
    }

    @Override
    public String toString() {
        return "ParkingSpace{" +
                "spaceId='" + spaceId + '\'' +
                ", isBooked=" + isBooked +
                ", isDisabled=" + isDisabled +
                ", rate=" + rate +
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }
    
    // Method to retrieve status as a string
    public String getStatus() {
        return isDisabled ? "Disabled" : (isBooked ? "Occupied" : "Available");
    }

    public void setState(ParkingSpaceState state) {
        this.state = state;
    }

    public void setOccupied(boolean occupied, Car car) {
        this.isBooked = occupied;
        if (car != null){
            this.licensePlate = car.getLicensePlate();
        } else {
            this.licensePlate = null;
        }
        notifyObservers();
    }

    public void setRate(double rate) {
        this.rate = rate;
        notifyObservers();
    }

    public String getCarInfo() {
        return isBooked ? "Car with license plate: " + licensePlate : "No car";
    }

    public String getId() {
        return spaceId;
    }

    public void free() {
        this.isBooked = false;
        this.licensePlate = null;
        this.state = new AvailableState();
        notifyObservers();
    }

    public void setEnabled(boolean enabled) {
        this.isDisabled = !enabled; // Set disabled state based on the enabled parameter
        if (enabled) {
            this.state = new AvailableState();
        } else {
            this.state = new DisabledState();
        }
        notifyObservers();
    }

    public List<Observer> getObservers() {
        return observers; // Assuming 'observers' is the list of observers in ParkingSpace
    }
    public void clearObservers() {
        observers.clear();
    }
}