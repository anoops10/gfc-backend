package com.kfc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kfc.dto.TrainerDTO;
import com.kfc.pojo.Trainer;
import com.kfc.services.TrainerServiceClass;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/trainer")
public class TrainerController {
	
//	@Autowired
	private TrainerServiceClass service;

	
	
	public TrainerController(TrainerServiceClass service) {
	super();
	this.service = service;
}

	@PostMapping("/add")
	public Trainer addTrainer(@Valid @RequestBody TrainerDTO DTO) {
		return service.addTrainer(
				DTO.getuId(),
				DTO.getmId(),
				DTO.getExpYears(),
				DTO.getBio());
	}
	
	@GetMapping("/findbyuserid/{uId}")
	public Trainer getTrainer(@PathVariable int uId) {
		return service.getTrainerByuId(uId);
	}
	
	@GetMapping("/findbymemid/{mId}")
	public List<Trainer> getTrainerByMId(@PathVariable int mId) {
		return service.getTrainerByMId(mId);
	}
	
	@GetMapping("/findbyid/{tId}")
	public Trainer getTrainerById(@PathVariable int tId) {
		return service.getTrainerById(tId);
	}
	
	@GetMapping("/getall")
	public List<Trainer> getTrainerList(){
		return service.trainerList();
	}
	
	@DeleteMapping("/delete/{tId}")
	public String deleteTrainer(@PathVariable int tId) {
		return service.deleteTrainer(tId);
	}
	
}
