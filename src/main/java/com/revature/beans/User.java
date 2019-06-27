package com.revature.beans;

public abstract class User {
	protected int ID;
	protected String login;
	protected String password;
	protected String firstName;
	protected String lastName;
	
	
	//constructors
	public User() {
		super();
	}


	public User(int iD, String login, String password, String firstName, String lastName) {
		super();
		this.ID = iD;
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
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
		return "User [ID=" + ID + ", login=" + login + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}	
}
