package com.planner.planner.user.service;

import java.util.List;

import com.planner.planner.user.dto.RequestUserDTO;
import com.planner.planner.user.dto.ResponseUserDTO;

public interface UserService {

	List<ResponseUserDTO> getUserList();
	
	Boolean selectOnebyCheck(RequestUserDTO param);
	
	ResponseUserDTO selectOnebyUser(RequestUserDTO param);
	
	int joinUser(RequestUserDTO param);
	
	int upDateUserData (RequestUserDTO param);
}
