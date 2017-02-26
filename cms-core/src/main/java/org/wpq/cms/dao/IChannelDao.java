package org.wpq.cms.dao;


import java.util.List;

import org.wpq.cms.model.Channel;
import org.wpq.cms.model.ChannelTree;
public interface IChannelDao extends IBaseDao<Channel> {
	/**
	 * 获所有的栏目树列表
	 * @return
	 */
	public List<ChannelTree> getChannelree();
	/**
	 * 通过父ID获取子栏目列表
	 * @param pid
	 * @return
	 */
	public List<Channel> listByParentId(int pid);
	/**
	 * 更新排序
	 * @param ids
	 */
	public void updateSorts(Integer[] ids);
	
	/**
	 * 列出可以发布文章的栏目
	 * @return
	 */
	public List<Channel> listPublishableChannel();
}
