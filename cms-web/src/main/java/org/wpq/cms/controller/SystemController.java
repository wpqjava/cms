package org.wpq.cms.controller;



import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wpq.cms.auth.AuthClass;
import org.wpq.cms.model.Attachment;
import org.wpq.cms.model.BaseInfo;
import org.wpq.cms.service.IAttachmentService;
import org.wpq.cms.web.BaseInfoUtil;

@Controller
@RequestMapping("/admin/system")
@AuthClass("ADMIN")
public class SystemController {
	@Resource
	private IAttachmentService attachmentService;
	
	@RequestMapping("/show")
	public String show(){
		return "admin/system/show";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(Model model){
		model.addAttribute("baseInfo",BaseInfoUtil.getInstance().read());
		return "admin/system/update";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(BaseInfo bi,HttpSession session){
		session.getServletContext().removeAttribute("baseInfo");
		session.getServletContext().setAttribute("baseInfo", bi);
		BaseInfoUtil.getInstance().write(bi);
		return "redirect:/admin/system/show";
	}
	
	@RequestMapping("/clean")
	public String clean(Model model){
		model.addAttribute("unusedAtts", attachmentService.listUnusedAtt().size());
		return "admin/system/clean";
	}
	
	@RequestMapping("/showGabage")
	public String showGabage(Model model){
		System.out.println(attachmentService.listUnusedAtt());
		model.addAttribute("gabages", attachmentService.listUnusedAtt());
		return "admin/system/gabageList";
	}
	
	@RequestMapping("/clearGabage")
	public String clear(Model model){
		for(Attachment a :attachmentService.listUnusedAtt()){
			attachmentService.delete(a.getId());
		}
		return "redirect:/admin/system/clean";
	}
}
