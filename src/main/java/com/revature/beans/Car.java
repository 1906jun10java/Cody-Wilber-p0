package com.revature.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Random;

public class Car implements Serializable {
	private static final long serialVersionUID = -7673955958198441523L;
	
	private Integer id;
	private Integer year;
	private String make;
	private String model;
	private Integer mileage;
	private BigDecimal price;
	private BigDecimal balance;
	private Integer ownerId;

	public Car() {}
	
	public Car(Integer year, String make, String model, Integer mileage,
	BigDecimal price) {
		// Generate a random id
		Random r = new Random();
		this.id = 100000000 + r.nextInt(900000000);
		
		this.year = year;
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.price = price;
		this.balance = price;
		this.ownerId = null;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getMileage() {
		return mileage;
	}
	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
}
