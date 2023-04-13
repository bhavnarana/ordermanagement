package com.ecommerce.application.ordermanagement.entities;

public class FareDetails {
	private double baseFare;
	private double discount;
	private double totalTaxAmount;
	private TaxComponents taxComponents;
	
	public FareDetails() {}

	public FareDetails(double baseFare, double discount, double totalTaxAmount, TaxComponents taxComponents) {
		super();
		this.baseFare = baseFare;
		this.discount = discount;
		this.totalTaxAmount = totalTaxAmount;
		this.taxComponents = taxComponents;
	}

	public double getBaseFare() {
		return baseFare;
	}

	public void setBaseFare(double baseFare) {
		this.baseFare = baseFare;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTotalTaxAmount() {
		return totalTaxAmount;
	}

	public void setTotalTaxAmount(double totalTaxAmount) {
		this.totalTaxAmount = totalTaxAmount;
	}

	public TaxComponents getTaxComponents() {
		return taxComponents;
	}

	public void setTaxComponents(TaxComponents taxComponents) {
		this.taxComponents = taxComponents;
	}
}
