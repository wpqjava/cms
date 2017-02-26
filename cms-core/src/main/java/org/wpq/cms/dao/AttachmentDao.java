package org.wpq.cms.dao;




import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.wpq.cms.model.Attachment;
@Repository
public class AttachmentDao extends BaseDao<Attachment> implements IAttachmentDao {

	@Override
	public void updateAttachTopicId(int aid, int tid) {
		Map<String,Object> params = new HashMap<>();
		params.put("id", aid);
		params.put("tid", tid);
		getSqlSession().update(getMethodPath("updateAttachTopicId"),params);
	}

	@Override
	public void deleteByTopicId(int tid) {
		getSqlSession().delete(getMethodPath("deleteByTopicId"),tid);		
	}

	@Override
	public List<Attachment> listByTopicId(int id) {
		return getSqlSession().selectList(getMethodPath("listByTopicId"),id);
	}
	
	@Override
	public List<Integer> listIdByTopicId(int id) {
		return getSqlSession().selectList(getMethodPath("listIdByTopicId"),id);
	}
	
	@Override
	public List<Attachment> listUnusedAtt() {
		return getSqlSession().selectList(getMethodPath("listUnusedAtt"));

	}

	@Override
	public List<Attachment> listIndexAtt(int cid, int max) {
		Map<String,Object> params = new HashMap<>();
		params.put("cid", cid);
		params.put("max",max);
		return getSqlSession().selectList(getMethodPath("listIndexAtt"),params);
	}

	@Override
	public List<Attachment> listChannelShowAtt(int cid, int max) {
		Map<String,Object> params = new HashMap<>();
		params.put("cid", cid);
		params.put("max",max);
		return getSqlSession().selectList(getMethodPath("listChannelShowAtt"),params);
	}

	@Override
	public List<Attachment> listByCon(String con, int max) {
		Map<String,Object> params = new HashMap<>();
		params.put("con","%"+con+"%");
		params.put("max",max);
		return getSqlSession().selectList(getMethodPath("listByCon"),params);
	}
}
