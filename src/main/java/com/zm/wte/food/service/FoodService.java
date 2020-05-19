package com.zm.wte.food.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zm.wte.food.po.CookMethod;
import com.zm.wte.food.po.Food;
import com.zm.wte.food.po.FoodStyle;
import com.zm.wte.food.po.Taste;
import com.zm.wte.food.vo.CommentVo;
import com.zm.wte.food.vo.FoodForm;
import com.zm.wte.food.vo.FoodVo;

public interface FoodService {

	List<FoodVo> getAllFoods();

	List<FoodVo> searchFood(String message);

	int delF(Integer foodID);

	List<Food> getMyPost(Integer userID);

	List<Food> getMyFavorite(Integer userID);

	List<Food> getMyCollect(Integer userID);

	int addFood(FoodForm foodForm);

	int getNum(Integer userID);

	FoodVo getFood(Integer foodID);

	List<FoodVo> getTypeFood(String type);

	List<FoodVo> searchTypeFood(String type, String message);

	List<Food> getTopThree(String foodType);

	List<FoodVo> getStyleFood(String type, String foodStyle);

	List<FoodVo> getMethodFood(String type, String cookMethod);

	List<FoodVo> getTasteFood(String type, String taste);

	List<FoodVo> getTimeFood(String foodType);

	List<FoodVo> getPopulorFood(String foodType);

	List<FoodVo> getPriceFood(String foodType);

	int cancelFavo(Integer userID, Integer foodID);

	int cancelColl(Integer userID, Integer foodID);

	int addFavorite(Integer userID, Integer foodID);

	int addCollect(Integer userID, Integer foodID);

	List<FoodVo> getCityFood(String foodType, String city);

	int addScore(Integer userID, Integer foodID, Float score);

	int getFavorite(Integer userID, Integer foodID);

	int getCollect(Integer userID, Integer foodID);

	int getReview(Integer userID, Integer foodID);

	List<FoodVo> getPosterFood(Integer userID);

	int getPoint(Integer userID, Integer foodID);

	int addComment(Integer userID, Integer foodID, String comment);
	
	List<CommentVo> getComment(Integer foodID);
	
	List<FoodStyle> getStyleList();
	List<Taste> getTasteList();
	List<CookMethod> getMethodList();
	String getStyle(Integer styleID);
	String getTaste(Integer tasteID);
	String getMethod(Integer methodID);

}
