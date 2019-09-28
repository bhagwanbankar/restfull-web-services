package com.bhagwan.restfullwebservices.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bhagwan.restfullwebservices.entity.Todo;

@Service
public class TodoHardcodedService {
	
	private static List<Todo> todos = new ArrayList<>();
	private static int counter = 0;
	
	static {
		todos.add(new Todo(++counter, "Bhagwan", "Learning Java 8", new Date(), false));
		todos.add(new Todo(++counter, "Bhagwan", "Learning Angular", new Date(), false));
		todos.add(new Todo(++counter, "Bhagwan", "Learning spring boot", new Date(), false));
		todos.add(new Todo(++counter, "Bhagwan", "Learning Kafka", new Date(), false));
		todos.add(new Todo(++counter, "Bhagwan", "Learning datastructure", new Date(), false));
		todos.add(new Todo(++counter, "Priyanka", "Learning dance", new Date(), false));
		
	}

	public Todo save(Todo todo) {
		if(todo.getId()==-1 || todo.getId()==0) {
			todo.setId(++counter);
			todos.add(todo);
		}else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	
	public List<Todo> getAllTodos(String username) {
	
		List<Todo> userTodos = todos.stream()
				.filter(t -> t.getUsername().equals(username))
				.collect(Collectors.toList());
		return userTodos;
	}

	public List<Todo> findAll() {
		return todos;
	}

	public Todo deleteById(long id) {
		Todo todo = findById(id);
		if(todos.remove(todo))
			return todo;
		return null;
	}

	public Todo findById(long id) {
		// TODO Auto-generated method stub
		Optional<Todo> todoOptional = todos.parallelStream()
										   .filter(t ->t.getId()==id)
		
										   .findAny();
		if(todoOptional.isPresent())
			return todoOptional.get();
		return null;
	}
	

}
