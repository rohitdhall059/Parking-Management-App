package com.example.parking.factory;

import com.example.parking.strategy.FacultyPricing;
import com.example.parking.strategy.NonFacultyStaffPricing;
import com.example.parking.strategy.PricingStrategy;
import com.example.parking.strategy.StudentPricing;
import com.example.parking.strategy.VisitorPricing;

public class PricingStrategyFactory {

    public static PricingStrategy getPricingStrategy(String clientType) {
        if (clientType == null || clientType.trim().isEmpty()) {
            throw new IllegalArgumentException("Client type cannot be null or empty");
        }
        switch (clientType.trim().toLowerCase()) {
            case "student":
                return new StudentPricing();
            case "visitor":
                return (PricingStrategy) new VisitorPricing();
            case "faculty":
                return (PricingStrategy) new FacultyPricing();
            case "non_faculty_staff":
                return (PricingStrategy) new NonFacultyStaffPricing();
            default:
                throw new IllegalArgumentException("Unknown client type: " + clientType);
        }
    }
}