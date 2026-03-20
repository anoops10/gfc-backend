package com.kfc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kfc.dto.UserDataDTO;
import com.kfc.pojo.Users;
import com.kfc.services.UserServicesClass;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {

//	@Autowired
	private UserServicesClass service;
	
	
	
	public UserController(UserServicesClass service) {
	super();
	this.service = service;
}

	@PostMapping (value =  "/adduser", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Users> saveUser(@ModelAttribute Users user, @RequestPart("file") MultipartFile file) {
		Users savedUser = service.addUser(user, file);
		return ResponseEntity.ok(savedUser);
	}
	
	@GetMapping("/userimg/{uId}")
	public ResponseEntity<byte[]> getImage(@PathVariable int uId){
		Users user = service.getUserById(uId);
		return ResponseEntity.ok()
//				.contentType(MediaType.valueOf(user.getImageType()))
				.body(user.getImageData());
	}
	
	@GetMapping("/userbyemail/{emailId:.+}")
	public UserDataDTO getUserByEmail(@PathVariable String emailId) {
		return service.getUserByEmailId(emailId);
	}
	
	@GetMapping("/showalluser")
	public List<UserDataDTO> getAllUsers(){
		return service.getAllUsers();
	}
	
	@GetMapping("/user/{uId}")
	public Users getUserById(@PathVariable int uId) {
		return service.getUserById(uId);
	}
	
	@PutMapping("/update/{emailId:.+}")
	public Users updateUser(@PathVariable String emailId,@Valid @RequestBody UserDataDTO dto) {
		return service.updateUser(emailId, dto);
	}
	
	@DeleteMapping("/delete/{uId}")
	public String deleteUser(@PathVariable int uId) {
		return service.deleteUser(uId);
	}
	
	
}
