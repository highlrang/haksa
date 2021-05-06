package com.myproject.myweb.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.myweb.domain.LectureVO;
import com.myproject.myweb.domain.RegisterVO;
import com.myproject.myweb.domain.RegisteredVO;
import com.myproject.myweb.persistence.MajorDAO;

@Service
public class RegisterService{
	@Autowired
	private MajorDAO majorDAO;
	
	public Map<String, Integer> selectRegistered(RegisteredVO registeredVO){
		List<RegisteredVO> alreadyList = majorDAO.selectRegistered(registeredVO);
		
		Map<String, Integer> alreadyMap = new HashMap<String, Integer>();
		for(RegisteredVO vo:alreadyList) {
			alreadyMap.put(vo.getLec_name(), vo.getReg_count());
		}
		
		return alreadyMap;
	}
	
	public Integer selectMaxCount(LectureVO lectureVO) {
		return majorDAO.selectMaxCount(lectureVO);
	}
	
	public Integer selectMinCount(LectureVO lectureVO) {
		return majorDAO.selectMinCount(lectureVO);
	};
	
	public void insertRegister(RegisterVO registerVO) {
		majorDAO.insertRegister(registerVO);
	}
	
	public void deleteRegister(RegisterVO registerVO) {
		majorDAO.deleteRegister(registerVO);
	}
}
