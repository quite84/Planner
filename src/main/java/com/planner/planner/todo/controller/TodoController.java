package com.planner.planner.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.planner.planner.DTO.REQ.RequestTodoDTO;
import com.planner.planner.todo.service.TodoService;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@PostMapping
	public ResponseEntity<Void> createTodo(@RequestBody RequestTodoDTO todoDTO) {
		// In a real application, you'd get the user from the security context.
		// For now, let's assume the insertUser is set in the DTO.
		todoService.createTodo(todoDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("/{todoId}")
	public ResponseEntity<RequestTodoDTO> getTodo(@PathVariable Long todoId) {
		RequestTodoDTO todo = todoService.findTodoById(todoId);
		return ResponseEntity.ok(todo);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<RequestTodoDTO>> getTodosByUser(@PathVariable String userId) {
		List<RequestTodoDTO> todos = todoService.findAllByUserId(userId);
		return ResponseEntity.ok(todos);
	}
	
	@PutMapping("/{todoId}")
	public ResponseEntity<Void> updateTodo(@PathVariable Long todoId, @RequestBody RequestTodoDTO todoDTO) {
		todoDTO.setTodoid(todoId);
		// In a real application, you'd get the user from the security context.
		// For now, let's assume the updateUser is set in the DTO.
		todoService.updateTodo(todoDTO);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{todoId}")
	public ResponseEntity<Void> deleteTodo(@PathVariable Long todoId) {
		todoService.deleteTodo(todoId);
		return ResponseEntity.noContent().build();
	}
}
