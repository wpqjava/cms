package org.wpq.cms.service;

import java.util.List;

import org.wpq.cms.model.Group;

public interface IGroupService {
	/**
	 * 添加组
	 * @param group
	 */
	public void add(Group group);
	/**
	 * 删除组
	 * @param id
	 */
	public void delete(int id);
	/**
	 * 更新组
	 * @param group
	 */
	public void update(Group group);
	/**
	 * 查询组
	 * @param id
	 * @return
	 */
	public Group load(int id);
	/**
	 * 列出所有组
	 * @return
	 */
	public List<Group> listAll();
}
