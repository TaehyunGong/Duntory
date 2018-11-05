package com.kong.duntory.charSearch.model.dao;

import java.util.ArrayList;

import com.kong.duntory.member.model.vo.Member;
import com.kong.duntory.member.model.vo.WishList;

public interface CharSearchDao {

	ArrayList<WishList> selectWishList(Member m);

}
