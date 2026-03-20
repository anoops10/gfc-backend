package com.kfc.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceClass implements EmailServiceDao {

	private JavaMailSender sender;
	
	public EmailServiceClass(JavaMailSender sender) {
		super();
		this.sender = sender;
	}



	@Override
	public void sendMail(String to, String subject, String msg) {

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(to);
		mail.setSubject(subject);
		mail.setText(msg);
		sender.send(mail);
	}

}
