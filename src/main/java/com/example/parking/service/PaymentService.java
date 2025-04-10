package com.example.parking.service;

import java.util.List;

import com.example.parking.dao.BookingDAO;
import com.example.parking.model.Booking;
import com.example.parking.model.payment.PaymentMethod;

public class PaymentService {
    private final BookingDAO bookingDAO;

    public PaymentService(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    public void processPayment(Booking booking) {
        PaymentMethod paymentMethod = booking.getPaymentMethod();
        if (paymentMethod == null) {
            throw new IllegalStateException("No payment method specified for booking: " + booking.getClientId());
        }

        // Process payment using the payment method
        boolean success = paymentMethod.processPayment(booking.getAmount());
        if (!success) {
            throw new IllegalStateException("Payment processing failed for booking: " + booking.getClientId());
        }

        // Update booking status
        booking.setStatus("PAID");
        bookingDAO.update(booking);
    }

    public void processRefund(Booking booking) {
        PaymentMethod paymentMethod = booking.getPaymentMethod();
        if (paymentMethod == null) {
            throw new IllegalStateException("No payment method specified for booking: " + booking.getClientId());
        }

        // Calculate refund amount (e.g., 80% of the booking amount for cancellations)
        double refundAmount = booking.getAmount() * 0.8;

        try {
            paymentMethod.processRefund(refundAmount);
        } catch (Exception e) {
            throw new IllegalStateException("Refund processing failed for booking: " + booking.getClientId(), e);
        }

        // Update booking status
        booking.setStatus("REFUNDED");
        bookingDAO.update(booking);
    }

    public List<Booking> getUnpaidBookings() {
        return bookingDAO.getAll().stream()
                .filter(booking -> "CONFIRMED".equals(booking.getStatus()))
                .toList();
    }

    public List<Booking> getRefundedBookings() {
        return bookingDAO.getAll().stream()
                .filter(booking -> "REFUNDED".equals(booking.getStatus()))
                .toList();
    }
} 