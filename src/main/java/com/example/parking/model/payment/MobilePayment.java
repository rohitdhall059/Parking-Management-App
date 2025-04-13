package com.example.parking.model.payment;

import java.util.regex.Pattern;

public class MobilePayment extends PaymentMethod {

    private String phoneNumber; // Phone number associated with the mobile payment
    private String credential; // Credential (e.g., name or identifier)

    // Constructor that takes phone number and amount
    public MobilePayment(String phoneNumber, double amount) {
        super("mobile", null, phoneNumber, amount); // Pass type, cardNumber (null), and phoneNumber as credential
        this.phoneNumber = phoneNumber; // Initialize phoneNumber
        this.credential = phoneNumber; // Optionally set credential to phone number
    }

    // Constructor that takes phone number, credential, and amount
    public MobilePayment(String phoneNumber, String credential, double amount) {
        super("mobile", null, phoneNumber, amount); // Pass type, cardNumber (null), and phoneNumber as credential
        this.phoneNumber = phoneNumber; // Initialize phoneNumber
        this.credential = credential; // Initialize credential
    }

    @Override
    public boolean processPayment(double amount) {
        // 1. Validate the phone number
        if (!isValidPhoneNumber(phoneNumber)) {
            System.out.println("Transaction failed: invalid phone number.");
            return false;
        }

        // 2. Perform a pseudo "approval"
        if (amount <= 0) {
            System.out.println("Transaction failed: amount must be greater than 0.");
            return false;
        }

        System.out.println("Mobile payment of $" + amount + " approved using phone number " 
            + maskPhoneNumber(phoneNumber) + ".");
        return true;
    }

    @Override
    public void processRefund(double amount) {
        if (!isValidPhoneNumber(phoneNumber)) {
            System.out.println("Refund failed: invalid phone number.");
            return;
        }

        System.out.println("Mobile payment refund of $" + amount + " processed for phone number " 
            + maskPhoneNumber(phoneNumber) + ".");
    }

    @Override
    public String getCardNumber() {
        return phoneNumber; // Return the phone number as the "card number"
    }

    @Override
    public String getCredential() {
        return credential; // Return the stored credential
    }

    private boolean isValidPhoneNumber(String number) {
        return Pattern.matches("\\d{10}", number);
    }

    private String maskPhoneNumber(String number) {
        if (number.length() <= 4) {
            return number;
        }
        String last4 = number.substring(number.length() - 4);
        return "******" + last4;
    }
}