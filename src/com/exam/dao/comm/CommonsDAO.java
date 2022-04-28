package com.exam.dao.comm;

import java.sql.SQLException;

import com.exam.vo.comm.MemberVO;

public interface CommonsDAO {

	//로그인 체크
	MemberVO loginCheck(MemberVO memberVO) throws SQLException;
	
}
