package com.realty.base.action;

import java.util.List;

import com.realty.base.model.BuildingUsage;
import com.realty.base.service.BuildingUsageService;
import com.realty.base.service.impl.BuildingUsageServiceImpl;

public class BuildingUsageAction {
	BuildingUsageService BU=new BuildingUsageServiceImpl();
	public boolean buildingusageAdd(int usageId, String usageName) {
		return BU.buildingusageAdd(usageId, usageName);
	}
	public boolean buildingusageUpdate(int usageId, String usageName) {
		return BU.buildingusageUpdate(usageId, usageName);
	}
	public List<BuildingUsage> buildingusageList() {
		return BU.buildingusageList();
	}
	public boolean buildingusageDel(int usageId) {
		return BU.buildingusageDel(usageId);
	}
	public String buildingusageSearch(int usageId) {
		return BU.buildingusageSearch(usageId);
	}
}
