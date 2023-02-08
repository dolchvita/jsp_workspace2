package com.mvc.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.mvc.controller.Controller;
import com.mvc.domain.Board;
import com.mvc.model.borad.BoardDAO;
import com.mvc.mybatis.MybatisConfig;

public class RegistController implements Controller{
	MybatisConfig mybatisConfig=MybatisConfig.getInstance();
	BoardDAO boardDAO=new BoardDAO();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		SqlSession sqlSession=mybatisConfig.getSqlSession();
		boardDAO.setSqlSession(sqlSession);
		
		
		Board board=new Board();
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));
		
		boardDAO.insert(board);
		
		sqlSession.commit();
		mybatisConfig.release(sqlSession);
	
	}

	@Override
	public String getViewName() {
		return "/board/view/regist";
	}

	@Override
	public boolean isForward() {
		return false;
	}

	
}
