package com.zm.wte.manager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zm.wte.manager.po.Manager;
import com.zm.wte.manager.vo.ManagerForm;

public interface ManagerService {

	int addManager(ManagerForm managerForm);

	Manager getAdmin(String account);

	List<Manager> getAllManagers();

	List<Manager> searchManager(String message);

	int saveInfo(ManagerForm managerForm);

	int delA(String account);
	
}
