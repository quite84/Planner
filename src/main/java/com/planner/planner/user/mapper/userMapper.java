package com.planner.planner.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.planner.planner.DTO.RES.ResponseUserDTO;

@Mapper
public interface userMapper {
	
	List<ResponseUserDTO> userSelect();

}
