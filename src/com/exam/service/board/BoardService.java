package com.exam.service.board;

import java.sql.SQLException;
import java.util.List;

import com.exam.vo.board.BoardVO;

public interface BoardService {
	
	//게시판 목록 조회
	List<BoardVO> selectBoardList() throws SQLException;
	
	//게시글 등록
	void insertBoard(BoardVO board) throws SQLException;

	//게시글 상세정보
	BoardVO selectBoardByBoardNo(String board_no) throws SQLException;
	
}
