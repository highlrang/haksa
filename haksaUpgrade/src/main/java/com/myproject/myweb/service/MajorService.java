package com.myproject.myweb.service;

import java.util.List;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.myweb.domain.LectureVO;
import com.myproject.myweb.domain.MajorVO;
import com.myproject.myweb.persistence.MajorDAO;

@Service
public class MajorService {
	@Autowired
	private MajorDAO majorDAO;
	
	public MultiValuedMap<String, String> selectMajor(){
		List<MajorVO> majorList = majorDAO.selectMajor();
		
		MultiValuedMap<String, String> majorMap = new ArrayListValuedHashMap<String, String>();
		for(MajorVO majorVO : majorList)
			majorMap.put(majorVO.getUpper_dept(), "'"+majorVO.getDept_name()+"'");
		
		return majorMap;
	}
	
	public List<LectureVO> selectLecture(LectureVO lectureVO){
		List<LectureVO> lectureList = majorDAO.selectLecture(lectureVO);
		
		return lectureList;
	}
	
	public String selectLecSem() {
		return majorDAO.selectLecSem();
	}
	
	public Integer selectLecLimit(LectureVO lectureVO) {
		return majorDAO.selectLecLimit(lectureVO);
	}
}
