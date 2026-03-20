package com.kfc.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.kfc.dto.UserDataDTO;
import com.kfc.pojo.Users;

public interface UserServicesDao {
	
	Users addUser(Users user, MultipartFile file);
	List<Users> showAllUsers();
	Users getUserById(int uId);
	Users updateUser(String emailId, UserDataDTO user);
	String deleteUser(int uId);
	UserDataDTO getUserByEmailId(String emailId);
	List<UserDataDTO> getAllUsers();
}
