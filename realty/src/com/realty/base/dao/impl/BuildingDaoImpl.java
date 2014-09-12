package com.realty.base.dao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import com.realty.base.dao.BuildingDao;
import com.realty.base.model.Building;
import com.realty.base.model.BuildingIntro;
import com.realty.base.model.BuildingLocationphoto;
import com.realty.base.model.BuildingPhoto;
import com.realty.base.model.BuildingPlanphoto;
import com.realty.base.model.BuildingTypephoto;
import com.realty.base.model.Floor;
import com.realty.base.utils.HibernateDaoSupport;


public class BuildingDaoImpl implements BuildingDao {
	HibernateDaoSupport hds=new HibernateDaoSupport();
	@Override
	public boolean buildingAdd(String buildingName,
			String buildingAlias, int regionId, String propertyAdress,
			String propertyName, int usageId, int buildtimeId,
			String developers, Double floorArea, Double buildingArea,
			int structureId, String formId, String plotRatio, Date landuseTime,
			String buildingDensity, String greeningRate,
			BigDecimal parkingRatio, int decorateId, Date openTime,
			String propertyService, Double initialPrice, Double averagePrice,
			Double perPrice, Double totalPrice, String locationphoto,
			int landId, int buildintroId, Double longitude, Double latitude,
			int entryId, String entryName, Date entryTime, String auditName,
			Date auditTime, int status, String remarks) {
		// TODO Auto-generated method stub
		Building building=new Building();
		building.setBuildingName(buildingName);
		building.setBuildingAlias(buildingAlias);
		building.setRegionId(regionId);
		building.setPropertyAdress(propertyAdress);
		building.setPropertyName(propertyName);
		building.setUsageId(usageId);
		building.setBuildtimeId(buildtimeId);
		building.setDevelopers(developers);
		building.setFloorArea(floorArea);
		building.setBuildingArea(buildingArea);
		building.setStructureId(structureId);
		building.setFormId(formId);
		building.setPlotRatio(plotRatio);
		building.setLanduseTime(landuseTime);
		building.setBuildingDensity(buildingDensity);
		building.setGreeningRate(greeningRate);
		building.setParkingRatio(parkingRatio);
		building.setDecorateId(decorateId);
		building.setOpenTime(openTime);
		building.setPropertyService(propertyService);
		building.setInitialPrice(initialPrice);
		building.setAveragePrice(averagePrice);
		building.setPerPrice(perPrice);
		building.setTotalPrice(totalPrice);
		building.setLocationphoto(locationphoto);
		building.setLandId(landId);
		building.setBuildintroId(buildintroId);
		building.setLongitude(longitude);
		building.setLatitude(latitude);
		building.setEntryId(entryId);
		building.setEntryName(entryName);
		building.setEntryTime(entryTime);
		building.setAuditName(auditName);
		building.setAuditTime(auditTime);
		building.setStatus(status);
		building.setRemarks(remarks);
		hds.save(building);
		return true;
	}
	public boolean locationphotoAdd(int buildingId,String locationPhoto){
		BuildingLocationphoto locationphoto=new BuildingLocationphoto();
		locationphoto.setBuildingId(buildingId);
		locationphoto.setLocationPhoto(locationPhoto);
		hds.save(locationphoto);
		return true;
	}
	public boolean buildingphotoAdd(int buildingId,String buildingPhoto){
		BuildingPhoto buildingph=new BuildingPhoto();
		buildingph.setBuildingId(buildingId);
		buildingph.setBuildingPhoto(buildingPhoto);
		hds.save(buildingph);
		return true;	
	}
	public boolean planphotoAdd(int buildingId,String planPhoto){
		BuildingPlanphoto planph=new BuildingPlanphoto();
		planph.setBuildingId(buildingId);
		planph.setPlanPhoto(planPhoto);
		hds.save(planph);
		return true;
	}
	public boolean typephotoAdd(int buildingId,String typePhoto){
		BuildingTypephoto typeph=new BuildingTypephoto();
		typeph.setBuildingId(buildingId);
		typeph.setTypePhoto(typePhoto);
		hds.save(typeph);
		return true;
	}
	
