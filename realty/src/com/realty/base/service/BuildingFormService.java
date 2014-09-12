package com.realty.base.service;

import java.util.List;

import com.realty.base.model.BuildingForm;

public interface BuildingFormService {
	public boolean buildingformAdd(String formId, String formName);
	public boolean buildingformUpdate(String formId, String formName);
	public List<BuildingForm> buildingformList();
	public boolean buildingformDel(String formId);
	public String buildingformSearch(String formId);
}
