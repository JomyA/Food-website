package com.zm.wte.manager.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zm.wte.common.constant;
import com.zm.wte.food.po.Food;
import com.zm.wte.food.service.FoodService;
import com.zm.wte.food.vo.FoodVo;
import com.zm.wte.manager.po.Manager;
import com.zm.wte.manager.service.ManagerService;
import com.zm.wte.manager.vo.ManagerForm;
import com.zm.wte.user.po.LoginLog;
import com.zm.wte.user.po.User;
import com.zm.wte.user.service.UserService;

@Controller
@RequestMapping("/admin")
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	@Autowired
	private UserService userService;
	@Autowired
	private FoodService foodService;
	
	@RequestMapping("/getImg/{img}")
	public void getImg(@PathVariable("img") String img,HttpServletResponse response)
			throws IOException {
		FileInputStream fis = null;
		OutputStream os = null;
		try {
			fis = new FileInputStream(constant.pathA+img);
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
	
	@RequestMapping("/saveInfo")
	public String saveInfo(ManagerForm managerForm) {
		int result=managerService.saveInfo(managerForm);
		if (result==1){
			return "saveASuccess";
		}
		return "saveAFailed";
	}

	@RequestMapping("/logOut")
	public String logOut(HttpSession session) {
		 session.invalidate();
		 return "admin-login";
	}
	
	@RequestMapping("/add")
	public String add() {
		return "admin-add";
	}
	
	@RequestMapping("/addManager")
	public String addManager(ManagerForm managerForm) {
		int result=managerService.addManager(managerForm);
		if (result==1){
			return "addMSuccess";
		}
		return "addMFailed";
	}

	@RequestMapping("/mainPage")
	public String mainPage(HttpSession session, Model model) {
		Object account=session.getAttribute("loginManager");
		Manager manager=managerService.getAdmin(account.toString());
		model.addAttribute("manager",manager);
		return "adminInfo";
	}
	
	@RequestMapping("/userList")
	public String getAllUsers(Model model) {
		List<User> users=userService.getAllUsers();
		model.addAttribute("users", users);
		return "userList";
	}
	
	@RequestMapping("/searchUser")
	public String searchUser(String message, Model model) {
		List<User> users=userService.searchUser(message);
		model.addAttribute("users",users);
		return "userList";
	}
	
	@RequestMapping("/foodList")
	public String getAllFoods(Model model) {
		List<FoodVo> foods=foodService.getAllFoods();
		model.addAttribute("foods", foods);
		return "foodList";
	}
	
	@RequestMapping("/searchFood")
	public String searchFood(String message, Model model){
		List<FoodVo> foods=foodService.searchFood(message);
		model.addAttribute("foods",foods);
		return "foodList";
	}
	
	@RequestMapping("/managerList")
	public String getAllManagers(Model model) {
		List<Manager> managers=managerService.getAllManagers();
		model.addAttribute("managers",managers);
		return "adminList";
	}
	
	@RequestMapping("/searchManager")
	public String searchManager(String message, Model model){
		List<Manager> managers=managerService.searchManager(message);
		model.addAttribute("managers",managers);
		return "adminList";
	}
	
	@RequestMapping("/getLog/{userID}")
	public String getLog(@PathVariable("userID")Integer userID,Model model,
			HttpSession session) {
		List<LoginLog> logs= userService.getLog(userID);
		session.setAttribute("userLog",userID);
		model.addAttribute("logs", logs);
		return "logList";
	}
	
}
