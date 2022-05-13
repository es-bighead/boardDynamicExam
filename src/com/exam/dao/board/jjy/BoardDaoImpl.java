package com.exam.dao.board.jjy;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.exam.vo.board.jjy.BoardVO;
import com.exam.vo.board.jjy.PagingVO;
import com.exam.vo.board.jjy.SearchVO;

import mybatis.config.DbFactory;

public class BoardDaoImpl implements BoardDao {

	private static BoardDao boardDao;

	public static BoardDao getInstance() {
		
		if (boardDao == null) {
			boardDao = new BoardDaoImpl();
		}

		return boardDao;
	}
	
	private SqlSessionFactory sqlFactory;
	private SqlSession sqlSession;
	
	private BoardDaoImpl() {
		
		if(sqlFactory == null) {
			sqlFactory = DbFactory.getSqlSessionFacotry();
		}
		
	}

	@Override
	public SearchVO selectJjyBoardList(SearchVO searchVO) throws SQLException {
		
		sqlSession = sqlFactory.openSession();
		try {
			searchVO.getPagingVO().handlePagingList(sqlSession.selectList("jjy-Board-Mapper.selectJjyBoardList", searchVO), sqlSession.selectOne("jjy-Board-Mapper.countJjyBoardList", searchVO));
		} finally {
			sqlSession.close();
		}
		
		return searchVO;
	}

	@Override
	public void insertJjyBoard(BoardVO boardVO) throws SQLException {
		sqlSession = sqlFactory.openSession();
		try {
			int insertChk = sqlSession.update("jjy-Board-Mapper.insertJjyBoard", boardVO);
			
			if(insertChk > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public BoardVO selectJjyBoardDetail(int board_no) throws SQLException {

		sqlSession = sqlFactory.openSession();
		BoardVO boardVO = null;
		try {
			boardVO = sqlSession.selectOne("jjy-Board-Mapper.selectJjyBoardDetail", board_no);
		} finally {
			sqlSession.close();
		}
		
		return boardVO;
	}

	@Override
	public void deleteJjyBoard(int board_no) throws SQLException {
		sqlSession = sqlFactory.openSession();
		try {
			int updateChk = sqlSession.update("jjy-Board-Mapper.deleteJjyBoard", board_no);
			
			if(updateChk > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void updateJjyBoard(BoardVO boardVO) throws SQLException {

		sqlSession = sqlFactory.openSession();
		try {
			int updateChk = sqlSession.update("jjy-Board-Mapper.updateJjyBoard", boardVO);
			
			if(updateChk > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
			
		} finally {
			sqlSession.close();
		}
		
	}
	
}
