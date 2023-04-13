package com.ecommerce.application.ordermanagement.service;

import com.ecommerce.application.ordermanagement.entities.OrderDetails;
import com.ecommerce.application.ordermanagement.entities.OrderRequest;
import com.ecommerce.application.ordermanagement.entities.PaymentCheckoutResponse;

public interface OrderService {

	OrderDetails getOrderById(long orderId);
	PaymentCheckoutResponse createOrder(OrderRequest orderRequest);
}
