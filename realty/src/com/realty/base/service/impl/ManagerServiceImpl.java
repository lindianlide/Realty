package com.realty.base.service.impl;

import java.util.List;

import com.realty.base.dao.ManagerDao;
import com.realty.base.dao.impl.ManagerDaoImpl;
import com.realty.base.model.Manager;
import com.realty.base.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
	ManagerDao managerDao=new ManagerDaoImpl();
	public boolean login(String managername, String password) {
		return managerDao.login(managername, password);
	}

	public List<Manager> managerList() {
		// TODO Auto-generated method stub
		return managerDao.managerList();
	}

	public boolean addManager(String name, String password, String manrole){
		// TODO Auto-generated method stub
		return managerDao.addManager(name, password, manrole);
	}
	public boolean updateManager(int manId,String name, String password, String manrole){
		// TODO Auto-generated method stub
		return managerDao.updateManager(manId, name, password, manrole);
	}
	public boolean delManager(int manId){
		// TODO Auto-generated method stub
		return managerDao.delManager(manId);
	}

}
