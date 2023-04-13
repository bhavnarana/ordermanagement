package com.ecommerce.application.ordermanagement.client.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.application.ordermanagement.client.kafka.JMSClient;

@Service
public class EmailClient {
	
	private JMSClient<EmailRequest> jmsClient;
	
	@Autowired
	public EmailClient(JMSClient<EmailRequest> jmsClient) {
		this.jmsClient = jmsClient;
	}

	public void sendEmail(EmailRequest emailRequest) {
		jmsClient.sendMessage(emailRequest);
	}
	
}
