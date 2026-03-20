package com.kfc.services;

import java.util.List;

import com.kfc.dto.PaymentDTO;
import com.kfc.pojo.Payment;

public interface PaymentServiceDao {
	Payment addPaymentData(PaymentDTO payment);
	List<Payment> findAllPayments();
	List<Payment> findPaymentByUserId(int uId);
}
