package com.example.parking.model.pricing;

import com.example.parking.strategy.PricingStrategy;

public class FacultyMemberPricing implements PricingStrategy {
    @Override
    public double getRate() {
        return 8.0;
    }
}