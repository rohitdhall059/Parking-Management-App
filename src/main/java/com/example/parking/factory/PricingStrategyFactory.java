package com.example.parking.factory;

import com.example.parking.strategy.PricingStrategy;
import com.example.parking.pricing.*;




public class PricingStrategyFactory {
    public static PricingStrategy getPricingStrategy(String clientType) {
        switch (clientType.toLowerCase()) {
            case "student":
                return new StudentPricing();
            case "visitor":
                return new VisitorPricing();
            case "facultystaff":
                return new FacultyStaffPricing();
            case "nonfacultystaff":
                return new NonFacultyStaffPricing();
            // Add other cases for different client types as needed
            default:
                throw new IllegalArgumentException("Unknown client type: " + clientType);
        }
    }
}