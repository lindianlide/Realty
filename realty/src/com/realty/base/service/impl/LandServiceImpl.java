package com.realty.base.service.impl;

import java.util.Date;
import java.util.List;

import com.realty.base.dao.LandDao;
import com.realty.base.dao.impl.LandDaoImpl;
import com.realty.base.model.Land;
import com.realty.base.model.LandAllot;
import com.realty.base.model.LandLocation;
import com.realty.base.model.LandMutiusage;
import com.realty.base.model.LandPhoto;
import com.realty.base.model.LandPoss;
import com.realty.base.model.LandSellway;
import com.realty.base.model.LandUsage;
import com.realty.base.service.LandService;

public class LandServiceImpl implements LandService {
	LandDao landdao=new LandDaoImpl();
	public boolean landphotoAdd(int landId, String photopath){
		return landdao.landphotoAdd(landId, photopath);
	}
	public boolean landlocationphotoAdd(int landId, String photopath){
		return landdao.landlocationphotoAdd(landId, photopath);		
	}
	
	public boolean landphotoUpdate(int landphotoId, int landId,String photopath){
		return landdao.landphotoUpdate(landphotoId, landId, photopath);
	}
	public boolean landlocationUpdate(int landlocationId, int landId, String photopath){ 
		return landdao.landlocationUpdate(landlocationId, landId, photopath);
	}
	
	public List<LandPhoto> landphotoList(){
		return landdao.landphotoList();
	}
	public List<LandLocation> landlocationList(){
		return landdao.landlocationList();
	}
	
	public boolean landphotoDel(int landphotoId){
		return landdao.landphotoDel(landphotoId);
	}
	public boolean landlocationDel(int landlocationId){
		return landdao.landlocationDel(landlocationId);
	}
	
	public List landPhoto(int landId, String photoTable){
		return landdao.landPhoto(landId, photoTable);
	}
	
	public boolean landusageAdd(int usageId, String usageName){ 
		return landdao.landusageAdd(usageId, usageName);
	}
	public boolean landusageUpdate(int usageId, String usageName){ 
		return landdao.landusageUpdate(usageId, usageName);
	}
	public List<LandUsage> landusageList(){ 
		return landdao.landusageList();
	}
	public boolean landusageDel(int usageId){
		return landdao.landusageDel(usageId);
	}
	public String landusageSearch(int usageId){ 
		return landdao.landusageSearch(usageId);
	}
	
	public boolean landpossAdd(int landpossIdId, String landpossIdName){
		return landdao.landpossAdd(landpossIdId, landpossIdName);
	}
	public boolean landpossUpdate(int landpossIdId, String landpossIdName){ 
		return landdao.landpossUpdate(landpossIdId, landpossIdName);
	}
	public List<LandPoss> landpossList(){ 
		return landdao.landpossList();
	}
	public boolean landpossDel(int landpossIdId){
		return landdao.landpossDel(landpossIdId);
	}
	public String landpossSearch(int landpossIdId){
		return landdao.landpossSearch(landpossIdId);
	}
	
	public boolean sellwayAdd(int sellwayId, String sellwayName){
		return landdao.sellwayAdd(sellwayId, sellwayName);
	}
	public boolean sellwayUpdate(int sellwayId, String sellwayName){
		return landdao.sellwayUpdate(sellwayId, sellwayName);
	}
	public List<LandSellway> sellwayList(){
		return landdao.sellwayList();
	}
	public boolean sellwayDel(int sellwayId){
		return landdao.sellwayDel(sellwayId);
				}
	public String sellwaySearch(int sellwayId){
		return landdao.sellwaySearch(sellwayId);
	}
	
	public int getMaxId(String photoTable){
		return landdao.getMaxId(photoTable);
	}
	
	public List<Land> landSearch(String landName){
		return landdao.landSearch(landName);
	}
	
	public int landCount(int regionId, int usageId, int landdealPrice, String likeName){ 
		return landdao.landCount(regionId, usageId, landdealPrice, likeName);
	}
	public List<Land> landSearch(int regionId, int usageId,int landdealPrice, 
									String likeName, int pageNo, int pageSize){
		return landdao.landSearch(regionId, usageId, landdealPrice, likeName, pageNo, pageSize);
	}
	public List<Land> searchLand(Integer landId, String memrole){
		return landdao.searchLand(landId, memrole);
	}
	public List landbuildingPhoto(int landId,String photoTable){
		return landdao.landbuildingPhoto(landId,photoTable);
	}
	@Override
	public List<LandMutiusage> landzpgsearch(int landId) {
		// TODO Auto-generated method stub
		return landdao.landzpgsearch(landId);
	}
	@Override
	public List<LandAllot> landallotsearch(int landId) {
		// TODO Auto-generated method stub
		return landdao.landallotsearch(landId);
		}
	@Override
	public boolean landsellUpdate(int landId, String sellAnnounce) {
		// TODO Auto-generated method stub
		return landdao.landsellUpdate(landId, sellAnnounce);
	}
	@Override
	public boolean landdealUpdate(int landId, String dealAnnounce) {
		// TODO Auto-generated method stub
		return landdao.landdealUpdate(landId, dealAnnounce);
	}

	

}
