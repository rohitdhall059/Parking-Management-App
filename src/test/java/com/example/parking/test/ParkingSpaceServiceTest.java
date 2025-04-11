package com.example.parking.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.parking.dao.ParkingSpaceDAO;
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
        List<ParkingSpace> mockSpaces = new ArrayList<>();
        mockSpaces.add(new ParkingSpace("A1", 10.0));
        mockSpaces.add(new ParkingSpace("A2", 12.0));
        mockSpaces.add(new ParkingSpace("B1", 8.0));
        
        when(parkingSpaceDAO.getAll()).thenReturn(mockSpaces);
        
        // Execute
        List<ParkingSpace> result = parkingSpaceService.getAllParkingSpaces();
        
        // Verify
        assertEquals(3, result.size());
        assertEquals("A1", result.get(0).getId());
        assertEquals("A2", result.get(1).getId());
        assertEquals("B1", result.get(2).getId());
    }
    
    @Test
    void testGetAvailableSpaces() {
        // Setup
        List<ParkingSpace> mockSpaces = new ArrayList<>();
        ParkingSpace space1 = new ParkingSpace("A1", 10.0);
        space1.setOccupied(false, null);
        
        ParkingSpace space2 = new ParkingSpace("A2", 12.0);
        space2.setOccupied(true, null);
        
        ParkingSpace space3 = new ParkingSpace("B1", 8.0);
        space3.setOccupied(false, null);
        space3.setEnabled(false);
        
        mockSpaces.add(space1);
        mockSpaces.add(space2);
        mockSpaces.add(space3);
        
        when(parkingSpaceDAO.getAll()).thenReturn(mockSpaces);
        
        // Execute
        List<ParkingSpace> result = parkingSpaceService.getAvailableSpaces();
        
        // Verify
        assertEquals(1, result.size());
        assertEquals("A1", result.get(0).getId());
    }
    
    @Test
    void testGetParkingSpace() {
        // Setup
        String spaceId = "A1";
        ParkingSpace mockSpace = new ParkingSpace(spaceId, 10.0);
        
        when(parkingSpaceDAO.getById(spaceId)).thenReturn(mockSpace);
        
        // Execute
        ParkingSpace result = parkingSpaceService.getParkingSpace(spaceId);
        
        // Verify
        assertNotNull(result);
        assertEquals(spaceId, result.getId());
    }
    
    @Test
    void testMarkSpaceOccupied() {
        // Setup
        String spaceId = "A1";
        ParkingSpace mockSpace = new ParkingSpace(spaceId, 10.0);
        
        when(parkingSpaceDAO.getById(spaceId)).thenReturn(mockSpace);
        
        // Execute
        parkingSpaceService.markSpaceOccupied(spaceId);
        
        // Verify
        assertTrue(mockSpace.isOccupied());
        verify(parkingSpaceDAO).update(mockSpace);
    }
    
    @Test
    void testMarkSpaceOccupiedWithNonExistentSpace() {
        // Setup
        String spaceId = "NONEXISTENT";
        
        when(parkingSpaceDAO.getById(spaceId)).thenReturn(null);
        
        // Execute and Verify
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            parkingSpaceService.markSpaceOccupied(spaceId);
        });
        
        assertTrue(exception.getMessage().contains("Parking space not found"));
    }
    
    @Test
    void testMarkSpaceFree() {
        // Setup
        String spaceId = "A1";
        ParkingSpace mockSpace = new ParkingSpace(spaceId, 10.0);
        mockSpace.setOccupied(true, null);
        
        when(parkingSpaceDAO.getById(spaceId)).thenReturn(mockSpace);
        
        // Execute
        parkingSpaceService.markSpaceFree(spaceId);
        
        // Verify
        assertFalse(mockSpace.isOccupied());
        verify(parkingSpaceDAO).update(mockSpace);
    }
    
    @Test
    void testMarkSpaceFreeWithNonExistentSpace() {
        // Setup
        String spaceId = "NONEXISTENT";
        
        when(parkingSpaceDAO.getById(spaceId)).thenReturn(null);
        
        // Execute and Verify
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            parkingSpaceService.markSpaceFree(spaceId);
        });
        
        assertTrue(exception.getMessage().contains("Parking space not found"));
    }
    
    @Test
    void testUpdateSpaceRate() {
        // Setup
        String spaceId = "A1";
        double newRate = 15.0;
        ParkingSpace mockSpace = new ParkingSpace(spaceId, 10.0);
        
        when(parkingSpaceDAO.getById(spaceId)).thenReturn(mockSpace);
        
        // Execute
        parkingSpaceService.updateSpaceRate(spaceId, newRate);
        
        // Verify
        assertEquals(newRate, mockSpace.getRate());
        verify(parkingSpaceDAO).update(mockSpace);
    }
    
    @Test
    void testUpdateSpaceRateWithNonExistentSpace() {
        // Setup
        String spaceId = "NONEXISTENT";
        double newRate = 15.0;
        
        when(parkingSpaceDAO.getById(spaceId)).thenReturn(null);
        
        // Execute and Verify
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            parkingSpaceService.updateSpaceRate(spaceId, newRate);
        });
        
        assertTrue(exception.getMessage().contains("Parking space not found"));
    }
    
    @Test
    void testEnableSpace() {
        // Setup
        String spaceId = "A1";
        ParkingSpace mockSpace = new ParkingSpace(spaceId, 10.0);
        mockSpace.setEnabled(false);
        
        when(parkingSpaceDAO.getById(spaceId)).thenReturn(mockSpace);
        
        // Execute
        parkingSpaceService.enableSpace(spaceId);
        
        // Verify
        assertTrue(mockSpace.isEnabled());
        verify(parkingSpaceDAO).update(mockSpace);
    }
    
    @Test
    void testDisableSpace() {
        // Setup
        String spaceId = "A1";
        ParkingSpace mockSpace = new ParkingSpace(spaceId, 10.0);
        
        when(parkingSpaceDAO.getById(spaceId)).thenReturn(mockSpace);
        
        // Execute
        parkingSpaceService.disableSpace(spaceId);
        
        // Verify
        assertFalse(mockSpace.isEnabled());
        verify(parkingSpaceDAO).update(mockSpace);
    }
}