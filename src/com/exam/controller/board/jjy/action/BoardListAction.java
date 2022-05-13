package com.exam.controller.board.jjy.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.dao.board.jjy.BoardDao;
import com.exam.dao.board.jjy.BoardDaoImpl;
import com.exam.vo.board.jjy.BoardVO;
import com.exam.vo.board.jjy.PagingVO;
import com.exam.vo.board.jjy.SearchVO;

import util.comm.ViewResolver;

public class BoardListAction implements Action {

	private BoardDao boardDao;
	
	public BoardListAction() {
		if(boardDao == null) {
			boardDao = BoardDaoImpl.getInstance();
		}
	}
	
	public Boolean isEmptyParameter(HttpServletRequest request, String param) {
		return request.getParameter(param)!=null && !request.getParameter(param).isEmpty() ? true : false;
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("BoardList 실행");
		
		HttpSession session = request.getSession();
		String url = "board/jjy/boardList";
		
		if(session.getAttribute("loginUser") == null) {
			url = "redirect:/";
		} else {
			
			SearchVO searchVO = new SearchVO();
			PagingVO pagingVO = new PagingVO();
			
			if(isEmptyParameter(request, "pageIndex")) {
				pagingVO.handlePaging(Integer.parseInt(request.getParameter("pageIndex")), 10);
			}
			
			if(request.getMethod().equals("POST")) {
				if(isEmptyParameter(request, "searchTitle")) {
					searchVO.setSearchTitle(request.getParameter("searchTitle"));
				}
				if(isEmptyParameter(request, "searchAuthor")) {
					searchVO.setSearchAuthor(request.getParameter("searchAuthor"));
				}
			}
			
			searchVO.setPagingVO(pagingVO);
			
			try {
				boardDao.selectJjyBoardList(searchVO);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			request.setAttribute("searchVO", searchVO);
			
		}
		
		ViewResolver.view(request, response, url);
	}
	
}
