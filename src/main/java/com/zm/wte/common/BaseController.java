package com.zm.wte.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.zm.wte.food.po.CookMethod;
import com.zm.wte.food.po.FoodStyle;
import com.zm.wte.food.po.Taste;
import com.zm.wte.food.service.FoodService;

public class BaseController {
	
	@Autowired 
	public FoodService foodService;
	
	public Model addModel(Model model) {
		List<FoodStyle> styleList=foodService.getStyleList();
		List<Taste> tasteList=foodService.getTasteList();
		List<CookMethod> methodList=foodService.getMethodList();
		styleList.remove(0);  tasteList.remove(0);  methodList.remove(0);
		model.addAttribute("styleList",styleList);
		model.addAttribute("tasteList",tasteList);
		model.addAttribute("methodList",methodList);
		return model;
	}

}
