package com.ekart.application;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ekart.application.service.OrderService;
import com.ekart.application.vo.OrderLineVO;
import com.ekart.application.vo.OrderVO;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTest {

	@Autowired
	private OrderService orderService;
	
	@Test
	/**Test to create an order with order lines*/
	public void shouldCreateOrderAndOrderLine() {
		OrderVO orderVO = new OrderVO();
		//Create order lines
		OrderLineVO orderLineVO = new OrderLineVO(); 
		orderLineVO.setProductId(1);
		orderLineVO.setProductName("Cadbury");
		orderLineVO.setQuantity(50); 
		//Add order lines to order
		List<OrderLineVO> orderLineVOs = new ArrayList<>();
		orderLineVOs.add(orderLineVO);
		orderVO.setOrderLineVOs(orderLineVOs);
		//Mock the service
		OrderVO savedOrderVO = orderService.createOrder(orderVO);
		Assert.assertNotEquals(0, savedOrderVO.getOrderId());
		Assert.assertEquals(1, savedOrderVO.getOrderLineVOs().size());
	}
	
	@Test
	/**Test to create order and order lines with products greater than available quantity
	 * The transaction should not be rolled back even in one of the product is not available*/
	public void shouldCreateOrderAndOrderLineWithInsufficientQuantity() {
		OrderVO orderVO = new OrderVO();
		//Create order lines
		OrderLineVO orderLineVO = new OrderLineVO(); 
		orderLineVO.setProductId(1);
		orderLineVO.setProductName("Cadbury");
		orderLineVO.setQuantity(50000);
		OrderLineVO orderLineVO2 = new OrderLineVO(); 
		orderLineVO2.setProductId(1);
		orderLineVO2.setProductName("Gummy Bears");
		orderLineVO2.setQuantity(100);
		//Add order lines to order
		List<OrderLineVO> orderLineVOs = new ArrayList<>();
		orderLineVOs.add(orderLineVO);
		orderLineVOs.add(orderLineVO2);
		orderVO.setOrderLineVOs(orderLineVOs);
		//Mock the service
		OrderVO savedOrderVO = orderService.createOrder(orderVO);
		Assert.assertNotEquals(0, savedOrderVO.getOrderId());
		Assert.assertEquals(1, savedOrderVO.getOrderLineVOs().size());
	}
	
}
