<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
    $(function(){
        var msg = "<c:out value="${msg}" />"
        if(msg != ""){
            alert(msg);
        }
    }) 
</script>
</head>
<body>
<jsp:include page="base.jsp"></jsp:include>
	
	<div style="margin-left: 5%;">
	<div style="font-weight: bold;">${lec_sem} - ${maj_name} 강의</div>
	<br><br>
	
	<c:forEach var="lecture" items="${lectureList}">
	    <form method="post">
		    <span style="margin: 3%;"> 
		    	<span style="font-weight: bold;">${lecture.getLec_name()}</span>
		    	<span>${lecture.getLec_time() }</span>
		    	<span>${lecture.getLec_prof() }</span>
		    	<input type="hidden" value="${lecture.getLec_name()}" name="lec_name"/>
		    	<input type="hidden" value="${lecture.getLec_id()}" name="lec_id"/>
		    	<input type="hidden" value="${maj_name}" name="maj_name"/>
		    </span>
		    
		    <c:choose>
			    <c:when test="${already.containsKey(lecture.getLec_name()) }">
			    	<c:choose>
				    	<c:when test="${already.get(lecture.getLec_name()) > 0 }">
				    		<span><input type="submit" value="수강 신청 취소" formaction="registerDelete"/></span>
				    	</c:when>
				    	<c:otherwise>
				    		<span><input type="submit" value="수강 대기 취소" formaction="registerDelete" /></span>
				    	</c:otherwise>
				    </c:choose>	
		    	</c:when>
		    	<c:otherwise>
		    		<input type="submit" value="수강신청" formaction="insert"/>
				</c:otherwise>
			</c:choose>	

	    </form>
	    <br>
	</c:forEach>
	</div>
</body>
</html>