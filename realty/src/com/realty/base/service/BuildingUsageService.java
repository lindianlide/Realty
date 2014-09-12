package com.realty.base.service;

import java.util.List;

import com.realty.base.model.BuildingUsage;

public interface BuildingUsageService {
	public boolean buildingusageAdd(int usageId, String usageName);
	public boolean buildingusageUpdate(int usageId, String usageName);
	public List<BuildingUsage> buildingusageList();
	public boolean buildingusageDel(int usageId);
	public String buildingusageSearch(int usageId);
}
