package com.bhagwan.restfullwebservices.entity;

public class AuthenticationBean {
	
	public AuthenticationBean() {
		// TODO Auto-generated constructor stub
	}
	
	

	public AuthenticationBean(String message) {
		super();
		this.message = message;
	}



	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
