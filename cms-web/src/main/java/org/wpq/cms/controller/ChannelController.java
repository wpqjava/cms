package org.wpq.cms.controller;

import java.util.List;




import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wpq.cms.auth.AuthClass;
import org.wpq.cms.auth.AuthMethod;
import org.wpq.cms.model.Channel;
import org.wpq.cms.model.ChannelTree;
import org.wpq.cms.model.ChannelType;
import org.wpq.cms.service.IChannelService;
import org.wpq.cms.service.IGroupService;
import org.wpq.cms.service.IUserService;
import org.wpq.cms.dto.AjaxObj;
import org.wpq.common.util.EnumUtil;

@Controller
@RequestMapping("/admin/channel")
@AuthClass
public class ChannelController {
	@Resource
	private IChannelService channelService;
	@Resource
	private IGroupService groupService;
	@Resource
	private IUserService userService;
	/**
	 * 同步加载树
	 */
	@RequestMapping("/channels")
	@AuthMethod
	public String list(Model model){
		//model.addAttribute("treeDatas", JacksonUtil.obj2Json(channelService.getChannelTree()));
		return "admin/channel/list";
	}
	
	/**
	 * 异步加载树
	 */
	@RequestMapping("/treeAll")
	public @ResponseBody List<ChannelTree> list(){
		return channelService.getChannelTree();
	}
	
	@RequestMapping("/groupChannelTree/{gid}")
	@ResponseBody
	public List<ChannelTree> getGroupChannelTree(@PathVariable int gid){
		return channelService.getChannelTreeByGroupId(gid);
	}
	
	@RequestMapping("/userChannelTree/{uid}")
	@ResponseBody
	public List<ChannelTree> getUserChannelTree(@PathVariable int uid){
		return channelService.getChannelTreeByUserId(uid);
	}

	@RequestMapping("/channels/{id}")
	@AuthMethod
	public String list(@PathVariable int id,@RequestParam(value="refresh", required=false, defaultValue="0") int refresh,Model model){
		if(refresh==0){
			model.addAttribute("refresh",0);
		}else{
			model.addAttribute("refresh",1);
		}
		model.addAttribute("pid", id);
		List<Channel> ls = channelService.listByParentId(id);
		if(ls.size()<1&&id!=0){
			model.addAttribute("channel", channelService.load(id));
			return "admin/channel/show";
		}
		model.addAttribute("childChannels", ls);
		return "admin/channel/list_child";
	}
	
	@RequestMapping(value="/add/{pid}",method=RequestMethod.GET)
	@AuthMethod
	public String add(@PathVariable Integer pid,Model model){
		Channel parentChannel;
		if(pid==null) pid = 0;
		if(pid==0){
			parentChannel = new Channel();
			parentChannel.setId(0);
			parentChannel.setName("系统栏目管理");
		}else {
			parentChannel = channelService.load(pid);
		}
		model.addAttribute("parentChannel", parentChannel);
		model.addAttribute(new Channel());
		model.addAttribute("types", EnumUtil.Enum2PropNameMap(ChannelType.class, "name"));
		return "admin/channel/add";
	}
	
	@RequestMapping(value="/add/{pid}",method=RequestMethod.POST)
	@AuthMethod
	public String add(@PathVariable Integer pid,Channel channel,Model model){
		channelService.add(channel, pid);
		return "redirect:/admin/channel/channels/"+pid+"?refresh=1";
	}
	
	@RequestMapping("/delete/{pid},{id}")
	@AuthMethod
	public String delete(@PathVariable int pid,@PathVariable int id){
		channelService.delete(id);
		return "redirect:/admin/channel/channels/"+pid;
	}
	
	@RequestMapping(value="/update/{pid},{id}",method=RequestMethod.GET)
	@AuthMethod
	public String update(@PathVariable Integer pid,@PathVariable int id,Model model){
		Channel channel = channelService.load(id);
		model.addAttribute("channel", channel);
		model.addAttribute("types", EnumUtil.Enum2PropNameMap(ChannelType.class, "name"));
		return "admin/channel/update";
	}
	
	@RequestMapping(value="/update/{pid},{id}",method=RequestMethod.POST)
	@AuthMethod
	public String update(@PathVariable Integer pid,@PathVariable int id,Channel channel,Model model){
		Channel oc = channelService.load(id);
		oc.setName(channel.getName());
		oc.setChannelType(channel.getChannelType());
		oc.setCustomLink(channel.getCustomLink());
		oc.setCustomLinkUrl(channel.getCustomLinkUrl());
		oc.setIsNav(channel.getIsNav());
		oc.setIsRecommend(channel.getIsRecommend());
		oc.setIsTopIntro(channel.getIsTopIntro());
		oc.setOrders(channel.getOrders());
		oc.setStatus(channel.getStatus());
		channelService.update(oc);
		return "redirect:/admin/channel/channels/"+pid+"?refresh=1";
	}
	
	@RequestMapping("/channels/updateSorts")
	@AuthMethod
	public @ResponseBody AjaxObj updateSorts(@RequestParam Integer[] ids){
		try {
			channelService.updateSort(ids);
		} catch (Exception e) {
			return new AjaxObj(0, "发生错误");
		}
		return new AjaxObj(1);
	}
	
	@RequestMapping("/groupChannels/{gid}")
	public String listGroupChannel(@PathVariable int gid,Model model){
		model.addAttribute("group", groupService.load(gid));
		return "admin/group/channels";
	}
	
	@RequestMapping("/userChannels/{uid}")
	public String listUserChannel(@PathVariable int uid,Model model){
		model.addAttribute("user", userService.load(uid));
		return "admin/user/channels";
	}
	
	@RequestMapping("/setChannels/{gid}")
	@AuthMethod
	public String setGroupChannel(@PathVariable int gid,Model model){
		model.addAttribute("group", groupService.load(gid));
		model.addAttribute("cids", channelService.listChannelIdsByGroupId(gid));
		return "admin/group/setChannels";
	}
	@RequestMapping("/deleteGroupChannel")
	@ResponseBody
	public AjaxObj deleteGroupChannel(int gid,int cid){
		try {
			channelService.deleteGroupChannel(gid, cid);
		} catch (Exception e) {
			return new AjaxObj(0,e.getMessage());
		}
		return new AjaxObj();
	}
	
	@RequestMapping("/addGroupChannel")
	@ResponseBody
	public AjaxObj addGroupChannel(int gid,int cid){
		try {
			channelService.addGroupChannel(gid, cid);
		} catch (Exception e) {
			return new AjaxObj(0,e.getMessage());
		}
		return new AjaxObj();
	}
}
