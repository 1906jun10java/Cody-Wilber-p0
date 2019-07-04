package com.revature.dao;

import com.revature.beans.Customer;
import com.revature.services.ConnectionService;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    private static ConnectionService cs = ConnectionService.getInstance();
    private Connection connection = cs.getConnection();

    @Override
    public void addCustomer(Customer c) throws SQLException {
        String sql = "{ call INSERT_CUSTOMER(?,?,?,?)";
        CallableStatement stmt = connection.prepareCall(sql);
        stmt.setString(1, c.getFirstName());
        stmt.setString(2, c.getLastName());
        stmt.setString(3, c.getUsername());
        stmt.setString(4, c.getPassword());
        stmt.execute();
    }

    @Override
    public ArrayList<Customer> getCustomers() throws SQLException {
        String sql = "SELECT * FROM CUSTOMER";
        Statement stmt = connection.createStatement();

        ArrayList<Customer> al = new ArrayList<Customer>();
        ResultSet rs = stmt.executeQuery(sql);
        if (!rs.isBeforeFirst()) {
            return null;
        }
        while (rs.next()) {
            Customer c = new Customer(
                    rs.getString("CUSTOMER_FIRST_NAME"),
                    rs.getString("CUSTOMER_LAST_NAME"),
                    rs.getString("CUSTOMER_USERNAME"),
                    rs.getString("CUSTOMER_PASSWORD")
            );
            c.setId(rs.getInt("CUSTOMER_ID"));
            al.add(c);
        }

        return al;
    }
}
