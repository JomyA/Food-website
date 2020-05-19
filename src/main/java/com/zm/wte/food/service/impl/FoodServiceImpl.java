package com.zm.wte.food.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zm.wte.common.constant;
import com.zm.wte.food.dao.FoodDao;
import com.zm.wte.food.po.CookMethod;
import com.zm.wte.food.po.Food;
import com.zm.wte.food.po.FoodStyle;
import com.zm.wte.food.po.Taste;
import com.zm.wte.food.service.FoodService;
import com.zm.wte.food.vo.CommentVo;
import com.zm.wte.food.vo.FoodForm;
import com.zm.wte.food.vo.FoodVo;
import com.zm.wte.manager.po.Manager;

@Service
public class FoodServiceImpl implements FoodService{

	@Autowired
	private FoodDao foodDao;
	
	@Override
	public List<FoodVo> getAllFoods() {
		return foodDao.getAllFoods();
	}

	@Override
	public List<FoodVo> searchFood(String message) {
		return foodDao.searchFood(message);
	}

	@Override
	public int delF(Integer foodID) {
		return foodDao.delF(foodID);
	}

	@Override
	public List<Food> getMyPost(Integer userID) {
		return foodDao.getMyPost(userID);
	}

	@Override
	public List<Food> getMyFavorite(Integer userID) {
		return foodDao.getMyFavorite(userID);
	}

	@Override
	public List<Food> getMyCollect(Integer userID) {
		return foodDao.getMyCollect(userID);
	}

	@Override
	public int getNum(Integer userID) {
		return foodDao.getNum(userID);
	}
	
	@Override
	public int addFood(FoodForm foodForm) {
		Food food = new Food(foodForm);
		int styleID=foodDao.getStyleID(foodForm.getFoodStyle());
		food.setStyleID(styleID);
		int tasteID=foodDao.getTasteID(foodForm.getTaste());
		food.setTasteID(tasteID);
		int methodID=foodDao.getMethodID(foodForm.getCookMethod());
		food.setMethodID(methodID);
		MultipartFile img = foodForm.getFoodImg();
		String name = img.getOriginalFilename();//文件名
		String suffix = name.substring(name.lastIndexOf(".")); //文件的后缀名
		int num=getNum(food.getUserID())+1;
		String foodImg = food.getUserID()+""+num+suffix;
		String filepath = constant.pathF+foodImg;
		File imgFile = new File(filepath);//指定路径创建用户上传的文件
		food.setFoodImg(foodImg);
		try {
			img.transferTo(imgFile); //上传图片
			int result = foodDao.addFood(food); 
			if (result == 1) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public FoodVo getFood(Integer foodID) {
		return foodDao.getFood(foodID);
	}

	@Override
	public List<FoodVo> getTypeFood(String type) {
		return foodDao.getTypeFood(type);
	}

	@Override
	public List<FoodVo> searchTypeFood(String type, String message) {
		return foodDao.searchTypeFood(type, message);
	}

	@Override
	public List<Food> getTopThree(String foodType) {
		return foodDao.getTopThree(foodType);
	}

	@Override
	public List<FoodVo> getStyleFood(String type, String foodStyle) {
		int styleID=foodDao.getStyleID(foodStyle);
		return foodDao.getStyleFood(type, styleID);
	}

	@Override
	public List<FoodVo> getMethodFood(String type, String cookMethod) {
		int methodID=foodDao.getMethodID(cookMethod);
		return foodDao.getMethodFood(type, methodID);
	}

	@Override
	public List<FoodVo> getTasteFood(String type, String taste) {
		int tasteID=foodDao.getTasteID(taste);
		return foodDao.getTasteFood(type, tasteID);
	}

	@Override
	public List<FoodVo> getTimeFood(String foodType) {
		return foodDao.getTimeFood(foodType);
	}

	@Override
	public List<FoodVo> getPopulorFood(String foodType) {
		return foodDao.getPopulorFood(foodType);
	}

	@Override
	public List<FoodVo> getPriceFood(String foodType) {
		return foodDao.getPriceFood(foodType);
	}

	@Override
	public int cancelFavo(Integer userID, Integer foodID) {
		return foodDao.cancelFavo(userID, foodID);
	}

	@Override
	public int cancelColl(Integer userID, Integer foodID) {
		return foodDao.cancelColl(userID, foodID);
	}

	@Override
	public int addFavorite(Integer userID, Integer foodID) {
		return foodDao.addFavorite(userID, foodID);
	}

	@Override
	public int addCollect(Integer userID, Integer foodID) {
		return foodDao.addCollect(userID, foodID);
	}

	@Override
	public List<FoodVo> getCityFood(String foodType, String city) {
		return foodDao.getCityFood(foodType, city);
	}

	@Override
	public int addScore(Integer userID, Integer foodID, Float score) {
		return foodDao.addScore(userID, foodID, score);
	}

	@Override
	public int getFavorite(Integer userID, Integer foodID) {
		return foodDao.getFavorite(userID, foodID);
	}

	@Override
	public int getCollect(Integer userID, Integer foodID) {
		return foodDao.getCollect(userID, foodID);
	}

	@Override
	public int getReview(Integer userID, Integer foodID) {
		return foodDao.getReview(userID, foodID);
	}

	@Override
	public List<FoodVo> getPosterFood(Integer userID) {
		return foodDao.getPosterFood(userID);
	}

	@Override
	public int getPoint(Integer userID, Integer foodID) {
		return foodDao.getPoint(userID, foodID);
	}

	@Override
	public int addComment(Integer userID, Integer foodID, String comment) {
		return foodDao.addComment(userID, foodID, comment);
	}

	@Override
	public List<CommentVo> getComment(Integer foodID) {
		return foodDao.getComment(foodID);
	}

	@Override
	public List<FoodStyle> getStyleList() {
		return foodDao.getStyleList();
	}

	@Override
	public List<Taste> getTasteList() {
		return foodDao.getTasteList();
	}

	@Override
	public List<CookMethod> getMethodList() {
		return foodDao.getMethodList();
	}

	@Override
	public String getStyle(Integer styleID) {
		return foodDao.getStyle(styleID);
	}

	@Override
	public String getTaste(Integer tasteID) {
		return foodDao.getTaste(tasteID);
	}

	@Override
	public String getMethod(Integer methodID) {
		return foodDao.getMethod(methodID);
	}

}
