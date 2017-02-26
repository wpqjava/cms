package org.wpq.cms.web;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.wpq.cms.auth.AuthUtil;
import org.wpq.cms.service.IChannelService;

public class InitServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static  WebApplicationContext wc;
	@Override
	public void init() throws ServletException {
		super.init();
		wc = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		initIndexChannelPath();
		Map<String,Set<String>> auth = AuthUtil.initAuth("org.wpq.cms.controller");
		this.getServletContext().setAttribute("auth", auth);
		this.getServletContext().setAttribute("baseInfo", BaseInfoUtil.getInstance().read());
		System.out.println("-----------------系统初始化成功------------------------");
	}
	
	public static WebApplicationContext getWc(){
		return wc;
	}
	
	private void initIndexChannelPath(){
		Map<String,Integer> map = new HashMap<>();
		map.put("intro",3);
		map.put("special",4);
		map.put("hotspot",5);
		map.put("competition",6);
		map.put("schedule", 7);
		map.put("teams", 8);
		map.put("racer",9);
		map.put("album",10);
		map.put("news",11);
		map.put("gossip",12);
		this.getServletContext().setAttribute("indexChannelPath", map);
		
	}
	
}
