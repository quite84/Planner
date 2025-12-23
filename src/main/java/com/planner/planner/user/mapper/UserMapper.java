package com.planner.planner.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.planner.planner.user.dto.RequestUserDTO;
import com.planner.planner.user.dto.ResponseUserDTO;

@Mapper
public interface UserMapper {
	
	List<ResponseUserDTO> userSelect();
	
	List<ResponseUserDTO> selectOnebyCheck(RequestUserDTO param);
	
	ResponseUserDTO selectOnebyUser(RequestUserDTO param);
	
	int joinUser(RequestUserDTO param);
	
	int updateUserPass(RequestUserDTO param);
	
	int updateUserData(RequestUserDTO param);
}
