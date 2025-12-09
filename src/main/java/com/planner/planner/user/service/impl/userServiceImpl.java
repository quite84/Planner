package com.planner.planner.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planner.planner.DTO.RES.ResponseUserDTO;
import com.planner.planner.user.mapper.userMapper;
import com.planner.planner.user.service.userService;

@Service
public class userServiceImpl implements userService {
	
	@Autowired
	userMapper mapper;

	public List<ResponseUserDTO> userSelect(){
		
		List<ResponseUserDTO> List = new ArrayList<>();
		List = mapper.userSelect();
		
		return List;
	}
}