	public boolean locationphotoUpdate(int locationphotoId,int buildingId,String locationPhoto){
		BuildingLocationphoto locationphoto=new BuildingLocationphoto();
		locationphoto.setLocationphotoId(locationphotoId);
		locationphoto.setBuildingId(buildingId);
		locationphoto.setLocationPhoto(locationPhoto);
		hds.update(locationphoto);
		return true;
	}
	public boolean buildingphotoUpdate(int buildingPhotoId,int buildingId,String buildingPhoto){
		BuildingPhoto buildingph=new BuildingPhoto();
		buildingph.setBuildingPhotoId(buildingPhotoId);
		buildingph.setBuildingId(buildingId);
		buildingph.setBuildingPhoto(buildingPhoto);
		hds.update(buildingph);
		return true;	
	}
	public boolean planphotoUpdate(int planphotoId,int buildingId,String planPhoto){
		BuildingPlanphoto planph=new BuildingPlanphoto();
		planph.setPlanphotoId(planphotoId);
		planph.setBuildingId(buildingId);
		planph.setPlanPhoto(planPhoto);
		hds.update(planph);
		return true;
	}
	public boolean typephotoUpdate(int typephotoId,int buildingId,String typePhoto){
		BuildingTypephoto typeph=new BuildingTypephoto();
		typeph.setTypephotoId(typephotoId);
		typeph.setBuildingId(buildingId);
		typeph.setTypePhoto(typePhoto);
		hds.update(typeph);
		return true;
	}
	public List<BuildingLocationphoto> locationphotoList()
	{
		List<BuildingLocationphoto> list=hds.findByParameter("from BuildingLocationphoto");
		return list;
	}
	public List<BuildingPhoto> buildingphotoList()
	{
		List<BuildingPhoto> list=hds.findByParameter("from BuildingPhoto");
		return list;
	}
	public List<BuildingPlanphoto> planphotoList()
	{
		List<BuildingPlanphoto> list=hds.findByParameter("from BuildingPlanphoto");
		return list;
	}
	public List<BuildingTypephoto> typephotoList()
	{
		List<BuildingTypephoto> list=hds.findByParameter("from BuildingTypephoto");
		return list;
	}
	public boolean locationphotoDel(int locationphotoId)
	{
		BuildingLocationphoto locationphoto=new BuildingLocationphoto();
		locationphoto.setLocationphotoId(locationphotoId);
		locationphoto.setBuildingId(0);
		locationphoto.setLocationPhoto("0");
		hds.delete(locationphoto);
		return true;
	}
	public boolean buildingphotoDel(int buildingPhotoId)
	{
		BuildingPhoto buildingph=new BuildingPhoto();
		buildingph.setBuildingPhotoId(buildingPhotoId);
		buildingph.setBuildingId(0);
		buildingph.setBuildingPhoto("0");
		hds.delete(buildingph);
		return true;		
	}
	public boolean planphotoDel(int planphotoId)
	{
		BuildingPlanphoto planph=new BuildingPlanphoto();
		planph.setPlanphotoId(planphotoId);
		planph.setBuildingId(0);
		planph.setPlanPhoto("0");
		hds.delete(planph);
		return true;
	}
	public boolean typephotoDel(int typephotoId)
	{
		BuildingTypephoto typeph=new BuildingTypephoto();
		typeph.setTypephotoId(typephotoId);
		typeph.setBuildingId(0);
		typeph.setTypePhoto("0");
		hds.delete(typeph);
		return true;
	}
	public int getMaxId(String photoTable)
	{
		String sql="SELECT IDENT_CURRENT('"+photoTable+"')";
		List maxId=hds.findByParametersql(sql);
		return Integer.parseInt(maxId.get(0).toString());
	}
	@Override
	public boolean buildingDel(int buildingId) {
		// TODO Auto-generated method stub
		Building building=new Building();
		building.setBuildingId(buildingId);
		building.setBuildingName("0");
		boolean result=hds.delete(building);
		return result;
	}

