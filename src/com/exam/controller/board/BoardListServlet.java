package com.exam.controller.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/boardList.do")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoardService boardService;
	
	public BoardListServlet() {
		if(boardService == null){
			boardService = BoardServiceImpl.getInstance();
		}
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "board/boardList";
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") == null){
			url = "redirect:login.do";
		}else{
			List<BoardVO> boardList = null;
			
			try {
				boardList = boardService.selectBoardList();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			request.setAttribute("boardList", boardList);			
		}
		
		ViewResolver.view(request, response, url);
		
	}

}
