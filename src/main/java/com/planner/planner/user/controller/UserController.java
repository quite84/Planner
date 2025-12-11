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
		
		List = service.userSelect();
		model.addAttribute("List", List);
		
		return "user/user";
	};
	
	@GetMapping("/loginPage")
	public String getUserLoginPage() {
		return "user/login";
	};
		
	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@ModelAttribute RequestUserDTO param) {
		log.info("로그인 데이터 확인3 ::::: {} " , param);
		Map<String, Object> result = new HashMap<>();
		
		result.put("resultCode", "1");
		
		return ResponseEntity.ok(result);
	};
	
}
