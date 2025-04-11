package com.example.parking.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.example.parking.config.AppConfig;

public class ConfigTest {

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
    void testConfigSetters() {
        AppConfig config = AppConfig.getInstance();
        
        // Test setting new paths
        String newClientsPath = "new/path/clients.csv";
        String newParkingSpacesPath = "new/path/parkingspaces.csv";
        String newBookingsPath = "new/path/bookings.csv";
        
        config.setClientsCsvPath(newClientsPath);
        config.setParkingspacesCsvPath(newParkingSpacesPath);
        config.setBookingsCsvPath(newBookingsPath);
        
        // Verify the paths were updated
        assertEquals(newClientsPath, config.getClientsCsvPath());
        assertEquals(newParkingSpacesPath, config.getParkingspacesCsvPath());
        assertEquals(newBookingsPath, config.getBookingsCsvPath());
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
} 