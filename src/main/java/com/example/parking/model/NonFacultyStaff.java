package com.example.parking.model;

import com.example.parking.observer.Observer;
import com.example.parking.strategy.NonFacultyStaffPricing;
/**
 * Represents non-faculty staff, extending the base Client class.
 */
public class NonFacultyStaff extends Client implements Observer {
    private String staffId;
    private String office;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public NonFacultyStaff(String clientId, String name, String email, String password,
                           String staffId, String office) {
        super(clientId, name, email, password);
        this.staffId = staffId;
        this.office = office;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public double getParkingRate() {
        NonFacultyStaffPricing pricing = new NonFacultyStaffPricing();
        return pricing.getRate();
    }
    @Override
    public void update(ParkingSpace parkingSpace) {
        String status = parkingSpace.isOccupied() ? "occupied" : "available";
        System.out.println("NonFacultyStaff " + getName() + ": Parking space " + parkingSpace.getSpaceId() + " status changed to " + status);
        if (parkingSpace.isOccupied()) {
            System.out.println("Details: " + parkingSpace.getCarInfo());
        }
    }
    @Override
    public double getDiscountRate() {
        // Provide a specific discount rate for NonFacultyStaff
        return 0.1; // Example discount rate
    }

    @Override
    public String toString() {
        return "NonFacultyStaff{" +
                "staffId='" + staffId + '\'' +
                ", office='" + office + '\'' +
                ", " + super.toString() +
                '}';
    }
}