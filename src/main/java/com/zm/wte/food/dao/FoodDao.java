package com.zm.wte.food.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zm.wte.food.po.CookMethod;
import com.zm.wte.food.po.Food;
import com.zm.wte.food.po.FoodStyle;
import com.zm.wte.food.po.Taste;
import com.zm.wte.food.vo.CommentVo;
import com.zm.wte.food.vo.FoodForm;
import com.zm.wte.food.vo.FoodVo;

@Mapper
public interface FoodDao {

	List<FoodVo> getAllFoods();
	
	List<FoodVo> searchFood(String message);
	
	int delF(Integer foodID);
	
	List<Food> getMyPost(Integer userID);

	List<Food> getMyFavorite(Integer userID);

	List<Food> getMyCollect(Integer userID);
	
	int addFood(Food food);
	
	int getNum(Integer userID);
	
	FoodVo getFood(Integer foodID);
	
	List<FoodVo> getTypeFood(String type);
	
	List<FoodVo> searchTypeFood(@Param("type")String type, @Param("message")String message);
	
	List<Food> getTopThree(String foodType);
	
	List<FoodVo> getStyleFood(@Param("type")String type, @Param("styleID")Integer styleID);
	
	List<FoodVo> getMethodFood(@Param("type")String type, @Param("methodID")Integer methodID);
	
	List<FoodVo> getTasteFood(@Param("type")String type, @Param("tasteID")Integer tasteID);
	
	List<FoodVo> getTimeFood(String foodType);
	
	List<FoodVo> getPopulorFood(String foodType);
	
	List<FoodVo> getPriceFood(String foodType);

	int cancelFavo(@Param("userID")Integer userID, @Param("foodID")Integer foodID);
	
	int cancelColl(@Param("userID")Integer userID, @Param("foodID")Integer foodID);
	
	int addFavorite(@Param("userID")Integer userID, @Param("foodID")Integer foodID);

	int addCollect(@Param("userID")Integer userID, @Param("foodID")Integer foodID);
	
	List<FoodVo> getCityFood(@Param("foodType")String foodType, @Param("city")String city);
	
	int addScore(@Param("userID")Integer userID, @Param("foodID")Integer foodID, @Param("score")Float score);
	
	int getFavorite(@Param("userID")Integer userID, @Param("foodID")Integer foodID);

	int getCollect(@Param("userID")Integer userID, @Param("foodID")Integer foodID);

	int getReview(@Param("userID")Integer userID, @Param("foodID")Integer foodID);
	
	int getPoint(@Param("userID")Integer userID, @Param("foodID")Integer foodID);
	
	List<FoodVo> getPosterFood(Integer userID);
	
	int addComment(@Param("userID")Integer userID, @Param("foodID")Integer foodID, @Param("comment")String comment);
	
	List<CommentVo> getComment(Integer foodID);
	
	int getStyleID(String foodStyle);
	int getTasteID(String taste);
	int getMethodID(String cookMethod);
	String getStyle(Integer styleID);
	String getTaste(Integer tasteID);
	String getMethod(Integer methodID);
	List<FoodStyle> getStyleList();
	List<Taste> getTasteList();
	List<CookMethod> getMethodList();
}
