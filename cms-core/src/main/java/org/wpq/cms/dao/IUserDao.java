package org.wpq.cms.dao;

import java.util.Map;

import org.wpq.cms.model.Pager;
import org.wpq.cms.model.User;

public interface IUserDao extends IBaseDao<User> {
	/**
	 * 获得User的分页对象
	 * @param params中必须有pageOffset,pageSize;可有可无order,condition(在service层传入)
	 * @return
	 */
	public Pager<User> find(Map<String,Object> params);
	/**
	 * 计算分页总条数
	 * @param params
	 * @return
	 */
	public long findCount(Map<String,Object> params);
	/**
	 * 通过用户名查找用户
	 * @param username
	 * @return
	 */
	public User loadByUsername(String username);
	/**
	 * 更新用户状态
	 * @param userId
	 */
	public void updateStatus(int userId,int status);
	
}
