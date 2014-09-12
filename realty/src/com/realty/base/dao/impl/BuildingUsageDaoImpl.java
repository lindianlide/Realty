package com.realty.base.dao.impl;

import java.util.List;

import com.realty.base.dao.BuildingUsageDao;
import com.realty.base.model.BuildingUsage;
import com.realty.base.model.Region;
import com.realty.base.utils.HibernateDaoSupport;

public class BuildingUsageDaoImpl implements BuildingUsageDao {
	HibernateDaoSupport hds=new HibernateDaoSupport();
	public boolean buildingusageAdd(int usageId, String usageName) {
		// TODO Auto-generated method stub

			BuildingUsage BS=new BuildingUsage();
			BS.setUsageId(usageId);
			BS.setUsageName(usageName);
			hds.save(BS);
			return true;
	}
	public boolean buildingusageUpdate(int usageId, String usageName) {
		// TODO Auto-generated method stub

			BuildingUsage BS=new BuildingUsage();
			BS.setUsageId(usageId);
			BS.setUsageName(usageName);
			hds.update(BS);
			return true;
	}
	@Override
	public List<BuildingUsage> buildingusageList() {
		// TODO Auto-generated method stub
		List<BuildingUsage> list=hds.findByParameter("from BuildingUsage");
		return list;
	}
	public boolean buildingusageDel(int usageId) {
		// TODO Auto-generated method stub
		BuildingUsage BS=new BuildingUsage();
		BS.setUsageId(usageId);
		hds.delete(BS);
		return true;
	}
	@Override
	public String buildingusageSearch(int usageId) {
		// TODO Auto-generated method stub
		Object[] o={usageId}; 
		String hql="from BuildingUsage where usageId=?";
		List<BuildingUsage> list=hds.findByParameter(hql,o);
		return list.get(0).getUsageName();
	}
}
