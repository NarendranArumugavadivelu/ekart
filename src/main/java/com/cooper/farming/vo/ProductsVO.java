package com.cooper.farming.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductsVO {

	@JsonProperty("products")
	@Schema(description = "The list of products", type = "array")
	private List<ProductVO> productVOs;

	public List<ProductVO> getProductVOs() {
		return productVOs;
	}

	public void setProductVOs(List<ProductVO> productVOs) {
		this.productVOs = productVOs;
	}

	@Override
	public String toString() {
		return "ProductsVO [productVOs=" + productVOs + "]";
	}
	
	
}
