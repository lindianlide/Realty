package com.realty.base.service.impl;

import java.util.List;

import com.realty.base.dao.BuildingFormDao;
import com.realty.base.dao.impl.BuildingFormDaoImpl;
import com.realty.base.model.BuildingForm;
import com.realty.base.service.BuildingFormService;

public class BuildingFormServiceImpl implements BuildingFormService{
	BuildingFormDao BFDao=new BuildingFormDaoImpl();
	
	@Override
	public boolean buildingformAdd(String formId, String formName) {
		// TODO Auto-generated method stub
		return BFDao.buildingformAdd(formId, formName);
	}
	@Override
	public boolean buildingformUpdate(String formId, String formName) {
		// TODO Auto-generated method stub
		return BFDao.buildingformUpdate(formId, formName);
	}
	@Override
	public List<BuildingForm> buildingformList() {
		// TODO Auto-generated method stub
		return BFDao.buildingformList();
	}
	@Override
	public boolean buildingformDel(String formId) {
		// TODO Auto-generated method stub
		return BFDao.buildingformDel(formId);
	}
	@Override
	public String buildingformSearch(String formId){
		// TODO Auto-generated method stub
		return BFDao.buildingformSearch(formId);
	}
}
