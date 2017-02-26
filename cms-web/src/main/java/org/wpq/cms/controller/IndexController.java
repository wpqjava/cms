package org.wpq.cms.controller;

import java.util.Map;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wpq.cms.model.Topic;
import org.wpq.cms.service.IAttachmentService;
import org.wpq.cms.service.ITopicService;

@Controller
public class IndexController {
	@Resource
	private IAttachmentService attachmentService;
	@Resource
	private ITopicService topicService;
	
	@RequestMapping("/")
	public String index(){
		return "index/index";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/{cname}")
	public String index(@PathVariable String cname,HttpSession session,Model model){
		if(cname.equals("index"))return "redirect:/";
		Map<String,Integer> icm = (Map<String, Integer>) session.getServletContext().getAttribute("indexChannelPath");
		model.addAttribute("isList", 1);
		try {
			model.addAttribute("datas", attachmentService.listChannelShowAtt(icm.get(cname),15));
		} catch (NullPointerException e) {
		}
		
		return "index/channel/"+cname;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/{cname}/{id}")
	public String show(@PathVariable String cname,@PathVariable int id,HttpSession session,Model model){
		Map<String,Integer> icm = (Map<String, Integer>) session.getServletContext().getAttribute("indexChannelPath");
		model.addAttribute("isList", 0);
		Topic t = topicService.load(id);
		if(t.getChannel().getId()==icm.get("album")){
			model.addAttribute("isAlbum", 1);
			model.addAttribute("pics",attachmentService.listByTopicId(id));
		}else{
			model.addAttribute("topic", t);
		}
		if(icm.keySet().contains(cname)){
			return "index/channel/"+cname;
		}else{
			return "index/channel/topic";
		}
	}
	@RequestMapping("/search/{key}")
	public String search(@PathVariable String key,Model model){
		model.addAttribute("isList", 1);
		model.addAttribute("datas", attachmentService.listByCon(key));
		return "index/channel/search";
	}
}
