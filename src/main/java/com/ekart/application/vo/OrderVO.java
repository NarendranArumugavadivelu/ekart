package com.ekart.application.vo;

import java.util.List;

public class OrderVO {

	private int orderId;
	
	private String createdAt;
	
	private List<OrderLineVO> orderLineVOs;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public List<OrderLineVO> getOrderLineVOs() {
		return orderLineVOs;
	}

	public void setOrderLineVOs(List<OrderLineVO> orderLineVOs) {
		this.orderLineVOs = orderLineVOs;
	}
	
	
}
