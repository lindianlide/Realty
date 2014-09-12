package com.realty.base.dao.impl;

import java.util.Date;
import java.util.List;

import com.realty.base.dao.LandDao;
import com.realty.base.model.FloorUsage;
import com.realty.base.model.Land;
import com.realty.base.model.LandAllot;
import com.realty.base.model.LandLocation;
import com.realty.base.model.LandMutiusage;
import com.realty.base.model.LandPhoto;
import com.realty.base.model.LandPoss;
import com.realty.base.model.LandSellway;
import com.realty.base.model.LandUsage;
import com.realty.base.utils.GenericDao;
import com.realty.base.utils.GenericDaoHibernate;
import com.realty.base.utils.HibernateDaoSupport;

public  class LandDaoImpl  implements LandDao {
	HibernateDaoSupport hds=new HibernateDaoSupport();		
	
	@Override
	public boolean landphotoAdd(int landId, String photopath) {
		// TODO Auto-generated method stub
		LandPhoto landphoto=new LandPhoto();
		landphoto.setLandId(landId);
		landphoto.setPhotopath(photopath);
		hds.save(landphoto);
		return true;
	}

	@Override
	public boolean landlocationphotoAdd(int landId, String photopath) {
		// TODO Auto-generated method stub
		LandLocation landlocation=new LandLocation();
		landlocation.setLandId(landId);
		landlocation.setPhotopath(photopath);
		hds.save(landlocation);
		return true;
	}

	@Override
	public boolean landphotoUpdate(int landphotoId, int landId,String photopath){
		// TODO Auto-generated method stub
		LandPhoto landphoto=new LandPhoto();
		landphoto.setLandphotoId(landphotoId);
		landphoto.setLandId(landId);
		landphoto.setPhotopath(photopath);
		hds.update(landphoto);
		return true;
	}

	@Override
	public boolean landlocationUpdate(int landlocationId, int landId, String photopath) {
		// TODO Auto-generated method stub
		LandLocation landlocation=new LandLocation();
		landlocation.setLandlocationId(landlocationId);
		landlocation.setLandId(landId);
		landlocation.setPhotopath(photopath);
		hds.update(landlocation);
		return true;
	}		
	@Override
	public List<LandPhoto> landphotoList() {
		// TODO Auto-generated method stub
		List<LandPhoto> list=hds.findByParameter("from LandPhoto");
		return list;
	}

	@Override
	public List<LandLocation> landlocationList() {
		// TODO Auto-generated method stub
		List<LandLocation> list=hds.findByParameter("from LandLocation");
		return list;
	}

	@Override
	public boolean landphotoDel(int landphotoId) {
		// TODO Auto-generated method stub
		LandPhoto landphoto=new LandPhoto();
		landphoto.setLandphotoId(landphotoId);
		hds.delete(landphoto);
		return true;
	}

	@Override
	public boolean landlocationDel(int landlocationId) {
		// TODO Auto-generated method stub
		LandLocation landlocation=new LandLocation();
		landlocation.setLandlocationId(landlocationId);
		hds.delete(landlocation);
		return true;
	}

	@Override
	public List landPhoto(int landId, String photoTable) {
		// TODO Auto-generated method stub
		Object[] o={landId}; 
		String sql="select photopath  from "+photoTable+" where land_id =?";
		List list=hds.findByParametersql(sql,o);
		return list;
	}
	@Override
	public boolean landusageAdd(int usageId, String usageName) {
		// TODO Auto-generated method stub
			LandUsage LS=new LandUsage();
			//LS.setUsageId(usageId);
			LS.setUsageName(usageName);
			hds.save(LS);
			return true;
	}
	@Override
	public boolean landusageUpdate(int usageId, String usageName) {
		// TODO Auto-generated method stub
			LandUsage LS=new LandUsage();
			LS.setUsageId(usageId);
			LS.setUsageName(usageName);
			hds.update(LS);
			return true;
	}
	@Override
	public List<LandUsage> landusageList() {
		// TODO Auto-generated method stub
		List<LandUsage> list=hds.findByParameter("from LandUsage");
		return list;
	}
	public boolean landusageDel(int usageId) {
		// TODO Auto-generated method stub
			LandUsage LS=new LandUsage();
			LS.setUsageId(usageId);
		 hds.delete(LS);
		return true;
	}
	@Override
	public String landusageSearch(int usageId) {
		// TODO Auto-generated method stub
		Object[] o={usageId}; 
		String hql="from LandUsage where usageId=?";
		List<LandUsage> list=hds.findByParameter(hql,o);
		return list.get(0).getUsageName();
	}

