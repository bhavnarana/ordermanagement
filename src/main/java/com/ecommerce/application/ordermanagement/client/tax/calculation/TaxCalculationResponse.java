package com.ecommerce.application.ordermanagement.client.tax.calculation;

import java.util.Map;

public class TaxCalculationResponse {
	private Map<String, Double> taxComponents;
	private double totalTax;

	public Map<String, Double> getTaxComponents() {
		return taxComponents;
	}

	public void setTaxComponents(Map<String, Double> taxComponents) {
		this.taxComponents = taxComponents;
	}

	public double getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}
}
