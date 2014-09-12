package com.realty.base.service.impl;

import java.util.List;

import com.realty.base.dao.BuildingStructureDao;
import com.realty.base.dao.impl.BuildingStructureDaoImpl;
import com.realty.base.model.BuildingStructure;
import com.realty.base.service.BuildingStructureService;

public class BuildingStructureServiceIml implements BuildingStructureService{
	BuildingStructureDao BSDao=new BuildingStructureDaoImpl();
	@Override
	public boolean buildingstructureAdd(int structureId, String structureName) {
		// TODO Auto-generated method stub
		return BSDao.buildingstructureAdd(structureId, structureName);
	}
	@Override
	public List<BuildingStructure> buildingstructureList() {
		// TODO Auto-generated method stub
		return BSDao.buildingstructureList();
	}
	@Override
	public boolean buildingstructureUpdate(int structureId, String structureName){
		// TODO Auto-generated method stub
		return BSDao.buildingstructureUpdate(structureId, structureName);
	}
	@Override
	public boolean buildingstructureDel(int structureId){
		// TODO Auto-generated method stub
		return BSDao.buildingstructureDel(structureId);
	}
	@Override
	public String buildingstructureSearch(int structureId){
		// TODO Auto-generated method stub
		return BSDao.buildingstructureSearch(structureId);
	}
}

