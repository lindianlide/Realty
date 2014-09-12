package com.realty.base.action;

import java.util.List;

import com.realty.base.model.Region;
import com.realty.base.service.RegionService;
import com.realty.base.service.impl.RegionServiceImpl;

public class RegionAction {
	RegionService region=new RegionServiceImpl();
	public boolean regionAdd(int regionId, String regionName) {
		return region.regionAdd(regionId, regionName);
	}

	public boolean regionUpdate(int regionId, String regionName) {
		return region.regionUpdate(regionId, regionName);
	}

	public List<Region> regionList() {
		return region.regionList();
	}

	public boolean regionDel(int regionId) {
		return region.regionDel(regionId);
	}
	public String regionSearch(int regionId) {
		return region.regionSearch(regionId);
	}
}
