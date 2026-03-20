package com.kfc.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "clientdata")
public class ClientData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clientId;
	
	@OneToOne
	@JoinColumn(name = "uId")
	@JsonIgnoreProperties({"clientList", "userMembershipList", "trainer", "paymentList"})
	private Users user;
	
	@ManyToOne
	@JoinColumn(name = "tId")
	@JsonIgnoreProperties({"clientList", "userMembershipList", "user"})
	private Trainer trainer;
	
	
	@OneToOne
	@JoinColumn(name = "umId")
	@JsonIgnoreProperties({"client", "trainer", "user", "payment"})
	private UserMembership umem;
	
	@PositiveOrZero(message = "Height must be a positive number")
	private int height;
	
	@PositiveOrZero(message = "Weight must be a positive number")
	private int weight;
	
	@PositiveOrZero(message = "Age must be a positive number")
	private int age;
	
	private String schedule;
	
	
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	public UserMembership getUmem() {
		return umem;
	}
	public void setUmem(UserMembership umem) {
		this.umem = umem;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public ClientData() {
		super();
	}
	
	
	
	
	

}
