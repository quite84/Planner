package com.planner.planner.todo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.planner.planner.DTO.REQ.RequestTodoDTO;

@Mapper
public interface TodoMapper {
	public void insertTodo(RequestTodoDTO todoDTO);
	public RequestTodoDTO findTodoById(Long todoId);
	public List<RequestTodoDTO> findAllByUserId(String userId);
	public void updateTodo(RequestTodoDTO todoDTO);
	public void deleteTodo(Long todoId);
}
