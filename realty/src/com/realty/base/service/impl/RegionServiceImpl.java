package com.realty.base.service.impl;

import java.util.List;

import com.realty.base.dao.RegionDao;
import com.realty.base.dao.impl.RegionDaoImpl;
import com.realty.base.model.Region;
import com.realty.base.service.RegionService;

public class RegionServiceImpl implements RegionService{
	RegionDao regionDao=new RegionDaoImpl();

	@Override
	public boolean regionAdd(int regionId, String regionName) {
		// TODO Auto-generated method stub
		return regionDao.regionAdd(regionId, regionName);
	}

	@Override
	public boolean regionUpdate(int regionId, String regionName) {
		// TODO Auto-generated method stub
		return regionDao.regionUpdate(regionId, regionName);
	}

	@Override
	public List<Region> regionList() {
		// TODO Auto-generated method stub
		return regionDao.regionList();
	}

	@Override
	public boolean regionDel(int regionId) {
		// TODO Auto-generated method stub
		return regionDao.regionDel(regionId);
	}

	public String regionSearch(int regionId){
		// TODO Auto-generated method stub
		return regionDao.regionSearch(regionId);
	}
}
