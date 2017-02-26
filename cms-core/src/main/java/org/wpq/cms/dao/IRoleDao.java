package org.wpq.cms.dao;

import java.util.List;

import org.wpq.cms.model.Role;

public interface IRoleDao extends IBaseDao<Role> {
	/**
	 * 通过用户ID列出所在角色
	 * @param id
	 * @return
	 */
	public List<Role> listRoleByUserId(int id);
}
