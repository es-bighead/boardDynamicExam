<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<!-- section1 -->
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/common.css">
    <script src="<%=request.getContextPath()%>/resources/js/docSlider.min.js"></script>
    <title>게시글 상세정보</title>
</head>

<jsp:include page="/WEB-INF/views/include/include_header.jsp"></jsp:include>

<script type="text/javascript">
	function fn_submit(val){
		var form = document.getElementById("boardForm");
		
		if(val == 1){
			form.action = "boardModify.do";
		}else{
			form.action = "boardDelete.do";
		}
		
		form.submit();
	}
</script>

	<div class="docSlider">
		<section class="section1">
	        <div class="inner">
	        	<div class="modal show">
		      		<div class="modal_body">
		      			<h1>게시글</h1>
			        	<form id="boardForm" name="boardForm" method="post">
				      		<fieldset>
				      		<legend>내용</legend>
				      			<input type="hidden" name="mem_no" value="${loginUser.mem_no }">
				      			<input type="hidden" name="board_no" value="${board.board_no }">
					      		<input id="title" name="title" type="text" placeholder="게시글 제목 입력" value="${board.title }" <c:if test="${loginUser.mem_no ne board.mem_no }">disabled</c:if>/>
					      		<input id="content" name="content" type="text" placeholder="게시글 내용 입력" value="${board.content }" <c:if test="${loginUser.mem_no ne board.mem_no }">disabled</c:if>/>
					      		<c:if test="${loginUser.mem_no eq board.mem_no }">
					      			<div>
						      			<input class="sub_input" onclick="fn_submit(1);" value="" />
						      			<input class="del_input" onclick="fn_submit(2);" value="" />
					      			</div>
					      		</c:if>
				      		</fieldset>
				      		<a href="boardList.do"><img src="<%=request.getContextPath() %>/resources/images/btn_a_list.gif" /></a>
				      	</form>
		      		</div>
		      	</div>
	        </div>
	    </section>
	</div>

<jsp:include page="/WEB-INF/views/include/include_footer.jsp"></jsp:include>