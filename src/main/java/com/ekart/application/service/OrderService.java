package com.ekart.application.service;

import org.springframework.stereotype.Service;

import com.ekart.application.vo.OrderVO;

@Service
public interface OrderService {

	public OrderVO createOrder(OrderVO orderVO);
	
}
