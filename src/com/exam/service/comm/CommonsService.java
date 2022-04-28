package com.exam.service.comm;

import java.sql.SQLException;

import com.exam.vo.comm.MemberVO;

import exception.LoginCheckException;

public interface CommonsService {
	
	//회원 체크
	MemberVO loginCheck(MemberVO memberVO) throws LoginCheckException, SQLException;

}
