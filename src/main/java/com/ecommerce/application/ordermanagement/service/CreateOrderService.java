package com.ecommerce.application.ordermanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.application.ordermanagement.client.email.EmailClient;
import com.ecommerce.application.ordermanagement.client.email.EmailRequest;
import com.ecommerce.application.ordermanagement.client.order.OrderServiceClient;
import com.ecommerce.application.ordermanagement.client.order.OrderServiceRequest;
import com.ecommerce.application.ordermanagement.client.order.OrderServiceResponse;
import com.ecommerce.application.ordermanagement.client.product.ProductServiceClient;
import com.ecommerce.application.ordermanagement.client.product.ProductServiceResponse;
import com.ecommerce.application.ordermanagement.client.tax.calculation.TaxCalculationClient;
import com.ecommerce.application.ordermanagement.client.tax.calculation.TaxCalculationRequest;
import com.ecommerce.application.ordermanagement.client.tax.calculation.TaxCalculationResponse;
import com.ecommerce.application.ordermanagement.entities.Address;
import com.ecommerce.application.ordermanagement.entities.FareDetails;
import com.ecommerce.application.ordermanagement.entities.OrderRequest;
import com.ecommerce.application.ordermanagement.entities.PaymentCheckoutResponse;
import com.ecommerce.application.ordermanagement.entities.ProductDetails;
import com.ecommerce.application.ordermanagement.entities.ProductWiseBreakup;
import com.ecommerce.application.ordermanagement.entities.TaxComponents;

@Service
public class CreateOrderService {
	
	private final TaxCalculationClient taxCalculationClient;
	
	private final OrderServiceClient orderServiceClient;
	
	private final ProductServiceClient productServiceClient;
	
	private final EmailClient emailClient;
	
	private static final Logger LOGGER = LogManager.getLogger(CreateOrderService.class);
	
	@Autowired
	public CreateOrderService(TaxCalculationClient taxCalculationClient, OrderServiceClient orderServiceClient, ProductServiceClient productServiceClient, EmailClient emailClient) {
		this.taxCalculationClient = taxCalculationClient;
		this.orderServiceClient = orderServiceClient;
		this.productServiceClient = productServiceClient;
		this.emailClient = emailClient;
	}

	public PaymentCheckoutResponse createOrder(OrderRequest orderRequest) {
		LOGGER.info("Starting [createOrder]");
		try {
			PaymentCheckoutResponse paymentCheckoutResponse = new PaymentCheckoutResponse();
			List<ProductWiseBreakup> productDetailsList = new ArrayList<>();
			double totalAmount = 0;
			for(ProductDetails productDetails: orderRequest.getProductDetails()) {
				ProductServiceResponse productServiceResponse = productServiceClient.getProductDetails(productDetails.getProductId());
				if(productServiceResponse == null) {
					return null;
				}
				TaxCalculationRequest taxCalculationRequest = 
						new TaxCalculationRequest.Builder()
						.baseAmount(productServiceResponse.getBaseAmount())
						.billingAddress(orderRequest.getBillingAddress())
						.quantity(productDetails.getQuantity())
						.build();
				TaxCalculationResponse taxCalculationResponse = taxCalculationClient.calculateTax(taxCalculationRequest);
				ProductWiseBreakup productWiseBreakup = getProductWiseBreakup(productServiceResponse, taxCalculationResponse, orderRequest.getBillingAddress(), productDetails);
				productDetailsList.add(productWiseBreakup);
				totalAmount += (productWiseBreakup.getFareDetails().getBaseFare()  + productWiseBreakup.getFareDetails().getTotalTaxAmount() - productWiseBreakup.getFareDetails().getDiscount()) * productDetails.getQuantity();
			}
			
			OrderServiceRequest orderServiceRequest = new OrderServiceRequest(productDetailsList, orderRequest.getUserInfo(), orderRequest.getShippingAddress(), orderRequest.getBillingAddress(), totalAmount);
			OrderServiceResponse orderServiceResponse = orderServiceClient.createOrder(orderServiceRequest);
			
			paymentCheckoutResponse.setPaymentCheckoutUrl(orderServiceResponse.getPaymentCheckoutUrl());
			paymentCheckoutResponse.setOrderId(orderServiceResponse.getOrderId());
			paymentCheckoutResponse.setAmountBreakup(productDetailsList);
			paymentCheckoutResponse.setTotalAmount(totalAmount);
			sendEmail(orderServiceRequest);
			return paymentCheckoutResponse;
		} catch(Exception ex) {
			LOGGER.error("Exception "+ex.getStackTrace()+" encountered in [createOrder]");
			throw ex;
		}
	}

	private void sendEmail(OrderServiceRequest orderServiceRequest) {
		LOGGER.info("Starting to send email");
		try
		{
			EmailRequest emailRequest = new EmailRequest();
			emailRequest.setEmailId(orderServiceRequest.getUserInfo().getEmailId());
			emailRequest.setOrderDetails(orderServiceRequest);
		}
		catch(Exception ex)
		{
			LOGGER.error("Exception "+ex.getStackTrace()+" encountered in [sendEmail]");
			throw ex;
		}
		LOGGER.info("Email sent successfully");
	}

	private ProductWiseBreakup getProductWiseBreakup(ProductServiceResponse productServiceResponse,
			TaxCalculationResponse taxCalculationResponse, Address billingAddress, ProductDetails productDetails) {
		LOGGER.info("Getting the product wise breakup");
		try
		{
			ProductWiseBreakup productWiseBreakup = new ProductWiseBreakup();
			TaxComponents taxComponents = new TaxComponents(billingAddress.getCountry(), billingAddress.getCity(), billingAddress.getPincode(), taxCalculationResponse.getTaxComponents());
			FareDetails fareDetails = new FareDetails(productServiceResponse.getBaseAmount(), 0, taxCalculationResponse.getTotalTax(), taxComponents);
			productWiseBreakup.setFareDetails(fareDetails);
			productWiseBreakup.setProductId(productServiceResponse.getProductId());
			productWiseBreakup.setProductName(productServiceResponse.getProductName());
			productWiseBreakup.setQuantity(productDetails.getQuantity());
			return productWiseBreakup;
		}
		catch(Exception ex)
		{
			LOGGER.error("Exception "+ex.getStackTrace()+" encountered in [getProductWiseBreakup]");
			throw ex;
		}
	}
}

