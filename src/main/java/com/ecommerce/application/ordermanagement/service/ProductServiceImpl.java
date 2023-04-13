package com.ecommerce.application.ordermanagement.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.application.ordermanagement.client.product.ProductServiceClient;
import com.ecommerce.application.ordermanagement.entities.ProductOrderDetails;
import com.ecommerce.application.ordermanagement.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductServiceClient productServiceClient;
	
	@Autowired
	public ProductServiceImpl(ProductServiceClient productServiceClient) {
		this.productServiceClient = productServiceClient;
	}

	@Override
	public List<ProductOrderDetails> getProductCatalog() {
		return productServiceClient.getAllProducts().stream().map(ProductMapper::getProduct).toList();
	}

	@Override
	public ProductOrderDetails getProductById(long productId) {
		return ProductMapper.getProduct(productServiceClient.getProductDetails(productId));
	}
	
}