	@Override
	public List<Building> buildingList() {
		// TODO Auto-generated method stub
		List<Building> list=hds.findByParameter("from Building");
		return list;
	}
	@Override
	public List<Building> buildingList(int buildingId){
		Object[] o={buildingId};
		List<Building> list=hds.findByParameter("from Building where buildingId =?",o);
		return list;
	}
	@Override
	public List<Building> buildingList(int pageNo,int pageSize){
		String hql="from Building";
		List<Building> list=hds.findByParameter(hql, null, pageNo, pageSize);
		return list;
	}
	@Override
	public boolean buildingUpdate(int buildingId,String buildingName, String buildingAlias,
			int regionId, String propertyAdress, String propertyName,
			int usageId, int buildtimeId, String developers, Double floorArea,
			Double buildingArea, int structureId, String formId,
			String plotRatio, Date landuseTime, String buildingDensity,
			String greeningRate, BigDecimal parkingRatio, int decorateId,
			Date openTime, String propertyService, Double initialPrice,
			Double averagePrice, Double perPrice, Double totalPrice,
			String locationphoto, int landId, int buildintroId,
			Double longitude, Double latitude, int entryId, String entryName,
			Date entryTime, String auditName, Date auditTime, int status,
			String remarks,String buildtimeOne,String buildtimeTwo,String buildtimeThree,String buildtimeOther,
			String buildingtimeFinish,String buildRegion,String projectFeature,
			int zipCode,String buildingStruc,String buildingType,Double propertyFee,
			String proWorkaddress,String proPhone,String proOtherinfor,String propertyRight,
			String buildingintro,String editer) {
		// TODO Auto-generated method stub
		Object[] o={buildingName,buildingAlias,
				regionId,propertyAdress,propertyName,
				usageId,buildtimeId,developers,floorArea,
				buildingArea,structureId,formId,
				plotRatio, landuseTime,buildingDensity,
				greeningRate, parkingRatio,decorateId,
				openTime,propertyService,initialPrice,
				averagePrice,perPrice,totalPrice,
				locationphoto,landId,buildintroId,
				longitude,latitude,entryId,entryName,
				entryTime,auditName, auditTime,status,
				remarks,buildtimeOne,buildtimeTwo,buildtimeThree,buildtimeOther,
				buildingtimeFinish,buildRegion,projectFeature,
				zipCode,buildingStruc,buildingType,propertyFee,
				proWorkaddress,proPhone,proOtherinfor,propertyRight,
				buildingintro,editer,buildingId};
		String hql="update Building set buildingName=?,buildingAlias=?,regionId=?,propertyAdress=?,propertyName=?,usageId=?,buildtimeId=?,developers=?,"
				+ "floorArea=?,buildingArea=?,structureId=?,formId=?,plotRatio=?, landuseTime=?,buildingDensity=?,greeningRate=?, parkingRatio=?,decorateId=?,"
				+ "openTime=?,propertyService=?,initialPrice=?,averagePrice=?,perPrice=?,totalPrice=?,"
				+ "locationphoto=?,landId=?,buildintroId=?,longitude=?,latitude=?,entryId=?,entryName=?,"
				+ "entryTime=?,auditName=?, auditTime=?,status=?,remarks=?,"
				+ "buildtimeOne=?,buildtimeTwo=?,buildtimeThree=?,buildtimeOther=?,buildingtimeFinish=?,"
				+ "buildRegion=?,projectFeature=?,zipCode=?,buildingStruc=?,buildingType=?,propertyFee=?,"
				+ "proWorkaddress=?,proPhone=?,proOtherinfor=?,propertyRight=?,buildingintro=?,editer=? where buildingId = ?";
		hds.batchUpdate(hql,o);
		return true;
	}
	@Override
	public boolean buildingUpdate(int buildingId,String buildtimeOne,String buildtimeTwo,String buildtimeThree,String buildtimeOther,
			String buildingtimeFinish,String buildRegion,String projectFeature,int zipCode,String buildingStruc,
			String buildingType,Double propertyFee,String proWorkaddress,String proOtherinfor,
			String waterSupply,String electricitySupply,String heatSupply,String gas,String communications,
			String elevato,String security,String hygienism,String parking,String communityEnter,
			String propertyRight,int floors,int units,int currentHouses,int allHouses,String buildingintro,String editer) {
		// TODO Auto-generated method stub
		Object[] o={buildtimeOne,buildtimeTwo,buildtimeThree,buildtimeOther,
				buildingtimeFinish,buildRegion,projectFeature,zipCode,buildingStruc,
				buildingType,propertyFee,proWorkaddress,proOtherinfor,
				waterSupply,electricitySupply,heatSupply,gas,communications,
				elevato,security,hygienism,parking,communityEnter,
				propertyRight,floors,units,currentHouses,allHouses,buildingintro,editer,buildingId};
		String hql="update Building set buildtimeOne=?,buildtimeTwo=?,buildtimeThree=?,buildtimeOther=?,"
				+ "buildingtimeFinish=?,buildRegion=?,projectFeature=?,zipCode=?,buildingStruc=?,"
				+ "buildingType=?,propertyFee=?,proWorkaddress=?,proOtherinfor=?,"
				+ "waterSupply=?,electricitySupply=?,heatSupply=?,gas=?,communications=?,"
				+ "elevato=?,security=?,hygienism=?,parking=?,communityEnter=?,"
				+ "propertyRight=?,floors=?,units=?,currentHouses=?,allHouses=?,buildingintro=?,editer=? where buildingId = ?";
		hds.batchUpdate(hql,o);
		return true;
	}
	
