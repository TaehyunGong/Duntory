package com.kong.duntory.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kong.duntory.member.model.service.MemberService;
import com.kong.duntory.member.model.vo.Member;

@Controller
public class memberController {

	@Autowired
	private MemberService memberservice;

	
	@RequestMapping(value="login.me")
	public String loginMember(Member m){
		
		Member loginUser = memberservice.loginUser(m);
		System.out.println(loginUser);
		return "home";
	}
	
	@RequestMapping(value="join.me")
	public String joinMember(Member m){
		
		System.out.println("가입결과 : " + memberservice.joinUser(m));
		
		return "home";
	}
}
