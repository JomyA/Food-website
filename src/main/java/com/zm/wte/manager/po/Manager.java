package com.zm.wte.manager.po;

import com.zm.wte.manager.vo.ManagerForm;

public class Manager {

	private String managerID;
	private String managerPass;
	private String managerName;
	private String managerImg;
	private String managerGender;
	private String managerPhone;
	private String managerAddress;
	
	public Manager() {}
	
	public Manager(ManagerForm form){
		this.managerID = form.getAccount();
		this.managerPass = form.getPassword();
		this.managerName = form.getName();
		this.managerGender = form.getGender();
		this.managerPhone = form.getPhone();
		this.managerAddress = form.getAddress();
	}

	public String getManagerID() {
		return managerID;
	}
	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}
	public String getManagerPass() {
		return managerPass;
	}
	public void setManagerPass(String managerPass) {
		this.managerPass = managerPass;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerImg() {
		return managerImg;
	}
	public void setManagerImg(String managerImg) {
		this.managerImg = managerImg;
	}
	public String getManagerGender() {
		return managerGender;
	}
	public void setManagerGender(String managerGender) {
		this.managerGender = managerGender;
	}
	public String getManagerPhone() {
		return managerPhone;
	}
	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}
	public String getManagerAddress() {
		return managerAddress;
	}
	public void setManagerAddress(String managerAddress) {
		this.managerAddress = managerAddress;
	}
	
}
