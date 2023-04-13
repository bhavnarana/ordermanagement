package com.ecommerce.application.ordermanagement.models;

public class OrderDetailsModel {
	private int productId;
	private double amount;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
