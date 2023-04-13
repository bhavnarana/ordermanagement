package com.ecommerce.application.ordermanagement.client.tax.calculation;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.application.ordermanagement.client.HttpClient;
import com.ecommerce.application.ordermanagement.client.RestClient;
import com.ecommerce.application.ordermanagement.controller.OrderController;

@Service
public class TaxCalculationClient {
	private String url;
	private HttpClient<TaxCalculationRequest, TaxCalculationResponse> httpClient;
	private static final Logger LOGGER = LogManager.getLogger(TaxCalculationClient.class);
	
	@Autowired
	public TaxCalculationClient(RestClient<TaxCalculationRequest, TaxCalculationResponse> httpClient) {
		this.httpClient = httpClient;
	}
	
	public TaxCalculationResponse calculateTax(TaxCalculationRequest request) {
		//return httpClient.httpPost(url, request, null);
		LOGGER.info("Starting tax computation");
		TaxCalculationResponse taxCalculationResponse = new TaxCalculationResponse();
		Map<String, Double> taxComponents = new HashMap<>();
		taxComponents.put("CGST", request.getBaseAmount() * 0.09);
		taxComponents.put("SGST", request.getBaseAmount() * 0.09);
		taxCalculationResponse.setTaxComponents(taxComponents);
		taxCalculationResponse.setTotalTax(request.getBaseAmount() * 0.18);
		LOGGER.info("Tax computation completed successfully");
		return taxCalculationResponse;
	}
	
}

