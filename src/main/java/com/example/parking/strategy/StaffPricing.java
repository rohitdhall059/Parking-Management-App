package com.example.parking.model.pricing;
import com.example.parking.strategy.PricingStrategy;

public class StaffPricing implements PricingStrategy {
    private static final double RATE = 3.0; // $3 per hour

    @Override
    public double getRate() {
        return RATE;
    }

    @Override
    public String getType() {
        return "STAFF";
    }
} 