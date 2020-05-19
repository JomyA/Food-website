package com.zm.wte.food.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class FoodForm {
	
	private Integer foodID;
	private String foodName;
	private MultipartFile foodImg;
	private String foodType;
	private String foodStyle;
	private String taste;
	private String cookMethod;
	private Float score;
	private Float price;
	private String province;
	private String city;
	private String address;
	private String description;
	private Date postTime;
	private Integer userID;
	
	public Integer getFoodID() {
		return foodID;
	}
	public void setFoodID(Integer foodID) {
		this.foodID = foodID;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public MultipartFile getFoodImg() {
		return foodImg;
	}
	public void setFoodImg(MultipartFile foodImg) {
		this.foodImg = foodImg;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public String getFoodStyle() {
		return foodStyle;
	}
	public void setFoodStyle(String foodStyle) {
		this.foodStyle = foodStyle;
	}
	public String getTaste() {
		return taste;
	}
	public void setTaste(String taste) {
		this.taste = taste;
	}
	public String getCookMethod() {
		return cookMethod;
	}
	public void setCookMethod(String cookMethod) {
		this.cookMethod = cookMethod;
	}
	public Float getScore() {
		return score;
	}
	public void setScore(Float score) {
		this.score = score;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getPostTime() {
		return postTime;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}

}
