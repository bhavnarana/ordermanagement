package com.ecommerce.application.ordermanagement.client.tax.calculation;

import com.ecommerce.application.ordermanagement.entities.Address;

public class TaxCalculationRequest {
	private double baseAmount;
	private int quantity;
	private Address billingAddress;
	
	public TaxCalculationRequest(Builder builder) {
		this.baseAmount = builder.baseAmount;
		this.billingAddress = builder.billingAddress;
		this.quantity = builder.quantity;
	}
	
	public TaxCalculationRequest() {}
	
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public double getBaseAmount() {
		return baseAmount;
	}

	public void setBaseAmount(double baseAmount) {
		this.baseAmount = baseAmount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public static class Builder {
		private double baseAmount;
		private int quantity;
		private Address billingAddress;
		
		public Builder() {}

		public Builder baseAmount(double baseAmount) {
			this.baseAmount = baseAmount;
			return this;
		}
		
		public Builder quantity(int quantity) {
			this.quantity = quantity;
			return this;
		}
		
		public Builder billingAddress(Address billingAddress) {
			this.billingAddress = billingAddress;
			return this;
		}
		
		public TaxCalculationRequest build() {
			return new TaxCalculationRequest(this);
		}
	}
}
