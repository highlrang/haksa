package com.myproject.myweb.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.myproject.myweb.domain.UserVO;

public class LoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, 
			Authentication authentication) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("user", authentication.getPrincipal());
		session.setAttribute("userId", authentication.getName());
		
		UserVO user = (UserVO) session.getAttribute("user");
		String user_role = user.getUser_role();
		
		if(user_role.equals("ROLE_STUDENT")) {
			session.setAttribute("userRole", "STUDENT");
		}else {
			session.setAttribute("userRole", "PROFESSOR");
		}
		
		
		response.sendRedirect("/");
	}
}
