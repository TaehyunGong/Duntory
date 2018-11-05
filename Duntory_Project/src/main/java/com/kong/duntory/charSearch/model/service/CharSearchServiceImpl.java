package com.kong.duntory.charSearch.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kong.duntory.charSearch.model.dao.CharSearchDao;
import com.kong.duntory.member.model.vo.Member;
import com.kong.duntory.member.model.vo.WishList;

@Service
public class CharSearchServiceImpl implements CharSearchService {

	@Autowired
	CharSearchDao charSearchDao;

	@Override
	public ArrayList<WishList> selectWishList(Member m) {
		return charSearchDao.selectWishList(m);
	}
	
}
