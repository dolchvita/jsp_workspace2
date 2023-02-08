package com.stone.board.dataservice;

import java.util.ArrayList;
import java.util.List;

import com.stone.board.common.Board;

public class BoardDAO {
	static ArrayList<Board> boardList=new ArrayList<Board>();
	// boardList를 여기에 선언하고 생성자에서 값을 메꾸는 이유?
	// 가짜 데이터이기 때문이지 않을까, 만약 진짜 데이터 였다면, mybatis로 참조 했을까?
	
	public BoardDAO() {
		// 임시 데이터 생성 
		for(int i=0; i<10; i++) {
			Board board=new Board();
			board.setNo(i);
			board.setTitle("제목 "+i);
			board.setContent("내용 "+i);
			boardList.add(board);
		}
	}
	
	
	public List<Board> selectAll() {
		return boardList;
	}
	
	
	
	public Board selectByNo(int no) {
		for(Board board:boardList) {
			if(board.getNo()==no) {
				return board;
			}
		}
		return null;
	}
	
	
	
	public int insert(Board board) {
		board.setNo(board.getNo()+1);
		board.setTitle(board.getTitle());
		boardList.add(board);
		return board.getNo();
	}
	
	
}
