package com.exam.controller.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.service.board.BoardService;
import com.exam.service.board.BoardServiceImpl;
import com.exam.vo.board.BoardVO;

import util.comm.ViewResolver;

/**
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet("/boardDetail.do")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BoardService boardService;
	
	public BoardDetailServlet() {
		if(boardService == null){
			boardService = BoardServiceImpl.getInstance();
		}
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String url = "board/boardDetail";
	   
	   BoardVO board = null;
	   
	   HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") == null){
			url = "redirect:login.do";
		}else{
			try {
				board = boardService.selectBoardByBoardNo(request.getParameter("board_no"));
				request.setAttribute("board", board);
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	   
	   ViewResolver.view(request, response, url);
	}

}
