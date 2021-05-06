package com.myproject.myweb;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myproject.myweb.domain.LectureVO;
import com.myproject.myweb.domain.ReviewVO;
import com.myproject.myweb.service.ReviewService;
import com.myproject.myweb.utils.SessionUtils;
import com.myproject.myweb.service.ReviewKeywordServiceImpl;


@Controller
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private ReviewKeywordServiceImpl reviewKeywordService;
	
	@Autowired
	private SessionUtils sessionUtils;
	
	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	
	
	
	@RequestMapping(value="/readMyReview")
	public String goReadMyReview(Model model) {
		int user_id = sessionUtils.getSessionUser();
		
		MultiValuedMap<String, String> myKeyword = new ArrayListValuedHashMap<String, String>();
		Map<String, Integer> myCount = new HashMap<String, Integer>();
		
		List<ReviewVO> myReviewList = reviewService.selectMyReview(user_id);
		
		for(ReviewVO reviewVO : myReviewList) {
			String keyword = reviewVO.getRev_keyword();
			List<String> keywordList = Arrays.asList(keyword.split("\\.")); // Arrays.toString([])
			
			for(int i=0; i<keywordList.size(); i=i+2) {
				myKeyword.put(reviewVO.getLec_name(), keywordList.get(i));
			}
			for(int i=1; i<keywordList.size(); i=i+2) {
				myCount.put(keywordList.get(i-1), Integer.valueOf(keywordList.get(i)));
			}
			
		}
		
		model.addAttribute("myReviewList", myReviewList);
		model.addAttribute("myKeyword", myKeyword);
		model.addAttribute("myCount", myCount);
		return "reviewRead1";
	}
	
	
	@RequestMapping(value="/readAllReview", method=RequestMethod.GET)
	public String goReadAllReview(Model model, @RequestParam("lec_name") String lec_name) {
		
		List<LectureVO> lectureList = reviewService.selectLecture(lec_name);

		model.addAttribute("lec_name", lec_name);
		model.addAttribute("lectureList", lectureList);
		return "reviewRead2";
	}
	
	
	@RequestMapping(value="/readLecReview", method=RequestMethod.GET)
	public String goReadLecReview(@RequestParam("lec_id") int lec_id, @RequestParam("lec_name") String lec_name, Model model) {
		
		List<ReviewVO> reviewList = reviewService.selectAllReview(lec_id);
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("lec_name", lec_name);
		
		return "reviewRead3";
		
	}
	
	
	@RequestMapping(value="/readyWriteReview/{lec_name}") 
	public String goReadyWriteReview(@PathVariable("lec_name") String lec_name, Model model) {
		int user_id = sessionUtils.getSessionUser();
		ReviewVO reviewVO = new ReviewVO(user_id, lec_name);
		model.addAttribute(reviewVO);
		
		return "reviewWrite1";
	}
	
	
	@RequestMapping(value="/writeReview", method=RequestMethod.POST) // PostMapping
	public String goWriteReview(ReviewVO reviewVO, HttpServletRequest request) {
		
		String keyword = reviewKeywordService.getReviewKeyword(reviewVO.getRev_content());
		logger.info(keyword);
	   
		reviewVO.setRev_keyword(keyword);
	    reviewService.insertReview(reviewVO);

	    return "redirect:/register/registered";
	}
	
	
	
	@RequestMapping(value="/readyUpdateReview")
	public String goReadyUpdateReview(@RequestParam("lec_name") String lec_name, Model model) {
		int user_id = sessionUtils.getSessionUser();

		ReviewVO vo = new ReviewVO(user_id, lec_name);
		ReviewVO reviewVO = reviewService.selectForUpdate(vo);
		
		model.addAttribute(reviewVO);
		return "reviewUpdate1";
	}
	
	
	@RequestMapping(value="/updateReview", method=RequestMethod.POST) // PostMapping
	public String goUpdateReview(ReviewVO reviewVO) {
		
		String keyword = reviewKeywordService.getReviewKeyword(reviewVO.getRev_content());
	    reviewVO.setRev_keyword(keyword);
		reviewService.updateMyReview(reviewVO);
		
		return "redirect:/review/readMyReview";
	}
	
	
	@RequestMapping(value="/deleteReview", method=RequestMethod.GET)
	public String goDeleteReview(@RequestParam("lec_name") String lec_name) {
		int user_id = sessionUtils.getSessionUser();
		ReviewVO reviewVO = new ReviewVO(user_id, lec_name);
		reviewService.deleteMyReview(reviewVO);
		
		return "redirect:/review/readMyReview";
	}
}
