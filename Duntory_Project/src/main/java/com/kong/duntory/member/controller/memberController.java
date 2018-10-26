package com.kong.duntory.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kong.duntory.member.model.vo.Member;

@Controller
public class memberController {

	
	@RequestMapping(value="login.me")
	public String loginMember(Member m){
		System.out.println(m);
		return "home";
	}
}
