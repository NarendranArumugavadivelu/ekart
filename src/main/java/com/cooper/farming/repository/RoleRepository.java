package com.cooper.farming.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cooper.farming.dto.RoleDTO;

@Repository
public interface RoleRepository extends CrudRepository<RoleDTO, Integer> {

	public RoleDTO findByRoleId(Integer roleId);
	
	public List<RoleDTO> findByRoleNameNot(String roleName);
}
