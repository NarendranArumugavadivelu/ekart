package com.cooper.farming.service.impl;

import java.text.MessageFormat;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooper.farming.constants.Constants;
import com.cooper.farming.dto.CategoryDTO;
import com.cooper.farming.dto.UserDTO;
import com.cooper.farming.exception.FarmingServiceException;
import com.cooper.farming.repository.CategoryRepository;
import com.cooper.farming.repository.UserRepository;
import com.cooper.farming.service.FarmingValidationService;
import com.cooper.farming.vo.ErrorVO;

@Service
public class FarmingValidationServiceImpl implements FarmingValidationService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Properties errorProperties;
	
	public FarmingValidationServiceImpl(CategoryRepository categoryRepository, UserRepository userRepository, Properties errorProperties) {
		this.categoryRepository = categoryRepository;
		this.userRepository = userRepository;
		this.errorProperties = errorProperties;
	}

	@Override
	public void validateCategory(String categoryName) throws FarmingServiceException {
		CategoryDTO categoryDTO = categoryRepository.findByCategoryName(categoryName);
		if(categoryDTO != null) {
			throwFarmingServiceException(Constants.CATEGORY_ALREADY_EXISTS, categoryName);
		}
	}
	
	@Override
	public void validateUsername(String userName) throws FarmingServiceException {
		UserDTO userDTO = userRepository.findByUserName(userName);
		if(userDTO != null) {
			throwFarmingServiceException(Constants.USER_ALREADY_EXISTS, userName);
		}
	}
	
	/**Method to throw the service exception*/
	private void throwFarmingServiceException(String code, Object ... arguments) throws FarmingServiceException {
		String message = errorProperties.getProperty(code);
		if(arguments != null && arguments.length > 0) {
			message = MessageFormat.format(message, arguments);
		}
		ErrorVO errorVO = new ErrorVO();
		errorVO.setErrorCode(code);
		errorVO.setErrorMessage(message);
		throw new FarmingServiceException(message, errorVO);
	}
}
