package com.bhagwan.restfullwebservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bhagwan.restfullwebservices.entity.Todo;
import com.bhagwan.restfullwebservices.service.TodoHardcodedService;


@RestController
@CrossOrigin(origins = {"http://localhost:4200","chrome-extension://fhbjgbiflinjbdggehcddcbncdddomop"})

public class TodoResource {
	
	@Autowired
	private TodoHardcodedService hardcodedService;
	
	@GetMapping("/user/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		System.out.println("getAllTodos called####");
		return hardcodedService.findAll();
		
	}
	
	@GetMapping("/user/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username, @PathVariable long id){
		
		return hardcodedService.findById(id);
		
	}
	
	@DeleteMapping("/user/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodoById(@PathVariable String username, @PathVariable long id){
		
		Todo todo = hardcodedService.deleteById(id);
		if(todo!=null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@PutMapping("/user/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo){
		
		Todo updatedTodo = hardcodedService.save(todo);
		return new ResponseEntity<Todo>(updatedTodo,HttpStatus.OK );
	}

	@PostMapping("/user/{username}/todos")
	public ResponseEntity<Void> addTodo(@PathVariable String username, @RequestBody Todo todo){
		
		Todo createdTodo = hardcodedService.save(todo);
		
		//location 
		//get current url
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
}
