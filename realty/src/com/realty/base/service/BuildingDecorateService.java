package com.realty.base.service;

import java.util.List;

import com.realty.base.model.BuildingDecorate;

public interface BuildingDecorateService {
	public boolean buildingdecorateAdd(int decorateId, String decorateName);
	public boolean buildingdecorateUpdate(int decorateId, String decorateName);
	public List<BuildingDecorate> buildingdecorateList();
	public boolean buildingdecorateDel(int decorateId);
	public String buildingdecorateSearch(int decorateId);
}
