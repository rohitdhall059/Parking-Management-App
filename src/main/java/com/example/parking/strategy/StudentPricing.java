package com.example.parking.strategy;

public class StudentPricing implements PricingStrategy {
    private static final double RATE = 5.0; 
    
    

    @Override
    public double getRate() {
        return RATE;
    }

    @Override
    public String getType() {
        return "STUDENT";
    }
    // Removed setRate method as RATE is a static final constant and cannot be reassigned.
} 