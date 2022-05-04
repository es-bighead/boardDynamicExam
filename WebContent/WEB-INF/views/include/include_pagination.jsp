<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav>
	<ul class="pagination">
		<li><a href="javascript:go_pagination(${pageMaker.startPage });">&lt;&lt;</a></li>
		<li><a href="javascript:go_pagination(${pageMaker.prev ? pageMaker.cri.page-1 : 1 });">&lt;</a></li>
		<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="page">
			<li><a href="javascript:go_pagination(${page });">${page }</a></li>
		</c:forEach>
		<li><a href="javascript:go_pagination(${pageMaker.next ? pageMaker.cri.page + 1 : pageMaker.endPage});">&gt;</a></li>
		<li><a href="javascript:go_pagination(${pageMaker.realEndPage});">&gt;&gt;</a></li>
	</ul>
</nav>

<form name="paginationForm" method="post">
	<input type="hidden" name="page" value=1 />
	<input type="hidden" name="perPageNum" value=10 />
</form>


<script type="text/javascript">
	function go_pagination(page, url){
		var form = document.paginationForm;
		form.page.value = page;
		
		form.method = "post";

		if(url){
			form.setAttribute("action",url);
		}else{
			form.setAttribute("action","/boardList.do");		
		}
		
		form.submit();
	}
</script>