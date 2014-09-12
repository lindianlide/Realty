package com.realty.base.service.impl;

import java.util.List;

import com.realty.base.dao.BuildingDecorateDao;
import com.realty.base.dao.impl.BuildingDecorateDaoImpl;
import com.realty.base.model.BuildingDecorate;
import com.realty.base.service.BuildingDecorateService;

public class BuildingDecorateServiceImpl implements BuildingDecorateService{
	BuildingDecorateDao BDDao=new BuildingDecorateDaoImpl();
	@Override
	public boolean buildingdecorateAdd(int decorateId, String decorateName) {
		// TODO Auto-generated method stub
		return BDDao.buildingdecorateAdd(decorateId,decorateName);
	}
	@Override
	public List<BuildingDecorate> buildingdecorateList() {
		// TODO Auto-generated method stub
		return BDDao.buildingdecorateList();
	}
	@Override
	public boolean buildingdecorateUpdate(int decorateId, String decorateName) {
		// TODO Auto-generated method stub
		return BDDao.buildingdecorateUpdate(decorateId, decorateName);
	}
	@Override
	public boolean buildingdecorateDel(int decorateId) {
		// TODO Auto-generated method stub
		return BDDao.buildingdecorateDel(decorateId);
	}
	@Override
	public String buildingdecorateSearch(int decorateId){
		// TODO Auto-generated method stub
		return BDDao.buildingdecorateSearch(decorateId);
	}
}
