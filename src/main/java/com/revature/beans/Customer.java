package com.revature.beans;

public class Customer extends User{
	
	public Customer() {
		super();
	}

	public Customer(int ID, String login, String password, String firstName, String lastName) {
		this();
		this.ID = ID;
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getCustId() {
		return ID;
	}

	public void setCustId(int ID) {
		this.ID = ID;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Customer [ID=" + ID + ", login=" + login + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}

	
}
