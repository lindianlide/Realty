package com.realty.base.dao;

import java.util.Date;
import java.text.ParseException;
import java.util.List;

import com.realty.base.model.Member;

public interface MemberDao {
	
	public boolean login(String username,String password);
	
	
	

	public boolean add(String membername,String memberpwd,String email,String question,String answer,String registerId);
	public boolean update(String email);
	public List<Member> find(String email);
	public List<Member> findn(String membername);
	}
