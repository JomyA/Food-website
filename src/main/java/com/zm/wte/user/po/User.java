package com.zm.wte.user.po;

import com.zm.wte.user.vo.UserForm;

public class User {

	private Integer userID;
	private String userPass;
	private String userName;
	private String userImg;
	private String userGender;
	private String userPhone;
	private String userSign;
	
	public User() {}
	
	public User(UserForm form) {
		this.userID=form.getUserID();
		this.userName=form.getAccount();
		this.userPass=form.getPassword();
		this.userGender=form.getGender();
		this.userPhone=form.getPhone();
		this.userSign=form.getUserSign();
	}
	
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
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
