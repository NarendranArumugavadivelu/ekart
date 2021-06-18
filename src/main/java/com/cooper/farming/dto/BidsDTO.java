package com.cooper.farming.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "bids")
public class BidsDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bid_id")
	private int bidId;
	
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private ProductDTO productDTO;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private UserDTO userDTO;
	
	@Column(name = "amount")
	private int amount;
	
	@Column(name = "status")
	private String status;

	public int getBidId() {
		return bidId;
	}

	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

	public ProductDTO getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BidsDTO [bidId=" + bidId + ", productDTO=" + productDTO + ", userDTOs=" + userDTO + ", amount="
				+ amount + "]";
	}

	
}
