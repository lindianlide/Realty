package com.realty.base.action;

import java.util.List;

import com.realty.base.model.BuildingStructure;
import com.realty.base.service.BuildingStructureService;
import com.realty.base.service.impl.BuildingStructureServiceIml;

public class BuildingStructureAction {
	BuildingStructureService BS=new BuildingStructureServiceIml();
	public boolean buildingstructureAdd(int structureId, String structureName) {
		return BS.buildingstructureAdd(structureId, structureName);
	}
	public List<BuildingStructure> buildingstructureList() {
		return BS.buildingstructureList();
	}
	public boolean buildingstructureUpdate(int structureId, String structureName){
		return BS.buildingstructureUpdate(structureId, structureName);
	}
	public boolean buildingstructureDel(int structureId){
		return BS.buildingstructureDel(structureId);
	}
	public String buildingstructureSearch(int structureId){
		// TODO Auto-generated method stub
		return BS.buildingstructureSearch(structureId);
	}
}
