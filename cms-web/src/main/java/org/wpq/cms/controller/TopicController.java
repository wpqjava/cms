package org.wpq.cms.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.wpq.cms.auth.AuthClass;
import org.wpq.cms.auth.AuthMethod;
import org.wpq.cms.dto.AjaxObj;
import org.wpq.cms.dto.TopicDto;
import org.wpq.cms.model.Attachment;
import org.wpq.cms.model.Channel;
import org.wpq.cms.model.ChannelTree;
import org.wpq.cms.model.Topic;
import org.wpq.cms.model.User;
import org.wpq.cms.service.IAttachmentService;
import org.wpq.cms.service.IChannelService;
import org.wpq.cms.service.IKeywordService;
import org.wpq.cms.service.ITopicService;
import org.wpq.cms.web.IIndexService;
import org.wpq.common.util.JacksonUtil;

@Controller
@RequestMapping("/admin/topic")
@AuthClass
public class TopicController {
	@Resource
	private ITopicService topicService;
	@Resource
	private IChannelService channelService;
	@Resource
	private IKeywordService keywordService;
	@Resource
	private IAttachmentService attachmentService;
	@Resource
	private IIndexService indexService;
	
	private final static List<String> imgTypes = Arrays.asList("jpg","jpeg","gif","png");
	
	@RequestMapping("/topics")
	public String list(@RequestParam(required=false) String con,
			@RequestParam(required=false,defaultValue="0") int cid,
			@RequestParam(required=false,defaultValue="-1") int status,Model model,HttpSession session){
		if(((int)session.getAttribute("isAdmin"))==1){
			if(con==null){
				model.addAttribute("pager", topicService.findByCIdStatus(cid, status));
			}else{
				model.addAttribute("pager", topicService.findByConCIdStatus(con, cid, status));
			}
			
		}else{
			int uid = ((User)session.getAttribute("loginUser")).getId();
			if(con==null){
				model.addAttribute("pager", topicService.findByUIdCIdStatus(uid, cid, status));
			}else{
				model.addAttribute("pager", topicService.findByUIdConCIdStatus(uid, con, cid, status));
			}
		}
		model.addAttribute("channels", channelService.listPublishableChannel());
		model.addAttribute("con",con);
		model.addAttribute("cid",cid);
		model.addAttribute("status",status);
		return "admin/topic/list";
	}
	
	@RequestMapping("/updateStatus/{id},{status}")
	@AuthMethod(role="AUDIT")
	public String updateStatus(@PathVariable int id,@PathVariable int status){
		topicService.updateStatus(id, status);
		updateIndex();
		return "redirect:/admin/topic/topics";
	}
	
	@RequestMapping("/delete/{id}")
	@AuthMethod(role="AUDIT")
	public String delete(@PathVariable int id){
		attachmentService.deleteByTopidId(id);
		topicService.delete(id);
		return "redirect:/admin/topic/topics";
	}
	
