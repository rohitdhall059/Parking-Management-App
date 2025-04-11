package com.example.parking.model;

import java.util.List;

import com.example.parking.model.payment.PaymentMethod; // Ensure this package and class exist
import com.example.parking.strategy.PricingStrategy;
public abstract class Client {
    protected String email;
    protected String password;
    protected String name;
    protected String status; // Added status field
    protected PricingStrategy parkingRateStrategy;
    protected Car car; // Added car field
    protected List<Booking> bookings;
    protected PaymentMethod paymentMethod;
    protected String id; // Unique identifier for the client

    public Client(String email, String password, String name, String password2) {
        this.email = email;
        this.status = "ACTIVE";
        this.car = null;
    }

    public Client(String clientId, String name2, String email2, String password2, Object object, Object object2) {
        //TODO Auto-generated constructor stub
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
        this.status = status;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public abstract double getDiscountRate();
	
	public String getStatus() {
		return status;
	}

    public Object getPassword() {
        return password;
    }
} 