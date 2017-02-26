package org.wpq.cms.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.wpq.cms.model.ChannelTree;
import org.wpq.cms.model.GroupChannel;
@Repository
public class GroupChannelDao extends BaseDao<GroupChannel> implements IGroupChannelDao {

	@Override
	public List<Integer> listGroupChannelIdsByGroupId(int id) {
		return getSqlSession().selectList(getMethodPath("listGroupChannelIdsByGroupId"), id);
	}

	@Override
	public List<ChannelTree> getGroupChannelTreeByGroupId(int id) {
		return getSqlSession().selectList(getMethodPath("getGroupChannelTreeByGroupId"), id);
	}

	@Override
	public List<ChannelTree> getGroupChannelTreeByUserId(int id) {
		return getSqlSession().selectList(getMethodPath("getGroupChannelTreeByUserId"), id);
	}

	@Override
	public void deleteByGroupId(int id) {
		getSqlSession().delete(getMethodPath("deleteByGroupId"), id);
	}

	@Override
	public void deleteByGroupIdChannelId(int gid, int cid) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("gid", gid);
		map.put("cid", cid);
		getSqlSession().delete(getMethodPath("deleteByGroupIdChannelId"), map);
	}

	@Override
	public List<Integer> listGroupIdsByChannelId(int id) {
		return getSqlSession().selectList(getMethodPath("listGroupIdsByChannelId"), id);
	}

	@Override
	public List<Integer> listChannelIdsByGroupId(int id) {
		return getSqlSession().selectList(getMethodPath("listChannelIdsByGroupId"), id);
	}

}
