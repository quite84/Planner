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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.planner.planner.user.dto.RequestUserDTO;
import com.planner.planner.user.dto.ResponseUserDTO;
import com.planner.planner.user.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;

	@GetMapping("/main")
	public String getUser(Model model) {
		
		List<ResponseUserDTO> List = new ArrayList<>();
		List = service.getUserList();
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
	};
	
	@GetMapping("/find")
	public String getFindPage() {
		return "user/find";
	};
	
	@PostMapping("/join")
	public ResponseEntity<?> userJoin(@RequestBody RequestUserDTO param) {
		log.info("join ::::: {} " , param);
		Map<String, Object> result = new HashMap<>();
		int code = service.joinUser(param);
		
		// 여기에 실제 회원가입 로직 (서비스 호출 등)을 추가할 수 있습니다.
		result.put("resultCode", code); // 성공 가정
		
		return ResponseEntity.ok(result);
	};
		
	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@ModelAttribute RequestUserDTO param, HttpSession session) {
		log.info("login ::::: {} " , param);
		Map<String, Object> result = new HashMap<>();
		boolean exist = service.selectOnebyCheck(param); 
		if(!exist) {
			session.setAttribute("userId", param.getUserId());
			result.put("resultCode", "200");	
		}else {
			result.put("resultCode", "400");
		}
				
		return ResponseEntity.ok(result);
	};
	
	@PostMapping("/idCheck")
	public ResponseEntity<?> userIdCheck(@ModelAttribute RequestUserDTO param) {
		log.info("idCheck ::::: {} " , param);
		Map<String, Object> result = new HashMap<>();
		boolean exist = service.selectOnebyCheck(param); 
		if(exist) {
			result.put("resultCode", "200");	
		}else {
			result.put("resultCode", "400");
		}
		
		return ResponseEntity.ok(result);
	};
	
	@PostMapping("/emailCheck")
	public ResponseEntity<?> userEmailCheck(@ModelAttribute RequestUserDTO param) {
		log.info("emailCheck ::::: {} " , param);
		Map<String, Object> result = new HashMap<>();
		boolean exist = service.selectOnebyCheck(param); 
		
		if(exist) {
			result.put("resultCode", "200");	
		}else {
			result.put("resultCode", "400");
		}
		
		return ResponseEntity.ok(result);
	};
	
	@PostMapping("/logOut")
	public ResponseEntity<?> userLogOut(HttpSession session) {
		log.info("logOut ::::: {} " , session.getAttribute("userId"));
		Map<String, Object> result = new HashMap<>();
		String userId = (String)session.getAttribute("userId");
		
		if(userId.isEmpty()||userId == null) {
			result.put("resultCode", "400");
			result.put("message", "알수 없는 오류가 발생 하였습니다. 다시 시도 바랍니다.");
		}else {
			session.removeAttribute("userId");
			result.put("resultCode", "200");
		}
		
		return ResponseEntity.ok(result);
	};
	
	@PostMapping("/findByName")
	public ResponseEntity<?> findByName(@ModelAttribute RequestUserDTO param, HttpSession session) {
		log.info("findByName 진입 데이터 확인 :::: {}", param);
		Map<String, Object> result = new HashMap<>();
		
		if(service.selectOnebyUser(param) != null) {
			result.put("resultCode", "200");
			result.put("message", service.selectOnebyUser(param).getUserId());
		}else {
			result.put("resultCode", "400");
			result.put("message", "잘못된 데이터 입력으로 해당 고객을 찾을 수 없습니다.");
		}
		return ResponseEntity.ok(result);
	};
	
	@PostMapping("/findById")
	public ResponseEntity<?> findById(@ModelAttribute RequestUserDTO param, HttpSession session) {
		log.info("findById 진입 데이터 확인 :::: {}", param);
		Map<String, Object> result = new HashMap<>();
		
		if(service.selectOnebyUser(param) != null) {
			service.upDateUserData(param);
			result.put("resultCode", "200");
			result.put("message", "임시 비밀번호를 발급 했습니다.");
		}else {
			result.put("resultCode", "400");
			result.put("message", "잘못된 데이터 입력으로 해당 고객을 찾을 수 없습니다.");
		}
		
		return ResponseEntity.ok(result);
	};
}
