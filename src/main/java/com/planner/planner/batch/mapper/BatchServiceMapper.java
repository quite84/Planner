package com.planner.planner.batch.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.planner.planner.batch.dto.RequestBatchDTO;
import com.planner.planner.batch.dto.ResponseBatchDTO;
import com.planner.planner.todo.dto.RequestTodoDTO;
import com.planner.planner.todo.dto.ResponseTodoDTO;

@Mapper
public interface BatchServiceMapper {
	
	ResponseBatchDTO selectOneBatch(String batchId);
	
	int updateBatch(RequestBatchDTO param);
	
	List<ResponseTodoDTO> getNotComplTodoList(String dateNow);
	
	int updateNotComplTodo(RequestTodoDTO param);
}
