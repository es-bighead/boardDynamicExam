package com.exam.controller.comm;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.service.comm.CommonsService;
import com.exam.service.comm.CommonsServiceImpl;
import com.exam.vo.comm.MemberVO;

import exception.LoginCheckException;
import util.comm.ViewResolver;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CommonsService comService = CommonsServiceImpl.getInstacne();
	
	//로그인페이지
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "login/login";
		ViewResolver.view(request, response, url);
	}

	//로그인처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "main/main";
		
		String lgin_id = (String) request.getParameter("id");
		String pwd = (String) request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		MemberVO memberVO = new MemberVO();
		memberVO.setLgin_id(lgin_id);
		memberVO.setPwd(pwd);
		
		try {
			MemberVO loginUser = (MemberVO) comService.loginCheck(memberVO);
			session.setAttribute("loginUser", loginUser);
			session.setMaxInactiveInterval(60 * 10);
		}catch (LoginCheckException e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			url = "login/login";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ViewResolver.view(request, response, url);
		
	}

}
