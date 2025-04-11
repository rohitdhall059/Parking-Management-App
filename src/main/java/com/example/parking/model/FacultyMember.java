package com.example.parking.model;
import com.example.parking.observer.Observer;
import com.example.parking.strategy.FacultyPricing;
/**
 * Represents a faculty client, extending the base Client class.
 */
public class FacultyMember extends Client implements Observer {
    private String department;
    private String facultyId;

    public FacultyMember(String clientId, String name, String email, String password,
                         String facultyId, String department) {
        super(clientId, name, email, password); // Adjusted to match the Client constructor
        this.department = department;
        this.facultyId = facultyId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public double getParkingRate() {
        FacultyPricing facultyPricing = new FacultyPricing();
        return facultyPricing.getRate();
    }
    
    public boolean requiresValidation() {
        return facultyId == null || facultyId.isEmpty();
    }


    @Override
    public void update(ParkingSpace parkingSpace) {
        String status = parkingSpace.isBooked() ? "occupied" : "available";
        System.out.println("Faculty " + getName() + ": Parking space " + parkingSpace.getSpaceId() + " status changed to " + status);
        if (parkingSpace.isBooked()) {
            System.out.println("Details: " + parkingSpace.getCarInfo());
        }
    }
    @Override
    public double getDiscountRate() {
        // Assuming faculty members get a fixed discount rate of 0.15 (15%)
        return 0.15;
    }

    @Override
    public String toString() {
        return "FacultyMember{" +
                "department='" + department + '\'' +
                ", facultyId='" + facultyId + '\'' +
                ", " + super.toString() +
                '}';
    }
}