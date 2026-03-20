package com.kfc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.kfc.pojo.Payment;
@EnableJpaRepositories
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    List<Payment> findByUserUIdOrderByCreatedAtDesc(int uId);

}
