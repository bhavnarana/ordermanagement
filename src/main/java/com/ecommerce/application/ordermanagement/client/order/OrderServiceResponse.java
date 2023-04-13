package com.ecommerce.application.ordermanagement.client.order;

public class OrderServiceResponse {
	private String paymentCheckoutUrl;
	private long orderId;

	public OrderServiceResponse() {}

	public OrderServiceResponse(String paymentCheckoutUrl, long orderId) {
		this.paymentCheckoutUrl = paymentCheckoutUrl;
		this.orderId = orderId;
	}

	public String getPaymentCheckoutUrl() {
		return paymentCheckoutUrl;
	}

	public void setPaymentCheckoutUrl(String paymentCheckoutUrl) {
		this.paymentCheckoutUrl = paymentCheckoutUrl;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	
}
