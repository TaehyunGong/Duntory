package com.kong.duntory.member.model.service;

import java.util.ArrayList;

import com.kong.duntory.member.model.vo.Member;
import com.kong.duntory.member.model.vo.WishList;

public interface MemberService {

	//로그인 유저
	Member loginUser(Member m);

	int joinUser(Member m);

	int joinCheckId(String userId);

	int insertWishList(WishList wish);

	ArrayList<WishList> selectMemberWishList(Member m);

	int deleteAdventure(WishList list);

}
