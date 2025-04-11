package com.example.parking.tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.parking.model.Car;
import com.example.parking.model.Client;
import com.example.parking.strategy.PricingStrategy;
    
class ClientTest {
    // A concrete subclass of Client for testing purposes.
static class TestClient extends Client {
    private double discountRate;
    private PricingStrategy parkingStrategy; // to verify the setter
    // Expose the registration status for testing.
    public String getRegistrationStatus() {
        return registrationStatus;
    }

    // Constructor using the primary Client constructor.
    TestClient(String email, String password, String name, double discountRate) {
        super(email, password, name, password);
        this.discountRate = discountRate;
    }

    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    // Override the setParkingRateStrategy to also retain the strategy locally.
    @Override
    public void setParkingRateStrategy(PricingStrategy strategy) {
        super.setParkingRateStrategy(strategy);
        this.parkingStrategy = strategy;
    }

    public PricingStrategy getParkingRateStrategy() {
        return parkingStrategy;
    }

    // For testing, we add a setter for id.
    public void setId(String id) {
        this.id = id;
    }
}

// A simple dummy implementation of PricingStrategy.
static class DummyPricingStrategy implements PricingStrategy {
    private double rate;

    DummyPricingStrategy(double rate) {
        this.rate = rate;
    }

    // For testing, we implement a getRate method.
    public double getRate() {
        return rate;
    }

    // Implement the required getType method from PricingStrategy interface.
    @Override
    public String getType() {
        return "Dummy";
    }
}

private TestClient client;

@BeforeEach
void setUp() {
    // Construct a TestClient instance with test parameters.
    client = new TestClient("testuser@example.com", "secretPass", "Test User", 15.0);
}

// Test 1: Verify that the client email is correctly returned.
@Test
void testGetEmail() {
    assertEquals("testuser@example.com", client.getEmail());
}

// Test 2: Verify that the client name is correctly returned.
@Test
void testGetName() {
    assertEquals("Test User", client.getName());
}

// Test 3: Verify that the default registration status is set to "ACTIVE".
@Test
void testDefaultRegistrationStatus() {
    // The constructor sets registrationStatus to "ACTIVE"
    assertEquals("ACTIVE", client.getRegistrationStatus());
}

// Test 4: Verify that the client password is correctly returned.
@Test
void testGetPassword() {
    assertEquals("secretPass", client.getPassword());
}

// Test 5: Verify that the client's car is null by default.
@Test
void testDefaultCarIsNull() {
    assertNull(client.getCar(), "Car should be null by default.");
}

// Test 6: Verify that setting a Car updates the client's car.
@Test
void testSetCar() {
    // Create a new Car instance (using available constructor from Car.java)
    Car testCar = new Car("ABC123", "Toyota", "Camry", "Blue");
    client.setCar(testCar);
    assertNotNull(client.getCar());
    assertEquals("ABC123", client.getCar().getLicensePlate());
}

// Test 7: Verify that updating registration status works correctly.
@Test
void testSetStatus() {
    client.setStatus("INACTIVE");
    assertEquals("INACTIVE", client.getRegistrationStatus());
}

// Test 8: Verify that getDiscountRate returns the expected discount rate.
@Test
void testGetDiscountRate() {
    // TestClient was constructed with discount rate = 15.0
    assertEquals(15.0, client.getDiscountRate());
}

// Test 9: Verify that setParkingRateStrategy correctly stores the strategy.
@Test
void testSetParkingRateStrategy() {
    DummyPricingStrategy strategy = new DummyPricingStrategy(2.5);
    client.setParkingRateStrategy(strategy);
    assertNotNull(client.getParkingRateStrategy());
    // Downcast to DummyPricingStrategy to access getRate()
    DummyPricingStrategy ds = (DummyPricingStrategy) client.getParkingRateStrategy();
    assertEquals(2.5, ds.getRate());
}

// Test 10: Verify that setting and getting client id works correctly.
@Test
void testSetAndGetId() {
    assertNull(client.getId(), "Initial id should be null.");
    client.setId("client-001");
    assertEquals("client-001", client.getId());
}

}
