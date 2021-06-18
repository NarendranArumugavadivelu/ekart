package com.cooper.farming.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "items")
public class ItemDTO extends BaseDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "item_name")
	private String itemName;
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private CategoryDTO categoryDTO;
	
	@OneToMany(mappedBy = "itemDTO", fetch = FetchType.LAZY)
	private Set<ProductDTO> productDTOs;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public CategoryDTO getCategoryDTO() {
		return categoryDTO;
	}

	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}
	
	public Set<ProductDTO> getProductDTOs() {
		return productDTOs;
	}

	public void setProductDTOs(Set<ProductDTO> productDTOs) {
		this.productDTOs = productDTOs;
	}

	@Override
	public String toString() {
		return "ItemDTO [itemId=" + itemId + ", itemName=" + itemName + ", categoryDTO=" + categoryDTO
				+ ", productDTOs=" + productDTOs + "]";
	}

	
	
}
