package com.example.parking.strategy;

public class VisitorPricing implements PricingStrategy {
    private static final double RATE = 15.0; 

    @Override
    public double getRate() {
        return RATE;
    }

    @Override
    public String getType() {
        return "VISITOR";
    }

    public void setRate(double d) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setRate'");
    }
} 