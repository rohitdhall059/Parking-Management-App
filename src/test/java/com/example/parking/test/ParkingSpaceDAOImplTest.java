package com.example.parking.test;

import com.example.parking.dao.ParkingSpaceDAOImpl;
import com.example.parking.model.ParkingSpace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingSpaceDAOImplTest {

    private ParkingSpaceDAOImpl dao;

    @BeforeEach
    void setUp() {
        dao = new ParkingSpaceDAOImpl();
    }

    @Test
    void testSaveAndGetById() {
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        dao.save(space);

        ParkingSpace retrieved = dao.getById("A1");
        assertNotNull(retrieved);
        assertEquals("A1", retrieved.getId());
        assertEquals(10.0, retrieved.getRate());
    }

    @Test
    void testGetByIdNotFound() {
        assertNull(dao.getById("XYZ"));
    }

    @Test
    void testDelete() {
        ParkingSpace space = new ParkingSpace("B1", 8.0);
        dao.save(space);

        dao.delete("B1");

        assertNull(dao.getById("B1"));
        assertTrue(dao.getAll().isEmpty());
    }

    @Test
    void testGetAll() {
        dao.save(new ParkingSpace("C1", 5.0));
        dao.save(new ParkingSpace("C2", 6.5));

        List<ParkingSpace> allSpaces = dao.getAll();
        assertEquals(2, allSpaces.size());
    }

    @Test
    void testUpdate() {
        ParkingSpace original = new ParkingSpace("D1", 4.0);
        dao.save(original);

        ParkingSpace updated = new ParkingSpace("D1", 6.0); // update rate
        dao.update(updated);

        ParkingSpace result = dao.getById("D1");
        assertNotNull(result);
        assertEquals(6.0, result.getRate());
    }

    @Test
    void testGetAllParkingSpaces() {
        dao.save(new ParkingSpace("E1", 7.0));
        List<ParkingSpace> list = dao.getAllParkingSpaces();

        assertEquals(1, list.size());
        assertEquals("E1", list.get(0).getId());
    }

    @Test
    void testAddParkingSpaceAndGetParkingSpaceById() {
        ParkingSpace space = new ParkingSpace("F1", 9.0);
        dao.addParkingSpace(space);

        ParkingSpace result = dao.getParkingSpaceById("F1");
        assertNotNull(result);
        assertEquals("F1", result.getId());
        assertEquals(9.0, result.getRate());
    }
}