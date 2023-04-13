package com.ecommerce.application.ordermanagement.entities;

import java.util.List;
import java.util.UUID;

public class PaymentCheckoutResponse {
	private String paymentCheckoutUrl;
	private long orderId;
	private double totalAmount;
	private List<ProductWiseBreakup> amountBreakup;
	
	public PaymentCheckoutResponse(String paymentCheckoutUrl, long orderId, double totalAmount, List<ProductWiseBreakup> amountBreakup) {
		this.paymentCheckoutUrl = paymentCheckoutUrl;
		this.orderId = orderId;
		this.totalAmount = totalAmount;
		this.amountBreakup = amountBreakup;
	}
	
	public PaymentCheckoutResponse() {}
	
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

	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public List<ProductWiseBreakup> getAmountBreakup() {
		return amountBreakup;
	}
	public void setAmountBreakup(List<ProductWiseBreakup> amountBreakup) {
		this.amountBreakup = amountBreakup;
	}
}
