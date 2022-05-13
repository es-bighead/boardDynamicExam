package com.exam.controller.board.jjy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.dao.board.jjy.BoardDao;
import com.exam.dao.board.jjy.BoardDaoImpl;
import com.exam.vo.board.jjy.BoardVO;
import com.exam.vo.comm.MemberVO;

import util.comm.ViewResolver;

public class BoardWriteAction implements Action {

	private BoardDao boardDao;
	
	public BoardWriteAction() {
		if(boardDao == null) {
			boardDao = BoardDaoImpl.getInstance();
		}
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("BoardWrite 실행");
		
		String requestMethod = request.getMethod();
		HttpSession session = request.getSession();
		String url = "";
		
		if(session.getAttribute("loginUser") == null) {
			url = "redirect:/";
		} else {

			MemberVO memberVO = (MemberVO)session.getAttribute("loginUser");
			request.setAttribute("loginUser", memberVO);

			if(requestMethod.equals("GET")) {
				url = "board/jjy/boardWrite";
				request.setAttribute("method", "write");
			}
			
			if(requestMethod.equals("POST")) {
				url = "redirect:/jjy/board?command=list&pageIndex=1";

				BoardVO boardVO = new BoardVO();
				boardVO.setTitle(request.getParameter("title"));
				boardVO.setContent(request.getParameter("content"));
				boardVO.setMem_no(memberVO.getMem_no());
				
				try{
					boardDao.insertJjyBoard(boardVO);
					System.out.println("게시글 작성 성공 : " + memberVO.getName() + " (" + memberVO.getMem_no() + ")");
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	
		ViewResolver.view(request, response, url);
		
	}
	
	

}
