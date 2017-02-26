package org.wpq.cms.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wpq.cms.model.SystemContext;
import org.wpq.cms.service.IAttachmentService;
import org.wpq.cms.service.IChannelService;
import org.wpq.cms.service.ITopicService;
import org.wpq.common.util.FreemarkerUtil;

@Service
public class IndexService implements IIndexService{
	@Resource
	private IChannelService channelService;
	@Resource
	private ITopicService topicService;
	@Resource
	private IAttachmentService attachmentService;
	
	@Override
	public void generateNav() {
		Map<String,Object> root = new HashMap<>();
		root.put("album",topicService.listIndexTopicByCid(10,6));
		root.put("news",topicService.listIndexTopicByCid(11,6));
		root.put("gossip", topicService.listIndexTopicByCid(12,6));
		FreemarkerUtil.getInstance("/ftl").filePrint(root, "nav.ftl", SystemContext.getRealPath()+"/WEB-INF/jsp/index/inc/nav.jsp");
	}
	
	@Override
	public void generateBody() {
		Map<String,Object> root = new HashMap<>();
		root.put("intro",attachmentService.listChannelShowAtt(3, 7));
		root.put("special",attachmentService.listChannelShowAtt(4, 4));
		root.put("hotspot", attachmentService.listChannelShowAtt(5, 5));
		root.put("competition", attachmentService.listChannelShowAtt(6,5));
		FreemarkerUtil.getInstance("/ftl").filePrint(root, "body.ftl", SystemContext.getRealPath()+"/WEB-INF/jsp/index/inc/body.jsp");
	}
	
	@Override
	public void generateFoot() {
		Map<String,Object> root = new HashMap<>();
		FreemarkerUtil.getInstance("/ftl").filePrint(root, "foot.ftl", SystemContext.getRealPath()+"/WEB-INF/jsp/index/inc/foot.jsp");
	}
	
}
