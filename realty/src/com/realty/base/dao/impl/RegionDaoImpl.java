package com.realty.base.dao.impl;

import java.util.List;

import com.realty.base.dao.RegionDao;
import com.realty.base.model.Region;
import com.realty.base.utils.HibernateDaoSupport;

public class RegionDaoImpl implements RegionDao {
	HibernateDaoSupport hds=new HibernateDaoSupport();
	public boolean regionAdd(int regionId, String regionName) {
		// TODO Auto-generated method stub

			Region region=new Region();
			region.setRegionId(regionId);
			region.setRegionName(regionName);
			hds.save(region);
			return true;
	}
	public boolean regionUpdate(int regionId, String regionName) {
		// TODO Auto-generated method stub

			Region region=new Region();
			region.setRegionId(regionId);
			region.setRegionName(regionName);
			hds.update(region);
			return true;
	}
	public List<Region> regionList() {
		// TODO Auto-generated method stub
		List<Region> list=hds.findByParameter("from Region");
		return list;
	}
	@Override
	public boolean regionDel(int regionId) {
		// TODO Auto-generated method stub
		Region region=new Region();
		region.setRegionId(regionId);
		hds.delete(region);
		return true;
	}
	@Override
	public String regionSearch(int regionId) {
		// TODO Auto-generated method stub
		Object[] o={regionId}; 
		String hql="from Region where regionId=?";
		List<Region> list=hds.findByParameter(hql,o);
		return list.get(0).getRegionName();
	}

}
