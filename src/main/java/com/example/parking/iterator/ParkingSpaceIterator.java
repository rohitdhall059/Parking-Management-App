package com.example.parking.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.HashMap;
import com.example.parking.model.ParkingSpace;

public class ParkingSpaceIterator implements Iterator<ParkingSpace> {
    private List<ParkingSpace> parking; // List of parking spaces
    private int position; // Current position in the list
    private boolean isEnabledOnly; // Flag to filter enabled spaces
    private static ParkingSpaceIterator instance; // Singleton instance
    private Map<String, ParkingSpace> parkingSpaces; // Map of parking spaces

    // Private constructor for singleton
    private ParkingSpaceIterator() {
        parkingSpaces = new HashMap<>();
    }

    // Singleton instance getter
    public static ParkingSpaceIterator getInstance() {
        if (instance == null) {
            instance = new ParkingSpaceIterator();
        }
        return instance;
    }

    // Method to add a parking space to the map
    public void addParkingSpace(ParkingSpace space) {
        parkingSpaces.put(space.getId(), space);
    }

    // Method to get a parking space by ID
    public ParkingSpace getParkingSpace(String spaceId) {
        return parkingSpaces.get(spaceId);
    }

    // Method to remove a parking space by ID
    public void removeParkingSpace(String spaceId) {
        parkingSpaces.remove(spaceId);
    }

    // Method to get all parking spaces
    public Map<String, ParkingSpace> getAllParkingSpaces() {
        return new HashMap<>(parkingSpaces);
    }

    // Constructor for iterating over a list of parking spaces
    public ParkingSpaceIterator(List<ParkingSpace> parkingSpaces, boolean isEnabledOnly) {
        this.parking = parkingSpaces;
        this.position = 0;
        this.isEnabledOnly = isEnabledOnly;
    }

    // Check if there is a next parking space
    @Override
    public boolean hasNext() {
        while (position < parking.size()) {
            ParkingSpace space = parking.get(position);
            if (!isEnabledOnly || (isEnabledOnly && space.isEnabled())) {
                return true;
            }
            position++;
        }
        return false;
    }

    // Get the next parking space
    @Override
    public ParkingSpace next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return parking.get(position++);
    }
}