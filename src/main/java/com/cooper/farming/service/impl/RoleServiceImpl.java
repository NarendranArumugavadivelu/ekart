package com.cooper.farming.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.cooper.farming.constants.Constants;
import com.cooper.farming.dto.RoleDTO;
import com.cooper.farming.exception.FarmingServiceException;
import com.cooper.farming.repository.RoleRepository;
import com.cooper.farming.service.RoleService;
import com.cooper.farming.vo.ErrorVO;
import com.cooper.farming.vo.RoleVO;
import com.cooper.farming.vo.RolesVO;

@Service
public class RoleServiceImpl implements RoleService {
	
	private RoleRepository roleRepository;
	
	private Properties errorProperties;
	
	public RoleServiceImpl(RoleRepository roleRepository, Properties errorProperties) {
		this.roleRepository = roleRepository;
		this.errorProperties = errorProperties; 
	}

	@Override
	public RoleDTO getRole(Integer roleId) throws FarmingServiceException {
		RoleDTO roleDTO = roleRepository.findByRoleId(roleId);
		if(roleDTO == null) {
			String message = MessageFormat.format(errorProperties.getProperty(Constants.ROLE_DOES_NOT_EXISTS), roleId);
			ErrorVO errorVO = new ErrorVO();
			errorVO.setErrorCode(Constants.ROLE_DOES_NOT_EXISTS);
			errorVO.setErrorMessage(message);
			throw new FarmingServiceException(message, errorVO);
		}
		return roleDTO;
	}

	@Override
	public RolesVO getRoles() {
		List<RoleDTO> roleDTOs = roleRepository.findByRoleNameNot(Constants.ADMIN_ROLE);
		RolesVO rolesVO = new RolesVO();
		List<RoleVO> roleVOs = new ArrayList<>();
		roleDTOs.forEach(roleDTO -> roleVOs.add(getRoleVOByDTO(roleDTO)));
		rolesVO.setRoleVOs(roleVOs);
		return rolesVO;
	}
	
	/**Method to get the role VO by DTO*/
	private RoleVO getRoleVOByDTO(RoleDTO roleDTO) {
		RoleVO roleVO = new RoleVO();
		roleVO.setRoleId(roleDTO.getRoleId());
		roleVO.setRoleName(roleDTO.getRoleName());
		return roleVO;
	}

}
