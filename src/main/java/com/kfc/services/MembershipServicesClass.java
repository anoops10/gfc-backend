package com.kfc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfc.pojo.Membership;
import com.kfc.repository.MembershipRepository;

@Service
public class MembershipServicesClass implements MembershipServicesDao {

	private MembershipRepository memRepo;
	
	public MembershipServicesClass(MembershipRepository memRepo) {
		super();
		this.memRepo = memRepo;
	}

	@Override
	public Membership addMembership(Membership mem) {
		// TODO Auto-generated method stub
		return memRepo.save(mem);
	}

	@Override
	public List<Membership> showAllMembership() {
		// TODO Auto-generated method stub
		return memRepo.findAll();
	}

	@Override
	public Membership findMembershipById(int mId) {
		return memRepo.findById(mId)
				.orElseThrow(()-> new RuntimeException("membersship Id "+mId+" not present"));
	}

	@Override
	public Membership updateMembership(int mId, Membership newMem) {
		// TODO Auto-generated method stub
		Membership mem = memRepo.findById(mId).get();
		if(mem!=null) {
			mem.setmName(newMem.getmName());
			mem.setDuration(newMem.getDuration());
			mem.setActive(newMem.isActive());
			mem.setPrice(newMem.getPrice());
			mem.setDescription(newMem.getDescription());
			return memRepo.save(mem);
		}
		return null;
	}

	@Override
	public String deleteMembership(int mId) {
		// TODO Auto-generated method stub
		memRepo.deleteById(mId);
		return "deleted membership:"+mId;
	}

}
