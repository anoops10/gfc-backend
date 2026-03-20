package com.kfc.dto;

public class EmailDTO {

	String to;
	String subject;
	String msg;
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public EmailDTO(String to, String subject, String msg) {
		super();
		this.to = to;
		this.subject = subject;
		this.msg = msg;
	}
	public EmailDTO() {
		super();
	}
	
	
	
	
}
