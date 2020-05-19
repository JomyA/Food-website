package com.zm.wte.manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.zm.wte.manager.po.Manager;
import com.zm.wte.manager.vo.ManagerForm;

@Mapper
public interface ManagerDao {
	
	int addManager(Manager manager);
	
	Manager getAdmin(String account);
	
	List<Manager> getAllManagers();
	
	List<Manager> searchManager(String message);
	
	int saveInfo(Manager manager);

	int delA(String account);

}
