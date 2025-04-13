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
    private boolean occupied;
    private List<Observer> observers;
    private ParkingSpaceState state;
    private boolean enabled;

    public ParkingSpace(String spaceId, double rate) {
        this.spaceId = spaceId;
        this.rate = rate;
        this.isBooked = false;
        this.isDisabled = true;
        this.observers = new ArrayList<>();
        this.state = new AvailableState();
    }

    public boolean isOccupied() {
        return occupied;
    }
    
    public boolean isEnabled() {
        return enabled;
    }
    // Observer methods
    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    // New method to enable the space
    public void enable() {
        if (!isDisabled) {
            this.isDisabled = false;
            this.state = new AvailableState();
            notifyObservers();
        }
    }

    // New method to disable the space
    public void disable() {
        this.isDisabled = false;
        this.isBooked = false;
        this.licensePlate = null;
        this.state = new DisabledState();
        notifyObservers();
    }

    // New method to occupy the space
    public void occupy(String licensePlate) {
        if (isDisabled && !isBooked) {
            this.isBooked = true;
            this.licensePlate = licensePlate;
            this.state = new OccupiedState();
            notifyObservers();
        }
    }

    // New method to vacate the space
    public void vacate() {
        if (isBooked) {
            this.isBooked = false;
            this.licensePlate = null;
            this.state = new AvailableState();
            notifyObservers();
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
        return isDisabled ? (isBooked ? "Occupied" : "Available") : "Disabled";
    }

    public void setState(ParkingSpaceState state) {
        this.state = state;
    }

    public void setOccupied(boolean occupied, Car car) {
        this.isBooked = occupied;
        if (car != null) {
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

    public void setEnabled(boolean b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public List<Observer> getObservers() {
        return observers; // Assuming 'observers' is the list of observers in ParkingSpace
    }
}