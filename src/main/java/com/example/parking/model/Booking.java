package com.example.parking.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.example.parking.factory.PaymentMethodFactory;
import com.example.parking.factory.PricingStrategyFactory;
import com.example.parking.model.payment.PaymentMethod;
import com.example.parking.strategy.PricingStrategy;

public class Booking {
    private String bookingId;
    private Client client; // Direct reference to Client object
    private ParkingSpace spaceId;  // Holds a ParkingSpace reference
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double totalCost;
    private PaymentMethod paymentMethod;
    private double deposit = 10.0; // Default deposit amount
    private String status;
    private String licensePlate;

    public Booking(String bookingId, Client client, ParkingSpace space, LocalDateTime startTime, LocalDateTime endTime, PaymentMethod paymentMethod) {
        this.bookingId = bookingId;
        this.client = client; // Assigning Client object directly
        this.spaceId = space; // Assigning ParkingSpace directly
        this.startTime = startTime;
        this.endTime = endTime;
        this.paymentMethod = paymentMethod;
        this.status = "Active"; // Default status
    }

    // Getters/Setters
    public String getBookingId() { return bookingId; }
    public void setBookingId(String bookingId) { this.bookingId = bookingId; }

    public Client getClient() { return client; } // Getter for Client
    public String getClientId() { return client.getId(); } 
    public void setClient(Client client) { this.client = client; } // Setter for Client

    public String getClientId() { return client.getId(); }

    public ParkingSpace getSpaceId() { return spaceId; }
    public void setSpaceId(ParkingSpace spaceId) { this.spaceId = spaceId; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public double getTotalCost() { return totalCost; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }

    public PaymentMethod getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(PaymentMethod paymentMethod) { this.paymentMethod = paymentMethod; }

    public double getDeposit() { return deposit; }
    public void setDeposit(double deposit) { this.deposit = deposit; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    //New method to get the ParkingSpace
    public ParkingSpace getParkingSpace() { return spaceId; }

    public String getLicensePlate() {
        return licensePlate;
    }
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString() {
        return "Booking {" + "bookingID = '" + bookingId + '\'' + ", clientID = '" + client.getId() + '\'' + ", spaceID = '" + spaceId.getId() + '\'' + ", startTime = " + startTime + ", endTime = " + endTime + ", totalCost = " + totalCost + '}';
    }

    // Method to create a booking
    public static Booking createBooking(String bookingId, Client client, ParkingSpace space, LocalDateTime startTime, LocalDateTime endTime, String clientType) {
        if (startTime.isAfter(endTime)) {
            throw new IllegalArgumentException("Start time must be before end time.");
        }
        PricingStrategy pricingStrategy = (PricingStrategy) PricingStrategyFactory.getPricingStrategy(clientType);
        long hours = ChronoUnit.HOURS.between(startTime, endTime);
        double totalCost = hours * pricingStrategy.getRate();
        PaymentMethod defaultPaymentMethod = PaymentMethodFactory.getDefaultPaymentMethod(); // Assuming a factory method for default PaymentMethod
        Booking booking = new Booking(bookingId, client, space, startTime, endTime, defaultPaymentMethod);
        booking.setTotalCost(totalCost);
        return booking;
    }

    // Method to checkout
    public void checkout() {
        System.out.println("Checking out booking: " + bookingId);
        totalCost -= deposit;
        System.out.println("Total cost after deducting deposit: " + totalCost);
        this.status = "Checked Out"; // Update status
    }

    // Method to calculate refund based on time remaining
    public double calculateRefund() {
        long minutesLeft = ChronoUnit.MINUTES.between(LocalDateTime.now(), endTime);
        if (minutesLeft > 0) {
            double refundAmount = (totalCost / ChronoUnit.MINUTES.between(startTime, endTime)) * minutesLeft;
            return refundAmount;
        }
        return 0.0;
    }

    // Method to extend parking time
    public void extendParkingTime(LocalDateTime newEndTime, String clientType) {
        if (newEndTime.isBefore(endTime)) {
            throw new IllegalArgumentException("New end time must be after the current end time.");
        }

        // Calculate additional cost
        long additionalHours = ChronoUnit.HOURS.between(endTime, newEndTime);
        PricingStrategy pricingStrategy = (PricingStrategy) PricingStrategyFactory.getPricingStrategy(clientType);
        double additionalCost = additionalHours * pricingStrategy.getRate();

        // Update the end time and total cost
        this.endTime = newEndTime;
        this.totalCost += additionalCost;

        System.out.println("Parking time extended to: " + newEndTime);
        System.out.println("New total cost: " + this.totalCost);
    }

    public void cancelBooking() {
        // Logic to handle payment refunds
        long minutesSinceStart = ChronoUnit.MINUTES.between(startTime, LocalDateTime.now());
        if (minutesSinceStart < 60) {
            System.out.println("No refund for the deposit as the client is a no-show within the first hour.");
        } else {
            double refundAmount = calculateRefund();
            if (refundAmount > 0) {
                processRefund(refundAmount);
                System.out.println("Refund of " + refundAmount + " processed for booking: " + bookingId);
            } else {
                System.out.println("No refund applicable for booking: " + bookingId);
            }
        }

        System.out.println("Booking canceled: " + bookingId);
        this.status = "Canceled"; // Update status
    }

    // Method to process payment
    public void processPayment(double amount) {
        if (paymentMethod != null) {
            paymentMethod.processPayment(amount);
            System.out.println("Payment of " + amount + " processed for booking: " + bookingId);
        } else {
            System.out.println("No payment method set for this booking.");
        }
    }

    // Method to process Refund
    public void processRefund(double amount) {
        if (paymentMethod != null) {
            paymentMethod.processRefund(amount);
            System.out.println("Refund of " + amount + " processed for booking: " + bookingId);
        } else {
            System.out.println("No payment method set for this booking. Cannot process refund.");
        }
    }

    public void setAmount(double amount) {
        this.totalCost = amount;
    }

    public double getAmount() {
        return this.totalCost;
    }

    public void setOccupied(boolean occupied, Car car) {
        this.spaceId.setOccupied(occupied, car);
    }
}