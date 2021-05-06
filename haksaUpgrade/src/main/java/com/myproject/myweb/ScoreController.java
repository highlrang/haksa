package com.myproject.myweb;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myproject.myweb.domain.PagingVO;
import com.myproject.myweb.domain.ScoreInsertVO;
import com.myproject.myweb.domain.ScoreVO;
import com.myproject.myweb.service.MajorService;
import com.myproject.myweb.service.ScoreService;
import com.myproject.myweb.service.ScoredService;
import com.myproject.myweb.utils.SessionUtils;

@Controller
@RequestMapping("/score")
public class ScoreController {
	@Autowired
	private ScoreService scoreService;
	@Autowired
	private ScoredService scoredService;
	@Autowired
	private MajorService majorService;
	@Autowired
	private SessionUtils sessionUtils;
	
	private static final Logger logger = LoggerFactory.getLogger(ScoreController.class);
	
	
	@RequestMapping(value="/readyForScoreInsert")
	public String goLecForScoreInsert(Model model) {
		int user_id = sessionUtils.getSessionUser();
		String lec_sem = majorService.selectLecSem();
		ScoreVO scoreVO = new ScoreVO(user_id, lec_sem);
		
		List<ScoreVO> lecList = scoreService.selectLecForScore(scoreVO);
		model.addAttribute("lecList", lecList);
		return "score1";
		
	}

	
	@RequestMapping(value="/infoForScoreInsert")
	public String goInfoForScoreInsert(HttpServletRequest request, Model model,
			@RequestParam(value="lec_id") int lec_id,
			@RequestParam(value="lec_name") String lec_name,
			@RequestParam(value="nowPage", required=false) String nowPage
			) {
		
		// 강의 수강생 수
		int totalP = scoreService.selectScoreCount(lec_id);
		if (nowPage == null) {
			nowPage = "1";
		}
		PagingVO pagingVO = new PagingVO(lec_id, totalP, Integer.parseInt(nowPage));
		List<ScoreVO> score_list = scoreService.selectScore(pagingVO);
			
			
		
		// 성적 등록여부
		List<Integer> alreadyScoredList = scoredService.selectComplete(lec_id); // 성적 입력된 학생
		boolean isScoredEvenOne = !alreadyScoredList.isEmpty();
		List<Integer> already_scored_list = new ArrayList<Integer>();
		List<Integer> none_score_list = new ArrayList<Integer>();
		
		if(isScoredEvenOne) { // 이미 성적 입력된 학생 있으면
			for(Integer stu_num: alreadyScoredList) {
				already_scored_list.add(stu_num);
			}
		}
		// 성적 입력안된리스트
		for(ScoreVO scoreVO: score_list) {
			// (List<Integer>) MultiValueMap.get(val);
			if(!already_scored_list.contains(scoreVO.getUser_id())){
				none_score_list.add(scoreVO.getUser_id());
			}
		}
		
		model.addAttribute("lec_id", lec_id);
		model.addAttribute("lec_name", lec_name);

		model.addAttribute("score_list", score_list);
		model.addAttribute("complete_list", already_scored_list);
		model.addAttribute("none_list", none_score_list);
		
		model.addAttribute("paging", pagingVO);
		
		return "score2";
	}
	
	
	@RequestMapping(value="/readyScoreInsert")
	public String goReadyScoreInsert(Model model, 
			ScoreInsertVO scoreInsertVO,
			@RequestParam(value="nowPage") int nowPage,
			@RequestParam(value="lec_id") int lec_id, @RequestParam(value="lec_name") String lec_name, 
			@RequestParam(value="user_id") int user_id, @RequestParam(value="user_name") String user_name ) {
		

		model.addAttribute("nowPage", nowPage);
		model.addAttribute("user_id", user_id);
		model.addAttribute("user_name", user_name);
		model.addAttribute("lec_id", lec_id);
		model.addAttribute("lec_name", lec_name);
		return "score3";
	} 
	
	@RequestMapping(value="/scoreInsert", method=RequestMethod.POST) // PostMapping
	public String goScoreInsert(HttpServletRequest request, ScoreInsertVO scoreInsertVO, RedirectAttributes redirect) {
		int nowPage = Integer.valueOf(request.getParameter("nowPage"));
		String lec_name = request.getParameter("lec_name");
		int lec_id = scoreInsertVO.getLec_id();
		
		scoreService.insertScore(scoreInsertVO);
		
		redirect.addAttribute("lec_id", lec_id);
		redirect.addAttribute("lec_name", lec_name); 
		redirect.addAttribute("nowPage", nowPage);
		return "redirect:/score/infoForScoreInsert";
	} 
	
	
	// ../{} + @PathVariable() + ${pageContext.request.contextPath}/
	@RequestMapping(value="/readyScoreUpdate") 
	public String goReadyScoreUpdate(HttpServletRequest request, Model model,
			@RequestParam(value="nowPage") int nowPage,
			@RequestParam(value="lec_id") int lec_id, @RequestParam(value="lec_name") String lec_name, 
			@RequestParam(value="user_id") int user_id, @RequestParam(value="user_name") String user_name) {
		
		ScoreVO scoreVO = new ScoreVO(lec_id, user_id);
		ScoreInsertVO scoreInsertVO = scoreService.selectScoreForUpdate(scoreVO);
		
		model.addAttribute(scoreInsertVO);
		model.addAttribute("user_name", user_name);
		model.addAttribute("lec_id", lec_id);
		model.addAttribute("lec_name", lec_name);
		model.addAttribute("nowPage", nowPage);
		return "scoreUpdate";
	}
	
	@RequestMapping(value="/scoreUpdate", method=RequestMethod.POST) // PostMapping
	public String goScoreUpdate(ScoreInsertVO scoreInsertVO, HttpServletRequest request, RedirectAttributes redirect) {
		int nowPage = Integer.valueOf(request.getParameter("nowPage"));
		int lec_id = Integer.valueOf(request.getParameter("lec_id"));
		String lec_name = request.getParameter("lec_name");
		
		scoreService.updateScore(scoreInsertVO);
	
		redirect.addAttribute("lec_id", lec_id);
		redirect.addAttribute("lec_name", lec_name);
		redirect.addAttribute("nowPage", nowPage);
		return "redirect:/score/infoForScoreInsert";
	}
	
}
