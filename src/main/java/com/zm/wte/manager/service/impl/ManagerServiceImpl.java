package com.zm.wte.manager.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zm.wte.manager.service.ManagerService;
import com.zm.wte.manager.vo.ManagerForm;
import com.zm.wte.common.constant;
import com.zm.wte.manager.dao.ManagerDao;
import com.zm.wte.manager.po.Manager;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDao managerDao;

	@Override
	public Manager getAdmin(String account) {
		return managerDao.getAdmin(account);
	}

	@Override
	public List<Manager> getAllManagers() {
		return managerDao.getAllManagers();
	}

	@Override
	public List<Manager> searchManager(String message) {
		return managerDao.searchManager(message);
	}

	@Override
	public int saveInfo(ManagerForm managerForm) {
		Manager manager = new Manager(managerForm);
		MultipartFile img = managerForm.getUpload();
		if(img!=null && img.getSize() > 0) {
			String name = img.getOriginalFilename();
			String suffix = name.substring(name.lastIndexOf(".")); //文件的后缀名
			String managerImg = manager.getManagerID()+suffix;
			String filepath = constant.pathA+managerImg;
			File imgFile = new File(filepath); //指定路径创建用户上传的文件
			manager.setManagerImg(managerImg);
			try {
				img.transferTo(imgFile);//上传图片
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		int result = managerDao.saveInfo(manager); 
		if (result == 1) {
			return 1;
		}
		return 0;
	}
	
	@Override
	public int addManager(ManagerForm managerForm) {
		Manager manager = new Manager(managerForm);
		MultipartFile img = managerForm.getUpload();
		String name = img.getOriginalFilename();//文件名
		String suffix = name.substring(name.lastIndexOf(".")); //文件的后缀名
		String managerImg = manager.getManagerID()+suffix;
		String filepath = constant.pathA+managerImg;
		File imgFile = new File(filepath);//指定路径创建用户上传的文件
		manager.setManagerImg(managerImg);
		try {
			img.transferTo(imgFile); //上传图片
			int result = managerDao.addManager(manager); 
			if (result == 1) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int delA(String account) {
		return managerDao.delA(account);
	}
	
}