	@RequestMapping("/add")
	@AuthMethod(role="PUBLISH,AUDIT")
	public String add(Model model){
		model.addAttribute("channels", channelService.listPublishableChannel());
		model.addAttribute(new TopicDto());
		return "admin/topic/add";
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(TopicDto topicDto,String[] aks,Integer[] aids,Integer cid,HttpSession session) {
		Topic t = topicDto.getTopic();
		User u = (User)session.getAttribute("loginUser");
		t.setUser(u);
		t.setAuthor(u.getNickname());
		t.setChannel(new Channel(cid));
		if(aks!=null){
			StringBuilder sb = new StringBuilder();
			for(String str:aks){
				keywordService.add(str);
				sb.append(str).append("|");
			}
			t.setKeyword(sb.toString());
		}
		topicService.add(t, aids);
		return "redirect:/jsp/common/addSuc.jsp";
	}
	
	@RequestMapping("/tree")
	@ResponseBody
	public List<ChannelTree> tree(HttpSession session,Model model){
		int uid = ((User)session.getAttribute("loginUser")).getId();
		return channelService.getChannelTreeByUserId(uid);
	}
	@RequestMapping("/getKeywords")
	@ResponseBody
	public List<String> listKeyword(@RequestParam(required=false) String term){
		return keywordService.listKeywordByCon(term);
	}
	@RequestMapping(value="upload",method=RequestMethod.POST)
	public void upload(MultipartFile attach,HttpServletResponse resp) throws IOException{
		resp.setContentType("text/html;charset=utf-8");
		Attachment a = new Attachment();
		String ext = FilenameUtils.getExtension(attach.getOriginalFilename());
		if(imgTypes.contains(ext.toLowerCase()))a.setIsImg(1);
		a.setNewName(String.valueOf(new Date().getTime())+"."+ext);
		a.setOldName(FilenameUtils.getBaseName(attach.getOriginalFilename())+"."+ext);
		a.setSize(attach.getSize());
		a.setSuffix(ext);
		a.setType(attach.getContentType());
		try {
			attachmentService.add(a, attach.getInputStream());
		} catch (Exception e) {
			System.out.println("error:"+e.getMessage());
			resp.getWriter().write(JacksonUtil.obj2Json(new AjaxObj(0,null,null)));
			return;
		}
		resp.getWriter().write(JacksonUtil.obj2Json(new AjaxObj(1,null,a)));
	}
	
	@RequestMapping("/show/{id}")
	public String show(@PathVariable int id,Model model){
		model.addAttribute(topicService.load(id));
		model.addAttribute("attaches",attachmentService.listByTopicId(id));
		return "admin/topic/show";
	}
	
	@RequestMapping("/update/{id}")
	@AuthMethod(role="PUBLISH,AUDIT")
	public String update(@PathVariable int id,Model model){
		Topic t = topicService.load(id);
		if(t.getKeyword()!=null){
			String[] keys = t.getKeyword().split("\\|");
			model.addAttribute("ekeys", keys);
		}
		model.addAttribute("topic",t);
		model.addAttribute(new TopicDto(t));
		List<Attachment> attaches = attachmentService.listByTopicId(id);
		if(attaches!=null){
			model.addAttribute("attaches",attaches);
		}
		return "admin/topic/update";
	}
	
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	@AuthMethod(role="PUBLISH,AUDIT")
	public String update(@PathVariable int id,TopicDto topicDto,String[] aks,Integer[] aids,Integer cid) {
		//System.out.println(topicDto);
		Topic t = topicDto.getTopic();
		Topic ot = topicService.load(id);
		ot.setChannel(new Channel(cid));
		ot.setContent(t.getContent());
		ot.setPublishDate(t.getPublishDate());
		ot.setRecommend(t.getRecommend());
		ot.setSummary(t.getSummary());
		ot.setTitle(t.getTitle());
		if(aks!=null){
			StringBuilder sb = new StringBuilder();
			for(String str:aks){
				keywordService.add(str);
				sb.append(str).append("|");
			}
			ot.setKeyword(sb.toString());
		}
		topicService.update(ot,aids);
		updateIndex();
		return "redirect:/jsp/common/updateSuc.jsp";
	}
	
	@RequestMapping("/updateIntroPic")
	@ResponseBody
	public AjaxObj updateIntroPic(int aid){
		try {
			attachmentService.updateIntroPic(aid);
		} catch (Exception e) {
			return new AjaxObj(0,e.getMessage());
		}
		return new AjaxObj();
	}
	@RequestMapping("/updateSpePic")
	@ResponseBody
	public AjaxObj updateSpePic(int aid){
		try {
			attachmentService.updateSpePic(aid);
		} catch (Exception e) {
			return new AjaxObj(0,e.getMessage());
		}
		return new AjaxObj();
	}
	@RequestMapping("/updateShowPic")
	@ResponseBody
	public AjaxObj updateShowPic(int aid){
		try {
			attachmentService.updateShowPic(aid);
		} catch (Exception e) {
			return new AjaxObj(0,e.getMessage());
		}
		return new AjaxObj();
	}
	@RequestMapping("/deleteAttach")
	@ResponseBody
	public AjaxObj deleteAttach(int id){
		try {
			attachmentService.delete(id);
		} catch (Exception e) {
			return new AjaxObj(0,e.getMessage());
		}
		return new AjaxObj();
	}
	
	private void updateIndex(){
		indexService.generateNav();
		indexService.generateBody();
	}
}