	@Override
	public boolean buildingUpdate(int buildingId,String waterSupply,String electricitySupply,String heatSupply,String gas,String communications,
			String elevato,String security,String hygienism,String parking,String communityEnter) {
		// TODO Auto-generated method stub
		Object[] o={waterSupply,electricitySupply,heatSupply,gas,communications,
				elevato,security,hygienism,parking,communityEnter,buildingId};
		String hql="update Building set waterSupply=?,electricitySupply=?,heatSupply=?,gas=?,communications=?,"
				+ "elevato=?,security=?,hygienism=?,parking=?,communityEnter=? where buildingId = ?";
		hds.batchUpdate(hql,o);
		return true;
	}
	
	public List<Building> buildingSearch(String buildingName) {
		// TODO Auto-generated method stub
		Object[] o={buildingName}; 
		//List<Building> list=hds.findByParameter("from Building where buildingName like '%'+?+'%' ",o);
		List<Building> list=hds.findByParameter("from Building where buildingName =?",o);
		return list;
	}
	public int buildingCount(int regionId,int usageId,int averagePrice,String likeName) {
		
		String sql=" select count(1) from building where 1=1 ";
		if(regionId!=0){
			sql+=" and region_id='" + regionId+"'";
		}
		if(usageId!=0)
		{
			sql+=" and usage_id='"+usageId+"'";
		}
		if(averagePrice!=0){
			switch (averagePrice) {
			case  1: sql+=" and average_price<=6000";
			break;				
			case  2: sql+=" and average_price>6000 and average_price<=8000";
			break;
			case  3: sql+=" and average_price>8000 and average_price<=10000";
			break;
			case  4: sql+=" and average_price>10000 and average_price<=12000";
			break;
			case  5: sql+=" and average_price>12000";
			break;
			default:
				break;
				}
			}	
		if(likeName!=null)
		{ 
			sql+=" and building_name like '%'+'"+likeName+"'+'%' ";
		}
		List counts=hds.findByParametersql(sql);
		return Integer.parseInt(counts.get(0).toString());	
}
	
