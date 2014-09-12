package com.realty.base.service;

import java.util.List;

import com.realty.base.model.Region;

public interface RegionService {
	public boolean regionAdd(int regionId, String regionName) ;
	public boolean regionUpdate(int regionId, String regionName) ;
	public List<Region> regionList();
	public boolean regionDel(int regionId);
	public String regionSearch(int regionId);
}
