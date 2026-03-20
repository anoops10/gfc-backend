package com.kfc.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kfc.pojo.Membership;
import com.kfc.services.MembershipServicesClass;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/membership")
public class MembershipController {

//	@Autowired
	private MembershipServicesClass service;
	
	
	public MembershipController(MembershipServicesClass service) {
	super();
	this.service = service;
}

	@PostMapping("/add")
	public Membership addMembership(@Valid @RequestBody Membership mem) {
		return service.addMembership(mem);
	}
	
	@GetMapping("/showall")
	public List<Membership> showAllMembership() {
		return service.showAllMembership();
	}
	
	@GetMapping("/showmembership/{mId}")
	public Membership getMembershipById(@PathVariable int mId) {
		return service.findMembershipById(mId);
	}
	
	@PutMapping("/update/{mId}")
	public Membership updateMembership(@PathVariable int mId,@Valid @RequestBody Membership mem) {
		return service.updateMembership(mId, mem);
	}
	
	@DeleteMapping("/delete/{mId}")
	public String deleteMembership(@PathVariable int mId) {
		return service.deleteMembership(mId);
	}
}
