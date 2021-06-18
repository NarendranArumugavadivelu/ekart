package com.cooper.farming.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemsVO {

	@JsonProperty("items")
	@Schema(description = "The list of items", type = "array")
	private List<ItemVO> itemsVOs;

	public List<ItemVO> getItemsVOs() {
		return itemsVOs;
	}

	public void setItemsVOs(List<ItemVO> itemsVOs) {
		this.itemsVOs = itemsVOs;
	}

	@Override
	public String toString() {
		return "ItemsVO [itemsVOs=" + itemsVOs + "]";
	}
	
	
}
