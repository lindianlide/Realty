package com.realty.base.service.impl;

import java.util.List;

import com.realty.base.dao.BuildingUsageDao;
import com.realty.base.dao.impl.BuildingUsageDaoImpl;
import com.realty.base.model.BuildingUsage;
import com.realty.base.service.BuildingUsageService;

public class BuildingUsageServiceImpl implements BuildingUsageService{
	BuildingUsageDao BUDao=new BuildingUsageDaoImpl();

	@Override
	public boolean buildingusageAdd(int usageId, String usageName) {
		// TODO Auto-generated method stub
		return BUDao.buildingusageAdd(usageId, usageName);
	}

	@Override
	public boolean buildingusageUpdate(int usageId, String usageName) {
		// TODO Auto-generated method stub
		return BUDao.buildingusageUpdate(usageId, usageName);
	}

	@Override
	public List<BuildingUsage> buildingusageList() {
		// TODO Auto-generated method stub
		return BUDao.buildingusageList();
	}

	@Override
	public boolean buildingusageDel(int usageId) {
		// TODO Auto-generated method stub
		return BUDao.buildingusageDel(usageId);
	}
	@Override
	public String buildingusageSearch(int usageId) {
		// TODO Auto-generated method stub
		return BUDao.buildingusageSearch(usageId);
	}
}
