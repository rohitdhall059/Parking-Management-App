package com.example.parking.factory;

import com.example.parking.model.payment.CreditCard;
import com.example.parking.model.payment.MobilePayment; // Ensure PaymentMethod is imported
import com.example.parking.model.payment.PaymentMethod; // Import MobilePayment

public class PaymentFactory {

    /**
     * Creates a PaymentMethod instance based on the type specified.
     *
     * @param type The type of payment method (e.g., "CREDIT_CARD", "MOBILE_PAYMENT").
     * @param details The details required to create the payment method.
     *                For CreditCard: {cardHolderName, cardNumber, expiry}
     *                For MobilePayment: {phoneNumber}
     * @return A PaymentMethod instance or null if the type is invalid.
     */
    public static PaymentMethod createPaymentMethod(String type, String... details) {
        switch (type.toUpperCase()) {
            case "CREDIT_CARD":
                if (details.length == 3) {
                    String cardHolderName = details[0];
                    String cardNumber = details[1];
                    String expiry = details[2];
                    double defaultCreditLimit = 1000.0; // Example default value
                    return new CreditCard(cardHolderName, cardNumber, expiry, defaultCreditLimit);
                } else {
                    throw new IllegalArgumentException("Invalid number of arguments for CreditCard.");
                }
            case "MOBILE_PAYMENT":
                if (details.length == 1) {
                    String phoneNumber = details[0];
                    return new MobilePayment(phoneNumber, 0.0);
                } else {
                    throw new IllegalArgumentException("Invalid number of arguments for MobilePayment.");
                }
            default:
                throw new IllegalArgumentException("Unknown payment method type: " + type);
        }

    }
    public static PaymentMethod getDefaultPaymentMethod() {
        return new CreditCard("Default Holder", "0000-0000-0000-0000", "12/99", 1000.0);
    }
}