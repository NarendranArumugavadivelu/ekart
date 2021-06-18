package com.cooper.farming.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleVO {

	@JsonProperty("role_id")
	@Schema(description = "The role id", type = "integer")
	private int roleId;
	
	@JsonProperty("role_name")
	@Schema(description = "The name of the role", type = "string")
	private String roleName;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "RoleVO [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
}