	public List<Building> buildingSearch(int regionId,int usageId,int averagePrice,String likeName,int pageNo,int pageSize) {
		
			String hql=" from Building where 1=1 ";
			if(regionId!=0){
				hql+=" and regionId='" + regionId+"'";
			}
			if(usageId!=0)
			{
				hql+=" and usageId='"+usageId+"'";
			}
			if(averagePrice!=0){
				switch (averagePrice) {
				case  1: hql+=" and averagePrice<=6000";
				break;				
				case  2: hql+=" and averagePrice>6000 and averagePrice<=8000";
				break;
				case  3: hql+=" and averagePrice>8000 and averagePrice<=12000";
				break;
				case  4: hql+=" and averagePrice>12000";
				break;
				default:
					break;
					}
				}	
			if(likeName!=null)
			{ 
				hql+=" and buildingName like '%'+'"+likeName+"'+'%' ";
			}
			List<Building> list=hds.findByParameter(hql, null, pageNo, pageSize);
		return list;
	
		
	}
	public List buildingPhoto(int buildingId) {
		// TODO Auto-generated method stub
		Object[] o={buildingId}; 
		//List<Building> list=hds.findByParameter("from Building where buildingName like '%'+?+'%' ",o);
		//List list=hds.findByParameter("select location_photo from building_locationphoto l ,building b where l.building_id =b.building_id and b.building_id=?",o);
		List list=hds.findByParametersql("select photopath from building_locationphoto l  where l.building_id =?",o);
		return list;
	}
	public List buildingPhoto(int buildingId,String photoTable) {
		// TODO Auto-generated method stub
		Object[] o={buildingId}; 
		//List<Building> list=hds.findByParameter("from Building where buildingName like '%'+?+'%' ",o);
		String sql="select photopath from "+photoTable+" l  where l.building_id =?";
		//List list=hds.findByParameter("select location_photo from building_locationphoto l ,building b where l.building_id =b.building_id and b.building_id=?",o);
		List list=hds.findByParametersql(sql,o);
		return list;
	}
	public List<Building> serachBuilding(Integer buildId,String memrole){
		int memroleint =Integer.parseInt(memrole);
		if(memroleint<=1){
		Object[] o={buildId}; 
		List<Building> list=hds.findByParameter("from Building where buildingId =?",o);
		list.get(0).setPropertyAdress("level");
		return list;
		}else if (memroleint==2){
			Object[] o={buildId}; 
			List<Building> list=hds.findByParameter("from Building where buildingId =?",o);
			return list;
		}else{
			Object[] o={buildId}; 
			List<Building> list=hds.findByParameter("from Building where buildingId =?",o);
			return list;
		}
	}
	@Override
	public boolean floorAdd(int buildingId,int buildNum,int unitNum,int houseNum,
			 Double houseArea, String present,int decorateId,int floorTotle,
			 int floorSaid,int floorActual,int usageId,String houseType,
			 String orientation,Double exchangePrice,Double exchangeTotle,Date exchangeTime,String remarks) {
		// TODO Auto-generated method stub
		Floor floor=new Floor(); 
		floor.setBuildingId(buildingId);
		floor.setBuildNum(buildNum);
		floor.setUnitNum(unitNum);
		floor.setHouseNum(houseNum);
		floor.setHouseArea(houseArea);
		floor.setPresent(present);
		floor.setDecorateId(decorateId);
		floor.setFloorTotle(floorTotle);
		floor.setFloorSaid(floorSaid);
		floor.setFloorActual(floorActual);
		floor.setUsageId(usageId);
		floor.setHouseType(houseType);
		floor.setOrientation(orientation);
		floor.setExchangePrice(exchangePrice);
		floor.setExchangeTotle(exchangeTotle);
		floor.setExchangeTime(exchangeTime);
		floor.setRemarks(remarks);
		hds.save(floor);
		return true;
	}
	@Override
	public boolean floorDel(int floorId) {
		// TODO Auto-generated method stub
	/*	Floor floor=new Floor(); 
		floor.setFloorId(floorId);
		floor.setBuildingId(0);
		hds.delete(floor);
		return true;*/
		Object[] o={floorId};
		String hql="delete from Floor where buildingId = ?";
		hds.batchUpdate(hql,o);
		return true;
	}
	@Override
	public List<Floor> floorList() {
		// TODO Auto-generated method stub
		List<Floor> list=hds.findByParameter("from Floor");
		return list;
	}
	@Override
	public List<Floor> floorList(int buildingId) {
		// TODO Auto-generated method stub
		Object[] o={buildingId}; 
		List<Floor> list=hds.findByParameter("from Floor where buildingId=?",o);
		return list;
	}
	@Override
	public boolean floorUpdate(int floorId,int buildingId,int buildNum,int unitNum,int houseNum,
			 Double houseArea, String present,int decorateId,int floorTotle,
			 int floorSaid,int floorActual,int usageId,String houseType,
			 String orientation,Double exchangePrice,Double exchangeTotle,Date exchangeTime,String remarks) {
		Floor floor=new Floor(); 
		floor.setFloorId(floorId);
		floor.setBuildingId(buildingId);
		floor.setBuildNum(buildNum);
		floor.setUnitNum(unitNum);
		floor.setHouseNum(houseNum);
		floor.setHouseArea(houseArea);
		floor.setPresent(present);
		floor.setDecorateId(decorateId);
		floor.setFloorTotle(floorTotle);
		floor.setFloorSaid(floorSaid);
		floor.setFloorActual(floorActual);
		floor.setUsageId(usageId);
		floor.setHouseType(houseType);
		floor.setOrientation(orientation);
		floor.setExchangePrice(exchangePrice);
		floor.setExchangeTotle(exchangeTotle);
		floor.setExchangeTime(exchangeTime);
		floor.setRemarks(remarks);
		hds.update(floor);
		return true;
	}
	
