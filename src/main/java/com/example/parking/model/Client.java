package com.example.parking.model;

import java.util.List;

import com.example.parking.model.payment.PaymentMethod; // Ensure this package and class exist
import com.example.parking.strategy.PricingStrategy;

public abstract class Client {
    protected String email;
    protected String password;
    protected String name;
    protected String registrationStatus; // Added status field
    protected PricingStrategy parkingRateStrategy;
    protected Car car; // Added car field
    protected List<Booking> bookings;
    protected PaymentMethod paymentMethod;
    protected String id; // Unique identifier for the client

    public Client(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.registrationStatus = "ACTIVE";
        this.car = null;
    }

    public Client(String clientId, String name, String email, String password, 
                  PricingStrategy strategy, Car car) {
        this.id = clientId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.registrationStatus = "ACTIVE";
        this.parkingRateStrategy = strategy;
        this.car = car;
    }

    public Client(String clientId, String name, String email, String password) {
        this.id = clientId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setParkingRateStrategy(PricingStrategy strategy) {
        this.parkingRateStrategy = strategy;
    }

    public void setStatus(String status) {
        registrationStatus = status;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public abstract double getDiscountRate();

    public String getStatus() {
        return registrationStatus;
    }

    public Object getPassword() {
        return password;
    }
}