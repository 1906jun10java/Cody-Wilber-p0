package com.revature.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Random;

public class Offer implements Serializable {
	private static final long serialVersionUID = -3839087744440848572L;
	
	private Integer id;
	private Integer carId;
	private Integer customerId;
	private BigDecimal amount;
	private String status;
	
	public Offer(Integer carId, Integer customerId, BigDecimal amount) {
		// Generate a random id
		Random r = new Random();
		this.id = 100000000 + r.nextInt(900000000);
		
		this.carId = carId;
		this.customerId = customerId;
		this.amount = amount;
		this.status = "Open";
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCarId() {
		return carId;
	}
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
