package com.example.parking.dao;

import com.example.parking.model.Booking;
import com.example.parking.model.Client;
import com.example.parking.model.ParkingSpace;
import com.example.parking.model.Student;
import com.example.parking.model.Visitor;
import com.example.parking.model.payment.PaymentMethod;
import com.example.parking.strategy.VisitorPricing;
import com.example.parking.factory.PaymentMethodFactory;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


public class CSVBookingDAO implements BookingDAO {
    private final String filePath;
    private final ClientDAO clientDAO;
    private final ParkingSpaceDAO parkingSpaceDAO;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public CSVBookingDAO(ClientDAO clientDAO, ParkingSpaceDAO parkingSpaceDAO, String filePath) {
        this.filePath = filePath; // Use the provided file path
        this.clientDAO = clientDAO;
        this.parkingSpaceDAO = parkingSpaceDAO;
    }


    /**
     * Saves a new booking record to the CSV file.
     * Appends the record to the end of the file.
     */
    @Override
    public void save(Booking booking) {
        try (FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {
            out.println(formatBooking(booking)); // Ensure this is correctly formatted
        } catch (IOException e) {
            throw new RuntimeException("Error saving booking: " + e.getMessage());
        }
    }

    /**
     * Retrieves a booking by its unique ID.
     * Returns null if no booking is found with the given ID.
     */
  @Override
    public Booking getById(String id) {
        File file = new File(filePath);

        if (!file.exists()) {
            return null;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue; // Skip empty lines
                }
                String[] parts = line.split(",");
                if (parts.length < 9) {
                    throw new IllegalArgumentException("Invalid booking data: " + line);
                }
                if (parts[0].equals(id)) {
                    return parseBooking(parts);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading booking: " + e.getMessage(), e);
        }

        return null;
    }

    @Override
    public List<Booking> getAll() {
        List<Booking> bookings = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue; // Skip empty lines
                }
                String[] parts = line.split(",");
                if (parts.length < 9) {
                    throw new IllegalArgumentException("Invalid booking data: " + line);
                }
                bookings.add(parseBooking(parts));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading bookings: " + e.getMessage());
        }
        return bookings;
    }
    /**
     * Updates an existing booking record in the CSV file.
     * Replaces the entire file content to update the record.
     */
    @Override
    public void update(Booking booking) {
        List<Booking> bookings = getAll();
        try (FileWriter fw = new FileWriter(filePath, false);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            for (Booking b : bookings) {
                if (b.getBookingId().equals(booking.getBookingId())) {
                    out.println(formatBooking(booking));
                } else {
                    out.println(formatBooking(b));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error updating booking: " + e.getMessage());
        }
    }

    /**
     * Removes a booking record from the CSV file.
     * Recreates the file without the deleted record.
     */
    @Override
    public void delete(String id) {
        List<Booking> bookings = getAll();
        try (FileWriter fw = new FileWriter(filePath, false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {
            for (Booking booking : bookings) {
                // Check if the booking ID matches the id parameter
                if (!booking.getBookingId().equals(id)) {
                    out.println(formatBooking(booking));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error deleting booking: " + e.getMessage());
        }
    }

    /**
     * Retrieves all bookings associated with a specific client.
     */
    @Override
    public List<Booking> getByClientId(String clientId) {
        return getAll().stream()
                .filter(b -> b.getClient().getId().equals(clientId))
                .toList();
    }

    /**
     * Formats a booking object into a CSV string.
     * Includes all booking details including client ID, parking space ID,
     * timestamps, payment information, and status.
     */
    private String formatBooking(Booking booking) {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",
                booking.getBookingId(),
                booking.getClient().getId(),
                booking.getParkingSpace().getId(),
                booking.getStartTime().format(formatter),
                booking.getEndTime().format(formatter),
                booking.getPaymentMethod().getType(), // Ensure this is not null
                booking.getPaymentMethod().getCardNumber(),
                booking.getPaymentMethod().getCredential(),
                booking.getStatus());
    }

    /**
     * Parses a CSV line into a Booking object.
     * Reconstructs related objects (Client, ParkingSpace, PaymentMethod)
     * and calculates the final booking amount.
     */
    private Booking parseBooking(String[] parts) {
        String id = parts[0];
        Client client = clientDAO.getById(parts[1]);
        ParkingSpace space = parkingSpaceDAO.getById(parts[2]);
        LocalDateTime startTime = LocalDateTime.parse(parts[3], formatter);
        LocalDateTime endTime = LocalDateTime.parse(parts[4], formatter);
        
        String paymentMethodType = parts[5];
        String cardNumber = parts[6];
        String credential = parts[7];
        
        PaymentMethod paymentMethod = PaymentMethodFactory.createPaymentMethod(paymentMethodType, cardNumber, credential);
        
        Booking booking = new Booking(id, client, space, startTime, endTime, paymentMethod);
        booking.setStatus(parts[8]);
        
        long hours = ChronoUnit.HOURS.between(startTime, endTime);
        
        // If hours is negative, set it to 0
        if (hours < 0) {
            hours = 0;
        }
    
        double baseAmount;
        
        // Use the correct rate based on the client type
        if (client instanceof Student) {
            baseAmount = hours * ((Student) client).getParkingRate(); // Get the student rate
        } else if (client instanceof Visitor) {
            baseAmount = hours * new VisitorPricing().getRate(); // Use VisitorPricing directly
        } else {
            baseAmount = hours * space.getRate(); // Default case for other clients
        }
    
        double discountRate = client.getDiscountRate(); // This should return 0.15 for students
        
        // Debugging output
        System.out.println("Client Type: " + client.getType());
        System.out.println("Hours: " + hours);
        System.out.println("Base Amount: " + baseAmount);
        System.out.println("Discount Rate: " + discountRate);
        
        double finalAmount = baseAmount * (1 - discountRate);
        booking.setAmount(finalAmount);
        
        // Debugging output for final amount
        System.out.println("Final Amount: " + finalAmount);
        
        return booking;
    }
    
}