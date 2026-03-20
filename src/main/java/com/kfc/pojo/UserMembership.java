package com.kfc.pojo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "user_membership")
public class UserMembership {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int umId;
	
	@ManyToOne
    @JoinColumn(name = "uId")
    @JsonIgnoreProperties({"userMembershipList", "clientList", "trainer", "paymentList"})
    private Users user;

    @ManyToOne
    @JoinColumn(name = "mId")
    @JsonIgnoreProperties({"userMembershipList", "trainer"})
    private Membership mem;

//    @ManyToOne
//    @JoinColumn(name = "tId")
//    @JsonIgnoreProperties({"userMembershipList", "clientList", "user"})
//    private Trainer trainer;

    @OneToOne(mappedBy = "umem", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"umem", "trainer", "user"})
    private ClientData client;
	
//    @OneToOne(mappedBy = "umem", cascade = CascadeType.ALL)
//	@JsonIgnoreProperties({"umem", "user"}) 
//	private Payment payment;
    
    @NotNull(message = "Start date is required")
	private LocalDate startDate;
    
    @NotNull(message = "End date is required")
    private LocalDate endDate;
    
    @NotBlank(message = "Status is required (e.g., 'ACTIVE', 'EXPIRED')")
	private String status;

	
	
	
//	public Payment getPayment() {
//		return payment;
//	}
//
//
//
//	public void setPayment(Payment payment) {
//		this.payment = payment;
//	}
//	public Trainer getTrainer() {
//		return trainer;
//	}
//
//
//
//	public void setTrainer(Trainer trainer) {
//		this.trainer = trainer;
//	}
    
    
	public int getUmId() {
		return umId;
	}



	public void setUmId(int umId) {
		this.umId = umId;
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

	

	public ClientData getClient() {
		return client;
	}



	public void setClient(ClientData client) {
		this.client = client;
	}


	public UserMembership() {

	}

}
