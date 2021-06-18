package com.cooper.farming.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class RatingsVO {

	@JsonProperty("ratings")
	@Schema(description = "The ratings of a user", type = "array")
	private List<RatingVO> ratingVOs;

	public List<RatingVO> getRatingVOs() {
		return ratingVOs;
	}

	public void setRatingVOs(List<RatingVO> ratingVOs) {
		this.ratingVOs = ratingVOs;
	}

	@Override
	public String toString() {
		return "RatingsVO [ratingVOs=" + ratingVOs + "]";
	}
	
	
}
