package com.au.aums.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	private String email;
	private String password;
	private String googleId;
	private String token;
	public User(int userId, String email, String password, String googleId, String token) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.googleId = googleId;
		this.token = token;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the googleId
	 */
	public String getGoogleId() {
		return googleId;
	}
	/**
	 * @param googleId the googleId to set
	 */
	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

}
