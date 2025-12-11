package com.planner.planner.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@GetMapping("/main")
	public String getAdminMain() {
		return "admin/login/adminLogin";
	}

	@PostMapping("/login")
	public String getAdminPage() {
		boolean admin = false;
		
		if(!admin) {
			return "redirect:/admin/main";
		}
		return "admin/user/adminUserManager";
	}
}
