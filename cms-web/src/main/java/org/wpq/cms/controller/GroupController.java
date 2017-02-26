package org.wpq.cms.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wpq.cms.auth.AuthClass;
import org.wpq.cms.auth.AuthMethod;
import org.wpq.cms.model.Group;
import org.wpq.cms.service.IGroupService;
import org.wpq.cms.service.IUserService;

@Controller
@RequestMapping("/admin/group")
@AuthClass
public class GroupController {
	@Resource
	private IUserService userService;
	@Resource
	private IGroupService groupService;
	
	@RequestMapping("/groups")
	@AuthMethod
	public String listAll(Model model){
		model.addAttribute("groups", groupService.listAll());
		return "admin/group/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	@AuthMethod
	public String add(Model model){
		model.addAttribute(new Group());
		return "admin/group/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@AuthMethod
	public String add(Group group){
		groupService.add(group);
		return "redirect:/admin/group/groups";
	}
	
	@RequestMapping("/delete/{id}")
	@AuthMethod
	public String delete(@PathVariable int id){
		groupService.delete(id);
		return "redirect:/admin/group/groups";
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	@AuthMethod
	public String update(@PathVariable int id,Model model){
		model.addAttribute(groupService.load(id));
		return "admin/group/update";
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	@AuthMethod
	public String update(@PathVariable int id,Group group){
		Group og = groupService.load(id);
		og.setName(group.getName());
		og.setDescri(group.getDescri());
		groupService.update(og);
		return "redirect:/admin/group/groups";
	}
	
	@RequestMapping(value="/show/{id}",method=RequestMethod.GET)
	public String show(@PathVariable int id,Model model){
		model.addAttribute(groupService.load(id));
		model.addAttribute("users", userService.listUserByGroupId(id));
		return "admin/group/show";
	}
}
