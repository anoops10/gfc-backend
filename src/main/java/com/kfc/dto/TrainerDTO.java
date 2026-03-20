package com.kfc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class TrainerDTO {
	
	@Positive(message = "User ID must be a positive number")
	private int uId;

	@Positive(message = "Membership ID must be a positive number")
	private int mId;
	
	@PositiveOrZero(message = "Years of experience cannot be negative")
	private int expYears;

	@NotBlank(message = "Bio cannot be empty")
    @Size(max = 1000, message = "Bio cannot exceed 1000 characters")
	private String bio;
	
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public int getExpYears() {
		return expYears;
	}
	public void setExpYears(int expYears) {
		this.expYears = expYears;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public TrainerDTO( int uId, int mId, int expYears, String bio) {
		this.uId = uId;
		this.mId = mId;
		this.expYears = expYears;
		this.bio = bio;
	}
	public TrainerDTO() {
		super();
	}
	
	
}
