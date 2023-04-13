package com.ecommerce.application.ordermanagement.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.application.ordermanagement.entities.ProductOrderDetails;
import com.ecommerce.application.ordermanagement.service.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	private final ProductService productService;
	private static final Logger LOGGER = LogManager.getLogger(ProductController.class);
	
	@Autowired
	public ProductController(ProductService productService)
	{
		this.productService = productService;
	}
	
	@GetMapping(value = "/{productId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ProductOrderDetails getProductDetails(@PathVariable long productId) {
		LOGGER.info("[getProductDetails] called");
		return productService.getProductById(productId);
	}
	
	@GetMapping(value = "/catalog", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<ProductOrderDetails> getProductCatalog() {
		LOGGER.info("[getProductDetails] called");
		return productService.getProductCatalog();
	}
}
