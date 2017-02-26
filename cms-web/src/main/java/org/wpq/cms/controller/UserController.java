package org.wpq.cms.controller;

import java.security.NoSuchAlgorithmException;

import java.util.Map;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wpq.cms.auth.AuthClass;
import org.wpq.cms.auth.AuthMethod;
import org.wpq.cms.model.User;
import org.wpq.cms.dto.PasswordDto;
import org.wpq.cms.dto.UserDto;
import org.wpq.common.util.SecuriyUtil;
import org.wpq.cms.service.IGroupService;
import org.wpq.cms.service.IRoleService;
import org.wpq.cms.service.IUserService;

@Controller
@RequestMapping("/admin/user")
@AuthClass
public class UserController {
	@Resource
	private IUserService userService;
	@Resource
	private IRoleService roleService;
	@Resource
	private IGroupService groupService;

	@RequestMapping("/users")
	@AuthMethod
	public String listAll(Model model) {
		model.addAttribute("datas", userService.findUsers());
		return "admin/user/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@AuthMethod
	public String add(Model model) {
		model.addAttribute(new UserDto());
		initRolesAndGroups(model);
		return "admin/user/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@AuthMethod
	public String add(@Validated UserDto userDto, BindingResult br, Model model) {
		// validate插件实现验证
		/*
		 * if(br.hasErrors()){ initRolesAndGroups(model); return
		 * "admin/user/add"; }
		 */
		userService.add(userDto.getUser(), userDto.getRoleIds(), userDto.getGroupIds());
		return "redirect:/admin/user/users";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	@AuthMethod
	public String update(@PathVariable int id,Model model) {
		Map<String, int[]> map = userService.listUserRoleIdsAndGroupIds(id);
		model.addAttribute(new UserDto(userService.load(id),map.get("groupIds"),map.get("roleIds")));
		initRolesAndGroups(model);
		return "admin/user/update";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	@AuthMethod
	public String update(@PathVariable int id, UserDto userDto, Model model) {
		User ou = userService.load(id);
		ou.setNickname(userDto.getNickname());
		ou.setPassword(userDto.getPassword());
		ou.setPhone(userDto.getPhone());
		ou.setEmail(userDto.getEmail());
		userService.update(ou, userDto.getRoleIds(), userDto.getGroupIds());
		return "redirect:/admin/user/users";
	}
	@RequestMapping(value = "/updateSelf/{id}", method = RequestMethod.GET)
	public String updateSelf(@PathVariable int id,Model model) {
		model.addAttribute(userService.load(id));
		return "admin/user/updateSelf";
	}

	@RequestMapping(value = "/updateSelf/{id}", method = RequestMethod.POST)
	public String updateSelf(@PathVariable int id, User user, Model model) {
		User ou = userService.load(id);
		ou.setNickname(user.getNickname());
		ou.setPhone(user.getPhone());
		ou.setEmail(user.getEmail());
		userService.updateOnlyUser(user);
		return "redirect:/admin/user/show/"+id;
	}
	
	@RequestMapping(value = "/updatePassword/{id}", method = RequestMethod.GET)
	public String updatePassword(@PathVariable int id,Model model) {
		model.addAttribute(new PasswordDto());
		return "admin/user/updatePassword";
	}

	@RequestMapping(value = "/updatePassword/{id}", method = RequestMethod.POST)
	public String updatePassword(@PathVariable int id,PasswordDto pd, Model model) {
		User ou = userService.load(id);
		try {
			if(!ou.getPassword().equals(SecuriyUtil.md5(pd.getOpassword()))){
				model.addAttribute("error", "密码错误");
				return "admin/user/updatePassword";
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ou.setPassword(pd.getPassword());
		userService.updatePassword(ou);
		return "redirect:/admin/user/users";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@AuthMethod
	public String delete(@PathVariable int id) {
		userService.delete(id);
		return "redirect:/admin/user/users";
	}

	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable int id, Model model) {
		Map<String, String> map = userService.listUserRoleNamesAndGroupNames(id);
		model.addAttribute(new UserDto(userService.load(id), map.get("groupNames"), map.get("roleNames")));
		initRolesAndGroups(model);
		return "admin/user/show";
	}

	@RequestMapping(value = "/updateStatus/{id},{status}", method = RequestMethod.GET)
	@AuthMethod
	public String updateStatus(@PathVariable int id, @PathVariable int status, Model model) {
		userService.updateStatus(id, status);
		return "redirect:/admin/user/users";
	}

	private void initRolesAndGroups(Model model) {
		model.addAttribute("roles", roleService.listAll());
		model.addAttribute("groups", groupService.listAll());
	}
}
