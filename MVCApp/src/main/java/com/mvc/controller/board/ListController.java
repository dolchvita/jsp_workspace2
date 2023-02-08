package com.mvc.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.mvc.controller.Controller;
import com.mvc.domain.Board;
import com.mvc.model.borad.BoardDAO;
import com.mvc.mybatis.MybatisConfig;

public class ListController implements Controller{
	MybatisConfig mybatisConfig=MybatisConfig.getInstance();
	BoardDAO boardDAO=new BoardDAO();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		SqlSession sqlSession=mybatisConfig.getSqlSession();
		boardDAO.setSqlSession(sqlSession);
		
		List<Board> boardList=boardDAO.selectAll();
		request.setAttribute("boardList", boardList);
		
		mybatisConfig.release(sqlSession);
	}

	@Override
	public String getViewName() {
		return "/board/view/list";
	}

	@Override
	public boolean isForward() {
		return true;
	}

}
