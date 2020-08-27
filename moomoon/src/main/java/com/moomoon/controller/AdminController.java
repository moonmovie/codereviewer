package com.moomoon.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moomoon.domain.*;
import com.moomoon.service.memberService;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	memberService service;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String admin(HttpServletRequest req, MemberVO vo, Model model) throws Exception{
		
		logger.info("get admin index");
		HttpSession session = req.getSession();
		MemberVO re_user = (MemberVO)session.getAttribute("member");
		String[] userSet = {"user","reviewer","manager"}; 
		if(re_user.getVerify()==0) {
			model.addAttribute("user", userSet[0]);
		}else if(re_user.getVerify()==1) {
			model.addAttribute("user", userSet[1]);
		}else {
			model.addAttribute("user", userSet[2]);
		}
		
		return "index";
	}
	
	@RequestMapping(value = "postAjax.do")
	@ResponseBody
	public String ajaxtest(HttpServletRequest req, Model model, ReviewerVO vo, MemberVO mvo) throws Exception{
		String str1=req.getParameter("data");
		logger.info(str1);
		HttpSession session = req.getSession();
		MemberVO user=(MemberVO)session.getAttribute("member");
		System.out.println(user.getUserId());
		vo.setReviewer(user.getUserId());
		vo.setLang(str1);
		mvo.setVerify(1);
		mvo.setUserId(user.getUserId());
		service.verifyReviewer(mvo);
		service.reviewerModify(vo);
		return "Seucess";
	}
	
	
}
