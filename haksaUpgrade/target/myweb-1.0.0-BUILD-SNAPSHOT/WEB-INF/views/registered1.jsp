<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>
<jsp:include page="base.jsp"></jsp:include>
	
	<div style="margin-left: 3%">
	
		<h3>수강신청 내역</h3><br>
		
		
			<c:forEach var="registeredVO" items="${registeredList}">
				<span style="display: inline-block; width: 800px;">
					<span style="display: inline-block; width: 150px; font-weight: bold;">${registeredVO.getLec_name()}</span>
					<span style="display: inline-block; width: 150px;">${registeredVO.getLec_maj()}</span>
					<span style="display: inline-block; width: 150px;">${registeredVO.getLec_sem()}</span>
				
					<c:choose>
					<c:when test="${starList.get(registeredVO.getLec_name()) eq 0}">
						<span style="display: inline-block; width: 150px;">
							<input type="button" onclick="location.href='review/readyWriteReview/${registeredVO.getLec_name()}'" value="강의평가하기"/>
						</span>
					</c:when>
					<c:otherwise>
						<span style="display: inline-block; width: 150px;" >
							강의 평가 완료
						</span>	
					</c:otherwise>
					</c:choose>
					<br><br>
					
					
				</span>	
			</c:forEach>
	</div>
	
	
</body>
</html>