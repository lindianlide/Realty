package com.realty.base.action;

import java.util.List;

import com.realty.base.model.BuildingDecorate;
import com.realty.base.service.BuildingDecorateService;
import com.realty.base.service.impl.BuildingDecorateServiceImpl;

public class BuildingDecorateAction {
	BuildingDecorateService BD=new BuildingDecorateServiceImpl();
	public boolean buildingdecorateAdd(int decorateId,String decorateName){
		return BD.buildingdecorateAdd(decorateId,decorateName);
	}
	public boolean buildingdecorateUpdate(int decorateId,String decorateName){
		return BD.buildingdecorateAdd(decorateId,decorateName);
	}
	public List<BuildingDecorate> buildingdecorateList(){
		return BD.buildingdecorateList();
	}
	public boolean buildingdecorateDel(int decorateId){
		return BD.buildingdecorateDel(decorateId);
	}
	public String buildingdecorateSearch(int decorateId){
		// TODO Auto-generated method stub
		return BD.buildingdecorateSearch(decorateId);
	}
}
