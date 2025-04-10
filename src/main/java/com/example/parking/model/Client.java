package com.example.parking.model;

import com.example.parking.model.Car;
import com.example.parking.strategy.ParkingRateStrategy;
import com.example.parking.model.payment.PaymentMethod;
import java.util.List;
public abstract class Client {
    protected String email;
    protected String password;
    protected String name;
    protected ParkingRateStrategy parkingRateStrategy;
    protected List<Booking> bookings;
    protected PaymentMethod paymentMethod;

    public Client(String email, String password, String name, ParkingRateStrategy parkingRateStrategy) {
        this.email = email;
        this.status = "ACTIVE";
        this.car = null;
    }

    public Client(String clientId, String name2, String email2, String password, Object object, String string) {
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

    public void setParkingRateStrategy(ParkingRateStrategy strategy) {
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
} 