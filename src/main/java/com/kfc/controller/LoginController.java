package com.kfc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kfc.dto.LoginResponseDTO;
import com.kfc.dto.SessionUserDTO;
import com.kfc.pojo.Users;
import com.kfc.services.UserServicesClass;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"}, allowCredentials = "true")
public class LoginController {
	
	private UserServicesClass service;
	
	
	public LoginController(UserServicesClass service) {
		super();
		this.service = service;
	}


	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestParam String password, @RequestParam String emailId, HttpServletRequest request, HttpSession session) {
		LoginResponseDTO loginResponse = new LoginResponseDTO(null, null, false);
		Users user = service.getUserById(service.getUserByEmailId(emailId).getuId());
		
		if(user!=null && user.getPassword().equals(password)) {
			
			SessionUserDTO sessionUser = new SessionUserDTO(user.getuId(), user.getEmailId(), user.getRole());
			
			session.setAttribute("USER", sessionUser);
			loginResponse = new LoginResponseDTO(user.getEmailId(), user.getRole(), true);
			
			return ResponseEntity.ok(loginResponse);	
		}
	    return ResponseEntity.status(401).body(loginResponse);
	}
	
	
	@PostMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session) {
	    session.invalidate();  
	    return ResponseEntity.ok().body("Logged out successfully");
	}
	
}
