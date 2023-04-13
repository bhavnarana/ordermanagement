package com.ecommerce.application.ordermanagement.entities;

import java.util.Map;

public class TaxComponents {
	private String country;
	private String city;
	private String pincode;
	private Map<String, Double> taxComponents;
	
	public TaxComponents(String country, String city, String pincode,
			Map<String, Double> taxComponents) {
		super();
		this.country = country;
		this.city = city;
		this.pincode = pincode;
		this.taxComponents = taxComponents;
	}
	
	public TaxComponents() {
		super();
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	public Map<String, Double> getTaxComponents() {
		return taxComponents;
	}

	public void setTaxComponents(Map<String, Double> taxComponents) {
		this.taxComponents = taxComponents;
	}
}
