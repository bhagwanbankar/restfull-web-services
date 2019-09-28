package com.bhagwan.restfullwebservices.controller;

import com.bhagwan.restfullwebservices.entity.AuthenticationBean;

//@CrossOrigin(origins = "http://localhost:4200")
//@RestController
public class AuthenticationResouce {

	//@GetMapping(path="/basicAuth")
	public AuthenticationBean getAuthenticate() {
		
		return new AuthenticationBean("You are Authenticated");
		
	}
}
