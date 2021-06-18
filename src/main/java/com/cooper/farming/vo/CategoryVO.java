package com.cooper.farming.vo;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryVO {

	@JsonProperty("id")
	@Schema(description = "Category ID", type = "integer")
	private int id;
	
	@JsonProperty("name")
	@Schema(description = "Category Name", type = "string")
	@NotBlank(message = "{category.name.notBlank}")
	private String name;
	
	@JsonProperty("items")
	@Schema(description = "Items of the category", type = "array")
	private List<ItemVO> ietmVOs;

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

	public List<ItemVO> getIetmVOs() {
		return ietmVOs;
	}

	public void setIetmVOs(List<ItemVO> ietmVOs) {
		this.ietmVOs = ietmVOs;
	}

	@Override
	public String toString() {
		return "CategoryVO [id=" + id + ", name=" + name + ", ietmVOs=" + ietmVOs + "]";
	}
	
	
	
}
