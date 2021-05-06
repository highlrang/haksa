<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>        
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
    $(function(){
        var msg = "<c:out value="${msg}" />"
        if(msg != ""){
            alert(msg);
        }
    }) 
</script>
<style>
	input[type=text]{
		width: 30%;
		padding: 1%;
	}
</style>
</head>
<body>
<jsp:include page="base.jsp"></jsp:include>
<div style="margin-left: 5%;">
	<h2>강의 : ${lec_name}</h2>	
	<h4>학생이름 : ${user_name}</h4>
	<br><br><br>
	
	<form:form modelAttribute="scoreInsertVO" action="score/scoreInsert" method="post">
		
		<div style="width: 500px;">
		<div><div style="width:150px; display:inline-block;">중간고사 성적 : </div><form:input path="mid_exam" required="required"/></div><br><br>
		<div><div style="width:150px; display:inline-block;">기말고사 성적 : </div><form:input path="final_exam" required="required"/></div><br><br>
		<div><div style="width:150px; display:inline-block;">과제 점수 : </div><form:input path="assignment" required="required"/></div><br><br>
		<div><div style="width:150px; display:inline-block;">출석 점수 : </div><form:input path="attendence" required="required"/></div><br><br>
		</div>
		<form:hidden path="lec_id" value="${lec_id }"/>
		<form:hidden path="user_id" value="${user_id }"/>
		<input type="hidden" name="lec_name" value="${lec_name }"/>
		<input type="hidden" name="nowPage" value="${nowPage }"/>
		<input type="submit" value="확인"/>
	</form:form>
</div>	
</body>
</html>