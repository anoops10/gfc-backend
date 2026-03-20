package com.kfc.dto;
import com.kfc.pojo.UserMembership;
import com.kfc.pojo.Users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


public class PaymentDTO {
    
	@Positive(message = "User ID must be a positive number")
    private int user;
	
	@Positive(message = "Payment amount must be greater than zero")
	private double amount;
	
	@NotBlank(message = "Payment description cannot be empty")
	private String description;

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}


	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PaymentDTO(int user, double amount, String description) {
		super();
		this.user = user;
		this.amount = amount;
		this.description = description;
	}

	public PaymentDTO() {
		super();
	}
	
	
	
}
