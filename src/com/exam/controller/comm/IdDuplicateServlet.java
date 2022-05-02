package com.exam.controller.comm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.service.comm.CommonsService;
import com.exam.service.comm.CommonsServiceImpl;

/**
 * Servlet implementation class IdDuplicateServlet
 */
@WebServlet("/idDuplicate.do")
public class IdDuplicateServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private CommonsService commonService;
	
	public IdDuplicateServlet(){
		if(commonService == null){
			commonService = CommonsServiceImpl.getInstacne();
		}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int idCnt = 0;
		
		try {
			idCnt = commonService.idDuplicateCheck(id);
		} catch (SQLException e) {
			out.write("NO");
			e.printStackTrace();
		}
		
		if(idCnt == 0){
			out.write("OK");
		}else{
			out.write("NO");	
		}
	}

}
