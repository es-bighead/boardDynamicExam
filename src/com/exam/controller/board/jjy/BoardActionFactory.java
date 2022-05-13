package com.exam.controller.board.jjy;

import javax.servlet.http.HttpServletRequest;

import com.exam.controller.board.jjy.action.Action;
import com.exam.controller.board.jjy.action.BoardDeleteAction;
import com.exam.controller.board.jjy.action.BoardDetailAction;
import com.exam.controller.board.jjy.action.BoardListAction;
import com.exam.controller.board.jjy.action.BoardUpdateAction;
import com.exam.controller.board.jjy.action.BoardWriteAction;

public class BoardActionFactory {

	private static BoardActionFactory instance = new BoardActionFactory();
	
	private BoardActionFactory() {
		super();
	}
	
	public static BoardActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("BoardActionFactory : " + command);
		
		if(command.equals("list")) {
			action = new BoardListAction();
		} else if(command.equals("write")) {
			action = new BoardWriteAction();
		} else if(command.equals("update")) {
			action = new BoardUpdateAction();
		} else if(command.equals("delete")) {
			action = new BoardDeleteAction();
		} else if(command.equals("detail")) {
			action = new BoardDetailAction();
		}
		
		return action;
		
	}
	
	
	
}
