package com.exam.service.comm;

import java.sql.SQLException;

import com.exam.dao.comm.CommonsDAO;
import com.exam.dao.comm.CommonsDAOImpl;
import com.exam.vo.comm.MemberVO;

import exception.LoginCheckException;

public class CommonsServiceImpl implements CommonsService {

	private static CommonsService comService;
	
	public static CommonsService getInstacne(){
		
		if(comService == null){
			comService = new CommonsServiceImpl();
		}
		
		return comService;
	}
	
	private CommonsDAO commonsDao = CommonsDAOImpl.getInstance();
	
	
	//회원 체크
	@Override
	public MemberVO loginCheck(MemberVO memberVO) throws LoginCheckException, SQLException {
		MemberVO member = commonsDao.loginCheck(memberVO);
		if(member == null){throw new LoginCheckException();}
		if(!memberVO.getPwd().equals(member.getPwd())){throw new LoginCheckException();}
		return member;
	}

}
