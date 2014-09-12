package com.realty.base.service;

import java.util.Date;
import java.util.List;

import com.realty.base.model.Member;



public interface MemberService {

public boolean login(String membername,String memberpwd);	
public boolean add(String membername,String memberpwd,String email,String question,String answer,String registerId);

public List<Member> find(String email);
public List<Member> findn(String membername);
}
