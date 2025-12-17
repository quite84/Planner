package com.planner.planner.user.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
