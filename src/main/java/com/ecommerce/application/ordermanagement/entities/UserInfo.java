package com.ecommerce.application.ordermanagement.entities;

public class UserInfo {
	private String userName;
	private String mobileNumber;
	private String emailId;
	
	public UserInfo(String userName, String mobileNumber, String emailId) {
		super();
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}	
}
