package com.example.parking.model.payment;

public abstract class PaymentMethod {
    private String type;
    private String cardNumber;
    private String credential; // Added credential field
    protected String paymentID;
    protected double amount;

    public PaymentMethod(double amount, String type, String cardNumber, String credential) {
        this.type = type;
        this.cardNumber = cardNumber;
        this.credential = credential; // Initialize credential
        this.amount = amount;
    }
    public PaymentMethod(double amount) {
        this.amount = amount;
    }
    public abstract boolean processPayment(double amount);

    public abstract void processRefund(double amount);
                
    public String getType() {
        return type;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCredential() { // Added getCredential method
        return credential;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}