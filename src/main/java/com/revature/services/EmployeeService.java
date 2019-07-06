package com.revature.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAOImpl;

public class EmployeeService {
	private static EmployeeService instance;
	private static Employee currentEmployee;
	private static ArrayList<Employee> employees = new ArrayList<Employee>();
	
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

	// Get all employees
	public ArrayList<Employee> getEmployees() {
		return employees;
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
