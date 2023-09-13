package com.kh.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mvc.model.dao.MemberDAO2;
import com.kh.mvc.model.vo.Member2;

@Service
public class MemberService2 {

	
	
	
	@Autowired
	private MemberDAO2 dao;
	
	public int registerMember(Member2 vo) throws Exception{
		return dao.registerMember(vo);
	}
	public List<Member2> findMember(String keyword) {
		return dao.findMember(keyword);
	}
	
	public List<Member2> showAllMemeber() {
		return dao.showAllMember();
	}
	
	public Member2 login(Member2 vo) {
		return dao.login(vo);
	}
	
	public int updateMember(Member2 vo) {
		return dao.updateMember(vo);
	}
}
