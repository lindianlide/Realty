package com.realty.base.action;

import java.util.Date;
import java.util.List;

import com.realty.base.model.Land;
import com.realty.base.model.LandLocation;
import com.realty.base.model.LandPhoto;
import com.realty.base.model.LandPoss;
import com.realty.base.model.LandSellway;
import com.realty.base.model.LandUsage;
import com.realty.base.service.LandService;
import com.realty.base.service.impl.LandServiceImpl;
import com.realty.base.utils.GenericDaoHibernate;


public class LandAction extends GenericDaoHibernate<Land, Integer>{
	LandService landservice=new LandServiceImpl();
	
	
	public boolean landphotoAdd(int landId, String photopath){
		return landservice.landphotoAdd(landId, photopath);
	}
	public boolean landlocationphotoAdd(int landId, String photopath){
		return landservice.landlocationphotoAdd(landId, photopath);		
	}
	
	public boolean landphotoUpdate(int landphotoId, int landId,String photopath){
		return landservice.landphotoUpdate(landphotoId, landId, photopath);
	}
	public boolean landlocationUpdate(int landlocationId, int landId, String photopath){ 
		return landservice.landlocationUpdate(landlocationId, landId, photopath);
	}
	
	public List<LandPhoto> landphotoList(){
		return landservice.landphotoList();
	}
	public List<LandLocation> landlocationList(){
		return landservice.landlocationList();
	}
	
	public boolean landphotoDel(int landphotoId){
		return landservice.landphotoDel(landphotoId);
	}
	public boolean landlocationDel(int landlocationId){
		return landservice.landlocationDel(landlocationId);
	}
	
	public List landPhoto(int landId, String photoTable){
		return landservice.landPhoto(landId, photoTable);
	}
	
	public boolean landusageAdd(int usageId, String usageName){ 
		return landservice.landusageAdd(usageId, usageName);
	}
	public boolean landusageUpdate(int usageId, String usageName){ 
		return landservice.landusageUpdate(usageId, usageName);
	}
	public List<LandUsage> landusageList(){ 
		return landservice.landusageList();
	}
	public boolean landusageDel(int usageId){
		return landservice.landusageDel(usageId);
	}
	public String landusageSearch(int usageId){ 
		return landservice.landusageSearch(usageId);
	}
	
	public boolean landpossAdd(int landpossIdId, String landpossIdName){
		return landservice.landpossAdd(landpossIdId, landpossIdName);
	}
	public boolean landpossUpdate(int landpossIdId, String landpossIdName){ 
		return landservice.landpossUpdate(landpossIdId, landpossIdName);
	}
	public List<LandPoss> landpossList(){ 
		return landservice.landpossList();
	}
	public boolean landpossDel(int landpossIdId){
		return landservice.landpossDel(landpossIdId);
	}
	public String landpossSearch(int landpossIdId){
		return landservice.landpossSearch(landpossIdId);
	}
	
	public boolean sellwayAdd(int sellwayId, String sellwayName){
		return landservice.sellwayAdd(sellwayId, sellwayName);
	}
	public boolean sellwayUpdate(int sellwayId, String sellwayName){
		return landservice.sellwayUpdate(sellwayId, sellwayName);
	}
	public List<LandSellway> sellwayList(){
		return landservice.sellwayList();
	}
	public boolean sellwayDel(int sellwayId){
		return landservice.sellwayDel(sellwayId);
				}
	public String sellwaySearch(int sellwayId){
		return landservice.sellwaySearch(sellwayId);
	}
	
	public int getMaxId(String photoTable){
		return landservice.getMaxId(photoTable);
	}
	
	public List<Land> landSearch(String landName){
		return landservice.landSearch(landName);
	}
	
	public int landCount(int regionId, int usageId, int landdealPrice, String likeName){ 
		return landservice.landCount(regionId, usageId, landdealPrice, likeName);
	}
	public List<Land> landSearch(int regionId, int usageId,int landdealPrice, 
									String likeName, int pageNo, int pageSize){
		return landservice.landSearch(regionId, usageId, landdealPrice, likeName, pageNo, pageSize);
	}
	public List<Land> searchLand(Integer landId, String memrole){
		return landservice.searchLand(landId, memrole);
	}
	public List landbuildingPhoto(int landId,String photoTable){
		return landservice.landbuildingPhoto(landId,photoTable);
	}

	public boolean landsellUpdate(int landId, String sellAnnounce) {
		// TODO Auto-generated method stub
		return landservice.landsellUpdate(landId, sellAnnounce);
	}
	public boolean landdealUpdate(int landId, String dealAnnounce) {
		// TODO Auto-generated method stub
		return landservice.landdealUpdate(landId, dealAnnounce);
	}

}
