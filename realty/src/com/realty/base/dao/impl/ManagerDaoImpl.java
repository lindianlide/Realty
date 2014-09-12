package com.realty.base.dao.impl;


import java.util.List;

import org.apache.log4j.Logger;

import com.realty.base.dao.ManagerDao;
import com.realty.base.model.Manager;
import com.realty.base.utils.HibernateDaoSupport;


public class ManagerDaoImpl implements ManagerDao {
	HibernateDaoSupport hds=new HibernateDaoSupport();
	public boolean login(String managername, String password) {
		// TODO Auto-generated method stub
		boolean result=false;
		 Logger logger = Logger.getLogger("DAO");
		// PropertyConfigurator.configure("src/log4j.properties");
		Object[] o={managername,password};
		String hql="from Manager where name=? and password=?";
		List list=hds.findByParameter(hql,o);
		if(!list.isEmpty())
			{
			result=true;
			logger.info(managername+"µÇÂ¼³É¹¦");
			}
		else
			logger.info(managername+"µÇÂ¼Ê§°Ü");
			return result;
	}
	@Override
	public List<Manager> managerList() {
		// TODO Auto-generated method stub
		List<Manager> list=hds.findByParameter("from Manager");
		return list;
	}
	@Override
	public boolean addManager(String name, String password, String manrole) {
		// TODO Auto-generated method stub
		Manager manage=new Manager();
		manage.setName(name);
		manage.setPassword(password);
		manage.setManrole(manrole);
		hds.save(manage);
		return true;
		
	}
	@Override
	public boolean updateManager(int manId,String name, String password, String manrole) {
		// TODO Auto-generated method stub
		Manager manage=new Manager();
		manage.setManId(manId);
		manage.setName(name);
		manage.setPassword(password);
		manage.setManrole(manrole);
		hds.update(manage);
		return true;
	}
	@Override
	public boolean delManager(int manId) {
		// TODO Auto-generated method stub
		Manager manage=new Manager();
		manage.setManId(manId);
		manage.setName("0");
		manage.setPassword("0");
		manage.setManrole("00");
		hds.delete(manage);
		return true;
	}


}
