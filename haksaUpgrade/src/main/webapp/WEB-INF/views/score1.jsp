<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="base.jsp"></jsp:include>
<div style="margin-left: 5%;">

<c:forEach var="i" items="${lecList}">
	<div style="display: inline-block; width: 400px;"> 
	<form action="infoForScoreInsert" method="get">
		<input type="hidden" value="${i.getLec_id() }" name="lec_id"/>
		<input type="hidden" value="${i.getLec_name() }" name="lec_name"/>
		<span style="display: inline-block; width: 50%"> ${i.getLec_name() }</span>
		<span style="display: inline-block; "><input type="submit" value="성적 입력하기"/></span> 
		
	</form>
	</div>
	<br><br>
	
</c:forEach>
</div>
</body>
</html>