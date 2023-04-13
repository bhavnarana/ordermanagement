package com.ecommerce.application.ordermanagement.client.product;

import java.util.List;

import com.ecommerce.application.ordermanagement.entities.Category;

public class ProductServiceResponse {
	private long productId;
	private String productName;
	private String productDescription;
	private List<String> productImages;
	private String thumbnail;
	private double baseAmount;
	private Category category;
	
	public ProductServiceResponse() {}

	public ProductServiceResponse(long productId, String productName, String productDescription,
			List<String> productImages, String thumbnail, double baseAmount, Category category) {
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productImages = productImages;
		this.thumbnail = thumbnail;
		this.baseAmount = baseAmount;
		this.category = category;
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
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public List<String> getProductImages() {
		return productImages;
	}
	public void setProductImages(List<String> productImages) {
		this.productImages = productImages;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public double getBaseAmount() {
		return baseAmount;
	}
	public void setBaseAmount(double baseAmount) {
		this.baseAmount = baseAmount;
	}

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
