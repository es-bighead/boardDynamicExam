package com.exam.service.board;

import java.sql.SQLException;
import java.util.List;

import com.exam.controller.board.SearchCriteria;
import com.exam.vo.board.BoardVO;

public interface BoardService {
	
	//게시판 목록 조회
	List<BoardVO> selectBoardList(SearchCriteria cri) throws SQLException;
	
	//게시글 등록
	void insertBoard(BoardVO board) throws SQLException;

	//게시글 상세정보
	BoardVO selectBoardByBoardNo(String board_no) throws SQLException;

	//게시글 수정
	void updateModifyBoard(BoardVO board) throws SQLException;

	//게시글 삭제
	void deleteBoard(String board_no) throws SQLException;
	
}
