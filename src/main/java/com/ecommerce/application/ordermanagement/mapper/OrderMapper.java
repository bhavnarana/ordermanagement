package com.ecommerce.application.ordermanagement.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.ecommerce.application.ordermanagement.client.order.OrderServiceRequest;
import com.ecommerce.application.ordermanagement.entities.FareDetails;
import com.ecommerce.application.ordermanagement.entities.OrderDetails;
import com.ecommerce.application.ordermanagement.entities.ProductOrderDetails;
import com.ecommerce.application.ordermanagement.entities.ProductWiseBreakup;

public class OrderMapper {
	public static OrderDetails getOrderDetails(OrderServiceRequest orderServiceRequest) {
		if(orderServiceRequest == null) {
			return null;
		}
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setOrderId(orderServiceRequest.getOrderId());
		orderDetails.setCreatedDate(orderServiceRequest.getCreatedDate());
		orderDetails.setStatus(orderServiceRequest.getStatus());
		orderDetails.setTotalAmount(orderServiceRequest.getTotalAmount());
		List<ProductOrderDetails> productList = orderServiceRequest.getProductDetailsList().stream().map(OrderMapper::getProductDetails).collect(Collectors.toList());
		orderDetails.setOrderProducts(productList);
		return orderDetails;
	}
	
	public static ProductOrderDetails getProductDetails(ProductWiseBreakup productWiseBreakup) {
		ProductOrderDetails product = new ProductOrderDetails();
		product.setId(productWiseBreakup.getProductId());
		product.setQuantity(productWiseBreakup.getQuantity());
		FareDetails fareDetails = productWiseBreakup.getFareDetails();
		product.setDisplayAmount(fareDetails.getBaseFare() + fareDetails.getTotalTaxAmount() - fareDetails.getDiscount());
		product.setTitle(productWiseBreakup.getProductName());
		return product;
	}
}
