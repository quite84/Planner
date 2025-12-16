package com.planner.planner.main.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {

	@GetMapping("/main")
	public String getMain(Model model) {
		
		model.addAttribute("message", "안녕하세요, Thymeleaf!");
        model.addAttribute("user", "홍길동");
        model.addAttribute("new", "권오태");
        
        LocalDateTime now = LocalDateTime.now();
        model.addAttribute("today", now);
        return "main";
	}
	
	@GetMapping("/todo")
	public String getTodoPage(Model model, HttpSession session) {
		model.addAttribute("userId", session.getAttribute("userId"));
		
		return "todo/todo";
	}
	
	@GetMapping("/login")
	public String getLoginPage() {
		return "user/login";
	}
}

