package com.zm.wte.food.po;

import java.util.Date;

public class Collect {
	
	private Integer collID;
	private Integer userID;
	private Integer foodID;
	private Date collTime;
	
	public Integer getCollID() {
		return collID;
	}
	public void setCollID(Integer collID) {
		this.collID = collID;
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
	public Date getCollTime() {
		return collTime;
	}
	public void setCollTime(Date collTime) {
		this.collTime = collTime;
	}

}
