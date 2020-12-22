package com.ekart.application.dto;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "orders")
public class OrderDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int orderId;
	
	@Column(name = "created_At")
	private LocalDateTime createAt;
	
	@OneToMany(mappedBy = "orderDTO", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private Set<OrderLineDTO> orderLineDTOs;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public Set<OrderLineDTO> getOrderLineDTOs() {
		return orderLineDTOs;
	}

	public void setOrderLineDTOs(Set<OrderLineDTO> orderLineDTOs) {
		this.orderLineDTOs = orderLineDTOs;
	}
}
