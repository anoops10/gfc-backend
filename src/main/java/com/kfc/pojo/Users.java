package com.kfc.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;
//import java.util.List;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users",
uniqueConstraints = @UniqueConstraint(columnNames = "emailId"))
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@NotBlank(message = "Password is required")
	@Size(min = 6, message = "Password must be at least 6 characters long")
	private String password;
	
	@NotBlank(message = "Role is required")
	private String role;
	
	@NotBlank(message = "Gender is required")
	private String gender;
	
	@NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
	private LocalDate dob;
	
	private String imageName;
	
	@Lob
	private byte[] imageData;
	
	@CreationTimestamp 
	@Column(updatable = false)
	private LocalDateTime created_at;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL )
    @JsonIgnoreProperties("user")
    private List<UserMembership> userMembershipList;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
    private Trainer trainer;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL )
    @JsonIgnoreProperties("user")
    private ClientData clientList;
	
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}


	

	public List<UserMembership> getUserMembershipList() {
		return userMembershipList;
	}

	public void setUserMembershipList(List<UserMembership> userMembershipList) {
		this.userMembershipList = userMembershipList;
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

	
	
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

//	public String getImageType() {
//		return imageType;
//	}
//
//	public void setImageType(String imageType) {
//		this.imageType = imageType;
//	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Users() {

	}

}
