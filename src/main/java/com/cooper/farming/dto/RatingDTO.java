package com.cooper.farming.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "ratings")
public class RatingDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rating_id")
	private int ratingId;
	
	@Column(name = "timely_delivery")
	private String onTimeDelivery;
	
	@Column(name = "product_quality")
	private String productQuality;
	
	@Column(name = "payment_history")
	private String paymentHistory;
	
	@Column(name = "overall_rating")
	private int overallRating;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private UserDTO userDTO;

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

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	
	public int getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(int overallRating) {
		this.overallRating = overallRating;
	}

	@Override
	public String toString() {
		return "RatingDTO [ratingId=" + ratingId + ", onTimeDelivery=" + onTimeDelivery + ", productQuality="
				+ productQuality + ", paymentHistory=" + paymentHistory + ", overallRating=" + overallRating
				+ ", userDTO=" + userDTO + "]";
	}

	
}
