package com.ecommerce.application.ordermanagement.client.email;

import com.ecommerce.application.ordermanagement.client.order.OrderServiceRequest;

public class EmailRequest {
	private String emailId;
	private OrderServiceRequest orderDetails;
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public OrderServiceRequest getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(OrderServiceRequest orderDetails) {
		this.orderDetails = orderDetails;
	}
}
