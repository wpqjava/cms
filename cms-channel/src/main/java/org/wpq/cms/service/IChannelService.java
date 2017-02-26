package org.wpq.cms.service;

import java.util.List;

import org.wpq.cms.model.Channel;
import org.wpq.cms.model.ChannelTree;

public interface IChannelService {
	/**
	 * 添加栏目
	 * @param channel
	 * @param pid
	 */
	public void add(Channel channel,int pid);
	/**
	 * 添加组栏目关联
	 * @param gid
	 * @param cid
	 */
	public void addGroupChannel(int gid,int cid);
	/**
	 * 删除栏目
	 * @param id
	 */
	public void delete(int id);
	/**
	 * 删除组栏目关联
	 * @param gid
	 * @param cid
	 */
	public void deleteGroupChannel(int gid,int cid);
	/**
	 * 更新栏目
	 * @param channle
	 */
	public void update(Channel channle);
	/**
	 * 查询栏目
	 * @param id
	 * @return
	 */
	public Channel load(int id);
	/**
	 * 通过父ID列表栏目
	 * @param pid
	 * @return
	 */
	public List<Channel> listByParentId(int pid);
	/**
	 * 根据组ID列出组中栏目ID
	 * @param pid
	 * @return
	 */
	public List<Integer> listChannelIdsByGroupId(int pid);
	/**
	 * 获得所有的栏目树
	 * @return
	 */
	public List<ChannelTree> getChannelTree();
	/**
	 * 通过组ID获得组中栏目的树
	 * @param groupId
	 * @return
	 */
	public List<ChannelTree> getChannelTreeByGroupId(int groupId);
	/**
	 * 通过用户ID获得用户所在组的栏目树
	 * @param userId
	 * @return
	 */
	public List<ChannelTree> getChannelTreeByUserId(int userId);
	/**
	 * 更新栏目顺序
	 * @param ids
	 */
	public void updateSort(Integer[] ids);
	/**
	 * 列出可以发布文章的栏目
	 * @return
	 */
	public List<Channel> listPublishableChannel();
	/**
	 * 列出所有栏目
	 * @return
	 */
	public List<Channel> listAll();
}
