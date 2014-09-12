package com.realty.base.action;


import java.util.Date;
import java.util.List;

import com.realty.base.model.Member;
import com.realty.base.service.MemberService;
import com.realty.base.service.impl.MemberServiceImpl;

public class MemberAction {
	MemberService memberService=new MemberServiceImpl();
	public boolean memberLogin(String membername,String memberpwd){
		return memberService.login(membername, memberpwd);
	}

	
	/*public List<Member> memberList(){
		return memberService.memberList();
	}*/
	public boolean memberAdd(String membername, String memberpwd, String email,
			String question, String answer, 
			String registerId) {
		// TODO Auto-generated method stub
		return memberService.add(membername, memberpwd,email,question,answer,registerId);
	}
	public List<Member> find(String email){
		return memberService.find(email);
	}
	public List<Member> findn(String membername){
		return memberService.findn(membername);
	}
}
