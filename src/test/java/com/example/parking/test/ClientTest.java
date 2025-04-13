package com.example.parking.test;

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

        // Constructor without setting the id initially.
        TestClient(String name, String email, String password, PricingStrategy strategy, Car car) {
            super(null, name, email, password, strategy, car);  // Pass null for clientId in constructor
            this.discountRate = 0.0; // Default discount rate
        }
        TestClient(String clientId, String name, String email, String password, PricingStrategy strategy, Car car) {
            super(clientId, name, email, password, strategy, car);
            this.discountRate = 0.0; // Default or you can pass it as a param if needed
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

        @Override
        public String getType() {
            return "TestClient"; // Mocked getType for the test
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
        client = new TestClient("C123", "Test User", "testuser@example.com", "password123", new DummyPricingStrategy(5.0), null);
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
        assertEquals("password123", client.getPassword());
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
        // TestClient was constructed with discount rate = 0.0
        assertEquals(0.0, client.getDiscountRate());
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
        // Initially set to "C123" in setup
        assertEquals("C123", client.getId(), "Initial ID should be C123");
        client.setId("client-001");
        assertEquals("client-001", client.getId());
    }


    // Test 11: Verify that constructor handles null values correctly for name and email.
    @Test
    void testClientConstructorWithNullValues() {
        // Test with null values for name and email
        String clientId = "C123";
        String name = null;  // Null value for name
        String email = null; // Null value for email
        String password = "password123";
        DummyPricingStrategy strategy = new DummyPricingStrategy(2.5); // Assuming a valid PricingStrategy implementation
        Car car = new Car("ABC123", "Toyota", "Corolla", "blue");

        // Create a new client with null values for name and email
        Client client = new TestClient(clientId, name, email, password, strategy, car);

        // Verify that the Client is not null
        assertNotNull(client);

        // Verify that the name and email are null as expected
        assertNull(client.getName(), "Name should be null.");
        assertNull(client.getEmail(), "Email should be null.");
        
        // Verify other properties
        assertEquals(clientId, client.getId(), "Client ID should match.");
        assertEquals(password, client.getPassword(), "Password should match.");
        assertEquals("ACTIVE", client.getStatus(), "Registration status should be 'ACTIVE'");
    }
}
