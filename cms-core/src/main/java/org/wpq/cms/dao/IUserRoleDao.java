package org.wpq.cms.dao;

import java.util.List;

import org.wpq.cms.model.UserRole;

public interface IUserRoleDao extends IBaseDao<UserRole> {
	/**
	 * 根据userID列表用户所在的组
	 * @param userId
	 * @return
	 */
	public List<UserRole> listByUserId(int userId);
	/**
	 * 根据组ID列表组中所有用户
	 * @param groupId
	 * @return
	 */
	public List<UserRole> listByRoleId(int roleId);
	/**
	 * 根据用户ID删除用户角色关联
	 * @param id
	 */
	public void deleteByUserId(int id);
	/**
	 * 通过用户id列表角色id
	 * @param userId
	 * @return
	 */
	public List<Integer> listRoleIdByUserId(int userId);
	/**
	 * 通过用户和角色ID删除关联表数据
	 * @param userId
	 * @param roleId
	 */
	public void deleteByUserIdAndRoleId(int userId,int roleId);
}
