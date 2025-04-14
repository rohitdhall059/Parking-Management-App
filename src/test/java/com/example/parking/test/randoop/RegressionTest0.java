package com.example.parking.test.randoop;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

    public static boolean debug = false;

    @Test
    public void test001() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test001");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str9 = booking6.toString();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.example.parking.model.Client.getId()\" because \"this.client\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test002");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        java.time.LocalDateTime localDateTime12 = null;
        // The following exception was thrown during execution in test generation
        try {
            booking6.extendParkingTime(localDateTime12, "hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDateTime.isBefore(java.time.chrono.ChronoLocalDateTime)\" because \"newEndTime\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(paymentMethod7);
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test003");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        com.example.parking.model.Car car9 = null;
        // The following exception was thrown during execution in test generation
        try {
            booking6.setOccupied(false, car9);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.example.parking.model.ParkingSpace.setOccupied(boolean, com.example.parking.model.Car)\" because \"this.spaceId\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(paymentMethod7);
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test004");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        booking6.setAmount((double) (short) 0);
        com.example.parking.model.ParkingSpace parkingSpace14 = null;
        booking6.setSpaceId(parkingSpace14);
        java.lang.Class<?> wildcardClass16 = booking6.getClass();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertNotNull(wildcardClass16);
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test005");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str10 = booking6.getClientId();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.example.parking.model.Client.getId()\" because \"this.client\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(paymentMethod7);
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test006");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        booking6.setAmount((double) (short) 0);
        com.example.parking.model.ParkingSpace parkingSpace14 = null;
        booking6.setSpaceId(parkingSpace14);
        // The following exception was thrown during execution in test generation
        try {
            booking6.cancelBooking();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.temporal.Temporal.until(java.time.temporal.Temporal, java.time.temporal.TemporalUnit)\" because \"temporal1Inclusive\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(paymentMethod7);
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test007");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.lang.String str9 = booking6.getStatus();
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Active" + "'", str9, "Active");
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test008");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        // The following exception was thrown during execution in test generation
        try {
            booking6.cancelBooking();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.temporal.Temporal.until(java.time.temporal.Temporal, java.time.temporal.TemporalUnit)\" because \"temporal1Inclusive\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(paymentMethod7);
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test009");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        com.example.parking.model.payment.PaymentMethod paymentMethod12 = null;
        booking6.setPaymentMethod(paymentMethod12);
        org.junit.Assert.assertNull(paymentMethod7);
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test010");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getId();
        parkingSpace2.enable();
        java.lang.String str5 = parkingSpace2.toString();
        java.lang.String str6 = parkingSpace2.getLicensePlate();
        parkingSpace2.setEnabled(false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hi!" + "'", str3, "hi!");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str5, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test011");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getId();
        parkingSpace4.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState7 = parkingSpace4.getState();
        java.time.LocalDateTime localDateTime8 = null;
        java.time.LocalDateTime localDateTime9 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.example.parking.model.Booking booking11 = com.example.parking.model.Booking.createBooking("ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}", client1, parkingSpace4, localDateTime8, localDateTime9, "No car");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDateTime.isAfter(java.time.chrono.ChronoLocalDateTime)\" because \"startTime\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "hi!" + "'", str5, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState7);
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test012");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.time.LocalDateTime localDateTime9 = null;
        booking6.setEndTime(localDateTime9);
        // The following exception was thrown during execution in test generation
        try {
            booking6.cancelBooking();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.temporal.Temporal.until(java.time.temporal.Temporal, java.time.temporal.TemporalUnit)\" because \"temporal1Inclusive\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test013");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        booking6.setLicensePlate("");
        org.junit.Assert.assertNull(paymentMethod7);
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test014");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getId();
        parkingSpace4.enable();
        java.lang.String str7 = parkingSpace4.toString();
        parkingSpace4.disable();
        java.lang.String str9 = parkingSpace4.toString();
        java.time.LocalDateTime localDateTime10 = null;
        java.time.LocalDateTime localDateTime11 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod12 = null;
        com.example.parking.model.Booking booking13 = new com.example.parking.model.Booking("Available", client1, parkingSpace4, localDateTime10, localDateTime11, paymentMethod12);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str14 = booking13.toString();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.example.parking.model.Client.getId()\" because \"this.client\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "hi!" + "'", str5, "hi!");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str9, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test015");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        java.time.LocalDateTime localDateTime6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.example.parking.model.Booking booking9 = com.example.parking.model.Booking.createBooking("Available", client1, parkingSpace4, localDateTime6, localDateTime7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDateTime.isAfter(java.time.chrono.ChronoLocalDateTime)\" because \"startTime\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test016");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.lang.String str9 = booking6.getStatus();
        java.lang.String str10 = booking6.getBookingId();
        java.time.LocalDateTime localDateTime11 = booking6.getEndTime();
        java.lang.String str12 = booking6.getStatus();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Active" + "'", str9, "Active");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "hi!" + "'", str10, "hi!");
        org.junit.Assert.assertNull(localDateTime11);
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "Active" + "'", str12, "Active");
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test017");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.lang.String str9 = booking6.getStatus();
        java.lang.String str10 = booking6.getBookingId();
        java.time.LocalDateTime localDateTime11 = null;
        // The following exception was thrown during execution in test generation
        try {
            booking6.extendParkingTime(localDateTime11, "Available");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDateTime.isBefore(java.time.chrono.ChronoLocalDateTime)\" because \"newEndTime\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Active" + "'", str9, "Active");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "hi!" + "'", str10, "hi!");
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test018");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        double double8 = booking6.getTotalCost();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 0.0d + "'", double8 == 0.0d);
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test019");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setLicensePlate("Active");
        double double9 = booking6.getDeposit();
        booking6.setStatus("ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        booking6.setBookingId("hi!");
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 10.0d + "'", double9 == 10.0d);
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test020");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        com.example.parking.model.ParkingSpace parkingSpace8 = booking6.getParkingSpace();
        com.example.parking.model.Client client9 = null;
        booking6.setClient(client9);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str11 = booking6.getClientId();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.example.parking.model.Client.getId()\" because \"this.client\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertNull(parkingSpace8);
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test021");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setAmount((double) 10L);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str9 = booking6.toString();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.example.parking.model.Client.getId()\" because \"this.client\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test022");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processRefund((double) (short) -1);
        double double9 = booking6.getTotalCost();
        java.time.LocalDateTime localDateTime10 = null;
        // The following exception was thrown during execution in test generation
        try {
            booking6.extendParkingTime(localDateTime10, "");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDateTime.isBefore(java.time.chrono.ChronoLocalDateTime)\" because \"newEndTime\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 0.0d + "'", double9 == 0.0d);
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test023");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.time.LocalDateTime localDateTime9 = null;
        booking6.setEndTime(localDateTime9);
        booking6.setDeposit((double) 1.0f);
        java.time.LocalDateTime localDateTime13 = null;
        booking6.setStartTime(localDateTime13);
        java.time.LocalDateTime localDateTime15 = null;
        booking6.setEndTime(localDateTime15);
        double double17 = booking6.getTotalCost();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertTrue("'" + double17 + "' != '" + 0.0d + "'", double17 == 0.0d);
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test024");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setLicensePlate("Active");
        booking6.setStatus("Available");
        booking6.setDeposit((double) (byte) 1);
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test025");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        double double12 = booking6.getDeposit();
        booking6.setStatus("Active");
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 10.0d + "'", double12 == 10.0d);
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test026");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace6 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str7 = parkingSpace6.getId();
        parkingSpace6.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState9 = parkingSpace6.getState();
        parkingSpace2.setState(parkingSpaceState9);
        parkingSpace2.setEnabled(true);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "hi!" + "'", str7, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState9);
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test027");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        double double9 = booking6.getTotalCost();
        com.example.parking.model.payment.PaymentMethod paymentMethod10 = null;
        booking6.setPaymentMethod(paymentMethod10);
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 0.0d + "'", double9 == 0.0d);
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test028");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getId();
        parkingSpace2.enable();
        parkingSpace2.clearObservers();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hi!" + "'", str3, "hi!");
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test029");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getId();
        parkingSpace4.enable();
        java.lang.String str7 = parkingSpace4.toString();
        parkingSpace4.disable();
        java.lang.String str9 = parkingSpace4.toString();
        java.time.LocalDateTime localDateTime10 = null;
        java.time.LocalDateTime localDateTime11 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod12 = null;
        com.example.parking.model.Booking booking13 = new com.example.parking.model.Booking("Available", client1, parkingSpace4, localDateTime10, localDateTime11, paymentMethod12);
        boolean boolean14 = parkingSpace4.isBooked();
        boolean boolean15 = parkingSpace4.isOccupied();
        boolean boolean16 = parkingSpace4.isBooked();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "hi!" + "'", str5, "hi!");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str9, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test030");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        java.lang.String str7 = booking6.getLicensePlate();
        org.junit.Assert.assertNull(str7);
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test031");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str7 = booking6.getClientId();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.example.parking.model.Client.getId()\" because \"this.client\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test032");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        boolean boolean4 = parkingSpace2.isBooked();
        java.lang.String str5 = parkingSpace2.toString();
        com.example.parking.observer.Observer observer6 = null;
        parkingSpace2.attach(observer6);
        java.lang.Class<?> wildcardClass8 = parkingSpace2.getClass();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str5, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test033");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setAmount((double) 10L);
        double double9 = booking6.getTotalCost();
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 10.0d + "'", double9 == 10.0d);
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test034");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setLicensePlate("Active");
        double double9 = booking6.getDeposit();
        // The following exception was thrown during execution in test generation
        try {
            double double10 = booking6.calculateRefund();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: temporal");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 10.0d + "'", double9 == 10.0d);
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test035");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setTotalCost((double) (byte) 100);
        booking6.setAmount((double) (-1.0f));
        java.time.LocalDateTime localDateTime11 = null;
        booking6.setEndTime(localDateTime11);
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test036");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processRefund((double) (short) -1);
        // The following exception was thrown during execution in test generation
        try {
            double double9 = booking6.calculateRefund();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: temporal");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test037");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.Client client3 = null;
        com.example.parking.model.ParkingSpace parkingSpace6 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str7 = parkingSpace6.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace10 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str11 = parkingSpace10.getId();
        parkingSpace10.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState13 = parkingSpace10.getState();
        parkingSpace6.setState(parkingSpaceState13);
        com.example.parking.observer.Observer observer15 = null;
        parkingSpace6.detach(observer15);
        java.time.LocalDateTime localDateTime17 = null;
        java.time.LocalDateTime localDateTime18 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod19 = null;
        com.example.parking.model.Booking booking20 = new com.example.parking.model.Booking("Active", client3, parkingSpace6, localDateTime17, localDateTime18, paymentMethod19);
        java.time.LocalDateTime localDateTime21 = null;
        java.time.LocalDateTime localDateTime22 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.example.parking.model.Booking booking24 = com.example.parking.model.Booking.createBooking("Active", client1, parkingSpace6, localDateTime21, localDateTime22, "Disabled");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDateTime.isAfter(java.time.chrono.ChronoLocalDateTime)\" because \"startTime\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "Available" + "'", str7, "Available");
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "hi!" + "'", str11, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState13);
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test038");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setTotalCost((double) (byte) 100);
        booking6.setAmount((double) (-1.0f));
        com.example.parking.model.ParkingSpace parkingSpace11 = booking6.getSpaceId();
        // The following exception was thrown during execution in test generation
        try {
            double double12 = booking6.calculateRefund();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: temporal");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(parkingSpace11);
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test039");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setTotalCost((double) (byte) 100);
        booking6.setAmount((double) (-1.0f));
        com.example.parking.model.ParkingSpace parkingSpace11 = booking6.getSpaceId();
        com.example.parking.model.Car car13 = null;
        // The following exception was thrown during execution in test generation
        try {
            booking6.setOccupied(false, car13);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.example.parking.model.ParkingSpace.setOccupied(boolean, com.example.parking.model.Car)\" because \"this.spaceId\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(parkingSpace11);
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test040");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace6 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str7 = parkingSpace6.getId();
        parkingSpace6.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState9 = parkingSpace6.getState();
        parkingSpace2.setState(parkingSpaceState9);
        parkingSpace2.setRate((double) 10);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "hi!" + "'", str7, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState9);
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test041");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        java.time.LocalDateTime localDateTime6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.example.parking.model.Booking booking9 = com.example.parking.model.Booking.createBooking("Disabled", client1, parkingSpace4, localDateTime6, localDateTime7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDateTime.isAfter(java.time.chrono.ChronoLocalDateTime)\" because \"startTime\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test042");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getId();
        parkingSpace4.enable();
        java.lang.String str7 = parkingSpace4.toString();
        parkingSpace4.disable();
        java.lang.String str9 = parkingSpace4.toString();
        java.time.LocalDateTime localDateTime10 = null;
        java.time.LocalDateTime localDateTime11 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod12 = null;
        com.example.parking.model.Booking booking13 = new com.example.parking.model.Booking("Available", client1, parkingSpace4, localDateTime10, localDateTime11, paymentMethod12);
        // The following exception was thrown during execution in test generation
        try {
            double double14 = booking13.calculateRefund();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: temporal");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "hi!" + "'", str5, "hi!");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str9, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test043");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        booking6.setAmount((double) (short) 0);
        com.example.parking.model.ParkingSpace parkingSpace14 = null;
        booking6.setSpaceId(parkingSpace14);
        booking6.setAmount((double) (-1L));
        // The following exception was thrown during execution in test generation
        try {
            booking6.cancelBooking();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.temporal.Temporal.until(java.time.temporal.Temporal, java.time.temporal.TemporalUnit)\" because \"temporal1Inclusive\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(paymentMethod7);
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test044");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setLicensePlate("Active");
        double double9 = booking6.getDeposit();
        booking6.processPayment((double) (short) -1);
        com.example.parking.model.Client client12 = null;
        booking6.setClient(client12);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str14 = booking6.toString();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.example.parking.model.Client.getId()\" because \"this.client\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 10.0d + "'", double9 == 10.0d);
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test045");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setLicensePlate("Active");
        double double9 = booking6.getDeposit();
        // The following exception was thrown during execution in test generation
        try {
            booking6.cancelBooking();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.temporal.Temporal.until(java.time.temporal.Temporal, java.time.temporal.TemporalUnit)\" because \"temporal1Inclusive\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 10.0d + "'", double9 == 10.0d);
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test046");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getId();
        java.lang.String str4 = parkingSpace2.getCarInfo();
        java.lang.String str5 = parkingSpace2.getCarInfo();
        com.example.parking.observer.Observer observer6 = null;
        parkingSpace2.attach(observer6);
        boolean boolean8 = parkingSpace2.isOccupied();
        parkingSpace2.free();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hi!" + "'", str3, "hi!");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "No car" + "'", str4, "No car");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "No car" + "'", str5, "No car");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test047");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        java.time.LocalDateTime localDateTime10 = booking6.getStartTime();
        // The following exception was thrown during execution in test generation
        try {
            booking6.cancelBooking();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.temporal.Temporal.until(java.time.temporal.Temporal, java.time.temporal.TemporalUnit)\" because \"temporal1Inclusive\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertNull(localDateTime10);
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test048");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setTotalCost((double) (byte) 100);
        booking6.setAmount((double) (-1.0f));
        com.example.parking.model.ParkingSpace parkingSpace11 = booking6.getSpaceId();
        java.time.LocalDateTime localDateTime12 = null;
        booking6.setStartTime(localDateTime12);
        org.junit.Assert.assertNull(parkingSpace11);
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test049");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.time.LocalDateTime localDateTime9 = null;
        booking6.setEndTime(localDateTime9);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str11 = booking6.getClientId();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.example.parking.model.Client.getId()\" because \"this.client\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test050");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processRefund((double) (short) -1);
        double double9 = booking6.getTotalCost();
        com.example.parking.model.payment.PaymentMethod paymentMethod10 = booking6.getPaymentMethod();
        booking6.setStatus("ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        booking6.setStatus("No car");
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 0.0d + "'", double9 == 0.0d);
        org.junit.Assert.assertNull(paymentMethod10);
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test051");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processRefund((double) (short) -1);
        booking6.setLicensePlate("");
        booking6.processRefund((double) 10);
        java.lang.String str13 = booking6.getStatus();
        // The following exception was thrown during execution in test generation
        try {
            booking6.cancelBooking();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.temporal.Temporal.until(java.time.temporal.Temporal, java.time.temporal.TemporalUnit)\" because \"temporal1Inclusive\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "Active" + "'", str13, "Active");
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test052");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getId();
        java.lang.String str4 = parkingSpace2.getCarInfo();
        java.lang.String str5 = parkingSpace2.getCarInfo();
        com.example.parking.observer.Observer observer6 = null;
        parkingSpace2.attach(observer6);
        com.example.parking.model.ParkingSpace parkingSpace10 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str11 = parkingSpace10.getId();
        parkingSpace10.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState13 = parkingSpace10.getState();
        boolean boolean14 = parkingSpace10.isOccupied();
        com.example.parking.state.ParkingSpaceState parkingSpaceState15 = parkingSpace10.getState();
        parkingSpace2.setState(parkingSpaceState15);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hi!" + "'", str3, "hi!");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "No car" + "'", str4, "No car");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "No car" + "'", str5, "No car");
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "hi!" + "'", str11, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(parkingSpaceState15);
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test053");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.lang.String str9 = booking6.getStatus();
        com.example.parking.model.Client client11 = null;
        com.example.parking.model.ParkingSpace parkingSpace14 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str15 = parkingSpace14.getId();
        parkingSpace14.enable();
        java.lang.String str17 = parkingSpace14.toString();
        parkingSpace14.disable();
        java.lang.String str19 = parkingSpace14.toString();
        java.time.LocalDateTime localDateTime20 = null;
        java.time.LocalDateTime localDateTime21 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod22 = null;
        com.example.parking.model.Booking booking23 = new com.example.parking.model.Booking("Available", client11, parkingSpace14, localDateTime20, localDateTime21, paymentMethod22);
        boolean boolean24 = parkingSpace14.isBooked();
        boolean boolean25 = parkingSpace14.isOccupied();
        booking6.setSpaceId(parkingSpace14);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str27 = booking6.getClientId();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.example.parking.model.Client.getId()\" because \"this.client\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Active" + "'", str9, "Active");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "hi!" + "'", str15, "hi!");
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str17, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str19, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test054");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        java.lang.Class<?> wildcardClass7 = booking6.getClass();
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test055");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.time.LocalDateTime localDateTime9 = null;
        booking6.setEndTime(localDateTime9);
        booking6.setDeposit((double) 1.0f);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str13 = booking6.toString();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.example.parking.model.Client.getId()\" because \"this.client\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test056");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace8 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str9 = parkingSpace8.getId();
        parkingSpace8.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState11 = parkingSpace8.getState();
        parkingSpace4.setState(parkingSpaceState11);
        com.example.parking.observer.Observer observer13 = null;
        parkingSpace4.detach(observer13);
        java.time.LocalDateTime localDateTime15 = null;
        java.time.LocalDateTime localDateTime16 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod17 = null;
        com.example.parking.model.Booking booking18 = new com.example.parking.model.Booking("Active", client1, parkingSpace4, localDateTime15, localDateTime16, paymentMethod17);
        parkingSpace4.vacate();
        com.example.parking.observer.Observer observer20 = null;
        parkingSpace4.detach(observer20);
        boolean boolean22 = parkingSpace4.isOccupied();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState11);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test057");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        boolean boolean4 = parkingSpace2.isDisabled();
        java.lang.String str5 = parkingSpace2.getCarInfo();
        java.lang.String str6 = parkingSpace2.getStatus();
        parkingSpace2.clearObservers();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "No car" + "'", str5, "No car");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "Available" + "'", str6, "Available");
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test058");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        boolean boolean4 = parkingSpace2.isBooked();
        com.example.parking.model.ParkingSpace parkingSpace7 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str8 = parkingSpace7.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace11 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str12 = parkingSpace11.getId();
        parkingSpace11.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState14 = parkingSpace11.getState();
        parkingSpace7.setState(parkingSpaceState14);
        parkingSpace2.setState(parkingSpaceState14);
        com.example.parking.state.ParkingSpaceState parkingSpaceState17 = parkingSpace2.getState();
        parkingSpace2.clearObservers();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "Available" + "'", str8, "Available");
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "hi!" + "'", str12, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState14);
        org.junit.Assert.assertNotNull(parkingSpaceState17);
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test059");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processRefund((double) (short) -1);
        booking6.setLicensePlate("");
        booking6.processRefund((double) 10);
        java.time.LocalDateTime localDateTime13 = null;
        // The following exception was thrown during execution in test generation
        try {
            booking6.extendParkingTime(localDateTime13, "No car");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDateTime.isBefore(java.time.chrono.ChronoLocalDateTime)\" because \"newEndTime\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test060");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace8 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str9 = parkingSpace8.getId();
        parkingSpace8.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState11 = parkingSpace8.getState();
        parkingSpace4.setState(parkingSpaceState11);
        com.example.parking.observer.Observer observer13 = null;
        parkingSpace4.detach(observer13);
        java.time.LocalDateTime localDateTime15 = null;
        java.time.LocalDateTime localDateTime16 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod17 = null;
        com.example.parking.model.Booking booking18 = new com.example.parking.model.Booking("Active", client1, parkingSpace4, localDateTime15, localDateTime16, paymentMethod17);
        boolean boolean19 = parkingSpace4.isDisabled();
        java.lang.String str20 = parkingSpace4.toString();
        boolean boolean21 = parkingSpace4.isBooked();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState11);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str20, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test061");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getId();
        parkingSpace2.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState5 = parkingSpace2.getState();
        boolean boolean6 = parkingSpace2.isOccupied();
        java.lang.String str7 = parkingSpace2.getCarInfo();
        java.lang.String str8 = parkingSpace2.toString();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hi!" + "'", str3, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "No car" + "'", str7, "No car");
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str8, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test062");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processRefund((double) (short) -1);
        double double9 = booking6.getTotalCost();
        com.example.parking.model.ParkingSpace parkingSpace10 = booking6.getParkingSpace();
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 0.0d + "'", double9 == 0.0d);
        org.junit.Assert.assertNull(parkingSpace10);
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test063");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        double double12 = booking6.getDeposit();
        booking6.setAmount((double) (short) 1);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str15 = booking6.toString();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.example.parking.model.Client.getId()\" because \"this.client\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 10.0d + "'", double12 == 10.0d);
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test064");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.lang.String str9 = booking6.getStatus();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str10 = booking6.getClientId();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.example.parking.model.Client.getId()\" because \"this.client\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Active" + "'", str9, "Active");
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test065");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        booking6.setAmount((double) (short) 0);
        com.example.parking.model.ParkingSpace parkingSpace14 = booking6.getParkingSpace();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertNull(parkingSpace14);
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test066");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        com.example.parking.model.payment.PaymentMethod paymentMethod8 = booking6.getPaymentMethod();
        com.example.parking.model.Car car10 = null;
        // The following exception was thrown during execution in test generation
        try {
            booking6.setOccupied(false, car10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.example.parking.model.ParkingSpace.setOccupied(boolean, com.example.parking.model.Car)\" because \"this.spaceId\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertNull(paymentMethod8);
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test067");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setTotalCost((double) (byte) 100);
        booking6.setAmount((double) (-1.0f));
        com.example.parking.model.ParkingSpace parkingSpace11 = booking6.getSpaceId();
        java.lang.Class<?> wildcardClass12 = booking6.getClass();
        org.junit.Assert.assertNull(parkingSpace11);
        org.junit.Assert.assertNotNull(wildcardClass12);
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test068");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        double double12 = booking6.getDeposit();
        java.time.LocalDateTime localDateTime13 = booking6.getEndTime();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 10.0d + "'", double12 == 10.0d);
        org.junit.Assert.assertNull(localDateTime13);
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test069");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.example.parking.model.Booking booking6 = com.example.parking.model.Booking.createBooking("Available", client1, parkingSpace2, localDateTime3, localDateTime4, "Available");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDateTime.isAfter(java.time.chrono.ChronoLocalDateTime)\" because \"startTime\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test070");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        booking6.setAmount((double) (short) 0);
        com.example.parking.model.ParkingSpace parkingSpace14 = null;
        booking6.setSpaceId(parkingSpace14);
        double double16 = booking6.getAmount();
        java.time.LocalDateTime localDateTime17 = null;
        booking6.setEndTime(localDateTime17);
        // The following exception was thrown during execution in test generation
        try {
            double double19 = booking6.calculateRefund();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: temporal");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 0.0d + "'", double16 == 0.0d);
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test071");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace8 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str9 = parkingSpace8.getId();
        parkingSpace8.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState11 = parkingSpace8.getState();
        parkingSpace4.setState(parkingSpaceState11);
        com.example.parking.observer.Observer observer13 = null;
        parkingSpace4.detach(observer13);
        java.time.LocalDateTime localDateTime15 = null;
        java.time.LocalDateTime localDateTime16 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod17 = null;
        com.example.parking.model.Booking booking18 = new com.example.parking.model.Booking("Active", client1, parkingSpace4, localDateTime15, localDateTime16, paymentMethod17);
        java.time.LocalDateTime localDateTime19 = null;
        // The following exception was thrown during execution in test generation
        try {
            booking18.extendParkingTime(localDateTime19, "Disabled");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDateTime.isBefore(java.time.chrono.ChronoLocalDateTime)\" because \"newEndTime\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState11);
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test072");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("No car", (double) 10.0f);
        java.lang.String str3 = parkingSpace2.getId();
        com.example.parking.observer.Observer observer4 = null;
        parkingSpace2.detach(observer4);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "No car" + "'", str3, "No car");
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test073");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processRefund((double) (short) -1);
        booking6.setLicensePlate("");
        booking6.processPayment((double) 1);
        booking6.setAmount((double) 10L);
        // The following exception was thrown during execution in test generation
        try {
            booking6.cancelBooking();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.temporal.Temporal.until(java.time.temporal.Temporal, java.time.temporal.TemporalUnit)\" because \"temporal1Inclusive\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test074");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processPayment((double) 10L);
        com.example.parking.model.ParkingSpace parkingSpace9 = null;
        booking6.setSpaceId(parkingSpace9);
        com.example.parking.model.payment.PaymentMethod paymentMethod11 = booking6.getPaymentMethod();
        org.junit.Assert.assertNull(paymentMethod11);
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test075");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processPayment((double) 10L);
        com.example.parking.model.ParkingSpace parkingSpace9 = null;
        booking6.setSpaceId(parkingSpace9);
        java.time.LocalDateTime localDateTime11 = booking6.getStartTime();
        booking6.setStatus("hi!");
        double double14 = booking6.getAmount();
        org.junit.Assert.assertNull(localDateTime11);
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 0.0d + "'", double14 == 0.0d);
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test076");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setLicensePlate("Active");
        booking6.checkout();
        double double10 = booking6.getTotalCost();
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + (-10.0d) + "'", double10 == (-10.0d));
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test077");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) (short) 0);
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test078");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getId();
        parkingSpace2.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState5 = parkingSpace2.getState();
        parkingSpace2.enable();
        java.lang.Class<?> wildcardClass7 = parkingSpace2.getClass();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hi!" + "'", str3, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState5);
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test079");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getId();
        parkingSpace4.enable();
        java.lang.String str7 = parkingSpace4.toString();
        parkingSpace4.disable();
        java.lang.String str9 = parkingSpace4.toString();
        java.time.LocalDateTime localDateTime10 = null;
        java.time.LocalDateTime localDateTime11 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod12 = null;
        com.example.parking.model.Booking booking13 = new com.example.parking.model.Booking("Available", client1, parkingSpace4, localDateTime10, localDateTime11, paymentMethod12);
        parkingSpace4.free();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "hi!" + "'", str5, "hi!");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str9, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test080");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getId();
        java.lang.String str4 = parkingSpace2.getSpaceId();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hi!" + "'", str3, "hi!");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "hi!" + "'", str4, "hi!");
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test081");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getId();
        parkingSpace4.enable();
        java.lang.String str7 = parkingSpace4.toString();
        parkingSpace4.disable();
        java.lang.String str9 = parkingSpace4.toString();
        java.time.LocalDateTime localDateTime10 = null;
        java.time.LocalDateTime localDateTime11 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod12 = null;
        com.example.parking.model.Booking booking13 = new com.example.parking.model.Booking("Available", client1, parkingSpace4, localDateTime10, localDateTime11, paymentMethod12);
        boolean boolean14 = parkingSpace4.isBooked();
        boolean boolean15 = parkingSpace4.isOccupied();
        java.lang.String str16 = parkingSpace4.getCarInfo();
        parkingSpace4.clearObservers();
        boolean boolean18 = parkingSpace4.isBooked();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "hi!" + "'", str5, "hi!");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str9, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "No car" + "'", str16, "No car");
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test082");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace8 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str9 = parkingSpace8.getId();
        parkingSpace8.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState11 = parkingSpace8.getState();
        parkingSpace4.setState(parkingSpaceState11);
        com.example.parking.observer.Observer observer13 = null;
        parkingSpace4.detach(observer13);
        java.time.LocalDateTime localDateTime15 = null;
        java.time.LocalDateTime localDateTime16 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod17 = null;
        com.example.parking.model.Booking booking18 = new com.example.parking.model.Booking("Active", client1, parkingSpace4, localDateTime15, localDateTime16, paymentMethod17);
        java.lang.String str19 = parkingSpace4.getId();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState11);
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "hi!" + "'", str19, "hi!");
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test083");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.lang.String str9 = booking6.getStatus();
        booking6.setBookingId("Available");
        booking6.setAmount((double) (-1L));
        double double14 = booking6.getAmount();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Active" + "'", str9, "Active");
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + (-1.0d) + "'", double14 == (-1.0d));
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test084");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getId();
        parkingSpace4.enable();
        java.lang.String str7 = parkingSpace4.toString();
        parkingSpace4.disable();
        java.lang.String str9 = parkingSpace4.toString();
        java.time.LocalDateTime localDateTime10 = null;
        java.time.LocalDateTime localDateTime11 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod12 = null;
        com.example.parking.model.Booking booking13 = new com.example.parking.model.Booking("Available", client1, parkingSpace4, localDateTime10, localDateTime11, paymentMethod12);
        boolean boolean14 = parkingSpace4.isBooked();
        boolean boolean15 = parkingSpace4.isOccupied();
        java.util.List<com.example.parking.observer.Observer> observerList16 = parkingSpace4.getObservers();
        java.util.List<com.example.parking.observer.Observer> observerList17 = parkingSpace4.getObservers();
        parkingSpace4.enable();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "hi!" + "'", str5, "hi!");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str9, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(observerList16);
        org.junit.Assert.assertNotNull(observerList17);
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test085");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        java.lang.String str12 = booking6.getLicensePlate();
        java.lang.String str13 = booking6.getStatus();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertNull(str12);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "Active" + "'", str13, "Active");
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test086");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.lang.String str9 = booking6.getStatus();
        java.lang.String str10 = booking6.getBookingId();
        java.time.LocalDateTime localDateTime11 = booking6.getEndTime();
        double double12 = booking6.getDeposit();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str13 = booking6.toString();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.example.parking.model.Client.getId()\" because \"this.client\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Active" + "'", str9, "Active");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "hi!" + "'", str10, "hi!");
        org.junit.Assert.assertNull(localDateTime11);
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 10.0d + "'", double12 == 10.0d);
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test087");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        boolean boolean4 = parkingSpace2.isDisabled();
        java.lang.String str5 = parkingSpace2.getCarInfo();
        java.lang.String str6 = parkingSpace2.getStatus();
        java.lang.String str7 = parkingSpace2.getStatus();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "No car" + "'", str5, "No car");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "Available" + "'", str6, "Available");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "Available" + "'", str7, "Available");
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test088");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setAmount((double) 10L);
        booking6.setTotalCost((double) (byte) -1);
        com.example.parking.model.Car car12 = null;
        // The following exception was thrown during execution in test generation
        try {
            booking6.setOccupied(true, car12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.example.parking.model.ParkingSpace.setOccupied(boolean, com.example.parking.model.Car)\" because \"this.spaceId\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test089");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setLicensePlate("Active");
        booking6.checkout();
        double double10 = booking6.getAmount();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str11 = booking6.getClientId();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.example.parking.model.Client.getId()\" because \"this.client\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + (-10.0d) + "'", double10 == (-10.0d));
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test090");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processPayment((double) 10L);
        com.example.parking.model.ParkingSpace parkingSpace9 = null;
        booking6.setSpaceId(parkingSpace9);
        com.example.parking.model.payment.PaymentMethod paymentMethod11 = null;
        booking6.setPaymentMethod(paymentMethod11);
        // The following exception was thrown during execution in test generation
        try {
            booking6.cancelBooking();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.temporal.Temporal.until(java.time.temporal.Temporal, java.time.temporal.TemporalUnit)\" because \"temporal1Inclusive\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test091");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.lang.String str9 = booking6.getStatus();
        java.lang.String str10 = booking6.getBookingId();
        java.time.LocalDateTime localDateTime11 = booking6.getEndTime();
        java.time.LocalDateTime localDateTime12 = null;
        booking6.setStartTime(localDateTime12);
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Active" + "'", str9, "Active");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "hi!" + "'", str10, "hi!");
        org.junit.Assert.assertNull(localDateTime11);
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test092");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getId();
        parkingSpace4.enable();
        java.lang.String str7 = parkingSpace4.toString();
        parkingSpace4.disable();
        java.lang.String str9 = parkingSpace4.toString();
        java.time.LocalDateTime localDateTime10 = null;
        java.time.LocalDateTime localDateTime11 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod12 = null;
        com.example.parking.model.Booking booking13 = new com.example.parking.model.Booking("Available", client1, parkingSpace4, localDateTime10, localDateTime11, paymentMethod12);
        boolean boolean14 = parkingSpace4.isBooked();
        boolean boolean15 = parkingSpace4.isOccupied();
        java.lang.String str16 = parkingSpace4.getCarInfo();
        parkingSpace4.clearObservers();
        parkingSpace4.occupy("");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "hi!" + "'", str5, "hi!");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str9, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "No car" + "'", str16, "No car");
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test093");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace8 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str9 = parkingSpace8.getId();
        parkingSpace8.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState11 = parkingSpace8.getState();
        parkingSpace4.setState(parkingSpaceState11);
        com.example.parking.observer.Observer observer13 = null;
        parkingSpace4.detach(observer13);
        java.time.LocalDateTime localDateTime15 = null;
        java.time.LocalDateTime localDateTime16 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod17 = null;
        com.example.parking.model.Booking booking18 = new com.example.parking.model.Booking("Active", client1, parkingSpace4, localDateTime15, localDateTime16, paymentMethod17);
        parkingSpace4.vacate();
        com.example.parking.observer.Observer observer20 = null;
        parkingSpace4.detach(observer20);
        boolean boolean22 = parkingSpace4.isBooked();
        java.lang.String str23 = parkingSpace4.getSpaceId();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState11);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertEquals("'" + str23 + "' != '" + "hi!" + "'", str23, "hi!");
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test094");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace6 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str7 = parkingSpace6.getId();
        parkingSpace6.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState9 = parkingSpace6.getState();
        parkingSpace2.setState(parkingSpaceState9);
        boolean boolean11 = parkingSpace2.isDisabled();
        java.lang.String str12 = parkingSpace2.getCarInfo();
        parkingSpace2.setRate((double) (byte) 1);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "hi!" + "'", str7, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState9);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "No car" + "'", str12, "No car");
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test095");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace8 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str9 = parkingSpace8.getId();
        parkingSpace8.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState11 = parkingSpace8.getState();
        parkingSpace4.setState(parkingSpaceState11);
        com.example.parking.observer.Observer observer13 = null;
        parkingSpace4.detach(observer13);
        java.time.LocalDateTime localDateTime15 = null;
        java.time.LocalDateTime localDateTime16 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod17 = null;
        com.example.parking.model.Booking booking18 = new com.example.parking.model.Booking("Active", client1, parkingSpace4, localDateTime15, localDateTime16, paymentMethod17);
        parkingSpace4.vacate();
        com.example.parking.model.ParkingSpace parkingSpace22 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str23 = parkingSpace22.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace26 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str27 = parkingSpace26.getId();
        parkingSpace26.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState29 = parkingSpace26.getState();
        parkingSpace22.setState(parkingSpaceState29);
        parkingSpace4.setState(parkingSpaceState29);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState11);
        org.junit.Assert.assertEquals("'" + str23 + "' != '" + "Available" + "'", str23, "Available");
        org.junit.Assert.assertEquals("'" + str27 + "' != '" + "hi!" + "'", str27, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState29);
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test096");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        com.example.parking.model.ParkingSpace parkingSpace8 = booking6.getParkingSpace();
        java.lang.String str9 = booking6.getStatus();
        java.lang.String str10 = booking6.getBookingId();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertNull(parkingSpace8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Active" + "'", str9, "Active");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "hi!" + "'", str10, "hi!");
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test097");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace6 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str7 = parkingSpace6.getId();
        parkingSpace6.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState9 = parkingSpace6.getState();
        parkingSpace2.setState(parkingSpaceState9);
        boolean boolean11 = parkingSpace2.isDisabled();
        java.lang.String str12 = parkingSpace2.getCarInfo();
        parkingSpace2.setRate((double) 10.0f);
        java.lang.String str15 = parkingSpace2.getCarInfo();
        parkingSpace2.free();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "hi!" + "'", str7, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState9);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "No car" + "'", str12, "No car");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "No car" + "'", str15, "No car");
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test098");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getId();
        parkingSpace2.enable();
        java.lang.String str5 = parkingSpace2.toString();
        parkingSpace2.disable();
        parkingSpace2.free();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hi!" + "'", str3, "hi!");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str5, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test099");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getId();
        parkingSpace4.enable();
        java.lang.String str7 = parkingSpace4.toString();
        parkingSpace4.disable();
        java.lang.String str9 = parkingSpace4.toString();
        java.time.LocalDateTime localDateTime10 = null;
        java.time.LocalDateTime localDateTime11 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod12 = null;
        com.example.parking.model.Booking booking13 = new com.example.parking.model.Booking("Available", client1, parkingSpace4, localDateTime10, localDateTime11, paymentMethod12);
        boolean boolean14 = parkingSpace4.isBooked();
        boolean boolean15 = parkingSpace4.isOccupied();
        java.util.List<com.example.parking.observer.Observer> observerList16 = parkingSpace4.getObservers();
        java.lang.String str17 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace20 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str21 = parkingSpace20.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace24 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str25 = parkingSpace24.getId();
        parkingSpace24.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState27 = parkingSpace24.getState();
        parkingSpace20.setState(parkingSpaceState27);
        parkingSpace4.setState(parkingSpaceState27);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "hi!" + "'", str5, "hi!");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str9, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(observerList16);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "Disabled" + "'", str17, "Disabled");
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "Available" + "'", str21, "Available");
        org.junit.Assert.assertEquals("'" + str25 + "' != '" + "hi!" + "'", str25, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState27);
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test100");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getId();
        parkingSpace2.enable();
        java.lang.String str5 = parkingSpace2.toString();
        java.lang.String str6 = parkingSpace2.getLicensePlate();
        parkingSpace2.notifyObservers();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hi!" + "'", str3, "hi!");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str5, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test101");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setBookingId("No car");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str9 = booking6.toString();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.example.parking.model.Client.getId()\" because \"this.client\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test102");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.lang.String str9 = booking6.getStatus();
        booking6.setBookingId("Available");
        java.time.LocalDateTime localDateTime12 = null;
        // The following exception was thrown during execution in test generation
        try {
            booking6.extendParkingTime(localDateTime12, "");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDateTime.isBefore(java.time.chrono.ChronoLocalDateTime)\" because \"newEndTime\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Active" + "'", str9, "Active");
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test103");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        booking6.setAmount((double) (short) 0);
        // The following exception was thrown during execution in test generation
        try {
            booking6.cancelBooking();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.temporal.Temporal.until(java.time.temporal.Temporal, java.time.temporal.TemporalUnit)\" because \"temporal1Inclusive\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(paymentMethod7);
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test104");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("No car", (double) (short) 10);
        java.lang.String str3 = parkingSpace2.getStatus();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test105");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.Client client3 = null;
        com.example.parking.model.ParkingSpace parkingSpace6 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str7 = parkingSpace6.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace10 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str11 = parkingSpace10.getId();
        parkingSpace10.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState13 = parkingSpace10.getState();
        parkingSpace6.setState(parkingSpaceState13);
        com.example.parking.observer.Observer observer15 = null;
        parkingSpace6.detach(observer15);
        java.time.LocalDateTime localDateTime17 = null;
        java.time.LocalDateTime localDateTime18 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod19 = null;
        com.example.parking.model.Booking booking20 = new com.example.parking.model.Booking("Active", client3, parkingSpace6, localDateTime17, localDateTime18, paymentMethod19);
        com.example.parking.model.Car car22 = null;
        parkingSpace6.setOccupied(false, car22);
        parkingSpace6.setEnabled(true);
        java.lang.String str26 = parkingSpace6.getSpaceId();
        java.time.LocalDateTime localDateTime27 = null;
        java.time.LocalDateTime localDateTime28 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.example.parking.model.Booking booking30 = com.example.parking.model.Booking.createBooking("Available", client1, parkingSpace6, localDateTime27, localDateTime28, "Disabled");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDateTime.isAfter(java.time.chrono.ChronoLocalDateTime)\" because \"startTime\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "Available" + "'", str7, "Available");
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "hi!" + "'", str11, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState13);
        org.junit.Assert.assertEquals("'" + str26 + "' != '" + "hi!" + "'", str26, "hi!");
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test106");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.lang.String str9 = booking6.getStatus();
        com.example.parking.model.Client client11 = null;
        com.example.parking.model.ParkingSpace parkingSpace14 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str15 = parkingSpace14.getId();
        parkingSpace14.enable();
        java.lang.String str17 = parkingSpace14.toString();
        parkingSpace14.disable();
        java.lang.String str19 = parkingSpace14.toString();
        java.time.LocalDateTime localDateTime20 = null;
        java.time.LocalDateTime localDateTime21 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod22 = null;
        com.example.parking.model.Booking booking23 = new com.example.parking.model.Booking("Available", client11, parkingSpace14, localDateTime20, localDateTime21, paymentMethod22);
        boolean boolean24 = parkingSpace14.isBooked();
        boolean boolean25 = parkingSpace14.isOccupied();
        booking6.setSpaceId(parkingSpace14);
        com.example.parking.model.Client client27 = booking6.getClient();
        booking6.setLicensePlate("Available");
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Active" + "'", str9, "Active");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "hi!" + "'", str15, "hi!");
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str17, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str19, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNull(client27);
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test107");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        double double9 = booking6.getTotalCost();
        booking6.setLicensePlate("ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 0.0d + "'", double9 == 0.0d);
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test108");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setLicensePlate("Active");
        double double9 = booking6.getDeposit();
        booking6.processPayment((double) (short) -1);
        java.time.LocalDateTime localDateTime12 = null;
        booking6.setEndTime(localDateTime12);
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 10.0d + "'", double9 == 10.0d);
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test109");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace8 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str9 = parkingSpace8.getId();
        parkingSpace8.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState11 = parkingSpace8.getState();
        parkingSpace4.setState(parkingSpaceState11);
        com.example.parking.observer.Observer observer13 = null;
        parkingSpace4.detach(observer13);
        java.time.LocalDateTime localDateTime15 = null;
        java.time.LocalDateTime localDateTime16 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod17 = null;
        com.example.parking.model.Booking booking18 = new com.example.parking.model.Booking("Active", client1, parkingSpace4, localDateTime15, localDateTime16, paymentMethod17);
        parkingSpace4.vacate();
        com.example.parking.observer.Observer observer20 = null;
        parkingSpace4.detach(observer20);
        java.util.List<com.example.parking.observer.Observer> observerList22 = parkingSpace4.getObservers();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState11);
        org.junit.Assert.assertNotNull(observerList22);
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test110");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        booking6.setAmount((double) (short) 0);
        com.example.parking.model.ParkingSpace parkingSpace14 = null;
        booking6.setSpaceId(parkingSpace14);
        double double16 = booking6.getAmount();
        booking6.setBookingId("ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 0.0d + "'", double16 == 0.0d);
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test111");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setBookingId("No car");
        java.lang.Class<?> wildcardClass9 = booking6.getClass();
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test112");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        boolean boolean4 = parkingSpace2.isBooked();
        com.example.parking.model.ParkingSpace parkingSpace7 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str8 = parkingSpace7.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace11 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str12 = parkingSpace11.getId();
        parkingSpace11.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState14 = parkingSpace11.getState();
        parkingSpace7.setState(parkingSpaceState14);
        parkingSpace2.setState(parkingSpaceState14);
        com.example.parking.state.ParkingSpaceState parkingSpaceState17 = parkingSpace2.getState();
        parkingSpace2.enable();
        java.util.List<com.example.parking.observer.Observer> observerList19 = parkingSpace2.getObservers();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "Available" + "'", str8, "Available");
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "hi!" + "'", str12, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState14);
        org.junit.Assert.assertNotNull(parkingSpaceState17);
        org.junit.Assert.assertNotNull(observerList19);
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test113");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        booking6.setAmount((double) (short) 0);
        com.example.parking.model.ParkingSpace parkingSpace14 = null;
        booking6.setSpaceId(parkingSpace14);
        double double16 = booking6.getAmount();
        java.time.LocalDateTime localDateTime17 = null;
        booking6.setEndTime(localDateTime17);
        com.example.parking.model.payment.PaymentMethod paymentMethod19 = booking6.getPaymentMethod();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 0.0d + "'", double16 == 0.0d);
        org.junit.Assert.assertNull(paymentMethod19);
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test114");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("No car", (double) 10.0f);
        double double3 = parkingSpace2.getRate();
        org.junit.Assert.assertTrue("'" + double3 + "' != '" + 10.0d + "'", double3 == 10.0d);
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test115");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getId();
        parkingSpace4.enable();
        java.lang.String str7 = parkingSpace4.toString();
        parkingSpace4.disable();
        java.lang.String str9 = parkingSpace4.toString();
        java.time.LocalDateTime localDateTime10 = null;
        java.time.LocalDateTime localDateTime11 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod12 = null;
        com.example.parking.model.Booking booking13 = new com.example.parking.model.Booking("Available", client1, parkingSpace4, localDateTime10, localDateTime11, paymentMethod12);
        boolean boolean14 = parkingSpace4.isBooked();
        boolean boolean15 = parkingSpace4.isOccupied();
        parkingSpace4.setEnabled(true);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "hi!" + "'", str5, "hi!");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str9, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test116");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        boolean boolean4 = parkingSpace2.isBooked();
        java.lang.Class<?> wildcardClass5 = parkingSpace2.getClass();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test117");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setLicensePlate("Active");
        double double9 = booking6.getDeposit();
        booking6.processPayment((double) (short) -1);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str12 = booking6.toString();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.example.parking.model.Client.getId()\" because \"this.client\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 10.0d + "'", double9 == 10.0d);
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test118");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        double double12 = booking6.getDeposit();
        booking6.setAmount((double) (short) 1);
        booking6.setStatus("ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        // The following exception was thrown during execution in test generation
        try {
            booking6.cancelBooking();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.temporal.Temporal.until(java.time.temporal.Temporal, java.time.temporal.TemporalUnit)\" because \"temporal1Inclusive\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 10.0d + "'", double12 == 10.0d);
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test119");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        double double12 = booking6.getDeposit();
        booking6.setAmount((double) (short) 1);
        java.time.LocalDateTime localDateTime15 = booking6.getStartTime();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 10.0d + "'", double12 == 10.0d);
        org.junit.Assert.assertNull(localDateTime15);
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test120");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getId();
        parkingSpace4.enable();
        java.lang.String str7 = parkingSpace4.toString();
        parkingSpace4.disable();
        java.lang.String str9 = parkingSpace4.toString();
        java.time.LocalDateTime localDateTime10 = null;
        java.time.LocalDateTime localDateTime11 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod12 = null;
        com.example.parking.model.Booking booking13 = new com.example.parking.model.Booking("Available", client1, parkingSpace4, localDateTime10, localDateTime11, paymentMethod12);
        boolean boolean14 = parkingSpace4.isBooked();
        boolean boolean15 = parkingSpace4.isOccupied();
        java.util.List<com.example.parking.observer.Observer> observerList16 = parkingSpace4.getObservers();
        java.lang.String str17 = parkingSpace4.getStatus();
        boolean boolean18 = parkingSpace4.isEnabled();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "hi!" + "'", str5, "hi!");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str9, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(observerList16);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "Disabled" + "'", str17, "Disabled");
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test121");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getId();
        parkingSpace4.enable();
        java.lang.String str7 = parkingSpace4.toString();
        parkingSpace4.disable();
        java.lang.String str9 = parkingSpace4.toString();
        java.time.LocalDateTime localDateTime10 = null;
        java.time.LocalDateTime localDateTime11 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod12 = null;
        com.example.parking.model.Booking booking13 = new com.example.parking.model.Booking("Available", client1, parkingSpace4, localDateTime10, localDateTime11, paymentMethod12);
        boolean boolean14 = parkingSpace4.isBooked();
        boolean boolean15 = parkingSpace4.isOccupied();
        java.util.List<com.example.parking.observer.Observer> observerList16 = parkingSpace4.getObservers();
        parkingSpace4.setEnabled(false);
        java.lang.Class<?> wildcardClass19 = parkingSpace4.getClass();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "hi!" + "'", str5, "hi!");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str9, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(observerList16);
        org.junit.Assert.assertNotNull(wildcardClass19);
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test122");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        booking6.setAmount((double) (short) 0);
        com.example.parking.model.ParkingSpace parkingSpace14 = null;
        booking6.setSpaceId(parkingSpace14);
        double double16 = booking6.getAmount();
        java.time.LocalDateTime localDateTime17 = null;
        booking6.setEndTime(localDateTime17);
        booking6.setLicensePlate("");
        double double21 = booking6.getTotalCost();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 0.0d + "'", double16 == 0.0d);
        org.junit.Assert.assertTrue("'" + double21 + "' != '" + 0.0d + "'", double21 == 0.0d);
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test123");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processRefund((double) (short) -1);
        booking6.setLicensePlate("");
        booking6.processRefund((double) 10);
        // The following exception was thrown during execution in test generation
        try {
            booking6.cancelBooking();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.temporal.Temporal.until(java.time.temporal.Temporal, java.time.temporal.TemporalUnit)\" because \"temporal1Inclusive\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test124");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("Disabled", (double) 1.0f);
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test125");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        boolean boolean6 = parkingSpace4.isBooked();
        java.lang.String str7 = parkingSpace4.toString();
        java.time.LocalDateTime localDateTime8 = null;
        java.time.LocalDateTime localDateTime9 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.example.parking.model.Booking booking11 = com.example.parking.model.Booking.createBooking("", client1, parkingSpace4, localDateTime8, localDateTime9, "");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDateTime.isAfter(java.time.chrono.ChronoLocalDateTime)\" because \"startTime\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test126");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        boolean boolean4 = parkingSpace2.isBooked();
        java.lang.String str5 = parkingSpace2.toString();
        com.example.parking.state.ParkingSpaceState parkingSpaceState6 = parkingSpace2.getState();
        java.lang.String str7 = parkingSpace2.toString();
        java.lang.String str8 = parkingSpace2.getStatus();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str5, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertNotNull(parkingSpaceState6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "Available" + "'", str8, "Available");
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test127");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getId();
        parkingSpace4.enable();
        java.lang.String str7 = parkingSpace4.toString();
        parkingSpace4.disable();
        java.lang.String str9 = parkingSpace4.toString();
        java.time.LocalDateTime localDateTime10 = null;
        java.time.LocalDateTime localDateTime11 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod12 = null;
        com.example.parking.model.Booking booking13 = new com.example.parking.model.Booking("Available", client1, parkingSpace4, localDateTime10, localDateTime11, paymentMethod12);
        boolean boolean14 = parkingSpace4.isBooked();
        boolean boolean15 = parkingSpace4.isOccupied();
        java.util.List<com.example.parking.observer.Observer> observerList16 = parkingSpace4.getObservers();
        java.lang.Class<?> wildcardClass17 = observerList16.getClass();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "hi!" + "'", str5, "hi!");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str9, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(observerList16);
        org.junit.Assert.assertNotNull(wildcardClass17);
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test128");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace8 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str9 = parkingSpace8.getId();
        parkingSpace8.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState11 = parkingSpace8.getState();
        parkingSpace4.setState(parkingSpaceState11);
        com.example.parking.observer.Observer observer13 = null;
        parkingSpace4.detach(observer13);
        java.time.LocalDateTime localDateTime15 = null;
        java.time.LocalDateTime localDateTime16 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod17 = null;
        com.example.parking.model.Booking booking18 = new com.example.parking.model.Booking("Active", client1, parkingSpace4, localDateTime15, localDateTime16, paymentMethod17);
        parkingSpace4.vacate();
        java.lang.String str20 = parkingSpace4.getCarInfo();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState11);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "No car" + "'", str20, "No car");
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test129");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.lang.String str9 = booking6.getStatus();
        com.example.parking.model.Client client11 = null;
        com.example.parking.model.ParkingSpace parkingSpace14 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str15 = parkingSpace14.getId();
        parkingSpace14.enable();
        java.lang.String str17 = parkingSpace14.toString();
        parkingSpace14.disable();
        java.lang.String str19 = parkingSpace14.toString();
        java.time.LocalDateTime localDateTime20 = null;
        java.time.LocalDateTime localDateTime21 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod22 = null;
        com.example.parking.model.Booking booking23 = new com.example.parking.model.Booking("Available", client11, parkingSpace14, localDateTime20, localDateTime21, paymentMethod22);
        boolean boolean24 = parkingSpace14.isBooked();
        boolean boolean25 = parkingSpace14.isOccupied();
        booking6.setSpaceId(parkingSpace14);
        java.lang.String str27 = parkingSpace14.getSpaceId();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Active" + "'", str9, "Active");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "hi!" + "'", str15, "hi!");
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str17, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str19, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertEquals("'" + str27 + "' != '" + "hi!" + "'", str27, "hi!");
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test130");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        boolean boolean3 = parkingSpace2.isOccupied();
        parkingSpace2.notifyObservers();
        boolean boolean5 = parkingSpace2.isEnabled();
        double double6 = parkingSpace2.getRate();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test131");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.time.LocalDateTime localDateTime9 = null;
        booking6.setEndTime(localDateTime9);
        com.example.parking.model.payment.PaymentMethod paymentMethod11 = booking6.getPaymentMethod();
        com.example.parking.model.payment.PaymentMethod paymentMethod12 = null;
        booking6.setPaymentMethod(paymentMethod12);
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertNull(paymentMethod11);
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test132");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processPayment((double) 10L);
        com.example.parking.model.ParkingSpace parkingSpace9 = null;
        booking6.setSpaceId(parkingSpace9);
        java.time.LocalDateTime localDateTime11 = booking6.getStartTime();
        booking6.setStatus("hi!");
        // The following exception was thrown during execution in test generation
        try {
            booking6.cancelBooking();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.temporal.Temporal.until(java.time.temporal.Temporal, java.time.temporal.TemporalUnit)\" because \"temporal1Inclusive\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(localDateTime11);
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test133");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace8 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str9 = parkingSpace8.getId();
        parkingSpace8.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState11 = parkingSpace8.getState();
        parkingSpace4.setState(parkingSpaceState11);
        com.example.parking.observer.Observer observer13 = null;
        parkingSpace4.detach(observer13);
        java.time.LocalDateTime localDateTime15 = null;
        java.time.LocalDateTime localDateTime16 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod17 = null;
        com.example.parking.model.Booking booking18 = new com.example.parking.model.Booking("ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}", client1, parkingSpace4, localDateTime15, localDateTime16, paymentMethod17);
        java.lang.String str19 = parkingSpace4.getId();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState11);
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "hi!" + "'", str19, "hi!");
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test134");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setLicensePlate("Active");
        booking6.setStatus("Available");
        com.example.parking.model.payment.PaymentMethod paymentMethod11 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime12 = null;
        booking6.setStartTime(localDateTime12);
        org.junit.Assert.assertNull(paymentMethod11);
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test135");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        com.example.parking.model.payment.PaymentMethod paymentMethod8 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime9 = booking6.getStartTime();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertNull(paymentMethod8);
        org.junit.Assert.assertNull(localDateTime9);
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test136");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setLicensePlate("Active");
        double double9 = booking6.getDeposit();
        com.example.parking.model.Client client10 = booking6.getClient();
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 10.0d + "'", double9 == 10.0d);
        org.junit.Assert.assertNull(client10);
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test137");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processRefund((double) (short) -1);
        booking6.setLicensePlate("");
        booking6.processRefund((double) 10);
        java.lang.String str13 = booking6.getStatus();
        java.lang.String str14 = booking6.getBookingId();
        double double15 = booking6.getDeposit();
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "Active" + "'", str13, "Active");
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "" + "'", str14, "");
        org.junit.Assert.assertTrue("'" + double15 + "' != '" + 10.0d + "'", double15 == 10.0d);
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test138");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace8 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str9 = parkingSpace8.getId();
        parkingSpace8.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState11 = parkingSpace8.getState();
        parkingSpace4.setState(parkingSpaceState11);
        com.example.parking.observer.Observer observer13 = null;
        parkingSpace4.detach(observer13);
        java.time.LocalDateTime localDateTime15 = null;
        java.time.LocalDateTime localDateTime16 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod17 = null;
        com.example.parking.model.Booking booking18 = new com.example.parking.model.Booking("Active", client1, parkingSpace4, localDateTime15, localDateTime16, paymentMethod17);
        booking18.setStatus("ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState11);
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test139");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setLicensePlate("Active");
        booking6.setStatus("Available");
        booking6.processPayment((double) 0L);
        double double13 = booking6.getAmount();
        org.junit.Assert.assertTrue("'" + double13 + "' != '" + 0.0d + "'", double13 == 0.0d);
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test140");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        double double12 = booking6.getDeposit();
        booking6.setLicensePlate("");
        booking6.setAmount((double) 'a');
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 10.0d + "'", double12 == 10.0d);
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test141");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processRefund((double) (short) -1);
        booking6.setLicensePlate("");
        booking6.processPayment((double) 1);
        booking6.setAmount((double) 10L);
        java.time.LocalDateTime localDateTime15 = booking6.getEndTime();
        org.junit.Assert.assertNull(localDateTime15);
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test142");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.lang.String str9 = booking6.getStatus();
        com.example.parking.model.Client client11 = null;
        com.example.parking.model.ParkingSpace parkingSpace14 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str15 = parkingSpace14.getId();
        parkingSpace14.enable();
        java.lang.String str17 = parkingSpace14.toString();
        parkingSpace14.disable();
        java.lang.String str19 = parkingSpace14.toString();
        java.time.LocalDateTime localDateTime20 = null;
        java.time.LocalDateTime localDateTime21 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod22 = null;
        com.example.parking.model.Booking booking23 = new com.example.parking.model.Booking("Available", client11, parkingSpace14, localDateTime20, localDateTime21, paymentMethod22);
        boolean boolean24 = parkingSpace14.isBooked();
        boolean boolean25 = parkingSpace14.isOccupied();
        booking6.setSpaceId(parkingSpace14);
        com.example.parking.model.Client client27 = booking6.getClient();
        double double28 = booking6.getTotalCost();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Active" + "'", str9, "Active");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "hi!" + "'", str15, "hi!");
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str17, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str19, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNull(client27);
        org.junit.Assert.assertTrue("'" + double28 + "' != '" + 0.0d + "'", double28 == 0.0d);
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test143");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processRefund((double) (short) -1);
        booking6.setLicensePlate("");
        booking6.processRefund((double) 10);
        java.lang.String str13 = booking6.getStatus();
        booking6.setBookingId("ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "Active" + "'", str13, "Active");
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test144");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setLicensePlate("Active");
        java.time.LocalDateTime localDateTime9 = null;
        booking6.setEndTime(localDateTime9);
        java.lang.String str11 = booking6.getLicensePlate();
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "Active" + "'", str11, "Active");
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test145");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace8 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str9 = parkingSpace8.getId();
        parkingSpace8.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState11 = parkingSpace8.getState();
        parkingSpace4.setState(parkingSpaceState11);
        com.example.parking.observer.Observer observer13 = null;
        parkingSpace4.detach(observer13);
        java.time.LocalDateTime localDateTime15 = null;
        java.time.LocalDateTime localDateTime16 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod17 = null;
        com.example.parking.model.Booking booking18 = new com.example.parking.model.Booking("Active", client1, parkingSpace4, localDateTime15, localDateTime16, paymentMethod17);
        boolean boolean19 = parkingSpace4.isDisabled();
        java.lang.String str20 = parkingSpace4.getStatus();
        parkingSpace4.occupy("");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState11);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "Available" + "'", str20, "Available");
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test146");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setLicensePlate("Active");
        booking6.setStatus("Available");
        com.example.parking.model.payment.PaymentMethod paymentMethod11 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime12 = booking6.getEndTime();
        org.junit.Assert.assertNull(paymentMethod11);
        org.junit.Assert.assertNull(localDateTime12);
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test147");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.checkout();
        booking6.setBookingId("ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test148");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getId();
        parkingSpace2.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState5 = parkingSpace2.getState();
        parkingSpace2.disable();
        com.example.parking.observer.Observer observer7 = null;
        parkingSpace2.detach(observer7);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hi!" + "'", str3, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState5);
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test149");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        double double12 = booking6.getDeposit();
        booking6.setAmount((double) (short) 1);
        java.lang.String str15 = booking6.getStatus();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 10.0d + "'", double12 == 10.0d);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "Active" + "'", str15, "Active");
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test150");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getId();
        parkingSpace4.enable();
        java.lang.String str7 = parkingSpace4.toString();
        parkingSpace4.disable();
        java.lang.String str9 = parkingSpace4.toString();
        java.time.LocalDateTime localDateTime10 = null;
        java.time.LocalDateTime localDateTime11 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod12 = null;
        com.example.parking.model.Booking booking13 = new com.example.parking.model.Booking("Available", client1, parkingSpace4, localDateTime10, localDateTime11, paymentMethod12);
        boolean boolean14 = parkingSpace4.isBooked();
        boolean boolean15 = parkingSpace4.isOccupied();
        java.util.List<com.example.parking.observer.Observer> observerList16 = parkingSpace4.getObservers();
        java.lang.String str17 = parkingSpace4.getStatus();
        boolean boolean18 = parkingSpace4.isDisabled();
        boolean boolean19 = parkingSpace4.isBooked();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "hi!" + "'", str5, "hi!");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str9, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(observerList16);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "Disabled" + "'", str17, "Disabled");
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test151");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        booking6.setTotalCost(0.0d);
        org.junit.Assert.assertNull(paymentMethod7);
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test152");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.lang.String str9 = booking6.getStatus();
        booking6.setBookingId("Available");
        booking6.setAmount((double) (-1L));
        com.example.parking.model.payment.PaymentMethod paymentMethod14 = null;
        booking6.setPaymentMethod(paymentMethod14);
        booking6.setBookingId("ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Active" + "'", str9, "Active");
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test153");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("No car", (double) 10.0f);
        com.example.parking.model.ParkingSpace parkingSpace7 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str8 = parkingSpace7.getId();
        parkingSpace7.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState10 = parkingSpace7.getState();
        parkingSpace4.setState(parkingSpaceState10);
        java.time.LocalDateTime localDateTime12 = null;
        java.time.LocalDateTime localDateTime13 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.example.parking.model.Booking booking15 = com.example.parking.model.Booking.createBooking("Active", client1, parkingSpace4, localDateTime12, localDateTime13, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDateTime.isAfter(java.time.chrono.ChronoLocalDateTime)\" because \"startTime\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState10);
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test154");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        booking6.setAmount((double) (short) 0);
        booking6.processPayment((double) 1L);
        // The following exception was thrown during execution in test generation
        try {
            double double16 = booking6.calculateRefund();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: temporal");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(paymentMethod7);
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test155");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processPayment((double) 10L);
        com.example.parking.model.ParkingSpace parkingSpace9 = null;
        booking6.setSpaceId(parkingSpace9);
        java.time.LocalDateTime localDateTime11 = booking6.getStartTime();
        booking6.setStatus("hi!");
        com.example.parking.model.payment.PaymentMethod paymentMethod14 = booking6.getPaymentMethod();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str15 = booking6.getClientId();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.example.parking.model.Client.getId()\" because \"this.client\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(localDateTime11);
        org.junit.Assert.assertNull(paymentMethod14);
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test156");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace8 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str9 = parkingSpace8.getId();
        parkingSpace8.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState11 = parkingSpace8.getState();
        parkingSpace4.setState(parkingSpaceState11);
        com.example.parking.observer.Observer observer13 = null;
        parkingSpace4.detach(observer13);
        java.time.LocalDateTime localDateTime15 = null;
        java.time.LocalDateTime localDateTime16 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod17 = null;
        com.example.parking.model.Booking booking18 = new com.example.parking.model.Booking("Active", client1, parkingSpace4, localDateTime15, localDateTime16, paymentMethod17);
        boolean boolean19 = parkingSpace4.isDisabled();
        java.lang.String str20 = parkingSpace4.getSpaceId();
        java.lang.String str21 = parkingSpace4.getLicensePlate();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState11);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "hi!" + "'", str20, "hi!");
        org.junit.Assert.assertNull(str21);
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test157");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace6 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str7 = parkingSpace6.getId();
        parkingSpace6.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState9 = parkingSpace6.getState();
        parkingSpace2.setState(parkingSpaceState9);
        boolean boolean11 = parkingSpace2.isDisabled();
        java.lang.String str12 = parkingSpace2.getCarInfo();
        parkingSpace2.setRate((double) 10.0f);
        java.util.List<com.example.parking.observer.Observer> observerList15 = parkingSpace2.getObservers();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "hi!" + "'", str7, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState9);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "No car" + "'", str12, "No car");
        org.junit.Assert.assertNotNull(observerList15);
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test158");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processRefund((double) (short) -1);
        double double9 = booking6.getTotalCost();
        com.example.parking.model.Client client10 = booking6.getClient();
        booking6.setTotalCost((double) '#');
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 0.0d + "'", double9 == 0.0d);
        org.junit.Assert.assertNull(client10);
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test159");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getId();
        parkingSpace2.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState5 = parkingSpace2.getState();
        parkingSpace2.enable();
        parkingSpace2.setRate((double) '4');
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hi!" + "'", str3, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState5);
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test160");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getId();
        java.lang.String str4 = parkingSpace2.getCarInfo();
        java.lang.String str5 = parkingSpace2.getCarInfo();
        com.example.parking.observer.Observer observer6 = null;
        parkingSpace2.attach(observer6);
        boolean boolean8 = parkingSpace2.isOccupied();
        java.lang.String str9 = parkingSpace2.getSpaceId();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hi!" + "'", str3, "hi!");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "No car" + "'", str4, "No car");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "No car" + "'", str5, "No car");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test161");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace8 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str9 = parkingSpace8.getId();
        parkingSpace8.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState11 = parkingSpace8.getState();
        parkingSpace4.setState(parkingSpaceState11);
        com.example.parking.observer.Observer observer13 = null;
        parkingSpace4.detach(observer13);
        java.time.LocalDateTime localDateTime15 = null;
        java.time.LocalDateTime localDateTime16 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod17 = null;
        com.example.parking.model.Booking booking18 = new com.example.parking.model.Booking("hi!", client1, parkingSpace4, localDateTime15, localDateTime16, paymentMethod17);
        double double19 = booking18.getDeposit();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState11);
        org.junit.Assert.assertTrue("'" + double19 + "' != '" + 10.0d + "'", double19 == 10.0d);
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test162");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getId();
        parkingSpace2.enable();
        java.lang.String str5 = parkingSpace2.toString();
        parkingSpace2.disable();
        java.lang.String str7 = parkingSpace2.toString();
        java.lang.String str8 = parkingSpace2.toString();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hi!" + "'", str3, "hi!");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str5, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str8, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test163");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace8 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str9 = parkingSpace8.getId();
        parkingSpace8.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState11 = parkingSpace8.getState();
        parkingSpace4.setState(parkingSpaceState11);
        com.example.parking.observer.Observer observer13 = null;
        parkingSpace4.detach(observer13);
        java.time.LocalDateTime localDateTime15 = null;
        java.time.LocalDateTime localDateTime16 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod17 = null;
        com.example.parking.model.Booking booking18 = new com.example.parking.model.Booking("Active", client1, parkingSpace4, localDateTime15, localDateTime16, paymentMethod17);
        boolean boolean19 = parkingSpace4.isDisabled();
        java.lang.String str20 = parkingSpace4.getSpaceId();
        parkingSpace4.vacate();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState11);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "hi!" + "'", str20, "hi!");
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test164");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.lang.String str9 = booking6.getStatus();
        java.lang.String str10 = booking6.getBookingId();
        java.time.LocalDateTime localDateTime11 = booking6.getEndTime();
        com.example.parking.model.payment.PaymentMethod paymentMethod12 = null;
        booking6.setPaymentMethod(paymentMethod12);
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Active" + "'", str9, "Active");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "hi!" + "'", str10, "hi!");
        org.junit.Assert.assertNull(localDateTime11);
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test165");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        java.time.LocalDateTime localDateTime10 = booking6.getStartTime();
        double double11 = booking6.getTotalCost();
        com.example.parking.model.Client client12 = null;
        booking6.setClient(client12);
        booking6.processPayment((double) 100);
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertNull(localDateTime10);
        org.junit.Assert.assertTrue("'" + double11 + "' != '" + 0.0d + "'", double11 == 0.0d);
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test166");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        booking6.setAmount((double) (short) 0);
        com.example.parking.model.ParkingSpace parkingSpace14 = null;
        booking6.setSpaceId(parkingSpace14);
        com.example.parking.model.ParkingSpace parkingSpace16 = booking6.getSpaceId();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertNull(parkingSpace16);
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test167");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getId();
        parkingSpace4.enable();
        java.lang.String str7 = parkingSpace4.toString();
        parkingSpace4.disable();
        java.lang.String str9 = parkingSpace4.toString();
        java.time.LocalDateTime localDateTime10 = null;
        java.time.LocalDateTime localDateTime11 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod12 = null;
        com.example.parking.model.Booking booking13 = new com.example.parking.model.Booking("Available", client1, parkingSpace4, localDateTime10, localDateTime11, paymentMethod12);
        boolean boolean14 = parkingSpace4.isBooked();
        boolean boolean15 = parkingSpace4.isOccupied();
        java.util.List<com.example.parking.observer.Observer> observerList16 = parkingSpace4.getObservers();
        java.lang.String str17 = parkingSpace4.getStatus();
        boolean boolean18 = parkingSpace4.isDisabled();
        parkingSpace4.free();
        com.example.parking.state.ParkingSpaceState parkingSpaceState20 = parkingSpace4.getState();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "hi!" + "'", str5, "hi!");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str9, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(observerList16);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "Disabled" + "'", str17, "Disabled");
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertNotNull(parkingSpaceState20);
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test168");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace8 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str9 = parkingSpace8.getId();
        parkingSpace8.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState11 = parkingSpace8.getState();
        parkingSpace4.setState(parkingSpaceState11);
        java.time.LocalDateTime localDateTime13 = null;
        java.time.LocalDateTime localDateTime14 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod15 = null;
        com.example.parking.model.Booking booking16 = new com.example.parking.model.Booking("Available", client1, parkingSpace4, localDateTime13, localDateTime14, paymentMethod15);
        booking16.setAmount((double) 0.0f);
        com.example.parking.model.Client client19 = null;
        booking16.setClient(client19);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState11);
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test169");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        booking6.setAmount((double) (short) 0);
        com.example.parking.model.ParkingSpace parkingSpace14 = null;
        booking6.setSpaceId(parkingSpace14);
        double double16 = booking6.getAmount();
        booking6.setTotalCost((double) (-1L));
        booking6.processPayment((double) 100);
        booking6.setLicensePlate("Active");
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 0.0d + "'", double16 == 0.0d);
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test170");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.lang.String str9 = booking6.getStatus();
        java.lang.String str10 = booking6.getBookingId();
        java.time.LocalDateTime localDateTime11 = booking6.getEndTime();
        double double12 = booking6.getDeposit();
        java.time.LocalDateTime localDateTime13 = booking6.getStartTime();
        booking6.setAmount(0.0d);
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Active" + "'", str9, "Active");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "hi!" + "'", str10, "hi!");
        org.junit.Assert.assertNull(localDateTime11);
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 10.0d + "'", double12 == 10.0d);
        org.junit.Assert.assertNull(localDateTime13);
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test171");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        boolean boolean4 = parkingSpace2.isBooked();
        java.lang.String str5 = parkingSpace2.toString();
        com.example.parking.state.ParkingSpaceState parkingSpaceState6 = parkingSpace2.getState();
        java.lang.String str7 = parkingSpace2.toString();
        parkingSpace2.setRate((-1.0d));
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str5, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertNotNull(parkingSpaceState6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test172");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getId();
        parkingSpace2.enable();
        java.lang.String str5 = parkingSpace2.toString();
        java.lang.String str6 = parkingSpace2.getLicensePlate();
        com.example.parking.model.Car car8 = null;
        parkingSpace2.setOccupied(true, car8);
        boolean boolean10 = parkingSpace2.isOccupied();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hi!" + "'", str3, "hi!");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str5, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertNull(str6);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test173");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        boolean boolean3 = parkingSpace2.isOccupied();
        parkingSpace2.notifyObservers();
        boolean boolean5 = parkingSpace2.isEnabled();
        parkingSpace2.notifyObservers();
        boolean boolean7 = parkingSpace2.isBooked();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test174");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.lang.String str9 = booking6.getStatus();
        java.lang.String str10 = booking6.getBookingId();
        java.time.LocalDateTime localDateTime11 = booking6.getEndTime();
        double double12 = booking6.getDeposit();
        java.time.LocalDateTime localDateTime13 = booking6.getStartTime();
        double double14 = booking6.getTotalCost();
        java.time.LocalDateTime localDateTime15 = booking6.getEndTime();
        java.time.LocalDateTime localDateTime16 = booking6.getStartTime();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Active" + "'", str9, "Active");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "hi!" + "'", str10, "hi!");
        org.junit.Assert.assertNull(localDateTime11);
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 10.0d + "'", double12 == 10.0d);
        org.junit.Assert.assertNull(localDateTime13);
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 0.0d + "'", double14 == 0.0d);
        org.junit.Assert.assertNull(localDateTime15);
        org.junit.Assert.assertNull(localDateTime16);
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test175");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace6 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str7 = parkingSpace6.getId();
        parkingSpace6.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState9 = parkingSpace6.getState();
        parkingSpace2.setState(parkingSpaceState9);
        com.example.parking.observer.Observer observer11 = null;
        parkingSpace2.detach(observer11);
        java.lang.String str13 = parkingSpace2.toString();
        java.util.List<com.example.parking.observer.Observer> observerList14 = parkingSpace2.getObservers();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "hi!" + "'", str7, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState9);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str13, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertNotNull(observerList14);
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test176");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        com.example.parking.model.ParkingSpace parkingSpace8 = booking6.getParkingSpace();
        double double9 = booking6.getTotalCost();
        java.lang.String str10 = booking6.getStatus();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertNull(parkingSpace8);
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 0.0d + "'", double9 == 0.0d);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "Active" + "'", str10, "Active");
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test177");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace8 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str9 = parkingSpace8.getId();
        parkingSpace8.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState11 = parkingSpace8.getState();
        parkingSpace4.setState(parkingSpaceState11);
        com.example.parking.model.Car car14 = null;
        parkingSpace4.setOccupied(false, car14);
        java.time.LocalDateTime localDateTime16 = null;
        java.time.LocalDateTime localDateTime17 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.example.parking.model.Booking booking19 = com.example.parking.model.Booking.createBooking("", client1, parkingSpace4, localDateTime16, localDateTime17, "No car");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDateTime.isAfter(java.time.chrono.ChronoLocalDateTime)\" because \"startTime\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState11);
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test178");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        boolean boolean4 = parkingSpace2.isBooked();
        com.example.parking.model.ParkingSpace parkingSpace7 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str8 = parkingSpace7.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace11 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str12 = parkingSpace11.getId();
        parkingSpace11.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState14 = parkingSpace11.getState();
        parkingSpace7.setState(parkingSpaceState14);
        parkingSpace2.setState(parkingSpaceState14);
        java.lang.String str17 = parkingSpace2.getLicensePlate();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "Available" + "'", str8, "Available");
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "hi!" + "'", str12, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState14);
        org.junit.Assert.assertNull(str17);
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test179");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processPayment((double) 10L);
        com.example.parking.model.ParkingSpace parkingSpace9 = null;
        booking6.setSpaceId(parkingSpace9);
        com.example.parking.model.payment.PaymentMethod paymentMethod11 = null;
        booking6.setPaymentMethod(paymentMethod11);
        booking6.setBookingId("Active");
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test180");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        booking6.setAmount((double) (short) 0);
        com.example.parking.model.ParkingSpace parkingSpace14 = null;
        booking6.setSpaceId(parkingSpace14);
        double double16 = booking6.getAmount();
        // The following exception was thrown during execution in test generation
        try {
            double double17 = booking6.calculateRefund();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: temporal");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 0.0d + "'", double16 == 0.0d);
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test181");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace6 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str7 = parkingSpace6.getId();
        parkingSpace6.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState9 = parkingSpace6.getState();
        parkingSpace2.setState(parkingSpaceState9);
        com.example.parking.observer.Observer observer11 = null;
        parkingSpace2.detach(observer11);
        parkingSpace2.setRate((double) (short) -1);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "hi!" + "'", str7, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState9);
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test182");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getId();
        parkingSpace4.enable();
        java.lang.String str7 = parkingSpace4.toString();
        parkingSpace4.disable();
        java.lang.String str9 = parkingSpace4.toString();
        java.time.LocalDateTime localDateTime10 = null;
        java.time.LocalDateTime localDateTime11 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod12 = null;
        com.example.parking.model.Booking booking13 = new com.example.parking.model.Booking("Available", client1, parkingSpace4, localDateTime10, localDateTime11, paymentMethod12);
        boolean boolean14 = parkingSpace4.isBooked();
        boolean boolean15 = parkingSpace4.isOccupied();
        java.util.List<com.example.parking.observer.Observer> observerList16 = parkingSpace4.getObservers();
        parkingSpace4.notifyObservers();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "hi!" + "'", str5, "hi!");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str9, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(observerList16);
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test183");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = null;
        booking6.setPaymentMethod(paymentMethod7);
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test184");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace8 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str9 = parkingSpace8.getId();
        parkingSpace8.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState11 = parkingSpace8.getState();
        parkingSpace4.setState(parkingSpaceState11);
        com.example.parking.observer.Observer observer13 = null;
        parkingSpace4.detach(observer13);
        java.time.LocalDateTime localDateTime15 = null;
        java.time.LocalDateTime localDateTime16 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod17 = null;
        com.example.parking.model.Booking booking18 = new com.example.parking.model.Booking("hi!", client1, parkingSpace4, localDateTime15, localDateTime16, paymentMethod17);
        com.example.parking.model.payment.PaymentMethod paymentMethod19 = booking18.getPaymentMethod();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState11);
        org.junit.Assert.assertNull(paymentMethod19);
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test185");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.lang.String str9 = booking6.getStatus();
        com.example.parking.model.Client client11 = null;
        com.example.parking.model.ParkingSpace parkingSpace14 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str15 = parkingSpace14.getId();
        parkingSpace14.enable();
        java.lang.String str17 = parkingSpace14.toString();
        parkingSpace14.disable();
        java.lang.String str19 = parkingSpace14.toString();
        java.time.LocalDateTime localDateTime20 = null;
        java.time.LocalDateTime localDateTime21 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod22 = null;
        com.example.parking.model.Booking booking23 = new com.example.parking.model.Booking("Available", client11, parkingSpace14, localDateTime20, localDateTime21, paymentMethod22);
        boolean boolean24 = parkingSpace14.isBooked();
        boolean boolean25 = parkingSpace14.isOccupied();
        booking6.setSpaceId(parkingSpace14);
        boolean boolean27 = parkingSpace14.isBooked();
        java.lang.String str28 = parkingSpace14.toString();
        parkingSpace14.notifyObservers();
        parkingSpace14.free();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Active" + "'", str9, "Active");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "hi!" + "'", str15, "hi!");
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str17, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str19, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertEquals("'" + str28 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str28, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test186");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setLicensePlate("Active");
        double double9 = booking6.getDeposit();
        booking6.setStatus("ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        java.time.LocalDateTime localDateTime12 = null;
        // The following exception was thrown during execution in test generation
        try {
            booking6.extendParkingTime(localDateTime12, "hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDateTime.isBefore(java.time.chrono.ChronoLocalDateTime)\" because \"newEndTime\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 10.0d + "'", double9 == 10.0d);
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test187");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace6 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str7 = parkingSpace6.getId();
        parkingSpace6.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState9 = parkingSpace6.getState();
        parkingSpace2.setState(parkingSpaceState9);
        com.example.parking.observer.Observer observer11 = null;
        parkingSpace2.detach(observer11);
        java.lang.String str13 = parkingSpace2.toString();
        double double14 = parkingSpace2.getRate();
        java.lang.String str15 = parkingSpace2.getId();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "hi!" + "'", str7, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState9);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str13, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 0.0d + "'", double14 == 0.0d);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "hi!" + "'", str15, "hi!");
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test188");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setTotalCost((double) (byte) 100);
        booking6.setAmount((double) (-1.0f));
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str11 = booking6.toString();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.example.parking.model.Client.getId()\" because \"this.client\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test189");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getId();
        parkingSpace2.enable();
        java.lang.String str5 = parkingSpace2.toString();
        java.lang.String str6 = parkingSpace2.getLicensePlate();
        boolean boolean7 = parkingSpace2.isEnabled();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hi!" + "'", str3, "hi!");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str5, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertNull(str6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test190");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setTotalCost((double) (byte) 100);
        booking6.setStatus("Active");
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test191");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setLicensePlate("Active");
        booking6.setStatus("Available");
        com.example.parking.model.Car car12 = null;
        // The following exception was thrown during execution in test generation
        try {
            booking6.setOccupied(true, car12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.example.parking.model.ParkingSpace.setOccupied(boolean, com.example.parking.model.Car)\" because \"this.spaceId\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test192");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getId();
        parkingSpace2.enable();
        java.lang.String str5 = parkingSpace2.toString();
        parkingSpace2.disable();
        java.lang.String str7 = parkingSpace2.getId();
        parkingSpace2.notifyObservers();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hi!" + "'", str3, "hi!");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str5, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "hi!" + "'", str7, "hi!");
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test193");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setLicensePlate("Active");
        booking6.checkout();
        double double10 = booking6.getAmount();
        double double11 = booking6.getDeposit();
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + (-10.0d) + "'", double10 == (-10.0d));
        org.junit.Assert.assertTrue("'" + double11 + "' != '" + 10.0d + "'", double11 == 10.0d);
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test194");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getId();
        boolean boolean4 = parkingSpace2.isDisabled();
        boolean boolean5 = parkingSpace2.isBooked();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hi!" + "'", str3, "hi!");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test195");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("No car", (double) 10.0f);
        java.lang.String str5 = parkingSpace4.getCarInfo();
        java.time.LocalDateTime localDateTime6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.example.parking.model.Booking booking9 = com.example.parking.model.Booking.createBooking("No car", client1, parkingSpace4, localDateTime6, localDateTime7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDateTime.isAfter(java.time.chrono.ChronoLocalDateTime)\" because \"startTime\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "No car" + "'", str5, "No car");
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test196");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace6 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str7 = parkingSpace6.getId();
        parkingSpace6.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState9 = parkingSpace6.getState();
        parkingSpace2.setState(parkingSpaceState9);
        boolean boolean11 = parkingSpace2.isDisabled();
        java.lang.String str12 = parkingSpace2.getCarInfo();
        parkingSpace2.setRate((double) 10.0f);
        java.lang.String str15 = parkingSpace2.getCarInfo();
        double double16 = parkingSpace2.getRate();
        java.lang.String str17 = parkingSpace2.toString();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "hi!" + "'", str7, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState9);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "No car" + "'", str12, "No car");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "No car" + "'", str15, "No car");
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 10.0d + "'", double16 == 10.0d);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=10.0, licensePlate='null'}" + "'", str17, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=10.0, licensePlate='null'}");
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test197");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        booking6.setAmount((double) (short) 0);
        com.example.parking.model.ParkingSpace parkingSpace14 = null;
        booking6.setSpaceId(parkingSpace14);
        double double16 = booking6.getAmount();
        booking6.setTotalCost((double) (-1L));
        booking6.setTotalCost((double) 1.0f);
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 0.0d + "'", double16 == 0.0d);
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test198");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getId();
        parkingSpace4.enable();
        java.lang.String str7 = parkingSpace4.toString();
        parkingSpace4.disable();
        java.lang.String str9 = parkingSpace4.toString();
        java.time.LocalDateTime localDateTime10 = null;
        java.time.LocalDateTime localDateTime11 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod12 = null;
        com.example.parking.model.Booking booking13 = new com.example.parking.model.Booking("Available", client1, parkingSpace4, localDateTime10, localDateTime11, paymentMethod12);
        boolean boolean14 = parkingSpace4.isBooked();
        boolean boolean15 = parkingSpace4.isOccupied();
        java.lang.String str16 = parkingSpace4.getCarInfo();
        com.example.parking.model.ParkingSpace parkingSpace19 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str20 = parkingSpace19.getStatus();
        com.example.parking.state.ParkingSpaceState parkingSpaceState21 = parkingSpace19.getState();
        parkingSpace4.setState(parkingSpaceState21);
        parkingSpace4.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState24 = parkingSpace4.getState();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "hi!" + "'", str5, "hi!");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str9, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "No car" + "'", str16, "No car");
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "Available" + "'", str20, "Available");
        org.junit.Assert.assertNotNull(parkingSpaceState21);
        org.junit.Assert.assertNotNull(parkingSpaceState24);
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test199");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        boolean boolean5 = parkingSpace4.isOccupied();
        java.lang.String str6 = parkingSpace4.getCarInfo();
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod9 = null;
        com.example.parking.model.Booking booking10 = new com.example.parking.model.Booking("hi!", client1, parkingSpace4, localDateTime7, localDateTime8, paymentMethod9);
        parkingSpace4.enable();
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "No car" + "'", str6, "No car");
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test200");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        booking6.setAmount((double) (short) 0);
        com.example.parking.model.ParkingSpace parkingSpace14 = null;
        booking6.setSpaceId(parkingSpace14);
        java.time.LocalDateTime localDateTime16 = booking6.getStartTime();
        java.time.LocalDateTime localDateTime17 = null;
        booking6.setStartTime(localDateTime17);
        com.example.parking.model.ParkingSpace parkingSpace19 = booking6.getSpaceId();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertNull(localDateTime16);
        org.junit.Assert.assertNull(parkingSpace19);
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test201");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processPayment((double) 10L);
        com.example.parking.model.ParkingSpace parkingSpace9 = null;
        booking6.setSpaceId(parkingSpace9);
        com.example.parking.model.payment.PaymentMethod paymentMethod11 = null;
        booking6.setPaymentMethod(paymentMethod11);
        booking6.setAmount((double) '4');
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test202");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        boolean boolean4 = parkingSpace2.isBooked();
        java.lang.String str5 = parkingSpace2.toString();
        java.lang.String str6 = parkingSpace2.getStatus();
        boolean boolean7 = parkingSpace2.isDisabled();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str5, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "Available" + "'", str6, "Available");
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test203");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processRefund((double) (short) -1);
        double double9 = booking6.getTotalCost();
        com.example.parking.model.payment.PaymentMethod paymentMethod10 = booking6.getPaymentMethod();
        booking6.setStatus("ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        com.example.parking.model.ParkingSpace parkingSpace15 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        boolean boolean16 = parkingSpace15.isOccupied();
        parkingSpace15.notifyObservers();
        boolean boolean18 = parkingSpace15.isEnabled();
        parkingSpace15.notifyObservers();
        booking6.setSpaceId(parkingSpace15);
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 0.0d + "'", double9 == 0.0d);
        org.junit.Assert.assertNull(paymentMethod10);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test204");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace8 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str9 = parkingSpace8.getId();
        parkingSpace8.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState11 = parkingSpace8.getState();
        parkingSpace4.setState(parkingSpaceState11);
        java.time.LocalDateTime localDateTime13 = null;
        java.time.LocalDateTime localDateTime14 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod15 = null;
        com.example.parking.model.Booking booking16 = new com.example.parking.model.Booking("Available", client1, parkingSpace4, localDateTime13, localDateTime14, paymentMethod15);
        java.util.List<com.example.parking.observer.Observer> observerList17 = parkingSpace4.getObservers();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState11);
        org.junit.Assert.assertNotNull(observerList17);
    }

    @Test
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test205");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace8 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str9 = parkingSpace8.getId();
        parkingSpace8.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState11 = parkingSpace8.getState();
        parkingSpace4.setState(parkingSpaceState11);
        com.example.parking.observer.Observer observer13 = null;
        parkingSpace4.detach(observer13);
        java.time.LocalDateTime localDateTime15 = null;
        java.time.LocalDateTime localDateTime16 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod17 = null;
        com.example.parking.model.Booking booking18 = new com.example.parking.model.Booking("ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}", client1, parkingSpace4, localDateTime15, localDateTime16, paymentMethod17);
        java.lang.String str19 = parkingSpace4.getLicensePlate();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState11);
        org.junit.Assert.assertNull(str19);
    }

    @Test
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test206");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        boolean boolean4 = parkingSpace2.isBooked();
        com.example.parking.model.ParkingSpace parkingSpace7 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str8 = parkingSpace7.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace11 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str12 = parkingSpace11.getId();
        parkingSpace11.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState14 = parkingSpace11.getState();
        parkingSpace7.setState(parkingSpaceState14);
        parkingSpace2.setState(parkingSpaceState14);
        com.example.parking.state.ParkingSpaceState parkingSpaceState17 = parkingSpace2.getState();
        parkingSpace2.enable();
        parkingSpace2.notifyObservers();
        com.example.parking.state.ParkingSpaceState parkingSpaceState20 = parkingSpace2.getState();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "Available" + "'", str8, "Available");
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "hi!" + "'", str12, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState14);
        org.junit.Assert.assertNotNull(parkingSpaceState17);
        org.junit.Assert.assertNotNull(parkingSpaceState20);
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test207");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        booking6.setAmount((double) (short) 0);
        com.example.parking.model.ParkingSpace parkingSpace14 = null;
        booking6.setSpaceId(parkingSpace14);
        java.time.LocalDateTime localDateTime16 = booking6.getStartTime();
        booking6.setBookingId("No car");
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertNull(localDateTime16);
    }

    @Test
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test208");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace8 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str9 = parkingSpace8.getId();
        parkingSpace8.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState11 = parkingSpace8.getState();
        parkingSpace4.setState(parkingSpaceState11);
        com.example.parking.observer.Observer observer13 = null;
        parkingSpace4.detach(observer13);
        java.time.LocalDateTime localDateTime15 = null;
        java.time.LocalDateTime localDateTime16 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod17 = null;
        com.example.parking.model.Booking booking18 = new com.example.parking.model.Booking("Active", client1, parkingSpace4, localDateTime15, localDateTime16, paymentMethod17);
        java.lang.String str19 = parkingSpace4.getCarInfo();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState11);
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "No car" + "'", str19, "No car");
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test209");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("No car", (double) 10.0f);
        boolean boolean3 = parkingSpace2.isEnabled();
        parkingSpace2.enable();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test210");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getId();
        parkingSpace2.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState5 = parkingSpace2.getState();
        boolean boolean6 = parkingSpace2.isOccupied();
        java.util.List<com.example.parking.observer.Observer> observerList7 = parkingSpace2.getObservers();
        boolean boolean8 = parkingSpace2.isDisabled();
        double double9 = parkingSpace2.getRate();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hi!" + "'", str3, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(observerList7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 0.0d + "'", double9 == 0.0d);
    }

    @Test
    public void test211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test211");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setAmount((double) 10L);
        com.example.parking.model.Client client9 = booking6.getClient();
        java.time.LocalDateTime localDateTime10 = booking6.getEndTime();
        // The following exception was thrown during execution in test generation
        try {
            booking6.cancelBooking();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.temporal.Temporal.until(java.time.temporal.Temporal, java.time.temporal.TemporalUnit)\" because \"temporal1Inclusive\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(client9);
        org.junit.Assert.assertNull(localDateTime10);
    }

    @Test
    public void test212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test212");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        java.time.LocalDateTime localDateTime10 = booking6.getStartTime();
        double double11 = booking6.getTotalCost();
        com.example.parking.model.ParkingSpace parkingSpace14 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str15 = parkingSpace14.getId();
        parkingSpace14.enable();
        java.lang.String str17 = parkingSpace14.toString();
        parkingSpace14.setRate((double) (short) -1);
        com.example.parking.model.ParkingSpace parkingSpace22 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str23 = parkingSpace22.getStatus();
        boolean boolean24 = parkingSpace22.isBooked();
        java.lang.String str25 = parkingSpace22.toString();
        com.example.parking.state.ParkingSpaceState parkingSpaceState26 = parkingSpace22.getState();
        parkingSpace14.setState(parkingSpaceState26);
        booking6.setSpaceId(parkingSpace14);
        booking6.checkout();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertNull(localDateTime10);
        org.junit.Assert.assertTrue("'" + double11 + "' != '" + 0.0d + "'", double11 == 0.0d);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "hi!" + "'", str15, "hi!");
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str17, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str23 + "' != '" + "Available" + "'", str23, "Available");
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertEquals("'" + str25 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str25, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertNotNull(parkingSpaceState26);
    }

    @Test
    public void test213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test213");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processPayment((double) 10L);
        com.example.parking.model.ParkingSpace parkingSpace9 = null;
        booking6.setSpaceId(parkingSpace9);
        java.time.LocalDateTime localDateTime11 = booking6.getStartTime();
        booking6.setStatus("hi!");
        com.example.parking.model.payment.PaymentMethod paymentMethod14 = booking6.getPaymentMethod();
        com.example.parking.model.Client client15 = null;
        booking6.setClient(client15);
        org.junit.Assert.assertNull(localDateTime11);
        org.junit.Assert.assertNull(paymentMethod14);
    }

    @Test
    public void test214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test214");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        parkingSpace2.free();
        java.lang.String str5 = parkingSpace2.getSpaceId();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "hi!" + "'", str5, "hi!");
    }

    @Test
    public void test215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test215");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getId();
        parkingSpace4.enable();
        java.lang.String str7 = parkingSpace4.toString();
        parkingSpace4.disable();
        java.lang.String str9 = parkingSpace4.toString();
        java.time.LocalDateTime localDateTime10 = null;
        java.time.LocalDateTime localDateTime11 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod12 = null;
        com.example.parking.model.Booking booking13 = new com.example.parking.model.Booking("Available", client1, parkingSpace4, localDateTime10, localDateTime11, paymentMethod12);
        boolean boolean14 = parkingSpace4.isBooked();
        boolean boolean15 = parkingSpace4.isOccupied();
        java.util.List<com.example.parking.observer.Observer> observerList16 = parkingSpace4.getObservers();
        java.lang.String str17 = parkingSpace4.getStatus();
        boolean boolean18 = parkingSpace4.isDisabled();
        parkingSpace4.free();
        com.example.parking.observer.Observer observer20 = null;
        parkingSpace4.detach(observer20);
        parkingSpace4.notifyObservers();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "hi!" + "'", str5, "hi!");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str9, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(observerList16);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "Disabled" + "'", str17, "Disabled");
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
    }

    @Test
    public void test216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test216");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.lang.String str9 = booking6.getStatus();
        booking6.setBookingId("Available");
        booking6.setAmount((double) (-1L));
        com.example.parking.model.payment.PaymentMethod paymentMethod14 = null;
        booking6.setPaymentMethod(paymentMethod14);
        com.example.parking.model.payment.PaymentMethod paymentMethod16 = booking6.getPaymentMethod();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Active" + "'", str9, "Active");
        org.junit.Assert.assertNull(paymentMethod16);
    }

    @Test
    public void test217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test217");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getId();
        parkingSpace2.enable();
        java.lang.String str5 = parkingSpace2.toString();
        java.lang.String str6 = parkingSpace2.getLicensePlate();
        parkingSpace2.occupy("Available");
        parkingSpace2.enable();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hi!" + "'", str3, "hi!");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str5, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test218");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace8 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str9 = parkingSpace8.getId();
        parkingSpace8.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState11 = parkingSpace8.getState();
        parkingSpace4.setState(parkingSpaceState11);
        com.example.parking.observer.Observer observer13 = null;
        parkingSpace4.detach(observer13);
        java.time.LocalDateTime localDateTime15 = null;
        java.time.LocalDateTime localDateTime16 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod17 = null;
        com.example.parking.model.Booking booking18 = new com.example.parking.model.Booking("Active", client1, parkingSpace4, localDateTime15, localDateTime16, paymentMethod17);
        boolean boolean19 = parkingSpace4.isDisabled();
        java.lang.String str20 = parkingSpace4.toString();
        com.example.parking.model.Car car22 = null;
        parkingSpace4.setOccupied(true, car22);
        com.example.parking.model.Client client25 = null;
        com.example.parking.model.ParkingSpace parkingSpace28 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str29 = parkingSpace28.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace32 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str33 = parkingSpace32.getId();
        parkingSpace32.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState35 = parkingSpace32.getState();
        parkingSpace28.setState(parkingSpaceState35);
        com.example.parking.observer.Observer observer37 = null;
        parkingSpace28.detach(observer37);
        java.time.LocalDateTime localDateTime39 = null;
        java.time.LocalDateTime localDateTime40 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod41 = null;
        com.example.parking.model.Booking booking42 = new com.example.parking.model.Booking("Active", client25, parkingSpace28, localDateTime39, localDateTime40, paymentMethod41);
        boolean boolean43 = parkingSpace28.isDisabled();
        java.util.List<com.example.parking.observer.Observer> observerList44 = parkingSpace28.getObservers();
        com.example.parking.state.ParkingSpaceState parkingSpaceState45 = parkingSpace28.getState();
        parkingSpace4.setState(parkingSpaceState45);
        parkingSpace4.free();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState11);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str20, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str29 + "' != '" + "Available" + "'", str29, "Available");
        org.junit.Assert.assertEquals("'" + str33 + "' != '" + "hi!" + "'", str33, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState35);
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + false + "'", boolean43 == false);
        org.junit.Assert.assertNotNull(observerList44);
        org.junit.Assert.assertNotNull(parkingSpaceState45);
    }

    @Test
    public void test219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test219");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace6 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str7 = parkingSpace6.getId();
        parkingSpace6.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState9 = parkingSpace6.getState();
        parkingSpace2.setState(parkingSpaceState9);
        com.example.parking.observer.Observer observer11 = null;
        parkingSpace2.detach(observer11);
        java.lang.String str13 = parkingSpace2.getSpaceId();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "hi!" + "'", str7, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState9);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "hi!" + "'", str13, "hi!");
    }

    @Test
    public void test220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test220");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.time.LocalDateTime localDateTime9 = null;
        booking6.setEndTime(localDateTime9);
        booking6.setDeposit((double) 1.0f);
        java.time.LocalDateTime localDateTime13 = null;
        booking6.setStartTime(localDateTime13);
        java.time.LocalDateTime localDateTime15 = null;
        booking6.setEndTime(localDateTime15);
        java.time.LocalDateTime localDateTime17 = booking6.getStartTime();
        double double18 = booking6.getAmount();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertNull(localDateTime17);
        org.junit.Assert.assertTrue("'" + double18 + "' != '" + 0.0d + "'", double18 == 0.0d);
    }

    @Test
    public void test221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test221");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processRefund((double) (short) -1);
        double double9 = booking6.getTotalCost();
        java.lang.String str10 = booking6.getStatus();
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 0.0d + "'", double9 == 0.0d);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "Active" + "'", str10, "Active");
    }

    @Test
    public void test222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test222");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getId();
        parkingSpace2.enable();
        java.lang.String str5 = parkingSpace2.toString();
        parkingSpace2.setRate((double) (short) -1);
        com.example.parking.model.ParkingSpace parkingSpace10 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str11 = parkingSpace10.getStatus();
        boolean boolean12 = parkingSpace10.isBooked();
        java.lang.String str13 = parkingSpace10.toString();
        com.example.parking.state.ParkingSpaceState parkingSpaceState14 = parkingSpace10.getState();
        parkingSpace2.setState(parkingSpaceState14);
        com.example.parking.model.ParkingSpace parkingSpace18 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str19 = parkingSpace18.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace22 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str23 = parkingSpace22.getId();
        parkingSpace22.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState25 = parkingSpace22.getState();
        parkingSpace18.setState(parkingSpaceState25);
        parkingSpace2.setState(parkingSpaceState25);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hi!" + "'", str3, "hi!");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str5, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "Available" + "'", str11, "Available");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str13, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertNotNull(parkingSpaceState14);
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "Available" + "'", str19, "Available");
        org.junit.Assert.assertEquals("'" + str23 + "' != '" + "hi!" + "'", str23, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState25);
    }

    @Test
    public void test223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test223");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("Available", 10.0d);
    }

    @Test
    public void test224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test224");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace8 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str9 = parkingSpace8.getId();
        parkingSpace8.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState11 = parkingSpace8.getState();
        parkingSpace4.setState(parkingSpaceState11);
        com.example.parking.observer.Observer observer13 = null;
        parkingSpace4.detach(observer13);
        java.time.LocalDateTime localDateTime15 = null;
        java.time.LocalDateTime localDateTime16 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod17 = null;
        com.example.parking.model.Booking booking18 = new com.example.parking.model.Booking("Active", client1, parkingSpace4, localDateTime15, localDateTime16, paymentMethod17);
        boolean boolean19 = parkingSpace4.isDisabled();
        com.example.parking.state.ParkingSpaceState parkingSpaceState20 = parkingSpace4.getState();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState11);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNotNull(parkingSpaceState20);
    }

    @Test
    public void test225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test225");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        parkingSpace2.disable();
        com.example.parking.model.Car car6 = null;
        parkingSpace2.setOccupied(false, car6);
        parkingSpace2.notifyObservers();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
    }

    @Test
    public void test226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test226");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setLicensePlate("Active");
        booking6.setStatus("Available");
        com.example.parking.model.payment.PaymentMethod paymentMethod11 = booking6.getPaymentMethod();
        com.example.parking.model.ParkingSpace parkingSpace12 = booking6.getSpaceId();
        org.junit.Assert.assertNull(paymentMethod11);
        org.junit.Assert.assertNull(parkingSpace12);
    }

    @Test
    public void test227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test227");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        boolean boolean4 = parkingSpace2.isBooked();
        java.lang.String str5 = parkingSpace2.toString();
        com.example.parking.state.ParkingSpaceState parkingSpaceState6 = parkingSpace2.getState();
        java.lang.String str7 = parkingSpace2.toString();
        boolean boolean8 = parkingSpace2.isOccupied();
        parkingSpace2.occupy("");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str5, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertNotNull(parkingSpaceState6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test228");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setBookingId("No car");
        booking6.setAmount((-1.0d));
        booking6.processPayment((double) '#');
    }

    @Test
    public void test229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test229");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        boolean boolean6 = parkingSpace4.isBooked();
        java.lang.String str7 = parkingSpace4.toString();
        java.lang.String str8 = parkingSpace4.getStatus();
        java.time.LocalDateTime localDateTime9 = null;
        java.time.LocalDateTime localDateTime10 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod11 = null;
        com.example.parking.model.Booking booking12 = new com.example.parking.model.Booking("Disabled", client1, parkingSpace4, localDateTime9, localDateTime10, paymentMethod11);
        com.example.parking.model.payment.PaymentMethod paymentMethod13 = null;
        booking12.setPaymentMethod(paymentMethod13);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "Available" + "'", str8, "Available");
    }

    @Test
    public void test230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test230");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        java.time.LocalDateTime localDateTime10 = booking6.getStartTime();
        com.example.parking.model.ParkingSpace parkingSpace11 = booking6.getSpaceId();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertNull(localDateTime10);
        org.junit.Assert.assertNull(parkingSpace11);
    }

    @Test
    public void test231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test231");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processRefund((double) (short) -1);
        double double9 = booking6.getTotalCost();
        com.example.parking.model.payment.PaymentMethod paymentMethod10 = booking6.getPaymentMethod();
        booking6.setAmount((double) '4');
        booking6.processPayment((double) 10L);
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 0.0d + "'", double9 == 0.0d);
        org.junit.Assert.assertNull(paymentMethod10);
    }

    @Test
    public void test232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test232");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.lang.String str9 = booking6.getStatus();
        com.example.parking.model.Client client11 = null;
        com.example.parking.model.ParkingSpace parkingSpace14 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str15 = parkingSpace14.getId();
        parkingSpace14.enable();
        java.lang.String str17 = parkingSpace14.toString();
        parkingSpace14.disable();
        java.lang.String str19 = parkingSpace14.toString();
        java.time.LocalDateTime localDateTime20 = null;
        java.time.LocalDateTime localDateTime21 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod22 = null;
        com.example.parking.model.Booking booking23 = new com.example.parking.model.Booking("Available", client11, parkingSpace14, localDateTime20, localDateTime21, paymentMethod22);
        boolean boolean24 = parkingSpace14.isBooked();
        boolean boolean25 = parkingSpace14.isOccupied();
        booking6.setSpaceId(parkingSpace14);
        boolean boolean27 = parkingSpace14.isOccupied();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Active" + "'", str9, "Active");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "hi!" + "'", str15, "hi!");
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str17, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str19, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
    }

    @Test
    public void test233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test233");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processRefund((double) (short) -1);
        double double9 = booking6.getTotalCost();
        com.example.parking.model.payment.PaymentMethod paymentMethod10 = booking6.getPaymentMethod();
        // The following exception was thrown during execution in test generation
        try {
            double double11 = booking6.calculateRefund();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: temporal");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 0.0d + "'", double9 == 0.0d);
        org.junit.Assert.assertNull(paymentMethod10);
    }

    @Test
    public void test234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test234");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace6 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str7 = parkingSpace6.getId();
        parkingSpace6.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState9 = parkingSpace6.getState();
        parkingSpace2.setState(parkingSpaceState9);
        boolean boolean11 = parkingSpace2.isDisabled();
        java.lang.String str12 = parkingSpace2.getCarInfo();
        parkingSpace2.setRate((double) 10.0f);
        java.lang.String str15 = parkingSpace2.getCarInfo();
        parkingSpace2.disable();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "hi!" + "'", str7, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState9);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "No car" + "'", str12, "No car");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "No car" + "'", str15, "No car");
    }

    @Test
    public void test235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test235");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processRefund((double) (short) -1);
        double double9 = booking6.getTotalCost();
        com.example.parking.model.payment.PaymentMethod paymentMethod10 = booking6.getPaymentMethod();
        booking6.setStatus("ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        com.example.parking.model.ParkingSpace parkingSpace13 = booking6.getParkingSpace();
        booking6.setLicensePlate("hi!");
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 0.0d + "'", double9 == 0.0d);
        org.junit.Assert.assertNull(paymentMethod10);
        org.junit.Assert.assertNull(parkingSpace13);
    }

    @Test
    public void test236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test236");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=10.0, licensePlate='null'}", (double) 0L);
    }

    @Test
    public void test237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test237");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.Client client3 = null;
        com.example.parking.model.ParkingSpace parkingSpace6 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str7 = parkingSpace6.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace10 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str11 = parkingSpace10.getId();
        parkingSpace10.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState13 = parkingSpace10.getState();
        parkingSpace6.setState(parkingSpaceState13);
        com.example.parking.observer.Observer observer15 = null;
        parkingSpace6.detach(observer15);
        java.time.LocalDateTime localDateTime17 = null;
        java.time.LocalDateTime localDateTime18 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod19 = null;
        com.example.parking.model.Booking booking20 = new com.example.parking.model.Booking("Active", client3, parkingSpace6, localDateTime17, localDateTime18, paymentMethod19);
        com.example.parking.model.Car car22 = null;
        parkingSpace6.setOccupied(false, car22);
        java.time.LocalDateTime localDateTime24 = null;
        java.time.LocalDateTime localDateTime25 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.example.parking.model.Booking booking27 = com.example.parking.model.Booking.createBooking("Active", client1, parkingSpace6, localDateTime24, localDateTime25, "");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDateTime.isAfter(java.time.chrono.ChronoLocalDateTime)\" because \"startTime\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "Available" + "'", str7, "Available");
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "hi!" + "'", str11, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState13);
    }

    @Test
    public void test238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test238");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace8 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str9 = parkingSpace8.getId();
        parkingSpace8.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState11 = parkingSpace8.getState();
        parkingSpace4.setState(parkingSpaceState11);
        boolean boolean13 = parkingSpace4.isDisabled();
        java.lang.String str14 = parkingSpace4.getCarInfo();
        parkingSpace4.setRate((double) 10.0f);
        java.lang.String str17 = parkingSpace4.getCarInfo();
        com.example.parking.model.Car car19 = null;
        parkingSpace4.setOccupied(false, car19);
        java.time.LocalDateTime localDateTime21 = null;
        java.time.LocalDateTime localDateTime22 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.example.parking.model.Booking booking24 = com.example.parking.model.Booking.createBooking("Available", client1, parkingSpace4, localDateTime21, localDateTime22, "Disabled");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDateTime.isAfter(java.time.chrono.ChronoLocalDateTime)\" because \"startTime\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState11);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "No car" + "'", str14, "No car");
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "No car" + "'", str17, "No car");
    }

    @Test
    public void test239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test239");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        com.example.parking.model.payment.PaymentMethod paymentMethod8 = booking6.getPaymentMethod();
        booking6.setAmount((double) 0);
        booking6.setAmount((double) (short) 100);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str13 = booking6.toString();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.example.parking.model.Client.getId()\" because \"this.client\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertNull(paymentMethod8);
    }

    @Test
    public void test240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test240");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processPayment((double) 10L);
        com.example.parking.model.ParkingSpace parkingSpace9 = null;
        booking6.setSpaceId(parkingSpace9);
        java.time.LocalDateTime localDateTime11 = booking6.getStartTime();
        booking6.setStatus("hi!");
        booking6.processRefund((double) (short) 10);
        org.junit.Assert.assertNull(localDateTime11);
    }

    @Test
    public void test241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test241");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setBookingId("No car");
        booking6.setAmount((-1.0d));
        com.example.parking.model.Client client11 = null;
        booking6.setClient(client11);
    }

    @Test
    public void test242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test242");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.lang.String str9 = booking6.getStatus();
        booking6.setBookingId("Available");
        double double12 = booking6.getTotalCost();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Active" + "'", str9, "Active");
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 0.0d + "'", double12 == 0.0d);
    }

    @Test
    public void test243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test243");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace6 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str7 = parkingSpace6.getId();
        parkingSpace6.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState9 = parkingSpace6.getState();
        parkingSpace2.setState(parkingSpaceState9);
        boolean boolean11 = parkingSpace2.isDisabled();
        java.lang.String str12 = parkingSpace2.getCarInfo();
        boolean boolean13 = parkingSpace2.isOccupied();
        java.lang.String str14 = parkingSpace2.getLicensePlate();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "hi!" + "'", str7, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState9);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "No car" + "'", str12, "No car");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNull(str14);
    }

    @Test
    public void test244() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test244");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        boolean boolean4 = parkingSpace2.isBooked();
        parkingSpace2.disable();
        com.example.parking.observer.Observer observer6 = null;
        parkingSpace2.detach(observer6);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test245() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test245");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getId();
        parkingSpace2.enable();
        java.lang.String str5 = parkingSpace2.toString();
        parkingSpace2.disable();
        java.lang.String str7 = parkingSpace2.toString();
        parkingSpace2.setEnabled(true);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hi!" + "'", str3, "hi!");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str5, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
    }

    @Test
    public void test246() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test246");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace8 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str9 = parkingSpace8.getId();
        parkingSpace8.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState11 = parkingSpace8.getState();
        parkingSpace4.setState(parkingSpaceState11);
        com.example.parking.observer.Observer observer13 = null;
        parkingSpace4.detach(observer13);
        java.time.LocalDateTime localDateTime15 = null;
        java.time.LocalDateTime localDateTime16 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod17 = null;
        com.example.parking.model.Booking booking18 = new com.example.parking.model.Booking("Active", client1, parkingSpace4, localDateTime15, localDateTime16, paymentMethod17);
        com.example.parking.model.Car car20 = null;
        parkingSpace4.setOccupied(false, car20);
        java.lang.String str22 = parkingSpace4.toString();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState11);
        org.junit.Assert.assertEquals("'" + str22 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str22, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
    }

    @Test
    public void test247() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test247");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}", (double) 0.0f);
    }

    @Test
    public void test248() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test248");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processRefund((double) (short) -1);
        booking6.setLicensePlate("");
        booking6.processRefund((double) 10);
        java.lang.String str13 = booking6.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace14 = booking6.getSpaceId();
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "Active" + "'", str13, "Active");
        org.junit.Assert.assertNull(parkingSpace14);
    }

    @Test
    public void test249() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test249");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.lang.String str9 = booking6.getStatus();
        com.example.parking.model.Client client11 = null;
        com.example.parking.model.ParkingSpace parkingSpace14 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str15 = parkingSpace14.getId();
        parkingSpace14.enable();
        java.lang.String str17 = parkingSpace14.toString();
        parkingSpace14.disable();
        java.lang.String str19 = parkingSpace14.toString();
        java.time.LocalDateTime localDateTime20 = null;
        java.time.LocalDateTime localDateTime21 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod22 = null;
        com.example.parking.model.Booking booking23 = new com.example.parking.model.Booking("Available", client11, parkingSpace14, localDateTime20, localDateTime21, paymentMethod22);
        boolean boolean24 = parkingSpace14.isBooked();
        boolean boolean25 = parkingSpace14.isOccupied();
        booking6.setSpaceId(parkingSpace14);
        boolean boolean27 = parkingSpace14.isBooked();
        java.lang.String str28 = parkingSpace14.toString();
        parkingSpace14.notifyObservers();
        java.lang.String str30 = parkingSpace14.toString();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Active" + "'", str9, "Active");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "hi!" + "'", str15, "hi!");
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str17, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str19, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertEquals("'" + str28 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str28, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str30 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str30, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
    }

    @Test
    public void test250() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test250");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getId();
        parkingSpace2.enable();
        java.lang.String str5 = parkingSpace2.toString();
        parkingSpace2.setRate((double) (short) -1);
        com.example.parking.model.Client client9 = null;
        com.example.parking.model.ParkingSpace parkingSpace12 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str13 = parkingSpace12.getId();
        parkingSpace12.enable();
        java.lang.String str15 = parkingSpace12.toString();
        parkingSpace12.disable();
        java.lang.String str17 = parkingSpace12.toString();
        java.time.LocalDateTime localDateTime18 = null;
        java.time.LocalDateTime localDateTime19 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod20 = null;
        com.example.parking.model.Booking booking21 = new com.example.parking.model.Booking("Available", client9, parkingSpace12, localDateTime18, localDateTime19, paymentMethod20);
        boolean boolean22 = parkingSpace12.isBooked();
        boolean boolean23 = parkingSpace12.isOccupied();
        java.lang.String str24 = parkingSpace12.getCarInfo();
        com.example.parking.model.ParkingSpace parkingSpace27 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str28 = parkingSpace27.getStatus();
        com.example.parking.state.ParkingSpaceState parkingSpaceState29 = parkingSpace27.getState();
        parkingSpace12.setState(parkingSpaceState29);
        parkingSpace2.setState(parkingSpaceState29);
        java.lang.String str32 = parkingSpace2.getSpaceId();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hi!" + "'", str3, "hi!");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str5, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "hi!" + "'", str13, "hi!");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str15, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str17, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + "No car" + "'", str24, "No car");
        org.junit.Assert.assertEquals("'" + str28 + "' != '" + "Available" + "'", str28, "Available");
        org.junit.Assert.assertNotNull(parkingSpaceState29);
        org.junit.Assert.assertEquals("'" + str32 + "' != '" + "hi!" + "'", str32, "hi!");
    }

    @Test
    public void test251() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test251");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        boolean boolean4 = parkingSpace2.isDisabled();
        java.lang.String str5 = parkingSpace2.getCarInfo();
        java.lang.String str6 = parkingSpace2.getStatus();
        boolean boolean7 = parkingSpace2.isBooked();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "No car" + "'", str5, "No car");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "Available" + "'", str6, "Available");
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test252() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test252");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        parkingSpace2.vacate();
        com.example.parking.observer.Observer observer5 = null;
        parkingSpace2.detach(observer5);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
    }

    @Test
    public void test253() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test253");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processRefund((double) (short) -1);
        com.example.parking.model.payment.PaymentMethod paymentMethod9 = null;
        booking6.setPaymentMethod(paymentMethod9);
        java.time.LocalDateTime localDateTime11 = null;
        booking6.setStartTime(localDateTime11);
    }

    @Test
    public void test254() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test254");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.lang.String str9 = booking6.getStatus();
        com.example.parking.model.Client client11 = null;
        com.example.parking.model.ParkingSpace parkingSpace14 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str15 = parkingSpace14.getId();
        parkingSpace14.enable();
        java.lang.String str17 = parkingSpace14.toString();
        parkingSpace14.disable();
        java.lang.String str19 = parkingSpace14.toString();
        java.time.LocalDateTime localDateTime20 = null;
        java.time.LocalDateTime localDateTime21 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod22 = null;
        com.example.parking.model.Booking booking23 = new com.example.parking.model.Booking("Available", client11, parkingSpace14, localDateTime20, localDateTime21, paymentMethod22);
        boolean boolean24 = parkingSpace14.isBooked();
        boolean boolean25 = parkingSpace14.isOccupied();
        booking6.setSpaceId(parkingSpace14);
        com.example.parking.model.Client client27 = booking6.getClient();
        com.example.parking.model.ParkingSpace parkingSpace28 = booking6.getSpaceId();
        com.example.parking.model.ParkingSpace parkingSpace29 = booking6.getSpaceId();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Active" + "'", str9, "Active");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "hi!" + "'", str15, "hi!");
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str17, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str19, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNull(client27);
        org.junit.Assert.assertNotNull(parkingSpace28);
        org.junit.Assert.assertNotNull(parkingSpace29);
    }

    @Test
    public void test255() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test255");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.Client client3 = null;
        com.example.parking.model.ParkingSpace parkingSpace6 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        boolean boolean7 = parkingSpace6.isOccupied();
        java.lang.String str8 = parkingSpace6.getCarInfo();
        java.time.LocalDateTime localDateTime9 = null;
        java.time.LocalDateTime localDateTime10 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod11 = null;
        com.example.parking.model.Booking booking12 = new com.example.parking.model.Booking("hi!", client3, parkingSpace6, localDateTime9, localDateTime10, paymentMethod11);
        java.time.LocalDateTime localDateTime13 = null;
        java.time.LocalDateTime localDateTime14 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod15 = null;
        com.example.parking.model.Booking booking16 = new com.example.parking.model.Booking("hi!", client1, parkingSpace6, localDateTime13, localDateTime14, paymentMethod15);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "No car" + "'", str8, "No car");
    }

    @Test
    public void test256() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test256");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace8 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str9 = parkingSpace8.getId();
        parkingSpace8.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState11 = parkingSpace8.getState();
        parkingSpace4.setState(parkingSpaceState11);
        com.example.parking.observer.Observer observer13 = null;
        parkingSpace4.detach(observer13);
        java.time.LocalDateTime localDateTime15 = null;
        java.time.LocalDateTime localDateTime16 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod17 = null;
        com.example.parking.model.Booking booking18 = new com.example.parking.model.Booking("Active", client1, parkingSpace4, localDateTime15, localDateTime16, paymentMethod17);
        java.time.LocalDateTime localDateTime19 = null;
        booking18.setStartTime(localDateTime19);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState11);
    }

    @Test
    public void test257() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test257");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        boolean boolean5 = parkingSpace4.isOccupied();
        java.lang.String str6 = parkingSpace4.getCarInfo();
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod9 = null;
        com.example.parking.model.Booking booking10 = new com.example.parking.model.Booking("hi!", client1, parkingSpace4, localDateTime7, localDateTime8, paymentMethod9);
        java.lang.String str11 = parkingSpace4.getSpaceId();
        java.lang.String str12 = parkingSpace4.getSpaceId();
        double double13 = parkingSpace4.getRate();
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "No car" + "'", str6, "No car");
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "hi!" + "'", str11, "hi!");
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "hi!" + "'", str12, "hi!");
        org.junit.Assert.assertTrue("'" + double13 + "' != '" + 0.0d + "'", double13 == 0.0d);
    }

    @Test
    public void test258() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test258");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        booking6.setAmount((double) (short) 0);
        com.example.parking.model.ParkingSpace parkingSpace14 = null;
        booking6.setSpaceId(parkingSpace14);
        booking6.setAmount((double) (-1L));
        booking6.setDeposit((double) (-1L));
        com.example.parking.model.Client client20 = null;
        booking6.setClient(client20);
        com.example.parking.model.payment.PaymentMethod paymentMethod22 = null;
        booking6.setPaymentMethod(paymentMethod22);
        org.junit.Assert.assertNull(paymentMethod7);
    }

    @Test
    public void test259() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test259");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("No car", (double) 10.0f);
        com.example.parking.model.ParkingSpace parkingSpace5 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str6 = parkingSpace5.getStatus();
        boolean boolean7 = parkingSpace5.isBooked();
        java.lang.String str8 = parkingSpace5.toString();
        com.example.parking.model.ParkingSpace parkingSpace11 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str12 = parkingSpace11.getStatus();
        boolean boolean13 = parkingSpace11.isBooked();
        com.example.parking.model.ParkingSpace parkingSpace16 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str17 = parkingSpace16.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace20 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str21 = parkingSpace20.getId();
        parkingSpace20.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState23 = parkingSpace20.getState();
        parkingSpace16.setState(parkingSpaceState23);
        parkingSpace11.setState(parkingSpaceState23);
        parkingSpace5.setState(parkingSpaceState23);
        parkingSpace2.setState(parkingSpaceState23);
        boolean boolean28 = parkingSpace2.isOccupied();
        java.lang.String str29 = parkingSpace2.toString();
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "Available" + "'", str6, "Available");
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str8, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "Available" + "'", str12, "Available");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "Available" + "'", str17, "Available");
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "hi!" + "'", str21, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState23);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertEquals("'" + str29 + "' != '" + "ParkingSpace{spaceId='No car', isBooked=false, isDisabled=false, rate=10.0, licensePlate='null'}" + "'", str29, "ParkingSpace{spaceId='No car', isBooked=false, isDisabled=false, rate=10.0, licensePlate='null'}");
    }

    @Test
    public void test260() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test260");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        com.example.parking.model.Client client9 = null;
        com.example.parking.model.ParkingSpace parkingSpace12 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str13 = parkingSpace12.getId();
        parkingSpace12.enable();
        java.lang.String str15 = parkingSpace12.toString();
        parkingSpace12.disable();
        java.lang.String str17 = parkingSpace12.toString();
        java.time.LocalDateTime localDateTime18 = null;
        java.time.LocalDateTime localDateTime19 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod20 = null;
        com.example.parking.model.Booking booking21 = new com.example.parking.model.Booking("Available", client9, parkingSpace12, localDateTime18, localDateTime19, paymentMethod20);
        boolean boolean22 = parkingSpace12.isBooked();
        boolean boolean23 = parkingSpace12.isOccupied();
        java.lang.String str24 = parkingSpace12.getCarInfo();
        com.example.parking.model.ParkingSpace parkingSpace27 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str28 = parkingSpace27.getStatus();
        com.example.parking.state.ParkingSpaceState parkingSpaceState29 = parkingSpace27.getState();
        parkingSpace12.setState(parkingSpaceState29);
        booking6.setSpaceId(parkingSpace12);
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "hi!" + "'", str13, "hi!");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str15, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str17, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + "No car" + "'", str24, "No car");
        org.junit.Assert.assertEquals("'" + str28 + "' != '" + "Available" + "'", str28, "Available");
        org.junit.Assert.assertNotNull(parkingSpaceState29);
    }

    @Test
    public void test261() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test261");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setLicensePlate("Active");
        booking6.checkout();
        java.lang.String str10 = booking6.getBookingId();
        booking6.checkout();
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "hi!" + "'", str10, "hi!");
    }

    @Test
    public void test262() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test262");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        boolean boolean4 = parkingSpace2.isBooked();
        java.lang.String str5 = parkingSpace2.toString();
        java.lang.String str6 = parkingSpace2.getStatus();
        java.lang.String str7 = parkingSpace2.getStatus();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str5, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "Available" + "'", str6, "Available");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "Available" + "'", str7, "Available");
    }

    @Test
    public void test263() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test263");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 100);
    }

    @Test
    public void test264() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test264");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        booking6.setAmount((double) (short) 0);
        com.example.parking.model.ParkingSpace parkingSpace14 = null;
        booking6.setSpaceId(parkingSpace14);
        double double16 = booking6.getAmount();
        com.example.parking.model.ParkingSpace parkingSpace17 = booking6.getParkingSpace();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 0.0d + "'", double16 == 0.0d);
        org.junit.Assert.assertNull(parkingSpace17);
    }

    @Test
    public void test265() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test265");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace8 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str9 = parkingSpace8.getId();
        parkingSpace8.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState11 = parkingSpace8.getState();
        parkingSpace4.setState(parkingSpaceState11);
        com.example.parking.observer.Observer observer13 = null;
        parkingSpace4.detach(observer13);
        java.time.LocalDateTime localDateTime15 = null;
        java.time.LocalDateTime localDateTime16 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod17 = null;
        com.example.parking.model.Booking booking18 = new com.example.parking.model.Booking("ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}", client1, parkingSpace4, localDateTime15, localDateTime16, paymentMethod17);
        com.example.parking.observer.Observer observer19 = null;
        parkingSpace4.attach(observer19);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState11);
    }

    @Test
    public void test266() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test266");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setLicensePlate("Active");
        double double9 = booking6.getDeposit();
        booking6.setStatus("Disabled");
        booking6.setTotalCost((double) 100.0f);
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 10.0d + "'", double9 == 10.0d);
    }

    @Test
    public void test267() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test267");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.Client client3 = null;
        com.example.parking.model.ParkingSpace parkingSpace6 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str7 = parkingSpace6.getId();
        parkingSpace6.enable();
        java.lang.String str9 = parkingSpace6.toString();
        parkingSpace6.disable();
        java.lang.String str11 = parkingSpace6.toString();
        java.time.LocalDateTime localDateTime12 = null;
        java.time.LocalDateTime localDateTime13 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod14 = null;
        com.example.parking.model.Booking booking15 = new com.example.parking.model.Booking("Available", client3, parkingSpace6, localDateTime12, localDateTime13, paymentMethod14);
        boolean boolean16 = parkingSpace6.isBooked();
        boolean boolean17 = parkingSpace6.isOccupied();
        java.util.List<com.example.parking.observer.Observer> observerList18 = parkingSpace6.getObservers();
        java.lang.String str19 = parkingSpace6.getStatus();
        boolean boolean20 = parkingSpace6.isDisabled();
        parkingSpace6.free();
        java.time.LocalDateTime localDateTime22 = null;
        java.time.LocalDateTime localDateTime23 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.example.parking.model.Booking booking25 = com.example.parking.model.Booking.createBooking("ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}", client1, parkingSpace6, localDateTime22, localDateTime23, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDateTime.isAfter(java.time.chrono.ChronoLocalDateTime)\" because \"startTime\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "hi!" + "'", str7, "hi!");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str9, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str11, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNotNull(observerList18);
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "Disabled" + "'", str19, "Disabled");
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
    }

    @Test
    public void test268() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test268");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processRefund((double) (short) -1);
        com.example.parking.model.payment.PaymentMethod paymentMethod9 = null;
        booking6.setPaymentMethod(paymentMethod9);
        java.lang.String str11 = booking6.getLicensePlate();
        org.junit.Assert.assertNull(str11);
    }

    @Test
    public void test269() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test269");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getId();
        parkingSpace4.enable();
        java.lang.String str7 = parkingSpace4.toString();
        parkingSpace4.disable();
        java.lang.String str9 = parkingSpace4.toString();
        java.time.LocalDateTime localDateTime10 = null;
        java.time.LocalDateTime localDateTime11 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod12 = null;
        com.example.parking.model.Booking booking13 = new com.example.parking.model.Booking("Available", client1, parkingSpace4, localDateTime10, localDateTime11, paymentMethod12);
        boolean boolean14 = parkingSpace4.isBooked();
        boolean boolean15 = parkingSpace4.isOccupied();
        java.util.List<com.example.parking.observer.Observer> observerList16 = parkingSpace4.getObservers();
        java.lang.String str17 = parkingSpace4.getStatus();
        boolean boolean18 = parkingSpace4.isDisabled();
        parkingSpace4.free();
        com.example.parking.observer.Observer observer20 = null;
        parkingSpace4.detach(observer20);
        parkingSpace4.disable();
        com.example.parking.model.Car car24 = null;
        parkingSpace4.setOccupied(false, car24);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "hi!" + "'", str5, "hi!");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str9, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(observerList16);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "Disabled" + "'", str17, "Disabled");
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
    }

    @Test
    public void test270() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test270");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        com.example.parking.model.payment.PaymentMethod paymentMethod8 = booking6.getPaymentMethod();
        booking6.setAmount(10.0d);
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertNull(paymentMethod8);
    }

    @Test
    public void test271() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test271");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        booking6.setAmount((double) (short) 0);
        com.example.parking.model.ParkingSpace parkingSpace14 = null;
        booking6.setSpaceId(parkingSpace14);
        double double16 = booking6.getDeposit();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 10.0d + "'", double16 == 10.0d);
    }

    @Test
    public void test272() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test272");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getId();
        parkingSpace2.enable();
        java.lang.String str5 = parkingSpace2.toString();
        parkingSpace2.disable();
        java.lang.String str7 = parkingSpace2.getId();
        java.lang.String str8 = parkingSpace2.getStatus();
        parkingSpace2.enable();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hi!" + "'", str3, "hi!");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str5, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "hi!" + "'", str7, "hi!");
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "Disabled" + "'", str8, "Disabled");
    }

    @Test
    public void test273() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test273");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setLicensePlate("Active");
        booking6.setStatus("Available");
        double double11 = booking6.getDeposit();
        org.junit.Assert.assertTrue("'" + double11 + "' != '" + 10.0d + "'", double11 == 10.0d);
    }

    @Test
    public void test274() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test274");
        com.example.parking.model.ParkingSpace parkingSpace2 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str3 = parkingSpace2.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace6 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str7 = parkingSpace6.getId();
        parkingSpace6.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState9 = parkingSpace6.getState();
        parkingSpace2.setState(parkingSpaceState9);
        com.example.parking.model.Car car12 = null;
        parkingSpace2.setOccupied(false, car12);
        com.example.parking.model.Car car15 = null;
        parkingSpace2.setOccupied(false, car15);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Available" + "'", str3, "Available");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "hi!" + "'", str7, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState9);
    }

    @Test
    public void test275() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test275");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.lang.String str9 = booking6.getStatus();
        java.lang.String str10 = booking6.getBookingId();
        java.time.LocalDateTime localDateTime11 = booking6.getEndTime();
        double double12 = booking6.getDeposit();
        java.time.LocalDateTime localDateTime13 = booking6.getStartTime();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str14 = booking6.toString();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.example.parking.model.Client.getId()\" because \"this.client\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Active" + "'", str9, "Active");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "hi!" + "'", str10, "hi!");
        org.junit.Assert.assertNull(localDateTime11);
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 10.0d + "'", double12 == 10.0d);
        org.junit.Assert.assertNull(localDateTime13);
    }

    @Test
    public void test276() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test276");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setLicensePlate("Active");
        booking6.checkout();
        double double10 = booking6.getAmount();
        double double11 = booking6.getAmount();
        double double12 = booking6.getTotalCost();
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + (-10.0d) + "'", double10 == (-10.0d));
        org.junit.Assert.assertTrue("'" + double11 + "' != '" + (-10.0d) + "'", double11 == (-10.0d));
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + (-10.0d) + "'", double12 == (-10.0d));
    }

    @Test
    public void test277() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test277");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getId();
        parkingSpace4.enable();
        java.lang.String str7 = parkingSpace4.toString();
        parkingSpace4.disable();
        java.lang.String str9 = parkingSpace4.toString();
        java.time.LocalDateTime localDateTime10 = null;
        java.time.LocalDateTime localDateTime11 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod12 = null;
        com.example.parking.model.Booking booking13 = new com.example.parking.model.Booking("Available", client1, parkingSpace4, localDateTime10, localDateTime11, paymentMethod12);
        boolean boolean14 = parkingSpace4.isBooked();
        boolean boolean15 = parkingSpace4.isOccupied();
        java.util.List<com.example.parking.observer.Observer> observerList16 = parkingSpace4.getObservers();
        parkingSpace4.setEnabled(false);
        java.lang.String str19 = parkingSpace4.getSpaceId();
        parkingSpace4.setRate(10.0d);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "hi!" + "'", str5, "hi!");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str7, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str9, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(observerList16);
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "hi!" + "'", str19, "hi!");
    }

    @Test
    public void test278() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test278");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setLicensePlate("Active");
        booking6.setStatus("Available");
        booking6.setTotalCost((double) (short) 0);
    }

    @Test
    public void test279() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test279");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.lang.String str8 = booking6.getBookingId();
        java.lang.String str9 = booking6.getStatus();
        com.example.parking.model.Client client11 = null;
        com.example.parking.model.ParkingSpace parkingSpace14 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str15 = parkingSpace14.getId();
        parkingSpace14.enable();
        java.lang.String str17 = parkingSpace14.toString();
        parkingSpace14.disable();
        java.lang.String str19 = parkingSpace14.toString();
        java.time.LocalDateTime localDateTime20 = null;
        java.time.LocalDateTime localDateTime21 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod22 = null;
        com.example.parking.model.Booking booking23 = new com.example.parking.model.Booking("Available", client11, parkingSpace14, localDateTime20, localDateTime21, paymentMethod22);
        boolean boolean24 = parkingSpace14.isBooked();
        boolean boolean25 = parkingSpace14.isOccupied();
        booking6.setSpaceId(parkingSpace14);
        com.example.parking.model.Client client27 = booking6.getClient();
        com.example.parking.model.ParkingSpace parkingSpace28 = booking6.getSpaceId();
        booking6.setLicensePlate("");
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "hi!" + "'", str8, "hi!");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "Active" + "'", str9, "Active");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "hi!" + "'", str15, "hi!");
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}" + "'", str17, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=false, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}" + "'", str19, "ParkingSpace{spaceId='hi!', isBooked=false, isDisabled=true, rate=0.0, licensePlate='null'}");
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNull(client27);
        org.junit.Assert.assertNotNull(parkingSpace28);
    }

    @Test
    public void test280() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test280");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str5 = parkingSpace4.getStatus();
        com.example.parking.model.ParkingSpace parkingSpace8 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        java.lang.String str9 = parkingSpace8.getId();
        parkingSpace8.enable();
        com.example.parking.state.ParkingSpaceState parkingSpaceState11 = parkingSpace8.getState();
        parkingSpace4.setState(parkingSpaceState11);
        com.example.parking.observer.Observer observer13 = null;
        parkingSpace4.detach(observer13);
        java.time.LocalDateTime localDateTime15 = null;
        java.time.LocalDateTime localDateTime16 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod17 = null;
        com.example.parking.model.Booking booking18 = new com.example.parking.model.Booking("Active", client1, parkingSpace4, localDateTime15, localDateTime16, paymentMethod17);
        com.example.parking.model.Car car20 = null;
        parkingSpace4.setOccupied(false, car20);
        parkingSpace4.setEnabled(true);
        com.example.parking.model.Car car25 = null;
        parkingSpace4.setOccupied(false, car25);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Available" + "'", str5, "Available");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "hi!" + "'", str9, "hi!");
        org.junit.Assert.assertNotNull(parkingSpaceState11);
    }

    @Test
    public void test281() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test281");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        com.example.parking.model.payment.PaymentMethod paymentMethod7 = booking6.getPaymentMethod();
        java.time.LocalDateTime localDateTime8 = null;
        booking6.setEndTime(localDateTime8);
        com.example.parking.model.Client client10 = null;
        booking6.setClient(client10);
        double double12 = booking6.getDeposit();
        booking6.setLicensePlate("");
        java.lang.String str15 = booking6.getStatus();
        org.junit.Assert.assertNull(paymentMethod7);
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 10.0d + "'", double12 == 10.0d);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "Active" + "'", str15, "Active");
    }

    @Test
    public void test282() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test282");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.processRefund((double) (short) -1);
        booking6.setLicensePlate("");
        booking6.processPayment((double) 1);
        booking6.setAmount((double) 10L);
        booking6.setDeposit((double) (short) -1);
        booking6.processRefund((double) 100L);
    }

    @Test
    public void test283() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test283");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace4 = new com.example.parking.model.ParkingSpace("hi!", (double) 0.0f);
        boolean boolean5 = parkingSpace4.isOccupied();
        java.lang.String str6 = parkingSpace4.getCarInfo();
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod9 = null;
        com.example.parking.model.Booking booking10 = new com.example.parking.model.Booking("hi!", client1, parkingSpace4, localDateTime7, localDateTime8, paymentMethod9);
        java.lang.String str11 = parkingSpace4.getSpaceId();
        java.lang.String str12 = parkingSpace4.getSpaceId();
        java.lang.String str13 = parkingSpace4.getLicensePlate();
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "No car" + "'", str6, "No car");
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "hi!" + "'", str11, "hi!");
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "hi!" + "'", str12, "hi!");
        org.junit.Assert.assertNull(str13);
    }

    @Test
    public void test284() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test284");
        com.example.parking.model.Client client1 = null;
        com.example.parking.model.ParkingSpace parkingSpace2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        com.example.parking.model.payment.PaymentMethod paymentMethod5 = null;
        com.example.parking.model.Booking booking6 = new com.example.parking.model.Booking("hi!", client1, parkingSpace2, localDateTime3, localDateTime4, paymentMethod5);
        booking6.setAmount((double) 10L);
        com.example.parking.model.Client client9 = booking6.getClient();
        java.time.LocalDateTime localDateTime10 = booking6.getEndTime();
        com.example.parking.model.Car car12 = null;
        // The following exception was thrown during execution in test generation
        try {
            booking6.setOccupied(false, car12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.example.parking.model.ParkingSpace.setOccupied(boolean, com.example.parking.model.Car)\" because \"this.spaceId\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(client9);
        org.junit.Assert.assertNull(localDateTime10);
    }
}

