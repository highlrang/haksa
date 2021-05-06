<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/base.css">
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>

<body>
<table>
	<tr>
		<jsp:include page="base.jsp"></jsp:include>
	</tr>
	
	<tr>
		<td width="100%" style="position: relative;">
			<jsp:include page="slide.jsp"></jsp:include>	
		</td>
		
		<td height="1000px" style="float: right; margin-right: 5%;">
			<c:choose>
			<c:when test="${empty user }">
			<!--  sec:authorize access="isAnonymous() isAuthenticated() hasRole('STUDENT')" -->
			<form action="/" method="post" style="height: 100%">
				<div style="border: 1px solid black; border-radius: 10px; padding: 5%; width: 300px; height: 100%;">
					<div>
						<div>
							<input type="text" name="username" placeholder="학번"/>
						</div><br>
						<div>
							<input type="password" name="password" placeholder="비밀번호"/>
						</div><br>
						<div style="float: right; margin-right: 5%;"> 
							<input type="submit" value="로그인" style="padding: 20%"/> 
						</div>
						
						<c:if test="${error }">
						<br><br><br><br>
						<div style="clear: both; text-align:center; font-weight: bold; color: red;">
							<spring:message code="userNotMatched"/>
						</div>
						</c:if>
					</div>
				</div>
			</form>
			</c:when>
			
			<c:otherwise>
			<form action="logout" method="post" style="height: 100%">
				<div style="border: 1px solid Khaki; border-radius: 10px; padding: 5%; width: 300px; height: 100%; text-align:center;">

				<div style="border-bottom: 1px solid black; padding: 1%;"> 
					학번 : <sec:authentication property="principal.username"/>
				</div>
				<br>
				<div id="user_info" style="display:block; background-color: beige; padding: 3%; text-align: left;">
					<div>이름 : <sec:authentication property="principal.user_name" /></div>
					<div>전공 : <sec:authentication property="principal.user_major" /></div>

					<c:if test=${not empty principal.user_minor }>
					<div>복수전공 : <sec:authentication property="principal.user_minor" /></div>
					</c:if>

					<div>전화번호 : <sec:authentication property="principal.user_phone" /></div>
					<div>이메일 : <sec:authentication property="principal.user_email" /></div>
				</div>
				<br>
				<div style="float: right;"> <input type="submit" value="로그아웃"/> </div>
				<br><br>
				
				<c:choose>
				<c:when test="${userRole eq 'STUDENT'}">
				
				<div>
					<input type="button" value="수강신청" onclick="location.href='register/majorForRegister'"/>&nbsp;&nbsp;
					<input type="button" value="수강조회" onclick="location.href='register/registered'"/>
				</div><br>
				
				<div>	
					<input type="button" value="성적조회" onclick="location.href='scored'"/>&nbsp;&nbsp;
					<input type="button" value="강의평가보기" onclick="location.href='review/readMyReview'"/>
				</div>
				
				</c:when>
				<c:when test="${userRole eq 'PROFESSOR' }">
				
				<div>
					<input type="button" value="성적등록" onclick="location.href='score/readyForScoreInsert'"/>	
				</div>
				
				</c:when>
				</c:choose>
				</div>
			</form>
			
			</c:otherwise>
			</c:choose>
			<br><br>

		</td>
	</tr>
</table>


<br>

<script type="text/javascript">
	function selectStu(){
		var stu = document.getElementById("showStu");
		var prof = document.getElementById("showProf");
		if(stu.style.display == "none"){
			prof.style.display = "none";
			stu.style.display = "block";
		}
	}
	
	function selectProf(){
		var stu = document.getElementById("showStu");
		var prof = document.getElementById("showProf");
		if(prof.style.display == "none"){
			stu.style.display = "none";
			prof.style.display = "block";
		}
	}
	
</script>

</body>
</html>
