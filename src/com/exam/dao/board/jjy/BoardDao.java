package com.exam.dao.board.jjy;

import java.sql.SQLException;
import java.util.List;

import com.exam.vo.board.jjy.BoardVO;
import com.exam.vo.board.jjy.PagingVO;
import com.exam.vo.board.jjy.SearchVO;

public interface BoardDao {

	/**
	 * 게시글 조회
	 * @param searchVO
	 * @return
	 * @throws SQLException
	 */
	SearchVO selectJjyBoardList(SearchVO searchVO) throws SQLException;
	
	/**
	 * 게시글 등록
	 * @param boardVO
	 * @throws SQLException
	 */
	void insertJjyBoard(BoardVO boardVO) throws SQLException;
	
	/**
	 * 게시글 조회
	 * @param board_no
	 * @return
	 * @throws SQLException
	 */
	BoardVO selectJjyBoardDetail(int board_no) throws SQLException;
	
	/**
	 * 게시글 삭제
	 * @param board_no
	 * @throws SQLException
	 */
	void deleteJjyBoard(int board_no) throws SQLException;
	
	/**
	 * 게시글 수정
	 * @param boardVO
	 * @throws SQLException
	 */
	void updateJjyBoard(BoardVO boardVO) throws SQLException; 
	
}
