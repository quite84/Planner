package com.planner.planner.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RequestUserDTO {
	
	@JsonProperty
	private String userId;
	@JsonProperty
	private String userName;
	@JsonProperty
	private String password;
	@JsonProperty
	private String userPhone;
	@JsonProperty
	private String userEmail;
	@JsonProperty
	private String role;
	@JsonProperty
	private String useYn;
	@JsonProperty
	private String updateUser;
	
	@JsonProperty
	private String currentPassword;
	@JsonProperty
	private String newPassword;
	
}
