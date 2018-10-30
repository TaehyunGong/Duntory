package com.kong.duntory.member.model.dao;

import com.kong.duntory.member.model.vo.Member;

public interface MemberDao {

	Member loginUser(Member m);

	String selectEncPassword(Member m);

	int insertJoinUser(Member m);

}
