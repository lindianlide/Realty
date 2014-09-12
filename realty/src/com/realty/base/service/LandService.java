package com.realty.base.service;

import java.util.Date;
import java.util.List;

import com.realty.base.model.Land;
import com.realty.base.model.LandAllot;
import com.realty.base.model.LandLocation;
import com.realty.base.model.LandMutiusage;
import com.realty.base.model.LandPhoto;
import com.realty.base.model.LandPoss;
import com.realty.base.model.LandSellway;
import com.realty.base.model.LandUsage;

public interface LandService {

	public boolean landphotoAdd(int landId, String photopath);
	public boolean landlocationphotoAdd(int landId, String photopath);
	
	public boolean landphotoUpdate(int landphotoId, int landId,String photopath);
	public boolean landlocationUpdate(int landlocationId, int landId, String photopath);
	
	public List<LandPhoto> landphotoList();
	public List<LandLocation> landlocationList();
	
	public boolean landphotoDel(int landphotoId);
	public boolean landlocationDel(int landlocationId);
	
	public List landPhoto(int landId, String photoTable);
	
	public boolean landusageAdd(int usageId, String usageName);
	public boolean landusageUpdate(int usageId, String usageName);
	public List<LandUsage> landusageList();
	public boolean landusageDel(int usageId);
	public String landusageSearch(int usageId);
	
	public boolean landpossAdd(int landpossIdId, String landpossIdName);
	public boolean landpossUpdate(int landpossIdId, String landpossIdName);
	public List<LandPoss> landpossList();
	public boolean landpossDel(int landpossIdId);
	public String landpossSearch(int landpossIdId);
	
	public boolean sellwayAdd(int sellwayId, String sellwayName);
	public boolean sellwayUpdate(int sellwayId, String sellwayName);
	public List<LandSellway> sellwayList();
	public boolean sellwayDel(int sellwayId);
	public String sellwaySearch(int sellwayId);
	
	public int getMaxId(String photoTable);
	
	public List<Land> landSearch(String landName);
	
	public int landCount(int regionId, int usageId, int landdealPrice, String likeName);
	public List<Land> landSearch(int regionId, int usageId,int landdealPrice, 
									String likeName, int pageNo, int pageSize);
	public List<Land> searchLand(Integer landId, String memrole);
	public List landbuildingPhoto(int landId,String photoTable);
	public List<LandMutiusage> landzpgsearch(int landId);
	public List<LandAllot> landallotsearch(int landId);
	public boolean landsellUpdate(int landId, String sellAnnounce);
	public boolean landdealUpdate(int landId, String dealAnnounce);
}
