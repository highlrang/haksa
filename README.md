# 학사관리 웹 프로그래밍 코드 설명
+ 웹페이지의 기능은 사용자 인증, 수강 등록, 강의 평가, 성적으로 이루어져 있습니다.
+ 그 중 **수강 신청 페이지**를 중심으로 코드를 소개하겠습니다. 
+ 주석 중심으로 살펴봐주세요.

## Controller

``` java
@RequestMapping(value="/insert")
public String goRegister(HttpServletRequest request, RedirectAttributes redirect) {
    String maj_name = request.getParameter("maj_name");
		String lec_name = request.getParameter("lec_name");
		String lec_sem = majorService.selectLecSem();                                               
		int user_id = sessionUtils.getSessionUser();                                          // session에서 사용자 정보 호출하는 메서드
		Integer reg_count = 0;
		
		LectureVO lectureVO = new LectureVO(lec_name, lec_sem);
		Integer maxCount = registerService.selectMaxCount(lectureVO);
		Integer lecLimit = majorService.selectLecLimit(lectureVO);
		
		try {
			if(maxCount >= lecLimit) {
				reg_count = registerService.selectMinCount(lectureVO) - 1;
				
			}else {
				
				reg_count = maxCount + 1;
			}
		
		}catch(NullPointerException e) {
			reg_count = 1;
		}	
			
		RegisterVO registerVO = new RegisterVO(user_id, lec_name, lec_sem, reg_count);
		registerService.insertRegister(registerVO);
		
		redirect.addAttribute("maj_Name", maj_name);
		return "redirect:/register/lectureForRegister";
		
	}
```

------------------------------------------------------

## Service

``` java
@Service
public class RegisterService{
	
  @Autowired
	private MajorDAO majorDAO;
  
  ...
  
  public void insertRegister(RegisterVO registerVO) {
		majorDAO.insertRegister(registerVO);
	}
	
	public void deleteRegister(RegisterVO registerVO) {
		majorDAO.deleteRegister(registerVO);
	}
}

```

------------------------------------------------------

## VO

```java

public class RegisterVO {
	private Integer user_id;
	private Integer lec_id;
	private String lec_name;
	private String lec_sem;
	private Integer reg_count;
	private Integer lec_limit;
	
	public RegisterVO() {};
	
  public RegisterVO(Integer user_id, String lec_name, String lec_sem, Integer reg_count) {
		this.user_id = user_id;
		this.lec_name = lec_name;
		this.lec_sem = lec_sem;
		this.reg_count = reg_count;
	}
  
	...

```

-------------------------------------------------------------------

## DAO

```java
@Repository
public class MajorDAO{
	@Inject
	private SqlSession sqlSession;    # mybatis 연결
  ...
	private static final String InsertRegister = "MajorMapper.insertRegister";      # mapper 지정
	private static final String SelectRegister = "MajorMapper.selectRegistered";
	
  ...
	public void insertRegister(RegisterVO vo) {
		sqlSession.insert(InsertRegister, vo);          			# insert 메서드(DB 기능) 실행
	}
  
	public List<RegisteredVO> selectRegistered(int stu_number) {
		return sqlSession.selectList(SelectRegister, stu_number);        	# select 메서드(DB 기능) 실행
	}
}
```

--------------------------------------------------------

## Mapper

+ 전달받은 변수를 활용하여 등록 테이블 insert 및 select SQL문

```xml
<insert id="insertRegister">
	  insert into register_l(reg_id, reg_stu, reg_lec, reg_sem, reg_count) 
	  values( 
	  (select MAX(reg_id) + 1 from register_l),
	  #{user_id}, 
	  (select lec_id from lecture where lec_name=#{lec_name} and lec_sem=#{lec_sem}), 
	  #{lec_sem},
	  #{reg_count}
	  )
</insert>
  
<select id="selectRegistered" resultType="registeredvo">
    select lec_name, lec_sem, lec_maj, reg_count
    from lecture, register_l
	  where reg_stu = #{user_id} 
	  and lec_id = reg_lec
	  and lec_sem=#{lec_sem}
</select>
```

-----------------------------------------------------------------------

# jsp

```jsp
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
</head>
<body>

  <jsp:include page="base.jsp"></jsp:include>
	
	<div style="margin-left: 5%;">
	<div style="font-weight: bold;">${lec_sem} - ${maj_name} 강의</div>
	<br><br>
	
	<c:forEach var="lecture" items="${lectureList}">                                                      // List<LectureVO> 로 넘겨받은 강의 객체들 for문으로 순회
	    <form method="post">
		    <span style="margin: 3%;"> 
		    	<span style="font-weight: bold;">${lecture.getLec_name()}</span>                              // 각 강의 세부 정보
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
				    		<span><input type="submit" value="수강 신청 취소" formaction="registerDelete"/></span>                    // 이미 수강신청 되어있으면 수강 취소 버튼
				    	</c:when>
				    	<c:otherwise>
				    		<span><input type="submit" value="수강 대기 취소" formaction="registerDelete" /></span>                   // 수강 대기 처리 되어있으면 수강 대기 취소 버튼
				    	</c:otherwise>
				    </c:choose>	
		    	</c:when>
		    	<c:otherwise>
		    		<input type="submit" value="수강신청" formaction="insert"/>                                                   // 위에 해당되지 않을 경우 수강신청 버튼
				  </c:otherwise>
			</c:choose>	

	    </form>
	    <br>
	</c:forEach>
	</div>
</body>
</html>
```
