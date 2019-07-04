package com.revature.dao;

import com.revature.beans.Customer;
import com.revature.services.ConnectionService;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    private static ConnectionService cs = ConnectionService.getInstance();
    private Connection connection = cs.getConnection();

    @Override
    public void saveCustomer(Customer c) throws SQLException {
        String sql = "{ call INSERT_CUSTOMER(?,?,?,?)";
        CallableStatement stmt = connection.prepareCall(sql);
        stmt.setString(1, c.getFirstName());
        stmt.setString(2, c.getLastName());
        stmt.setString(3, c.getUsername());
        stmt.setString(4, c.getPassword());
        stmt.execute();
    }

    @Override
    public Customer getCustomer(String username) throws SQLException {
        String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMER_USERNAME = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, username);

        ResultSet rs = stmt.executeQuery();
        Customer c = new Customer();
        if (!rs.isBeforeFirst()) {
            return null;
        }
        while (rs.next()) {
            c.setId(rs.getInt("CUSTOMER_ID"));
            c.setFirstName(rs.getString("CUSTOMER_FIRST_NAME"));
            c.setLastName(rs.getString("CUSTOMER_LAST_NAME"));
            c.setUsername(rs.getString("CUSTOMER_USERNAME"));
            c.setPassword(rs.getString("CUSTOMER_PASSWORD"));
        }

        return c;
    }
}