	@Override
	public boolean buildingintroAdd(int buildingId, String buildingName,
			String address, String buildingEast, String buildingWest,
			String buildingSouth, String buildingNorth, String landLevel,
			String neighborhood, String buildingInfor, String nearRoad,
			String publicTransport, String commercialFacility,
			String financingNstitution, String school, String hospital,
			String other, String internalFacility, String electricityFacility,
			String parkFacility, String propertyManagement, String environment,
			Date collectTime, String entryName, Date entryTime,
			String auditName, Date auditTime, Integer status, String remarks,
			Integer buildNum, String floors, Integer cells, String networks,
			Integer onehouses) {
		// TODO Auto-generated method stub
		BuildingIntro buildigintro=new BuildingIntro();
		buildigintro.setBuildingId(buildingId);
		buildigintro.setBuildingName(buildingName);
		buildigintro.setAddress(address);
		buildigintro.setBuildingEast(buildingEast);
		buildigintro.setBuildingWest(buildingWest);
		buildigintro.setBuildingSouth(buildingSouth);
		buildigintro.setBuildingNorth(buildingNorth);
		buildigintro.setLandLevel(landLevel);
		buildigintro.setNeighborhood(neighborhood);
		buildigintro.setBuildingInfor(buildingInfor);
		buildigintro.setNearRoad(nearRoad);
		buildigintro.setPublicTransport(publicTransport);
		buildigintro.setCommercialFacility(commercialFacility);
		buildigintro.setFinancingNstitution(financingNstitution);
		buildigintro.setSchool(school);
		buildigintro.setHospital(hospital);
		buildigintro.setOther(other);
		buildigintro.setInternalFacility(internalFacility);
		buildigintro.setElectricityFacility(electricityFacility);
		buildigintro.setParkFacility(parkFacility);
		buildigintro.setPropertyManagement(propertyManagement);
		buildigintro.setEnvironment(environment);
		buildigintro.setCollectTime(collectTime);
		buildigintro.setEntryName(entryName);
		buildigintro.setEntryTime(entryTime);
		buildigintro.setAuditName(auditName);
		buildigintro.setAuditTime(auditTime);
		buildigintro.setStatus(status);
		buildigintro.setRemarks(remarks);
		buildigintro.setBuildNum(buildNum);
		buildigintro.setFloors(floors);
		buildigintro.setCells(cells);
		buildigintro.setNetworks(networks);
		buildigintro.setOnehouses(onehouses);
		hds.save(buildigintro);
		return true;
	}
	@Override
	public boolean buildingintroDel(int buildintroId) {
		// TODO Auto-generated method stub
		/*BuildingIntro buildigintro=new BuildingIntro();
		buildigintro.setBuildintroId(buildintroId);
		buildigintro.setBuildingId(0);
		buildigintro.setBuildingName("0");
		hds.delete(buildigintro);
		return true;*/
		Object[] o={buildintroId};
		String hql="delete from BuildingIntro where buildingId = ?";
		hds.batchUpdate(hql,o);
		return true;
	}
	@Override
	public List<BuildingIntro> buildingintroList() {
		// TODO Auto-generated method stub
		List<BuildingIntro> list=hds.findByParameter("from BuildingIntro");
		return list;
	}
	
