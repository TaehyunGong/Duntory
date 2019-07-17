package com.kong.duntory.charSearch.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.kong.duntory.charSearch.model.service.CharSearchService;
import com.kong.duntory.charSearch.model.vo.charSearch;
import com.kong.duntory.charSearch.model.vo.equipmentDetail;
import com.kong.duntory.member.model.vo.Member;
import com.kong.duntory.member.model.vo.WishList;

@Controller
public class charSearchController {

	@Autowired
	private CharSearchService charSearchService;
	
	private final String APIKEY = "**********";
	
	@RequestMapping(value="charSearchForward.search")
	public String charSearchForward(){
		return "search/CharactersSearch";
	}
	
	@RequestMapping(value="searchChar.search")
	public void searchChar(String search, String server, String level, HttpServletRequest req, HttpServletResponse res){
		String[] servers = server.split(",");
		String result = "";
		ArrayList<charSearch> allList = new ArrayList<charSearch>();
		Gson gson = new Gson();
		String wordType = "full";
		if(search.length() == 1) wordType="match";
		for(int i=0 ; i<servers.length; i++){
			try{
				URL url = new URL("https://api.neople.co.kr/df/servers/" + servers[i] + "/characters?characterName=" + URLEncoder.encode(search, "UTF-8") + "&wordType=" + wordType +"&apikey="+APIKEY);
				
				HttpURLConnection connection = (HttpURLConnection) url
						.openConnection();
				connection.setRequestMethod("GET");
				
				InputStream is = connection.getInputStream();
				
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				String readLine = null;
				while ((readLine = br.readLine()) != null) {
					result = readLine;
				}
				
				JsonObject job = gson.fromJson(result, JsonObject.class);
				JsonArray jsonArray = job.getAsJsonArray("rows");
				
				charSearch[] list = gson.fromJson(jsonArray, charSearch[].class);
				for(int n=0; n<list.length;n++){
					if(level.equals("0")){
						list[n].setServer(servers[i]);
						allList.add(list[n]);
					}else{
						if(list[n].getLevel().equals(level)){
							list[n].setServer(servers[i]);
							allList.add(list[n]);
						}
					}
				}
				
				br.close();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//---- 모험단 리스트 가져오기
		
		HttpSession session = req.getSession();
		Member m = (Member)session.getAttribute("loginUser");
		if(m != null){
			ArrayList<WishList> wishList = charSearchService.selectWishList(m);
			for(int i=0; i<allList.size(); i++){
				for(int n=0; n<wishList.size(); n++){
					if(allList.get(i).getCharacterId().equals(wishList.get(n).getChar_id()))
						allList.get(i).setWishList("Y");
				}
			}
		}
		
		res.setCharacterEncoding("UTF-8");
		try {
			res.getWriter().print(gson.toJson(allList));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="charDetail.search")
	public void charDetail(String id, String server, HttpServletResponse res){
		Gson gson = new Gson();
		String result = "";
		
		try{
			
			URL url = new URL("https://api.neople.co.kr/df/servers/" + server + "/characters/" + id + "/equip/equipment?apikey="+APIKEY);
			
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			
			InputStream is = connection.getInputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String readLine = null;
			while ((readLine = br.readLine()) != null) {
				result = readLine;
			}
			
			equipmentDetail equip = gson.fromJson(result, equipmentDetail.class);
			System.out.println(equip);
			
			br.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			res.getWriter().print("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
