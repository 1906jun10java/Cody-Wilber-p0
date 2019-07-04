package com.revature.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.revature.beans.Employee;

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
	
	// Load employees
	@SuppressWarnings("unchecked")
	public void loadEmployees() {
		try {
			FileInputStream fis = new FileInputStream("Employees.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			employees = (ArrayList<Employee>)ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
	// Save employees
	public void saveEmployees() {
		try {
			FileOutputStream fos = new FileOutputStream("Employees.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(employees);
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	public void saveEmployee(Employee c) {
		employees.add(c);
		saveEmployees();
	}
	
	// Get employee from employees
	public Employee getEmployee(String username) {
		for (Employee e : employees) {
			if (e.getUsername().equals(username)) {
				return e;
			}
		}
		return null;
	}
}
