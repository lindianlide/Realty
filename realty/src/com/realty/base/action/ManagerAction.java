package com.realty.base.action;


import java.util.List;

import com.realty.base.model.Manager;
import com.realty.base.service.ManagerService;
import com.realty.base.service.impl.ManagerServiceImpl;

public class ManagerAction {
	ManagerService managerService=new ManagerServiceImpl();
	public boolean managerLogin(String managername,String password){
		return managerService.login(managername, password);
	}
	
	public List<Manager> managerList(){
		return managerService.managerList();
	}
	public boolean addManager(String name, String password, String manrole){
		return managerService.addManager(name, password, manrole);
	}
	public boolean updateManager(int manId,String name, String password, String manrole){
		return managerService.updateManager(manId, name, password, manrole);
	}
	public boolean delManager(int manId){
		return managerService.delManager(manId);
	}
}
