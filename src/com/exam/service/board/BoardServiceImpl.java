package com.exam.service.board;

import java.sql.SQLException;
import java.util.List;

import com.exam.dao.board.BoardDao;
import com.exam.dao.board.BoardDaoImpl;
import com.exam.vo.board.BoardVO;

public class BoardServiceImpl implements BoardService{

	private static BoardService boardService;
	
	public static BoardService getInstance(){
		if(boardService == null){
			boardService = new BoardServiceImpl();
		}
		return boardService;
	}
	
	private BoardDao boardDao;
	
	private BoardServiceImpl() {
		if(boardDao == null){
			boardDao = BoardDaoImpl.getInstance();
		}
	}
	
	
	@Override
	public List<BoardVO> selectBoardList() throws SQLException {
		return boardDao.selectBoardList();
	}


	@Override
	public void insertBoard(BoardVO board) throws SQLException {
		boardDao.insertBoard(board);
	}


	@Override
	public BoardVO selectBoardByBoardNo(String board_no) throws SQLException {
		return boardDao.selectBoardByBoardNo(board_no);
	}

}
