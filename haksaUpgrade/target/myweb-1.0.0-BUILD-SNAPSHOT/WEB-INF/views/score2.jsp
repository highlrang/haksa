<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
</head>
<body>
<jsp:include page="base.jsp"></jsp:include>
	
<div style="margin-left: 5%;">
	<h4> ${lec_name} - 성적 입력</h4><br>
	
	<c:forEach var="score" items="${score_list}">
	<form method="get">
		<input type="hidden" value="${paging.nowPage}" name="nowPage"/>
		<input type="hidden" value="${lec_id}" name="lec_id"/>
		<input type="hidden" value="${lec_name}" name="lec_name"/>
		<input type="hidden" value="${score.getUser_id()}" name="user_id"/>
		<input type="hidden" value="${score.getUser_name()}" name="user_name"/>
		<span> ${score.getUser_name()}</span>&ensp;&ensp;&ensp;
		<span> ${score.getUser_id() }</span>&ensp;&ensp;&ensp;
		<span> ${score.getUser_major() }</span>&ensp;&ensp;&ensp;
	
		<c:choose>
			<c:when test="${empty complete_list.get(k) }">
				<span style="margin: 5%;"><input type="submit" formaction="score/readyScoreInsert" value="성적입력"/></span><br>
			</c:when>
					
			<c:otherwise>
				<c:if test="${complete_list.contains(score.getUser_id()) }">
					<span style="margin: 5%"><input type="submit" formaction="score/readyScoreUpdate" value="성적 수정"/></span><br>				
				</c:if>
				<c:if test="${none_list.contains(score.getUser_id()) }">
					<span style="margin: 5%;"><input type="submit" formaction="score/readyScoreInsert" value="성적 입력"/></span><br>
				</c:if>
			</c:otherwise>
					
		</c:choose>
	</form><br>
	</c:forEach>
	
	<br>
	<div style="display: block; text-align: center;">	
		<c:if test="${paging.startPage != 1 }">
			<a href="/infoForScoreInsert?lec_id=${lec_id }&lec_name=${lec_name }&nowPage=${paging.startPage - 1}">&lt;</a>
		</c:if>
		<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
			<c:choose>
				<c:when test="${p == paging.nowPage }">
					<b>${p }</b>
				</c:when>
				<c:when test="${p != paging.nowPage }">
					<a href="/infoForScoreInsert?lec_id=${lec_id }&lec_name=${lec_name }&nowPage=${p }">${p }</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.endPage != paging.lastPage}">
			<a href="/infoForScoreInsert?lec_id=${lec_id }&lec_name=${lec_name }&nowPage=${paging.endPage+1 }">&gt;</a>
		</c:if>
	</div>
</div>
</body>
</html>