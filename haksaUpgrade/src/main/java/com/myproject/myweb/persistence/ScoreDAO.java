package com.myproject.myweb.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.myproject.myweb.domain.PagingVO;
import com.myproject.myweb.domain.ScoreInsertVO;
import com.myproject.myweb.domain.ScoreVO;
import com.myproject.myweb.domain.ScoredVO;

@Service
public class ScoreDAO {
	@Inject
	private SqlSession sqlSession;
	
	private static final String SelectLecForScore = "ScoreMapper.selectLecForScore";
	private static final String SelectScoreCount = "ScoreMapper.selectScoreCount"; 
	private static final String SelectScore = "ScoreMapper.selectScore";
	private static final String InsertScore = "ScoreMapper.insertScore";
	private static final String SelectScoreForUpdate = "ScoreMapper.selectScoreForUpdate";
	private static final String UpdateScore = "ScoreMapper.updateScore";
	private static final String SelectScored = "ScoreMapper.selectScored";
	private static final String SelectComplete = "ScoreMapper.selectComplete";
	
	
	public List<ScoreVO> selectLecForScore(ScoreVO vo){
		return sqlSession.selectList(SelectLecForScore, vo);
	}
	
	public int selectScoreCount(int lec_id) {
		return sqlSession.selectOne(SelectScoreCount, lec_id);
	}
	
	public List<ScoreVO> selectScore(PagingVO vo) {
		return sqlSession.selectList(SelectScore, vo);
	}
	
	public void insertScore(ScoreInsertVO vo) {
		sqlSession.insert(InsertScore, vo);
	}
	
	public ScoreInsertVO selectScoreForUpdate(ScoreVO vo) {
		return sqlSession.selectOne(SelectScoreForUpdate, vo);
	}
	
	public void updateScore(ScoreInsertVO vo) {
		sqlSession.update(UpdateScore, vo);
	}
	
	public List<ScoredVO> selectScored(int user_id){
		return sqlSession.selectList(SelectScored, user_id);
	}
	
	public List<Integer> selectComplete(int lec_id){
		return sqlSession.selectList(SelectComplete, lec_id);
	}
}
