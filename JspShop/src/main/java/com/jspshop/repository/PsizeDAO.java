package com.jspshop.repository;

import org.apache.ibatis.session.SqlSession;

import com.jspshop.domain.Color;
import com.jspshop.domain.Psize;
import com.jspshop.exception.ColorException;
import com.jspshop.exception.PsizeException;

public class PsizeDAO {
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void insert(Psize psize) throws PsizeException{
		int result=sqlSession.insert("Psize.insert", psize);
		if(result<1) {
			throw new PsizeException("사이즈 입력 실패");
		}
	}
	
}
