package com.revature.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Random;

public class Payment implements Serializable {
	private static final long serialVersionUID = -7643579498975426961L;
	
	private Integer id;
	private BigDecimal amount;
	private Integer customerId;
	private Integer carId;
	
	public Payment(BigDecimal amount, Integer customerId, Integer carId) {
		// Generate a random id
		Random r = new Random();
		this.id = 100000000 + r.nextInt(900000000);

		this.amount = amount;
		this.customerId = customerId;
		this.carId = carId;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getCarId() {
		return carId;
	}
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
