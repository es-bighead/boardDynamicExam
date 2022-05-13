<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Book Write</title>
</head>

<script type="text/javascript">

	function onClickSubmit(method, board_no) {
		
		var boardForm = document.getElementById("boardForm");
		
		if(method=='write') {
			boardForm.action = "/jjy/board?command=write";
		}
		else if (method=='update') {
			console.log(board_no);
			boardForm.action = "/jjy/board?command=update&board_no=" + board_no;
		}
		
		boardForm.submit();
	}

</script>

<body>
<div>
	<div>
		<form name="boardForm" id="boardForm" method="post">
			
			<table border="1" width="100%">
				<colgroup>
					<col width="25%">
					<col width="25%">
					<col width="25%">
					<col width="25%">
				</colgroup>
				<thead>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" <c:if test="${boardVO.title != null}">value = ${boardVO.title}</c:if> /></td>
					<th>작성자</th>
					<td>${loginUser.name}</td>
				</tr>
				</thead>
				<tbody>
				<tr>
					<th>내용</th>
					<td colspan="3"><textarea rows="10" cols="100%" name="content"><c:if test="${boardVO.content != null}">${boardVO.content}</c:if></textarea>
				</tr>
				<tr>
					<th>파일업로드</th>
					<td colspan="3">
					</td>
				</tr>
				</tbody>
			</table>
			
			<div>
				<a href="javascript:history.go(-1);">취소</a>
				<input type="button" id="btnSubmit" onClick="javascript:onClickSubmit('${method}', ${boardVO.board_no });" value="등록" />
			</div>
		</form>
	</div>
</div>
</body>
</html>