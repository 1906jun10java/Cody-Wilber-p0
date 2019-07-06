package com.revature.services;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAOImpl;

import java.sql.SQLException;

public class EmployeeService {
	private static EmployeeService instance;
	private static Employee currentEmployee;

	private EmployeeService() {}
	
	// Return singleton instance
	public static synchronized EmployeeService getInstance() {
		if (instance == null) {
			instance = new EmployeeService();
		}
		return instance;
	}
	
	// Set current employee
	public void setCurrentEmployee(Employee e) {
		currentEmployee = e;
	}
	
	// Get current employee
	public Employee getCurrentEmployee() {
		return currentEmployee;
	}
	
	// Save employee to employees
	public void saveEmployee(Employee e) {
		EmployeeDAOImpl edi = new EmployeeDAOImpl();
		try {
			edi.saveEmployee(e);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	// Get employee from employees
	public Employee getEmployee(String username) {
		EmployeeDAOImpl edi = new EmployeeDAOImpl();
		try {
			return edi.getEmployee(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
