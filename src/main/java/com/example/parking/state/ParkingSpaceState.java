package com.example.parking.state;
import com.example.parking.model.ParkingSpace;
public interface ParkingSpaceState {
    void occupy(ParkingSpace space, String licensePlate);
    void vacate(ParkingSpace space);
    void enable(ParkingSpace space);
    void disable(ParkingSpace space);
} 