package com.myproject.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.myweb.domain.RegisteredVO;
import com.myproject.myweb.persistence.MajorDAO;

@Service
public class RegisteredService {

	@Autowired
	private MajorDAO majorDAO;
	
	public List<RegisteredVO> selectRegistered(RegisteredVO registeredVO){
		List<RegisteredVO> registeredList = majorDAO.selectRegistered(registeredVO);
		

		return registeredList;
	}
	
	
}
