package com.example.parking.strategy;

public class VisitorPricing implements PricingStrategy {
    private static final double RATE = 15.0;  // Update to $15 per hour as expected

    @Override
    public double getRate() {
        return RATE;
    }

    @Override
    public String getType() {
        return "VISITOR";
    }

    public void setRate(double d) {
        throw new UnsupportedOperationException("Value cannot be modified");
    }
}