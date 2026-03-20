package com.kfc.dto;

public class LoginResponseDTO {
	private String emailId;
	private String role;
	private boolean logedin;
	
	
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
	public boolean isLogedin() {
		return logedin;
	}
	public void setLogedin(boolean logedin) {
		this.logedin = logedin;
	}
	public LoginResponseDTO(String emailId, String role, boolean logedin) {
		super();
		this.emailId = emailId;
		this.role = role;
		this.logedin = logedin;
	}
	public LoginResponseDTO() {
		super();
	}
	
}
