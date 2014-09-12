package com.realty.base.action;

import java.util.List;

import com.realty.base.model.BuildingForm;
import com.realty.base.service.BuildingFormService;
import com.realty.base.service.impl.BuildingFormServiceImpl;

public class BuildingFormAction {
	BuildingFormService BF=new BuildingFormServiceImpl();
	public boolean buildingformeAdd(String formId,String formName){
		return BF.buildingformAdd(formId,formName);
	}
	public boolean buildingformeUpdate(String formId,String formName){
		return BF.buildingformUpdate(formId,formName);
	}
	public List<BuildingForm> buildingformList(){
		return BF.buildingformList();
	}
	public boolean buildingformeDel(String formId){
		return BF.buildingformDel(formId);
	}
	public String buildingformSearch(String formId){
		// TODO Auto-generated method stub
		return BF.buildingformSearch(formId);
	}
}
