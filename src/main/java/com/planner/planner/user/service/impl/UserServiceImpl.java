package com.planner.planner.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.planner.planner.user.dto.RequestUserDTO;
import com.planner.planner.user.dto.ResponseUserDTO;
import com.planner.planner.user.mapper.UserMapper;
import com.planner.planner.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<ResponseUserDTO> getUserList(){
		
		List<ResponseUserDTO> List = new ArrayList<>();
		List = mapper.userSelect();
		
		return List;
	};
	
	public Boolean selectOnebyCheck(RequestUserDTO param){
		log.info("1");
		ResponseUserDTO user = mapper.selectOnebyUser(param);
		log.info("2   {}", user);
		if (user != null && passwordEncoder.matches(param.getPassword(), user.getPassword())) {
			log.info("3");
			return true;
		}
		log.info("4");
		return false;
	};
	
	public int joinUser(RequestUserDTO param) {
		int result = 0;
		try {
			param.setPassword(passwordEncoder.encode(param.getPassword()));
			
			mapper.joinUser(param);
			result = 200;
		} catch(Exception e) {
			result = 500;
			log.info("가입중 오류 발생 ::: {}", e.getMessage());
		}
		
		return result;
	};
	
	public ResponseUserDTO selectOnebyUser(RequestUserDTO param){
		ResponseUserDTO result = new ResponseUserDTO();
		result = mapper.selectOnebyUser(param);
		return result;
	};
	
	public int userPassSetting (RequestUserDTO param) {
		int result = 0;
		String originalString = "a123456789!";
		try {
			param.setPassword(passwordEncoder.encode(originalString));
			mapper.updateUserPass(param);
			result=200;
		} catch (Exception e) {
			log.info("Exception error :::: {}", e.getMessage());
		}
	        
		return result;
	};
	
	public int updateUserPass (RequestUserDTO param) {
		int result = 0;
		try {
			log.info("1111");
			param.setPassword(passwordEncoder.encode(param.getNewPassword()));
			param.setUpdateUser(param.getUserId());
			mapper.updateUserPass(param);
			
			result=200;
		}catch (Exception e) {
			log.info("Exception error :::: {}", e.getMessage());
		}
		return result;
	};
	
	public int updateUserData (RequestUserDTO param) {
		int result = 0;
		try {
			mapper.updateUserData(param);
			result = 200;
		}catch (Exception e) {
			log.info("Exception error :::: {}", e.getMessage());
		}
		return result;
	};	
}
