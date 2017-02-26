package org.wpq.cms.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.wpq.cms.model.Channel;
import org.wpq.cms.model.ChannelTree;
@Repository
public class ChannelDao extends BaseDao<Channel> implements IChannelDao {

	@Override
	public List<ChannelTree> getChannelree() {
		return getSqlSession().selectList(getMethodPath("getChannelTree"));
	}

	@Override
	public List<Channel> listByParentId(int pid) {
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("pid", pid);
		return getSqlSession().selectList(getMethodPath("listByParentId"),map);
	}

	@Override
	public void updateSorts(Integer[] ids) {
		int index = 1;
		Map<String,Integer> map = new HashMap<String, Integer>();
		for(Integer id:ids){
			map.put("id", id);
			map.put("index", index);
			getSqlSession().update("updateSorts",map);
			index++;
		}
	}

	@Override
	public List<Channel> listPublishableChannel() {
		return getSqlSession().selectList(getMethodPath("listPublishableChannel"));
	}


}
