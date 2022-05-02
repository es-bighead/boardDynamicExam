package com.exam.controller.comm;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.service.comm.CommonsService;
import com.exam.service.comm.CommonsServiceImpl;
import com.exam.vo.comm.MemberVO;

import util.comm.ViewResolver;

/**
 * Servlet implementation class AcountServlet
 */
@WebServlet("/acount.do")
public class AcountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CommonsService commonsService;
	
	public AcountServlet(){
		if(commonsService == null){
			commonsService = CommonsServiceImpl.getInstacne();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "sign/sign";
		ViewResolver.view(request, response, url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "redirect:/login.do?chk=y";
		
		MemberVO member = new MemberVO();
		member.setLgin_id(request.getParameter("id"));
		member.setCel(request.getParameter("cel"));
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		member.setAddr(request.getParameter("addr"));
		member.setPwd(request.getParameter("pwd"));
		
		try {
			commonsService.insertMember(member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ViewResolver.view(request, response, url);
		
	}

}
