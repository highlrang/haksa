package com.myproject.myweb;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myproject.myweb.domain.ScoredVO;
import com.myproject.myweb.service.ScoredService;
import com.myproject.myweb.utils.SessionUtils;

@Controller
@RequestMapping("/scored")
public class ScoredController {
	@Autowired
	private ScoredService scoredService;
	@Autowired
	private SessionUtils sessionUtils;
	
	private static final Logger logger = LoggerFactory.getLogger(ScoredController.class);
	
	@RequestMapping
	public String goScored(HttpServletRequest request, Model model) {
		int user_id = sessionUtils.getSessionUser();
		List<ScoredVO> scoredList = scoredService.selectScored(user_id);
		model.addAttribute("scoredList", scoredList);
			
		return "scored";
	}
}
