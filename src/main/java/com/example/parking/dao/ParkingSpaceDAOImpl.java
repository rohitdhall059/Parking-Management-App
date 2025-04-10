package com.example.parking.dao;

import com.example.parking.model.ParkingSpace;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of ParkingSpaceDAO.
 */
public class ParkingSpaceDAOImpl implements ParkingSpaceDAO {

    @Override
    public ParkingSpace getById(String id) {
        return parkingSpaces.stream()
                .filter(space -> space.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(String id) {
        parkingSpaces.removeIf(space -> space.getId().equals(id));
    }

    @Override
    public List<ParkingSpace> getAll() {
        return new ArrayList<>(parkingSpaces);
    }

    @Override
    public void update(ParkingSpace parkingSpace) {
        for (int i = 0; i < parkingSpaces.size(); i++) {
            if (parkingSpaces.get(i).getId().equals(parkingSpace.getId())) {
                parkingSpaces.set(i, parkingSpace);
                return;
            }
        }
    }

    @Override
    public void save(ParkingSpace parkingSpace) {
        parkingSpaces.add(parkingSpace);
    }

    private final List<ParkingSpace> parkingSpaces = new ArrayList<>();

    @Override
    public List<ParkingSpace> getAllParkingSpaces() {
        return new ArrayList<>(parkingSpaces);
    }

    public ParkingSpace getParkingSpaceById(String id) {
        return parkingSpaces.stream()
                .filter(space -> space.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addParkingSpace(ParkingSpace parkingSpace) {
        parkingSpaces.add(parkingSpace);
    }
}