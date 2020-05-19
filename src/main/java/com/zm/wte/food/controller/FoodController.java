package com.zm.wte.food.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zm.wte.common.BaseController;
import com.zm.wte.common.constant;
import com.zm.wte.food.po.CookMethod;
import com.zm.wte.food.po.Food;
import com.zm.wte.food.po.FoodStyle;
import com.zm.wte.food.po.Taste;
import com.zm.wte.food.service.FoodService;
import com.zm.wte.food.vo.FoodForm;
import com.zm.wte.food.vo.FoodVo;
import com.zm.wte.user.vo.Poster;

@Controller
@RequestMapping("/food")
public class FoodController extends BaseController{
	
	@RequestMapping("/addFood")
	public String addFood(FoodForm foodForm,HttpSession session) {
		Integer userID=(Integer) session.getAttribute("UserID");
		foodForm.setUserID(userID);
		int result=foodService.addFood(foodForm);
		if (result==1){
			return "postSuccess";
		}
		return "postSuccess";
	}
	
	@RequestMapping("/getImg/{img}")
	public void getImg(@PathVariable("img") String img,HttpServletResponse response)
			throws IOException {
		FileInputStream fis = null;
		OutputStream os = null;
		try {
			fis = new FileInputStream(constant.pathF+img);
			os = response.getOutputStream();
			int count = 0;
			byte[] buffer = new byte[1024 * 8];
			while ((count = fis.read(buffer)) != -1) {
				os.write(buffer, 0, count);
				os.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping("/location/breakfast/{city}")
	public String getBCFood(@PathVariable("city") String city,Model model) {
		List<FoodVo> cityFood=foodService.getCityFood(constant.BREAKFAST,city);
		model.addAttribute("breakfast", cityFood);
		List<Food> topFood=foodService.getTopThree(constant.BREAKFAST);
		model.addAttribute("topFood", topFood);
		addModel(model);
		return "breakfast";
	}
	
	@RequestMapping("/location/lunch/{city}")
	public String getLCFood(@PathVariable("city") String city,Model model) {
		List<FoodVo> cityFood=foodService.getCityFood(constant.LUNCH,city);
		model.addAttribute("lunch", cityFood);
		List<Food> topFood=foodService.getTopThree(constant.LUNCH);
		model.addAttribute("topFood", topFood);
		addModel(model);
		return "lunch";
	}
	
	@RequestMapping("/location/snack/{city}")
	public String getSCFood(@PathVariable("city") String city,Model model) {
		List<FoodVo> cityFood=foodService.getCityFood(constant.SNACK,city);
		model.addAttribute("snack", cityFood);
		List<Food> topFood=foodService.getTopThree(constant.SNACK);
		model.addAttribute("topFood", topFood);
		addModel(model);
		return "snack";
	}
	
	@RequestMapping("/location/desert/{city}")
	public String getDeCFood(@PathVariable("city") String city,Model model) {
		List<FoodVo> cityFood=foodService.getCityFood(constant.DESERT,city);
		model.addAttribute("desert", cityFood);
		List<Food> topFood=foodService.getTopThree(constant.DESERT);
		model.addAttribute("topFood", topFood);
		addModel(model);
		return "desert";
	}
	
	@RequestMapping("/location/drink/{city}")
	public String getDrCFood(@PathVariable("city") String city,Model model) {
		List<FoodVo> cityFood=foodService.getCityFood(constant.DRINK,city);
		model.addAttribute("drink", cityFood);
		List<Food> topFood=foodService.getTopThree(constant.DRINK);
		model.addAttribute("topFood", topFood);
		addModel(model);
		return "drink";
	}
	
	@RequestMapping("/time/{foodType}")
	public String timeFood(@PathVariable("foodType")String foodType,Model model) {
		addModel(model);
		List<FoodVo> timeFood=foodService.getTimeFood(foodType);
		if(constant.BREAKFAST.equals(foodType)) {
			model.addAttribute("breakfast", timeFood);
			List<Food> topFood=foodService.getTopThree(constant.BREAKFAST);
			model.addAttribute("topFood", topFood);
			return "breakfast";
		}else if(constant.LUNCH.equals(foodType)) {
			model.addAttribute("lunch", timeFood);
			List<Food> topFood=foodService.getTopThree(constant.LUNCH);
			model.addAttribute("topFood", topFood);
			return "lunch";
		}else if(constant.SNACK.equals(foodType)) {
			model.addAttribute("snack", timeFood);
			List<Food> topFood=foodService.getTopThree(constant.SNACK);
			model.addAttribute("topFood", topFood);
			return "snack";
		}else if(constant.DESERT.equals(foodType)) {
			model.addAttribute("desert", timeFood);
			List<Food> topFood=foodService.getTopThree(constant.DESERT);
			model.addAttribute("topFood", topFood);
			return "desert";
		}else {
			model.addAttribute("drink", timeFood);
			List<Food> topFood=foodService.getTopThree(constant.DRINK);
			model.addAttribute("topFood", topFood);
			return "drink";
		}
	}
	
	@RequestMapping("/populor/{foodType}")
	public String populorFood(@PathVariable("foodType")String foodType,Model model) {
		addModel(model);
		List<FoodVo> populorFood=foodService.getPopulorFood(foodType);
		if(constant.BREAKFAST.equals(foodType)) {
			model.addAttribute("breakfast", populorFood);
			List<Food> topFood=foodService.getTopThree(constant.BREAKFAST);
			model.addAttribute("topFood", topFood);
			return "breakfast";
		}else if(constant.LUNCH.equals(foodType)) {
			model.addAttribute("lunch", populorFood);
			List<Food> topFood=foodService.getTopThree(constant.LUNCH);
			model.addAttribute("topFood", topFood);
			return "lunch";
		}else if(constant.SNACK.equals(foodType)) {
			model.addAttribute("snack", populorFood);
			List<Food> topFood=foodService.getTopThree(constant.SNACK);
			model.addAttribute("topFood", topFood);
			return "snack";
		}else if(constant.DESERT.equals(foodType)) {
			model.addAttribute("desert", populorFood);
			List<Food> topFood=foodService.getTopThree(constant.DESERT);
			model.addAttribute("topFood", topFood);
			return "desert";
		}else {
			model.addAttribute("drink", populorFood);
			List<Food> topFood=foodService.getTopThree(constant.DRINK);
			model.addAttribute("topFood", topFood);
			return "drink";
		}
	}
	
	@RequestMapping("/price/{foodType}")
	public String priceFood(@PathVariable("foodType")String foodType,Model model) {
		addModel(model);
		List<FoodVo> priceFood=foodService.getPriceFood(foodType);
		if(constant.BREAKFAST.equals(foodType)) {
			model.addAttribute("breakfast", priceFood);
			List<Food> topFood=foodService.getTopThree(constant.BREAKFAST);
			model.addAttribute("topFood", topFood);
			return "breakfast";
		}else if(constant.LUNCH.equals(foodType)) {
			model.addAttribute("lunch", priceFood);
			List<Food> topFood=foodService.getTopThree(constant.LUNCH);
			model.addAttribute("topFood", topFood);
			return "lunch";
		}else if(constant.SNACK.equals(foodType)) {
			model.addAttribute("snack", priceFood);
			List<Food> topFood=foodService.getTopThree(constant.SNACK);
			model.addAttribute("topFood", topFood);
			return "snack";
		}else if(constant.DESERT.equals(foodType)) {
			model.addAttribute("desert", priceFood);
			List<Food> topFood=foodService.getTopThree(constant.DESERT);
			model.addAttribute("topFood", topFood);
			return "desert";
		}else {
			model.addAttribute("drink", priceFood);
			List<Food> topFood=foodService.getTopThree(constant.DRINK);
			model.addAttribute("topFood", topFood);
			return "drink";
		}
	}
	
	@RequestMapping("/poster/{userID}")
	public String posterFood(@PathVariable("userID")Integer userID,Model model) {
		List<FoodVo> posterFood=foodService.getPosterFood(userID);
		model.addAttribute("food", posterFood);
		String userName=posterFood.get(0).getUserName();
		String userImg=posterFood.get(0).getUserImg();
		String userGender=posterFood.get(0).getUserGender();
		String userPhone=posterFood.get(0).getUserPhone();
		String userSign=posterFood.get(0).getUserSign();
		Poster poster=new Poster(userName,userImg,userGender,userPhone,userSign);
		model.addAttribute("poster", poster);
		return "poster";
	}
	
}
