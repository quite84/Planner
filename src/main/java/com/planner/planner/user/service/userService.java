package com.planner.planner.user.service;

import java.util.List;

import com.planner.planner.DTO.REQ.RequestUserDTO;
import com.planner.planner.DTO.RES.ResponseUserDTO;

public interface userService {

	List<ResponseUserDTO> getUserList();
	
	Boolean selectOnebyCheck(RequestUserDTO param);
	
	ResponseUserDTO selectOnebyUser(RequestUserDTO param);
	
	int joinUser(RequestUserDTO param);
	
	int upDateUserData (RequestUserDTO param);
}
