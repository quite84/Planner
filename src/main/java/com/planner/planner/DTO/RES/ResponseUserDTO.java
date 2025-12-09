package com.planner.planner.DTO.RES;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ResponseUserDTO {
	
	@JsonProperty
	private String userId;
	@JsonProperty
	private String userName;
	@JsonProperty
	private String userPhone;
	@JsonProperty
	private String userEmail;
	@JsonProperty
	private String role;
	@JsonProperty
	private String useYn;
	@JsonProperty
	private String insertDate;
}
