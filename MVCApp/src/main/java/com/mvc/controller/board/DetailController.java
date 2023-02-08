package com.mvc.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.mvc.controller.Controller;
import com.mvc.domain.Board;
import com.mvc.model.borad.BoardDAO;
import com.mvc.mybatis.MybatisConfig;

public class DetailController implements Controller{
	MybatisConfig mybatisConfig=MybatisConfig.getInstance();
	BoardDAO boardDAO=new BoardDAO();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		SqlSession sqlSession=mybatisConfig.getSqlSession();
		boardDAO.setSqlSession(sqlSession);
		
		String board_idx=request.getParameter("board_idx");
		Board board=boardDAO.select(Integer.parseInt(board_idx));
		
		request.setAttribute("board", board);
		
		// 저장값이 있으므로, foward의 대상이 된다.
		
		mybatisConfig.release(sqlSession);
	};

	@Override
	public String getViewName() {
		return "/board/view/detail";
	}

	@Override
	public boolean isForward() {
		return true;
	}
	
}
