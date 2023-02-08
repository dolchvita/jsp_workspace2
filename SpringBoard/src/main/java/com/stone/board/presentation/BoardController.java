package com.stone.board.presentation;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.board.common.Board;
import com.stone.board.dataservice.BoardDAO;

// 게시물 관련 업무를 처리할 컨트롤러 객체 @Controller 표시가 있어야함! -- 그래 config가 찾아가겠지  
@Controller
public class BoardController {
	BoardDAO boardDAO=new BoardDAO();
	
	
	@GetMapping("getlist")
	public ModelAndView getList() {
		List<Board> boardList=boardDAO.selectAll();
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("boardList", boardList);
		mv.setViewName("board/list");
		return mv;
	}
	
	
	
	@GetMapping("getDetail")
	public ModelAndView getDetail(int no) {
		Board board=boardDAO.selectByNo(no);
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("board", board);
		mv.setViewName("board/detail");
		
		return mv;
	}
	
	
	// 입력창 먼저 보여주기 -- list.jsp 로부터 호출될 것
	// 여기서는 옮겨질 데이터가 없으므로, 그냥 보여질 페이지 주소값을 문자열로 반환하기 
	@GetMapping("regist")
	public String registform() {
		return "board/registform";
	}
	
	
	@PostMapping("regist")
	public ModelAndView regist(Board board) {
		ModelAndView mv=new ModelAndView();
		
		// 넣을 값은? 일단 제목만 
		mv.addObject("title", board.getTitle());
		// 그런다음 어디를 보여줄 거지?
		mv.setViewName("board/list");
		return mv;
	}
	
}