	@Override
	public boolean buildingintroUpdate(int buildintroId, int buildingId,
			String buildingName, String address, String buildingEast,
			String buildingWest, String buildingSouth, String buildingNorth,
			String landLevel, String neighborhood, String buildingInfor,
			String nearRoad, String publicTransport, String commercialFacility,
			String financingNstitution, String school, String hospital,
			String other, String internalFacility, String electricityFacility,
			String parkFacility, String propertyManagement, String environment,
			Date collectTime, String entryName, Date entryTime,
			String auditName, Date auditTime, Integer status, String remarks,
			Integer buildNum, String floors, Integer cells, String networks,
			Integer onehouses) {
		// TODO Auto-generated method stub
		BuildingIntro buildigintro=new BuildingIntro();
		buildigintro.setBuildintroId(buildintroId);
		buildigintro.setBuildingId(buildingId);
		buildigintro.setBuildingName(buildingName);
		buildigintro.setAddress(address);
		buildigintro.setBuildingEast(buildingEast);
		buildigintro.setBuildingWest(buildingWest);
		buildigintro.setBuildingSouth(buildingSouth);
		buildigintro.setBuildingNorth(buildingNorth);
		buildigintro.setLandLevel(landLevel);
		buildigintro.setNeighborhood(neighborhood);
		buildigintro.setBuildingInfor(buildingInfor);
		buildigintro.setNearRoad(nearRoad);
		buildigintro.setPublicTransport(publicTransport);
		buildigintro.setCommercialFacility(commercialFacility);
		buildigintro.setFinancingNstitution(financingNstitution);
		buildigintro.setSchool(school);
		buildigintro.setHospital(hospital);
		buildigintro.setOther(other);
		buildigintro.setInternalFacility(internalFacility);
		buildigintro.setElectricityFacility(electricityFacility);
		buildigintro.setParkFacility(parkFacility);
		buildigintro.setPropertyManagement(propertyManagement);
		buildigintro.setEnvironment(environment);
		buildigintro.setCollectTime(collectTime);
		buildigintro.setEntryName(entryName);
		buildigintro.setEntryTime(entryTime);
		buildigintro.setAuditName(auditName);
		buildigintro.setAuditTime(auditTime);
		buildigintro.setStatus(status);
		buildigintro.setRemarks(remarks);
		buildigintro.setBuildNum(buildNum);
		buildigintro.setFloors(floors);
		buildigintro.setCells(cells);
		buildigintro.setNetworks(networks);
		buildigintro.setOnehouses(onehouses);
		hds.update(buildigintro);
		return true;
	}
	public List<BuildingIntro> serachBuildingIntro(int buildId,String memrole){
		int memroleint =Integer.parseInt(memrole);
		if(memroleint<=1){
		Object[] o={buildId}; 
		List<BuildingIntro> list=hds.findByParameter("from BuildingIntro where buildingId =?",o);
		
		return list;
		}else if (memroleint==2){
			Object[] o={buildId}; 
			List<BuildingIntro> list=hds.findByParameter("from BuildingIntro where buildingId =?",o);
			return list;
		}else{
			Object[] o={buildId}; 
			List<BuildingIntro> list=hds.findByParameter("from BuildingIntro where buildingId =?",o);
			return list;
		}
	}
}
