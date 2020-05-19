package com.zm.wte.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zm.wte.user.po.LoginLog;
import com.zm.wte.user.po.User;
import com.zm.wte.user.vo.UserForm;

@Mapper
public interface UserDao {

	int addUser(@Param("account")String account, @Param("password")String password);
	
	User getUser(String account);
	
	User getUserByID(Integer userID);
	
	List<User> getAllUsers();
	
	List<User> searchUser(String message);
	
	int delU(Integer userID);
	
	int saveInfo(User user);
	
	int addLogin(@Param("userID")Integer userID,@Param("loginIP")String loginIP);
	
	List<LoginLog> getLog(Integer userID);
}
