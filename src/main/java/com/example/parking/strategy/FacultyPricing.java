package com.example.parking.strategy;

public class FacultyPricing implements PricingStrategy {
    private static final double RATE = 8.0; 

    @Override
    public double getRate() {
        return RATE;
    }

    @Override
    public String getType() {
        return "FACULTY";
    }

    public void setRate(double d) {
        throw new UnsupportedOperationException("Value cannot be modified");
    }
}