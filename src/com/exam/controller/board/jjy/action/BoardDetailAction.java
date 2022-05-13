package com.exam.controller.board.jjy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.dao.board.jjy.BoardDao;
import com.exam.dao.board.jjy.BoardDaoImpl;
import com.exam.vo.board.jjy.BoardVO;
import com.exam.vo.board.jjy.SearchVO;

import util.comm.ViewResolver;

public class BoardDetailAction implements Action{

	private BoardDao boardDao;
	
	public BoardDetailAction() {
		if(boardDao == null) {
			boardDao = BoardDaoImpl.getInstance();
		}
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("boardDetail 실행");
		
		HttpSession session = request.getSession();
		String url = "board/jjy/boardDetail";
		
		if(session.getAttribute("loginUser") == null) {
			url = "redirect:/";
		} else {
			
			int board_no = Integer.parseInt(request.getParameter("board_no"));
			BoardVO boardVO = null;
			
			try {
				boardVO = boardDao.selectJjyBoardDetail(board_no);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			request.setAttribute("boardVO", boardVO);
			
		}
	
		ViewResolver.view(request, response, url);
		
	}
	
}
