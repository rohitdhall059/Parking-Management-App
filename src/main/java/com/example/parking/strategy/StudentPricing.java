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
} 