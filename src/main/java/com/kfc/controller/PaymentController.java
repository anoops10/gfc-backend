package com.kfc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kfc.dto.PaymentDTO;
import com.kfc.pojo.Payment;
import com.kfc.services.PaymentServiceClass;

import jakarta.validation.Valid;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/payment")
public class PaymentController {

//	@Autowired
	private PaymentServiceClass service;
	
	
	
	public PaymentController(PaymentServiceClass service) {
	super();
	this.service = service;
}

	@PostMapping("/add")
	public Payment addPaymentData(@Valid @RequestBody PaymentDTO payment) {
		return service.addPaymentData(payment);
	}
	
	@GetMapping("/findall")
	public List<Payment> findAllPayments(){
		return service.findAllPayments();
	}
	
	@GetMapping("/findbyid/{uId}")
	public List<Payment> findPaymentByUserId(@PathVariable int uId){
		return service.findPaymentByUserId(uId);}
	
}
