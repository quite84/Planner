package com.planner.planner.batch.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.planner.planner.batch.dto.RequestBatchDTO;
import com.planner.planner.batch.mapper.BatchServiceMapper;
import com.planner.planner.todo.dto.RequestTodoDTO;
import com.planner.planner.todo.dto.ResponseTodoDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BatchService002 {

	private static final DateTimeFormatter DATE_ONLY_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private static final LocalDateTime now = LocalDateTime.now();

	@Autowired
	private BatchServiceMapper mapper;

	@Transactional
	public void todoListUpdate() {
		RequestBatchDTO batch = new RequestBatchDTO();
		String nowDate = now.toString();
		String dateNow = now.format(DATE_ONLY_FORMATTER);
		batch.setBatchId("BatchService002");
		batch.setBatchStatus("start");
		batch.setUpdateUser("System");
		batch.setUpdateDate(nowDate);
		mapper.updateBatch(batch);
		try {
			List<ResponseTodoDTO> TodoList = new ArrayList<>();
			TodoList = mapper.getNotComplTodoList(dateNow);
			if(TodoList.isEmpty()) {
				log.info("시작 todo 내역 : {}", "변경 할 리스트 내역이 없습니다.");
			}else {
				for (ResponseTodoDTO todo : TodoList) {
					log.info("시작 todo 내역 : {}", todo);
					RequestTodoDTO todoSet = new RequestTodoDTO();
					todoSet.setTodoid(todo.getTodoid());
					mapper.updateNotComplTodo(todoSet);
				}
			}
			batch.setBatchStatus("end");
			batch.setUpdateDate(nowDate);
			mapper.updateBatch(batch);
		}catch (Exception e) {
			log.info("오류 내역 확인 ::::: {}" , e.getMessage());
			batch.setBatchStatus("error");
			batch.setUpdateDate(nowDate);
			mapper.updateBatch(batch);
		}
		
	}
}
