package com.cooper.farming.service;

import org.springframework.stereotype.Service;

import com.cooper.farming.exception.FarmingServiceException;

@Service
public interface FarmingValidationService {

	public void validateCategory(String categoryName) throws FarmingServiceException;
	
	public void validateUsername(String username) throws FarmingServiceException;
}
