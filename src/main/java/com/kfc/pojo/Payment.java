package com.kfc.pojo;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "payments")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	
//	@OneToOne
//	@JoinColumn(name = "umId")
//	@JsonIgnoreProperties({"payment", "user", "mem", "trainer", "client"})
//	private UserMembership umem;
//	
	@ManyToOne
    @JoinColumn(name = "uId")
    @JsonIgnoreProperties({"paymentList", "clientList", "userMembershipList", "trainer"})
    private Users user;
	
	@Positive(message = "Payment amount must be greater than zero")
	private double amount;
	
	@NotBlank(message = "Payment description is required")
	private String description;
	
	@CreationTimestamp 
	@Column(updatable = false)
	private LocalDateTime createdAt;
	
	
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
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
	
	
	
//	public UserMembership getUmem() {
//		return umem;
//	}
//	public void setUmem(UserMembership umem) {
//		this.umem = umem;
//	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public Payment() {
		super();
	}
	
	
}
