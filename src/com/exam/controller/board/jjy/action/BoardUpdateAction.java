package com.exam.controller.board.jjy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.dao.board.jjy.BoardDao;
import com.exam.dao.board.jjy.BoardDaoImpl;
import com.exam.vo.board.jjy.BoardVO;

import util.comm.ViewResolver;

public class BoardUpdateAction implements Action {

	private BoardDao boardDao;
	
	public BoardUpdateAction() {
		if(boardDao == null) {
			boardDao = BoardDaoImpl.getInstance();
		}
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("BoardUpdate 실행");
		
		HttpSession session = request.getSession();
		String requestMethod = request.getMethod();
		String url = "";
		
		if(session.getAttribute("loginUser") == null) {
			url = "redirect:/";
		} else {
			
			BoardVO boardVO = null;
			int board_no = Integer.parseInt(request.getParameter("board_no"));
			
			if(requestMethod.equals("GET")) {
				url = "/board/jjy/boardWrite";
				
				try {
					boardVO = boardDao.selectJjyBoardDetail(board_no);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				request.setAttribute("boardVO", boardVO);
				request.setAttribute("method", "update");
			}
			else if(requestMethod.equals("POST")) {
				url = "redirect:/jjy/board?command=detail&board_no=" + board_no;

				boardVO = new BoardVO();
				boardVO.setBoard_no(board_no);
				boardVO.setTitle(request.getParameter("title"));
				boardVO.setContent(request.getParameter("content"));
				
				try {
					
					boardDao.updateJjyBoard(boardVO);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			else {
				url = "redirect:/";
			}
			
		}
		
		ViewResolver.view(request, response, url);
		
	}
	
}
