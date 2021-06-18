package com.cooper.farming.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cooper.farming.dto.CategoryDTO;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryDTO, Integer>{

	public CategoryDTO findByCategoryName(String categoryName);
}
