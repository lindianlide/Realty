package com.realty.base.dao.impl;

import java.util.List;

import com.realty.base.dao.BuildingStructureDao;
import com.realty.base.model.BuildingStructure;
import com.realty.base.model.Region;
import com.realty.base.utils.HibernateDaoSupport;

public class BuildingStructureDaoImpl implements BuildingStructureDao {
	HibernateDaoSupport hds=new HibernateDaoSupport();
	public boolean buildingstructureAdd(int structureId, String structureName) {
		// TODO Auto-generated method stub

		    BuildingStructure BS=new BuildingStructure();
		    BS.setStructureId(structureId);
		    BS.setStructureName(structureName);
			hds.save(BS);
			return true;
	}
	public boolean buildingstructureUpdate(int structureId, String structureName) {
		// TODO Auto-generated method stub
			BuildingStructure BS=new BuildingStructure();
		    BS.setStructureId(structureId);
		    BS.setStructureName(structureName);
			hds.update(BS);
			return true;
	}
	@Override
	public List<BuildingStructure> buildingstructureList() {
		// TODO Auto-generated method stub
		List<BuildingStructure> list=hds.findByParameter("from BuildingStructure");
		return list;
	}
	public boolean buildingstructureDel(int structureId) {
		// TODO Auto-generated method stub
		BuildingStructure BS=new BuildingStructure();
	    BS.setStructureId(structureId);
		hds.delete(BS);
		return true;
	}
	@Override
	public String buildingstructureSearch(int structureId) {
		// TODO Auto-generated method stub
		Object[] o={structureId}; 
		String hql="from BuildingStructure where structureId=?";
		List<BuildingStructure> list=hds.findByParameter(hql,o);
		return list.get(0).getStructureName();
	}
}
