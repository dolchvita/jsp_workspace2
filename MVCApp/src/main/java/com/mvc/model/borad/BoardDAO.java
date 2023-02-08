package com.mvc.model.borad;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mvc.domain.Board;
import com.mvc.exception.BoardException;

public class BoardDAO {
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List selectAll() {
		return sqlSession.selectList("Board.selectAll");
	}
	
	public Board select(int board_idx) {
		return sqlSession.selectOne("Board.select", board_idx);
	}
	
	public void insert(Board board) throws BoardException{
		int result=sqlSession.insert("Board.insert", board);
		if(result<1) {
			throw new BoardException("등록 실패 ");
		}
	}
	

}
