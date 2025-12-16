package com.planner.planner.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planner.planner.DTO.REQ.RequestUserDTO;
import com.planner.planner.DTO.RES.ResponseUserDTO;
import com.planner.planner.user.mapper.userMapper;
import com.planner.planner.user.service.userService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class userServiceImpl implements userService {

	@Autowired
	userMapper mapper;
	
	public List<ResponseUserDTO> getUserList(){
		
		List<ResponseUserDTO> List = new ArrayList<>();
		List = mapper.userSelect();
		
		return List;
	};
	
	public Boolean selectOnebyCheck(RequestUserDTO param){
		Boolean result = false;
		List<ResponseUserDTO> exist = new ArrayList<>();
		exist = mapper.selectOnebyCheck(param);
		log.info("결과 확인 :::: {}" , exist);
		if(exist.isEmpty()) {
			result = true;
		}else{
			result = false;
		}
		
		return result;
	};
	
	public int joinUser(RequestUserDTO param) {
		int result = 0;
		try {
			mapper.joinUser(param);
			result = 200;
		}catch(Exception e) {
			result = 500;
			log.info("가입중 오류 발생 ::: {}", e.getMessage());
		}
		
		return result;
	}
}
