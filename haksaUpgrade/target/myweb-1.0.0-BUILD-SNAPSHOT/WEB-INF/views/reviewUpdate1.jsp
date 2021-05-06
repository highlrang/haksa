<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<style>
	#for_rev_stars a{
		text-decoration: none;
		color: lightgray;
	}		
	
	#for_rev_stars a.on{
		color: black;
	}
	
	.textCss{
		border-radius: 8px; 
		padding: 1%;
	}
</style>
<script>
	function formValidCheck(){
		var star = document.getElementById("rev_stars").value;
		var content = document.getElementById("rev_content").value;
		if(star != "" && content != ""){
			return true;
		}else{
			alert("별점평가 등 빠짐없이 작성해주세요");
			return false;
		}
	}
	
	$(function(){
		$("input[type='checkbox']").click(function(){
			$("input[type='checkbox']").prop('checked', false);
			$(this).prop('checked', true);
		})
		
	});
</script>
</head>
<body>
	<jsp:include page="base.jsp"></jsp:include>
	
	<div style="margin-left: 3%">
	
		<div style="font-weight: bold;"> ${reviewVO.getLec_name()} - 강의 평가 수정</div>
		
		<br>
		
		<form:form modelAttribute="reviewVO" action="review/updateReview" method="post" onsubmit="return formValidCheck();">
		
			<form:hidden path="lec_name"/>
			<form:hidden path="user_id"/>
			
			<div>
				<div id="for_rev_stars">
					<a href="#">★</a>
					<a href="#">★</a>
					<a href="#">★</a>
					<a href="#">★</a>
					<a href="#">★</a>
					<form:hidden path="rev_stars"/>
				</div>
			</div><br>
			
			<div><form:textarea cols="60" rows="20" path="rev_content" wrap="hard" cssClass="textCss"></form:textarea></div><br>
			
			<div>
				<form:checkbox path="rev_public" value="1" label="공개"/>
				<form:checkbox path="rev_public" value="0" label="비공개"/>
			</div><br>
			
			<div><input type="submit" value="확인"/></div>
		</form:form>
		
	</div>
	<script>
		$("#for_rev_stars a").click(function(){
			$(this).parent().children("a").removeClass("on");
			$(this).addClass("on").prevAll("a").addClass("on");
			document.getElementById("rev_stars").value = $('.on').length;
			return false;
		});
		
		$(document).ready(function(){
			/*
			var rev_pub = ${rev_public};
			if(rev_pub == "1"){
				$("input[type=checkbox][value='1']").prop("checked", true);
			}else{
				$("input[type=checkbox][value='0']").prop("checked", true);
			}
			*/
			
			var star_index = ${reviewVO.rev_stars};
			$("#for_rev_stars a").eq(star_index).trigger("click");
			
		});
	</script>
</body>
</html>