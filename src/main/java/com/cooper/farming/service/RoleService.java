package com.cooper.farming.service;

import org.springframework.stereotype.Service;

import com.cooper.farming.dto.RoleDTO;
import com.cooper.farming.exception.FarmingServiceException;
import com.cooper.farming.vo.RolesVO;

@Service
public interface RoleService {

	public RoleDTO getRole(Integer roleId) throws FarmingServiceException;
	
	public RolesVO getRoles();
	
}
