<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<jsp:include page="/WEB-INF/views/include/include_header.jsp"></jsp:include>
    <title>로그인</title>
</head>

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
                    <button class="lg_btn" type="submit"></button>
                </fieldset>
            </form>
        </div>
    </section>
</div>

<jsp:include page="/WEB-INF/views/include/include_footer.jsp"></jsp:include>
