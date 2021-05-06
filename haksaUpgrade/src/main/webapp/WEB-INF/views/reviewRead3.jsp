<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
<style>
	#star a {
		text-decoration: none;
		color: black;
	}
</style>
</head>
<body>
	<jsp:include page="base.jsp"></jsp:include>
	
	<div style="margin-left: 3%; text-align: center;">
	
		<div style="border-top: 1px solid black; border-bottom: 1px solid black; padding: 1%;">
			<span style="font-weight: bold;">${lec_name }</span> 강의 평가
		</div>
		<br><br>
	
		<c:forEach var="review" items="${reviewList}">
		<div>
			<div id="star">
				<c:forEach begin="0" end="${review.getRev_stars() }">
					<span>★</span>	
				</c:forEach>
			</div>
			<br>
						
			<div><textarea  cols="60" rows="20" wrap="hard" style="border-radius: 10px; padding: 1%;" disabled> ${review.getRev_content()}</textarea> </div>
			<br>	
		</div>
		<div style="border-bottom: 1px solid black;"></div>			
		</c:forEach>
	</div>
</body>
</html>