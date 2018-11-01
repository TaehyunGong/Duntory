package com.kong.duntory.member.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kong.duntory.member.model.vo.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	SqlSession sqlsession;
	
	@Override
	public Member loginUser(Member m) {
		return sqlsession.selectOne("Member.selectLogin",m);
	}

	@Override
	public String selectEncPassword(Member m) {
		return sqlsession.selectOne("Member.selectEncPwd",m);
	}

	@Override
	public int insertJoinUser(Member m) {
		return sqlsession.insert("Member.insertJoinUser",m);
	}

	@Override
	public int selectJoinCheckId(String userId) {
		return sqlsession.selectOne("Member.selectJoinCheckId",userId);
	}

}
