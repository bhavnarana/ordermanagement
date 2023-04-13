package com.ecommerce.application.ordermanagement.models;

import java.util.Date;
import java.util.List;

import com.ecommerce.application.ordermanagement.entities.OrderStatus;

public class OrderModel {
	private long orderId;
	private List<OrderDetailsModel> itemsList;
	private double totalAmount;
	private Date createdDate;
	private OrderStatus status;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public List<OrderDetailsModel> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<OrderDetailsModel> itemsList) {
		this.itemsList = itemsList;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
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
	
}
