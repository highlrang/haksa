package com.myproject.myweb.utils;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 직접 <> @Configuration & @Bean
public class SessionUtils {
	
	@Autowired
	private HttpSession session;
	
	public Integer getSessionUser() {
		System.out.println("method 호출 중");
		return Integer.valueOf((String) session.getAttribute("userId"));
	}
	
}


// 세션 불러내기 최종은 utils로..

//int user_id = (Integer)session.getAttribute("userId");
//int user_id = Integer.valueOf(principal.getName());
//public void index(Authentication authentication) { UserVO user = (UserVO)authentication.getPrincipal(); }
//@SessionAttribute
/*
	@Autowired
	private static HttpSession session;
	
	public static Integer getSessionUser() {
		return (Integer)session.getAttribute("userId");
	}
*/