package com.zm.wte.food.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zm.wte.food.service.FoodService;

@RestController
public class FoodRestController {
	
	@Autowired
	private FoodService foodService;
	
	@RequestMapping("/deleteFood")
	public String deleterFood(@RequestParam("foodID") Integer foodID) {
		int i=foodService.delF(foodID);
		if(i==1) {
			return "success";
		}
		return "failed";
	}
	
	@RequestMapping("/cancelFavo")
	public String cancelFavo(@RequestParam("foodID") Integer foodID, HttpSession session) {
		Integer userID=(Integer) session.getAttribute("UserID");
		int i=foodService.cancelFavo(userID,foodID);
		if(i==1) {
			return "success";
		}
		return "failed";
	}
	
	@RequestMapping("/cancelColl")
	public String cancelColl(@RequestParam("foodID") Integer foodID,HttpSession session) {
		Integer userID=(Integer) session.getAttribute("UserID");
		int i=foodService.cancelColl(userID,foodID);
		if(i==1) {
			return "success";
		}
		return "failed";
	}
	
	@RequestMapping("/revScore")
	public String revScore(@RequestParam("foodID")Integer foodID,
			@RequestParam("score")Float score, HttpSession session) {
		Integer userID=(Integer) session.getAttribute("UserID");
		int i=foodService.addScore(userID,foodID,score);
		if(i>=1) {
			return "success";
		}
		return "failed";
	}
	
	@RequestMapping("/addFavorite")
	public String addFavorite(@RequestParam("foodID") Integer foodID,HttpSession session) {
		Integer userID=(Integer) session.getAttribute("UserID");
		int i=foodService.addFavorite(userID,foodID);
		if(i==1) {
			return "success";
		}
		return "failed";
	}
	
	@RequestMapping("/addCollect")
	public String addCollect(@RequestParam("foodID") Integer foodID,HttpSession session) {
		Integer userID=(Integer) session.getAttribute("UserID");
		int i=foodService.addCollect(userID,foodID);
		if(i==1) {
			return "success";
		}
		return "failed";
	}
	
	@RequestMapping("/addComment")
	public String addComment(@RequestParam("foodID") Integer foodID,@RequestParam("comment") String comment,
			HttpSession session) {
		Integer userID=(Integer) session.getAttribute("UserID");
		int i=foodService.addComment(userID,foodID,comment);
		if(i==1) {
			return "success";
		}
		return "failed";
	}

}
