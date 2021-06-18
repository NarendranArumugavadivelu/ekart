package com.cooper.farming.vo;

import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductVO {

	@JsonProperty("product_id")
	@Schema(description = "Product ID", type = "integer")
	private int productId;
	
	@JsonProperty("user_id")
	@Schema(description = "Product posted by user id", type = "integer")
	@Min(value = 1, message = "{postedBy.min}")
	private int userId;
	
	@JsonProperty("user_name")
	@Schema(description = "Product posted by user name", type = "string")
	private String userName;
	
	@JsonProperty("item_id")
	@Schema(description = "Item id posted", type = "integer")
	@Min(value = 1, message = "{itemId.min}")
	private int itemId;
	
	@JsonProperty("item_name")
	@Schema(description = "Item name posted", type = "string")
	private String itemName;
	
	@JsonProperty("quantity")
	@Schema(description = "Quantity available", type = "integer")
	@Min(value = 1, message = "{quantity.min}")
	private int quantity;
	
	@JsonProperty("base_price")
	@Schema(description = "Base price per kilogram", type = "number")
	@Min(value = 1, message = "{basePricePerKg.min}")
	private float basePricePerKg;
	
	@JsonProperty("ends_on")
	@Schema(description = "The date and time on which bid ends", type = "string", format = "date-time", example = "2020-12-31T21:05")
	private String bidEndsOn;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getBasePricePerKg() {
		return basePricePerKg;
	}

	public void setBasePricePerKg(float basePricePerKg) {
		this.basePricePerKg = basePricePerKg;
	}

	public String getBidEndsOn() {
		return bidEndsOn;
	}

	public void setBidEndsOn(String bidEndsOn) {
		this.bidEndsOn = bidEndsOn;
	}

	@Override
	public String toString() {
		return "ProductVO [productId=" + productId + ", userId=" + userId + ", userName=" + userName + ", itemId="
				+ itemId + ", itemName=" + itemName + ", quantity=" + quantity + ", basePricePerKg=" + basePricePerKg
				+ ", bidEndsOn=" + bidEndsOn + "]";
	}

	

	
}
