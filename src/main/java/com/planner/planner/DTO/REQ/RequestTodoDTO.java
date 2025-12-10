package com.planner.planner.DTO.REQ;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RequestTodoDTO {
	
	@JsonProperty
	private Long todoid;
	@JsonProperty
	private String userId;
	@JsonProperty
	private String title;
	@JsonProperty
	private String completed;
	@JsonProperty
	private LocalDateTime dueDate;
	@JsonProperty
	private LocalDateTime completDate;
	@JsonProperty
	private String useYn;
	@JsonProperty
	private String insertUser;
	@JsonProperty
	private LocalDateTime insertDate;
	@JsonProperty
	private String updateUser;
	@JsonProperty
	private LocalDateTime updateDate;
}
