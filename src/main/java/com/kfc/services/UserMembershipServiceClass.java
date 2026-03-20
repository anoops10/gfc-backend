package com.kfc.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfc.dto.UserMembershipDTO;
import com.kfc.pojo.Membership;
import com.kfc.pojo.UserMembership;
import com.kfc.pojo.Users;
import com.kfc.repository.UserMembershipRepository;

@Service
public class UserMembershipServiceClass implements UserMembershipServiceDao {

	private UserMembershipRepository umRepo;
	private UserServicesClass uservice;
	private MembershipServicesClass mservice;
	private TrainerServiceClass tservice;
	
	
	public UserMembershipServiceClass(UserMembershipRepository umRepo, UserServicesClass uservice,
			MembershipServicesClass mservice, TrainerServiceClass tservice) {
		super();
		this.umRepo = umRepo;
		this.uservice = uservice;
		this.mservice = mservice;
		this.tservice = tservice;
	}



	@Override
	public UserMembership addUserMembership(int uId, int mId, LocalDate startDate, LocalDate endDate, String status) {
		Users user = uservice.getUserById(uId);
		Membership mem = mservice.findMembershipById(mId);
		UserMembership umCart = new UserMembership();
		umCart.setMem(mem);
		umCart.setUser(user);
		umCart.setStartDate(startDate);
		umCart.setEndDate(endDate);
		umCart.setStatus(status);
		
		return umRepo.save(umCart);
	}



	@Override
	public UserMembership GetListByUMID(int umId) {
		Optional<UserMembership> optUm = umRepo.findById(umId);
		if(optUm.isPresent()) {
		return optUm.get();
		}
		throw new RuntimeException("UserMembership not found");
//		return umRepo.findById(umId).get();
	}

	@Override
	public List<UserMembership> GetAllList() {
		// TODO Auto-generated method stub
		return umRepo.findAll();
	}

//	@Override
//	public UserMembership updateUserMembership(int umId,int tId, UserMembership newMem) {
//		UserMembership um = umRepo.findById(umId).get();		
//		um.setStartDate(newMem.getStartDate());
//		um.setEndDate(newMem.getEndDate());
////		um.setTrainer(tservice.getTrainerById(tId));
//		um.setStatus(newMem.getStatus());
//		return umRepo.save(um);
//	}

	@Override
	public String deleteMembershipByUMID(int umId) {
		umRepo.deleteById(umId);
		return "umId: "+umId+" Deleted";
	}

	@Override
	public List<UserMembership> GetListByUID(int uId) {
		// TODO Auto-generated method stub
		return  umRepo.findByUserUId(uId);
		
	}



	@Override
	public long countActiveMembers() {
		// TODO Auto-generated method stub
		return umRepo.countActiveMemberships();
	}



	@Override
	public List<UserMembership> activeMembersList() {
		// TODO Auto-generated method stub
		return umRepo.findAllActiveMemberships();
	}

}
