package com.kong.duntory.charSearch.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kong.duntory.charSearch.model.vo.charSearch;

@Controller
public class charSearchController {

	private final String APIKEY = "P4GiGs1KtJyD3VoMB3jkgzDsMI4tDNGi";
	
	@RequestMapping(value="charSearchForward.search")
	public String charSearchForward(){
		return "search/CharactersSearch";
	}
	
	
	@RequestMapping(value="searchChar.search")
	public void searchChar(String search, String server, HttpServletResponse res){
		
		String[] servers = server.split(",");
		String result = "";
		ArrayList<charSearch> allList = new ArrayList<charSearch>();
		Gson gson = new Gson();
		
		for(int i=0 ; i<servers.length; i++){
			
			try{
				URL url = new URL("https://api.neople.co.kr/df/servers/" + servers[i] + "/characters?characterName=" + URLEncoder.encode(search, "UTF-8") + "&wordType=full&apikey="+APIKEY);
				
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
					list[n].setServer(servers[i]);
					allList.add(list[n]);
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
		
		res.setCharacterEncoding("UTF-8");
		try {
			res.getWriter().print(gson.toJson(allList));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
