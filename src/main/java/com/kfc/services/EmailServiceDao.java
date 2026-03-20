package com.kfc.services;

public interface EmailServiceDao {

	void sendMail(String to, String subject, String msg);
}
