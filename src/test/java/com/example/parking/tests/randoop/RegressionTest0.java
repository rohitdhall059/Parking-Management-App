package com.example.parking.tests.randoop;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

    public static boolean debug = false;

    @Test
    public void test01() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test01");
        java.lang.Object obj0 = new java.lang.Object();
        java.lang.Class<?> wildcardClass1 = obj0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test02() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test02");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        java.lang.String str3 = superManager0.getPassword();
        java.lang.Class<?> wildcardClass4 = superManager0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
// flaky:         org.junit.Assert.assertTrue("'" + str3 + "' != '" + "" + "'", str3.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test03() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test03");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setEmail("");
        java.lang.Class<?> wildcardClass7 = superManager0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test04() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test04");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setPassword("");
        java.lang.Class<?> wildcardClass7 = superManager0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test05() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test05");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setEmail("");
        superManager0.setEmail("");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
    }

    @Test
    public void test06() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test06");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setPassword("");
        superManager0.setEmail("hi!");
        java.lang.Class<?> wildcardClass9 = superManager0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test07() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test07");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setEmail("hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
    }

    @Test
    public void test08() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test08");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setEmail("");
        java.lang.String str7 = superManager0.getPassword();
        superManager0.setEmail("hi!");
        java.lang.Class<?> wildcardClass10 = superManager0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test09() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test09");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        java.lang.Class<?> wildcardClass1 = superManager0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test10() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test10");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        java.lang.String str3 = superManager0.getPassword();
        superManager0.setEmail("hi!");
        superManager0.setEmail("hi!");
        java.lang.String str8 = superManager0.getEmail();
        java.lang.Class<?> wildcardClass9 = superManager0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
// flaky:         org.junit.Assert.assertTrue("'" + str3 + "' != '" + "hi!" + "'", str3.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test11() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test11");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setEmail("");
        java.lang.String str7 = superManager0.getPassword();
        superManager0.setEmail("hi!");
        superManager0.setPassword("");
        superManager0.generateManagementAccount();
        java.lang.Class<?> wildcardClass13 = superManager0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass13);
    }

    @Test
    public void test12() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test12");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setPassword("");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
    }

    @Test
    public void test13() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test13");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setEmail("");
        java.lang.String str7 = superManager0.getPassword();
        superManager0.setPassword("hi!");
        java.lang.Class<?> wildcardClass10 = superManager0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test14() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test14");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setEmail("");
        superManager0.setPassword("hi!");
        superManager0.generateManagementAccount();
        java.lang.String str10 = superManager0.getPassword();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "hi!" + "'", str10.equals("hi!"));
    }

    @Test
    public void test15() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test15");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setEmail("");
        superManager0.setPassword("hi!");
        superManager0.generateManagementAccount();
        superManager0.generateManagementAccount();
        superManager0.setEmail("hi!");
        superManager0.setEmail("");
        java.lang.String str15 = superManager0.getEmail();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str15 + "' != '" + "" + "'", str15.equals(""));
    }

    @Test
    public void test16() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test16");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        java.lang.String str1 = superManager0.getPassword();
        superManager0.setPassword("hi!");
        java.lang.String str4 = superManager0.getEmail();
        java.lang.String str5 = superManager0.getPassword();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str1 + "' != '" + "hi!" + "'", str1.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str4 + "' != '" + "" + "'", str4.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str5 + "' != '" + "hi!" + "'", str5.equals("hi!"));
    }

    @Test
    public void test17() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test17");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setPassword("");
        superManager0.setPassword("hi!");
        superManager0.setPassword("");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
    }

    @Test
    public void test18() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test18");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        java.lang.String str3 = superManager0.getPassword();
        java.lang.String str4 = superManager0.getEmail();
        superManager0.generateManagementAccount();
        java.lang.String str6 = superManager0.getPassword();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "" + "'", str3.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str4 + "' != '" + "" + "'", str4.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "" + "'", str6.equals(""));
    }

    @Test
    public void test19() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test19");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setPassword("");
        superManager0.setEmail("hi!");
        superManager0.setEmail("hi!");
        superManager0.generateManagementAccount();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
    }

    @Test
    public void test20() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test20");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        java.lang.String str1 = superManager0.getPassword();
        superManager0.generateManagementAccount();
        superManager0.generateManagementAccount();
        java.lang.String str4 = superManager0.getEmail();
        java.lang.String str5 = superManager0.getEmail();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str1 + "' != '" + "" + "'", str1.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str4 + "' != '" + "hi!" + "'", str4.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str5 + "' != '" + "hi!" + "'", str5.equals("hi!"));
    }

    @Test
    public void test21() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test21");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        java.lang.String str1 = superManager0.getPassword();
        superManager0.generateManagementAccount();
        superManager0.generateManagementAccount();
        java.lang.String str4 = superManager0.getEmail();
        java.lang.String str5 = superManager0.getPassword();
        superManager0.setPassword("");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
