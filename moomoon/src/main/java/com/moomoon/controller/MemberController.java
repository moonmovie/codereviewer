package com.moomoon.controller;

import javax.inject.Inject;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.moomoon.domain.MemberVO;
import com.moomoon.service.memberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	memberService service;
	
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	@RequestMapping(value="/signup", method =RequestMethod.GET)
	public void getSignup() throws Exception{
		logger.info("get signup form");
	}
	
	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public String postSignup(MemberVO vo) throws Exception{
		logger.info("post signup");
		
		String inPass = vo.getUserPass();
		String encoder = passEncoder.encode(inPass);
		vo.setUserPass(encoder);
		
		service.signup(vo);
		
		return "redirect:/";
	}
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public void getSignin() throws Exception{
		logger.info("get signin");
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String postSignin(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		
		logger.info("post signin");
		
		MemberVO login = service.signin(vo);
		HttpSession session = req.getSession();
		
		if(login==null) {
			
			rttr.addFlashAttribute("msg" , true) ;
			return "redirect:/member/signin";
	
		}else {
			boolean passMatch = passEncoder.matches(vo.getUserPass(), login.getUserPass());
			
			if(login!=null && passMatch) {
				
				session.setAttribute("member", login);
				return "redirect:/";
				
			}else {
				session.setAttribute("member", null);
				rttr.addFlashAttribute("msg", false);
				return "redirect:/member/signin";
			}
		}
		
	}
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public String getSignout(HttpSession session) throws Exception{
		
		logger.info("signout");
		service.signout(session);
		
		return "redirect:/";
	}
}
