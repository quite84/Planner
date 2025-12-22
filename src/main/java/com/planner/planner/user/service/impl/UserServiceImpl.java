package com.planner.planner.user.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	UserMapper mapper;
	
	public List<ResponseUserDTO> getUserList(){
		
		List<ResponseUserDTO> List = new ArrayList<>();
		List = mapper.userSelect();
		
		return List;
	};
	
	public Boolean selectOnebyCheck(RequestUserDTO param){
		Boolean result = false;
		List<ResponseUserDTO> exist = new ArrayList<>();
		exist = mapper.selectOnebyCheck(param);
		
		log.info("데이터 확인 ::::: {}", exist);
		
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
	};
	
	public ResponseUserDTO selectOnebyUser(RequestUserDTO param){
		ResponseUserDTO result = new ResponseUserDTO();
		result = mapper.selectOnebyUser(param);
		return result;
	};
	
	public int upDateUserData (RequestUserDTO param) {
		int result = 0;
		String originalString = "a123456789!";
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(originalString.getBytes());
			log.info("SHA-256 해시값 : " + toHexString(encodedhash));
			
			param.setPassword(toHexString(encodedhash));
			mapper.updateUserPass(param);
			result=200;
		} catch (NoSuchAlgorithmException e) {
			log.info("NoSuchAlgorithmException error :::: {}", e.getMessage());
		} catch (Exception e) {
			log.info("Exception error :::: {}", e.getMessage());
		}
	        
		return result;
	};
	
	public static String toHexString(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
