package com.cooper.farming.service;

import org.springframework.stereotype.Service;

import com.cooper.farming.exception.FarmingServiceException;
import com.cooper.farming.vo.CategoriesVO;
import com.cooper.farming.vo.CategoryVO;

@Service
public interface CategoryService {

	public CategoryVO createCategory(CategoryVO categoryVO) throws FarmingServiceException;
	
	public CategoriesVO getCategories();
}
