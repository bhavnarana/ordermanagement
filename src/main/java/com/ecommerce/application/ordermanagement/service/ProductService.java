package com.ecommerce.application.ordermanagement.service;

import java.util.*;

import com.ecommerce.application.ordermanagement.entities.ProductOrderDetails;

public interface ProductService {
	
	List<ProductOrderDetails> getProductCatalog();
	ProductOrderDetails getProductById(long productId);
	
	
}
