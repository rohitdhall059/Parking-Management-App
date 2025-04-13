package com.example.parking.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.parking.config.AppConfig;

import java.lang.reflect.Field;
import java.nio.file.Paths;

public class ConfigTest {

    @BeforeEach
    void setUp() {
        AppConfig.getInstance().reset(); // Assuming you have a reset method
    }

    @Test
    void testAppConfigSingleton() {
        // Test singleton pattern
        AppConfig config1 = AppConfig.getInstance();
        AppConfig config2 = AppConfig.getInstance();
        assertSame(config1, config2, "AppConfig should return the same instance");
    }

    @Test
    void testDefaultConfigValues() {
        AppConfig config = AppConfig.getInstance();
        
        // Test default CSV paths
        assertEquals("data/clients.csv", config.getClientsCsvPath());
        assertEquals("data/parkingspaces.csv", config.getParkingspacesCsvPath());
        assertEquals("data/bookings.csv", config.getBookingsCsvPath());
    }

    @Test
    void testConfigNullValues() {
        AppConfig config = AppConfig.getInstance();
        
        // Test setting null values
        assertThrows(IllegalArgumentException.class, () -> config.setClientsCsvPath(null));
        assertThrows(IllegalArgumentException.class, () -> config.setParkingspacesCsvPath(null));
        assertThrows(IllegalArgumentException.class, () -> config.setBookingsCsvPath(null));
    }

    @Test
    void testConfigEmptyValues() {
        AppConfig config = AppConfig.getInstance();
        
        // Test setting empty values
        assertThrows(IllegalArgumentException.class, () -> config.setClientsCsvPath(""));
        assertThrows(IllegalArgumentException.class, () -> config.setParkingspacesCsvPath(""));
        assertThrows(IllegalArgumentException.class, () -> config.setBookingsCsvPath(""));
    }

    @Test
    void testConfigInvalidPaths() {
        AppConfig config = AppConfig.getInstance();
        
        // Test setting invalid paths
        assertThrows(IllegalArgumentException.class, () -> config.setClientsCsvPath("invalid/path/"));
        assertThrows(IllegalArgumentException.class, () -> config.setParkingspacesCsvPath("invalid/path/"));
        assertThrows(IllegalArgumentException.class, () -> config.setBookingsCsvPath("invalid/path/"));
    }

    @Test
    void testConfigValidPaths() {
        AppConfig config = AppConfig.getInstance();
        
        // Test setting valid absolute paths
        String validPath = Paths.get("C:/valid/path/clients.csv").toAbsolutePath().toString();
        config.setClientsCsvPath(validPath);
        assertEquals(validPath, config.getClientsCsvPath());

        validPath = Paths.get("C:/valid/path/parkingspaces.csv").toAbsolutePath().toString();
        config.setParkingspacesCsvPath(validPath);
        assertEquals(validPath, config.getParkingspacesCsvPath());

        validPath = Paths.get("C:/valid/path/bookings.csv").toAbsolutePath().toString();
        config.setBookingsCsvPath(validPath);
        assertEquals(validPath, config.getBookingsCsvPath());
    }

    @Test
    void testInstanceIsNull() throws Exception {
        // Use reflection to set the instance to null
        Field instanceField = AppConfig.class.getDeclaredField("instance");
        instanceField.setAccessible(true);
        instanceField.set(null, null);

        // Now, when we call getInstance, it should create a new instance
        AppConfig config = AppConfig.getInstance();
        assertNotNull(config, "AppConfig instance should not be null after calling getInstance");
    }
    @Test
    void testSingletonInstanceCreation() {
        // Ensure the instance is null before calling getInstance
        try {
            Field instanceField = AppConfig.class.getDeclaredField("instance");
            instanceField.setAccessible(true);
            instanceField.set(null, null); // Set instance to null

            // Call getInstance and check if a new instance is created
            AppConfig config = AppConfig.getInstance();
            assertNotNull(config, "AppConfig instance should not be null after calling getInstance");
        } catch (Exception e) {
            fail("Exception occurred while testing singleton instance creation: " + e.getMessage());
        }
    }
    @Test
    void testSettingValidPaths() {
        AppConfig config = AppConfig.getInstance();
        
        // Set valid absolute paths
        String validClientsPath = Paths.get("C:/valid/path/clients.csv").toAbsolutePath().toString();
        config.setClientsCsvPath(validClientsPath);
        assertEquals(validClientsPath, config.getClientsCsvPath());

        String validParkingspacesPath = Paths.get("C:/valid/path/parkingspaces.csv").toAbsolutePath().toString();
        config.setParkingspacesCsvPath(validParkingspacesPath);
        assertEquals(validParkingspacesPath, config.getParkingspacesCsvPath());

        String validBookingsPath = Paths.get("C:/valid/path/bookings.csv").toAbsolutePath().toString();
        config.setBookingsCsvPath(validBookingsPath);
        assertEquals(validBookingsPath, config.getBookingsCsvPath());
    }
    @Test
    void testDoubleCheckedLocking() {
        // Use reflection to set the instance to null
        try {
            Field instanceField = AppConfig.class.getDeclaredField("instance");
            instanceField.setAccessible(true);
            instanceField.set(null, null); // Set instance to null
    
            // Create multiple threads to test concurrent access
            Runnable task = () -> {
                AppConfig config = AppConfig.getInstance();
                assertNotNull(config, "AppConfig instance should not be null");
            };
    
            Thread thread1 = new Thread(task);
            Thread thread2 = new Thread(task);
            
            // Start both threads
            thread1.start();
            thread2.start();
            
            // Wait for both threads to finish
            thread1.join();
            thread2.join();
    
            // After both threads have executed, check that the instance is still not null
            AppConfig finalConfig = AppConfig.getInstance();
            assertNotNull(finalConfig, "AppConfig instance should not be null after concurrent access");
        } catch (Exception e) {
            fail("Exception occurred while testing double-checked locking: " + e.getMessage());
        }
    }

}