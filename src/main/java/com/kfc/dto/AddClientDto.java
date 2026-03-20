package com.kfc.dto;

import jakarta.validation.constraints.Positive;

public class AddClientDto {
	
	@Positive(message = "User ID must be a positive number")
	private int user;
//	private int tId;
	@Positive(message = "UserMembership ID must be a positive number")
	private int umem;
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public int getUmem() {
		return umem;
	}
	public void setUmem(int umem) {
		this.umem = umem;
	}
	public AddClientDto(int user, int umem) {
		super();
		this.user = user;
		this.umem = umem;
	}
	public AddClientDto() {
		super();
	}

	
	
	
}
