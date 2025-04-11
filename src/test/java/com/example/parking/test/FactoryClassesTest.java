package com.example.parking.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.parking.factory.ClientFactory;
import com.example.parking.factory.PaymentMethodFactory;
import com.example.parking.factory.PricingStrategyFactory;
import com.example.parking.model.Client;
import com.example.parking.model.FacultyMember;
import com.example.parking.model.NonFacultyStaff;
import com.example.parking.model.Student;
import com.example.parking.model.Visitor;
import com.example.parking.model.payment.CreditCard;
import com.example.parking.model.payment.DebitCard;
import com.example.parking.model.payment.MobilePayment;
import com.example.parking.model.payment.PaymentMethod;
import com.example.parking.strategy.FacultyPricing;
import com.example.parking.strategy.NonFacultyStaffPricing;
import com.example.parking.strategy.PricingStrategy;
import com.example.parking.strategy.StudentPricing;
import com.example.parking.strategy.VisitorPricing;

public class FactoryClassesTest {

    @Test
    void testClientFactory() {
        // Test creating different types of clients
        Client faculty = ClientFactory.createClient("FM", "FM001", "John Smith", "john@example.com");
        assertTrue(faculty instanceof FacultyMember);
        assertEquals("FM001", faculty.getId());
        assertEquals("John Smith", faculty.getName());
        assertEquals("john@example.com", faculty.getEmail());
        
        Client student = ClientFactory.createClient("ST", "ST001", "Jane Doe", "jane@example.com");
        assertTrue(student instanceof Student);
        assertEquals("ST001", student.getId());
        assertEquals("Jane Doe", student.getName());
        assertEquals("jane@example.com", student.getEmail());
        
        Client staff = ClientFactory.createClient("NF", "NF001", "Bob Johnson", "bob@example.com");
        assertTrue(staff instanceof NonFacultyStaff);
        assertEquals("NF001", staff.getId());
        assertEquals("Bob Johnson", staff.getName());
        assertEquals("bob@example.com", staff.getEmail());
        
        Client visitor = ClientFactory.createClient("VI", "VI001", "Alice Brown", "alice@example.com");
        assertTrue(visitor instanceof Visitor);
        assertEquals("VI001", visitor.getId());
        assertEquals("Alice Brown", visitor.getName());
        assertEquals("alice@example.com", visitor.getEmail());
        
        // Test invalid client type
        assertThrows(IllegalArgumentException.class, () -> {
            ClientFactory.createClient("XX", "XX001", "Invalid User", "invalid@example.com");
        });
    }
    
    @Test
    void testPaymentMethodFactory() {
        // Test creating different types of payment methods
        PaymentMethod creditCard = PaymentMethodFactory.createPaymentMethod("credit", "1234567890123456", "12/25");
        assertTrue(creditCard instanceof CreditCard);
        assertEquals("1234567890123456", creditCard.getCardNumber());
        assertEquals("12/25", creditCard.getCredential());
        
        PaymentMethod debitCard = PaymentMethodFactory.createPaymentMethod("debit", "1234567890123456", "1234");
        assertTrue(debitCard instanceof DebitCard);
        assertEquals("1234567890123456", debitCard.getCardNumber());
        assertEquals("1234", debitCard.getCredential());
        
        PaymentMethod mobilePayment = PaymentMethodFactory.createPaymentMethod("mobile", "1234567890", "John Smith");
        assertTrue(mobilePayment instanceof MobilePayment);
        assertEquals("1234567890", mobilePayment.getCardNumber());
        assertEquals("John Smith", mobilePayment.getCredential());
        
        // Test default payment method
        PaymentMethod defaultPayment = PaymentMethodFactory.getDefaultPaymentMethod();
        assertTrue(defaultPayment instanceof CreditCard);
        
        // Test invalid payment method type
        assertThrows(IllegalArgumentException.class, () -> {
            PaymentMethodFactory.createPaymentMethod("invalid", "1234567890123456", "12/25");
        });
    }
    
    @Test
    void testPricingStrategyFactory() {
        // Test creating different types of pricing strategies
        PricingStrategy facultyPricing = PricingStrategyFactory.getPricingStrategy("faculty");
        assertTrue(facultyPricing instanceof FacultyPricing);
        assertEquals(8.0, facultyPricing.getRate());
        assertEquals("FACULTY", facultyPricing.getType());
        
        PricingStrategy studentPricing = PricingStrategyFactory.getPricingStrategy("student");
        assertTrue(studentPricing instanceof StudentPricing);
        assertEquals(5.0, studentPricing.getRate());
        assertEquals("STUDENT", studentPricing.getType());
        
        PricingStrategy staffPricing = PricingStrategyFactory.getPricingStrategy("non_faculty_staff");
        assertTrue(staffPricing instanceof NonFacultyStaffPricing);
        assertEquals(10.0, staffPricing.getRate());
        assertEquals("NON_FACULTY_STAFF", staffPricing.getType());
        
        PricingStrategy visitorPricing = PricingStrategyFactory.getPricingStrategy("visitor");
        assertTrue(visitorPricing instanceof VisitorPricing);
        assertEquals(15.0, visitorPricing.getRate());
        assertEquals("VISITOR", visitorPricing.getType());
        
        // Test null client type
        assertThrows(IllegalArgumentException.class, () -> {
            PricingStrategyFactory.getPricingStrategy(null);
        });
        
        // Test empty client type
        assertThrows(IllegalArgumentException.class, () -> {
            PricingStrategyFactory.getPricingStrategy("");
        });
        
        // Test invalid client type
        assertThrows(IllegalArgumentException.class, () -> {
            PricingStrategyFactory.getPricingStrategy("invalid");
        });
    }
}