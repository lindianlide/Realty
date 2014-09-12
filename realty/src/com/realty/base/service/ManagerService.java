package com.realty.base.service;

import java.util.List;

import com.realty.base.model.Manager;

public interface ManagerService {
	
	public boolean login(String managername,String password);
	
	public List<Manager> managerList();
	
	public boolean addManager(String name, String password, String manrole);
	public boolean updateManager(int manId,String name, String password, String manrole);
	public boolean delManager(int manId);
}
