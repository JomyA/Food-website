package com.zm.wte.user.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zm.wte.common.constant;
import com.zm.wte.manager.po.Manager;
import com.zm.wte.user.dao.UserDao;
import com.zm.wte.user.po.LoginLog;
import com.zm.wte.user.po.User;
import com.zm.wte.user.service.UserService;
import com.zm.wte.user.vo.UserForm;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public int addUser(String account, String password) {
		return userDao.addUser(account, password);
	}

	@Override
	public User getUser(String account) {
		return userDao.getUser(account);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public List<User> searchUser(String message) {
		return userDao.searchUser(message);
	}

	@Override
	public int delU(Integer userID) {
		return userDao.delU(userID);
	}

	@Override
	public int saveInfo(UserForm userForm,HttpSession session) {
		User user = new User(userForm);
		session.setAttribute("UserName", user.getUserName());
		MultipartFile img = userForm.getUpload();
		if(img!=null && img.getSize() > 0) {
			String name = img.getOriginalFilename();
			String suffix = name.substring(name.lastIndexOf(".")); //文件的后缀名
			String userImg = user.getUserID()+suffix;
			session.setAttribute("UserImg", userImg);
			String filepath = constant.pathU+userImg;
			File imgFile = new File(filepath); //指定路径创建用户上传的文件
			user.setUserImg(userImg);
			try {
				img.transferTo(imgFile);//上传图片
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		int result = userDao.saveInfo(user); 
		if (result == 1) {
			return 1;
		}
		return 0;
	}

	@Override
	public User getUserByID(Integer userID) {
		return userDao.getUserByID(userID);
	}

	@Override
	public int addLogin(Integer userID, String loginIP) {
		return userDao.addLogin(userID, loginIP);
	}

	@Override
	public List<LoginLog> getLog(Integer userID) {
		return userDao.getLog(userID);
	}

}
