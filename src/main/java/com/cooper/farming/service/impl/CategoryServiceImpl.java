package com.cooper.farming.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.cooper.farming.dto.CategoryDTO;
import com.cooper.farming.dto.ItemDTO;
import com.cooper.farming.exception.FarmingServiceException;
import com.cooper.farming.repository.CategoryRepository;
import com.cooper.farming.service.CategoryService;
import com.cooper.farming.service.FarmingValidationService;
import com.cooper.farming.vo.CategoriesVO;
import com.cooper.farming.vo.CategoryVO;
import com.cooper.farming.vo.ItemVO;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	private CategoryRepository categoryRepository;
	
	private FarmingValidationService farmingValidationService;
	
	public CategoryServiceImpl(CategoryRepository categoryRepository, FarmingValidationService farmingValidationService) {
		this.categoryRepository = categoryRepository;
		this.farmingValidationService = farmingValidationService;
	}

	@Override
	public CategoryVO createCategory(CategoryVO categoryVO) throws FarmingServiceException {
		farmingValidationService.validateCategory(categoryVO.getName());
		CategoryDTO categoryDTO = getCategoryDTOByVO(categoryVO);
		categoryDTO = categoryRepository.save(categoryDTO);
		return getCategoryVOByDTO(categoryDTO);
	}
	
	@Override
	public CategoriesVO getCategories() {
		CategoriesVO categoriesVO = new CategoriesVO();
		List<CategoryVO> categoryVOs = new ArrayList<>();
		Iterable<CategoryDTO> categoryIterable = categoryRepository.findAll();
		categoryIterable.forEach(categoryDTO -> categoryVOs.add(getCategoryVOByDTO(categoryDTO)));
		categoriesVO.setCategoryVOs(categoryVOs);
		return categoriesVO;
	}
	
	/**Method to get the category DTO by VO*/
	private CategoryDTO getCategoryDTOByVO(CategoryVO categoryVO) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setCategoryName(categoryVO.getName());
		return categoryDTO;
	}
	
	/**Method to get the category VO by DTO*/
	private CategoryVO getCategoryVOByDTO(CategoryDTO categoryDTO) {
		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setId(categoryDTO.getCategoryId());
		categoryVO.setName(categoryDTO.getCategoryName());
		Set<ItemDTO> itemDTOs = categoryDTO.getItemDTOs();
		List<ItemVO> itemVOs = new ArrayList<>();
		if(itemDTOs != null && !itemDTOs.isEmpty()) {
			itemDTOs.forEach(itemDTO -> {
				ItemVO itemVO = new ItemVO();
				itemVO.setId(itemDTO.getItemId());
				itemVO.setName(itemDTO.getItemName());
				itemVOs.add(itemVO);
			});
			categoryVO.setIetmVOs(itemVOs);
		}
		return categoryVO;
	}
}
