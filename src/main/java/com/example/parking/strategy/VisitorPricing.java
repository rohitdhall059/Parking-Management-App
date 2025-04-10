package com.example.parking.model.pricing;
import com.example.parking.strategy.PricingStrategy;

public class VisitorPricing implements PricingStrategy {
    private static final double RATE = 5.0; // $5 per hour for visitors

    @Override
    public double getRate() {
        return RATE;
    }
}