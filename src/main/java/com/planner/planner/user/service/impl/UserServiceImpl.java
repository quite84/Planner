package com.planner.planner.user.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planner.planner.commonService.Sha256EncoderService;
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
	
	@Autowired
	Sha256EncoderService encoService;
	
	public List<ResponseUserDTO> getUserList(){
		
		List<ResponseUserDTO> List = new ArrayList<>();
		List = mapper.userSelect();
		
		return List;
	};
	
	public Boolean selectOnebyCheck(RequestUserDTO param){
		Boolean result = false;
		List<ResponseUserDTO> exist = new ArrayList<>();
		
		try {
			
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(param.getPassword().getBytes());
			
			param.setPassword(encoService.toHexString(encodedhash));
			exist = mapper.selectOnebyCheck(param);
			
			if(exist.isEmpty()) {result = true;}else{result = false;}
			
		} catch (NoSuchAlgorithmException e) {
			log.info("NoSuchAlgorithmException error :::: {}", e.getMessage());
		} catch (Exception e) {
			log.info("Exception error :::: {}", e.getMessage());
		}
		
		return result;
	};
	
	public int joinUser(RequestUserDTO param) {
		int result = 0;
		try {
			
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(param.getPassword().getBytes());
			param.setPassword(encoService.toHexString(encodedhash));
			
			mapper.joinUser(param);
			result = 200;
		} catch (NoSuchAlgorithmException e) {
			log.info("NoSuchAlgorithmException error :::: {}", e.getMessage());
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
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(originalString.getBytes());
//			log.info("SHA-256 해시값 : " + encoService.toHexString(encodedhash));
			
			param.setPassword(encoService.toHexString(encodedhash));
			mapper.updateUserPass(param);
			result=200;
		} catch (NoSuchAlgorithmException e) {
			log.info("NoSuchAlgorithmException error :::: {}", e.getMessage());
		} catch (Exception e) {
			log.info("Exception error :::: {}", e.getMessage());
		}
	        
		return result;
	};
	
	public int updateUserPass (RequestUserDTO param) {
		int result = 0;
		try {
			MessageDigest digest;
			digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(param.getNewPassword().getBytes());
			
			param.setPassword(encoService.toHexString(encodedhash));
			param.setUpdateUser(param.getUserId());
			mapper.updateUserPass(param);
			
			result=200;
		}catch (NoSuchAlgorithmException e) {
			log.info("NoSuchAlgorithmException error :::: {}", e.getMessage());
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
