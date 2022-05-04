package com.exam.controller.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			SearchCriteria cri = new SearchCriteria();
			try{
				int page = Integer.parseInt(request.getParameter("page"));
				int perPageNum = Integer.parseInt(request.getParameter("perPageNum"));
				cri.setPage(page);
				cri.setPerPageNum(perPageNum);	
			}catch(NumberFormatException e){
				System.out.println("페이징 초기화");
			}
			
			try {
				List<BoardVO> boardList = boardService.selectBoardList(cri);
				
				PageMaker pageMaker = new PageMaker();
				pageMaker.setCri(cri);
				pageMaker.setTotalCount(boardList.get(0).getTotpage());

				Map<String, Object> dataMap = new HashMap<String, Object>();
				dataMap.put("boardList", boardList);
				dataMap.put("pageMaker", pageMaker);
				
				request.setAttribute("dataMap", dataMap);
				
				System.out.println(pageMaker);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			String chk = request.getParameter("chk");
			
			if(chk != null){
				request.setAttribute("msg", "요청사항이 완료되었습니다.");
			}
			
		}
		
		ViewResolver.view(request, response, url);
		
	}

}
