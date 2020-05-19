package com.zm.wte.user.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mockito.internal.matchers.InstanceOf.VarArgAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zm.wte.common.BaseController;
import com.zm.wte.common.constant;
import com.zm.wte.common.utils.IPUtils;
import com.zm.wte.food.dao.FoodDao;
import com.zm.wte.food.po.CookMethod;
import com.zm.wte.food.po.Food;
import com.zm.wte.food.po.FoodStyle;
import com.zm.wte.food.po.Taste;
import com.zm.wte.food.service.FoodService;
import com.zm.wte.food.vo.CommentVo;
import com.zm.wte.food.vo.FoodVo;
import com.zm.wte.manager.vo.ManagerForm;
import com.zm.wte.user.po.User;
import com.zm.wte.user.service.UserService;
import com.zm.wte.user.vo.UserForm;

@Controller
public class UserController extends BaseController{

	@Autowired 
	private UserService userService;
	
	@RequestMapping("/toIndex")
	public String toIndex(HttpSession session, Model model) {
		Integer userID=(Integer) session.getAttribute("UserID");
		if(userID != null) {
			User user=userService.getUserByID(userID);
			model.addAttribute("user",user);
			return "index";
		}else {
			return "login";
		}
	}
	
	@RequestMapping("/getImg/{img}")
	public void getImg(@PathVariable("img") String img,HttpServletResponse response)
			throws IOException {
		FileInputStream fis = null;
		OutputStream os = null;
		try {
			fis = new FileInputStream(constant.pathU+img);
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
	public String saveInfo(UserForm userForm,HttpSession session) {
		int result=userService.saveInfo(userForm,session);
		if (result==1){
			return "saveUSuccess";
		}
		return "saveUFailed";
	}

	@RequestMapping("/postFood")
	public String postFood(Model model) {
		List<FoodStyle> styleList=foodService.getStyleList();
		List<Taste> tasteList=foodService.getTasteList();
		List<CookMethod> methodList=foodService.getMethodList();
		model.addAttribute("styleList",styleList);
		model.addAttribute("tasteList",tasteList);
		model.addAttribute("methodList",methodList);
		return "postFood";
	}
	
	@RequestMapping("/myPost")
	public String myPost(HttpSession session,Model model) {
		Integer userID=(Integer) session.getAttribute("UserID");
		List<Food> foods= foodService.getMyPost(userID);
		model.addAttribute("foods", foods);
		return "myPost";
	}
	
	@RequestMapping("/myFavorite")
	public String myFavorite(HttpSession session,Model model) {
		Integer userID=(Integer) session.getAttribute("UserID");
		List<Food> foods= foodService.getMyFavorite(userID);
		model.addAttribute("foods", foods);
		return "myFavorite";
	}
	
	@RequestMapping("/myCollect")
	public String myCollect(HttpSession session,Model model) {
		Integer userID=(Integer) session.getAttribute("UserID");
		List<Food> foods= foodService.getMyCollect(userID);
		model.addAttribute("foods", foods);
		return "myCollect";
	}
	
	@RequestMapping("/foodInfo/{foodID}")
	public String foodInfo(@PathVariable("foodID")Integer foodID, Model model,HttpSession session) {
		FoodVo foodVo=foodService.getFood(foodID);
		foodVo.setFoodStyle(foodService.getStyle(foodVo.getStyleID()));
		foodVo.setTaste(foodService.getTaste(foodVo.getTasteID()));
		foodVo.setCookMethod(foodService.getMethod(foodVo.getMethodID()));
		model.addAttribute("food", foodVo);
		List<CommentVo> comments=foodService.getComment(foodID);
		model.addAttribute("comments",comments);
		
		Integer userID=(Integer) session.getAttribute("UserID");
		int fav=2;  int col=2;  int rev=2; int point=5; int load=0;
		if(userID!=null) {
			load=1;
			fav=foodService.getFavorite(userID,foodID);
			col=foodService.getCollect(userID,foodID);
			rev=foodService.getReview(userID,foodID);
		}
		if(rev==1) {
			point=foodService.getPoint(userID,foodID);
		}
		model.addAttribute("load",load);
		model.addAttribute("fav", fav);
		model.addAttribute("col", col);
		model.addAttribute("rev", rev);
		model.addAttribute("point",point);
		return "foodInfo";
	}
	
	
	@RequestMapping("/breakfast")
	public String breakfast(Model model) {
		List<FoodVo> breakfast=foodService.getTypeFood(constant.BREAKFAST);
		model.addAttribute("breakfast", breakfast);
		List<Food> topFood=foodService.getTopThree(constant.BREAKFAST);
		model.addAttribute("topFood", topFood);
		List<FoodStyle> styleList=foodService.getStyleList();
		List<Taste> tasteList=foodService.getTasteList();
		List<CookMethod> methodList=foodService.getMethodList();
		styleList.remove(0);  tasteList.remove(0);  methodList.remove(0);
		model.addAttribute("styleList",styleList);
		model.addAttribute("tasteList",tasteList);
		model.addAttribute("methodList",methodList);
		return "breakfast";
	}
	
	@RequestMapping("/lunch")
	public String lunch(Model model) {
		List<FoodVo> lunch=foodService.getTypeFood(constant.LUNCH);
		model.addAttribute("lunch", lunch);
		List<Food> topFood=foodService.getTopThree(constant.LUNCH);
		model.addAttribute("topFood", topFood);
		List<FoodStyle> styleList=foodService.getStyleList();
		List<Taste> tasteList=foodService.getTasteList();
		List<CookMethod> methodList=foodService.getMethodList();
		styleList.remove(0);  tasteList.remove(0);  methodList.remove(0);
		model.addAttribute("styleList",styleList);
		model.addAttribute("tasteList",tasteList);
		model.addAttribute("methodList",methodList);
		return "lunch";
	}
	
	@RequestMapping("/snack")
	public String snack(Model model) {
		List<FoodVo> snack=foodService.getTypeFood(constant.SNACK);
		model.addAttribute("snack", snack);
		List<Food> topFood=foodService.getTopThree(constant.SNACK);
		model.addAttribute("topFood", topFood);
		List<FoodStyle> styleList=foodService.getStyleList();
		List<Taste> tasteList=foodService.getTasteList();
		List<CookMethod> methodList=foodService.getMethodList();
		styleList.remove(0);  tasteList.remove(0);  methodList.remove(0);
		model.addAttribute("styleList",styleList);
		model.addAttribute("tasteList",tasteList);
		model.addAttribute("methodList",methodList);
		return "snack";
	}
	
	@RequestMapping("/desert")
	public String desert(Model model) {
		List<FoodVo> desert=foodService.getTypeFood(constant.DESERT);
		model.addAttribute("desert", desert);
		List<Food> topFood=foodService.getTopThree(constant.DESERT);
		model.addAttribute("topFood", topFood);
		return "desert";
	}
	
	@RequestMapping("/drink")
	public String drink(Model model) {
		List<FoodVo> drink=foodService.getTypeFood(constant.DRINK);
		model.addAttribute("drink", drink);
		List<Food> topFood=foodService.getTopThree(constant.DRINK);
		model.addAttribute("topFood", topFood);
		return "drink";
	}
	
	@RequestMapping("/searchFood/breakfast")
	public String searchBreakfast(String message,Model model) {
		List<FoodVo> foods=foodService.searchTypeFood(constant.BREAKFAST,message);
		model.addAttribute("breakfast", foods);
		List<Food> topFood=foodService.getTopThree(constant.BREAKFAST);
		model.addAttribute("topFood", topFood);
		addModel(model);
		return "breakfast";
	}
	
	@RequestMapping("/searchFood/lunch")
	public String searchLunch(String message,Model model) {
		List<FoodVo> foods=foodService.searchTypeFood(constant.LUNCH,message);
		model.addAttribute("lunch", foods);
		List<Food> topFood=foodService.getTopThree(constant.LUNCH);
		model.addAttribute("topFood", topFood);
		addModel(model);
		return "lunch";
	}

	@RequestMapping("/searchFood/snack")
	public String searchSnack(String message,Model model) {
		List<FoodVo> foods=foodService.searchTypeFood(constant.SNACK,message);
		model.addAttribute("snack", foods);
		List<Food> topFood=foodService.getTopThree(constant.SNACK);
		model.addAttribute("topFood", topFood);
		addModel(model);
		return "snack";
	}

	@RequestMapping("/searchFood/desert")
	public String searchDesert(String message,Model model) {
		List<FoodVo> foods=foodService.searchTypeFood(constant.DESERT,message);
		model.addAttribute("desert", foods);
		List<Food> topFood=foodService.getTopThree(constant.DESERT);
		model.addAttribute("topFood", topFood);
		addModel(model);
		return "desert";
	}
	
	@RequestMapping("/searchFood/drink")
	public String searchDrink(String message,Model model) {
		List<FoodVo> foods=foodService.searchTypeFood(constant.DRINK,message);
		model.addAttribute("drink", foods);
		List<Food> topFood=foodService.getTopThree(constant.DRINK);
		model.addAttribute("topFood", topFood);
		addModel(model);
		return "drink";
	}
	
	@RequestMapping("/foodStyle/breakfast/{foodStyle}")
	public String breakfastStyle(@PathVariable("foodStyle") String foodStyle,Model model) {
		List<FoodVo> styleFood=foodService.getStyleFood(constant.BREAKFAST,foodStyle);
		model.addAttribute("breakfast", styleFood);
		List<Food> topFood=foodService.getTopThree(constant.BREAKFAST);
		model.addAttribute("topFood", topFood);
		addModel(model);
		return "breakfast";
	}
	
	@RequestMapping("/foodStyle/lunch/{foodStyle}")
	public String lunchStyle(@PathVariable("foodStyle") String foodStyle,Model model) {
		List<FoodVo> styleFood=foodService.getStyleFood(constant.LUNCH,foodStyle);
		model.addAttribute("lunch", styleFood);
		List<Food> topFood=foodService.getTopThree(constant.LUNCH);
		model.addAttribute("topFood", topFood);
		addModel(model);
		return "lunch";
	}
	
	@RequestMapping("/foodStyle/snack/{foodStyle}")
	public String snackStyle(@PathVariable("foodStyle") String foodStyle,Model model) {
		List<FoodVo> styleFood=foodService.getStyleFood(constant.SNACK,foodStyle);
		model.addAttribute("snack", styleFood);
		List<Food> topFood=foodService.getTopThree(constant.SNACK);
		model.addAttribute("topFood", topFood);
		addModel(model);
		return "snack";
	}
	
	@RequestMapping("/cookMethod/breakfast/{cookMethod}")
	public String breakfastMethod(@PathVariable("cookMethod") String cookMethod,Model model) {
		System.out.println(cookMethod);
		List<FoodVo> methodFood=foodService.getMethodFood(constant.BREAKFAST,cookMethod);
		model.addAttribute("breakfast",methodFood);
		List<Food> topFood=foodService.getTopThree(constant.BREAKFAST);
		model.addAttribute("topFood", topFood);
		addModel(model);
		return "breakfast";
	}
	
	@RequestMapping("/cookMethod/lunch/{cookMethod}")
	public String lunchMethod(@PathVariable("cookMethod") String cookMethod,Model model) {
		List<FoodVo> methodFood=foodService.getMethodFood(constant.LUNCH,cookMethod);
		model.addAttribute("lunch",methodFood);
		List<Food> topFood=foodService.getTopThree(constant.LUNCH);
		model.addAttribute("topFood", topFood);
		addModel(model);
		return "lunch";
	}
	
	@RequestMapping("/cookMethod/snack/{cookMethod}")
	public String snackMethod(@PathVariable("cookMethod") String cookMethod,Model model) {
		List<FoodVo> methodFood=foodService.getMethodFood(constant.SNACK,cookMethod);
		model.addAttribute("snack",methodFood);
		List<Food> topFood=foodService.getTopThree(constant.SNACK);
		model.addAttribute("topFood", topFood);
		addModel(model);
		return "snack";
	}

	@RequestMapping("/taste/breakfast/{taste}")
	public String breakfastTaste(@PathVariable("taste") String taste,Model model) {
		List<FoodVo> tasteFood=foodService.getTasteFood(constant.BREAKFAST,taste);
		model.addAttribute("breakfast",tasteFood);
		List<Food> topFood=foodService.getTopThree(constant.BREAKFAST);
		model.addAttribute("topFood", topFood);
		addModel(model);
		return "breakfast";
	}
	
	@RequestMapping("/taste/lunch/{taste}")
	public String lunchTaste(@PathVariable("taste") String taste,Model model) {
		List<FoodVo> tasteFood=foodService.getTasteFood(constant.LUNCH,taste);
		model.addAttribute("lunch",tasteFood);
		List<Food> topFood=foodService.getTopThree(constant.LUNCH);
		model.addAttribute("topFood", topFood);
		addModel(model);
		return "lunch";
	}
	
	@RequestMapping("/taste/snack/{taste}")
	public String snackTaste(@PathVariable("taste") String taste,Model model) {
		List<FoodVo> tasteFood=foodService.getTasteFood(constant.SNACK,taste);
		model.addAttribute("sanck",tasteFood);
		List<Food> topFood=foodService.getTopThree(constant.SNACK);
		model.addAttribute("topFood", topFood);
		addModel(model);
		return "sanck";
	}

}
