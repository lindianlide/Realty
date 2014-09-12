package com.realty.base.action;

import java.util.Date;
import java.util.List;

import com.realty.base.model.FloorUsage;
import com.realty.base.model.PriceType;
import com.realty.base.model.Secondhouse;
import com.realty.base.model.SedecoratePhoto;
import com.realty.base.model.SetypePhoto;
import com.realty.base.model.TaxType;
import com.realty.base.service.SecondService;
import com.realty.base.service.impl.SecondServiceImpl;

public class SecondAction {
	SecondService secondService=new SecondServiceImpl();
	public boolean secondAdd(String houseName, Integer regionId,
			String propertyAdress, String propertyName,
			Integer usageId, Date exchangeTime, Double buildingArea,
			Integer structureId, String present, Double exchangePrice,
			Double exchangeTotle, Integer pricetypeId, Integer taxtypeId,
			Double taxTotle, Double taxSeller, Double taxBuyer,
			Integer decorateId, String buildingTime,
			String floorTotle, Integer floorSaid, Integer floorActual,
			String roomRate, String houseType,
			String orientation, String otherfile,
			String introduction, Double longitude, Double latitude,
			String saleTime, Integer entryId, String entryName,
			Date entryTime, String auditName, Date auditTime,
			Integer status, String remarks){
		return secondService.secondAdd(houseName, regionId,propertyAdress, propertyName,
				usageId, exchangeTime, buildingArea,structureId, present, exchangePrice,
				exchangeTotle, pricetypeId, taxtypeId,taxTotle, taxSeller, taxBuyer,
				decorateId, buildingTime,floorTotle, floorSaid, floorActual,
				roomRate, houseType,orientation, otherfile,
				introduction, longitude, latitude,saleTime, entryId, entryName,
				entryTime, auditName, auditTime,status, remarks);
	}	


	public boolean decoratephotoAdd(int houseId,String photopath)
	{
		return secondService.decoratephotoAdd(houseId, photopath);	
	}
	public boolean typephotoAdd(int houseId,String photopath)
	{
		return secondService.typephotoAdd(houseId, photopath);
	}
	public boolean decoratephotoUpdate(int decoratephotoId,int houseId,String photopath)
	{
		return secondService.decoratephotoUpdate(decoratephotoId,houseId, photopath);	
	}
	public boolean typephotoUpdate(int typephotoId,int houseId,String photopath)
	{
		return secondService.typephotoUpdate(typephotoId,houseId, photopath);
	}
	public List<SedecoratePhoto> decoratephotoList()
	{
		return secondService.decoratephotoList();	
	}
	public List<SetypePhoto> typephotoList()
	{
		return secondService.typephotoList();
	}
	public boolean decoratephotoDel(int decoratephotoId)
	{
		return secondService.decoratephotoDel(decoratephotoId);	
	}
	public boolean typephotoDel(int typephotoId)
	{
		return secondService.typephotoDel(typephotoId);
	}
	
	
	public List secondPhoto(int houseId,String photoTable) {
		return secondService.secondPhoto(houseId, photoTable);
	}
	
	
	public boolean secondusageAdd(int usageId, String usageName){
		
		return secondService.secondusageAdd(usageId, usageName);
	}
	
	public boolean secondusageUpdate(int usageId, String usageName){
		
		return secondService.secondusageAdd(usageId, usageName);
	}
	public List<FloorUsage> secondusageList(){
		
		return secondService.secondusageList();
	}
	
	public boolean secondusageDel(int usageId){
		
		return secondService.secondusageDel(usageId);
	}
	
	
	public String secondusageSearch(int usageId){
		
		return secondService.secondusageSearch(usageId);
	}

	
	public boolean pricetypeAdd(int pricetypeId, String pricetypeName){
		
		return secondService.pricetypeAdd(pricetypeId, pricetypeName);
	}
	
	public boolean pricetypeUpdate(int pricetypeId, String pricetypeName){
		
		return secondService.pricetypeUpdate(pricetypeId, pricetypeName);
	}
	
	public List<PriceType> pricetypeList(){
		
		return secondService.pricetypeList();
	}
	
	public boolean pricetypeDel(int pricetypeId){
		
		return secondService.pricetypeDel(pricetypeId);
	}
	
	public String pricetypeSearch(int pricetypeId){
		
		return secondService.pricetypeSearch(pricetypeId);
	}

	
	public boolean taxtypeAdd(int taxtypeId, String taxtypeName){
		
		return secondService.taxtypeAdd(taxtypeId, taxtypeName);
	}
	
	public boolean taxtypeUpdate(int taxtypeId, String taxtypeName){
		
		return secondService.taxtypeUpdate(taxtypeId, taxtypeName);
	}
	
	public List<TaxType> taxtypeList(){
		
		return secondService.taxtypeList();
	}
	
	public boolean taxtypeDel(int taxtypeId){
		
		return secondService.taxtypeDel(taxtypeId);
	}
	
	public String taxtypeSearch(int taxtypeId){
		
		return secondService.taxtypeSearch(taxtypeId);
	}
	public int getMaxId(String photoTable){
		return secondService.getMaxId(photoTable);
	}
	
	public boolean secondDel(int houseId)
	{
		return secondService.secondDel(houseId);
	}
	
	public boolean secondUpdate(int houseId,String houseName, Integer regionId,
			String propertyAdress, String propertyName,
			Integer usageId, Date exchangeTime, Double buildingArea,
			Integer structureId, String present, Double exchangePrice,
			Double exchangeTotle, Integer pricetypeId, Integer taxtypeId,
			Double taxTotle, Double taxSeller, Double taxBuyer,
			Integer decorateId, String buildingTime,
			String floorTotle, Integer floorSaid, Integer floorActual,
			String roomRate, String houseType,
			String orientation, String otherfile,
			String introduction, Double longitude, Double latitude,
			String saleTime, Integer entryId, String entryName,
			Date entryTime, String auditName, Date auditTime,
			Integer status, String remarks){
		return secondService.secondUpdate(houseId,houseName, regionId,propertyAdress, propertyName,
				usageId, exchangeTime, buildingArea,structureId, present, exchangePrice,
				exchangeTotle, pricetypeId, taxtypeId,taxTotle, taxSeller, taxBuyer,
				decorateId, buildingTime,floorTotle, floorSaid, floorActual,
				roomRate, houseType,orientation, otherfile,
				introduction, longitude, latitude,saleTime, entryId, entryName,
				entryTime, auditName, auditTime,status, remarks);
	}
	
	public List<Secondhouse> secondList(){
		return secondService.secondList();
	}
	public List<Secondhouse> secondList(int pageNo,int pageSize){
		return secondService.secondList(pageNo, pageSize);
	}
	public List<Secondhouse> secondSearch(String houseName){
		return secondService.secondSearch(houseName);
	}
	public int secondCount(int regionId,int usageId,int exchangePrice,String likeName){
		return secondService.secondCount(regionId, usageId, exchangePrice, likeName);
	}
	public List<Secondhouse> secondSearch(int regionId,int usageId,int exchangePrice,String likeName,int pageNo,int pageSize){
		return secondService.secondSearch(regionId, usageId, exchangePrice,likeName,pageNo,pageSize);
	}
	public List<Secondhouse> serachsecond(Integer houseId,String memrole){
		return secondService.serachsecond(houseId,memrole);
	}
}
