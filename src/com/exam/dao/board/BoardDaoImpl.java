package com.exam.dao.board;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.exam.controller.board.SearchCriteria;
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
	public List<BoardVO> selectBoardList(SearchCriteria cri) throws SQLException {
		sqlSession = sqlFactory.openSession();
		RowBounds rowBounds = new RowBounds(cri.getPageStartRowNum(), cri.getPerPageNum());
		List<BoardVO> boardList = sqlSession.selectList("Board-Mapper.selectBoardList", cri, rowBounds);
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

	@Override
	public void updateModifyBoard(BoardVO board) throws SQLException {
		sqlSession = sqlFactory.openSession();
		try{
			int updateChk = sqlSession.update("Board-Mapper.updateModifyBoard", board);
			
			if(updateChk > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		}finally{
			sqlSession.close();
		}
		
	}

	@Override
	public void deleteBoard(String board_no) throws SQLException {
		sqlSession = sqlFactory.openSession();
		try{
			
			int deleteChk = sqlSession.update("Board-Mapper.deleteBoard", board_no);
			
			if(deleteChk > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
			
		}finally{
			sqlSession.close();
		}
		
	}

}