// flaky:         org.junit.Assert.assertTrue("'" + str1 + "' != '" + "hi!" + "'", str1.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
// flaky:         org.junit.Assert.assertTrue("'" + str4 + "' != '" + "" + "'", str4.equals(""));
        // Regression assertion (captures the current behavior of the code)
// flaky:         org.junit.Assert.assertTrue("'" + str5 + "' != '" + "hi!" + "'", str5.equals("hi!"));
    }

    @Test
    public void test22() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test22");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        java.lang.String str3 = superManager0.getPassword();
        java.lang.String str4 = superManager0.getEmail();
        superManager0.generateManagementAccount();
        superManager0.setPassword("");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "" + "'", str3.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str4 + "' != '" + "" + "'", str4.equals(""));
    }

    @Test
    public void test23() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test23");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setPassword("");
        java.lang.String str11 = superManager0.getPassword();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "" + "'", str11.equals(""));
    }

    @Test
    public void test24() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test24");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        java.lang.String str3 = superManager0.getPassword();
        superManager0.generateManagementAccount();
        superManager0.setPassword("hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "" + "'", str3.equals(""));
    }

    @Test
    public void test25() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test25");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        java.lang.String str3 = superManager0.getPassword();
        superManager0.setEmail("hi!");
        superManager0.setEmail("hi!");
        java.lang.String str8 = superManager0.getPassword();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "hi!" + "'", str3.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
    }

    @Test
    public void test26() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test26");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        java.lang.String str1 = superManager0.getPassword();
        java.lang.String str2 = superManager0.getPassword();
        java.lang.String str3 = superManager0.getEmail();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str1 + "' != '" + "hi!" + "'", str1.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str2 + "' != '" + "hi!" + "'", str2.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "hi!" + "'", str3.equals("hi!"));
    }

    @Test
    public void test27() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test27");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.generateManagementAccount();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
    }

    @Test
    public void test28() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test28");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setPassword("");
        java.lang.String str11 = superManager0.getEmail();
        superManager0.generateManagementAccount();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "" + "'", str11.equals(""));
    }

    @Test
    public void test29() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test29");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setEmail("");
        superManager0.setPassword("hi!");
        superManager0.generateManagementAccount();
        superManager0.generateManagementAccount();
        java.lang.String str11 = superManager0.getPassword();
        superManager0.setEmail("");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "hi!" + "'", str11.equals("hi!"));
    }

    @Test
    public void test30() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test30");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        java.lang.String str1 = superManager0.getPassword();
        superManager0.setPassword("hi!");
        superManager0.generateManagementAccount();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str1 + "' != '" + "hi!" + "'", str1.equals("hi!"));
    }

    @Test
    public void test31() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test31");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setPassword("");
        superManager0.setEmail("hi!");
        java.lang.String str9 = superManager0.getEmail();
        java.lang.String str10 = superManager0.getEmail();
        superManager0.generateManagementAccount();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "hi!" + "'", str9.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "hi!" + "'", str10.equals("hi!"));
    }

    @Test
    public void test32() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test32");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setEmail("");
        java.lang.String str7 = superManager0.getPassword();
        superManager0.setEmail("hi!");
        superManager0.setPassword("");
        superManager0.setEmail("");
        java.lang.String str14 = superManager0.getPassword();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str14 + "' != '" + "" + "'", str14.equals(""));
    }

    @Test
    public void test33() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test33");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setPassword("");
        java.lang.String str11 = superManager0.getEmail();
        java.lang.String str12 = superManager0.getPassword();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "" + "'", str11.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
    }

    @Test
    public void test34() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test34");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        java.lang.String str1 = superManager0.getPassword();
        superManager0.generateManagementAccount();
        superManager0.generateManagementAccount();
        java.lang.Class<?> wildcardClass4 = superManager0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str1 + "' != '" + "" + "'", str1.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test35() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test35");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setPassword("");
        java.lang.String str11 = superManager0.getEmail();
        java.lang.Class<?> wildcardClass12 = superManager0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "" + "'", str11.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass12);
    }

    @Test
    public void test36() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test36");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setPassword("");
        superManager0.setEmail("hi!");
        superManager0.setEmail("hi!");
        superManager0.setPassword("hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
    }

    @Test
    public void test37() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test37");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        java.lang.String str1 = superManager0.getPassword();
        superManager0.generateManagementAccount();
        superManager0.setEmail("hi!");
        superManager0.setEmail("");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str1 + "' != '" + "hi!" + "'", str1.equals("hi!"));
    }

    @Test
    public void test38() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test38");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setEmail("");
        java.lang.String str7 = superManager0.getPassword();
        superManager0.setEmail("hi!");
        superManager0.setPassword("");
        superManager0.generateManagementAccount();
        superManager0.setPassword("");
        superManager0.generateManagementAccount();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
    }

    @Test
    public void test39() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test39");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setPassword("");
        superManager0.setPassword("hi!");
        java.lang.Class<?> wildcardClass9 = superManager0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test40() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test40");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        java.lang.String str3 = superManager0.getPassword();
        java.lang.String str4 = superManager0.getEmail();
        java.lang.String str5 = superManager0.getPassword();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
