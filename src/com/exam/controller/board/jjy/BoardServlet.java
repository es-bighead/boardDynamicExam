package com.exam.controller.board.jjy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.controller.board.jjy.action.Action;

@WebServlet("/jjy/board")
public class BoardServlet extends HttpServlet {
	
	public BoardServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String command = request.getParameter("command");
		System.out.println("BoardServlet에서 요청을 받음 : " + command);
		
		BoardActionFactory baf = BoardActionFactory.getInstance();
		
		// 커맨드에 해당하는 action 가져오기
		Action action = baf.getAction(command);
		
		// 불러온 action에 대한 서비스로직 실행
		if (action != null) {
			action.execute(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
		
	}
	
	
	
}
