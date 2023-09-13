package com.kh.mvc.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.mvc.model.vo.Member2;



@Repository
public class MemberDAO2 {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int registerMember(Member2 vo) throws Exception {
		return sqlSession.insert("MemberMapper.registerMember", vo);
		
	}
	
	public List<Member2> showAllMember() {
		return sqlSession.selectList("MemberMapper.showAllMember");
	}
	
	public List<Member2> findMember(String keyword) {
		return sqlSession.selectOne("MemberMapper.findMember",keyword);	
	}
	
	public Member2 login(Member2 vo) {
		return sqlSession.selectOne("MemberMapper.login", vo);
	}
	public int updateMember(Member2 vo) {
		return sqlSession.update("MemberMapper.updateMember", vo);
	}
	
	
	}


