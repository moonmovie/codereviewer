package com.moomoon.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.moomoon.dao.memberDAO;
import com.moomoon.domain.MemberVO;
import com.moomoon.domain.ReviewerVO;
import com.moomoon.domain.transFormVO;

@Service
public class memberServiceImpl implements memberService {
	
	@Inject
	private memberDAO dao;
	
	@Override
	public void signup(MemberVO vo) throws Exception {
		dao.signup(vo);
	}

	@Override
	public MemberVO signin(MemberVO vo) throws Exception {
		return dao.signin(vo);
	}

	@Override
	public void signout(HttpSession session) throws Exception {
		session.invalidate();
		
	}

	@Override
	public List<transFormVO> best_reviewer() throws Exception {
		
		return dao.best_reviewer();
	}

	@Override
	public void reviewerModify(ReviewerVO vo) throws Exception {
		
		dao.reviewerModify(vo);
	}

	@Override
	public void verifyReviewer(MemberVO vo) throws Exception {
		
		dao.verifyReviewer(vo);
	}
	
	

}