	@Override
	public boolean landpossAdd(int landpossId, String landpossName) {
		// TODO Auto-generated method stub
			LandPoss LP=new LandPoss();
			LP.setLandpossId(landpossId);
			LP.setLandpossName(landpossName);
			hds.save(LP);
			return true;
	}
	@Override
	public boolean landpossUpdate(int landpossId, String landpossName) {
		// TODO Auto-generated method stub
			LandPoss LP=new LandPoss();
			LP.setLandpossId(landpossId);
			LP.setLandpossName(landpossName);
			hds.update(LP);
			return true;
	}
	@Override
	public List<LandPoss> landpossList() {
		// TODO Auto-generated method stub
		List<LandPoss> list=hds.findByParameter("from LandPoss");
		return list;
	}
	@Override
	public boolean landpossDel(int landpossId) {
		// TODO Auto-generated method stub
			LandPoss LP=new LandPoss();
			LP.setLandpossId(landpossId);
			hds.delete(LP);
			return true;
	}
	
	@Override
	public String landpossSearch(int landpossId) {
		// TODO Auto-generated method stub
		Object[] o={landpossId}; 
		String hql="from LandPoss where landpossId=?";
		List<LandPoss> list=hds.findByParameter(hql,o);
		return list.get(0).getLandpossName();
	}

	@Override
	public boolean sellwayAdd(int sellwayId, String sellwayName) {
		// TODO Auto-generated method stub
			LandSellway LSW=new LandSellway();
			LSW.setSellwayId(sellwayId);
			LSW.setSellwayName(sellwayName);
			hds.save(LSW);
			return true;
	}
	@Override
	public boolean sellwayUpdate(int sellwayId, String sellwayName) {
		// TODO Auto-generated method stub
			LandSellway LSW=new LandSellway();
			LSW.setSellwayId(sellwayId);
			LSW.setSellwayName(sellwayName);
			hds.update(LSW);
			return true;
	}
	@Override
	public List<LandSellway> sellwayList() {
		// TODO Auto-generated method stub
		List<LandSellway> list=hds.findByParameter("from LandSellway");
		return list;
	}
	@Override
	public boolean sellwayDel(int sellwayId) {
		// TODO Auto-generated method stub
		LandSellway LSW=new LandSellway();
		LSW.setSellwayId(sellwayId);
		 hds.delete(LSW);
		return true;
	}
	@Override
	public String sellwaySearch(int sellwayId) {
		// TODO Auto-generated method stub
		Object[] o={sellwayId}; 
		String hql="from LandSellway where sellwayId=?";
		List<LandSellway> list=hds.findByParameter(hql,o);
		return list.get(0).getSellwayName();
	}
	
	@Override
	public int getMaxId(String photoTable) {
		// TODO Auto-generated method stub
		String sql="SELECT IDENT_CURRENT('"+photoTable+"')";
		List maxId=hds.findByParametersql(sql);
		return Integer.parseInt(maxId.get(0).toString());
	}


	@Override
	public List<Land> landSearch(String landName) {
		// TODO Auto-generated method stub
		Object[] o={landName}; 
		//List<Building> list=hds.findByParameter("from Building where buildingName like '%'+?+'%' ",o);
		List<Land> list=hds.findByParameter("from Land where landName =?",o);
		return list;
	}

	@Override
	public int landCount(int regionId, int usageId, int landdealPrice,String likeName) {
		// TODO Auto-generated method stub
		String sql=" select count(1) from Land where 1=1 ";
		if(regionId!=0){
			sql+=" and region_id='" + regionId+"'";
		}
		if(usageId!=0)
		{
			sql+=" and usage_id='"+usageId+"'";
		}
		if(landdealPrice!=0){
			switch (landdealPrice) {
			case  1: sql+=" and landdeal_price<=6000";
			break;				
			case  2: sql+=" and landdeal_price>6000 and landdeal_price<=8000";
			break;
			case  3: sql+=" and landdeal_price>8000 and landdeal_price<=12000";
			break;
			case  4: sql+=" and landdeal_price>12000";
			break;
			default:
				break;
				}
			}	
		if(likeName!=null)
		{ 
			sql+=" and land_name like '%'+'"+likeName+"'+'%' ";
		}
		List counts=hds.findByParametersql(sql);
		return Integer.parseInt(counts.get(0).toString());	
	}

