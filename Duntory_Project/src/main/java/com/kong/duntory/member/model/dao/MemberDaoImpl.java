package com.kong.duntory.member.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kong.duntory.member.model.vo.Member;
import com.kong.duntory.member.model.vo.WishList;

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

	@Override
	public int selectWishList(WishList wish) {
		return sqlsession.selectOne("Member.selectWishList",wish);
	}

	@Override
	public int insertWishList(WishList wish) {
		System.out.println(wish);
		return sqlsession.insert("Member.insertWishList",wish);
	}

	@Override
	public int deleteWishList(WishList wish) {
		return sqlsession.delete("Member.deleteWishList",wish);
	}

	@Override
	public ArrayList<WishList> selectMemberWishList(Member m) {
		return (ArrayList)sqlsession.selectList("Member.selectMemberWishList", m);
	}

	@Override
	public int deleteAdventure(WishList list) {
		return sqlsession.delete("Member.deleteAdventure", list);
	}

}
