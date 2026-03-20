package com.kfc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kfc.dto.PaymentDTO;
import com.kfc.pojo.Payment;
import com.kfc.pojo.UserMembership;
import com.kfc.pojo.Users;
import com.kfc.repository.PaymentRepository;

@Service
public class PaymentServiceClass implements PaymentServiceDao {

	private PaymentRepository repo;
	private UserServicesClass uService;

	public PaymentServiceClass(PaymentRepository repo, UserServicesClass uService) {
		super();
		this.repo = repo;
		this.uService = uService;
	}

	@Override
	public Payment addPaymentData(PaymentDTO dto) {
		Users user = uService.getUserById(dto.getUser());
		Payment pay = new Payment();
		pay.setAmount(dto.getAmount());
		pay.setDescription(dto.getDescription());
		pay.setUser(user);
			
		return repo.save(pay);
	}

	@Override
	public List<Payment> findAllPayments() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Payment> findPaymentByUserId(int uId) {
		// TODO Auto-generated method stub
		return repo.findByUserUIdOrderByCreatedAtDesc(uId);
	}

}