	@Override
	public List<Land> landSearch(int regionId, int usageId,
			int landdealPrice, String likeName, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql=" from Land where 1=1 ";
		if(regionId!=0){
			hql+=" and regionId='" + regionId+"'";
		}
		if(usageId!=0)
		{
			switch (usageId) {
			case  1: hql+=" and land_allarea<=5000";
			break;				
			case  2: hql+=" and land_allarea>5000 and land_allarea<=10000";
			break;
			case  3: hql+=" and land_allarea>10000 and land_allarea<=20000";
			break;
			case  4: hql+=" and land_allarea>20000 and land_allarea<=30000";
			break;
			case  5: hql+=" and land_allarea>30000";
			break;
			default:
				break;
				}
		}
		if(landdealPrice!=0){
			switch (landdealPrice) {
			case  1: hql+=" and land_allarea<=10000";
			break;				
			case  2: hql+=" and land_allarea>10000 and land_allarea<=20000";
			break;
			case  3: hql+=" and land_allarea>20000 and land_allarea<=30000";
			break;
			case  4: hql+=" and land_allarea>30000 and land_allarea<=40000";
			break;
			case  5: hql+=" and land_allarea>40000";
			break;
			default:
				break;
				}
			}	
		if(likeName!=null)
		{ 
			hql+=" and land_name like '%'+'"+likeName+"'+'%' ";
		}
		List<Land> list=hds.findByParameter(hql, null, pageNo, pageSize);
	return list;

	}

	@Override
	public List<Land> searchLand(Integer landId, String memrole) {
		// TODO Auto-generated method stub
		int memroleint =Integer.parseInt(memrole);
		if(memroleint<=1){
		Object[] o={landId}; 
		List<Land> list=hds.findByParameter("from Land where landId =?",o);
		list.get(0).setAddress(null);
		return list;
		}else if (memroleint==2){
			Object[] o={landId}; 
			List<Land> list=hds.findByParameter("from Land where landId =?",o);
			return list;
		}else{
			Object[] o={landId}; 
			List<Land> list=hds.findByParameter("from Land where landId =?",o);
			return list;
		}
	}
	@Override
	public List landbuildingPhoto(int landId,String photoTable) {
		// TODO Auto-generated method stub
		Object[] o={landId}; 
		//List<Building> list=hds.findByParameter("from Building where buildingName like '%'+?+'%' ",o);
		String sql="select photopath  from "+photoTable+" l  where l.land_id =?";
		//List list=hds.findByParameter("select location_photo from building_locationphoto l ,building b where l.building_id =b.building_id and b.building_id=?",o);
		List list=hds.findByParametersql(sql,o);
		return list;
	}

	@Override
	public List<LandMutiusage> landzpgsearch(int landId) {
		// TODO Auto-generated method stub
		Object[] o={landId}; 
		//List<Building> list=hds.findByParameter("from Building where buildingName like '%'+?+'%' ",o);
		List<LandMutiusage> list=hds.findByParameter("from LandMutiusage where landId =?",o);
		return list;
	}

	@Override
	public List<LandAllot> landallotsearch(int landId) {
		// TODO Auto-generated method stub
		Object[] o={landId}; 
		//List<Building> list=hds.findByParameter("from Building where buildingName like '%'+?+'%' ",o);
		List<LandAllot> list=hds.findByParameter("from LandAllot where landId =?",o);
		return list;
	}
	@Override
	public boolean landsellUpdate(int landId,String sellAnnounce) {
		// TODO Auto-generated method stub
		Object[] o={sellAnnounce,landId};
		String hql="update Land set sellAnnounce=? where landId = ?";
		hds.batchUpdate(hql,o);
		return true;
	}
	@Override
	public boolean landdealUpdate(int landId,String dealAnnounce) {
		// TODO Auto-generated method stub
		Object[] o={dealAnnounce,landId};
		String hql="update Land set dealAnnounce=? where landId = ?";
		hds.batchUpdate(hql,o);
		return true;
	}

}
