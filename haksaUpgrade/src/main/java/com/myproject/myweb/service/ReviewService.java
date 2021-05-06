package com.myproject.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.myweb.domain.LectureVO;
import com.myproject.myweb.domain.ReviewVO;
import com.myproject.myweb.persistence.ReviewDAO;

@Service
public class ReviewService {

	@Autowired
	private ReviewDAO reviewDAO;
	
	public Integer selectMyStars(ReviewVO reviewVO) {
		Integer star = reviewDAO.selectMyStars(reviewVO);
		if (star == null) {
			star = 0;
		}
		return star;
	}
	
	public List<ReviewVO> selectMyReview(Integer user_id){
		
		List<ReviewVO> myReviewList = reviewDAO.selectMyReview(user_id);
		return myReviewList; 
	}
	
	public List<LectureVO> selectLecture(String lec_name){
		
		List<LectureVO> lectureList = reviewDAO.selectLecture(lec_name);
		return lectureList;
	}
	
	public List<ReviewVO> selectAllReview(Integer lec_id){
		
		List<ReviewVO> allReviewList = reviewDAO.selectAllReview(lec_id);
		return allReviewList;
	}
	
	public void insertReview(ReviewVO reviewVO) {
		reviewDAO.insertReview(reviewVO);
	}
	
	public ReviewVO selectForUpdate(ReviewVO reviewVO) {
		ReviewVO getReviewVO = reviewDAO.selectForUpdate(reviewVO);
		return getReviewVO;
	}
	
	public void updateMyReview(ReviewVO reviewVO) {
		reviewDAO.updateMyReview(reviewVO);
	}
	
	public void deleteMyReview(ReviewVO reviewVO) {
		reviewDAO.deleteMyReview(reviewVO);
	}
}
