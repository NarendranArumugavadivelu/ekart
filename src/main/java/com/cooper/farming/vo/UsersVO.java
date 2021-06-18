package com.cooper.farming.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersVO {

	@JsonProperty("users")
	@Schema(description = "List of users", type = "array")
	private List<UserVO> userVOs;

	public List<UserVO> getUserVOs() {
		return userVOs;
	}

	public void setUserVOs(List<UserVO> userVOs) {
		this.userVOs = userVOs;
	}

	@Override
	public String toString() {
		return "UsersVO [userVOs=" + userVOs + "]";
	}
	
	
}
