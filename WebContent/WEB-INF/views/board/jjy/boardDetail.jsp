<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board Detail</title>
</head>
<body>
<div class="mainContainer">
	<div>
		<table width="100%" border="1">
			<colgroup>
				<col width="25%">
				<col width="25%">
				<col width="25%">
				<col width="25%">
			</colgroup>
		
			<thead>
				<tr>
					<th>제목</th>
					<td>${boardVO.title}</td>
					<th>작성자</th>
					<td>${boardVO.author}</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>내용</th>
					<td colspan="3"><pre>${boardVO.content}</pre></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div>
		<a href="/jjy/board?command=delete&board_no=${boardVO.board_no}">삭제</a>
		<a href="/jjy/board?command=update&board_no=${boardVO.board_no}">수정</a>
		<a href="javascript:history.go(-1);">목록</a>
	</div>
</div>
</body>
</html>