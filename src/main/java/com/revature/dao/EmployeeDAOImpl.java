package com.revature.dao;

import com.revature.beans.Employee;
import com.revature.services.ConnectionService;

import java.sql.*;

public class EmployeeDAOImpl implements EmployeeDAO {
    private static ConnectionService cs = ConnectionService.getInstance();
    private Connection connection = cs.getConnection();

    @Override
    public void saveEmployee(Employee e) throws SQLException {
        String sql = "{ call INSERT_EMPLOYEE(?,?,?,?)";
        CallableStatement stmt = connection.prepareCall(sql);
        stmt.setString(1, e.getFirstName());
        stmt.setString(2, e.getLastName());
        stmt.setString(3, e.getUsername());
        stmt.setString(4, e.getPassword());
        stmt.execute();
    }

    @Override
    public Employee getEmployee(String username) throws SQLException {
        String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_USERNAME = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, username);

        ResultSet rs = stmt.executeQuery();
        Employee e = new Employee();
        if (!rs.isBeforeFirst()) {
            return null;
        }
        while (rs.next()) {
            e.setId(rs.getInt("EMPLOYEE_ID"));
            e.setFirstName(rs.getString("EMPLOYEE_FIRST_NAME"));
            e.setLastName(rs.getString("EMPLOYEE_LAST_NAME"));
            e.setUsername(rs.getString("EMPLOYEE_USERNAME"));
            e.setPassword(rs.getString("EMPLOYEE_PASSWORD"));
        }

        return e;
    }
}
