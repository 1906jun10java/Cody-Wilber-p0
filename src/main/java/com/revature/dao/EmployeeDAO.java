package com.revature.dao;

import com.revature.beans.Employee;

import java.sql.SQLException;

public interface EmployeeDAO {
    void saveEmployee(Employee e) throws SQLException;
    Employee getEmployee(String username) throws SQLException;
}
