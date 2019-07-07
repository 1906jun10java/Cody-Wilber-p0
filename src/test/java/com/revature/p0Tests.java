package com.revature;

import com.revature.beans.Customer;
import com.revature.services.CustomerService;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class p0Tests {
    private static Customer customer;
    private static CustomerService customerService;

    @BeforeClass
    public static void beforeClass() {
        customer = new Customer("First", "Last", "testtest", "password");
        customerService = CustomerService.getInstance();
    }

    // Test adding customer to database
    @Test
    public void saveCustomerTest() {
        customerService.saveCustomer(customer);
        Customer c = customerService.getCustomer(customer.getUsername());
        assertEquals(customer.getUsername(), c.getUsername());
    }
    @After
    public void afterSaveCustomerTest() {
        customerService.deleteCustomer(customer.getUsername());
    }
}
