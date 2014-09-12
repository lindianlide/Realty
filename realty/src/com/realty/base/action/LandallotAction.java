package com.realty.base.action;

import java.util.List;

import com.realty.base.model.LandAllot;
import com.realty.base.service.LandService;
import com.realty.base.service.impl.LandServiceImpl;
import com.realty.base.utils.GenericDaoHibernate;

public class LandallotAction extends  GenericDaoHibernate<LandAllot, Integer>{
	LandService landservice=new LandServiceImpl();
	public List<LandAllot> landallotsearch(int landId){
		return landservice.landallotsearch(landId);
		
	}
}
