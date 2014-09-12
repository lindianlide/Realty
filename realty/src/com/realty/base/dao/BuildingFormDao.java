package com.realty.base.dao;

import java.util.List;

import com.realty.base.model.BuildingForm;

public interface BuildingFormDao {

	public boolean buildingformAdd(String formId, String formName);
	public boolean buildingformUpdate(String formId, String formName);
	public List<BuildingForm> buildingformList();
	public boolean buildingformDel(String formId);
	public String buildingformSearch(String formId);
}
