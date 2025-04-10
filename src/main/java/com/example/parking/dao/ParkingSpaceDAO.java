package com.example.parking.dao;

import com.example.parking.model.ParkingSpace;
import java.util.List;

public interface ParkingSpaceDAO {
    ParkingSpace getById(String id);
    void delete(String id);
    List<ParkingSpace> getAll();
    void update(ParkingSpace parkingSpace);
    void save(ParkingSpace parkingSpace);
    List<ParkingSpace> getAllParkingSpaces();
}