package org.wpq.cms.dao;

import java.util.List;

import org.wpq.cms.model.UserGroup;

public interface IUserGroupDao extends IBaseDao<UserGroup> {
	/**
	 * 根据用户ID删除用户组
	 * @param id
	 */
	public void deleteByUserId(int id);
	/**
	 * 根据userID列表用户所在的组
	 * @param userId
	 * @return
	 */
	public List<UserGroup> listByUserId(int userId);
	/**
	 * 根据组ID列表组中所有用户
	 * @param groupId
	 * @return
	 */
	public List<UserGroup> listByGroupId(int groupId);
	/**
	 * 根据用户ID列表所在组ID
	 * @param userId
	 * @return
	 */
	public List<Integer> listGroupIdByUserId(int userId);
	/**
	 * 通过用户和组ID删除关联表数据 
	 * @param userId
	 * @param groupId
	 */
	public void deleteByUserIdAndGroupId(int userId,int groupId);
	/**
	 * 根据组ID删除关联表数据
	 * @param groupId
	 */
	public void deleteByGroupId(int groupId);
}
