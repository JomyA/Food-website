package com.zm.wte.food.po;

import java.util.Date;

public class Favorite {

	private Integer favID;
	private Integer userID;
	private Integer foodID;
	private Date favTime;
	
	public Integer getFavID() {
		return favID;
	}
	public void setFavID(Integer favID) {
		this.favID = favID;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getFoodID() {
		return foodID;
	}
	public void setFoodID(Integer foodID) {
		this.foodID = foodID;
	}
	public Date getFavTime() {
		return favTime;
	}
	public void setFavTime(Date favTime) {
		this.favTime = favTime;
	}
	
}
