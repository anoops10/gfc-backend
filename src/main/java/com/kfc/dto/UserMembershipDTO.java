package com.kfc.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class UserMembershipDTO {
	
	@Positive(message = "User ID must be a positive number")
	private int uId;
	
	@Positive(message = "Membership ID must be a positive number")
	private int mId;

	@NotNull(message = "Start date is required")
	private LocalDate startDate;

	@NotNull(message = "End date is required")
	private LocalDate endDate;
	
	@NotBlank(message = "Status is required (e.g., 'ACTIVE', 'EXPIRED')")
	private String status;



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
public LocalDate getStartDate() {
	return startDate;
}
public void setStartDate(LocalDate startDate) {
	this.startDate = startDate;
}
public LocalDate getEndDate() {
	return endDate;
}
public void setEndDate(LocalDate endDate) {
	this.endDate = endDate;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public UserMembershipDTO() {}
public UserMembershipDTO(int uId, int mId, LocalDate startDate, LocalDate endDate, String status) {
	super();
	this.uId = uId;
	this.mId = mId;
	this.startDate = startDate;
	this.endDate = endDate;
	this.status = status;
}




}
