<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Head Start! -->
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/common.css">
    <script src="<%=request.getContextPath()%>/resources/js/docSlider.min.js"></script>

<!-- Body Start! -->
<body>
<header class="Header">
   <h1 class="Header-logo">
        <a href="/"><img src="<%=request.getContextPath()%>/resources/images/logo.png" width="120" alt="유클리드소프트"></a>
    </h1>
    <div class="Header-content">
        <ul>
        	<c:if test="${empty loginUser}">
        		<li class="Header-dl"><a href="<%=request.getContextPath()%>/login.do"><img src="<%=request.getContextPath() %>/resources/images/logo.png" alt="login" width="24">로그인</a></li>
        		<li class="Header-gh"><a href="<%=request.getContextPath()%>/acount.do"><img src="<%=request.getContextPath() %>/resources/images/logo.png" alt="regist" width="30">회원가입</a></li>
        	</c:if>
        	<c:if test="${not empty loginUser}">
        		<li class="Header-dl"><a href="<%=request.getContextPath()%>/logout.do" class="dlink"><img src="<%=request.getContextPath() %>/resources/images/logo.png" alt="logout" width="24">로그아웃</a></li>
        		<li class="Header-profile"><a href="<%=request.getContextPath()%>/boardList.do"><img src="<%=request.getContextPath() %>/resources/images/logo.png" width="30" alt="board">게시판</a></li>
        		        		<li class="Header-profile"><a href="<%=request.getContextPath()%>/jjy/board?command=list&pageIndex=1"><img src="<%=request.getContextPath() %>/resources/images/logo.png" width="30" alt="board">JJY 게시판</a></li>
        		
            </c:if>
        </ul>
    </div>
</header>