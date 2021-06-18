package com.cooper.farming.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemVO {

	@JsonProperty("id")
	@Schema(description = "Item ID", type = "integer")
	private int id;
	
	@JsonProperty("name")
	@Schema(description = "Item Name", type = "string")
	@NotBlank(message = "{item.name.notBlank}")
	private String name;
	
	@JsonProperty("category_name")
	@Schema(description = "Category name of item", type = "String")
	private String categoryName;
	
	@JsonProperty("category_id")
	@Schema(description = "Category id of item", type = "String")
	@Min(value = 1, message = "{category.id.min}")
	private Integer categoryId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "ItemVO [id=" + id + ", name=" + name + ", categoryName=" + categoryName + ", categoryId=" + categoryId
				+ "]";
	}
	
	
}
