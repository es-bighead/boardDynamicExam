<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<jsp:include page="/WEB-INF/views/include/include_header.jsp"></jsp:include>
	<title>게시판</title>
</head>

	<div class="docSlider">
		<section class="section1">
	        <div class="inner">
				<table class="tb1">
					<thead>
						<tr>
							<th class="th1">게시글번호</th>
							<th class="th2">작성자</th>
							<th class="th3">제목</th>
							<th class="th4">등록일</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="items" items="${boardList }">
					<tr>
						<td>${items.board_no }</td>
						<td>${items.name }</td>
						<td><a href="/boardDetail.do?board_no=${items.board_no }">${items.title }</a></td>
						<td>${items.reg_dt }</td>
					</tr>
					</c:forEach>
					</tbody>
				</table>
				<button class="btn-open-popup"></button> 
			</div>
			
			<div class="modal">
		      <div class="modal_body">
		      	<h1>게시글</h1>
		      	<form id="boardForm" name="boardForm" method="post" action="/boardRegist.do">
		      		<fieldset>
		      		<legend>내용입력</legend>
		      			<input type="hidden" name="mem_no" value="${loginUser.mem_no }">
			      		<input id="title" name="title" type="text" placeholder="게시글 제목 입력" />
			      		<input id="content" name="content" type="text" placeholder="게시글 내용 입력" />
			      		<input class="sub_input" type="submit" value="" />
		      		</fieldset>
		      	</form>
		      </div>
		    </div>
		</section>
	</div>
	
<script>

	const body = document.querySelector('body');
	const modal = document.querySelector('.modal');
	const btnOpenPopup = document.querySelector('.btn-open-popup');
	
	btnOpenPopup.addEventListener('click', function(event){
		modal.classList.toggle('show');
		
		  if (modal.classList.contains('show')) {
		    body.style.overflow = 'hidden';
		  }
	});
	
	modal.addEventListener('click', function(event){
		if (event.target === modal) {
		    modal.classList.toggle('show');
		
		    if (!modal.classList.contains('show')) {
		      body.style.overflow = 'auto';
		    }
		  }		
	});

</script>	
	
<jsp:include page="/WEB-INF/views/include/include_footer.jsp"></jsp:include>