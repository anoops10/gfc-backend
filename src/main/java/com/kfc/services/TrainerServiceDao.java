package com.kfc.services;

import java.util.List;
import java.util.Optional;

import com.kfc.dto.TrainerDTO;
import com.kfc.pojo.Trainer;

public interface TrainerServiceDao {
	Trainer addTrainer(int uId, int mId, int expYears, String bio);
//	Trainer updateTrainer(int tId, Trainer trainer);
	List<Trainer> trainerList();
	Trainer getTrainerById(int tId);
	Trainer getTrainerByuId(int uId);
	String deleteTrainer(int tId);
	List<Trainer> getTrainerByMId(int mId);
}
