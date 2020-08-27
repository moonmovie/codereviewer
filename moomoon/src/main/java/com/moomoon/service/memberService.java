package com.moomoon.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.moomoon.domain.*;

public interface memberService {
	
	public void signup(MemberVO vo) throws Exception;
	
	public MemberVO signin(MemberVO vo) throws Exception;
	
	public void signout(HttpSession session) throws Exception;
	
	public List<transFormVO> best_reviewer() throws Exception;
	
	public void reviewerModify(ReviewerVO vo) throws Exception;
	
	public void verifyReviewer(MemberVO vo) throws Exception;
}
