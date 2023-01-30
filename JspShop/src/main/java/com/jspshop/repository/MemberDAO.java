package com.jspshop.repository;

import org.apache.ibatis.session.SqlSession;

import com.jspshop.domain.Member;
import com.jspshop.exception.MemberException;

public class MemberDAO {
	private SqlSession sqlSession;
	
	public void setSqlSesison(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	public void insert(Member member) throws MemberException{
		int result=0;
		result=sqlSession.insert("Member.insert", member);
		if(result<0) {
			throw new MemberException("회원가입 실패 ");
		}
	}
	
	
	
	public Member select(String id) throws MemberException{
		Member dto=null;
		dto=sqlSession.selectOne("Member.select", id);
		
		if(dto==null) {
			throw new MemberException("로그인 정보가 올바르지 않습니다");
		}
		return dto;
	}
	
	
	
}
