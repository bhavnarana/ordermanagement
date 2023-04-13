package com.ecommerce.application.ordermanagement.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDetails {
	private long orderId;
	private Date createdDate;
	private OrderStatus status;
	private double totalAmount;
	private List<ProductOrderDetails> orderProducts;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	public OrderDetails() {
		
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<ProductOrderDetails> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<ProductOrderDetails> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
