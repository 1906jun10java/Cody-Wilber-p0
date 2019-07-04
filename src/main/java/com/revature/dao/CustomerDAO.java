package com.revature.dao;

import com.revature.beans.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO {
    void saveCustomer(Customer c) throws SQLException;
    Customer getCustomer(String username) throws SQLException;
}
