package com.kfc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.kfc.pojo.Membership;

@EnableJpaRepositories
public interface MembershipRepository extends JpaRepository<Membership, Integer> {

}
