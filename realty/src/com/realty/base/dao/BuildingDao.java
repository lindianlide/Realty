package com.realty.base.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.realty.base.model.Building;
import com.realty.base.model.BuildingIntro;
import com.realty.base.model.BuildingLocationphoto;
import com.realty.base.model.BuildingPhoto;
import com.realty.base.model.BuildingPlanphoto;
import com.realty.base.model.BuildingTypephoto;
import com.realty.base.model.Floor;

public interface BuildingDao {
	public boolean buildingAdd(String buildingName, String buildingAlias,
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
			String remarks);
	public boolean buildingintroAdd(int buildingId,String buildingName, String address,
			String buildingEast, String buildingWest,String buildingSouth, String buildingNorth,
			String landLevel, String neighborhood,String buildingInfor, String nearRoad,
			String publicTransport, String commercialFacility,String financingNstitution, String school,
			String hospital, String other,String internalFacility, String electricityFacility,
			String parkFacility, String propertyManagement,String environment, Date collectTime, String entryName,
			Date entryTime, String auditName, Date auditTime,Integer status,String remarks, 
			Integer buildNum, String floors,Integer cells, String networks, Integer onehouses);
	public boolean locationphotoAdd(int buildingId,String locationPhoto);
	public boolean buildingphotoAdd(int buildingId,String buildingPhoto);
	public boolean planphotoAdd(int buildingId,String planPhoto);
	public boolean typephotoAdd(int buildingId,String typePhoto);

	public boolean locationphotoUpdate(int locationphotoId,int buildingId,String locationPhoto);
	public boolean buildingphotoUpdate(int buildingPhotoId,int buildingId,String buildingPhoto);
	public boolean planphotoUpdate(int planphotoId,int buildingId,String planPhoto);
	public boolean typephotoUpdate(int typephotoId,int buildingId,String typePhoto);
	
	public List<BuildingLocationphoto> locationphotoList();
	public List<BuildingPhoto> buildingphotoList();
	public List<BuildingPlanphoto> planphotoList();
	public List<BuildingTypephoto> typephotoList();
	
	public boolean locationphotoDel(int locationphotoId);	
	public boolean buildingphotoDel(int buildingPhotoId);	
	public boolean planphotoDel(int planphotoId);
	public boolean typephotoDel(int typephotoId);
	public List buildingPhoto(int buildingId,String photoTable);
	public boolean buildingDel(int buildingId);
	public boolean buildingintroDel(int buildintroId);
	
	public int getMaxId(String photoTable);

	public List<Building> buildingList();
	public List<Building> buildingList(int buildingId);
	
	public List<BuildingIntro> buildingintroList();
	public List<Building> buildingList(int pageNo,int pageSize);
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
			Date entryTime, String auditName, Date auditTime, int status,String remarks,
			String buildtimeOne,String buildtimeTwo,String buildtimeThree,String buildtimeOther,
			String buildingtimeFinish,String buildRegion,String projectFeature,
			int zipCode,String buildingStruc,String buildingType,Double propertyFee,
			String proWorkaddress,String proPhone,String proOtherinfor,String propertyRight,
			String buildingintro,String editer);
	public boolean buildingUpdate(int buildingId,String buildtimeOne,String buildtimeTwo,String buildtimeThree,String buildtimeOther,
			String buildingtimeFinish,String buildRegion,String projectFeature,int zipCode,String buildingStruc,
			String buildingType,Double propertyFee,String proWorkaddress,String proOtherinfor,
			String waterSupply,String electricitySupply,String heatSupply,String gas,String communications,
			String elevato,String security,String hygienism,String parking,String communityEnter,
			String propertyRight,int floors,int units,int currentHouses,int allHouses,String buildingintro,String editer);
	
	public boolean buildingUpdate(int buildingId,String waterSupply,String electricitySupply,String heatSupply,String gas,String communications,
			String elevato,String security,String hygienism,String parking,String communityEnter);
	
	public boolean buildingintroUpdate(int buildintroId,int buildingId,String buildingName, String address,
			String buildingEast, String buildingWest,String buildingSouth, String buildingNorth,
			String landLevel, String neighborhood,String buildingInfor, String nearRoad,
			String publicTransport, String commercialFacility,String financingNstitution, String school,
			String hospital, String other,String internalFacility, String electricityFacility,
			String parkFacility, String propertyManagement,String environment, Date collectTime, String entryName,
			Date entryTime, String auditName, Date auditTime,Integer status,String remarks, 
			Integer buildNum, String floors,Integer cells, String networks, Integer onehouses);
	public List<Building> buildingSearch(String buildingName);
	public int buildingCount(int regionId,int usageId,int averagePrice,String likeName);
	public List<Building> buildingSearch(int regionId,int usageId,int averagePrice,String likeName,int pageNo,int pageSize);
	public List<Building> serachBuilding(Integer buildId, String memrole);
	public boolean floorAdd(int buildingId, int buildNum, int unitNum, int houseNum,
			Double houseArea, String present, int decorateId, int floorTotle,
			int floorSaid, int floorActual, int usageId, String houseType,
			String orientation, Double exchangePrice, Double exchangeTotle,
			Date exchangeTime, String remarks);
	public boolean floorDel(int floorId);
	public List<Floor> floorList();
	public List<Floor> floorList(int buildingId);
	public boolean floorUpdate(int floorId, int buildingId, int buildNum, int unitNum,
			int houseNum, Double houseArea, String present, int decorateId,
			int floorTotle, int floorSaid, int floorActual, int usageId,
			String houseType, String orientation, Double exchangePrice,
			Double exchangeTotle, Date exchangeTime, String remarks);
	public List<BuildingIntro> serachBuildingIntro(int buildId,String memrole);
	
}
