package com.zm.wte.food.po;

public class Review {
	
	private Integer revID;
	private Integer userID;
	private Integer foodID;
	private Float revScore;
	
	public Integer getRevID() {
		return revID;
	}
	public void setRevID(Integer revID) {
		this.revID = revID;
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
	public Float getRevScore() {
		return revScore;
	}
	public void setRevScore(Float revScore) {
		this.revScore = revScore;
	}

}
