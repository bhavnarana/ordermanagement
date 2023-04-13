package com.ecommerce.application.ordermanagement.entities;

import java.util.List;

public class ProductOrderDetails {

	private long id;
	private String title;
	private String description;
	private Category category;
	private double displayAmount;
	private List<String> imageUrl;
	private int quantity;
	private String thumbnail;
	
	public ProductOrderDetails() {
	}

	public ProductOrderDetails(long id, String title, String description, Category category, double displayAmount) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.category = category;
		this.displayAmount = displayAmount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public List<String> getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(List<String> imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getDisplayAmount() {
		return displayAmount;
	}

	public void setDisplayAmount(double displayAmount) {
		this.displayAmount = displayAmount;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
