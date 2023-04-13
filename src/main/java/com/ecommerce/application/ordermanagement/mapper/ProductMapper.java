package com.ecommerce.application.ordermanagement.mapper;

import com.ecommerce.application.ordermanagement.client.product.ProductServiceResponse;
import com.ecommerce.application.ordermanagement.entities.ProductOrderDetails;

public class ProductMapper {

	public static ProductOrderDetails getProduct(ProductServiceResponse productServiceResponse) {
		if(productServiceResponse == null)
		{
			return null;
		}
		ProductOrderDetails product = new ProductOrderDetails();
		product.setId(productServiceResponse.getProductId());
		product.setTitle(productServiceResponse.getProductName());
		product.setDescription(productServiceResponse.getProductDescription());
		product.setCategory(productServiceResponse.getCategory());
		product.setDisplayAmount(productServiceResponse.getBaseAmount());
		product.setImageUrl(productServiceResponse.getProductImages());
		product.setThumbnail(productServiceResponse.getThumbnail());
		return product;
	}
	
	public static void updateProduct(ProductOrderDetails product, ProductServiceResponse productServiceResponse) {
		product.setCategory(productServiceResponse.getCategory());
		product.setImageUrl(productServiceResponse.getProductImages());
		product.setThumbnail(productServiceResponse.getThumbnail());
		product.setDescription(productServiceResponse.getProductDescription());
	}
}
