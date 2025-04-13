package com.example.parking.model;
import java.util.Date;

import com.example.parking.observer.Observer;
import com.example.parking.strategy.VisitorPricing; // Import VisitorPricing if it exists in this package
/**
 * Represents a visitor client, extending the base Client class.
 */
public class Visitor extends Client implements Observer {
    private String visitInformation;
    private String visitorId;
    private Date visitDate;

    public Visitor(String clientId, String name, String email, String password,
                   String visitInformation, String visitorId) {
        super(clientId, name, email, password); // Initialize with null car and pricing strategy
        this.visitInformation = visitInformation;
        this.visitorId = visitorId;
    }

    public String getVisitInformation() {
        return visitInformation;
    }

    public void setVisitInformation(String visitInformation) {
        this.visitInformation = visitInformation;
    }
    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public Date getVisitDate() {  // Getter for visitDate
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {  // Setter for visitDate
        this.visitDate = visitDate;
    }

    public double getParkingRate() {
        VisitorPricing visitorPricing = new VisitorPricing();
        return visitorPricing.getRate();
    }

    @Override
    public void update(ParkingSpace parkingSpace) {
        // Handle the parking space update notification
        String status = parkingSpace.isBooked()? "occupied" : "available";
        System.out.println("Visitor " + name + ": Parking space status changed to " + status);
        if (parkingSpace.isBooked()) {
            System.out.println("Details: " + parkingSpace.getCarInfo());
        }
    }
    @Override
    public double getDiscountRate() {
        return 0.0; // Example: 10% discount
    }

    @Override
    public String toString() {
        return "Visitor{Name=" + name+
                ", visitInformation='" + visitInformation + '\'' +
                ", visitorId='" + visitorId + '\'' +
                ", visitDate=" + visitDate +
                ", " + super.toString() +
                '}';
    }
    @Override
    public String getType() {
        return "VISITOR"; // Return a string that identifies the type
    }
}