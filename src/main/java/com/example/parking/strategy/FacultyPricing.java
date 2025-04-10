package com.example.parking.model.pricing;

import com.example.parking.strategy.PricingStrategy;

public class FacultyPricing implements PricingStrategy {
    private static final double RATE = 2.0; // $2 per hour for faculty members

    @Override
    public double getRate() {
        return RATE;
    }
} 