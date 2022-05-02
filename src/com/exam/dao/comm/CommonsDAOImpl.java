package com.exam.dao.comm;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.exam.vo.comm.MemberVO;

import mybatis.config.DbFactory;

public class CommonsDAOImpl implements CommonsDAO {
	
	private static CommonsDAO commonsDao;
	
	public static CommonsDAO getInstance() {
		
		if(commonsDao == null){
			commonsDao = new CommonsDAOImpl();
		}
		
		return commonsDao;
	}
	
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	
	private CommonsDAOImpl() {
		if(sqlSessionFactory == null){
			sqlSessionFactory = DbFactory.getSqlSessionFacotry();	
		}
	}
	
	@Override
	public MemberVO loginCheck(MemberVO memberVO) throws SQLException {
		sqlSession = sqlSessionFactory.openSession();
		MemberVO member = sqlSession.selectOne("Commons-Mapper.loginCheck", memberVO.getLgin_id());
		sqlSession.close();
		return member;
	}

	@Override
	public int idDuplicateCheck(String id) throws SQLException {
		sqlSession = sqlSessionFactory.openSession();
		int idCnt = sqlSession.selectOne("Commons-Mapper.idDuplicateCheck", id);
		sqlSession.close();
		return idCnt;
	}

	@Override
	public void insertMember(MemberVO member) throws SQLException {
		sqlSession = sqlSessionFactory.openSession();
		
		try{
			int insertChk = sqlSession.update("Commons-Mapper.insertMember", member);
			
			if(insertChk > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
			
		}finally{
			sqlSession.close();
		}
		
	}

}
