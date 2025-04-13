package com.example.parking.model.payment;

public abstract class PaymentMethod {
    private String type;
    private String cardNumber;
    private String credential; // This can be used for expiry date or other credentials
    protected String paymentID;
    protected double amount;

    // Constructor to initialize all fields
    public PaymentMethod(String type, String cardNumber, String credential, double amount) {
        this.type = type;
        this.cardNumber = cardNumber;
        this.credential = credential; // Initialize credential
        this.amount = amount; // Initialize amount
    }

    // Abstract methods for processing payments and refunds
    public abstract boolean processPayment(double amount);
    public abstract void processRefund(double amount);

    // Getters
    public String getType() {
        return type;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCredential() { // This can return the expiry date for credit cards
        return credential;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}