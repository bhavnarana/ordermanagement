package com.ecommerce.application.ordermanagement.entities;

public class ProductWiseBreakup {
	private long productId;
	
	private String productName;
	
	private FareDetails fareDetails;
	
	private int quantity;
	
	public ProductWiseBreakup() {}
	
	public ProductWiseBreakup(long productId, String productName, FareDetails fareDetails) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.fareDetails = fareDetails;
	}
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public FareDetails getFareDetails() {
		return fareDetails;
	}
	public void setFareDetails(FareDetails fareDetails) {
		this.fareDetails = fareDetails;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
