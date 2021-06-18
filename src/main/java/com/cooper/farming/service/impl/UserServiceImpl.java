package com.cooper.farming.service.impl;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cooper.farming.constants.Constants;
import com.cooper.farming.dto.RoleDTO;
import com.cooper.farming.dto.UserDTO;
import com.cooper.farming.exception.FarmingServiceException;
import com.cooper.farming.repository.UserRepository;
import com.cooper.farming.service.FarmingValidationService;
import com.cooper.farming.service.RoleService;
import com.cooper.farming.service.UserService;
import com.cooper.farming.vo.ErrorVO;
import com.cooper.farming.vo.UserVO;
import com.cooper.farming.vo.UsersVO;

@Service
public class UserServiceImpl implements UserService {
	
	private FarmingValidationService farmingValidationService;
	
	private RoleService roleService;
	
	private UserRepository userRepository;
	
	private Properties errorProperties;
	
	private PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(RoleService roleService, FarmingValidationService farmingValidationService, UserRepository userRepository, Properties errorProperties, PasswordEncoder passwordEncoder) {
		this.roleService = roleService;
		this.farmingValidationService = farmingValidationService;
		this.userRepository = userRepository;
		this.errorProperties = errorProperties;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserVO createUser(UserVO userVO) throws FarmingServiceException {
		farmingValidationService.validateUsername(userVO.getUserName());
		UserDTO userDTO = getUserDTOByVO(userVO);
		RoleDTO roleDTO = roleService.getRole(userVO.getRoleId());
		userDTO.setRoleDTO(roleDTO);
		userDTO = userRepository.save(userDTO);
		return getUserVOByDTO(userDTO);
	}
	
	@Override
	public UserVO getUserByNameAndPassword(String username, String password) throws FarmingServiceException {
		UserDTO userDTO = userRepository.findByUserName(username);
		if(userDTO != null) {
			if(!passwordEncoder.matches(password, userDTO.getPassword())) {
				ErrorVO errorVO = new ErrorVO();
				errorVO.setErrorCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
				errorVO.setErrorCode(errorProperties.getProperty(Constants.INVALID_PASSWORD));
				throw new FarmingServiceException(errorProperties.getProperty(Constants.INVALID_PASSWORD), errorVO);
			}
			return getUserVOByDTO(userDTO);
		} else {
			ErrorVO errorVO = new ErrorVO();
			errorVO.setErrorCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
			errorVO.setErrorCode(errorProperties.getProperty(Constants.BAD_CREDENTIALS));
			throw new FarmingServiceException(errorProperties.getProperty(Constants.BAD_CREDENTIALS), errorVO);
		}
	}

	/**Method to get the user DTO by VO*/
	private UserDTO getUserDTOByVO(UserVO userVO) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		UserDTO userDTO = new UserDTO();
		userDTO.setCity(userVO.getCity());
		userDTO.setCreatedAt(currentDateTime);
		userDTO.setAddress(userVO.getAddress());
		userDTO.setEmailId(userVO.getEmailId());
		userDTO.setFirstName(userVO.getFirstName());
		userDTO.setLastName(userVO.getLastName());
		userDTO.setModifiedAt(currentDateTime);
		userDTO.setPassword(userVO.getPassword());
		userDTO.setPhoneNumber(userVO.getPhoneNumber());
		userDTO.setUserName(userVO.getUserName());
		userDTO.setZipCode(userVO.getZipCode());
		return userDTO;
	}
	
	/**Method to get the DTO by VO*/
	private UserVO getUserVOByDTO(UserDTO userDTO) {
		UserVO userVO = new UserVO();
		userVO.setCity(userDTO.getCity());
		userVO.setAddress(userDTO.getAddress());
		userVO.setEmailId(userDTO.getEmailId());
		userVO.setFirstName(userDTO.getFirstName());
		userVO.setLastName(userDTO.getLastName());
		userVO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		userVO.setPhoneNumber(userDTO.getPhoneNumber());
		userVO.setRoleId(userDTO.getRoleDTO().getRoleId());
		userVO.setRoleName(userDTO.getRoleDTO().getRoleName());
		userVO.setUserId(userDTO.getUserId());
		userVO.setUserName(userDTO.getUserName());
		userVO.setZipCode(userDTO.getZipCode());
		return userVO;
	}

	@Override
	public UserDTO getUserById(int userId) throws FarmingServiceException {
		Optional<UserDTO> optional = userRepository.findById(userId);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			String message = MessageFormat.format(errorProperties.getProperty(Constants.USER_DOES_NOT_EXISTS), userId);
			ErrorVO errorVO = new ErrorVO();
			errorVO.setErrorCode(Constants.USER_DOES_NOT_EXISTS);
			errorVO.setErrorMessage(message);
			throw new FarmingServiceException(message, errorVO);
		}
	}
	
	@Override
	public UsersVO getUsersByCityAndRole(String city, String role) {
		List<UserDTO> userDTOs = userRepository.findByCityAndRoleDTORoleName(city, role);
		UsersVO usersVO = new UsersVO();
		List<UserVO> userVOs = new ArrayList<>();
		if(userDTOs != null && !userDTOs.isEmpty()) {
			userDTOs.forEach(userDTO -> userVOs.add(getUserVOByDTO(userDTO)));
		}
		usersVO.setUserVOs(userVOs);
		return usersVO;
	}
}
