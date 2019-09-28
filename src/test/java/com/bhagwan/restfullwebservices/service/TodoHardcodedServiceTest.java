package com.bhagwan.restfullwebservices.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.bhagwan.restfullwebservices.entity.Todo;

public class TodoHardcodedServiceTest {

	@Test
	public void getAllTodos() {
		
		String username = "Bhagwan";
		
		TodoHardcodedService service = new TodoHardcodedService();
		List<Todo> todos = service.getAllTodos(username);
		
		assertEquals(5, todos.size());
		
	}
	
	@Test
	public void getAllTodosWithNoValues() {
		
		String username = "Priyanka";
		
		TodoHardcodedService service = new TodoHardcodedService();
		List<Todo> todos = service.getAllTodos(username);
		
		assertEquals(1, todos.size());
		
	}

}
