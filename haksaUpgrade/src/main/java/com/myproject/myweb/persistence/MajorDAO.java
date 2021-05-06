package com.myproject.myweb.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.myproject.myweb.domain.LectureVO;
import com.myproject.myweb.domain.MajorVO;
import com.myproject.myweb.domain.RegisterVO;
import com.myproject.myweb.domain.RegisteredVO;

@Service // @Repository
public class MajorDAO{
	@Inject
	private SqlSession sqlSession;
	
	private static final String SelectMajor = "MajorMapper.selectMajor";
	private static final String SelectLecSem = "MajorMapper.selectLecSem";
	private static final String SelectLecLimit = "MajorMapper.selectLecLimit";
	private static final String SelectLecture = "MajorMapper.selectLecture";
	private static final String SelectMinCount = "MajorMapper.selectMinCount";
	private static final String SelectMaxCount = "MajorMapper.selectMaxCount";
	private static final String InsertRegister = "MajorMapper.insertRegister";
	private static final String DeleteRegister = "MajorMapper.deleteRegister";
	private static final String SelectRegister = "MajorMapper.selectRegistered";
	
	public List<MajorVO> selectMajor() {
		return sqlSession.selectList(SelectMajor);
	}
	
	public String selectLecSem() {
		return sqlSession.selectOne(SelectLecSem);
	}
	
	public Integer selectLecLimit(LectureVO vo) {
		return sqlSession.selectOne(SelectLecLimit, vo);
	}
	
	public List<LectureVO> selectLecture(LectureVO vo){ 
		return sqlSession.selectList(SelectLecture, vo);
	}
	
	public Integer selectMinCount(LectureVO vo) {
		return sqlSession.selectOne(SelectMinCount, vo);
	}
	
	public Integer selectMaxCount(LectureVO vo) {
		return sqlSession.selectOne(SelectMaxCount, vo);
	}
	
	public void insertRegister(RegisterVO vo) {
		sqlSession.insert(InsertRegister, vo);
	}
	
	public void deleteRegister(RegisterVO vo) {
		sqlSession.delete(DeleteRegister, vo);
	}

	public List<RegisteredVO> selectRegistered(RegisteredVO vo) {
		return sqlSession.selectList(SelectRegister, vo);
	}
}
