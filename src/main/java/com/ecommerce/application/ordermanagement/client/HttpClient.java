package com.ecommerce.application.ordermanagement.client;

import java.util.Map;

public interface HttpClient<R, T> {
	
	T httpGet(String url, Map<String, String> query, Map<String, String> headers);
	
	T httpPost(String url, R request, Map<String, String> headers);
}
