package com.ecommerce.application.ordermanagement.client.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.application.ordermanagement.client.HttpClient;
import com.ecommerce.application.ordermanagement.client.RestClient;
import com.ecommerce.application.ordermanagement.entities.OrderStatus;

@Service
public class OrderServiceClient {
	private String url;
	private HttpClient<OrderServiceRequest, OrderServiceResponse> httpClient;
	private Map<Long, OrderServiceRequest> orderDetails;
	private long incrementalId;
	private static String CHECKOUT_URL = "https://domain/checkout/%s";
	
	@Autowired
	public OrderServiceClient(RestClient<OrderServiceRequest, OrderServiceResponse> httpClient) {
		this.httpClient = httpClient;
		incrementalId = 1;
		orderDetails = new HashMap<>();
	}
	
	public OrderServiceResponse createOrder(OrderServiceRequest request) {
		//return httpClient.httpPost(url, request, null);
		OrderServiceResponse orderServiceResponse = new OrderServiceResponse(String.format(CHECKOUT_URL, incrementalId), incrementalId);
		request.setOrderId(incrementalId);
		request.setCreatedDate(new Date());
		request.setStatus(OrderStatus.Created);
		orderDetails.put(incrementalId, request);
		incrementalId++;
		return orderServiceResponse;
	}
	
	public List<OrderServiceRequest> getAllOrders() {
		return new ArrayList<>(orderDetails.values());
	}
	
	public OrderServiceRequest getOrderById(long orderId) {
		return orderDetails.get(orderId);
	}
}
