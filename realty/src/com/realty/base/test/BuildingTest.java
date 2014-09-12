package com.realty.base.test;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
//import org.hibernate.mapping.List;












import com.realty.base.action.BuildingAction;
import com.realty.base.model.Building;
import com.realty.base.model.Manager;
import com.realty.base.utils.HibernateDaoSupport;
import com.realty.base.utils.HibernateSessionFactory;
import com.realty.base.utils.QueryUtils;
import com.realty.base.action.BuildingDecorateAction;
import com.realty.base.action.BuildingFormAction;
import com.realty.base.action.SecondAction;
import com.realty.base.action.WebsiteAction;
import com.realty.base.dao.BuildingDao;
import com.realty.base.dao.impl.BuildingDaoImpl;
import com.realty.base.model.BuildingForm;


public class BuildingTest {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int buildingId=213;
		String buildtimeOne="44";String buildtimeTwo=null;String buildtimeThree=null;String buildtimeOther=null;
		String buildingtimeFinish=null;String buildRegion=null;String projectFeature=null;
		int zipCode=0;
		String buildingStruc=null;
		String buildingType=null;
		Double propertyFee=0.0;
		String proWorkaddress=null;
		String proPhone=null;
		String proOtherinfor=null;
		String waterSupply=null;
		String electricitySupply=null;
		String heatSupply=null;
		String gas=null;
		String communications=null;
		String elevato=null;
		String security=null;
		String hygienism=null;
		String parking=null;
		String communityEnter=null;
		String propertyRight=null;
		int floors=0;
		int units=0;
		int currentHouses=0;
		int allHouses=0;
		String buildingintro=null;
		String editer=null;
		int microId=1;
		String title="2ee";
		String contents="ss";
		int browses=0;
		String proFile=null;
		int buildintroId=209;
		BuildingAction BA=new BuildingAction();
		BA.buildingintroDel(buildintroId);
		
