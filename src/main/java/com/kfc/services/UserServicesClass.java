package com.kfc.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kfc.dto.UserDataDTO;
import com.kfc.pojo.Users;
import com.kfc.repository.UserRepository;

@Service
public class UserServicesClass implements UserServicesDao {

//	@Autowired
	private UserRepository userRepo;
	
	
	
	public UserServicesClass(UserRepository userRepo) {
	super();
	this.userRepo = userRepo;
}

	@Override
	public Users addUser(Users user, MultipartFile file) {
		// TODO Auto-generated method stub
		try {
			user.setImageName(file.getOriginalFilename());
//			user.setImageType(file.getContentType());
			user.setImageData(file.getBytes());
			return userRepo.save(user);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return userRepo.save(user);
	}

	@Override
	public List<Users> showAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public Users getUserById(int uId) {
		// TODO Auto-generated method stub
//		return userRepo.findById(uId).get();
		Optional<Users> userOpt = userRepo.findById(uId);
		if(userOpt.isPresent()){
			return userOpt.get();
		}
		throw new RuntimeException("User Id "+uId+" not found");
	}

	@Override
	public Users updateUser(String emailId, UserDataDTO dto) {
		Users user = userRepo.findByEmailId(emailId).orElse(null);
		if(user!=null) {
			user.setuName(dto.getuName());
			user.setPhone(dto.getPhone());
			user.setAddress(dto.getAddress());
			return userRepo.save(user);
		}
		return null;
	}

	@Override
	public String deleteUser(int uId) {
		// TODO Auto-generated method stub
		userRepo.deleteById(uId);
		return "deleted user Id: "+ uId;
	}

	@Override
	public UserDataDTO getUserByEmailId(String emailId) {
		    Users user = userRepo.findByEmailId(emailId)
		               	.orElse(null);
		    UserDataDTO userData = new UserDataDTO();
		    userData.setuName(user.getuName());
		    userData.setEmailId(user.getEmailId());
		    userData.setClientList(user.getClientList());
		    userData.setDob(user.getDob());
		    userData.setCreated_at(user.getCreated_at());
		    userData.setGender(user.getGender());
		    userData.setImageData(user.getImageData());
		    userData.setImageName(user.getImageName());
		    userData.setPaymentList(user.getPaymentList());
		    userData.setPhone(user.getPhone());
		    userData.setRole(user.getRole());
		    userData.setTrainer(user.getTrainer());
		    userData.setuId(user.getuId());
		    userData.setUserMembershipList(user.getUserMembershipList());
		    userData.setAddress(user.getAddress());
		    
		    return userData;
	}

	@Override
	public List<UserDataDTO> getAllUsers() {
	    List<Users> usersList = userRepo.findAll();
	    
	    List<UserDataDTO> dtoList = new ArrayList<>();
	    
	    for (Users user : usersList) {
	        UserDataDTO userData = new UserDataDTO();
	        userData.setuName(user.getuName());
	        userData.setEmailId(user.getEmailId());
	        userData.setClientList(user.getClientList());
	        userData.setDob(user.getDob());
	        userData.setCreated_at(user.getCreated_at());
	        userData.setGender(user.getGender());
	        userData.setImageData(user.getImageData());
	        userData.setImageName(user.getImageName());
	        userData.setPaymentList(user.getPaymentList());
	        userData.setPhone(user.getPhone());
	        userData.setRole(user.getRole());
	        userData.setTrainer(user.getTrainer());
	        userData.setuId(user.getuId());
	        userData.setUserMembershipList(user.getUserMembershipList());
	        userData.setAddress(user.getAddress()); 
	        dtoList.add(userData);
	    }
	    
	    return dtoList;
	}

}
