package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="users")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_email")
	private String userEmail;
	
	@Column(name="user_mobile_number")
	private Long userMobileNumber;
	
	@Column(name="user_password")
	private String userPassword;
	
	@Column(name="user_address")
	private String userAddress;
	
	
	@Column(name="user_pin_code")
	private String userPinCode;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public Long getUserMobileNumber() {
		return userMobileNumber;
	}


	public void setUserMobileNumber(Long userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getUserAddress() {
		return userAddress;
	}


	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}


	public String getUserPinCode() {
		return userPinCode;
	}


	public void setUserPinCode(String userPinCode) {
		this.userPinCode = userPinCode;
	}


	public UserEntity(Long id, String userName, String userEmail, Long userMobileNumber, String userPassword,
			String userAddress, String userPinCode) {
		super();
		this.id = id;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userMobileNumber = userMobileNumber;
		this.userPassword = userPassword;
		this.userAddress = userAddress;
		this.userPinCode = userPinCode;
	}


	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", userName=" + userName + ", userEmail=" + userEmail + ", userMobileNumber="
				+ userMobileNumber + ", userPassword=" + userPassword + ", userAddress=" + userAddress
				+ ", userPinCode=" + userPinCode + "]";
	}

	
	
	
}
