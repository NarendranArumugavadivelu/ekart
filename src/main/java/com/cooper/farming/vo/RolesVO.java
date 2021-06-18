package com.cooper.farming.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class RolesVO {

	@JsonProperty("roles")
	@Schema(description = "The list of roles", type = "array")
	private List<RoleVO> roleVOs;

	public List<RoleVO> getRoleVOs() {
		return roleVOs;
	}

	public void setRoleVOs(List<RoleVO> roleVOs) {
		this.roleVOs = roleVOs;
	}

	@Override
	public String toString() {
		return "RolesVO [roleVOs=" + roleVOs + "]";
	}
	
	
}
