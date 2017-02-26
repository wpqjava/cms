package org.wpq.cms.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wpq.cms.dao.IAttachmentDao;
import org.wpq.cms.dao.ITopicDao;
import org.wpq.cms.model.Pager;
import org.wpq.cms.model.Topic;
import org.wpq.common.util.ServiceUtil;
@Service
public class TopicService implements ITopicService {
	@Resource
	private ITopicDao topicDao;
	@Resource
	private IAttachmentDao attachmentDao;
	

	@Override
	public Pager<Topic> findByUIdConCIdStatus(int uid, String con, int cid, int status) {
		return topicDao.findByUserIdConCIdStatus(uid, con, cid, status);
	}

	@Override
	public Pager<Topic> findByUIdCIdStatus(int uid, int cid, int status) {
		return findByUIdConCIdStatus(uid, null, cid, status);
	}

	@Override
	public Pager<Topic> findByConCIdStatus(String con, int cid, int status) {
		return findByUIdConCIdStatus(0, con, cid, status);
	}

	@Override
	public Pager<Topic> findByCIdStatus(int cid, int status) {
		return findByConCIdStatus(null, cid, status);
	}

	@Override
	public void updateStatus(int id, int status) {
		int ns = status;
		if(status==0)ns = 1;
		if(status==1)ns = 0;
		topicDao.updateStatus(id, ns);
	}
	
	@Override
	public void delete(int id) {
		attachmentDao.deleteByTopicId(id);
		topicDao.delete(id);
	}
	
	@Override
	public void add(Topic topic, Integer[] aids) {
		topicDao.add(topic);
		if(aids!=null){
			for(Integer i:aids){
				attachmentDao.updateAttachTopicId(i, topic.getId());
			}
		}
	}
	
	@Override
	public Topic load(int id) {
		return topicDao.load(id);
	}
	
	@Override
	public void update(Topic t, Integer[] aids) {
		int tid = t.getId();
		//处理附件ID
		if(aids!=null){
			List<Integer> existIds = attachmentDao.listIdByTopicId(tid);
			List<Integer> needDeleteIds = ServiceUtil.needDeleteId(existIds, ServiceUtil.ArrayToList(aids));
			List<Integer> needAddIds = ServiceUtil.needAddId(existIds, ServiceUtil.ArrayToList(aids));
			for(Integer i:needDeleteIds){
				attachmentDao.delete(i);
			}
			for(Integer i:needAddIds){
				attachmentDao.updateAttachTopicId(i, tid);
			}
		}else{
			attachmentDao.deleteByTopicId(tid);
		}
		topicDao.update(t);
	}

	@Override
	public List<Topic> listIndexTopicByCid(int id,int max) {
		return topicDao.listIndexTopicByCid(id,max);
	}

}
