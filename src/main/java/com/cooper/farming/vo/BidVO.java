package com.cooper.farming.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class BidVO {
	
	@JsonProperty("bid_id")
	@Schema(description = "The bid id for a product", type = "integer")
	private int bidId;
	
	@JsonProperty("product_id")
	@Schema(description = "The product id for the bid", type = "integer")
	private int productId;
	
	@JsonProperty("product_name")
	@Schema(description = "The name of the product", type = "string")
	private String productName;
	
	@JsonProperty("user_id")
	@Schema(description = "The user id of the product", type = "integer")
	private int userId;

	@JsonProperty("user_name")
	@Schema(description = "The name of the user bidden", type = "string")
	private String username;
	
	@JsonProperty("first_name")
	@Schema(description = "The first name of the user bidden", type = "string")
	private String firstName;
	
	@JsonProperty("last_name")
	@Schema(description = "The last name of the user bidden", type = "string")
	private String lastName;
	
	@JsonProperty("amount")
	@Schema(description = "The amount bidden", type = "integer")
	private int amount;
	
	@JsonProperty("email_id")
	@Schema(description = "The email id of the user", type = "string")
	private String emailId;
	
	@JsonProperty("phone_number")
	@Schema(description = "The phone number of the user", type = "long")
	private String phoneNumber;
	
	@JsonProperty("address")
	@Schema(description = "The door number of the user", type = "string")
	private String address;
	
	@JsonProperty("city")
	@Schema(description = "The living city of the user", type = "string")
	private String city;
	
	@JsonProperty("zip_code")
	@Schema(description = "The zip code of the user", type = "string")
	private String zipCode;
	
	@JsonProperty("status")
	@Schema(description = "The bid status", type = "string")
	private String status;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public int getBidId() {
		return bidId;
	}

	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BidVO [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", amount="
				+ amount + ", emailId=" + emailId + ", phoneNumber=" + phoneNumber + ", address=" + address + ", city="
				+ city + ", zipCode=" + zipCode + "]";
	}

}
