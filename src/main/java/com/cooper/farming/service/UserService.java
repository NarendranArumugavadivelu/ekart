package com.cooper.farming.service;

import org.springframework.stereotype.Service;

import com.cooper.farming.dto.UserDTO;
import com.cooper.farming.exception.FarmingServiceException;
import com.cooper.farming.vo.UserVO;
import com.cooper.farming.vo.UsersVO;

@Service
public interface UserService {

	public UserVO createUser(UserVO userVO) throws FarmingServiceException;
	
	public UserDTO getUserById(int userId) throws FarmingServiceException;
	
	public UserVO getUserByNameAndPassword(String username, String password) throws FarmingServiceException;
	
	public UsersVO getUsersByCityAndRole(String city, String role);
	
}
