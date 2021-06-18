package com.cooper.farming.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class RatingVO {

	@JsonProperty("rating_id")
	@Schema(description = "The id of the rating", type = "integer")
	private int ratingId;
	
	@JsonProperty("timely_delivery")
	@Schema(description = "The timely delivery of the product", type = "string")
	private String onTimeDelivery;
	
	@JsonProperty("product_quality")
	@Schema(description = "The product quality", type = "string")
	private String productQuality;
	
	@JsonProperty("payment_history")
	@Schema(description = "The payment history of the retailer", type = "string")
	private String paymentHistory;
	
	@JsonProperty("overall_rating")
	@Schema(description = "The overall rating of the user", type = "integer")
	private int overallRating;

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public String getOnTimeDelivery() {
		return onTimeDelivery;
	}

	public void setOnTimeDelivery(String onTimeDelivery) {
		this.onTimeDelivery = onTimeDelivery;
	}

	public String getProductQuality() {
		return productQuality;
	}

	public void setProductQuality(String productQuality) {
		this.productQuality = productQuality;
	}

	public String getPaymentHistory() {
		return paymentHistory;
	}

	public void setPaymentHistory(String paymentHistory) {
		this.paymentHistory = paymentHistory;
	}

	public int getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(int overallRating) {
		this.overallRating = overallRating;
	}

	@Override
	public String toString() {
		return "RatingVO [ratingId=" + ratingId + ", onTimeDelivery=" + onTimeDelivery + ", productQuality="
				+ productQuality + ", paymentHistory=" + paymentHistory + ", overallRating=" + overallRating + "]";
	}
	
	
}
