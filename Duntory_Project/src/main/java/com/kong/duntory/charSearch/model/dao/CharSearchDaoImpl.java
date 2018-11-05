package com.kong.duntory.charSearch.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kong.duntory.member.model.vo.Member;
import com.kong.duntory.member.model.vo.WishList;

@Repository
public class CharSearchDaoImpl implements CharSearchDao {

	@Autowired
	SqlSession sqlsession;

	@Override
	public ArrayList<WishList> selectWishList(Member m) {
		return (ArrayList)sqlsession.selectList("CharSearch.selectWishList",m);
	}
	
}
