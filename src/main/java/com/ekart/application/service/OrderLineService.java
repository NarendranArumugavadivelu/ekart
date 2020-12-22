package com.ekart.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ekart.application.vo.OrderLineVO;

@Service
public interface OrderLineService {

	public List<OrderLineVO> createOrderLine(List<OrderLineVO> orderLineVOs, int orderId);
}
