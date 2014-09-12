package com.realty.base.test;

import java.util.List;

import com.realty.base.action.ManagerAction;
import com.realty.base.action.WebsiteAction;
import com.realty.base.dao.impl.BuildingDaoImpl;
import com.realty.base.dao.impl.WebsiteDaoImpl;
import com.realty.base.model.News;

public class ManagerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuildingDaoImpl website=new BuildingDaoImpl();
		int buildingId=6;
		String lawFile="fff";
		for(int i=0;i<website.floorList(buildingId).size();i++)
		System.out.println(website.floorList(buildingId).get(i).getBuildNum());

	}

}
