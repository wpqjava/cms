package org.wpq.cms.dao;

import java.util.List;

import org.wpq.cms.model.ChannelTree;
import org.wpq.cms.model.GroupChannel;

public interface IGroupChannelDao extends IBaseDao<GroupChannel> {
	/**
	 * 通过组ID列出组栏目关联表对象的ID
	 * @param id
	 * @return
	 */
	public List<Integer> listGroupChannelIdsByGroupId(int id);
	/**
	 * 通过栏目ID列出所在组的ID
	 * @param id
	 * @return
	 */
	public List<Integer> listGroupIdsByChannelId(int id);
	/**
	 * 通过组ID列出组中所有栏目
	 * @param id
	 * @return
	 */
	public List<Integer> listChannelIdsByGroupId(int id);
	/**
	 * 通过组ID获得该组的栏目树
	 * @param id
	 * @return
	 */
	public List<ChannelTree> getGroupChannelTreeByGroupId(int id);
	/**
	 * 通过用户ID获得用户所在组的栏目树
	 * @param id
	 * @return
	 */
	public List<ChannelTree> getGroupChannelTreeByUserId(int id);
	/**
	 * 通过组ID删除组栏目关联
	 * @param id
	 */
	public void deleteByGroupId(int id);
	/**
	 * 通过组ID和栏目ID删除组栏目关联
	 * @param gid
	 * @param cid
	 */
	public void deleteByGroupIdChannelId(int gid,int cid);
}
