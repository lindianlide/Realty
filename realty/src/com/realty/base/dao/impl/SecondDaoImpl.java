package com.realty.base.dao.impl;

import java.util.Date;
import java.util.List;

import com.realty.base.dao.SecondDao;
import com.realty.base.model.Building;
import com.realty.base.model.BuildingLocationphoto;
import com.realty.base.model.BuildingUsage;
import com.realty.base.model.FloorUsage;
import com.realty.base.model.PriceType;
import com.realty.base.model.Secondhouse;
import com.realty.base.model.SedecoratePhoto;
import com.realty.base.model.SetypePhoto;
import com.realty.base.model.TaxType;
import com.realty.base.utils.HibernateDaoSupport;

public class SecondDaoImpl implements SecondDao {
	HibernateDaoSupport hds=new HibernateDaoSupport();
	@Override
	public boolean secondAdd(String houseName, Integer regionId,
			String propertyAdress, String propertyName, Integer usageId,
			Date exchangeTime, Double buildingArea, Integer structureId,
			String present, Double exchangePrice, Double exchangeTotle,
			Integer pricetypeId, Integer taxtypeId, Double taxTotle,
			Double taxSeller, Double taxBuyer, Integer decorateId,
			String buildingTime, String floorTotle, Integer floorSaid,
			Integer floorActual, String roomRate, String houseType,
			String orientation, String otherfile, String introduction,
			Double longitude, Double latitude, String saleTime,
			Integer entryId, String entryName, Date entryTime,
			String auditName, Date auditTime, Integer status, String remarks) {
		// TODO Auto-generated method stub
		Secondhouse secondhouse=new Secondhouse();
		secondhouse.setHouseName(houseName);
		secondhouse.setRegionId(regionId);
		secondhouse.setPropertyAdress(propertyAdress);
		secondhouse.setPropertyName(propertyName);
		secondhouse.setUsageId(usageId);
		secondhouse.setExchangeTime(exchangeTime);
		secondhouse.setBuildingArea(buildingArea);
		secondhouse.setStructureId(structureId);
		secondhouse.setPresent(present);
		secondhouse.setExchangePrice(exchangePrice);
		secondhouse.setExchangeTotle(exchangeTotle);
		secondhouse.setPricetypeId(pricetypeId);
		secondhouse.setTaxtypeId(taxtypeId);
		secondhouse.setTaxTotle(taxTotle);
		secondhouse.setTaxSeller(taxSeller);
		secondhouse.setTaxBuyer(taxBuyer);
		secondhouse.setDecorateId(decorateId);
		secondhouse.setBuildingTime(buildingTime);
		secondhouse.setFloorTotle(floorTotle);
		secondhouse.setFloorSaid(floorSaid);
		secondhouse.setFloorActual(floorActual);
		secondhouse.setRoomRate(roomRate);
		secondhouse.setHouseType(houseType);
		secondhouse.setOrientation(orientation);
		secondhouse.setOtherfile(otherfile);
		secondhouse.setIntroduction(introduction);
		secondhouse.setLongitude(longitude);
		secondhouse.setLatitude(latitude);
		secondhouse.setSaleTime(saleTime);
		secondhouse.setEntryId(entryId);
		secondhouse.setEntryName(entryName);
		secondhouse.setEntryTime(entryTime);
		secondhouse.setAuditName(auditName);
		secondhouse.setAuditTime(auditTime);
		secondhouse.setStatus(status);
		secondhouse.setRemarks(remarks);
		hds.save(secondhouse);
		return true;
	}

	@Override
	public boolean decoratephotoAdd(int houseId, String photopath) {
		// TODO Auto-generated method stub
		SedecoratePhoto decoratephoto=new SedecoratePhoto();
		decoratephoto.setHouseId(houseId);
		decoratephoto.setPhotopath(photopath);
		hds.save(decoratephoto);
		return true;
	}

	@Override
	public boolean typephotoAdd(int houseId, String photopath) {
		// TODO Auto-generated method stub
		SetypePhoto typephoto=new SetypePhoto();
		typephoto.setHouseId(houseId);
		typephoto.setPhotopath(photopath);
		hds.save(typephoto);
		return true;
	}

