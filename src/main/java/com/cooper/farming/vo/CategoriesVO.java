package com.cooper.farming.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoriesVO {

	@JsonProperty("categories")
	@Schema(description = "Category list", type = "array")
	private List<CategoryVO> categoryVOs;

	public List<CategoryVO> getCategoryVOs() {
		return categoryVOs;
	}

	public void setCategoryVOs(List<CategoryVO> categoryVOs) {
		this.categoryVOs = categoryVOs;
	}

	@Override
	public String toString() {
		return "CategoriesVO [categoryVOs=" + categoryVOs + "]";
	}
	
	
}
