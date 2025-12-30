package com.planner.planner.batch;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
	private BatchService001 bat01; // 회원 정보에 대한 비지니스 (휴면, 탈퇴처리 ... )

	@Autowired
	private BatchService002 bat02; // 투두 리스트 내역에 대한 비지니스 (투두 리스트의 날짜 확인 하여 사용여부 삭제 처리 ... )

//	private static final DateTimeFormatter DATE_ONLY_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	
	@Scheduled(cron = "0 * * * * *")
	public void getTime() throws Exception {
		LocalDateTime now = LocalDateTime.now();
		log.info("현재 시간 확인 ::: {}", now.format(DATE_FORMATTER));
		
//		Runtime runtime = Runtime.getRuntime();
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
		
		 MemoryUsage heapUsage = memoryMXBean.getHeapMemoryUsage();
	        System.out.println("Used Memory: " + heapUsage.getUsed() / 1024 / 1024 + " MB");
	        System.out.println("Total Memory: " + heapUsage.getCommitted() / 1024 / 1024 + " MB"); // 실제 사용 가능한 총 메모리
	        System.out.println("Max Memory: " + heapUsage.getMax() / 1024 / 1024 + " MB"); // 최대 힙 메모리
	   
	}
	
	@Scheduled(cron = "0 0 1 * * *") 
	 public void getUserDataUpdate() throws Exception{
		/*고객 라스트 로그인 시간으로 휴면 처리나 탈퇴 처리로 변경 로직 구현*/
//		 LocalDateTime now = LocalDateTime.now();
//		 log.info("현재 batch002 시작 ::: {}", now);		 
//		 bat02.todoListUpdate();
	 };
	
	 @Scheduled(cron = "0 0 1 * * *") 
	 public void getTodoUpdate() throws Exception{
		 LocalDateTime now = LocalDateTime.now();
		 log.info("현재 batch002 시작 ::: {}", now);		 
		 bat02.todoListUpdate();
	 };

}
