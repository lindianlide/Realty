package com.realty.base.service;

import java.util.Date;
import java.util.List;

import com.realty.base.model.FloorUsage;
import com.realty.base.model.PriceType;
import com.realty.base.model.Secondhouse;
import com.realty.base.model.SedecoratePhoto;
import com.realty.base.model.SetypePhoto;
import com.realty.base.model.TaxType;

public interface SecondService {

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
			String auditName, Date auditTime, Integer status, String remarks);
	public boolean decoratephotoAdd(int houseId, String photopath);
	public boolean typephotoAdd(int houseId, String photopath);
	public boolean decoratephotoUpdate(int decoratephotoId, int houseId,String photopath);
	public boolean typephotoUpdate(int typephotoId, int houseId, String photopath);
	public List<SedecoratePhoto> decoratephotoList();
	public List<SetypePhoto> typephotoList();
	public boolean decoratephotoDel(int decoratephotoId);
	public boolean typephotoDel(int typephotoId);
	public List secondPhoto(int houseId, String photoTable);
	public boolean secondusageAdd(int usageId, String usageName);
	public boolean secondusageUpdate(int usageId, String usageName);
	public List<FloorUsage> secondusageList();
	public boolean secondusageDel(int usageId);
	public String secondusageSearch(int usageId);
	
	public boolean pricetypeAdd(int pricetypeId, String pricetypeName);
	public boolean pricetypeUpdate(int pricetypeId, String pricetypeName);
	public List<PriceType> pricetypeList();
	public boolean pricetypeDel(int pricetypeId);
	public String pricetypeSearch(int pricetypeId);
	
	public boolean taxtypeAdd(int taxtypeId, String taxtypeName);
	public boolean taxtypeUpdate(int taxtypeId, String taxtypeName);
	public List<TaxType> taxtypeList();
	public boolean taxtypeDel(int taxtypeId);
	public String taxtypeSearch(int taxtypeId);
	
	
	public int getMaxId(String photoTable);
	public boolean secondDel(int houseId);
	public boolean secondUpdate(int houseId, String houseName, Integer regionId,
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
			String auditName, Date auditTime, Integer status, String remarks);
	public List<Secondhouse> secondList();
	public List<Secondhouse> secondList(int pageNo, int pageSize);
	public List<Secondhouse> secondSearch(String houseName);
	public int secondCount(int regionId, int usageId, int averagePrice, String likeName);
	public List<Secondhouse> secondSearch(int regionId, int usageId,int exchangePrice, 
									String likeName, int pageNo, int pageSize);
	public List<Secondhouse> serachsecond(Integer houseId, String memrole);

}
