package com.kong.duntory.member.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kong.duntory.member.model.dao.MemberDao;
import com.kong.duntory.member.model.vo.Member;
import com.kong.duntory.member.model.vo.WishList;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDao Memberdao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	//로그인
	@Override
	public Member loginUser(Member m) {
		
		String encPassword = Memberdao.selectEncPassword(m);	//로그인한 아이디로 해당 유저 암호화된 비번 가져오기
		if(!passwordEncoder.matches(m.getUserPwd(), encPassword)){	//비교
			return null;
		}else{
			return Memberdao.loginUser(m);
		}
		
	}

	@Override
	public int joinUser(Member m) {
		m.setUserPwd(passwordEncoder.encode(m.getUserPwd()));	//회원가입시 암호화
		return Memberdao.insertJoinUser(m);
	}

	//가입시 아이디 중복 체크
	@Override
	public int joinCheckId(String userId) {
		return Memberdao.selectJoinCheckId(userId);
	}

	@Override
	public int insertWishList(WishList wish) {
		
		if(Memberdao.selectWishList(wish) == 0){	//계정에 등록 안된 캐릭이라면 등록
			if(Memberdao.insertWishList(wish) == 1)
				return 1;
		}else{										//등록된 계정이라면 등록 해제
			if(Memberdao.deleteWishList(wish) == 1)
				return 2;
		}
		
		return 0;
	}

	@Override
	public ArrayList<WishList> selectMemberWishList(Member m) {
		return Memberdao.selectMemberWishList(m);
	}

}
