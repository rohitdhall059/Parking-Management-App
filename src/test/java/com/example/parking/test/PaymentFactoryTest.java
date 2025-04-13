package com.example.parking.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.example.parking.factory.PaymentFactory;
import com.example.parking.model.payment.CreditCard;
import com.example.parking.model.payment.MobilePayment;
import com.example.parking.model.payment.PaymentMethod;

class PaymentFactoryTest {

    @Test
    void createPaymentMethod_CreditCard_Success() {
        // Arrange
        String type = "CREDIT_CARD";
        String cardHolderName = "John Doe";
        String cardNumber = "1234-5678-9012-3456";
        String expiry = "12/25";

        // Act
        PaymentMethod paymentMethod = PaymentFactory.createPaymentMethod(type, cardHolderName, cardNumber, expiry);

        // Assert
        assertNotNull(paymentMethod);
        assertTrue(paymentMethod instanceof CreditCard);
        CreditCard creditCard = (CreditCard) paymentMethod;
        assertEquals(cardHolderName, creditCard.getCardHolderName());
        assertEquals(cardNumber, creditCard.getCardNumber());
        assertEquals(expiry, creditCard.getExpiry());
        assertEquals(1000.0, creditCard.getAmount());
    }

    @Test
    void createPaymentMethod_MobilePayment_Success() {
        // Arrange
        String type = "MOBILE_PAYMENT";
        String phoneNumber = "1234567890";

        // Act
        PaymentMethod paymentMethod = PaymentFactory.createPaymentMethod(type, phoneNumber);

        // Assert
        assertNotNull(paymentMethod);
        assertTrue(paymentMethod instanceof MobilePayment);
        MobilePayment mobilePayment = (MobilePayment) paymentMethod;
        assertEquals(phoneNumber, mobilePayment.getCredential());
        assertEquals(0.0, mobilePayment.getAmount());
    }

    @Test
    void createPaymentMethod_CreditCard_InvalidArguments() {
        // Arrange
        String type = "CREDIT_CARD";
        String cardHolderName = "John Doe";

        // Act & Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> PaymentFactory.createPaymentMethod(type, cardHolderName)
        );
        assertEquals("Invalid number of arguments for CreditCard.", exception.getMessage());
    }

    @Test
    void createPaymentMethod_MobilePayment_InvalidArguments() {
        // Arrange
        String type = "MOBILE_PAYMENT";

        // Act & Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> PaymentFactory.createPaymentMethod(type)
        );
        assertEquals("Invalid number of arguments for MobilePayment.", exception.getMessage());
    }

    @Test
    void createPaymentMethod_InvalidType() {
        // Arrange
        String type = "INVALID_TYPE";

        // Act & Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> PaymentFactory.createPaymentMethod(type, "dummy")
        );
        assertEquals("Unknown payment method type: " + type, exception.getMessage());
    }

    @Test
    void getDefaultPaymentMethod_Success() {
        // Act
        PaymentMethod paymentMethod = PaymentFactory.getDefaultPaymentMethod();

        // Assert
        assertNotNull(paymentMethod);
        assertTrue(paymentMethod instanceof CreditCard);
        CreditCard creditCard = (CreditCard) paymentMethod;
        assertEquals("Default Holder", creditCard.getCardHolderName());
        assertEquals("0000-0000-0000-0000", creditCard.getCardNumber());
        assertEquals("12/99", creditCard.getExpiry());
        assertEquals(1000.0, creditCard.getAmount());
    }
}