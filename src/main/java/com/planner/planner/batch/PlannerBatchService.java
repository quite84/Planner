package com.planner.planner.batch;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.planner.planner.batch.dto.RequestBatchDTO;
import com.planner.planner.batch.mapper.BatchServiceMapper;
import com.planner.planner.batch.service.BatchService001;
import com.planner.planner.batch.service.BatchService002;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PlannerBatchService {

	@Autowired
	private BatchService001 bat01; // 회원 정보에 대한 비지니스 (휴면, 탈퇴처리 ... )

	@Autowired
	private BatchService002 bat02; // 투두 리스트 내역에 대한 비지니스 (투두 리스트의 날짜 확인 하여 사용여부 삭제 또는 완료 처리 ... )

	@Autowired
	private BatchServiceMapper mapper;

	private static final DateTimeFormatter DATE_ONLY_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private static final LocalDateTime now = LocalDateTime.now();
	
	
	@Scheduled(cron = "1 * * * * *")
	public void getTime() throws Exception {
		log.info("현재 시간 확인 ::: {}", now.format(DATE_ONLY_FORMATTER));
	}

	
	 @Scheduled(cron = "0 0 1 * * *") 
	 public void getTodoUpdate() throws Exception{
//		 RequestBatchDTO batch = new RequestBatchDTO();
//		 String nowDate = now.toString();
//		 batch.setBatchId("BatchService002");
//		 batch.setBatchStatus("start");
//		 batch.setUpdateUser("System");
//		 batch.setUpdateDate(nowDate);
//		 
//		 mapper.updateBatch(batch);
		 
		 bat02.todoListUpdate();
		 
	 }
	 

}
