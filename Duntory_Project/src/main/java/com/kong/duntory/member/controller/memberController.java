package com.kong.duntory.member.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kong.duntory.charSearch.model.vo.charSearch;
import com.kong.duntory.member.model.service.MemberService;
import com.kong.duntory.member.model.vo.Member;
import com.kong.duntory.member.model.vo.TimeLineRaid;
import com.kong.duntory.member.model.vo.WishList;
import com.kong.duntory.member.model.vo.rows;

@Controller
public class memberController {

	@Autowired
	private MemberService memberservice;

	private final String APIKEY = "P4GiGs1KtJyD3VoMB3jkgzDsMI4tDNGi";
	
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
	public void adventrueEnroll(String id, String server, HttpServletRequest req, HttpServletResponse res){
		
		HttpSession session = req.getSession();
		Member m = (Member)session.getAttribute("loginUser");
		WishList wish = new WishList();
		int result = -1;
		if(m != null){
			wish.setMid(m.getMid());
			wish.setChar_id(id);
			wish.setServer(server);
			result = memberservice.insertWishList(wish);
		}
		
		try {
			res.getWriter().print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="myPageForward.me")
	public String myPageForward(HttpServletRequest req){
		
		HttpSession session = req.getSession();
		Member m = (Member)session.getAttribute("loginUser");
		Gson gson = new Gson();
		String result = "";
		ArrayList<TimeLineRaid> adventureTeam = new ArrayList<TimeLineRaid>(); 
		
		int fatality = 0;			//숙명의 의지
		int Immortal = 0;			//불멸의 의지
		
		//세션에 유저가있는지 확인
		if(m == null){
			req.setAttribute("msg", "마이페이지");
			return "common/Exception";
		}
		
		// ---- 모험단의 타임라인 정보 가져오기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmm");
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int dayNum = cal.get(Calendar.DAY_OF_WEEK) ;
		
		if(dayNum < 5){			//일, 월, 화, 수
			dayNum += 2;
			cal.add(Calendar.DATE, -dayNum);
		}else if(dayNum > 5){	//금, 토
			dayNum -= 5;
			cal.add(Calendar.DATE, -dayNum);
		}
		
		String startDate = sdf.format(cal.getTime()).substring(0,8).concat("T0600");		// end
		String endDate = sdf.format(new Date()).replace("-", "T");		//타임라인 시간 start ~
		
		ArrayList<WishList> wishList = memberservice.selectMemberWishList(m);
		
		for(int i=0; i<wishList.size(); i++){
			
			try{
				URL url = new URL("https://api.neople.co.kr/df/servers/" + wishList.get(i).getServer() +"/characters/" + wishList.get(i).getChar_id() + "/timeline?startDate=" + startDate + "&endDate=" + endDate + "&code=201,206,207&apikey="+APIKEY);
				
				HttpURLConnection connection = (HttpURLConnection) url
						.openConnection();
				connection.setRequestMethod("GET");
				
				InputStream is = connection.getInputStream();
				
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				String readLine = null;
				while ((readLine = br.readLine()) != null) {
					result = readLine;
				}
				
				TimeLineRaid charInfo = new Gson().fromJson(result, TimeLineRaid.class);
				
				adventureTeam.add(charInfo);
				br.close();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//---------- 레이드 횟수 계산
		int num = 0;
		for(TimeLineRaid time : adventureTeam){
			time.setServer(wishList.get(num).getServer()); num+=1;
			
			for(rows row : time.getTimeLine().getRowsList()){
				
				switch(row.getName()){
					case "레이드" :		//안톤 or 루크 
							if(row.getData().getRaidName().equals("안톤")){
								if(row.getData().getSingle().equals("true")){	//싱글
									time.setSingleAntonRaid(time.getSingleAntonRaid()+1); fatality += 60; break;
								}else{
									if(row.getData().getPhaseName().equals("토벌")){
										time.setAntonRaid(time.getAntonRaid()+1); fatality += 75; break;
									}
								}
							}else{		//루크레이드
								if(row.getData().getSingle().equals("true")){	//싱글
									time.setSingleLukeRaid(time.getSingleLukeRaid()+1); fatality += 80; break;
								}else{
									if(row.getData().getPhaseName().equals("초월의 성전")){
										if(row.getData().getHard().equals("true")){
											time.setHardLukeRaid(time.getHardLukeRaid()+1); fatality += 100; Immortal += 100; break;
										}else{
											time.setLukeRaid(time.getLukeRaid()+1); fatality +=100; Immortal += 100; break;
										}
									}
								}
							}
						break;
					case "핀드워 클리어" : 
							time.setFiendWar(time.getFiendWar()+1); fatality += 125; Immortal += 125;
						break;
					case "마수던전 토벌" :
							time.setMasuDungeon(time.getMasuDungeon()+1); break;
					default:
						break;
				}
			
			}
			
		}
		
		//--------------------------------------------------
		req.setAttribute("adventureTeam", adventureTeam);
		req.setAttribute("startDate", startDate);
		req.setAttribute("endDate", endDate);
		req.setAttribute("Immortal", Immortal);
		req.setAttribute("fatality", fatality);
		
		return "member/myPage";
	}
}
