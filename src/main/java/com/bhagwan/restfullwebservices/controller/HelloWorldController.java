package com.bhagwan.restfullwebservices.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bhagwan.restfullwebservices.entity.HelloWorldBean;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {
	
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello Bhagwan";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		
		throw new RuntimeException("Something wrong happenned**********");
		
		//return new HelloWorldBean("Hello World Bean");
		
	}
	
	@GetMapping(path = "/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldPath(@PathVariable String name) {
		
		return new HelloWorldBean(String.format("Hello World %s",name));
		
	}
	

}
