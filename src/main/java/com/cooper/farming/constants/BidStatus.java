package com.cooper.farming.constants;

public enum BidStatus {

	PENDING("Pending"), ACCEPTED("Accepted"), REJECTED("Rejected");
	
	private String status;

	BidStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
	
}
