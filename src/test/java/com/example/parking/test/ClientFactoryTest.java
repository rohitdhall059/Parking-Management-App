package com.example.parking.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.parking.factory.ClientFactory;
import com.example.parking.model.Client;
import com.example.parking.model.FacultyMember;
import com.example.parking.model.NonFacultyStaff;
import com.example.parking.model.Student;
import com.example.parking.model.Visitor;

public class ClientFactoryTest {

    @Test
    void testCreateFacultyMember() {
        // Setup
        String id = "FM001";
        String name = "John Smith";
        String email = "john@example.com";

        // Execute
        Client client = ClientFactory.createClient("FM", id, name, email);

        // Verify
        assertTrue(client instanceof FacultyMember);
        assertEquals(id, client.getId());
        assertEquals(name, client.getName());
        assertEquals(email, client.getEmail());
        assertEquals("default1", ((FacultyMember) client).getFacultyId());
        assertEquals("default2", ((FacultyMember) client).getDepartment());
        assertEquals("default3", ((FacultyMember) client).getPassword());
    }

    @Test
    void testCreateStudent() {
        // Setup
        String id = "ST001";
        String name = "Jane Doe";
        String email = "jane@example.com";

        // Execute
        Client client = ClientFactory.createClient("ST", id, name, email);

        // Verify
        assertTrue(client instanceof Student);
        assertEquals(id, client.getId());
        assertEquals(name, client.getName());
        assertEquals(email, client.getEmail());
        assertEquals("default1", ((Student) client).getStudentId());
        assertEquals("default2", ((Student) client).getDepartment());
        assertEquals("default3", ((Student) client).getPassword());
        assertEquals("default4", ((Student) client).getYear());
    }

    @Test
    void testCreateNonFacultyStaff() {
        // Setup
        String id = "NF001";
        String name = "Bob Johnson";
        String email = "bob@example.com";

        // Execute
        Client client = ClientFactory.createClient("NF", id, name, email);

        // Verify
        assertTrue(client instanceof NonFacultyStaff);
        assertEquals(id, client.getId());
        assertEquals(name, client.getName());
        assertEquals(email, client.getEmail());
        assertEquals("default1", ((NonFacultyStaff) client).getStaffId());
        assertEquals("default2", ((NonFacultyStaff) client).getOffice());
        assertEquals("default3", ((NonFacultyStaff) client).getPassword());
    }

    @Test
    void testCreateVisitor() {
        // Setup
        String id = "VI001";
        String name = "Alice Brown";
        String email = "alice@example.com";

        // Execute
        Client client = ClientFactory.createClient("VI", id, name, email);

        // Verify
        assertTrue(client instanceof Visitor);
        assertEquals(id, client.getId());
        assertEquals(name, client.getName());
        assertEquals(email, client.getEmail());
        assertEquals("default1", ((Visitor) client).getvisitInformation());
        assertEquals("default2", ((Visitor) client).getVisitorId());
        assertEquals("default3", ((Visitor) client).getPassword());
    }

    @Test
    void testCreateClientWithInvalidType() {
        // Setup
        String id = "XX001";
        String name = "Test User";
        String email = "test@example.com";

        // Execute & Verify
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ClientFactory.createClient("XX", id, name, email);
        });

        assertTrue(exception.getMessage().contains("Unknown client type: XX"));
    }

    @Test
    void testCreateClientWithNullType() {
        // Setup
        String id = "XX001";
        String name = "Test User";
        String email = "test@example.com";

        // Execute & Verify
        Exception exception = assertThrows(NullPointerException.class, () -> {
            ClientFactory.createClient(null, id, name, email);
        });

        assertTrue(exception.getMessage().contains("Cannot invoke \"String.toUpperCase()\" because \"type\" is null"));
    }

    @Test
    void testCreateClientWithEmptyType() {
        // Setup
        String id = "XX001";
        String name = "Test User";
        String email = "test@example.com";

        // Execute & Verify
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ClientFactory.createClient("", id, name, email);
        });

        assertTrue(exception.getMessage().contains("Unknown client type: "));
    }

    @Test
    void testCreateClientWithNullParameters() {
        // Execute & Verify
        Exception exception = assertThrows(NullPointerException.class, () -> {
            ClientFactory.createClient("FM", null, null, null);
        });

        assertTrue(exception.getMessage().contains("Cannot invoke \"String.toUpperCase()\" because \"type\" is null"));
    }

    @Test
    void testCreateClientWithEmptyParameters() {
        // Setup
        String id = "";
        String name = "";
        String email = "";

        // Execute
        Client client = ClientFactory.createClient("FM", id, name, email);

        // Verify
        assertTrue(client instanceof FacultyMember);
        assertEquals(id, client.getId());
        assertEquals(name, client.getName());
        assertEquals(email, client.getEmail());
    }
} 