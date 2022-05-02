package com.exam.dao.comm;

import java.sql.SQLException;

import com.exam.vo.comm.MemberVO;

public interface CommonsDAO {

	//로그인 체크
	MemberVO loginCheck(MemberVO memberVO) throws SQLException;

	//아이디 중복체크
	int idDuplicateCheck(String id) throws SQLException;

	//회원가입
	void insertMember(MemberVO member) throws SQLException;
	
}