	@Override
	public boolean decoratephotoUpdate(int decoratephotoId, int houseId,
			String photopath) {
		// TODO Auto-generated method stub
		SedecoratePhoto decoratephoto=new SedecoratePhoto();
		decoratephoto.setDecoratephotoId(decoratephotoId);
		decoratephoto.setHouseId(houseId);
		decoratephoto.setPhotopath(photopath);
		hds.update(decoratephoto);
		return true;
	}

	@Override
	public boolean typephotoUpdate(int typephotoId, int houseId, String photopath) {
		// TODO Auto-generated method stub
		SetypePhoto typephoto=new SetypePhoto();
		typephoto.setTypephotoId(typephotoId);
		typephoto.setHouseId(houseId);
		typephoto.setPhotopath(photopath);
		hds.update(typephoto);
		return true;
	}

	@Override
	public List<SedecoratePhoto> decoratephotoList() {
		// TODO Auto-generated method stub
		List<SedecoratePhoto> list=hds.findByParameter("from SedecoratePhoto");
		return list;
	}

	@Override
	public List<SetypePhoto> typephotoList() {
		// TODO Auto-generated method stub
		List<SetypePhoto> list=hds.findByParameter("from SetypePhoto");
		return list;
	}

	@Override
	public boolean decoratephotoDel(int decoratephotoId) {
		// TODO Auto-generated method stub
		SedecoratePhoto decoratephoto=new SedecoratePhoto();
		decoratephoto.setHouseId(decoratephotoId);
		hds.delete(decoratephoto);
		return true;
	}

	@Override
	public boolean typephotoDel(int typephotoId) {
		// TODO Auto-generated method stub
		SetypePhoto typephoto=new SetypePhoto();
		typephoto.setTypephotoId(typephotoId);
		hds.delete(typephoto);
		return true;
	}

	@Override
	public List secondPhoto(int houseId, String photoTable) {
		// TODO Auto-generated method stub
		Object[] o={houseId}; 
		String sql="select photopath from "+photoTable+" where house_id =?";
		List list=hds.findByParametersql(sql,o);
		return list;
	}
	@Override
	public boolean secondusageAdd(int usageId, String usageName) {
		// TODO Auto-generated method stub
			FloorUsage FS=new FloorUsage();
			FS.setUsageId(usageId);
			FS.setUsageName(usageName);
			hds.save(FS);
			return true;
	}
	@Override
	public boolean secondusageUpdate(int usageId, String usageName) {
		// TODO Auto-generated method stub
		    FloorUsage FS=new FloorUsage();
		    FS.setUsageId(usageId);
			FS.setUsageName(usageName);
			hds.update(FS);
			return true;
	}
	@Override
	public List<FloorUsage> secondusageList() {
		// TODO Auto-generated method stub
		List<FloorUsage> list=hds.findByParameter("from FloorUsage");
		return list;
	}
	public boolean secondusageDel(int usageId) {
		// TODO Auto-generated method stub
		 FloorUsage FS=new FloorUsage();
		 FS.setUsageId(usageId);
		 hds.delete(FS);
		return true;
	}
	@Override
	public String secondusageSearch(int usageId) {
		// TODO Auto-generated method stub
		Object[] o={usageId}; 
		String hql="from FloorUsage where usageId=?";
		List<FloorUsage> list=hds.findByParameter(hql,o);
		return list.get(0).getUsageName();
	}

	@Override
	public boolean pricetypeAdd(int pricetypeId, String pricetypeName) {
		// TODO Auto-generated method stub
			PriceType PT=new PriceType();
			PT.setPricetypeId(pricetypeId);
			PT.setPricetypeName(pricetypeName);
			hds.save(PT);
			return true;
	}
	@Override
	public boolean pricetypeUpdate(int pricetypeId, String pricetypeName) {
		// TODO Auto-generated method stub
			PriceType PT=new PriceType();
			PT.setPricetypeId(pricetypeId);
			PT.setPricetypeName(pricetypeName);
			hds.update(PT);
			return true;
	}
	@Override
	public List<PriceType> pricetypeList() {
		// TODO Auto-generated method stub
		List<PriceType> list=hds.findByParameter("from PriceType");
		return list;
	}
	public boolean pricetypeDel(int pricetypeId) {
		// TODO Auto-generated method stub
		PriceType PT=new PriceType();
		PT.setPricetypeId(pricetypeId);
		 hds.delete(PT);
		return true;
	}
	
