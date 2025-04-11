
package com.example.parking.tests;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.example.parking.dao.BookingDAO;
import com.example.parking.model.Booking;
import com.example.parking.model.Client;
import com.example.parking.model.payment.PaymentMethod;
import com.example.parking.service.PaymentService;

public class PaymentServiceTest {
    private PaymentService paymentService;

@Mock
private BookingDAO bookingDAO;

@Mock
private PaymentMethod paymentMethod;

@Mock
private Booking booking;

@Mock
private Client client;

@BeforeEach
void setUp() {
    // Initialize mocks
    MockitoAnnotations.openMocks(this);
    paymentService = new PaymentService(bookingDAO);
    
    // Set default stubs for booking and client behavior
    when(booking.getClient()).thenReturn(client);
    when(client.getId()).thenReturn("client123");
    when(booking.getAmount()).thenReturn(100.0);
}

// Test 1: Successful Payment Processing when paymentMethod.processPayment returns true.
@Test
void testProcessPayment_success() {
    when(booking.getPaymentMethod()).thenReturn(paymentMethod);
    when(paymentMethod.processPayment(100.0)).thenReturn(true);

    paymentService.processPayment(booking);

    verify(paymentMethod, times(1)).processPayment(100.0);
    verify(booking).setStatus("PAID");
    verify(bookingDAO).update(booking);
}

// Test 2: Process Payment throws exception when no PaymentMethod is provided.
@Test
void testProcessPayment_noPaymentMethod() {
    when(booking.getPaymentMethod()).thenReturn(null);

    IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
        paymentService.processPayment(booking);
    });
    assertTrue(exception.getMessage().contains("No payment method specified"));
}

// Test 3: Process Payment throws exception when payment method processing fails (returns false).
@Test
void testProcessPayment_failure() {
    when(booking.getPaymentMethod()).thenReturn(paymentMethod);
    when(paymentMethod.processPayment(100.0)).thenReturn(false);

    IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
        paymentService.processPayment(booking);
    });
    assertTrue(exception.getMessage().contains("Payment processing failed"));
}

// Test 4: Successful Refund Processing when processRefund completes without exception.
@Test
void testProcessRefund_success() {
    when(booking.getPaymentMethod()).thenReturn(paymentMethod);
    // Expect refund amount 80.0 (80% of 100.0) to be processed without error
    doNothing().when(paymentMethod).processRefund(80.0);

    paymentService.processRefund(booking);

    verify(paymentMethod, times(1)).processRefund(80.0);
    verify(booking).setStatus("REFUNDED");
    verify(bookingDAO).update(booking);
}

// Test 5: Process Refund throws exception when no PaymentMethod is provided.
@Test
void testProcessRefund_noPaymentMethod() {
    when(booking.getPaymentMethod()).thenReturn(null);

    IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
        paymentService.processRefund(booking);
    });
    assertTrue(exception.getMessage().contains("No payment method specified"));
}

// Test 6: Process Refund throws exception when PaymentMethod.processRefund throws an exception.
@Test
void testProcessRefund_exception() {
    when(booking.getPaymentMethod()).thenReturn(paymentMethod);
    doThrow(new RuntimeException("Refund error")).when(paymentMethod).processRefund(80.0);

    IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
        paymentService.processRefund(booking);
    });
    assertTrue(exception.getMessage().contains("Refund processing failed"));
    assertNotNull(exception.getCause());
}

// Test 7: getUnpaidBookings returns only bookings with status "CONFIRMED"
@Test
void testGetUnpaidBookings_returnsConfirmedBookings() {
    Booking confirmedBooking = mock(Booking.class);
    when(confirmedBooking.getStatus()).thenReturn("CONFIRMED");
    Booking paidBooking = mock(Booking.class);
    when(paidBooking.getStatus()).thenReturn("PAID");
    when(bookingDAO.getAll()).thenReturn(List.of(confirmedBooking, paidBooking));

    List<Booking> unpaidBookings = paymentService.getUnpaidBookings();
    assertEquals(1, unpaidBookings.size());
    assertEquals("CONFIRMED", unpaidBookings.get(0).getStatus());
}

// Test 8: getUnpaidBookings returns an empty list when there are no bookings with "CONFIRMED" status.
@Test
void testGetUnpaidBookings_empty() {
    Booking paidBooking = mock(Booking.class);
    when(paidBooking.getStatus()).thenReturn("PAID");
    when(bookingDAO.getAll()).thenReturn(List.of(paidBooking));

    List<Booking> unpaidBookings = paymentService.getUnpaidBookings();
    assertTrue(unpaidBookings.isEmpty());
}

// Test 9: getRefundedBookings returns only bookings with status "REFUNDED"
@Test
void testGetRefundedBookings_returnsRefundedBookings() {
    Booking refundedBooking = mock(Booking.class);
    when(refundedBooking.getStatus()).thenReturn("REFUNDED");
    Booking confirmedBooking = mock(Booking.class);
    when(confirmedBooking.getStatus()).thenReturn("CONFIRMED");
    when(bookingDAO.getAll()).thenReturn(List.of(refundedBooking, confirmedBooking));

    List<Booking> refundedBookings = paymentService.getRefundedBookings();
    assertEquals(1, refundedBookings.size());
    assertEquals("REFUNDED", refundedBookings.get(0).getStatus());
}

// Test 10: getRefundedBookings returns an empty list when there are no bookings with "REFUNDED" status.
@Test
void testGetRefundedBookings_empty() {
    Booking confirmedBooking = mock(Booking.class);
    when(confirmedBooking.getStatus()).thenReturn("CONFIRMED");
    Booking paidBooking = mock(Booking.class);
    when(paidBooking.getStatus()).thenReturn("PAID");
    when(bookingDAO.getAll()).thenReturn(List.of(confirmedBooking, paidBooking));

    List<Booking> refundedBookings = paymentService.getRefundedBookings();
    assertTrue(refundedBookings.isEmpty());
}

}

