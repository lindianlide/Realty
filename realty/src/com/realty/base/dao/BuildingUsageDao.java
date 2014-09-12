package com.realty.base.dao;

import java.util.List;

import com.realty.base.model.BuildingUsage;

public interface BuildingUsageDao {

	boolean buildingusageAdd(int usageId, String usageName);
	boolean buildingusageUpdate(int usageId, String usageName);
	List<BuildingUsage> buildingusageList();
	public boolean buildingusageDel(int usageId);
	public String buildingusageSearch(int usageId);
}
