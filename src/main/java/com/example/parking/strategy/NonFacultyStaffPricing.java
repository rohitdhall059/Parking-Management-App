package com.example.parking.strategy;

public class NonFacultyStaffPricing implements PricingStrategy {
    private static final double RATE = 10.0; 

    @Override
    public double getRate() {
        return RATE;
    }

    @Override
    public String getType() {
        return "NON_FACULTY_STAFF";
    }
} 