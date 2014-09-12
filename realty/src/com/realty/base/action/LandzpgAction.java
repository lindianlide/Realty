package com.realty.base.action;

import java.util.List;

import com.realty.base.model.LandMutiusage;
import com.realty.base.service.LandService;
import com.realty.base.service.impl.LandServiceImpl;
import com.realty.base.utils.GenericDaoHibernate;

public class LandzpgAction extends GenericDaoHibernate<LandMutiusage, Integer>{
	LandService landservice=new LandServiceImpl();
	public List<LandMutiusage> landzpgsearch(int landId){
		return landservice.landzpgsearch(landId);
		
	}
}
