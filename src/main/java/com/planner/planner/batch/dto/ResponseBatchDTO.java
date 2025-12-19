package com.planner.planner.batch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ResponseBatchDTO {

	@JsonProperty
	private String batchId;
	@JsonProperty
	private String batchStatus;
	@JsonProperty
	private String startDate;
	@JsonProperty
	private String endDate;
	@JsonProperty
	private String updateUser;
	@JsonProperty
	private String updateDate;
}
