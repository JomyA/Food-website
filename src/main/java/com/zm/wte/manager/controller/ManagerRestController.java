package com.zm.wte.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zm.wte.food.service.FoodService;
import com.zm.wte.manager.service.ManagerService;
import com.zm.wte.user.service.UserService;

@RestController
@RequestMapping("/admin")
public class ManagerRestController {

	@Autowired
	private ManagerService managerService;
	@Autowired
	private UserService userService;
	@Autowired
	private FoodService foodService;
	
	
	@RequestMapping("/delU/{account}")
	public String delU(@PathVariable("account") Integer account) {
		int i=userService.delU(account);
		if(i==1) {
			return "success";
		}
		return "failed";
	}
	
	@RequestMapping("/delF/{foodID}")
	public String delF(@PathVariable("foodID") Integer foodID) {
		int i=foodService.delF(foodID);
		if(i==1) {
			return "success";
		}
		return "failed";
	}
	
	@RequestMapping("/delA/{account}")
	public String delA(@PathVariable("account") String account) {
		int i=managerService.delA(account);
		if(i==1) {
			return "success";
		}
		return "failed";
	}
	
}