	@Override
	public String pricetypeSearch(int pricetypeId) {
		// TODO Auto-generated method stub
		Object[] o={pricetypeId}; 
		String hql="from PriceType where pricetypeId=?";
		List<PriceType> list=hds.findByParameter(hql,o);
		return list.get(0).getPricetypeName();
	}

	@Override
	public boolean taxtypeAdd(int taxtypeId, String taxtypeName) {
		// TODO Auto-generated method stub
			TaxType TY=new TaxType();
			TY.setTaxtypeId(taxtypeId);
			TY.setTaxtypeName(taxtypeName);
			hds.save(TY);
			return true;
	}
	@Override
	public boolean taxtypeUpdate(int taxtypeId, String taxtypeName) {
		// TODO Auto-generated method stub
			TaxType TY=new TaxType();
			TY.setTaxtypeId(taxtypeId);
			TY.setTaxtypeName(taxtypeName);
			hds.update(TY);
			return true;
	}
	@Override
	public List<TaxType> taxtypeList() {
		// TODO Auto-generated method stub
		List<TaxType> list=hds.findByParameter("from TaxType");
		return list;
	}
	@Override
	public boolean taxtypeDel(int taxtypeId) {
		// TODO Auto-generated method stub
		TaxType TY=new TaxType();
		TY.setTaxtypeId(taxtypeId);
		 hds.delete(TY);
		return true;
	}
	@Override
	public String taxtypeSearch(int taxtypeId) {
		// TODO Auto-generated method stub
		Object[] o={taxtypeId}; 
		String hql="from TaxType where taxtypeId=?";
		List<TaxType> list=hds.findByParameter(hql,o);
		return list.get(0).getTaxtypeName();
	}
	
	@Override
	public int getMaxId(String photoTable) {
		// TODO Auto-generated method stub
		String sql="SELECT IDENT_CURRENT('"+photoTable+"')";
		List maxId=hds.findByParametersql(sql);
		return Integer.parseInt(maxId.get(0).toString());
	}

	@Override
	public boolean secondDel(int houseId) {
		// TODO Auto-generated method stub
		Secondhouse secondhouse=new Secondhouse();
		secondhouse.setHouseId(houseId);
		boolean result=hds.delete(secondhouse);
		return result;
	}

	@Override
	public boolean secondUpdate(int houseId, String houseName,
			Integer regionId, String propertyAdress, String propertyName,
			Integer usageId, Date exchangeTime, Double buildingArea,
			Integer structureId, String present, Double exchangePrice,
			Double exchangeTotle, Integer pricetypeId, Integer taxtypeId,
			Double taxTotle, Double taxSeller, Double taxBuyer,
			Integer decorateId, String buildingTime, String floorTotle,
			Integer floorSaid, Integer floorActual, String roomRate,
			String houseType, String orientation, String otherfile,
			String introduction, Double longitude, Double latitude,
			String saleTime, Integer entryId, String entryName, Date entryTime,
			String auditName, Date auditTime, Integer status, String remarks) {
		// TODO Auto-generated method stub
		Secondhouse secondhouse=new Secondhouse();
		secondhouse.setHouseId(houseId);
		secondhouse.setHouseName(houseName);
		secondhouse.setRegionId(regionId);
		secondhouse.setPropertyAdress(propertyAdress);
		secondhouse.setPropertyName(propertyName);
		secondhouse.setUsageId(usageId);
		secondhouse.setExchangeTime(exchangeTime);
		secondhouse.setBuildingArea(buildingArea);
		secondhouse.setStructureId(structureId);
		secondhouse.setPresent(present);
		secondhouse.setExchangePrice(exchangePrice);
		secondhouse.setExchangeTotle(exchangeTotle);
		secondhouse.setPricetypeId(pricetypeId);
		secondhouse.setTaxtypeId(taxtypeId);
		secondhouse.setTaxTotle(taxTotle);
		secondhouse.setTaxSeller(taxSeller);
		secondhouse.setTaxBuyer(taxBuyer);
		secondhouse.setDecorateId(decorateId);
		secondhouse.setBuildingTime(buildingTime);
		secondhouse.setFloorTotle(floorTotle);
		secondhouse.setFloorSaid(floorSaid);
		secondhouse.setFloorActual(floorActual);
		secondhouse.setRoomRate(roomRate);
		secondhouse.setHouseType(houseType);
		secondhouse.setOrientation(orientation);
		secondhouse.setOtherfile(otherfile);
		secondhouse.setIntroduction(introduction);
		secondhouse.setLongitude(longitude);
		secondhouse.setLatitude(latitude);
		secondhouse.setSaleTime(saleTime);
		secondhouse.setEntryId(entryId);
		secondhouse.setEntryName(entryName);
		secondhouse.setEntryTime(entryTime);
		secondhouse.setAuditName(auditName);
		secondhouse.setAuditTime(auditTime);
		secondhouse.setStatus(status);
		secondhouse.setRemarks(remarks);
		hds.update(secondhouse);
		return true;
	}

