package com.tsi.kirk.mcallister.microdemo.unit.business;

import com.tsi.kirk.mcallister.microdemo.business.Payment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentTest {

    Payment testPayment;

    @BeforeEach
    public void setUp() {
        testPayment = new Payment(250, 250, new BigDecimal(5), LocalDateTime.now());
    }

    @Test
    public void testGetSetPaymentId() {
        int expected = 500;

        testPayment.setPaymentId(expected);
        int actual = testPayment.getPaymentId();

        Assertions.assertEquals(expected, actual, "Payment ID is wrong");
    }

    @Test
    public void testGetSetCustomerId() {
        int expected = 500;

        testPayment.setCustomerId(expected);
        int actual = testPayment.getCustomerId();

        Assertions.assertEquals(expected, actual, "Customer ID is wrong");
    }

    @Test
    public void testGetSetStaffId() {
        int expected = 500;

        testPayment.setStaffId(expected);
        int actual = testPayment.getStaffId();

        Assertions.assertEquals(expected, actual, "Staff ID is wrong");
    }

    @Test
    public void testGetSetRentalId() {
        int expected = 500;

        testPayment.setRentalId(expected);
        int actual = testPayment.getRentalId();

        Assertions.assertEquals(expected, actual, "Rental ID is wrong");
    }

    @Test
    public void testGetSetAmount() {
        BigDecimal expected = new BigDecimal(500);

        testPayment.setAmount(expected);
        BigDecimal actual = testPayment.getAmount();

        Assertions.assertEquals(expected, actual, "Amount is wrong");
    }

    @Test
    public void testGetSetPaymentDate() {
        LocalDateTime expected = LocalDateTime.now();

        testPayment.setPaymentDate(expected);
        LocalDateTime actual = testPayment.getPaymentDate();

        Assertions.assertEquals(expected, actual, "Payment Date is wrong");
    }
}
