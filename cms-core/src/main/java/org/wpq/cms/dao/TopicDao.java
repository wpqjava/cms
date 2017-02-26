package org.wpq.cms.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.wpq.cms.model.Pager;
import org.wpq.cms.model.SystemContext;
import org.wpq.cms.model.Topic;
@Repository
public class TopicDao extends BaseDao<Topic> implements ITopicDao {

	private Map<String,Object> initParamMap(){
		Map<String,Object> params = new HashMap<>();
		params.put("pageOffset", SystemContext.getPageOffset());
		params.put("pageSize", SystemContext.getPageSize());
		return params;
	}
	
	private Pager<Topic> initPager(){
		Pager<Topic> pager = new Pager<>();
		pager.setPageOffset(SystemContext.getPageOffset());
		pager.setPageSize(SystemContext.getPageSize());
		return pager;
	}

	@Override
	public Pager<Topic> findByUserIdConCIdStatus(int uid, String con, int cid, int status) {
		Pager<Topic> pager = initPager();
		Map<String,Object> params = initParamMap();
		if(con!=null)params.put("con", "%"+con+"%");
		if(cid!=0)params.put("cid", cid);
		if(uid!=0)params.put("uid", uid);
		if(status!=-1)params.put("status", status);
		pager.setDatas(getSqlSession().selectList(getMethodPath("findByUserIdConCIdStatus"), params));
		pager.setTotalRecord(getSqlSession().selectOne(getMethodPath("countByUserIdConCIdStatus"), params));
		return pager;
	}

	@Override
	public void updateStatus(int id, int status) {
		Map<String,Object> params = new HashMap<>();
		params.put("id", id);
		params.put("status", status);
		getSqlSession().update(getMethodPath("updateStatus"), params);
	}

	@Override
	public List<Topic> listIndexTopicByCid(int id,int maxRecord) {
		Map<String,Object> params = new HashMap<>();
		params.put("id", id);
		params.put("max", maxRecord);
		return getSqlSession().selectList(getMethodPath("listIndexTopicByCid"), params);
	}

}
