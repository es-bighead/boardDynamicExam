package com.exam.dao.board;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.exam.vo.board.BoardVO;

import mybatis.config.DbFactory;

public class BoardDaoImpl implements BoardDao{

	private static BoardDao boardDao;
	
	public static BoardDao getInstance(){
		if(boardDao == null){
			boardDao = new BoardDaoImpl();
		}
		return boardDao;
	}
	
	private SqlSessionFactory sqlFactory;
	private SqlSession sqlSession;
	
	private BoardDaoImpl() {
		if(sqlFactory == null){
			sqlFactory = DbFactory.getSqlSessionFacotry();
		}
	}
	
	@Override
	public List<BoardVO> selectBoardList() throws SQLException {
		sqlSession = sqlFactory.openSession();
		List<BoardVO> boardList = sqlSession.selectList("Board-Mapper.selectBoardList");
		sqlSession.close();
		return boardList;
	}

	@Override
	public void insertBoard(BoardVO board) throws SQLException {
		sqlSession = sqlFactory.openSession();
		try{
			int insertChk = sqlSession.update("Board-Mapper.insertBoard", board);
			
			if(insertChk > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		}finally{
			sqlSession.close();	
		}
		
	}

	@Override
	public BoardVO selectBoardByBoardNo(String board_no) throws SQLException {
		sqlSession = sqlFactory.openSession();
		BoardVO board = sqlSession.selectOne("Board-Mapper.selectBoardByBoardNo", board_no);
		sqlSession.close();
		return board;
	}

}
