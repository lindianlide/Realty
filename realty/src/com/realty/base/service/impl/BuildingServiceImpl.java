package com.realty.base.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.realty.base.dao.BuildingDao;
import com.realty.base.dao.impl.BuildingDaoImpl;
import com.realty.base.model.Building;
import com.realty.base.model.BuildingIntro;
import com.realty.base.model.BuildingLocationphoto;
import com.realty.base.model.BuildingPhoto;
import com.realty.base.model.BuildingPlanphoto;
import com.realty.base.model.BuildingTypephoto;
import com.realty.base.model.Floor;
import com.realty.base.service.BuildingService;

public class BuildingServiceImpl implements BuildingService {
	BuildingDao buildingDao=new BuildingDaoImpl();
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
		return buildingDao.buildingAdd(buildingName, buildingAlias, regionId, 
				propertyAdress, propertyName, usageId, buildtimeId, developers, floorArea, 
				buildingArea, structureId, formId, plotRatio, landuseTime, buildingDensity, 
				greeningRate, parkingRatio, decorateId, openTime, propertyService, initialPrice, 
				averagePrice, perPrice, totalPrice, locationphoto, landId, buildintroId, longitude,
				latitude, entryId, entryName, entryTime, auditName, auditTime, status, remarks);
	}
	
	public boolean locationphotoAdd(int buildingId,String locationPhoto){
		return buildingDao.locationphotoAdd(buildingId, locationPhoto);
	}
	public boolean buildingphotoAdd(int buildingId,String buildingPhoto)
	{
		return buildingDao.buildingphotoAdd(buildingId, buildingPhoto);
		
	}
	public boolean planphotoAdd(int buildingId,String planPhoto)
	{
		return buildingDao.planphotoAdd(buildingId, planPhoto);
		
	}
	public boolean typephotoAdd(int buildingId,String typePhoto)
	{
		return buildingDao.typephotoAdd(buildingId, typePhoto);
		
	}
	
	public boolean locationphotoUpdate(int locationphotoId,int buildingId,String locationPhoto)
	{
		return buildingDao.locationphotoUpdate(locationphotoId,buildingId, locationPhoto);	
	}
	public boolean buildingphotoUpdate(int buildingPhotoId,int buildingId,String buildingPhoto)
	{
		return buildingDao.buildingphotoUpdate(buildingPhotoId,buildingId, buildingPhoto);	
	}
	public boolean planphotoUpdate(int planphotoId,int buildingId,String planPhoto)
	{
		return buildingDao.planphotoUpdate(planphotoId,buildingId, planPhoto);
	}
	public boolean typephotoUpdate(int typephotoId,int buildingId,String typePhoto)
	{
		return buildingDao.typephotoUpdate(typephotoId,buildingId, typePhoto);
	}
	public List<BuildingLocationphoto> locationphotoList()
	{
		return buildingDao.locationphotoList();	
	}
	public List<BuildingPhoto> buildingphotoList()
	{
		return buildingDao.buildingphotoList();	
	}
	public List<BuildingPlanphoto> planphotoList()
	{
		return buildingDao.planphotoList();
	}
	public List<BuildingTypephoto> typephotoList()
	{
		return buildingDao.typephotoList();
	}
	public boolean locationphotoDel(int locationphotoId)
	{
		return buildingDao.locationphotoDel(locationphotoId);	
	}
	public boolean buildingphotoDel(int buildingPhotoId)
	{
		return buildingDao.buildingphotoDel(buildingPhotoId);	
	}
	public boolean planphotoDel(int planphotoId)
	{
		return buildingDao.planphotoDel(planphotoId);
	}
	public boolean typephotoDel(int typephotoId)
	{
		return buildingDao.typephotoDel(typephotoId);
	}
	
	public List buildingPhoto(int buildingId,String photoTable) {
		return buildingDao.buildingPhoto(buildingId, photoTable);
	}
	
	public int getMaxId(String photoTable){
		return buildingDao.getMaxId(photoTable);
	}

	@Override
	public boolean buildingDel(int buildingId) {
		// TODO Auto-generated method stub
		return buildingDao.buildingDel(buildingId);
	}
	@Override
	public List<Building> buildingList() {
		// TODO Auto-generated method stub
		return buildingDao.buildingList();
	}
	@Override
	public List<Building> buildingList(int buildingId){
		// TODO Auto-generated method stub
		return buildingDao.buildingList(buildingId);
	}
	@Override
	public List<Building> buildingList(int pageNo,int pageSize){
		return buildingDao.buildingList(pageNo, pageSize);
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
			String remarks,
			String buildtimeOne,String buildtimeTwo,String buildtimeThree,String buildtimeOther,
			String buildingtimeFinish,String buildRegion,String projectFeature,
			int zipCode,String buildingStruc,String buildingType,Double propertyFee,
			String proWorkaddress,String proPhone,String proOtherinfor,String propertyRight,
			String buildingintro,String editer) {
		// TODO Auto-generated method stub
		return buildingDao.buildingUpdate(buildingId,buildingName, buildingAlias, regionId, 
				propertyAdress, propertyName, usageId, buildtimeId, developers, floorArea, 
				buildingArea, structureId, formId, plotRatio, landuseTime, buildingDensity, 
				greeningRate, parkingRatio, decorateId, openTime, propertyService, initialPrice, 
				averagePrice, perPrice, totalPrice, locationphoto, landId, buildintroId, longitude,
				latitude, entryId, entryName, entryTime, auditName, auditTime, status, remarks,
				buildtimeOne,buildtimeTwo,buildtimeThree,buildtimeOther,
				buildingtimeFinish,buildRegion,projectFeature,
				zipCode,buildingStruc,buildingType,propertyFee,
				proWorkaddress,proPhone,proOtherinfor,propertyRight,
				buildingintro,editer);
	}
	@Override
	public boolean buildingUpdate(int buildingId,String buildtimeOne,String buildtimeTwo,String buildtimeThree,String buildtimeOther,
			String buildingtimeFinish,String buildRegion,String projectFeature,int zipCode,String buildingStruc,
			String buildingType,Double propertyFee,String proWorkaddress,String proOtherinfor,
			String waterSupply,String electricitySupply,String heatSupply,String gas,String communications,
			String elevato,String security,String hygienism,String parking,String communityEnter,
			String propertyRight,int floors,int units,int currentHouses,int allHouses,String buildingintro,String editer){
		return buildingDao.buildingUpdate(buildingId, buildtimeOne, buildtimeTwo, buildtimeThree, buildtimeOther,
				buildingtimeFinish, buildRegion, projectFeature, zipCode, buildingStruc, buildingType, 
				propertyFee, proWorkaddress, proOtherinfor, waterSupply, electricitySupply, heatSupply, 
				gas, communications, elevato, security, hygienism, parking, communityEnter, propertyRight,
				floors, units, currentHouses, allHouses, buildingintro, editer);
	}
	
	@Override
	public boolean buildingUpdate(int buildingId,String waterSupply,String electricitySupply,String heatSupply,String gas,String communications,
			String elevato,String security,String hygienism,String parking,String communityEnter){
		return buildingDao.buildingUpdate(buildingId, waterSupply, electricitySupply, heatSupply, 
				gas, communications, elevato, security, hygienism, parking, communityEnter);
	}
	public List<Building> buildingSearch(String buildingName){
		return buildingDao.buildingSearch(buildingName);
	}
	public int buildingCount(int regionId,int usageId,int averagePrice,String likeName){
		return buildingDao.buildingCount(regionId, usageId, averagePrice, likeName);
	}
	public List<Building> buildingSearch(int regionId,int usageId,int averagePrice,String likeName,int pageNo,int pageSize){
		return buildingDao.buildingSearch(regionId, usageId, averagePrice,likeName,pageNo,pageSize);
	}
	public List<Building> serachBuilding(Integer buildId,String memrole){
		return buildingDao.serachBuilding(buildId,memrole);
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
		return buildingDao.buildingintroAdd(buildingId, buildingName, address, buildingEast, buildingWest, buildingSouth, buildingNorth, landLevel, neighborhood, buildingInfor, nearRoad, publicTransport, commercialFacility, financingNstitution, school, hospital, other, internalFacility, electricityFacility, parkFacility, propertyManagement, environment, collectTime, entryName, entryTime, auditName, auditTime, status, remarks, buildNum, floors, cells, networks, onehouses);
	}
	@Override
	public boolean buildingintroDel(int buildintroId) {
		return buildingDao.buildingintroDel(buildintroId);
	}
	@Override
	public List<BuildingIntro> buildingintroList() {
		return buildingDao.buildingintroList();
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
		return buildingDao.buildingintroUpdate(buildintroId, buildingId, buildingName, address, buildingEast, buildingWest, buildingSouth, buildingNorth, landLevel, neighborhood, buildingInfor, nearRoad, publicTransport, commercialFacility, financingNstitution, school, hospital, other, internalFacility, electricityFacility, parkFacility, propertyManagement, environment, collectTime, entryName, entryTime, auditName, auditTime, status, remarks, buildNum, floors, cells, networks, onehouses);
}
	public boolean floorAdd(int buildingId, int buildNum, int unitNum, int houseNum,
			Double houseArea, String present, int decorateId, int floorTotle,
			int floorSaid, int floorActual, int usageId, String houseType,
			String orientation, Double exchangePrice, Double exchangeTotle,
			Date exchangeTime, String remarks){
		return buildingDao.floorAdd(buildingId, buildNum, unitNum, houseNum, houseArea, present, decorateId, floorTotle, floorSaid, floorActual, usageId, houseType, orientation, exchangePrice, exchangeTotle, exchangeTime, remarks);
	}
	public boolean floorDel(int floorId){
		return buildingDao.floorDel(floorId);
	}
	public List<Floor> floorList(){
		return buildingDao.floorList();
	}
	public List<Floor> floorList(int buildingId){
		return buildingDao.floorList(buildingId);
	}
	public boolean floorUpdate(int floorId, int buildingId, int buildNum, int unitNum,
			int houseNum, Double houseArea, String present, int decorateId,
			int floorTotle, int floorSaid, int floorActual, int usageId,
			String houseType, String orientation, Double exchangePrice,
			Double exchangeTotle, Date exchangeTime, String remarks){
		return buildingDao.floorUpdate(floorId, buildingId, buildNum, unitNum, houseNum, houseArea, present, decorateId, floorTotle, floorSaid, floorActual, usageId, houseType, orientation, exchangePrice, exchangeTotle, exchangeTime, remarks);
	}
	public List<BuildingIntro> serachBuildingIntro(int buildId,String memrole){
		return buildingDao.serachBuildingIntro(buildId, memrole);
	}
}
