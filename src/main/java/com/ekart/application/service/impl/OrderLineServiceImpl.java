package com.ekart.application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ekart.application.dto.OrderDTO;
import com.ekart.application.dto.OrderLineDTO;
import com.ekart.application.dto.ProductDTO;
import com.ekart.application.exception.InsufficientQuantityException;
import com.ekart.application.repository.OrderLineRepository;
import com.ekart.application.repository.OrderRepository;
import com.ekart.application.repository.ProductRepository;
import com.ekart.application.service.OrderLineService;
import com.ekart.application.vo.OrderLineVO;

@Service
public class OrderLineServiceImpl implements OrderLineService {
	
	public static final Logger logger = LoggerFactory.getLogger(OrderLineServiceImpl.class); 
	
	private OrderRepository orderRepository;
	
	private ProductRepository productRepository;
	
	private OrderLineRepository orderLineRepository;
	
	public OrderLineServiceImpl(OrderRepository orderRepository, ProductRepository productRepository, OrderLineRepository orderLineRepository) {
		this.orderRepository = orderRepository;
		this.productRepository = productRepository;
		this.orderLineRepository = orderLineRepository;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	/**Create order lines for an order and product. In case of insufficient quantity for a product, exception is logged and transaction would be carried out for other products*/
	public List<OrderLineVO> createOrderLine(List<OrderLineVO> orderLineVOs, int orderId) {
		OrderDTO orderDTO = orderRepository.findById(orderId).orElse(null);
		List<OrderLineDTO> orderLineDTOs = new ArrayList<>();
		orderLineVOs.forEach(orderLineVO -> {
			try {
				orderLineDTOs.add(getOrderLineDTOByVO(orderLineVO, orderDTO));
			} catch (InsufficientQuantityException e) {
				logger.error(e.getMessage());
			}
		});
		List<OrderLineVO> savedOrderLines = new ArrayList<>();
		Iterable<OrderLineDTO> orderLineIterables = orderLineRepository.saveAll(orderLineDTOs);
		orderLineIterables.forEach(orderLineDTO -> savedOrderLines.add(getOrderLineVOByDTO(orderLineDTO)));
		return savedOrderLines;
	}
	
	/**Method to get the value object by data transfer object*/
	private OrderLineVO getOrderLineVOByDTO(OrderLineDTO orderLineDTO) {
		OrderLineVO orderLineVO = new OrderLineVO();
		orderLineVO.setOrderId(orderLineDTO.getOrderDTO().getOrderId());
		orderLineVO.setOrderLineId(orderLineDTO.getOrderLineId());
		orderLineVO.setProductId(orderLineDTO.getProductDTO().getProductId());
		orderLineVO.setProductName(orderLineDTO.getProductDTO().getProductName());
		orderLineVO.setQuantity(orderLineDTO.getQuantity());
		return orderLineVO;
	}
	
	/**Method to get the data transfer object by value object 
	 * @throws InsufficientQuantityException */
	private OrderLineDTO getOrderLineDTOByVO(OrderLineVO orderLineVO, OrderDTO orderDTO) throws InsufficientQuantityException {
		ProductDTO productDTO = productRepository.findById(orderLineVO.getProductId()).orElse(null);
		if(productDTO != null && productDTO.getAvailableQuantity() < orderLineVO.getQuantity()) {
			throw new InsufficientQuantityException("Insufficient quantity for the product : " + productDTO.getProductName());
		}
		OrderLineDTO orderLineDTO = new OrderLineDTO();
		orderLineDTO.setOrderDTO(orderDTO);
		orderLineDTO.setProductDTO(productDTO);
		orderLineDTO.setQuantity(orderLineVO.getQuantity());
		return orderLineDTO;
	}

}
