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
 * Servlet implementation class BoardDeleteServlet
 */
@WebServlet("/boardDelete.do")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoardService boardService;
	
	public BoardDeleteServlet(){
		boardService = BoardServiceImpl.getInstance();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "board/boardList";
		
		String board_no = request.getParameter("board_no");

		List<BoardVO> boardList = null;
		
		try {
			boardService.deleteBoard(board_no);
			
			boardList = boardService.selectBoardList();
			
			request.setAttribute("boardList", boardList);
			
			request.setAttribute("msg", "게시글 삭제가 완료되었습니다.");
		} catch (SQLException e) {
			request.setAttribute("msg", "게시글 삭제가 실패하였습니다!!!");
			e.printStackTrace();
		}
		
		ViewResolver.view(request, response, url);
	}

}
