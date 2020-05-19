package com.zm.wte.food.po;

import java.util.Date;

import com.zm.wte.food.vo.FoodForm;

public class Food {

	private Integer foodID;
	private String foodName;
	private String foodImg;
	private String foodType;
	private Integer styleID;
	private Integer tasteID;
	private Integer methodID;
	private Float score;
	private Float price;
	private String province;
	private String city;
	private String address;
	private String description;
	private Date postTime;
	private Integer userID;
	
	public Food() {}
	
	public Food(FoodForm form) {
		this.foodID=form.getFoodID();
		this.foodName=form.getFoodName();
		this.foodType=form.getFoodType();
		this.score=form.getScore();
		this.price=form.getPrice();
		this.province=form.getProvince();
		this.city=form.getCity();
		this.address=form.getAddress();
		this.description=form.getDescription();
		this.postTime=form.getPostTime();
		this.userID=form.getUserID();
	}
	
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
	public String getFoodImg() {
		return foodImg;
	}
	public void setFoodImg(String foodImg) {
		this.foodImg = foodImg;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public Integer getStyleID() {
		return styleID;
	}

	public void setStyleID(Integer styleID) {
		this.styleID = styleID;
	}

	public Integer getTasteID() {
		return tasteID;
	}

	public void setTasteID(Integer tasteID) {
		this.tasteID = tasteID;
	}

	public Integer getMethodID() {
		return methodID;
	}

	public void setMethodID(Integer methodID) {
		this.methodID = methodID;
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
