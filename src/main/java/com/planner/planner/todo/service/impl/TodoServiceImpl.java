package com.planner.planner.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planner.planner.DTO.REQ.RequestTodoDTO;
import com.planner.planner.todo.mapper.TodoMapper;
import com.planner.planner.todo.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoMapper todoMapper;
	
	@Override
	public void createTodo(RequestTodoDTO todoDTO) {
		todoMapper.insertTodo(todoDTO);
	}

	@Override
	public RequestTodoDTO findTodoById(Long todoId) {
		return todoMapper.findTodoById(todoId);
	}

	@Override
	public List<RequestTodoDTO> findAllByUserId(String userId) {
		return todoMapper.findAllByUserId(userId);
	}

	@Override
	public void updateTodo(RequestTodoDTO todoDTO) {
		todoMapper.updateTodo(todoDTO);
	}

	@Override
	public void deleteTodo(Long todoId) {
		todoMapper.deleteTodo(todoId);
	}
}
