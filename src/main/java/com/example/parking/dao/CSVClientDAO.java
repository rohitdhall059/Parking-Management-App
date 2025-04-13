package com.example.parking.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.example.parking.factory.ClientFactory;
import com.example.parking.model.Car;
import com.example.parking.model.Client;

/**
 * Handles client data persistence using CSV file storage.
 * Provides CRUD operations for client records.
 */
public class CSVClientDAO implements ClientDAO {
    private final String filePath;

    public CSVClientDAO(String filePath) {
        this.filePath = filePath;
    }
    
    @Override
    public void save(Client client) {
        try (FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {
            out.println(formatClient(client)); // Ensure this is correctly formatted
            System.out.println("Saved client: " + client); // Debugging output
        } catch (IOException e) {
            throw new RuntimeException("Error saving client: " + e.getMessage());
        }
    }


    @Override
    public Client getById(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Reading line: " + line);  // Debugging line
                String[] parts = line.split(",", -1);
                if (parts[0].equals(id)) {
                    System.out.println("Client found: " + parts[0]);  // Debugging line
                    return parseClient(parts);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading client: " + e.getMessage());
        }
        System.out.println("Client not found with ID: " + id);  // Debugging line
        return null;  // This might be causing the test to fail
    }
    
    /**
     * Retrieves all client records from the CSV file.
     */
    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", -1); // Preserve empty fields
                clients.add(parseClient(parts));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading clients: " + e.getMessage());
        }
        return clients;
    }

    /**
     * Updates an existing client record in the CSV file.
     * Replaces the entire file content to update the record.
     */
    @Override
    public void update(Client client) {
        List<Client> clients = getAll();
        try (FileWriter fw = new FileWriter(filePath, false);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            for (Client c : clients) {
                if (c.getId().equals(client.getId())) {
                    out.println(formatClient(client));
                } else {
                    out.println(formatClient(c));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error updating client: " + e.getMessage());
        }
    }

    /**
     * Removes a client record from the CSV file.
     * Recreates the file without the deleted record.
     */
    @Override
    public void delete(String id) {
        List<Client> clients = getAll();
        try (FileWriter fw = new FileWriter(filePath, false);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            for (Client client : clients) {
                if (!client.getId().equals(id)) {
                    out.println(formatClient(client));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error deleting client: " + e.getMessage());
        }
    }

    /**
     * Formats a client object into a CSV string.
     * Includes client ID, name, email, status, and car license plate.
     */
    private String formatClient(Client client) {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
            client.getId(),
            client.getName(),
            client.getEmail(),
            client.getPassword(),
            client.getStatus(),
            client.getType(), // Use defined type (like "FACULTY")
            client.getCar() != null ? client.getCar().getLicensePlate() : "");
    }
    

    /**
     * Parses a CSV line into a Client object.
     * Creates the appropriate client type based on ID prefix.
     */
    private Client parseClient(String[] parts) {
        if (parts.length < 7) {
            throw new IllegalArgumentException("Invalid client data: " + String.join(",", parts));
        }
    
        String id = parts[0];
        String name = parts[1];
        String email = parts[2];
        String password = parts[3];
        String status = parts[4]; // Adjusted to match the correct index
        String type = parts[5]; // Assuming the type is now the 6th field in the CSV
        String carPlate = parts[6]; // Assuming the car plate is now the 7th field
    
        Client client = ClientFactory.createClient(type, id, name, email);
        client.setStatus(status);
        client.setPassword(password); // Set the password as well
    
        // Handle the car plate
        if (carPlate != null && !carPlate.equals("null") && !carPlate.isEmpty()) {
            Car car = new Car(carPlate);
            client.setCar(car);
        } else {
            client.setCar(null); // Explicitly set car to null if the plate is "null"
        }
    
        return client;
    }
}