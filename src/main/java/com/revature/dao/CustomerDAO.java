package com.revature.dao;

import com.revature.beans.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO {
    void addCustomer(Customer c) throws SQLException;
    ArrayList<Customer> getCustomers() throws SQLException;
}
