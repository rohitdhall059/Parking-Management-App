package com.example.parking.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.parking.dao.ParkingSpaceDAO;
import com.example.parking.model.Car;
import com.example.parking.model.ParkingSpace;
import com.example.parking.service.ParkingSpaceService;

public class ParkingSpaceServiceTest {

    private ParkingSpaceService parkingSpaceService;
    
    @Mock
    private ParkingSpaceDAO parkingSpaceDAO;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        parkingSpaceService = new ParkingSpaceService(parkingSpaceDAO);
    }
    
    @Test
    void testGetAllParkingSpaces() {
        // Setup
        ParkingSpace space1 = new ParkingSpace("A1", 10.0);
        ParkingSpace space2 = new ParkingSpace("A2", 12.0);
        when(parkingSpaceDAO.getAll()).thenReturn(Arrays.asList(space1, space2));
        
        // Execute
        List<ParkingSpace> result = parkingSpaceService.getAllParkingSpaces();
        
        // Verify
        assertEquals(2, result.size());
        assertEquals("A1", result.get(0).getId());
        assertEquals("A2", result.get(1).getId());
    }
    
    @Test
    void testGetAvailableParkingSpaces() {
        // Setup
        ParkingSpace space1 = new ParkingSpace("A1", 10.0);
        ParkingSpace space2 = new ParkingSpace("A2", 12.0);
        when(parkingSpaceDAO.getAll()).thenReturn(Arrays.asList(space1, space2));
        
        // Execute
        List<ParkingSpace> result = parkingSpaceService.getAvailableParkingSpaces();
        
        // Verify
        assertEquals(2, result.size());
        assertEquals("A1", result.get(0).getId());
        assertEquals("A2", result.get(1).getId());
    }
    
    @Test
    void testGetParkingSpace() {
        // Setup
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        when(parkingSpaceDAO.getById("A1")).thenReturn(space);
        
        // Execute
        ParkingSpace result = parkingSpaceService.getParkingSpace("A1");
        
        // Verify
        assertNotNull(result);
        assertEquals("A1", result.getId());
        assertEquals(10.0, result.getRate());
    }
    
    @Test
    void testUpdateParkingSpaceStatus() {
        // Setup
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        when(parkingSpaceDAO.getById("A1")).thenReturn(space);
        
        // Execute
        parkingSpaceService.updateParkingSpaceStatus("A1", true);
        
        // Verify
        assertTrue(space.isOccupied());
        verify(parkingSpaceDAO).update(space);
    }
    
    @Test
    void testUpdateParkingSpaceStatusNonExistent() {
        // Setup
        when(parkingSpaceDAO.getById("NONEXISTENT")).thenReturn(null);
        
        // Execute
        parkingSpaceService.updateParkingSpaceStatus("NONEXISTENT", true);
        
        // Verify
        verify(parkingSpaceDAO, never()).update(any());
    }
    
    @Test
    void testUpdateParkingSpaceRate() {
        // Setup
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        when(parkingSpaceDAO.getById("A1")).thenReturn(space);
        
        // Execute
        parkingSpaceService.updateParkingSpaceRate("A1", 15.0);
        
        // Verify
        assertEquals(15.0, space.getRate());
        verify(parkingSpaceDAO).update(space);
    }
    
    @Test
    void testUpdateParkingSpaceRateNonExistent() {
        // Setup
        when(parkingSpaceDAO.getById("NONEXISTENT")).thenReturn(null);
        
        // Execute
        parkingSpaceService.updateParkingSpaceRate("NONEXISTENT", 15.0);
        
        // Verify
        verify(parkingSpaceDAO, never()).update(any());
    }
    
    @Test
    void testEnableParkingSpace() {
        // Setup
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        space.disable();
        when(parkingSpaceDAO.getById("A1")).thenReturn(space);
        
        // Execute
        parkingSpaceService.enableParkingSpace("A1");
        
        // Verify
        assertTrue(space.isEnabled());
        verify(parkingSpaceDAO).update(space);
    }
    
    @Test
    void testDisableParkingSpace() {
        // Setup
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        space.enable();
        when(parkingSpaceDAO.getById("A1")).thenReturn(space);
        
        // Execute
        parkingSpaceService.disableParkingSpace("A1");
        
        // Verify
        assertFalse(space.isEnabled());
        verify(parkingSpaceDAO).update(space);
    }
    
    @Test
    void testGetAvailableSpaces() {
        // Setup
        ParkingSpace space1 = new ParkingSpace("A1", 10.0);
        space1.vacate();
        space1.enable();
        
        ParkingSpace space2 = new ParkingSpace("A2", 12.0);
        space2.occupy("ABC123");
        space2.enable();
        
        when(parkingSpaceDAO.getAll()).thenReturn(Arrays.asList(space1, space2));
        
        // Execute
        List<ParkingSpace> result = parkingSpaceService.getAvailableSpaces();
        
        // Verify
        assertEquals(1, result.size());
        assertEquals("A1", result.get(0).getId());
    }
    
    @Test
    void testMarkSpaceOccupied() {
        // Setup
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        when(parkingSpaceDAO.getById("A1")).thenReturn(space);
        
        // Execute
        parkingSpaceService.markSpaceOccupied("A1");
        
        // Verify
        assertTrue(space.isOccupied());
        verify(parkingSpaceDAO).update(space);
    }
    
    @Test
    void testMarkSpaceOccupiedNonExistent() {
        // Setup
        when(parkingSpaceDAO.getById("NONEXISTENT")).thenReturn(null);
        
        // Execute & Verify
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            parkingSpaceService.markSpaceOccupied("NONEXISTENT");
        });
        
        assertTrue(exception.getMessage().contains("Parking space not found"));
        verify(parkingSpaceDAO, never()).update(any());
    }
    
    @Test
    void testMarkSpaceFree() {
        // Setup
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        Car car = new Car("ABC123", "Toyota", "Camry", "Blue");
        space.occupy("ABC123");
        when(parkingSpaceDAO.getById("A1")).thenReturn(space);
        
        // Execute
        parkingSpaceService.markSpaceFree("A1");
        
        // Verify
        assertFalse(space.isOccupied());
        verify(parkingSpaceDAO).update(space);
    }
    
    @Test
    void testMarkSpaceFreeNonExistent() {
        // Setup
        when(parkingSpaceDAO.getById("NONEXISTENT")).thenReturn(null);
        
        // Execute & Verify
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            parkingSpaceService.markSpaceFree("NONEXISTENT");
        });
        
        assertTrue(exception.getMessage().contains("Parking space not found"));
        verify(parkingSpaceDAO, never()).update(any());
    }
    
    @Test
    void testUpdateSpaceRate() {
        // Setup
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        when(parkingSpaceDAO.getById("A1")).thenReturn(space);
        
        // Execute
        parkingSpaceService.updateSpaceRate("A1", 15.0);
        
        // Verify
        assertEquals(15.0, space.getRate());
        verify(parkingSpaceDAO).update(space);
    }
    
    @Test
    void testUpdateSpaceRateNonExistent() {
        // Setup
        when(parkingSpaceDAO.getById("NONEXISTENT")).thenReturn(null);
        
        // Execute & Verify
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            parkingSpaceService.updateSpaceRate("NONEXISTENT", 15.0);
        });
        
        assertTrue(exception.getMessage().contains("Parking space not found"));
        verify(parkingSpaceDAO, never()).update(any());
    }
    
    @Test
    void testUpdateSpaceStatus() {
        // Setup
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        when(parkingSpaceDAO.getById("A1")).thenReturn(space);
        
        // Execute
        parkingSpaceService.updateSpaceStatus("A1", true);
        
        // Verify
        assertTrue(space.isEnabled());
        verify(parkingSpaceDAO).update(space);
    }
    
    @Test
    void testUpdateSpaceStatusNonExistent() {
        // Setup
        when(parkingSpaceDAO.getById("NONEXISTENT")).thenReturn(null);
        
        // Execute & Verify
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            parkingSpaceService.updateSpaceStatus("NONEXISTENT", true);
        });
        
        assertTrue(exception.getMessage().contains("Parking space not found"));
        verify(parkingSpaceDAO, never()).update(any());
    }
    
    @Test
    void testEnableSpace() {
        // Setup
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        space.disable();
        when(parkingSpaceDAO.getById("A1")).thenReturn(space);
        
        // Execute
        parkingSpaceService.enableSpace("A1");
        
        // Verify
        assertTrue(space.isEnabled());
        verify(parkingSpaceDAO).update(space);
    }
    
    @Test
    void testDisableSpace() {
        // Setup
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        space.enable();
        when(parkingSpaceDAO.getById("A1")).thenReturn(space);
        
        // Execute
        parkingSpaceService.disableSpace("A1");
        
        // Verify
        assertFalse(space.isEnabled());
        verify(parkingSpaceDAO).update(space);
    }
    @Test
    void testGetAvailableParkingSpacesNoSpaces() {
        // Setup
        when(parkingSpaceDAO.getAll()).thenReturn(Arrays.asList());
        
        // Execute
        List<ParkingSpace> result = parkingSpaceService.getAvailableParkingSpaces();
        
        // Verify
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetAvailableSpacesNoSpaces() {
        // Setup
        when(parkingSpaceDAO.getAll()).thenReturn(Arrays.asList());
        
        // Execute
        List<ParkingSpace> result = parkingSpaceService.getAvailableSpaces();
        
        // Verify
        assertTrue(result.isEmpty());
    }

    @Test
    void testUpdateParkingSpaceStatusAlreadyOccupied() {
        // Setup
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        space.setOccupied(true, null);
        when(parkingSpaceDAO.getById("A1")).thenReturn(space);
        
        // Execute
        parkingSpaceService.updateParkingSpaceStatus("A1", true);
        
        // Verify
        assertTrue(space.isOccupied());
        verify(parkingSpaceDAO).update(space);
    }

    @Test
    void testMarkSpaceOccupiedAlreadyOccupied() {
        // Setup
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        space.setOccupied(true, null);
        when(parkingSpaceDAO.getById("A1")).thenReturn(space);
        
        // Execute
        parkingSpaceService.markSpaceOccupied("A1");
        
        // Verify
        assertTrue(space.isOccupied());
        verify(parkingSpaceDAO).update(space);
    }

    @Test
    void testMarkSpaceFreeAlreadyFree() {
        // Setup
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        space.setOccupied(false, null);
        when(parkingSpaceDAO.getById("A1")).thenReturn(space);
        
        // Execute
        parkingSpaceService.markSpaceFree("A1");
        
        // Verify
        assertFalse(space.isOccupied());
        verify(parkingSpaceDAO).update(space);
    }

    @Test
    void testUpdateSpaceStatusAlreadyEnabled() {
        // Setup
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        space.setEnabled(true);
        when(parkingSpaceDAO.getById("A1")).thenReturn(space);
        
        // Execute
        parkingSpaceService.updateSpaceStatus("A1", true);
        
        // Verify
        assertTrue(space.isEnabled());
        verify(parkingSpaceDAO).update(space);
    }

    @Test
    void testUpdateSpaceStatusAlreadyDisabled() {
        // Setup
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        space.setEnabled(false);
        when(parkingSpaceDAO.getById("A1")).thenReturn(space);
        
        // Execute
        parkingSpaceService.updateSpaceStatus("A1", false);
        
        // Verify
        assertFalse(space.isEnabled());
        verify(parkingSpaceDAO).update(space);
    }
}