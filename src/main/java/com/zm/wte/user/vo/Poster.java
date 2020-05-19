package com.zm.wte.user.vo;

public class Poster {
	private String userName;
	private String userImg;
	private String userGender;
	private String userPhone;
	private String userSign;
	
	public Poster(String userName, String userImg, String userGender, String userPhone, String userSign) {
		super();
		this.userName = userName;
		this.userImg = userImg;
		this.userGender = userGender;
		this.userPhone = userPhone;
		this.userSign = userSign;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserSign() {
		return userSign;
	}
	public void setUserSign(String userSign) {
		this.userSign = userSign;
	}
}
