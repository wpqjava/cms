package org.wpq.cms.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wpq.cms.auth.AuthClass;
import org.wpq.cms.service.IRoleService;
import org.wpq.cms.service.IUserService;

@Controller
@AuthClass
public class AdminController {
	@Resource
	private IUserService userService;
	@Resource
	private IRoleService roleService;
	
	@RequestMapping("/admin")
	public String index(){
		return "admin/index";
	}
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "login";
	}
	
}
