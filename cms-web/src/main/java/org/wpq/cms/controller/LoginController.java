package org.wpq.cms.controller;

import java.io.IOException;

import java.io.OutputStream;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wpq.cms.model.Role;
import org.wpq.cms.model.RoleType;
import org.wpq.cms.model.User;
import org.wpq.cms.service.IRoleService;
import org.wpq.cms.service.IUserService;
import org.wpq.common.model.Captcha;

@Controller
public class LoginController {
	@Resource
	private IUserService userService;
	@Resource
	private IRoleService roleService;
	

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username,String password,String validation,HttpSession session,Model model){
		if(!validation.equals(session.getAttribute("checkcode"))){
			model.addAttribute("error","验证码错误");
			return "login";
		}
		User u;
		try {
			u = userService.login(username, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("error","用户名或密码错误");
			return "login";
		}
		if(u.getStatus()==0){
			model.addAttribute("error","用户已被停用");
			return "login";
		}
		setAuth(session, u);
		session.setAttribute("loginUser", u);
		return "redirect:/admin";
	}
	
	@SuppressWarnings("unchecked")
	private void setAuth(HttpSession session,User u){
		Map<String,Set<String>> auths = (Map<String, Set<String>>) session.getServletContext().getAttribute("auth");
		Set<String> auth = auths.get("LOGIN");
		for(Role r:roleService.listRoleByUserId(u.getId())){
			if(r.getRoleType()==RoleType.ADMIN){
				session.setAttribute("isAdmin", 1);
				return;
			}
			auth.addAll(auths.get(r.getRoleType().name()));
		}
		session.setAttribute("isAdmin", 0);
		session.setAttribute("userAuth", auth);
	}
	
	@RequestMapping("/drawCheckCode")
	public void drawCheckCode(HttpServletResponse resp,HttpSession session) throws IOException {
		resp.setContentType("image/jpg");
		int width = 90;
		int height = 25;
		Captcha c = Captcha.getInstance();
		c.set(width, height);
		String checkcode = c.generateCheckcode();
		session.setAttribute("checkcode", checkcode);
		OutputStream os = resp.getOutputStream();
		ImageIO.write(c.generateCheckImg(checkcode), "jpg", os);
	}
}
