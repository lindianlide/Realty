package com.realty.base.dao.impl;

import java.util.List;

import com.realty.base.dao.BuildingDecorateDao;
import com.realty.base.model.BuildingDecorate;
import com.realty.base.model.BuildingForm;
import com.realty.base.utils.HibernateDaoSupport;

public class BuildingDecorateDaoImpl implements BuildingDecorateDao {
	HibernateDaoSupport hds=new HibernateDaoSupport();
	public boolean buildingdecorateAdd(int decorateId, String decorateName) {
		// TODO Auto-generated method stub

			BuildingDecorate BD=new BuildingDecorate();
		    BD.setDecorateId(decorateId);
		    BD.setDecorateName(decorateName);
			hds.save(BD);
			return true;
	}
	public boolean buildingdecorateUpdate(int decorateId, String decorateName) {
		// TODO Auto-generated method stub

			BuildingDecorate BD=new BuildingDecorate();
		    BD.setDecorateId(decorateId);
		    BD.setDecorateName(decorateName);
			hds.update(BD);
			return true;
	}
	@Override
	public List<BuildingDecorate> buildingdecorateList() {
		// TODO Auto-generated method stub
		List<BuildingDecorate> list=hds.findByParameter("from BuildingDecorate");
		return list;
	}
	public boolean buildingdecorateDel(int decorateId) {
		// TODO Auto-generated method stub
		BuildingDecorate BD=new BuildingDecorate();
	    BD.setDecorateId(decorateId);
		hds.delete(BD);
		return true;
	}
	@Override
	public String buildingdecorateSearch(int decorateId) {
		// TODO Auto-generated method stub
		Object[] o={decorateId}; 
		String hql="from BuildingDecorate where decorateId=?";
		List<BuildingDecorate> list=hds.findByParameter(hql,o);
		return list.get(0).getDecorateName();
	}
}
