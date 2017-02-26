package org.wpq.cms.service;

import java.util.List;
import java.util.Map;

import org.wpq.cms.model.Pager;
import org.wpq.cms.model.User;

public interface IUserService {
	/**
	 * 添加用户
	 * @param user
	 * @param rids 角色ID数组
	 * @param gids 组ID数组
	 */
	public void add(User user,int[] rids,int[] gids);
	/**
	 * 删除用户
	 * @param id
	 */
	public void delete(int id);
	/**
	 * 更新用户
	 * @param user
	 * @param rids 新的角色ID数组
	 * @param gids 新的组ID数组
	 */
	public void update(User user,int[] rids,int[] gids);
	/**
	 * 只更新用户的基本数据,不包括组、角色、密码
	 * @param user
	 */
	public void updateOnlyUser(User user);
	/**
	 * 只更新密码
	 * @param user
	 */
	public void updatePassword(User user);
	/**
	 * 更新用户状态
	 * @param userId
	 * @param status
	 */
	public void updateStatus(int userId,int status);
	/**
	 * 查询用户
	 * @param id
	 * @return
	 */
	public User load(int id);
	/**
	 * 通过condition查找用户分页对象(请先通过SystemContext设定pageOffset,pageSize,order的值)
	 * @param condition
	 * @return
	 */
	public Pager<User> findUsers(String condition);
	/**
	 * 无条件查询用户分页对象
	 * @return
	 */
	public Pager<User> findUsers();
	/**
	 * 通过UserId返回该用户的所在组以及角色用MAP存储
	 * @param id
	 * @return
	 */
	public Map<String,int[]> listUserRoleIdsAndGroupIds(int id);
	public Map<String,String> listUserRoleNamesAndGroupNames(int id);
	/**
	 * 通过组ID列出用户
	 * @param gourpId
	 * @return
	 */
	public List<User> listUserByGroupId(int groupId);
	/**
	 * 通过角色ID列出用户
	 * @param gourpId
	 * @return
	 */
	public List<User> listUserByRoleId(int roleId);
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username,String password);
}
