package com.realty.base.service.impl;

import java.util.Date;
import java.util.List;

import com.realty.base.dao.SecondDao;
import com.realty.base.dao.impl.SecondDaoImpl;
import com.realty.base.model.FloorUsage;
import com.realty.base.model.PriceType;
import com.realty.base.model.Secondhouse;
import com.realty.base.model.SedecoratePhoto;
import com.realty.base.model.SetypePhoto;
import com.realty.base.model.TaxType;
import com.realty.base.service.SecondService;

public class SecondServiceImpl implements SecondService {
	SecondDao seconddao=new SecondDaoImpl();
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
		return seconddao.secondAdd(houseName, regionId, propertyAdress, propertyName, usageId, exchangeTime, buildingArea, structureId, present, exchangePrice, exchangeTotle, pricetypeId, taxtypeId, taxTotle, taxSeller, taxBuyer, decorateId, buildingTime, floorTotle, floorSaid, floorActual, roomRate, houseType, orientation, otherfile, introduction, longitude, latitude, saleTime, entryId, entryName, entryTime, auditName, auditTime, status, remarks);
	}

	@Override
	public boolean decoratephotoAdd(int houseId, String photopath) {
		// TODO Auto-generated method stub
		return seconddao.decoratephotoAdd(houseId, photopath);
	}

	@Override
	public boolean typephotoAdd(int houseId, String photopath) {
		// TODO Auto-generated method stub
		return seconddao.typephotoAdd(houseId, photopath);
	}

	@Override
	public boolean decoratephotoUpdate(int decoratephotoId, int houseId,
			String photopath) {
		// TODO Auto-generated method stub
		return seconddao.decoratephotoUpdate(decoratephotoId, houseId, photopath);
	}

	@Override
	public boolean typephotoUpdate(int typephotoId, int houseId,
			String photopath) {
		// TODO Auto-generated method stub
		return seconddao.typephotoUpdate(typephotoId, houseId, photopath);
	}

	@Override
	public List<SedecoratePhoto> decoratephotoList() {
		// TODO Auto-generated method stub
		return seconddao.decoratephotoList();
	}

	@Override
	public List<SetypePhoto> typephotoList() {
		// TODO Auto-generated method stub
		return seconddao.typephotoList();
	}

	@Override
	public boolean decoratephotoDel(int decoratephotoId) {
		// TODO Auto-generated method stub
		return seconddao.decoratephotoDel(decoratephotoId);
	}

	@Override
	public boolean typephotoDel(int typephotoId) {
		// TODO Auto-generated method stub
		return seconddao.typephotoDel(typephotoId);
	}

	@Override
	public List secondPhoto(int houseId, String photoTable) {
		// TODO Auto-generated method stub
		return seconddao.secondPhoto(houseId, photoTable);
	}
	@Override
	public boolean secondusageAdd(int usageId, String usageName){
		// TODO Auto-generated method stub
		return seconddao.secondusageAdd(usageId, usageName);
	}
	@Override
	public boolean secondusageUpdate(int usageId, String usageName){
		// TODO Auto-generated method stub
		return seconddao.secondusageAdd(usageId, usageName);
	}
	public List<FloorUsage> secondusageList(){
		// TODO Auto-generated method stub
		return seconddao.secondusageList();
	}
	@Override
	public boolean secondusageDel(int usageId){
		// TODO Auto-generated method stub
		return seconddao.secondusageDel(usageId);
	}
	
	@Override
	public String secondusageSearch(int usageId){
		// TODO Auto-generated method stub
		return seconddao.secondusageSearch(usageId);
	}

	@Override
	public boolean pricetypeAdd(int pricetypeId, String pricetypeName){
		// TODO Auto-generated method stub
		return seconddao.pricetypeAdd(pricetypeId, pricetypeName);
	}
	@Override
	public boolean pricetypeUpdate(int pricetypeId, String pricetypeName){
		// TODO Auto-generated method stub
		return seconddao.pricetypeUpdate(pricetypeId, pricetypeName);
	}
	@Override
	public List<PriceType> pricetypeList(){
		// TODO Auto-generated method stub
		return seconddao.pricetypeList();
	}
	@Override
	public boolean pricetypeDel(int pricetypeId){
		// TODO Auto-generated method stub
		return seconddao.pricetypeDel(pricetypeId);
	}
	@Override
	public String pricetypeSearch(int pricetypeId){
		// TODO Auto-generated method stub
		return seconddao.pricetypeSearch(pricetypeId);
	}

	@Override
	public boolean taxtypeAdd(int taxtypeId, String taxtypeName){
		// TODO Auto-generated method stub
		return seconddao.taxtypeAdd(taxtypeId, taxtypeName);
	}
	@Override
	public boolean taxtypeUpdate(int taxtypeId, String taxtypeName){
		// TODO Auto-generated method stub
		return seconddao.taxtypeUpdate(taxtypeId, taxtypeName);
	}
	@Override
	public List<TaxType> taxtypeList(){
		// TODO Auto-generated method stub
		return seconddao.taxtypeList();
	}
	@Override
	public boolean taxtypeDel(int taxtypeId){
		// TODO Auto-generated method stub
		return seconddao.taxtypeDel(taxtypeId);
	}
	@Override
	public String taxtypeSearch(int taxtypeId){
		// TODO Auto-generated method stub
		return seconddao.taxtypeSearch(taxtypeId);
	}
	
	
	
	@Override
	public int getMaxId(String photoTable) {
		// TODO Auto-generated method stub
		return seconddao.getMaxId(photoTable);
	}

	@Override
	public boolean secondDel(int houseId) {
		// TODO Auto-generated method stub
		return seconddao.secondDel(houseId);
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
		return seconddao.secondUpdate(houseId, houseName, regionId, propertyAdress, propertyName, usageId, exchangeTime, buildingArea, structureId, present, exchangePrice, exchangeTotle, pricetypeId, taxtypeId, taxTotle, taxSeller, taxBuyer, decorateId, buildingTime, floorTotle, floorSaid, floorActual, roomRate, houseType, orientation, otherfile, introduction, longitude, latitude, saleTime, entryId, entryName, entryTime, auditName, auditTime, status, remarks);
	}

	@Override
	public List<Secondhouse> secondList() {
		// TODO Auto-generated method stub
		return seconddao.secondList();
	}

	@Override
	public List<Secondhouse> secondList(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return seconddao.secondList(pageNo, pageSize);
	}

	@Override
	public List<Secondhouse> secondSearch(String houseName) {
		// TODO Auto-generated method stub
		return seconddao.secondSearch(houseName);
	}

	@Override
	public int secondCount(int regionId, int usageId, int averagePrice,String likeName) {
		// TODO Auto-generated method stub
		return seconddao.secondCount(regionId, usageId, averagePrice, likeName);
	}

	@Override
	public List<Secondhouse> secondSearch(int regionId, int usageId,int exchangePrice, String likeName, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return seconddao.secondSearch(regionId, usageId, exchangePrice, likeName, pageNo, pageSize);
	}

	@Override
	public List<Secondhouse> serachsecond(Integer houseId, String memrole) {
		// TODO Auto-generated method stub
		return seconddao.serachsecond(houseId, memrole);
	}

}
