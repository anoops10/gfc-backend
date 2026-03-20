 package com.kfc.pojo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Trainer")
public class Trainer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int tId;
	
	@OneToOne
	@JoinColumn(name = "uId")
	@JsonIgnoreProperties({"trainer", "clientList", "userMembershipList", "paymentList"})
	private Users user;
	
	@ManyToOne
	@JoinColumn(name = "mId")
	@JsonIgnoreProperties({"trainer", "userMembershipList"})
	private Membership mem;
	
//	@OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL)
//	@JsonIgnoreProperties({"trainer", "client"})
//	private List<UserMembership> userMembershipList; 
//	

	@OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"trainer", "umem"})
	private List<ClientData> clientList; 
	
	@PositiveOrZero(message = "Years of experience cannot be negative")
	private int expYears;
	
	@NotBlank(message = "Bio cannot be empty")
    @Size(max = 1000, message = "Bio cannot exceed 1000 characters")
	private String bio;
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}


	public Membership getMem() {
		return mem;
	}
	public void setMem(Membership mem) {
		this.mem = mem;
	}
	
//	public List<UserMembership> getUserMembershipList() {
//		return userMembershipList;
//	}
//	public void setUserMembershipList(List<UserMembership> userMembershipList) {
//		this.userMembershipList = userMembershipList;
//	}
	
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
	
	
	
	public List<ClientData> getClientList() {
		return clientList;
	}
	public void setClientList(List<ClientData> clientList) {
		this.clientList = clientList;
	}
	public Trainer() {
	}
	
	
	
}
