package com.cooper.farming.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class BidsVO {

	@JsonProperty("bids")
	@Schema(description = "The list of bids", type = "array")
	private List<BidVO> bidVOs;

	public List<BidVO> getBidVOs() {
		return bidVOs;
	}

	public void setBidVOs(List<BidVO> bidVOs) {
		this.bidVOs = bidVOs;
	}

	@Override
	public String toString() {
		return "BidsVO [bidVOs=" + bidVOs + "]";
	}
	
	
}

