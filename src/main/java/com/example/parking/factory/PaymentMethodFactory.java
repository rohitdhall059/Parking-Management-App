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
     * @throws IllegalArgumentException if the type is unrecognized.
     */
    public static PaymentMethod createPaymentMethod(String type, String cardNumber, String credential) {
        return switch (type.toLowerCase()) {
            case "credit" -> new CreditCard(cardNumber, credential, "DefaultHolder", 0.0);
            case "debit" -> new DebitCard(cardNumber, credential, "DefaultHolder", 0.0);
            case "mobile" -> new MobilePayment(credential, 0.0);
            default -> throw new IllegalArgumentException("Unknown payment method type: " + type);
        };
    }
    public static PaymentMethod getDefaultPaymentMethod() {
        // Return a default PaymentMethod instance (replace with actual implementation)
        return new CreditCard("0000-0000-0000-0000", "12/34", "DefaultHolder", 0.0); // Default CreditCard instance
    }

    
}