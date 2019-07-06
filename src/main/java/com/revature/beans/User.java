package com.revature.beans;

import java.io.Serializable;
import java.util.Random;

public abstract class User implements Serializable {
	private static final long serialVersionUID = -2148285443476630628L;
	
	private Integer id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;

	public User() {}
	
	public User(String fn, String ln, String un, String pw) {
		this.firstName = fn;
		this.lastName = ln;
		this.username = un;
		this.password = pw;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
