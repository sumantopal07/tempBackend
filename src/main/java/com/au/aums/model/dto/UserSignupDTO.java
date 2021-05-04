package com.au.aums.model.dto;

import java.util.List;


public class UserSignupDTO {
	private String signupEmail;
	private String signupPassword;
	private String signupGoogleId;
	private String signupToken;
	/**
	 * @return the signupEmail
	 */
	public String getSignupEmail() {
		return this.signupEmail;
	}
	/**
	 * @param signupEmail the signupEmail to set
	 */
	public void setSignupEmail(String signupEmail) {
		this.signupEmail = signupEmail;
	}
	/**
	 * @return the signupPassword
	 */
	public String getSignupPassword() {
		return signupPassword;
	}
	/**
	 * @param signupPassword the signupPassword to set
	 */
	public void setSignupPassword(String signupPassword) {
		this.signupPassword = signupPassword;
	}
	/**
	 * @return the signupGoogleId
	 */
	public String getSignupGoogleId() {
		return signupGoogleId;
	}
	/**
	 * @param signupGoogleId the signupGoogleId to set
	 */
	public void setSignupGoogleId(String signupGoogleId) {
		this.signupGoogleId = signupGoogleId;
	}
	/**
	 * @return the signupToken
	 */
	public String getSignupToken() {
		return signupToken;
	}
	/**
	 * @param signupToken the signupToken to set
	 */
	public void setSignupToken(String signupToken) {
		this.signupToken = signupToken;
	}

	
	
	
}
