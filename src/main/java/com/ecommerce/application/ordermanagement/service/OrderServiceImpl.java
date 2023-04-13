package com.ecommerce.application.ordermanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.application.ordermanagement.client.order.OrderServiceClient;
import com.ecommerce.application.ordermanagement.client.order.OrderServiceRequest;
import com.ecommerce.application.ordermanagement.client.product.ProductServiceClient;
import com.ecommerce.application.ordermanagement.client.product.ProductServiceResponse;
import com.ecommerce.application.ordermanagement.entities.OrderDetails;
import com.ecommerce.application.ordermanagement.entities.OrderRequest;
import com.ecommerce.application.ordermanagement.entities.PaymentCheckoutResponse;
import com.ecommerce.application.ordermanagement.entities.ProductOrderDetails;
import com.ecommerce.application.ordermanagement.mapper.OrderMapper;
import com.ecommerce.application.ordermanagement.mapper.ProductMapper;

@Service
public class OrderServiceImpl implements OrderService {

	private final ProductServiceClient productServiceClient;
	private final OrderServiceClient orderServiceClient;
	private final CreateOrderService createOrderService;
	private static final Logger LOGGER = LogManager.getLogger(OrderServiceImpl.class);
	
	@Autowired
	public OrderServiceImpl(ProductServiceClient productServiceClient, OrderServiceClient orderServiceClient, CreateOrderService createOrderService) {
		this.productServiceClient = productServiceClient;
		this.orderServiceClient = orderServiceClient;
		this.createOrderService = createOrderService;
	}

	@Override
	public OrderDetails getOrderById(long orderId) {
		LOGGER.info("Getting Order by Id");
		try
		{
			OrderServiceRequest order = orderServiceClient.getOrderById(orderId);
			
			OrderDetails orderDetails = OrderMapper.getOrderDetails(order);
			if(orderDetails == null) {
				return orderDetails;
			}
			
			List<ProductOrderDetails> itemsList = new ArrayList<>();
			
			for(ProductOrderDetails product: orderDetails.getOrderProducts()) {
				ProductServiceResponse productModel = productServiceClient.getProductDetails(product.getId());
				ProductMapper.updateProduct(product, productModel);
				itemsList.add(product);
			}
			
			orderDetails.setOrderProducts(itemsList);
		
			LOGGER.info("Fetched "+itemsList.size()+" items for the order request");
			return orderDetails;
		}
		catch(Exception ex)
		{
			LOGGER.error("Exception "+ex.getStackTrace()+" encountered in [getOrderById]");
			throw ex;
		}
	}

	@Override
	public PaymentCheckoutResponse createOrder(OrderRequest orderRequest) {
		return createOrderService.createOrder(orderRequest);
	}
}


