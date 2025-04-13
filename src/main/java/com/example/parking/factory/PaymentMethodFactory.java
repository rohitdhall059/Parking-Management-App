package com.example.parking.factory;

import com.example.parking.model.payment.CreditCard;
import com.example.parking.model.payment.DebitCard;
import com.example.parking.model.payment.MobilePayment;
import com.example.parking.model.payment.PaymentMethod;

public class PaymentMethodFactory {

    /**
     * Creates a PaymentMethod based on the specified type.
     *
     * @param type The type of payment method ("credit", "debit", or "mobile").
     * @param cardNumber The card number or phone number.
     * @param credential For a credit card, this is the expiry date (in "MM/yy" format);
     *                   for a debit card, this is the PIN;
     *                   for mobile payment, this is the card holder name.
     * @return A PaymentMethod instance.
     * @throws IllegalArgumentException if the type is unrecognized or if the card number or credential is invalid.
     */
    public static PaymentMethod createPaymentMethod(String type, String cardNumber, String credential) {
        if (type != null) {
            switch (type.toLowerCase()) {
                case "credit":
                    if (!isValidCardNumber(cardNumber)) {
                        throw new IllegalArgumentException("Invalid card number format");
                    }
                    if (!isValidExpiryDate(credential)) {
                        throw new IllegalArgumentException("Invalid expiry date format");
                    }
                    return new CreditCard("DefaultHolder", cardNumber, credential, 0.0);
                case "debit":
                    if (!isValidCardNumber(cardNumber)) {
                        throw new IllegalArgumentException("Invalid card number format");
                    }
                    if (!isValidPin(credential)) {
                        throw new IllegalArgumentException("Invalid PIN format");
                    }
                    return new DebitCard(cardNumber, "DefaultHolder", credential, 0.0);
                case "mobile":
                    // If credential is provided, use the constructor that takes phone number, credential, and amount
                if (credential != null && !credential.isEmpty()) {
                    return new MobilePayment(cardNumber, credential, 0.0); // Use cardNumber for phone number
                } else {
                    // Otherwise, use the constructor that takes only phone number and amount
                    return new MobilePayment(cardNumber, 0.0); // Use cardNumber for phone number
                }
                default:
                    throw new IllegalArgumentException("Unknown payment method type: " + type);
            }
        }
        throw new IllegalArgumentException("Unknown payment method type");
    }

    public static PaymentMethod getDefaultPaymentMethod() {
        // Return a default PaymentMethod instance
        return new CreditCard("DefaultHolder", "0000-0000-0000-0000", "12/34", 0.0); // Default CreditCard instance
    }

    private static boolean isValidCardNumber(String cardNumber) {
        // Allow for card numbers with or without dashes
        return cardNumber != null && cardNumber.replace("-", "").matches("\\d{16}"); // Remove dashes and check for 16 digits
    }

    private static boolean isValidExpiryDate(String expiryDate) {
        // Check if the expiry date is not null and matches the MM/yy format
        return expiryDate != null && expiryDate.matches("(0[1-9]|1[0-2])/\\d{2}"); // MM/yy format
    }

    private static boolean isValidPin(String pin) {
        // Check if the PIN is not null and matches a specific format (e.g., 4 digits)
        return pin != null && pin.matches("\\d{4}"); // Example: 4 digits
    }
}