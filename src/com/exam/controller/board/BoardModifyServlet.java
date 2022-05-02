package com.exam.controller.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.service.board.BoardService;
import com.exam.service.board.BoardServiceImpl;
import com.exam.vo.board.BoardVO;

import util.comm.ViewResolver;

/**
 * Servlet implementation class BoardModifyServlet
 */
@WebServlet("/boardModify.do")
public class BoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService;
	
	public BoardModifyServlet(){
		boardService = BoardServiceImpl.getInstance();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "redirect:/boardList.do?chk=y";
		
		BoardVO board = new BoardVO();
		
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		board.setBoard_no(request.getParameter("board_no"));
		
		try {
			boardService.updateModifyBoard(board);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ViewResolver.view(request, response, url);
	}

}
