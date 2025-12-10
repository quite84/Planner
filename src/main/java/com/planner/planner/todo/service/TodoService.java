package com.planner.planner.todo.service;

import java.util.List;

import com.planner.planner.DTO.REQ.RequestTodoDTO;

public interface TodoService {
	public void createTodo(RequestTodoDTO todoDTO);
	public RequestTodoDTO findTodoById(Long todoId);
	public List<RequestTodoDTO> findAllByUserId(String userId);
	public void updateTodo(RequestTodoDTO todoDTO);
	public void deleteTodo(Long todoId);
}
