package com.cooper.farming.dto;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "products")
public class ProductDTO extends BaseDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private UserDTO userDTO;
	
	@ManyToOne
	@JoinColumn(name = "item_id", nullable = false)
	private ItemDTO itemDTO;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "base_price")
	private float basePrice;
	
	@Column(name = "ends_on")
	private LocalDateTime bidEndsOn;
	
	@OneToMany(mappedBy = "productDTO", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private Set<BidsDTO> bidsDTO;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public ItemDTO getItemDTO() {
		return itemDTO;
	}

	public void setItemDTO(ItemDTO itemDTO) {
		this.itemDTO = itemDTO;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}

	public LocalDateTime getBidEndsOn() {
		return bidEndsOn;
	}

	public void setBidEndsOn(LocalDateTime bidEndsOn) {
		this.bidEndsOn = bidEndsOn;
	}
	
	public Set<BidsDTO> getBidsDTO() {
		return bidsDTO;
	}

	public void setBidsDTO(Set<BidsDTO> bidsDTO) {
		this.bidsDTO = bidsDTO;
	}

	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", userDTO=" + userDTO + ", itemDTO=" + itemDTO + ", quantity="
				+ quantity + ", basePrice=" + basePrice + ", bidEndsOn=" + bidEndsOn + ", bidsDTO=" + bidsDTO + "]";
	}

	
}
