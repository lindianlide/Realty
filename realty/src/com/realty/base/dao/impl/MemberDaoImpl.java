package com.realty.base.dao.impl;


import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.HashMap;

import org.apache.tomcat.jni.Mmap;

import com.realty.base.dao.MemberDao;
import com.realty.base.model.Building;
import com.realty.base.model.Member;
import com.realty.base.utils.HibernateDaoSupport;


public class MemberDaoImpl implements MemberDao {
	Member member=new Member();
	HibernateDaoSupport hds=new HibernateDaoSupport();
	
	
	public boolean login(String membername, String memberpwd) {
		// TODO Auto-generated method stub
		boolean result=false;
		System.out.print(membername);
		System.out.print(memberpwd);
		Object[] o={membername,memberpwd};
		String hql="from Member where name=? and password=?";
		List list=hds.findByParameter(hql,o);
		if(!list.isEmpty())
			result=true;
		System.out.print(result);
			return result;
	}
	
	public boolean add(String membername,String memberpwd,String email,String question,String answer,String registerId) {
		// TODO Auto-generated method stub
		
		member.setName(membername);
		member.setPassword(memberpwd);
		member.setEMail(email);
		member.setQuerstion(question);
		member.setAnswer(answer);
		
		
		
		//member.setCreateTime(stp);
		member.setMemrole(0);
		member.setRegisterId(registerId);
		hds.save(member);
		return true;
	}
	public boolean update(String email)
	{
		
		List<Member> list=hds.findByParameter("from Member where e_mail=?",email);
		member.setMemberId(list.get(0).getMemberId());
		member.setName(list.get(0).getName());
		member.setPassword(list.get(0).getPassword());
		member.setEMail(list.get(0).getEMail());
		member.setQuerstion(list.get(0).getQuerstion());
		member.setAnswer(list.get(0).getAnswer());
		member.setRegisterId(list.get(0).getRegisterId());
		member.setMemrole(1);
		System.out.print(member.getMemberId());
		hds.update(member);
		
		return true;
		
	}
	public List<Member> find(String email){
		Object[] o={email};
		List<Member> list=hds.findByParameter("from Member where EMail=?",o);
		return list;
    }
	public List<Member> findn(String membername){
	
		Object[] o={membername};
		List<Member> list=hds.findByParameter("from Member where name=?",o);
		return list;
    }
	
	/*public List<Member> memberList() {
		// TODO Auto-generated method stub
		HibernateDaoSupport hds=new HibernateDaoSupport();
		List<Member> list=hds.findByParameter("from Member");
		return list;
	}*/

	
	
	


}
