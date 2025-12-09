package com.planner.planner.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.planner.planner.DTO.RES.ResponseUserDTO;
import com.planner.planner.user.service.userService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {
	
	@Autowired
	userService service;

	@GetMapping("/user")
	public String getUser(Model model) {
		
		List<ResponseUserDTO> List = new ArrayList<>();
		
		List = service.userSelect();
		model.addAttribute("List", List);
		
		return "user/user";
	}
}
