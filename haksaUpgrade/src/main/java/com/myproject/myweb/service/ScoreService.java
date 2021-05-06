package com.myproject.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.myweb.domain.PagingVO;
import com.myproject.myweb.domain.ScoreInsertVO;
import com.myproject.myweb.domain.ScoreVO;
import com.myproject.myweb.persistence.ScoreDAO;

@Service
public class ScoreService {

	@Autowired
	private ScoreDAO scoreDAO;
	
	public List<ScoreVO> selectLecForScore(ScoreVO scoreVO){
		List<ScoreVO> lecList = scoreDAO.selectLecForScore(scoreVO);
		return lecList;
	}
	
	public Integer selectScoreCount(int lec_id) {
		Integer total = scoreDAO.selectScoreCount(lec_id);
		return total;
	}
	
	public List<ScoreVO> selectScore(PagingVO pagingVO){
		List<ScoreVO> scoreList = scoreDAO.selectScore(pagingVO);
		return scoreList;
	}
	
	
	public void insertScore(ScoreInsertVO scoreInsertVO) {
		scoreDAO.insertScore(scoreInsertVO);
	}
	
	public ScoreInsertVO selectScoreForUpdate(ScoreVO scoreVO) {
		ScoreInsertVO scoreInsertVO = scoreDAO.selectScoreForUpdate(scoreVO);
		return scoreInsertVO;
	}
	
	public void updateScore(ScoreInsertVO scoreInsertVO) {
		scoreDAO.updateScore(scoreInsertVO);
	}
}
