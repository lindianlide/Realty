package com.realty.base.dao;

import java.util.List;

import com.realty.base.model.Manager;

public interface ManagerDao {
	
	public boolean login(String username,String password);
	
	public List<Manager> managerList();
	
	public boolean addManager(String name, String password, String manrole);
	public boolean updateManager(int manId,String name, String password, String manrole);
	public boolean delManager(int manId);
	}