// flaky:         org.junit.Assert.assertTrue("'" + str3 + "' != '" + "" + "'", str3.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str4 + "' != '" + "" + "'", str4.equals(""));
        // Regression assertion (captures the current behavior of the code)
// flaky:         org.junit.Assert.assertTrue("'" + str5 + "' != '" + "" + "'", str5.equals(""));
    }

    @Test
    public void test41() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test41");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setPassword("");
        superManager0.generateManagementAccount();
        java.lang.Class<?> wildcardClass8 = superManager0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test42() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test42");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setPassword("");
        java.lang.String str7 = superManager0.getEmail();
        superManager0.setEmail("");
        superManager0.generateManagementAccount();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
    }

    @Test
    public void test43() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test43");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setEmail("");
        superManager0.setPassword("hi!");
        superManager0.generateManagementAccount();
        superManager0.generateManagementAccount();
        superManager0.setEmail("hi!");
        superManager0.setEmail("");
        java.lang.String str15 = superManager0.getPassword();
        java.lang.String str16 = superManager0.getPassword();
        superManager0.setEmail("hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str15 + "' != '" + "hi!" + "'", str15.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str16 + "' != '" + "hi!" + "'", str16.equals("hi!"));
    }

    @Test
    public void test44() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test44");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setEmail("");
        java.lang.String str7 = superManager0.getPassword();
        superManager0.setEmail("hi!");
        superManager0.setPassword("");
        superManager0.generateManagementAccount();
        superManager0.setPassword("");
        superManager0.setEmail("");
        java.lang.String str17 = superManager0.getPassword();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str17 + "' != '" + "" + "'", str17.equals(""));
    }

    @Test
    public void test45() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test45");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setEmail("");
        superManager0.setPassword("hi!");
        superManager0.generateManagementAccount();
        java.lang.String str10 = superManager0.getEmail();
        superManager0.setEmail("");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "" + "'", str10.equals(""));
    }

    @Test
    public void test46() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test46");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setEmail("");
        superManager0.setPassword("hi!");
        superManager0.generateManagementAccount();
        superManager0.generateManagementAccount();
        superManager0.setEmail("hi!");
        superManager0.setEmail("");
        java.lang.String str15 = superManager0.getPassword();
        java.lang.String str16 = superManager0.getPassword();
        superManager0.generateManagementAccount();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str15 + "' != '" + "hi!" + "'", str15.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str16 + "' != '" + "hi!" + "'", str16.equals("hi!"));
    }

    @Test
    public void test47() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test47");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        superManager0.setPassword("");
        superManager0.setPassword("");
        superManager0.setEmail("hi!");
        superManager0.generateManagementAccount();
        superManager0.setPassword("hi!");
        java.lang.String str12 = superManager0.getPassword();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "hi!" + "'", str12.equals("hi!"));
    }

    @Test
    public void test48() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test48");
        com.example.parking.model.SuperManager superManager0 = com.example.parking.model.SuperManager.getInstance();
        superManager0.setEmail("");
        java.lang.String str3 = superManager0.getPassword();
        superManager0.setEmail("hi!");
        superManager0.setEmail("hi!");
        java.lang.String str8 = superManager0.getEmail();
        superManager0.generateManagementAccount();
        superManager0.setEmail("");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(superManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "hi!" + "'", str3.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
    }
}
