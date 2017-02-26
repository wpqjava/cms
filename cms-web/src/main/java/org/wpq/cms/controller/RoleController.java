package org.wpq.cms.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wpq.cms.auth.AuthClass;
import org.wpq.cms.auth.AuthMethod;
import org.wpq.cms.service.IRoleService;
import org.wpq.cms.service.IUserService;

@Controller
@RequestMapping("/admin/role")
@AuthClass
public class RoleController {
	@Resource
	private IRoleService roleService;
	@Resource
	private IUserService userService;
	
	@RequestMapping("/roles")
	@AuthMethod
	public String listAll(Model model){
		model.addAttribute("roles", roleService.listAll());
		return "admin/role/list";
	}
	
	@RequestMapping("/show/{id}")
	public String show(@PathVariable int id,Model model){
		model.addAttribute(roleService.load(id));
		model.addAttribute("users", userService.listUserByRoleId(id));
		return "admin/role/show";
	}
}
