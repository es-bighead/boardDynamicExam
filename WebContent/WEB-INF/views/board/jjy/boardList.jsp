<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>
<link href="/resources/css/jjy/common.css" rel="stylesheet" type="text/css">
</head>

<script type="text/javascript">

	function selectPage(pageIndex) {
		
		var searchForm = document.getElementById("searchForm");
		searchForm.action="/jjy/board?command=list&pageIndex=" + pageIndex;
		searchForm.submit();
		
	}
	
</script>

<body>

<div class="mainContainer">
	<div class="tableContainer">
		<div class="searchForm">
			<form id="searchForm" method="post">
				<div style="display: flex;">
					<div style="display: contents;">
					<table>
						<tr>
							<th>제목</th>
							<td>
							<input type="text" id="searchTitle" name="searchTitle" value="<c:out value="${searchVO.searchTitle}"/>" />
							</td>
							<th>작성자</th>
							<td><input type="text" id="searchAuthor" name="searchAuthor" value="<c:out value="${searchVO.searchAuthor}"/>" /></td>
						</tr>
					</table>
					</div>
					<div style="display: contents;">
						<input type="submit" value="검색" />
					</div>
				</div>
			</form>
		</div>
	
		<div class="boardTbl">
			<div>
				총 게시글 : ${searchVO.pagingVO.totalCount}
			</div>
			<div>
			<table>
				<thead>
					<tr>
						<th>No</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="board" items="${searchVO.pagingVO.resultList}" varStatus="status">
						<tr>
							<td>${board.row_num}</td>
							<td><a href="/jjy/board?command=detail&board_no=${board.board_no}">${board.title}</a></td>
							<td>${board.author}</td>
							<td>${board.create_date}</td>
						</tr>
					</c:forEach>
				</tbody>
				<tbody>
				</tbody>
			</table>
			</div>
		</div>
		
		<!-- 페이지 인덱스 처리 -->
		<div style="display: flex;">
			<div class="paging" >
				<a href="javascript:selectPage(1)">〈〈</a>
				<c:choose>
					<c:when test="${searchVO.pagingVO.pageIndex < 3 }">
						<c:forEach var="index" begin="1" end="5" >
							<c:if test="${index <= searchVO.pagingVO.totalIndex }">
								<a href="javascript:selectPage(${index});">${index}</a>
							</c:if>
						</c:forEach>
					</c:when>
					<c:when test="${searchVO.pagingVO.pageIndex > searchVO.pagingVO.totalIndex - 2}">
						<c:forEach var="index" begin="${searchVO.pagingVO.totalIndex - 4 }" end="${searchVO.pagingVO.totalIndex}" >
							<a href="javascript:selectPage(${index});">${index}</a>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach var="index" begin="${searchVO.pagingVO.pageIndex-2}" end="${searchVO.pagingVO.pageIndex+2}" >
								<a href="javascript:selectPage(${index});">${index}</a>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				<a href="javascript:selectPage(${searchVO.pagingVO.totalIndex})">〉〉</a>
			</div>
			
			<div>
				<a href="/jjy/board?command=write">글쓰기</a>
			</div>
		</div>
	</div>
</div>
</body>
</html>