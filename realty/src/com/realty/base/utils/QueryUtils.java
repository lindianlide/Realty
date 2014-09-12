package com.realty.base.utils;

import java.util.List;

public class QueryUtils {
	HibernateDaoSupport hds=new HibernateDaoSupport();
	public int getMaxId(String table)
	{
		String sql="SELECT IDENT_CURRENT('"+table+"')";
		List maxId=hds.findByParametersql(sql);
		return Integer.parseInt(maxId.get(0).toString());
	}
	public int count(String table){	
		String sql="select count(*) from "+table;
		List counts=hds.findByParametersql(sql);
		return Integer.parseInt(counts.get(0).toString());
	}
}
