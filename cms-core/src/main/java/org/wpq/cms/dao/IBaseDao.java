package org.wpq.cms.dao;

import java.util.List;

public interface IBaseDao<T> {
	/**
	 * 添加
	 * @param t
	 */
	public void add(T t);
	/**
	 * 删除
	 * @param id
	 */
	public void delete(int id);
	/**
	 * 更新
	 * @param t
	 */
	public void update(T t);
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public T load(int id);
	/**
	 * 列表所有对象
	 * @return
	 */
	public List<T> listAll();
}	
