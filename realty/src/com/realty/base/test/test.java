package com.realty.base.test;

import java.util.List;

import com.realty.base.action.LandAction;
import com.realty.base.action.LandzpgAction;
import com.realty.base.model.Land;
import com.realty.base.model.Manager;
import com.realty.base.utils.GenericDaoHibernate;

public class test extends GenericDaoHibernate<Manager, Integer> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		test t=new test(); 
		//Manager manager=new Manager();
		LandAction landaction=new LandAction();
		  Land land2=new Land();
		  land2.setLandName("222");
		  land2.setAddress("22222");
		  land2.setInitialPrice(0);
		  land2.setBuilddealPrice(0);
		//System.out.println(landzpgaction.landzpgsearch(26).get(0).getLandusageId());
/*for(int i=0;i<manager.size();i++)
	System.out.println(manager.get(i).getName());
	}*/
	}
}
