package com.realty.base.dao;

import java.util.List;
import com.realty.base.model.Region;

public interface RegionDao {

	public boolean regionAdd(int regionId, String regionName);
	public boolean regionUpdate(int regionId, String regionName);
	public List<Region> regionList();
	public boolean regionDel(int regionId);
	public String regionSearch(int regionId);
}
