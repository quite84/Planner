package com.planner.planner.admin.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.planner.planner.user.dto.RequestUserDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	/* 2025.12.18 이후 관리자 사이트에서 다루는 부분을 개발 회원수, 신규 가입수, 전체 투두 리스트 내역 확인, 배치 작업 내역 확인 , 배치 관리 테이블 생성/업데이트 로직 생성 필요 */
	
	@GetMapping("/main")
	public String getAdminLoginPage() {
		return "admin/adminLogin";
	}

	@PostMapping("/login")
	public ResponseEntity<?> adminLogin(@ModelAttribute RequestUserDTO param) {
		log.info("로그인 데이터 확인3 ::::: {} " , param);
		Map<String, Object> result = new HashMap<>();
		
		result.put("resultCode", "1");
		
		return ResponseEntity.ok(result);
	};
	
	
}
