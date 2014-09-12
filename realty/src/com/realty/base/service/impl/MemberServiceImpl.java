package com.realty.base.service.impl;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.naming.java.javaURLContextFactory;

import com.realty.base.dao.MemberDao;
import com.realty.base.dao.impl.MemberDaoImpl;
import com.realty.base.model.Member;
import com.realty.base.service.MemberService;


public class MemberServiceImpl implements MemberService {
	MemberDao memberDao=new MemberDaoImpl();
	public boolean login(String membername, String memberpwd) {
		//System.out.println(membername);
		return memberDao.login(membername, memberpwd);
	}
	

	/*public List<Member> memberList() {
		// TODO Auto-generated method stub
		return memberDao.memberList();
	}
	@Override*/
	public boolean add(String membername, String memberpwd, String email,
			String question, String answer, 
			String registerId) {
		
		// TODO Auto-generated method stub
		return memberDao.add(membername, memberpwd,email,question,answer,registerId);
	}
	public List<Member> find(String email){
		return memberDao.find(email);
	}
	public List<Member> findn(String membername){
		return memberDao.findn(membername);
	}





}
