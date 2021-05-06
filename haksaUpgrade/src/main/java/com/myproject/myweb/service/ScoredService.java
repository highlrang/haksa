package com.myproject.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.myweb.domain.ScoredVO;
import com.myproject.myweb.persistence.ScoreDAO;

@Service
public class ScoredService {

	@Autowired
	private ScoreDAO scoreDAO;
	
	public List<Integer> selectComplete(int lec_id){
		List<Integer> alreadyScoredList = scoreDAO.selectComplete(lec_id);
		return alreadyScoredList;
		
	}
	
	public List<ScoredVO> selectScored(int user_id){
		List<ScoredVO> scoredList = scoreDAO.selectScored(user_id);
		return scoredList;
	}
	
}
