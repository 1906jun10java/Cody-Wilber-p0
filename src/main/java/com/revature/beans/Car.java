package com.revature.beans;

public class Car {
	private int year;
	private String make;
	private String model;
	private int currentMiles;
	private double price;
	
	public Car() {
		super();
	}

	public Car(int year, String make, String model, int currentMiles, double price) {
		super();
		this.year = year;
		this.make = make;
		this.model = model;
		this.currentMiles = currentMiles;
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
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

	public int getCurrentMiles() {
		return currentMiles;
	}

	public void setCurrentMiles(int currentMiles) {
		this.currentMiles = currentMiles;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [year=" + year + ", make=" + make + ", model=" + model + ", currentMiles=" + currentMiles
				+ ", price=" + price + "]";
	}
}
