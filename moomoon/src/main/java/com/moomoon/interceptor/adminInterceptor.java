package com.moomoon.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.moomoon.domain.MemberVO;

public class adminInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO)session.getAttribute("member");
		
		if(member == null) {
			res.sendRedirect("/member/signup");
			return false;
		}
		
		/*
		 * if(member.getVerify() !=9 || member.getVerify() !=0 || member.getVerify()
		 * !=1){ res.sendRedirect("/"); return false; }
		 */
		return true;
	}
}
