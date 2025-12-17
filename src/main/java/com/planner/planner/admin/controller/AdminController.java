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
	
	@GetMapping("/main")
	public String getAdminLoginPage() {
		return "admin/login/adminLogin";
	}

	@PostMapping("/login")
	public ResponseEntity<?> adminLogin(@ModelAttribute RequestUserDTO param) {
		log.info("로그인 데이터 확인3 ::::: {} " , param);
		Map<String, Object> result = new HashMap<>();
		
		result.put("resultCode", "1");
		
		return ResponseEntity.ok(result);
	};
	
	
}
