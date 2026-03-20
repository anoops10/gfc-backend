package com.kfc.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kfc.pojo.ClientData;
import com.kfc.pojo.Payment;
import com.kfc.pojo.Trainer;
import com.kfc.pojo.UserMembership;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDataDTO {
	private int uId;
	
	@NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
	private String uName;
	
	@NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email format")
	private String emailId;
	
	@NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number must be valid and contain 10 to 15 digits")
	private String phone;
	
	@NotBlank(message = "Address cannot be empty")
	private String address;
	
	@NotBlank(message = "Role is required")
	private String role;
	
	@NotBlank(message = "Gender is required")
	private String gender;
	
	@NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
	private LocalDate dob;
	
	private String imageName;
	
	private byte[] imageData;
	
	private LocalDateTime created_at;
	
    private List<UserMembership> userMembershipList;

    private Trainer trainer;

    private ClientData clientList;
	
    private List<Payment> paymentList;

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public List<UserMembership> getUserMembershipList() {
		return userMembershipList;
	}

	public void setUserMembershipList(List<UserMembership> userMembershipList) {
		this.userMembershipList = userMembershipList;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public ClientData getClientList() {
		return clientList;
	}

	public void setClientList(ClientData clientList) {
		this.clientList = clientList;
	}

	public List<Payment> getPaymentList() {
		return paymentList;
	}

	public void setPaymentList(List<Payment> paymentList) {
		this.paymentList = paymentList;
	}

		
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public UserDataDTO(int uId, String uName, String emailId, String phone, String address, String role, String gender,
			LocalDate dob, String imageName, byte[] imageData, LocalDateTime created_at,
			List<UserMembership> userMembershipList, Trainer trainer, ClientData clientList,
			List<Payment> paymentList) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.emailId = emailId;
		this.phone = phone;
		this.address = address;
		this.role = role;
		this.gender = gender;
		this.dob = dob;
		this.imageName = imageName;
		this.imageData = imageData;
		this.created_at = created_at;
		this.userMembershipList = userMembershipList;
		this.trainer = trainer;
		this.clientList = clientList;
		this.paymentList = paymentList;
	}

	public UserDataDTO() {
		super();
	}
    
    
	
}
