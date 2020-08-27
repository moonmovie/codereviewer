package com.moomoon.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.moomoon.domain.MemberVO;
import com.moomoon.domain.ReviewerVO;
import com.moomoon.domain.transFormVO;

@Repository
public class memberDAOImpl implements memberDAO{
	
	@Inject
	private SqlSession sql;
	
	private static String namespace = "moomoon_member";
	
	@Override
	public void signup(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.insert(namespace+".signup", vo);
	}

	@Override
	public MemberVO signin(MemberVO vo) throws Exception {
		return sql.selectOne(namespace+".signin", vo);
	}

	@Override
	public List<transFormVO> best_reviewer() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace+".best_reviewer");
	}

	@Override
	public void reviewerModify(ReviewerVO vo) throws Exception {
		sql.insert(namespace+".reviewerModify", vo);
		
	}

	@Override
	public void verifyReviewer(MemberVO vo) throws Exception {
		sql.update(namespace+".verify_reviewer", vo);
		
	}
	

}
