package com.realty.base.dao.impl;

import java.util.List;

import com.realty.base.dao.BuildingFormDao;
import com.realty.base.model.BuildingForm;
import com.realty.base.model.BuildingStructure;
import com.realty.base.utils.HibernateDaoSupport;

public class BuildingFormDaoImpl implements BuildingFormDao {
	HibernateDaoSupport hds=new HibernateDaoSupport();
	@Override
	public boolean buildingformAdd(String formId, String formName) {
		// TODO Auto-generated method stub
		BuildingForm BF=new BuildingForm();
	    BF.setFormId(formId);
	    BF.setFormName(formName);
		hds.save(BF);
		return true;
	}
	@Override
	public boolean buildingformUpdate(String formId, String formName) {
		// TODO Auto-generated method stub
		BuildingForm BF=new BuildingForm();
	    BF.setFormId(formId);
	    BF.setFormName(formName);
	    hds.update(BF);
		return true;
	}
	@Override
	public List<BuildingForm> buildingformList() {
		// TODO Auto-generated method stub
		List<BuildingForm> list=hds.findByParameter("from BuildingForm");
		return list;
	}
	@Override
	public boolean buildingformDel(String formId) {
		// TODO Auto-generated method stub
		BuildingForm BF=new BuildingForm();
	    BF.setFormId(formId);
		hds.delete(BF);
		return true;
	}
	@Override
	public String buildingformSearch(String formId) {
		// TODO Auto-generated method stub
		Object[] o={formId}; 
		String hql="from BuildingForm where formId=?";
		List<BuildingForm> list=hds.findByParameter(hql,o);
		return list.get(0).getFormName();
	}
}
