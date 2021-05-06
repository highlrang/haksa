package com.myproject.myweb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.MultiValuedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myproject.myweb.domain.LectureVO;
import com.myproject.myweb.domain.RegisterVO;
import com.myproject.myweb.domain.RegisteredVO;
import com.myproject.myweb.domain.ReviewVO;
import com.myproject.myweb.service.MajorService;
import com.myproject.myweb.service.RegisterService;
import com.myproject.myweb.service.RegisteredService;
import com.myproject.myweb.service.ReviewService;
import com.myproject.myweb.utils.SessionUtils;


@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private MajorService majorService;
	@Autowired
	private RegisterService registerService;
	@Autowired
	private RegisteredService registeredService;
	@Autowired
	private ReviewService reviewService;

	@Autowired
	private SessionUtils sessionUtils;
	
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@RequestMapping("/majorForRegister")
	public String goMajor(Model model) {
		MultiValuedMap<String, String> majorList = majorService.selectMajor();
		model.addAttribute("majorList", majorList);
		return "/register1";
	}
	
	
	@RequestMapping(value="/lectureForRegister")
	public String goLecture(Model model, @RequestParam(value="maj_name") String maj_name) {
		System.out.println("utils method 호출 전");
		int user_id = sessionUtils.getSessionUser();
		String lec_sem = majorService.selectLecSem();
		
		LectureVO lectureVO = new LectureVO();
		lectureVO.setLec_maj(maj_name);
		lectureVO.setLec_sem(lec_sem);
		List<LectureVO> lectureList = majorService.selectLecture(lectureVO);
		
		RegisteredVO selectAlreadyRegVO = new RegisteredVO(user_id, lec_sem);
		Map<String, Integer> alreadyRegistered = registerService.selectRegistered(selectAlreadyRegVO);
				
		model.addAttribute("lectureList", lectureList);
		model.addAttribute("already", alreadyRegistered);
		model.addAttribute("maj_name", maj_name);
		model.addAttribute("lec_sem", lec_sem);
		return "register2";
				
	}
	

	@RequestMapping(value="/insert")
	public String goRegister(HttpServletRequest request, RedirectAttributes redirect) {
		String maj_name = request.getParameter("maj_name");
		String lec_name = request.getParameter("lec_name");
		String lec_sem = majorService.selectLecSem(); // final이나 static?
		int user_id = sessionUtils.getSessionUser();
		Integer reg_count = 0;
		
		LectureVO lectureVO = new LectureVO(lec_name, lec_sem);
		Integer maxCount = registerService.selectMaxCount(lectureVO);
		Integer lecLimit = majorService.selectLecLimit(lectureVO);
		
		try {
			if(maxCount >= lecLimit) {
				reg_count = registerService.selectMinCount(lectureVO) - 1;
				
			}else {
				
				reg_count = maxCount + 1;
			}
		
		}catch(NullPointerException e) {
			reg_count = 1;
		}	
			
		RegisterVO registerVO = new RegisterVO(user_id, lec_name, lec_sem, reg_count);
		registerService.insertRegister(registerVO);
		
		redirect.addAttribute("maj_Name", maj_name);
		return "redirect:/register/lectureForRegister";
		
	}
	
	
	@RequestMapping(value="/registerDelete")
	public String goRegisterDelete(HttpServletRequest request, RedirectAttributes redirect) {
		String maj_name = request.getParameter("maj_name");
		Integer lec_id = Integer.valueOf(request.getParameter("lec_id"));
		int user_id = sessionUtils.getSessionUser();
		
		RegisterVO registerVO = new RegisterVO(user_id, lec_id);
		registerService.deleteRegister(registerVO);
		
		redirect.addAttribute("maj_name", maj_name);
		return "redirect:/register/lectureForRegister";
	}
	
	
	@RequestMapping(value="/registered") 
	public String goRegistered(HttpServletRequest request, Model model) {
		int user_id = sessionUtils.getSessionUser();
		String lec_sem = majorService.selectLecSem();
		RegisteredVO registeredVO = new RegisteredVO(user_id, lec_sem);
		List<RegisteredVO> registeredList = registeredService.selectRegistered(registeredVO);
		
		Map<String, Integer> star_list = new HashMap<String, Integer>();
		ReviewVO reviewVO = new ReviewVO();
		reviewVO.setUser_id(user_id);
		
		for(RegisteredVO vo: registeredList) {
			reviewVO.setLec_name(vo.getLec_name());
			
			Integer star = reviewService.selectMyStars(reviewVO);
			star_list.put(vo.getLec_name(), star);
			
		}
			
		model.addAttribute("registeredList", registeredList);
		model.addAttribute("starList", star_list);
		return "registered1";
	}
}
