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
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "membership")
public class Membership {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mId;
	
	@NotBlank(message = "Membership name is required")
	private String mName;
	
	@NotBlank(message = "Duration is required (e.g., '3 Months')")
	private String duration;
	
	@PositiveOrZero(message = "Price cannot be negative")
	private double price;
	
	@NotBlank(message = "Description cannot be empty")
    @Size(max = 500, message = "Description cannot exceed 500 characters")
	private String description;
	private boolean isActive;

	@OneToMany(mappedBy = "mem", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"mem", "trainer", "user", "client"})
    private List<UserMembership> userMembershipList; 
	
    @OneToMany(mappedBy = "mem", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"mem", "user", "clientList", "userMembershipList"})
    private List<Trainer> trainer;
	
	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	
	
	public List<UserMembership> getUserMembershipList() {
		return userMembershipList;
	}

	public void setUserMembershipList(List<UserMembership> userMembershipList) {
		this.userMembershipList = userMembershipList;
	}

	

	public List<Trainer> getTrainer() {
		return trainer;
	}

	public void setTrainer(List<Trainer> trainer) {
		this.trainer = trainer;
	}

	
	
	public Membership() {
	}

}
