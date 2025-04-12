package com.example.parking.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.example.parking.model.payment.CreditCard;
import com.example.parking.model.payment.DebitCard;
import com.example.parking.model.payment.MobilePayment;
import com.example.parking.model.payment.Payment;
import com.example.parking.model.payment.PaymentMethod;
import com.example.parking.model.payment.PaymentStatus;

public class PaymentMethodTest {

    // Test class to test abstract PaymentMethod class
    private static class TestPaymentMethod extends PaymentMethod {
        public TestPaymentMethod(double amount, String type, String cardNumber, String credential) {
            super(amount, type, cardNumber, credential);
        }

        public TestPaymentMethod(double amount) {
            super(amount);
        }

        @Override
        public boolean processPayment(double amount) {
            return true;
        }

        @Override
        public void processRefund(double amount) {
            System.out.println("Refund processed: $" + amount);
        }
    }

    @Test
    void testPaymentMethodConstructor() {
        // Test constructor with all parameters
        PaymentMethod paymentMethod = new TestPaymentMethod(1000.0, "credit", "1234567890123456", "12/25");
        assertEquals("credit", paymentMethod.getType());
        assertEquals("1234567890123456", paymentMethod.getCardNumber());
        assertEquals("12/25", paymentMethod.getCredential());
        assertEquals(1000.0, paymentMethod.getAmount());

        // Test constructor with only amount
        PaymentMethod simplePaymentMethod = new TestPaymentMethod(500.0);
        assertEquals(500.0, simplePaymentMethod.getAmount());
        assertNull(simplePaymentMethod.getType());
        assertNull(simplePaymentMethod.getCardNumber());
        assertNull(simplePaymentMethod.getCredential());
    }

    @Test
    void testPaymentMethodSetters() {
        PaymentMethod paymentMethod = new TestPaymentMethod(1000.0);
        
        // Test setAmount
        paymentMethod.setAmount(2000.0);
        assertEquals(2000.0, paymentMethod.getAmount());
        
        // Test setting amount to zero
        paymentMethod.setAmount(0.0);
        assertEquals(0.0, paymentMethod.getAmount());
        
        // Test setting amount to negative
        paymentMethod.setAmount(-100.0);
        assertEquals(-100.0, paymentMethod.getAmount());
    }

    @Test
    void testPaymentMethodProcessPayment() {
        PaymentMethod paymentMethod = new TestPaymentMethod(1000.0);
        assertTrue(paymentMethod.processPayment(500.0));
    }

