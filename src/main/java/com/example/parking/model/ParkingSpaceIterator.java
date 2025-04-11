package com.example.parking.model;

import java.util.HashMap;
import java.util.Map;

public class ParkingSpaceIterator {
    private static ParkingSpaceIterator instance;
    private Map<String, ParkingSpace> parkingSpaces;

    private ParkingSpaceIterator() {
        parkingSpaces = new HashMap<>();
    }

    public static ParkingSpaceIterator getInstance() {
        if (instance == null) {
            instance = new ParkingSpaceIterator();
        }
        return instance;
    }

    public void addParkingSpace(ParkingSpace space) {
        parkingSpaces.put(space.getId(), space);
    }

    public ParkingSpace getParkingSpace(String spaceId) {
        return parkingSpaces.get(spaceId);
    }

    public void removeParkingSpace(String spaceId) {
        parkingSpaces.remove(spaceId);
    }

    public Map<String, ParkingSpace> getAllParkingSpaces() {
        return new HashMap<>(parkingSpaces);
    }
} 