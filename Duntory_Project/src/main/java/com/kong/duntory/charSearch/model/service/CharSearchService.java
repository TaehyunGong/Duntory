package com.kong.duntory.charSearch.model.service;

import java.util.ArrayList;

import com.kong.duntory.member.model.vo.Member;
import com.kong.duntory.member.model.vo.WishList;

public interface CharSearchService {

	ArrayList<WishList> selectWishList(Member m);

}
