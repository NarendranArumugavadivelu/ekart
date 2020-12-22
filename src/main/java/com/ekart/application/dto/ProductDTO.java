package com.ekart.application.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "products")
public class ProductDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@OneToMany(mappedBy = "productDTO", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private Set<OrderLineDTO> orderLineDTOs;
	
	@Column(name = "available_quantity")
	private int availableQuantity;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Set<OrderLineDTO> getOrderLineDTOs() {
		return orderLineDTOs;
	}

	public void setOrderLineDTOs(Set<OrderLineDTO> orderLineDTOs) {
		this.orderLineDTOs = orderLineDTOs;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	
	
	
}
