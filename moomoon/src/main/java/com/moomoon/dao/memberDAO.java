package com.moomoon.dao;

import java.util.List;

import com.moomoon.domain.*;

public interface memberDAO {
	
	public void signup(MemberVO vo) throws Exception;
	public MemberVO signin(MemberVO vo) throws Exception;
	
	public List<transFormVO> best_reviewer() throws Exception;
	
	public void reviewerModify(ReviewerVO vo) throws Exception;
	
	public void verifyReviewer(MemberVO vo) throws Exception;
}
