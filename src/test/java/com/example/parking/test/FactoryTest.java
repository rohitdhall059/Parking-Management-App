package com.example.parking.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.example.parking.factory.ClientFactory;
import com.example.parking.factory.PaymentFactory; 
import com.example.parking.factory.PaymentMethodFactory;
import com.example.parking.factory.PricingStrategyFactory;
import com.example.parking.model.Client;
import com.example.parking.model.FacultyMember;
import com.example.parking.model.payment.CreditCard;
import com.example.parking.model.payment.DebitCard;
import com.example.parking.model.payment.MobilePayment;
import com.example.parking.model.payment.PaymentMethod;
import com.example.parking.strategy.PricingStrategy; 
import com.example.parking.strategy.StudentPricing; 

public class FactoryTest {
    // Test 1: Verify that ClientFactory returns a FacultyMember for type "FM"
    @Test
    public void testCreateFacultyMember() {
        Client client = ClientFactory.createClient("FM", "id1", "Alice", "alice@example.com");
        assertNotNull(client);
        assertTrue(client instanceof FacultyMember);
    }

    // Test 2: Verify that ClientFactory throws an exception for an invalid client type
    @Test
    public void testCreateInvalidClient() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            ClientFactory.createClient("UNKNOWN", "id2", "Bob", "bob@example.com")
        );
        assertTrue(exception.getMessage().contains("Unknown client type"));
    }

    // Test 3: Verify that PaymentFactory creates a CreditCard payment method with valid details
    @Test
    public void testCreateCreditCardPaymentMethod() {
        PaymentMethod pm = PaymentFactory.createPaymentMethod("CREDIT_CARD", "John Doe", "1111-2222-3333-4444", "12/25");
        assertNotNull(pm);
        assertTrue(pm instanceof CreditCard);
    }

    // Test 4: Verify that PaymentFactory creates a MobilePayment payment method with valid details
    @Test
    public void testCreateMobilePaymentMethod() {
        PaymentMethod pm = PaymentFactory.createPaymentMethod("MOBILE_PAYMENT", "1234567890");
        assertNotNull(pm);
        assertTrue(pm instanceof MobilePayment);
    }

    // Test 5: Verify that PaymentFactory throws an exception for CREDIT_CARD with invalid argument count
    @Test
    public void testInvalidCreditCardArguments() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            PaymentFactory.createPaymentMethod("CREDIT_CARD", "John Doe", "1111-2222-3333-4444")
        );
        assertTrue(exception.getMessage().contains("Invalid number of arguments"));
    }

    // Test 6: Verify that PaymentMethodFactory creates a CreditCard when using type "credit"
    @Test
    public void testPaymentMethodFactoryCredit() {
        PaymentMethod pm = PaymentMethodFactory.createPaymentMethod("credit", "5555-6666-7777-8888", "12/34");
        assertNotNull(pm);
        assertTrue(pm instanceof CreditCard);
    }

    // Test 7: Verify that PaymentMethodFactory creates a MobilePayment when using type "mobile"
    @Test
    public void testPaymentMethodFactoryMobile() {
        PaymentMethod pm = PaymentMethodFactory.createPaymentMethod("mobile", "anyCardNumber", "Jane Doe");
        assertNotNull(pm);
        assertTrue(pm instanceof MobilePayment);
    }

    // Test 8: Verify that PaymentMethodFactory throws an exception for an unknown payment method type
    @Test
    public void testPaymentMethodFactoryUnknown() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            PaymentMethodFactory.createPaymentMethod("unknown", "0000", "credential")
        );
        assertTrue(exception.getMessage().contains("Unknown payment method type"));
    }

    // Test 9: Verify that PricingStrategyFactory creates a StudentPricing instance for type "student"
    @Test
    public void testPricingStrategyFactoryStudent() {
        PricingStrategy strategy = PricingStrategyFactory.getPricingStrategy("student");
        assertNotNull(strategy);
        assertTrue(strategy instanceof StudentPricing);
    }

    // Test 10: Verify that PricingStrategyFactory throws an exception when provided an empty client type
    @Test
    public void testPricingStrategyFactoryInvalidType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            PricingStrategyFactory.getPricingStrategy("")
        );
        assertTrue(exception.getMessage().contains("Client type cannot be null or empty"));
    }

    // Test 11: Verify that getDefaultPaymentMethod returns a valid CreditCard instance
    @Test
    public void testGetDefaultPaymentMethod() {
        PaymentMethod defaultPaymentMethod = PaymentMethodFactory.getDefaultPaymentMethod();
        assertNotNull(defaultPaymentMethod);
        assertTrue(defaultPaymentMethod instanceof CreditCard);
        assertEquals("0000-0000-0000-0000", defaultPaymentMethod.getCardNumber());
        assertEquals("12/34", defaultPaymentMethod.getCredential());
        assertEquals(0.0, defaultPaymentMethod.getAmount());
    }

    // Test 12: Verify that PaymentMethodFactory throws an exception for null type
    @Test
    public void testPaymentMethodFactoryNullType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            PaymentMethodFactory.createPaymentMethod(null, "0000", "credential")
        );
        assertTrue(exception.getMessage().contains("Unknown payment method type"));
    }

    // Test 13: Verify that PaymentMethodFactory throws an exception for empty type
    @Test
    public void testPaymentMethodFactoryEmptyType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            PaymentMethodFactory.createPaymentMethod("", "0000", "credential")
        );
        assertTrue(exception.getMessage().contains("Unknown payment method type"));
    }

    // Test 14: Verify that PaymentMethodFactory throws an exception for invalid expiry date format
    @Test
    public void testPaymentMethodFactoryInvalidExpiryDate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            PaymentMethodFactory.createPaymentMethod("credit", "5555-6666-7777-8888", "INVALID_DATE")
        );
        assertTrue(exception.getMessage().contains("Invalid expiry date format"));
    }

    // Test 15: Verify that PaymentMethodFactory throws an exception for invalid card number format
    @Test
    public void testPaymentMethodFactoryInvalidCardNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            PaymentMethodFactory.createPaymentMethod("credit", "INVALID_CARD_NUMBER", "12/34")
        );
        assertTrue(exception.getMessage().contains("Invalid card number format"));
    }

    // Test 16: Verify that PaymentMethodFactory throws an exception for invalid PIN for DebitCard
    @Test
    public void testPaymentMethodFactoryInvalidPin() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            PaymentMethodFactory.createPaymentMethod("debit", "5555-6666-7777-8888", "INVALID_PIN")
        );
        assertTrue(exception.getMessage().contains("Invalid PIN format"));
    }

    // Test 17: Verify that PaymentMethodFactory creates a valid DebitCard payment method
    @Test
    public void testPaymentMethodFactoryDebit() {
        PaymentMethod pm = PaymentMethodFactory.createPaymentMethod("debit", "5555-6666-7777-8888", "1234");
        assertNotNull(pm);
        assertTrue(pm instanceof DebitCard);
    }
    
}