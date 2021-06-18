package com.cooper.farming.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "categories")
public class CategoryDTO extends BaseDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private int categoryId;
	
	@Column(name = "category_name")
	private String categoryName;
	
	@OneToMany(mappedBy = "categoryDTO", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private Set<ItemDTO> itemDTOs;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Set<ItemDTO> getItemDTOs() {
		return itemDTOs;
	}

	public void setItemDTOs(Set<ItemDTO> itemDTOs) {
		this.itemDTOs = itemDTOs;
	}

	@Override
	public String toString() {
		return "CategoryDTO [categoryId=" + categoryId + ", categoryName=" + categoryName + ", itemDTOs=" + itemDTOs
				+ "]";
	}

	
}
