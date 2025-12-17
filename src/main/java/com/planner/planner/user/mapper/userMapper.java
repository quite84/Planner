package com.planner.planner.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.planner.planner.DTO.REQ.RequestUserDTO;
import com.planner.planner.DTO.RES.ResponseUserDTO;

@Mapper
public interface userMapper {
	
	List<ResponseUserDTO> userSelect();
	
	List<ResponseUserDTO> selectOnebyCheck(RequestUserDTO param);
	
	ResponseUserDTO selectOnebyUser(RequestUserDTO param);
	
	int joinUser(RequestUserDTO param);
	
	int updateUserPass(RequestUserDTO param);
}
