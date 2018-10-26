package com.kong.duntory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		BufferedReader in = null;
		String json = "";
		String nick="체원";
		try {
			nick = URLEncoder.encode(nick, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try 
		{ 
			URL obj = new URL("https://api.neople.co.kr/df/servers/bakal/characters?characterName="+ nick +"&apikey=P4GiGs1KtJyD3VoMB3jkgzDsMI4tDNGi");
			// 호출할 url 
			HttpURLConnection con = (HttpURLConnection)obj.openConnection(); 
			con.setRequestMethod("GET"); 
			in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8")); 
			String line; 
			while((line = in.readLine()) != null) 
			{ 
				json += line;
			}
		} 
		catch(Exception e) 
		{ 
			e.printStackTrace(); 
			} 
		finally 
		{ 
			if(in != null){
				try {
					in.close(); 
				} 
				catch(Exception e) 
				{ 
					e.printStackTrace(); 
				} 
			}
		}
		System.out.println("결과 : " + json);
		model.addAttribute("server", json);
		
		return "home";
	}
	
}
