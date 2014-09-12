package com.realty.base.model;

// Generated 2014-6-12 13:12:28 by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Building generated by hbm2java
 */
public class Building implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int buildingId;
	private String buildingName;
	private String buildingAlias;
	private Integer regionId;
	private String propertyAdress;
	private String propertyName;
	private Integer usageId;
	private Integer buildtimeId;
	private String developers;
	private Double floorArea;
	private Double buildingArea;
	private Integer structureId;
	private String formId;
	private String plotRatio;
	private Date landuseTime;
	private String buildingDensity;
	private String greeningRate;
	private BigDecimal parkingRatio;
	private Integer decorateId;
	private Date openTime;
	private String propertyService;
	private Double initialPrice;
	private Double averagePrice;
	private Double perPrice;
	private Double totalPrice;
	private String locationphoto;
	private Integer landId;
	private Integer buildintroId;
	private Double longitude;
	private Double latitude;
	private Integer entryId;
	private String entryName;
	private Date entryTime;
	private String auditName;
	private Date auditTime;
	private Integer status;
	private String remarks;
	private String buildtimeOne;
	private String buildtimeTwo;
	private String buildtimeThree;
	private String buildtimeOther;
	private String buildingtimeFinish;
	private String buildRegion;
	private String projectFeature;
	private Integer zipCode;
	private String buildingStruc;
	private String buildingType;
	private Double propertyFee;
	private String proWorkaddress;
	private String proPhone;
	private String proOtherinfor;
	private String waterSupply;
	private String electricitySupply;
	private String heatSupply;
	private String gas;
	private String communications;
	private String elevato;
	private String security;
	private String hygienism;
	private String parking;
	private String communityEnter;
	private String propertyRight;
	private Integer floors;
	private Integer units;
	private Integer currentHouses;
	private Integer allHouses;
	private String buildingintro;
	private String editer;

	public Building() {
	}

	public Building(int buildingId, String buildingName) {
		this.buildingId = buildingId;
		this.buildingName = buildingName;
	}

	public Building(int buildingId, String buildingName,
			String buildingAlias, Integer regionId,
			String propertyAdress, String propertyName,
			Integer usageId, Integer buildtimeId, String developers,
			Double floorArea, Double buildingArea, Integer structureId,
			String formId, String plotRatio, Date landuseTime,
			String buildingDensity, String greeningRate,
			BigDecimal parkingRatio, Integer decorateId, Date openTime,
			String propertyService, Double initialPrice,
			Double averagePrice, Double perPrice, Double totalPrice,
			String locationphoto, Integer landId, Integer buildintroId,
			Double longitude, Double latitude, Integer entryId,
			String entryName, Date entryTime, String auditName,
			Date auditTime, Integer status, String remarks,
			String buildtimeOne, String buildtimeTwo,
			String buildtimeThree, String buildtimeOther,
			String buildingtimeFinish, String buildRegion,
			String projectFeature, Integer zipCode,
			String buildingStruc, String buildingType,
			Double propertyFee, String proWorkaddress,
			String proPhone, String proOtherinfor,
			String waterSupply, String electricitySupply,
			String heatSupply, String gas,
			String communications, String elevato,
			String security, String hygienism,
			String parking, String communityEnter,
			String propertyRight, Integer floors, Integer units,
			Integer currentHouses, Integer allHouses,
			String buildingintro, String editer) {
		this.buildingId = buildingId;
		this.buildingName = buildingName;
		this.buildingAlias = buildingAlias;
		this.regionId = regionId;
		this.propertyAdress = propertyAdress;
		this.propertyName = propertyName;
		this.usageId = usageId;
		this.buildtimeId = buildtimeId;
		this.developers = developers;
		this.floorArea = floorArea;
		this.buildingArea = buildingArea;
		this.structureId = structureId;
		this.formId = formId;
		this.plotRatio = plotRatio;
		this.landuseTime = landuseTime;
		this.buildingDensity = buildingDensity;
		this.greeningRate = greeningRate;
		this.parkingRatio = parkingRatio;
		this.decorateId = decorateId;
		this.openTime = openTime;
		this.propertyService = propertyService;
		this.initialPrice = initialPrice;
		this.averagePrice = averagePrice;
		this.perPrice = perPrice;
		this.totalPrice = totalPrice;
		this.locationphoto = locationphoto;
		this.landId = landId;
		this.buildintroId = buildintroId;
		this.longitude = longitude;
		this.latitude = latitude;
		this.entryId = entryId;
		this.entryName = entryName;
		this.entryTime = entryTime;
		this.auditName = auditName;
		this.auditTime = auditTime;
		this.status = status;
		this.remarks = remarks;
		this.buildtimeOne = buildtimeOne;
		this.buildtimeTwo = buildtimeTwo;
		this.buildtimeThree = buildtimeThree;
		this.buildtimeOther = buildtimeOther;
		this.buildingtimeFinish = buildingtimeFinish;
		this.buildRegion = buildRegion;
		this.projectFeature = projectFeature;
		this.zipCode = zipCode;
		this.buildingStruc = buildingStruc;
		this.buildingType = buildingType;
		this.propertyFee = propertyFee;
		this.proWorkaddress = proWorkaddress;
		this.proPhone = proPhone;
		this.proOtherinfor = proOtherinfor;
		this.waterSupply = waterSupply;
		this.electricitySupply = electricitySupply;
		this.heatSupply = heatSupply;
		this.gas = gas;
		this.communications = communications;
		this.elevato = elevato;
		this.security = security;
		this.hygienism = hygienism;
		this.parking = parking;
		this.communityEnter = communityEnter;
		this.propertyRight = propertyRight;
		this.floors = floors;
		this.units = units;
		this.currentHouses = currentHouses;
		this.allHouses = allHouses;
		this.buildingintro = buildingintro;
		this.editer = editer;
	}

	public int getBuildingId() {
		return this.buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	public String getBuildingName() {
		return this.buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getBuildingAlias() {
		return this.buildingAlias;
	}

	public void setBuildingAlias(String buildingAlias) {
		this.buildingAlias = buildingAlias;
	}

	public Integer getRegionId() {
		return this.regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getPropertyAdress() {
		return this.propertyAdress;
	}

	public void setPropertyAdress(String propertyAdress) {
		this.propertyAdress = propertyAdress;
	}

	public String getPropertyName() {
		return this.propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public Integer getUsageId() {
		return this.usageId;
	}

	public void setUsageId(Integer usageId) {
		this.usageId = usageId;
	}

	public Integer getBuildtimeId() {
		return this.buildtimeId;
	}

	public void setBuildtimeId(Integer buildtimeId) {
		this.buildtimeId = buildtimeId;
	}

	public String getDevelopers() {
		return this.developers;
	}

	public void setDevelopers(String developers) {
		this.developers = developers;
	}

	public Double getFloorArea() {
		return this.floorArea;
	}

	public void setFloorArea(Double floorArea) {
		this.floorArea = floorArea;
	}

	public Double getBuildingArea() {
		return this.buildingArea;
	}

	public void setBuildingArea(Double buildingArea) {
		this.buildingArea = buildingArea;
	}

	public Integer getStructureId() {
		return this.structureId;
	}

	public void setStructureId(Integer structureId) {
		this.structureId = structureId;
	}

	public String getFormId() {
		return this.formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getPlotRatio() {
		return this.plotRatio;
	}

	public void setPlotRatio(String plotRatio) {
		this.plotRatio = plotRatio;
	}

	public Date getLanduseTime() {
		return this.landuseTime;
	}

	public void setLanduseTime(Date landuseTime) {
		this.landuseTime = landuseTime;
	}

	public String getBuildingDensity() {
		return this.buildingDensity;
	}

	public void setBuildingDensity(String buildingDensity) {
		this.buildingDensity = buildingDensity;
	}

	public String getGreeningRate() {
		return this.greeningRate;
	}

	public void setGreeningRate(String greeningRate) {
		this.greeningRate = greeningRate;
	}

	public BigDecimal getParkingRatio() {
		return this.parkingRatio;
	}

	public void setParkingRatio(BigDecimal parkingRatio) {
		this.parkingRatio = parkingRatio;
	}

	public Integer getDecorateId() {
		return this.decorateId;
	}

	public void setDecorateId(Integer decorateId) {
		this.decorateId = decorateId;
	}

	public Date getOpenTime() {
		return this.openTime;
	}

	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}

	public String getPropertyService() {
		return this.propertyService;
	}

	public void setPropertyService(String propertyService) {
		this.propertyService = propertyService;
	}

	public Double getInitialPrice() {
		return this.initialPrice;
	}

	public void setInitialPrice(Double initialPrice) {
		this.initialPrice = initialPrice;
	}

	public Double getAveragePrice() {
		return this.averagePrice;
	}

	public void setAveragePrice(Double averagePrice) {
		this.averagePrice = averagePrice;
	}

	public Double getPerPrice() {
		return this.perPrice;
	}

	public void setPerPrice(Double perPrice) {
		this.perPrice = perPrice;
	}

	public Double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getLocationphoto() {
		return this.locationphoto;
	}

	public void setLocationphoto(String locationphoto) {
		this.locationphoto = locationphoto;
	}

	public Integer getLandId() {
		return this.landId;
	}

	public void setLandId(Integer landId) {
		this.landId = landId;
	}

	public Integer getBuildintroId() {
		return this.buildintroId;
	}

	public void setBuildintroId(Integer buildintroId) {
		this.buildintroId = buildintroId;
	}

	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Integer getEntryId() {
		return this.entryId;
	}

	public void setEntryId(Integer entryId) {
		this.entryId = entryId;
	}

	public String getEntryName() {
		return this.entryName;
	}

	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}

	public Date getEntryTime() {
		return this.entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public String getAuditName() {
		return this.auditName;
	}

	public void setAuditName(String auditName) {
		this.auditName = auditName;
	}

	public Date getAuditTime() {
		return this.auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getBuildtimeOne() {
		return this.buildtimeOne;
	}

	public void setBuildtimeOne(String buildtimeOne) {
		this.buildtimeOne = buildtimeOne;
	}

	public String getBuildtimeTwo() {
		return this.buildtimeTwo;
	}

	public void setBuildtimeTwo(String buildtimeTwo) {
		this.buildtimeTwo = buildtimeTwo;
	}

	public String getBuildtimeThree() {
		return this.buildtimeThree;
	}

	public void setBuildtimeThree(String buildtimeThree) {
		this.buildtimeThree = buildtimeThree;
	}

	public String getBuildtimeOther() {
		return this.buildtimeOther;
	}

	public void setBuildtimeOther(String buildtimeOther) {
		this.buildtimeOther = buildtimeOther;
	}

	public String getBuildingtimeFinish() {
		return this.buildingtimeFinish;
	}

	public void setBuildingtimeFinish(String buildingtimeFinish) {
		this.buildingtimeFinish = buildingtimeFinish;
	}

	public String getBuildRegion() {
		return this.buildRegion;
	}

	public void setBuildRegion(String buildRegion) {
		this.buildRegion = buildRegion;
	}

	public String getProjectFeature() {
		return this.projectFeature;
	}

	public void setProjectFeature(String projectFeature) {
		this.projectFeature = projectFeature;
	}

	public Integer getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getBuildingStruc() {
		return this.buildingStruc;
	}

	public void setBuildingStruc(String buildingStruc) {
		this.buildingStruc = buildingStruc;
	}

	public String getBuildingType() {
		return this.buildingType;
	}

	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}

	public Double getPropertyFee() {
		return this.propertyFee;
	}

	public void setPropertyFee(Double propertyFee) {
		this.propertyFee = propertyFee;
	}

	public String getProWorkaddress() {
		return this.proWorkaddress;
	}

	public void setProWorkaddress(String proWorkaddress) {
		this.proWorkaddress = proWorkaddress;
	}

	public String getProPhone() {
		return this.proPhone;
	}

	public void setProPhone(String proPhone) {
		this.proPhone = proPhone;
	}

	public String getProOtherinfor() {
		return this.proOtherinfor;
	}

	public void setProOtherinfor(String proOtherinfor) {
		this.proOtherinfor = proOtherinfor;
	}

	public String getWaterSupply() {
		return this.waterSupply;
	}

	public void setWaterSupply(String waterSupply) {
		this.waterSupply = waterSupply;
	}

	public String getElectricitySupply() {
		return this.electricitySupply;
	}

	public void setElectricitySupply(String electricitySupply) {
		this.electricitySupply = electricitySupply;
	}

	public String getHeatSupply() {
		return this.heatSupply;
	}

	public void setHeatSupply(String heatSupply) {
		this.heatSupply = heatSupply;
	}

	public String getGas() {
		return this.gas;
	}

	public void setGas(String gas) {
		this.gas = gas;
	}

	public String getCommunications() {
		return this.communications;
	}

	public void setCommunications(String communications) {
		this.communications = communications;
	}

	public String getElevato() {
		return this.elevato;
	}

	public void setElevato(String elevato) {
		this.elevato = elevato;
	}

	public String getSecurity() {
		return this.security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public String getHygienism() {
		return this.hygienism;
	}

	public void setHygienism(String hygienism) {
		this.hygienism = hygienism;
	}

	public String getParking() {
		return this.parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	public String getCommunityEnter() {
		return this.communityEnter;
	}

	public void setCommunityEnter(String communityEnter) {
		this.communityEnter = communityEnter;
	}

	public String getPropertyRight() {
		return this.propertyRight;
	}

	public void setPropertyRight(String propertyRight) {
		this.propertyRight = propertyRight;
	}

	public Integer getFloors() {
		return this.floors;
	}

	public void setFloors(Integer floors) {
		this.floors = floors;
	}

	public Integer getUnits() {
		return this.units;
	}

	public void setUnits(Integer units) {
		this.units = units;
	}

	public Integer getCurrentHouses() {
		return this.currentHouses;
	}

	public void setCurrentHouses(Integer currentHouses) {
		this.currentHouses = currentHouses;
	}

	public Integer getAllHouses() {
		return this.allHouses;
	}

	public void setAllHouses(Integer allHouses) {
		this.allHouses = allHouses;
	}

	public String getBuildingintro() {
		return this.buildingintro;
	}

	public void setBuildingintro(String buildingintro) {
		this.buildingintro = buildingintro;
	}

	public String getEditer() {
		return this.editer;
	}

	public void setEditer(String editer) {
		this.editer = editer;
	}

}