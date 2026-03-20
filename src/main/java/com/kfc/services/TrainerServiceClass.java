package com.kfc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.kfc.dto.TrainerDTO;
import com.kfc.pojo.Membership;
import com.kfc.pojo.Trainer;
import com.kfc.pojo.Users;
import com.kfc.repository.TrainerRepository;
@Service
public class TrainerServiceClass implements TrainerServiceDao {

	private TrainerRepository repo;
	private UserServicesClass uservice;
	private MembershipServicesClass mservice;
	
	public TrainerServiceClass(TrainerRepository repo, UserServicesClass uservice, MembershipServicesClass mservice) {
		super();
		this.repo = repo;
		this.uservice = uservice;
		this.mservice = mservice;
	}



	@Override
	public Trainer addTrainer(int uId, int mId, int expYears, String bio) {
		Users user =  uservice.getUserById(uId);
		Membership mem = mservice.findMembershipById(mId);
		Trainer t = new Trainer();
		t.setUser(user);
		t.setMem(mem);
		t.setBio(bio);
		t.setExpYears(expYears);
		return repo.save(t);
	}



	@Override
	public List<Trainer> trainerList() {
		return repo.findAll();
	}


	@Override
	public String deleteTrainer(int tId) {
		repo.deleteById(tId);
		return "Trainer deleted with tId: "+tId;
	}

	@Override
	public Trainer getTrainerByuId(int uId) {
		return repo.findByUser_UId(uId).orElse(null);
//				.orElseThrow(() -> new RuntimeException("Trainer with User ID " + uId + " not found"));
	}
	


	@Override
	public List<Trainer> getTrainerByMId(int mId) {
		return repo.findByMem_MId(mId);
	}



	@Override
	public Trainer getTrainerById(int tId) {
		// TODO Auto-generated method stub
		return repo.findById(tId).orElse(null);
	}

}
