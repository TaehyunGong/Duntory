package com.kong.duntory.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kong.duntory.member.model.dao.MemberDao;
import com.kong.duntory.member.model.vo.Member;

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
		System.out.println("encpwd : " + encPassword);
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

}