		//BuildingDaoImpl b=new BuildingDaoImpl();
		//b.buildingUpdate(buildingId, buildtimeOne, buildtimeTwo, buildtimeThree, buildtimeOther, buildingtimeFinish, buildRegion, projectFeature, zipCode, buildingStruc, buildingType, propertyFee, proWorkaddress, proOtherinfor, waterSupply, electricitySupply, heatSupply, gas, communications, elevato, security, hygienism, parking, communityEnter, propertyRight, floors, units, currentHouses, allHouses, buildingintro, editer);
/*		HibernateDaoSupport hds=new HibernateDaoSupport();
		int buildingId=213;
		Double buildingArea=0.0;
		Object[] o={ buildingArea,buildingId};
		String hql="update Building set buildingArea=? where buildingId = ?";
		hds.batchUpdate(hql,o);*/

/*		int buildingId=213;
		String buildingName="Ô£Áú´óÏÃ";String buildingAlias="ÂÒÂëÂð";int regionId=0;String propertyAdress=null;
		 String propertyName=null;int usageId=0;int buildtimeId=0;String developers=null;Double floorArea=null;
		 Double buildingArea=null;int structureId=0;String formId=null;String plotRatio=null;Date landuseTime=null;
		 String buildingDensity=null;String greeningRate=null;BigDecimal parkingRatio=null;int decorateId=0;Date openTime=null;
		 String propertyService=null;Double initialPrice=null;Double averagePrice=null;Double perPrice=null;
		 Double totalPrice=null;String locationphoto=null;int landId=0;int buildintroId=0;Double longitude=null;
		 Double latitude=null;int entryId=2;String entryName=null;Date entryTime=null;String auditName=null;
		 Date auditTime=null;int status=0;String remarks=null;
			BuildingAction buildingaction=new BuildingAction();
		System.out.println(buildingaction.buildingUpdate(buildingId,buildingName, buildingAlias, regionId, propertyAdress, 
				propertyName, usageId, buildtimeId, developers, floorArea, buildingArea, structureId, 
				formId, plotRatio, landuseTime, buildingDensity, greeningRate, parkingRatio, decorateId, 
				openTime, propertyService, initialPrice, averagePrice, perPrice, totalPrice, locationphoto, 
				landId, buildintroId, longitude, latitude, entryId, entryName, entryTime, auditName, 
				auditTime, status, remarks));*/
		/*
		int buildingId=210;
		String propertyAdress="2222";
		String buildingName="22";
		BuildingDaoImpl b=new BuildingDaoImpl();
		b.bAdd(buildingId, buildingName,propertyAdress);*/
	}
		/*	String houseName="gh¸Õ¸Õ"; int regionId=0;
		String propertyAdress=null; String propertyName=null;
		int usageId=0; Date exchangeTime=null; Double buildingArea=null;
		int structureId=0; String present=null; Double exchangePrice=null;
		Double exchangeTotle=null; int pricetypeId=0; int taxtypeId=0;
		Double taxTotle=null; Double taxSeller=null; Double taxBuyer=null;
		int decorateId=0; String buildingTime=null;
		String floorTotle=null; int floorSaid=0; int floorActual=0;
		String roomRate=null; String houseType=null;
		String orientation=null; String otherfile=null;
		String introduction=null; Double longitude=null; Double latitude=null;
		String saleTime=null; int entryId=1; String entryName=null;
		Date entryTime=null; String auditName=null; Date auditTime=null;
		int status=0; String remarks=null;
		SecondAction secondaction=new SecondAction();
		// boolean outcome=secondaction.secondAdd(houseName, regionId, propertyAdress, propertyName, usageId, exchangeTime, buildingArea, structureId, present, exchangePrice, exchangeTotle, pricetypeId, taxtypeId, taxTotle, taxSeller, taxBuyer, decorateId, buildingTime, floorTotle, floorSaid, floorActual, roomRate, houseType, orientation, otherfile, introduction, longitude, latitude, saleTime, entryId, entryName, entryTime, auditName, auditTime, status, remarks);
		int maxId=1;
		int houseId=20;
		String decoratephotopath="dd";
		//secondaction.decoratephotoUpdate(maxId, houseId, decoratephotopath);
		
		String typephoto ="dd";
		List typeList=secondaction.secondPhoto(houseId, typephoto);
	}
		long beginTime = System.currentTimeMillis(); 
		
		BuildingAction buildingaction=new BuildingAction();
		buildingaction.buildingList();
		 long endTime = System.currentTimeMillis();  
		 System.out.println("µÚ´ÎÖ´ÐÐ»¨·ÑÊ±¼äÎª:" + (endTime - beginTime));  
	}
		int buildingId=6;
		String buildingName="Ô£Áú´óÏÃ";String buildingAlias="ÂÒÂëÂð";int regionId=0;String propertyAdress=null;
		 String propertyName=null;int usageId=0;int buildtimeId=0;String developers=null;Double floorArea=null;
		 Double buildingArea=null;int structureId=0;String formId=null;String plotRatio=null;Date landuseTime=null;
		 String buildingDensity=null;String greeningRate=null;BigDecimal parkingRatio=null;int decorateId=0;Date openTime=null;
		 String propertyService=null;Double initialPrice=null;Double averagePrice=null;Double perPrice=null;
		 Double totalPrice=null;String locationphoto=null;int landId=0;int buildintroId=0;Double longitude=null;
		 Double latitude=null;int entryId=2;String entryName=null;Date entryTime=null;String auditName=null;
		 Date auditTime=null;int status=0;String remarks=null;
		
		System.out.println(buildingaction.buildingUpdate(buildingId,buildingName, buildingAlias, regionId, propertyAdress, 
				propertyName, usageId, buildtimeId, developers, floorArea, buildingArea, structureId, 
				formId, plotRatio, landuseTime, buildingDensity, greeningRate, parkingRatio, decorateId, 
				openTime, propertyService, initialPrice, averagePrice, perPrice, totalPrice, locationphoto, 
				landId, buildintroId, longitude, latitude, entryId, entryName, entryTime, auditName, 
				auditTime, status, remarks));*/
		//int buildingId=5;
		//System.out.println(buildingaction.buildingDel(buildingId));
		/*BuildingDecorateAction BD=new BuildingDecorateAction();
		int decorateId=7;
		String decorateName="Ô£Áú´óÏÃ";
		System.out.println(BD.BuildingDecorateAdd(decorateId, decorateName));
		BuildingFormAction BF=new BuildingFormAction();
		List<BuildingForm> BFList=BF.buildingformList();
        for(int i=0;i<BFList.size();i++){ 
        	System.out.println( BFList.get(i).getFormName());
		String str="000";
		System.out.println(""+str+"");*/
		
        }


	
