package com.planner.planner.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.planner.planner.DTO.REQ.RequestUserDTO;
import com.planner.planner.DTO.RES.ResponseUserDTO;
import com.planner.planner.user.service.userService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	userService service;

	@GetMapping("/main")
	public String getUser(Model model) {
		
		List<ResponseUserDTO> List = new ArrayList<>();
		
		model.addAttribute("List", List);
		
		return "user/user";
	};
	
	@GetMapping("/loginPage")
	public String getUserLoginPage() {
		return "user/login";
	};
	
	@GetMapping("/joinPage")
	public String getJoinPage() {
		return "user/join";
	}
	
	@PostMapping("/join")
	public ResponseEntity<?> userJoin(@ModelAttribute RequestUserDTO param) {
		log.info("회원가입 데이터 확인 ::::: {} " , param);
		Map<String, Object> result = new HashMap<>();
		
		// 여기에 실제 회원가입 로직 (서비스 호출 등)을 추가할 수 있습니다.
		result.put("resultCode", "1"); // 성공 가정
		
		return ResponseEntity.ok(result);
	};
		
	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@ModelAttribute RequestUserDTO param) {
		log.info("로그인 데이터 확인3 ::::: {} " , param);
		Map<String, Object> result = new HashMap<>();
		
		result.put("resultCode", "1");
		
		return ResponseEntity.ok(result);
	};
	
}
