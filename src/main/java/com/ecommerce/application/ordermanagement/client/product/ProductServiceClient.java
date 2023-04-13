package com.ecommerce.application.ordermanagement.client.product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.application.ordermanagement.client.HttpClient;
import com.ecommerce.application.ordermanagement.client.RestClient;
import com.ecommerce.application.ordermanagement.entities.Category;

@Service
public class ProductServiceClient {
	private String url;
	private HttpClient<String, ProductServiceResponse> httpClient;
	
	static Map<Long, ProductServiceResponse> productDetails;
	
	static {
		productDetails = new HashMap<>();
		productDetails.put(1L, new ProductServiceResponse(1L, "p1", "desc1", Arrays.asList("image1", "image2"), "thumb1", 100.0, Category.ELECTRONICS));
		productDetails.put(2L, new ProductServiceResponse(2L, "p2", "desc2", Arrays.asList("image1"), "thumb2", 150.0, Category.BOOKS));
		productDetails.put(3L, new ProductServiceResponse(3L, "p3", "desc3", Arrays.asList("image1"), "thumb3", 200.0, Category.FITNESS));
	}
	
	@Autowired
	public ProductServiceClient(RestClient<String, ProductServiceResponse> httpClient) {
		this.httpClient = httpClient;
	}
	
	public ProductServiceResponse getProductDetails(long productId) {
//		Map<String, String> query = new HashMap<>();
//		query.put("productId", Long.toString(productId));
//		return httpClient.httpGet(url, query, null);
		return productDetails.get(productId);
	}
	
	public List<ProductServiceResponse> getAllProducts() {
		return new ArrayList<>(productDetails.values());
	}
}
