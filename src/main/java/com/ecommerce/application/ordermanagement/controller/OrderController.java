package com.ecommerce.application.ordermanagement.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.application.ordermanagement.entities.OrderDetails;
import com.ecommerce.application.ordermanagement.entities.OrderRequest;
import com.ecommerce.application.ordermanagement.entities.PaymentCheckoutResponse;
import com.ecommerce.application.ordermanagement.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	private final OrderService orderService;
	private static final Logger LOGGER = LogManager.getLogger(OrderController.class);
	
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping(value = "/compute", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public PaymentCheckoutResponse computeOrderDetails(@RequestBody OrderRequest orderRequest)
	{
		LOGGER.info("[computeOrderDetails] called");
		return orderService.createOrder(orderRequest);
	}
	
	@GetMapping(value = "/{orderId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public OrderDetails getProductDetails(@PathVariable long orderId) {
		LOGGER.info("[getProductDetails] called");
		return orderService.getOrderById(orderId);
	}

}
