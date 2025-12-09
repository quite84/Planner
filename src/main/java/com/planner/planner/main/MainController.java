package com.planner.planner.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {

	@GetMapping("/main")
	public String getMain(Model model) {
		log.info("진입 확인 :::!!!");
		
		model.addAttribute("message", "안녕하세요, Thymeleaf!");
        model.addAttribute("user", "홍길동");
		return "main";
	}
}

