package com.realty.base.service;

import java.util.List;

import com.realty.base.model.BuildingStructure;

public interface BuildingStructureService {
	public boolean buildingstructureAdd(int structureId, String structureName);
	public List<BuildingStructure> buildingstructureList();
	public boolean buildingstructureUpdate(int structureId, String structureName);
	public boolean buildingstructureDel(int structureId);
	public String buildingstructureSearch(int structureId);
	
}
