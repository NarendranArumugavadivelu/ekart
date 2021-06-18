package com.cooper.farming.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "roles")
public class RoleDTO extends BaseDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private int roleId;
	
	@Column(name = "role_name")
	private String roleName;
	
	@OneToMany(mappedBy = "roleDTO", fetch = FetchType.LAZY)
	private Set<UserDTO> userDTOs;

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

	public Set<UserDTO> getUserDTOs() {
		return userDTOs;
	}

	public void setUserDTOs(Set<UserDTO> userDTOs) {
		this.userDTOs = userDTOs;
	}

	@Override
	public String toString() {
		return "RoleDTO [roleId=" + roleId + ", roleName=" + roleName + ", userDTOs=" + userDTOs + "]";
	}
	
}
