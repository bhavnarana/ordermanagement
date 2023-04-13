package com.ecommerce.application.ordermanagement.client;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class SoapClient<R, T> implements HttpClient<R, T> {
	
	@Override
	public T httpGet(String url, Map<String, String> headers, Map<String, String> query) {
		return null;
	}
	
	@Override
	public T httpPost(String url, R request, Map<String, String> headers) {
		return null;
	}
}
