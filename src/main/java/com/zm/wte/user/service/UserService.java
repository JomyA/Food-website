package com.zm.wte.user.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.zm.wte.user.po.LoginLog;
import com.zm.wte.user.po.User;
import com.zm.wte.user.vo.UserForm;

public interface UserService {

	int addUser(String account, String password);

	User getUser(String account);

	List<User> getAllUsers();

	List<User> searchUser(String message);

	int delU(Integer userID);

	int saveInfo(UserForm userForm,HttpSession session);

	User getUserByID(Integer userID);
	
	int addLogin(Integer userID,String loginIP);
	
	List<LoginLog> getLog(Integer userID);
	
}
