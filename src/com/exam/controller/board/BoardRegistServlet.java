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
 * Servlet implementation class BoardRegist
 */
@WebServlet("/boardRegist.do")
public class BoardRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService;
	
	public BoardRegistServlet() {
		if(boardService == null){
			boardService = BoardServiceImpl.getInstance();
		}
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "board/boardList";
		
		BoardVO board = new BoardVO();
		board.setMem_no(request.getParameter("mem_no"));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		
		List<BoardVO> boardList = null;
		
		try {
			boardService.insertBoard(board);
			
			boardList = boardService.selectBoardList();
			
			request.setAttribute("boardList", boardList);
			
			request.setAttribute("msg", "게시글 등록이 완료되었습니다.");
		} catch (SQLException e) {
			request.setAttribute("msg", "게시글 등록 중 오류가 발생하였습니다.");
			e.printStackTrace();
		}
		
		ViewResolver.view(request, response, url);
	}

}
