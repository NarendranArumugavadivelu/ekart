package com.ekart.application.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ekart.application.dto.OrderDTO;
import com.ekart.application.exception.InsufficientQuantityException;
import com.ekart.application.repository.OrderRepository;
import com.ekart.application.service.OrderLineService;
import com.ekart.application.service.OrderService;
import com.ekart.application.vo.OrderLineVO;
import com.ekart.application.vo.OrderVO;

@Service
public class OrderServiceImpl implements OrderService {
	
	private OrderRepository orderRepository;
	
	private OrderLineService orderLineService;
	
	public OrderServiceImpl(OrderRepository orderRepository, OrderLineService orderLineService) {
		this.orderRepository = orderRepository;
		this.orderLineService = orderLineService;
	}

	@Override
	@Transactional(dontRollbackOn = InsufficientQuantityException.class)
	public OrderVO createOrder(OrderVO orderVO) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setCreateAt(LocalDateTime.now());
		orderDTO = orderRepository.save(orderDTO);
		List<OrderLineVO> orderLineVOs = orderLineService.createOrderLine(orderVO.getOrderLineVOs(), orderDTO.getOrderId());
		orderVO.setOrderLineVOs(orderLineVOs);
		orderVO.setOrderId(orderDTO.getOrderId());
		return orderVO;
	}


}
