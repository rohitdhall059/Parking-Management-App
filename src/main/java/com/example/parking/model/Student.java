package com.example.parking.model;
import com.example.parking.observer.Observer;
import com.example.parking.strategy.StudentPricing;
/**
 * Represents a Student client. 
 * Extends the base Client class, adding specific fields like major/year.
 */
public class Student extends Client implements Observer {

    @Override
    public double getDiscountRate() {
        return 0.15; // Example: 15% discount
    }

    private String department;
    private String year;
    private String major;
    private String studentId;

    public Student(String clientId, String name, String email, String password, String studentId, String major, String year) {
        super(clientId, (name == null || name.equals("null")) ? null : name, 
              (email == null || email.equals("null")) ? null : email, password);
        this.studentId = studentId;
        this.major = major;
        this.department = major;
        this.year = year;
    }
    
    public String getMajor() { // Add getter for major
        return major;
    }
    
    public void setMajor(String major) { // Add setter for major
        this.major = major;
        this.department = major;
    }
   
    public String getDepartment() {
        return department;
    }
    
    public double getParkingRate() {
        StudentPricing pricing = new StudentPricing();
        return pricing.getRate();
    }

    public void setDepartment(String department) {
        this.department = department;
        this.major = department;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public boolean requiresValidation() {
        return studentId == null || studentId.isEmpty();
    }

    @Override
    public void update(ParkingSpace parkingSpace) {
        String status = parkingSpace.isBooked() ? "occupied" : "available";
        System.out.println("Student " + getName() + ": Parking space " + parkingSpace.getSpaceId() + " status changed to " + status);
        if (parkingSpace.isBooked()) {
            System.out.println("Details: " + parkingSpace.getCarInfo());
        }
    }
    @Override
    public String toString() {
        return "Student{Name= " + name+
                ", studentId='" + studentId + '\'' +
                ", department='" + department + '\'' +
                ", year='" + year + '\'' +
                ", " + super.toString() +
                '}';
    }
    @Override
    public String getType() {
        return "STUDENT"; // Return a string that identifies the type
    }
}