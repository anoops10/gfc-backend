package com.kfc.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.kfc.dto.UserMembershipDTO;
import com.kfc.pojo.UserMembership;
import com.kfc.services.UserMembershipServiceClass;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/usermembership")
public class UserMembershipController {
	
//	@Autowired
	private UserMembershipServiceClass umservice;
	
	
	
	public UserMembershipController(UserMembershipServiceClass umservice) {
	super();
	this.umservice = umservice;
}

	@PostMapping("/add")
	public UserMembership addUserMembership(@RequestBody UserMembershipDTO DTO) {
		return umservice.addUserMembership(
				DTO.getuId(), 
				DTO.getmId(), 
				DTO.getStartDate(), 
				DTO.getEndDate(), 
				DTO.getStatus());
	}
	
	@GetMapping("/showall")
	public List<UserMembership> showAllUserMembership(){
	return umservice.GetAllList();	
	}
	
	@GetMapping("/show/{uId}")
	public List<UserMembership> getListByUID(@PathVariable int uId) {
		return umservice.GetListByUID(uId);
	}
	
	@GetMapping("/showbyumid/{umId}")
	public UserMembership getListByUmID(@PathVariable int umId) {
		return umservice.GetListByUMID(umId);
	}
	
	@DeleteMapping("/delete/{umId}")
	public String deleteUserMembership(@PathVariable int umId) {
		return umservice.deleteMembershipByUMID(umId);
	}
	
//	@PutMapping("/update/{umId}/{tId}")
//	public UserMembership updateUserMembership(@PathVariable int umId,@PathVariable int tId, @RequestBody UserMembership newUm) {
//		return umservice.updateUserMembership(umId,tId, newUm);
//	}
	
	@GetMapping("/activecount")
	public long getActiveCount() {
		return umservice.countActiveMembers();
	}
	
	@GetMapping("/activelist")
	public List<UserMembership> getActiveList() {
		return umservice.activeMembersList();
	}
//	@GetMapping("/test-put")  // Change to GET temporarily
//	public String test() { return "PUT works"; }
}
