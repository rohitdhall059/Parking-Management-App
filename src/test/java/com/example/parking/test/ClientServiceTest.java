package com.example.parking.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.parking.dao.ClientDAO;
import com.example.parking.model.Client;
import com.example.parking.model.FacultyMember;
import com.example.parking.model.Student;
import com.example.parking.service.ClientService;

public class ClientServiceTest {

    private ClientService clientService;
    
    @Mock
    private ClientDAO clientDAO;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        clientService = new ClientService(clientDAO);
    }
    
    @Test
    void testRegisterNewClient() {
        // Setup
        String type = "FM";
        String name = "Jane Doe";
        String email = "jane@example.com";
        
        // Mock the getAll method to return an empty list (no existing clients)
        when(clientDAO.getAll()).thenReturn(new ArrayList<>());
        
        // Execute
        Client client = clientService.registerClient(type, name, email);
        
        // Verify
        assertNotNull(client);
        assertEquals(name, client.getName());
        assertEquals(email, client.getEmail());
        verify(clientDAO).save(client);
    }
    
    @Test
    void testRegisterClientWithExistingEmail() {
        // Setup
        String type = "FM";
        String name = "Jane Doe";
        String email = "existing@example.com";
        
        List<Client> existingClients = new ArrayList<>();
        existingClients.add(new FacultyMember("FM001", "Existing User", email, "password", "CS101", "Computer Science"));
        
        when(clientDAO.getAll()).thenReturn(existingClients);
        
        // Execute and Verify
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            clientService.registerClient(type, name, email);
        });
        
        assertTrue(exception.getMessage().contains("Client with this email already exists"));
    }
    
    @Test
    void testGetClient() {
        // Setup
        String clientId = "FM001";
        Client mockClient = new FacultyMember(clientId, "John Doe", "john@example.com", "password", "CS101", "Computer Science");
        
        when(clientDAO.getById(clientId)).thenReturn(mockClient);
        
        // Execute
        Client result = clientService.getClient(clientId);
        
        // Verify
        assertNotNull(result);
        assertEquals(clientId, result.getId());
        assertEquals("John Doe", result.getName());
    }
    
    @Test
    void testGetAllClients() {
        // Setup
        List<Client> mockClients = new ArrayList<>();
        mockClients.add(new FacultyMember("FM001", "John Doe", "john@example.com", "password", "CS101", "Computer Science"));
        mockClients.add(new Student("ST001", "Jane Smith", "jane@example.com", "password", "S123", "Computer Science", "Sophomore"));
        
        when(clientDAO.getAll()).thenReturn(mockClients);
        
        // Execute
        List<Client> result = clientService.getAllClients();
        
        // Verify
        assertEquals(2, result.size());
        assertEquals("FM001", result.get(0).getId());
        assertEquals("ST001", result.get(1).getId());
    }
    
    @Test
    void testActivateClient() {
        // Setup
        String clientId = "FM001";
        Client mockClient = new FacultyMember(clientId, "John Doe", "john@example.com", "password", "CS101", "Computer Science");
        
        when(clientDAO.getById(clientId)).thenReturn(mockClient);
        
        // Execute
        clientService.activateClient(clientId);
        
        // Verify
        assertEquals("ACTIVE", mockClient.getStatus());
        verify(clientDAO).update(mockClient);
    }
    
    @Test
    void testDeactivateClient() {
        // Setup
        String clientId = "FM001";
        Client mockClient = new FacultyMember(clientId, "John Doe", "john@example.com", "password", "CS101", "Computer Science");
        
        when(clientDAO.getById(clientId)).thenReturn(mockClient);
        
        // Execute
        clientService.deactivateClient(clientId);
        
        // Verify
        assertEquals("INACTIVE", mockClient.getStatus());
        verify(clientDAO).update(mockClient);
    }
    
    @Test
    void testSuspendClient() {
        // Setup
        String clientId = "FM001";
        Client mockClient = new FacultyMember(clientId, "John Doe", "john@example.com", "password", "CS101", "Computer Science");
        
        when(clientDAO.getById(clientId)).thenReturn(mockClient);
        
        // Execute
        clientService.suspendClient(clientId);
        
        // Verify
        assertEquals("SUSPENDED", mockClient.getStatus());
        verify(clientDAO).update(mockClient);
    }
    
    @Test
    void testUpdateClientStatusWithNonExistentClient() {
        // Setup
        String clientId = "NONEXISTENT";
        
        when(clientDAO.getById(clientId)).thenReturn(null);
        
        // Execute and Verify
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            clientService.updateClientStatus(clientId, "ACTIVE");
        });
        
        assertTrue(exception.getMessage().contains("Client not found"));
    }
    
    @Test
    void testDeleteClient() {
        // Setup
        String clientId = "FM001";
        
        // Execute
        clientService.deleteClient(clientId);
        
        // Verify
        verify(clientDAO).delete(clientId);
    }
    
    @Test
    void testLoginSuccess() {
        // Setup
        String email = "john@example.com";
        String password = "password";
        
        List<Client> mockClients = new ArrayList<>();
        Client validClient = new FacultyMember("FM001", "John Doe", email, password, "CS101", "Computer Science");
        mockClients.add(validClient);
        mockClients.add(new Student("ST001", "Jane Smith", "jane@example.com", "otherpassword", "S123", "Computer Science", "Sophomore"));
        
        when(clientDAO.getAll()).thenReturn(mockClients);
        
        // Execute
        Client result = clientService.login(email, password);
        
        // Verify
        assertNotNull(result);
        assertEquals("FM001", result.getId());
        assertEquals(email, result.getEmail());
    }
    
    @Test
    void testLoginFailure() {
        // Setup
        String email = "john@example.com";
        String wrongPassword = "wrongpassword";
        
        List<Client> mockClients = new ArrayList<>();
        mockClients.add(new FacultyMember("FM001", "John Doe", email, "correctpassword", "CS101", "Computer Science"));
        
        when(clientDAO.getAll()).thenReturn(mockClients);
        
        // Execute
        Client result = clientService.login(email, wrongPassword);
        
        // Verify
        assertNull(result);
    }
}