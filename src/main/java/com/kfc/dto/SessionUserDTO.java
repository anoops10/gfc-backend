package com.kfc.dto;

public class SessionUserDTO {

	private int uId;
	private String emailId;
	private String role;
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public SessionUserDTO(int uId, String emailId, String role) {
		super();
		this.uId = uId;
		this.emailId = emailId;
		this.role = role;
	}
	public SessionUserDTO() {
		super();
	}
	
	
	
}
