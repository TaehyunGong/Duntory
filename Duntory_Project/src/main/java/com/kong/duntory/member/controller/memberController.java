package com.kong.duntory.member.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kong.duntory.member.model.service.MemberService;
import com.kong.duntory.member.model.vo.Member;
import com.kong.duntory.member.model.vo.WishList;

@Controller
public class memberController {

	@Autowired
	private MemberService memberservice;

	@RequestMapping(value="login.me")
	public void loginMember(Member m, HttpServletRequest req, HttpServletResponse res){
		
		Member loginUser = memberservice.loginUser(m);
		boolean check = false;
		if(loginUser == null){
			check = false;
		}else{
			HttpSession session = req.getSession();
			session.setAttribute("loginUser", loginUser);
			check= true;
		}
		
		try {
			res.getWriter().print(check);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="logout.me")
	public String logoutMember(Member m, HttpServletRequest req){
		
		HttpSession session = req.getSession();
        session.invalidate();  
		
		return "redirect:/";
	}
	
	@RequestMapping(value="joinCheckId.me")
	public void joinCheckId(String userId, HttpServletResponse res){
		
		int check = memberservice.joinCheckId(userId);
		
		try {
			res.getWriter().print(check);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="join.me")
	public String joinMember(Member m, HttpServletRequest req){
		String pwd = m.getUserPwd();
		if(memberservice.joinUser(m) == 1){
			m.setUserPwd(pwd);
			Member loginUser = memberservice.loginUser(m);
			HttpSession session = req.getSession();
			session.setAttribute("loginUser", loginUser);
		}else{
			req.setAttribute("msg", "[회원가입]");
			return "common/Exception";
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value="adventrueEnroll.me")
	public void adventrueEnroll(String id, HttpServletRequest req, HttpServletResponse res){
		
		HttpSession session = req.getSession();
		Member m = (Member)session.getAttribute("loginUser");
		WishList wish = new WishList();
		int result = -1;
		if(m != null){
			wish.setMid(m.getMid());
			wish.setChar_id(id);
			result = memberservice.insertWishList(wish);
		}
		
		try {
			res.getWriter().print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
