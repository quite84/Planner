package com.planner.planner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RootController {
	
	@GetMapping("/")
	public String root() {
		log.info("start Root");
		return "redirect:/main";
	};

}
