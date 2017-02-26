package org.wpq.cms.service;

import java.util.List;

import org.wpq.cms.model.Role;

public interface IRoleService {
	/**
	 * 列出所有角色
	 * @return
	 */
	public List<Role> listAll();
	/**
	 * 查询角色
	 * @param id
	 * @return
	 */
	public Role load(int id);
	/**
	 * 通过用户ID列出用户所在角色
	 * @param id
	 * @return
	 */
	public List<Role> listRoleByUserId(int id);
}
