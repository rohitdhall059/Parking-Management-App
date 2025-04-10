package com.example.parking.iterator;

import java.util.List;

import com.example.parking.model.ParkingSpace;

public class ParkingSpaceIterator {
    private List<ParkingSpace> parkingSpaces;
    private int position;
    private boolean isEnabledOnly;

    public ParkingSpaceIterator(List<ParkingSpace> parkingSpaces, boolean isEnabledOnly) {
        this.parkingSpaces = parkingSpaces;
        this.position = 0;
        this.isEnabledOnly = isEnabledOnly;
    }

    public boolean hasNext() {
        while (position < parkingSpaces.size()) {
            ParkingSpace space = parkingSpaces.get(position);
            if (!isEnabledOnly || (isEnabledOnly && space.isEnabled())) {
                return true;
            }
            position++;
        }
        return false;
    }

    public ParkingSpace next() {
        ParkingSpace space = parkingSpaces.get(position);
        position++;
        return space;
    }
}