    @Test
    void testPaymentMethodProcessRefund() {
        PaymentMethod paymentMethod = new TestPaymentMethod(1000.0);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));
        
        paymentMethod.processRefund(500.0);
        
        System.setOut(originalOut);
        String output = baos.toString();
        assertTrue(output.contains("Refund processed: $500.0"));
    }

    @Test
    void testPaymentClass() {
        // Test constructor and initial state
        PaymentMethod paymentMethod = new CreditCard("John Doe", "1234567890123456", "12/25", 1000.0);
        Payment payment = new Payment("P001", 500.0, paymentMethod);
        
        assertEquals("P001", payment.getId());
        assertEquals(500.0, payment.getAmount());
        assertEquals(PaymentStatus.PENDING, payment.getStatus());
        assertEquals(paymentMethod, payment.getPaymentMethod());
        assertNotNull(payment.getTimestamp());
        
        // Test successful payment processing
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));
        
        assertTrue(payment.process());
        assertEquals(PaymentStatus.COMPLETED, payment.getStatus());
        System.setOut(originalOut);
        String output = baos.toString();
        assertTrue(output.contains("Credit card payment of $500.0 approved for John Doe"));
        
        // Test failed payment processing
        PaymentMethod invalidPaymentMethod = new CreditCard("John Doe", "1234", "12/25", 1000.0);
        Payment failedPayment = new Payment("P002", 500.0, invalidPaymentMethod);
        
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        
        assertFalse(failedPayment.process());
        assertEquals(PaymentStatus.FAILED, failedPayment.getStatus());
        System.setOut(originalOut);
        output = baos.toString();
        assertTrue(output.contains("Transaction failed: invalid credit card number."));
        
        // Test status setter
        payment.setStatus(PaymentStatus.REFUNDED);
        assertEquals(PaymentStatus.REFUNDED, payment.getStatus());
    }

    @Test
    void testDebitCardValidation() {
        // Test invalid card number
        DebitCard invalidCard = new DebitCard("1234", "John Doe", "1234", 1000.0);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        assertFalse(invalidCard.processPayment(500.0));
        System.setOut(originalOut);
        String output = baos.toString();
        assertTrue(output.contains("Transaction failed: invalid debit card number."));

        // Test invalid PIN
        DebitCard invalidPinCard = new DebitCard("1234567890123456", "John Doe", "123", 1000.0);
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        assertFalse(invalidPinCard.processPayment(500.0));
        System.setOut(originalOut);
        output = baos.toString();
        assertTrue(output.contains("Transaction failed: incorrect PIN."));

        // Test zero or negative amount
        DebitCard validCard = new DebitCard("1234567890123456", "John Doe", "1234", 1000.0);
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        assertFalse(validCard.processPayment(0));
        System.setOut(originalOut);
        output = baos.toString();
        assertTrue(output.contains("Transaction failed: amount must be greater than 0."));

        // Test refund with invalid card number
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        invalidCard.processRefund(500.0);
        System.setOut(originalOut);
        output = baos.toString();
        assertTrue(output.contains("Refund failed: invalid debit card number."));

        // Test refund with invalid PIN
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        invalidPinCard.processRefund(500.0);
        System.setOut(originalOut);
        output = baos.toString();
        assertTrue(output.contains("Refund failed: incorrect PIN."));

        // Test successful refund
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        validCard.processRefund(500.0);
        System.setOut(originalOut);
        output = baos.toString();
        assertTrue(output.contains("Debit card refund of $500.0 processed for cardholder John Doe using card ************3456 with valid PIN."));

        // Test card number masking with very short number
        DebitCard shortCard = new DebitCard("1234", "John Doe", "1234", 1000.0);
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        shortCard.processRefund(500.0);
        System.setOut(originalOut);
        output = baos.toString();
        assertTrue(output.contains("Refund failed: invalid debit card number."));
    }

    @Test
    void testCreditCardValidation() {
        // Test invalid card number
        CreditCard invalidCard = new CreditCard("John Doe", "1234", "12/25", 1000.0);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        assertFalse(invalidCard.processPayment(500.0));
        System.setOut(originalOut);
        String output = baos.toString();
        assertTrue(output.contains("Transaction failed: invalid credit card number."));

        // Test invalid expiry date
        CreditCard invalidExpiryCard = new CreditCard("John Doe", "1234567890123456", "12/20", 1000.0);
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        assertFalse(invalidExpiryCard.processPayment(500.0));
        System.setOut(originalOut);
        output = baos.toString();
        assertTrue(output.contains("Transaction failed: credit card has expired."));

        // Test zero or negative amount
        CreditCard validCard = new CreditCard("John Doe", "1234567890123456", "12/25", 1000.0);
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        assertFalse(validCard.processPayment(0));
        System.setOut(originalOut);
        output = baos.toString();
        assertTrue(output.contains("Transaction failed: amount must be greater than 0."));

        // Test successful payment
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        assertTrue(validCard.processPayment(500.0));
        System.setOut(originalOut);
        output = baos.toString();
        assertTrue(output.contains("Credit card payment of $500.0 processed for cardholder John Doe using card ************3456 expiring on 12/25."));

        // Test successful refund
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        validCard.processRefund(500.0);
        System.setOut(originalOut);
        output = baos.toString();
        assertTrue(output.contains("Credit card refund of $500.0 processed for cardholder John Doe using card ************3456 expiring on 12/25."));

        // Test card number masking with very short number
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        invalidCard.processRefund(500.0);
        System.setOut(originalOut);
        output = baos.toString();
        assertTrue(output.contains("Refund failed: invalid credit card number."));
    }

    @Test
    void testMobilePaymentValidation() {
        // Test invalid phone number
        MobilePayment invalidPhone = new MobilePayment("123", 1000.0);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        assertFalse(invalidPhone.processPayment(500.0));
        System.setOut(originalOut);
        String output = baos.toString();
        assertTrue(output.contains("Transaction failed: invalid phone number."));

        // Test zero or negative amount
        MobilePayment validPhone = new MobilePayment("1234567890", 1000.0);
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        assertFalse(validPhone.processPayment(0));
        System.setOut(originalOut);
        output = baos.toString();
        assertTrue(output.contains("Transaction failed: amount must be greater than 0."));

        // Test successful payment
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        assertTrue(validPhone.processPayment(500.0));
        System.setOut(originalOut);
        output = baos.toString();
        assertTrue(output.contains("Mobile payment of $500.0 processed for phone number ******7890."));

        // Test refund with invalid phone number
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        invalidPhone.processRefund(500.0);
        System.setOut(originalOut);
        output = baos.toString();
        assertTrue(output.contains("Refund failed: invalid phone number."));

        // Test successful refund
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        validPhone.processRefund(500.0);
        System.setOut(originalOut);
        output = baos.toString();
        assertTrue(output.contains("Mobile payment refund of $500.0 processed for phone number ******7890."));

        // Test phone number masking with very short number (length <= 4)
        MobilePayment veryShortPhone = new MobilePayment("1234", 1000.0);
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        veryShortPhone.processRefund(500.0);
        System.setOut(originalOut);
        output = baos.toString();
        assertTrue(output.contains("Mobile payment refund of $500.0 processed for phone number 1234."));
    }
} 