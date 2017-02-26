package org.wpq.cms.service;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wpq.cms.dao.IChannelDao;
import org.wpq.cms.dao.IGroupChannelDao;
import org.wpq.cms.model.Channel;
import org.wpq.cms.model.ChannelTree;
import org.wpq.cms.model.CmsException;
import org.wpq.cms.model.Group;
import org.wpq.cms.model.GroupChannel;
@Service
public class ChannelService implements IChannelService{
	@Resource
	private IChannelDao channelDao;
	@Resource
	private IGroupChannelDao groupChannelDao;
	
	@Override
	public void add(Channel channel,int pid) {
		if(pid==0){
			channelDao.add(channel);
		}else{
			channel.setChannel(new Channel(pid));
			channelDao.add(channel);
			List<Integer> parentGroupIds = groupChannelDao.listGroupIdsByChannelId(pid);
			if(parentGroupIds!=null&&parentGroupIds.size()>0){
				for(Integer id :parentGroupIds){
					groupChannelDao.add(new GroupChannel(new Group(id), channel));
				}
			}
		}
	}

	@Override
	public void delete(int id) {
		// TODO 判断栏目内文章
		if(channelDao.listByParentId(id).size()>0){
			throw new CmsException("栏目下还有子栏目不能删除");
		}
		channelDao.delete(id);
	}

	@Override
	public void update(Channel channle) {
		channelDao.update(channle);
	}

	@Override
	public Channel load(int id) {
		return channelDao.load(id);
	}

	@Override
	public List<ChannelTree> getChannelTree() {
		List<ChannelTree> cts = channelDao.getChannelree();
		cts.add(0, new ChannelTree(0,"系统栏目管理",-1));
		return cts;
	}
	@Override
	public List<ChannelTree> getChannelTreeByGroupId(int groupId) {
		List<ChannelTree> cts = groupChannelDao.getGroupChannelTreeByGroupId(groupId);
		cts.add(0, new ChannelTree(0,"系统栏目管理",-1));
		return cts;
	}
	
	@Override
	public List<ChannelTree> getChannelTreeByUserId(int userId) {
		List<ChannelTree> cts = groupChannelDao.getGroupChannelTreeByUserId(userId);
		cts.add(0, new ChannelTree(0,"系统栏目管理",-1));
		return cts;
	}

	@Override
	public List<Channel> listByParentId(int pid) {
		return channelDao.listByParentId(pid);
	}

	@Override
	public void updateSort(Integer[] ids) {
		channelDao.updateSorts(ids);
	}

	@Override
	public List<Integer> listChannelIdsByGroupId(int pid) {
		return groupChannelDao.listChannelIdsByGroupId(pid);
	}

	@Override
	public void addGroupChannel(int gid, int cid) {
		groupChannelDao.add(new GroupChannel(new Group(gid), new Channel(cid)));
	}
	
	@Override
	public void deleteGroupChannel(int gid, int cid) {
		groupChannelDao.deleteByGroupIdChannelId(gid, cid);
	}

	@Override
	public List<Channel> listPublishableChannel() {
		return channelDao.listPublishableChannel();
	}

	@Override
	public List<Channel> listAll() {
		return channelDao.listAll();
	}
}
