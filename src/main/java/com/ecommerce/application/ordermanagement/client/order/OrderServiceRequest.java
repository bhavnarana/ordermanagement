package com.ecommerce.application.ordermanagement.client.order;

import java.util.Date;
import java.util.List;

import com.ecommerce.application.ordermanagement.entities.Address;
import com.ecommerce.application.ordermanagement.entities.OrderStatus;
import com.ecommerce.application.ordermanagement.entities.ProductWiseBreakup;
import com.ecommerce.application.ordermanagement.entities.UserInfo;

public class OrderServiceRequest {
	private long orderId;
	private Date createdDate;
	private OrderStatus status;
	private List<ProductWiseBreakup> productDetailsList;
	private UserInfo userInfo;
	private Address shippingAddress;
	private Address billingAddress;
	private double totalAmount;

	public OrderServiceRequest() {}

	public OrderServiceRequest(List<ProductWiseBreakup> productDetailsList, UserInfo userInfo, Address shippingAddress,
			Address billingAddress, double totalAmount) {
		this.productDetailsList = productDetailsList;
		this.userInfo = userInfo;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
		this.totalAmount = totalAmount;
	}

	public List<ProductWiseBreakup> getProductDetailsList() {
		return productDetailsList;
	}

	public void setProductDetailsList(List<ProductWiseBreakup> productDetailsList) {
		this.productDetailsList = productDetailsList;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
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

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
