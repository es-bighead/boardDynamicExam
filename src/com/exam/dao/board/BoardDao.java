package com.exam.dao.board;

import java.sql.SQLException;
import java.util.List;

import com.exam.vo.board.BoardVO;

public interface BoardDao {
	
	List<BoardVO> selectBoardList() throws SQLException;

	void insertBoard(BoardVO board) throws SQLException;

	BoardVO selectBoardByBoardNo(String board_no) throws SQLException;

}
