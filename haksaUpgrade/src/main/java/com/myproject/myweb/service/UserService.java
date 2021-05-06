package com.myproject.myweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.myproject.myweb.domain.UserVO;
import com.myproject.myweb.exception.UserNotFoundException;
import com.myproject.myweb.persistence.UserDAO;

@Service
public class UserService implements UserDetailsService{
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserVO loadUserByUsername(String username){
		UserVO user = userDAO.selectUserById(username);
		
		/* if(user == null) { 
			throw new UserNotFoundException(); 
		}
		*/
		
		return user; 
	}
	
	
	// 회원가입 기능 없음
}
