<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="base.jsp"></jsp:include>
	<div style="margin-left: 5%;">
	<h2>성적 조회 </h2>
	<br>
	
	<br><br>
	<span style="display: inline-block; width: 1100px; font-weight: bold;">
		<span style="display: inline-block; width: 130px;">수강 학기</span>
		<span style="display: inline-block; width: 130px;">강의 이름</span>
		<span style="display: inline-block; width: 130px;">소속 전공</span>
		<span style="display: inline-block; width: 100px;">중간고사</span>
		<span style="display: inline-block; width: 100px;">기말고사</span>
		<span style="display: inline-block; width: 100px;">과제</span>
		<span style="display: inline-block; width: 100px;">출석</span>
		<span style="display: inline-block; width: 100px;">총점수</span>
		<span style="display: inline-block; width: 100px;">학점</span>
	</span><br><br>

	<c:forEach var="scoredVO" items="${scoredList}">
		<span style="display: inline-block; width: 1100px;">
		<!--{status.count % 9 == 0 }-->
			<span style="display: inline-block; width: 130px;"> ${scoredVO.getLec_sem() }</span>
			<span style="display: inline-block; width: 130px;"> ${scoredVO.getLec_name() }</span>
			<span style="display: inline-block; width: 130px;"> ${scoredVO.getLec_maj() }</span>
			<span style="display: inline-block; width: 100px;"> ${scoredVO.getMid_exam() }</span>
			<span style="display: inline-block; width: 100px;"> ${scoredVO.getFinal_exam() }</span>
			<span style="display: inline-block; width: 100px;"> ${scoredVO.getAssignment() }</span>
			<span style="display: inline-block; width: 100px;"> ${scoredVO.getAttendence() }</span>
			<span style="display: inline-block; width: 100px;"> ${scoredVO.getRes_score() }</span>
			<span style="display: inline-block; width: 100px;"> ${scoredVO.getRes_grade() }</span>
			
		</span>
		<br><br>
	</c:forEach>	
	
	</div>
	
	<br>
</body>
</html>