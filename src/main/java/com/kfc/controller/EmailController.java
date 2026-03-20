package com.kfc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kfc.dto.EmailDTO;
import com.kfc.services.EmailServiceClass;

@CrossOrigin(origins = "*")
@RestController
public class EmailController {
	
	private EmailServiceClass service;

	public EmailController(EmailServiceClass service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/sendmail")
	public ResponseEntity<String> sendMail(@RequestBody EmailDTO dto) {
		service.sendMail(dto.getTo(), dto.getSubject(), dto.getMsg());
		return ResponseEntity.ok("receipt sent");
	}
	
}
