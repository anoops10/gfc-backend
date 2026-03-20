package com.kfc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.kfc.pojo.ClientData;
@EnableJpaRepositories
public interface ClientRepository extends JpaRepository<ClientData, Integer>{

	Optional<ClientData> findByUser_uId(int uId);
	List<ClientData> findByTrainer_TId(int tId);

}
