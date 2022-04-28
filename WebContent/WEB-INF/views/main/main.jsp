<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/common.css">
    <script src="<%=request.getContextPath()%>/resources/js/docSlider.min.js"></script>
    <title>메인</title>
</head>

<jsp:include page="/WEB-INF/views/include/include_header.jsp"></jsp:include>

<div class="docSlider">
    <section class="section1">
        <div class="inner">
            <h2>유클리드소프트 테스트<br/>반갑습니다.</h2>
        </div>
    </section>
    <section class="section2">
    </section>
    <section class="section3">
    </section>
</div>

<script>docSlider.init();</script>

<jsp:include page="/WEB-INF/views/include/include_footer.jsp"></jsp:include>