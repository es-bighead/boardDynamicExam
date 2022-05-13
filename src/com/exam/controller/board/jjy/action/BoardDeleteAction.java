package com.exam.controller.board.jjy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.dao.board.jjy.BoardDao;
import com.exam.dao.board.jjy.BoardDaoImpl;

import util.comm.ViewResolver;

public class BoardDeleteAction implements Action {

	private BoardDao boardDao;
	
	public BoardDeleteAction() {
		if(boardDao == null) {
			boardDao = BoardDaoImpl.getInstance();
		}
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("boardDelete 실행");
		
		HttpSession session = request.getSession();
		String url = "redirect:/jjy/board?command=list&pageIndex=1";
		
		if(session.getAttribute("loginUser") == null) {
			url = "redirect:/";
		} else {
			
			int board_no = Integer.parseInt(request.getParameter("board_no"));
			
			try {
				boardDao.deleteJjyBoard(board_no);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		ViewResolver.view(request, response, url);
		
	}

	
	
}
