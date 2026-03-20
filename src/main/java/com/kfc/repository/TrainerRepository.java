package com.kfc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.kfc.pojo.Trainer;

@EnableJpaRepositories
public interface TrainerRepository extends JpaRepository<Trainer, Integer> {

    Optional<Trainer> findByUser_UId(int uId);
    List<Trainer> findByMem_MId(int mId);

//    Optional<Trainer> findByUId(int uId);

}
