package com.kong.duntory.member.model.dao;

import java.util.ArrayList;

import com.kong.duntory.member.model.vo.Member;
import com.kong.duntory.member.model.vo.WishList;

public interface MemberDao {

	Member loginUser(Member m);

	String selectEncPassword(Member m);

	int insertJoinUser(Member m);

	int selectJoinCheckId(String userId);

	int selectWishList(WishList wish);

	int insertWishList(WishList wish);

	int deleteWishList(WishList wish);

	ArrayList<WishList> selectMemberWishList(Member m);

	int deleteAdventure(WishList list);

}