	@Override
	public List<Secondhouse> secondList() {
		// TODO Auto-generated method stub
		List<Secondhouse> list=hds.findByParameter("from Secondhouse");
		return list;
	}

	@Override
	public List<Secondhouse> secondList(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql="from Secondhouse";
		List<Secondhouse> list=hds.findByParameter(hql, null, pageNo, pageSize);
		return list;
	}

	@Override
	public List<Secondhouse> secondSearch(String houseName) {
		// TODO Auto-generated method stub
		Object[] o={houseName}; 
		//List<Building> list=hds.findByParameter("from Building where buildingName like '%'+?+'%' ",o);
		List<Secondhouse> list=hds.findByParameter("from Secondhouse where houseName =?",o);
		return list;
	}

	@Override
	public int secondCount(int regionId, int usageId, int averagePrice,String likeName) {
		// TODO Auto-generated method stub
		String sql=" select count(1) from secondhouse where 1=1 ";
		if(regionId!=0){
			sql+=" and region_id='" + regionId+"'";
		}
		if(usageId!=0)
		{
			sql+=" and usage_id='"+usageId+"'";
		}
		if(averagePrice!=0){
			switch (averagePrice) {
			case  1: sql+=" and exchange_price<=6000";
			break;				
			case  2: sql+=" and exchange_price>6000 and exchange_price<=8000";
			break;
			case  3: sql+=" and exchange_price>8000 and exchange_price<=12000";
			break;
			case  4: sql+=" and exchange_price>12000";
			break;
			default:
				break;
				}
			}	
		if(likeName!=null)
		{ 
			sql+=" and house_name like '%'+'"+likeName+"'+'%' ";
		}
		List counts=hds.findByParametersql(sql);
		return Integer.parseInt(counts.get(0).toString());	
	}

	@Override
	public List<Secondhouse> secondSearch(int regionId, int usageId,
			int exchangePrice, String likeName, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql=" from Secondhouse where 1=1 ";
		if(regionId!=0){
			hql+=" and regionId='" + regionId+"'";
		}
		if(usageId!=0)
		{
			hql+=" and usageId='"+usageId+"'";
		}
		if(exchangePrice!=0){
			switch (exchangePrice) {
			case  1: hql+=" and exchangePrice<=6000";
			break;				
			case  2: hql+=" and exchangePrice>6000 and exchangePrice<=8000";
			break;
			case  3: hql+=" and exchangePrice>8000 and exchangePrice<=10000";
			break;
			case  4: hql+=" and exchangePrice>10000 and exchangePrice<=12000";
			break;
			case  5: hql+=" and exchangePrice>12000";
			break;
			default:
				break;
				}
			}	
		if(likeName!=null)
		{ 
			hql+=" and house_name like '%'+'"+likeName+"'+'%' ";
		}
		List<Secondhouse> list=hds.findByParameter(hql, null, pageNo, pageSize);
	return list;

	}

	@Override
	public List<Secondhouse> serachsecond(Integer houseId, String memrole) {
		// TODO Auto-generated method stub
		int memroleint =Integer.parseInt(memrole);
		if(memroleint<=1){
		Object[] o={houseId}; 
		List<Secondhouse> list=hds.findByParameter("from Secondhouse where houseId =?",o);
		list.get(0).setPropertyAdress("");
		return list;
		}else if (memroleint==2){
			Object[] o={houseId}; 
			List<Secondhouse> list=hds.findByParameter("from Secondhouse where houseId =?",o);
			return list;
		}else{
			Object[] o={houseId}; 
			List<Secondhouse> list=hds.findByParameter("from Secondhouse where houseId =?",o);
			return list;
		}
	}


}
