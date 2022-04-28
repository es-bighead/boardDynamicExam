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
    <title>테스트</title>
</head>

<jsp:include page="/WEB-INF/views/include/include_header.jsp"></jsp:include>

<div class="docSlider">
	<section class="section1">
        <div class="inner">
            <form class="loginBox" action="<%=request.getContextPath()%>/login.do" method="post" name="loginForm">
                <h1>LOGIN</h1>
                <fieldset>
                    <legend id="log" class="hidden">LOGIN</legend>
                    <label>ID</label>
                    <input type="text" name="id" value="" placeholder="ID">
                    <label>PASSWORD</label>
                    <input type="password" name="password" value="" placeholder="PASSWORD">
                    <button type="submit">로그인</button>
                </fieldset>
            </form>
        </div>
    </section>
</div>

<jsp:include page="/WEB-INF/views/include/include_footer.jsp"></jsp:include>
