package com.realty.base.dao;

import java.util.List;

import com.realty.base.model.BuildingStructure;

public interface BuildingStructureDao {

	boolean buildingstructureAdd(int structureId, String structureName);
	boolean buildingstructureUpdate(int structureId, String structureName);
	List<BuildingStructure> buildingstructureList();
	public boolean buildingstructureDel(int structureId);
	public String buildingstructureSearch(int structureId);
}
