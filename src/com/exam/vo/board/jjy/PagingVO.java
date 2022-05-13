package com.exam.vo.board.jjy;

import java.util.List;

public class PagingVO {

	// 현재 페이지
	private int pageIndex;
	// 시작 게시글 번호
	private int startRow;
	// 끝 게시글 번호
	private int endRow;
	// 게시판 사이즈
	private int pageSize;
	// 불러온 게시글
	private List<?> resultList;
	// 총 게시글 수
	private int totalCount;
	// 총 index 수
	private int totalIndex;
	
	
	// startRow, endRow 계산
	public void handlePaging(int pageIndex, int pageSize) {
		this.pageIndex = pageIndex < 1 ? 1 : pageIndex;
		this.pageSize = pageSize;
		this.startRow = ((this.pageIndex-1) * this.pageSize) + 1;
		this.endRow = startRow + this.pageSize - 1;
	}
	
	// 페이징 처리된 결과값 담기
	public void handlePagingList(List<?> resultList, int totalCount) {
		this.resultList = resultList;
		this.totalCount = totalCount;
		this.totalIndex = (int)Math.ceil((double)totalCount / (double)pageSize);
	}
	
	// setter, getter
	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<?> getResultList() {
		return resultList;
	}

	public void setResultList(List<?> resultList) {
		this.resultList = resultList;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalIndex() {
		return totalIndex;
	}

	public void setTotalIndex(int totalIndex) {
		this.totalIndex = totalIndex;
	}
	

}
