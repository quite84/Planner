package com.planner.planner.batch;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.planner.planner.batch.service.BatchService001;
import com.planner.planner.batch.service.BatchService002;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PlannerBatchService {
	
	@Autowired
	private BatchService001 bat01;
	
	@Autowired
	private BatchService002 bat02;
	

	@Scheduled(cron = "1 * * * * *")
	public void getTime() throws Exception {
		LocalDateTime now = LocalDateTime.now();
		log.info("현재 시간 확인 ::: {}", now);
	}
	
}
