package com.zm.wte.index.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zm.wte.common.utils.IPUtils;
import com.zm.wte.manager.po.Manager;
import com.zm.wte.manager.service.ManagerService;
import com.zm.wte.user.po.User;
import com.zm.wte.user.service.UserService;

@Controller
public class IndexController {

	@Autowired
	private ManagerService managerService;
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/user")
	public String index(HttpServletRequest request,HttpSession session) {
		String ip = IPUtils.getIpBySohu();
		session.setAttribute("IP", ip);
		System.out.println(ip);
		String city = IPUtils.getAddressByIP(ip);
		session.setAttribute("city", city);
		System.out.println("Hello U~~~~~~~~");
		return "login";
	}
	
	@RequestMapping("/admin")
	public String admin(){
		System.out.println("Hello A~~~~~~~~");
		return "admin-login";
	}
	
	@RequestMapping("/userLogin")
	public String userLogin(@RequestParam("account") String account,
			@RequestParam("password") String password, Model model,
			Map<String,Object> map,HttpSession session) {
	
		User user=userService.getUser(account);
		if((account!=null)&&(!StringUtils.isEmpty(password))&&(user.getUserPass().equals(password))) {
			model.addAttribute("user",user);
			session.setAttribute("UserName", user.getUserName());
			session.setAttribute("UserID", user.getUserID());
			session.setAttribute("UserImg", user.getUserImg());
			userService.addLogin(user.getUserID(), (String)session.getAttribute("IP"));
			return "index";
		}else {
			map.put("msg", "用户名或密码错误");
			return "login";
		}
	}

	@RequestMapping("/logOut")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/user";
	}

	@RequestMapping("/userRegist")
	public String userRegist(@RequestParam("account") String account,
			@RequestParam("password") String password, Model model,
			HttpSession session) {
		
		int i=userService.addUser(account,password);
		if(i==1) {
			User user=userService.getUser(account);
			model.addAttribute("user", user);
			session.setAttribute("UserName", user.getUserName());
			session.setAttribute("UserImg", user.getUserImg());
			return "index";
		}else {
			System.out.println("注册失败");
			return "false";
		}
		
	}	
	
	@RequestMapping("/adminLogin")
	public String adminLogin(@RequestParam("account") String account,
			@RequestParam("password") String password, Model model,
			Map<String,Object> map,HttpSession session) {
		
		Manager manager=managerService.getAdmin(account);
		if((!StringUtils.isEmpty(account))&&(!StringUtils.isEmpty(password))&&(manager.getManagerPass().equals(password))) {
			model.addAttribute("manager",manager);
			session.setAttribute("loginManager", account);
			return "adminInfo";
		}else {
			map.put("msg", "用户名或密码错误");
			return "admin-login";
		}
	}
	
}
