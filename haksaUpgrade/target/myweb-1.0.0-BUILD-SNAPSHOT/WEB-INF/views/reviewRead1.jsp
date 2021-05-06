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
<script>
	$(function(){
		var msg = "${msg}";
		if(msg != ""){
			alert(msg);
		}
	})
</script>
</head>
<body>
	<jsp:include page="base.jsp"></jsp:include>
	
	<div style="margin-left: 3%; text-align: center;">
		<form action="review/readAllReview" method="get">
			<div> 검색 : <input type="text" name="lec_name" style="width: 30%;" placeholder="강의 이름" required/> <input type="submit" value="확인"/> </div>
		
		</form>
		<br><br>
		
		<div style="border-top: 1px solid black; border-bottom: 1px solid black; padding:1%;">나의 강의평가</div>
			<c:forEach var="reviewVO" items="${myReviewList}"><br>
			<div style="padding: 1%; border-radius: 5px; margin-right: 5%;" class="all">
			 
				<div> 
					<a class="info"> ${reviewVO.getLec_name()} </a><br><br>
					<form action="" method="get">	 
						<input type="hidden" value="${reviewVO.getLec_name()}" name="lec_name"/>
						<input type="submit" value="수정" formaction="review/readyUpdateReview"/>
						<input type="submit" value="삭제" formaction="review/deleteReview"/> 
					</form>
				</div>

				<div style="display: none;" class="other">
					<br>
					<div style="background-color:white">
						<span style="color: gray;">리뷰 키워드&ensp;&ensp;&ensp;</span>
	
						<c:set var="lecName" value="${reviewVO.getLec_name() }"/>
						<c:forEach var="count" items="${ myKeyword.get(lecName) }">
							<c:choose>
								<c:when test="${myCount.get(count) <= 3 }">
									<span style="font-size: 16px;">${count }</span>
								</c:when>
								<c:when test="${myCount.get(count) > 3}">
									<span style="font-size: 20px;">${count }</span>
								</c:when>
							</c:choose>	
						</c:forEach>
					</div>
					<br>
					

					<div id="star">
					<c:forEach begin="0" end="${reviewVO.getRev_stars() }">
						<span>★</span>	
					</c:forEach>
					</div>
					<br>
						
						
					<div>
						<textarea cols="60" rows="20" name="rev_content" wrap="hard" style="border-radius: 10px; padding:1%;" disabled>${reviewVO.getRev_content()}</textarea>
					</div>
						
					<br>
					<div>
					<c:choose>
						<c:when test="${reviewVO.getRev_public() eq 1}">
							공개
						</c:when>
						<c:otherwise>
							비공개
						</c:otherwise>
					</c:choose>
					</div>
				
				</div>
			</div>
		</c:forEach>
	</div>					
					
					
					
				
	<br><br><br>
	
	<script>
		$(function(){
			$(".info").click(function(){
				var info = $(this).parent("div");
				
				if(info.next().css("display") == "none"){
					$(".all").css({"background-color": "white"});
					info.parent().css({"background-color": "beige"});
					
					$(".other").css({"display": "none"});
					info.next().css({"display": "block"});
					
				}else{
					$(this).parent("div").parent().css({"background-color": "white"});
					$(this).parent("div").next().css({"display": "none"});
				}
			});
		});
		

	
	</script>
</body>
</html>