package org.wpq.cms.service;

import java.util.List;

import org.wpq.cms.model.Pager;
import org.wpq.cms.model.Topic;

public interface ITopicService {
	/**
	 * 通过作者ID关键字栏目ID文章状态查找文章分页对象
	 * @param uid
	 * @param con
	 * @param cid
	 */
	public Pager<Topic> findByUIdConCIdStatus(int uid,String con,int cid,int status);
	/**
	 * 通过作者ID栏目ID文章状态查找文章分页对象
	 * @param uid
	 * @param con
	 * @param cid
	 */
	public Pager<Topic> findByUIdCIdStatus(int uid,int cid,int status);
	/**
	 * 通过作者ID关键字栏目ID文章状态查找文章分页对象
	 * @param uid
	 * @param con
	 * @param cid
	 */
	public Pager<Topic> findByConCIdStatus(String con,int cid,int status);
	/**
	 * 通过作者ID栏目ID文章状态查找文章分页对象
	 * @param uid
	 * @param con
	 * @param cid
	 */
	public Pager<Topic> findByCIdStatus(int cid,int status);
	/**
	 * 更新文章状态
	 * @param id
	 * @param status
	 */
	public void updateStatus(int id,int status);
	/**
	 * 删除文章和附件的数据库信息
	 * @param id
	 */
	public void delete(int id);
	/**
	 * 添加附件
	 * @param topic
	 * @param aids
	 */
	public void add(Topic topic,Integer[] aids);
	/**
	 * 查询文章
	 * @param id
	 * @return
	 */
	public Topic load(int id);
	/**
	 * 更新文章
	 * @param id
	 * @return
	 */
	public void update(Topic t,Integer[] aids);
	/**
	 * 通过栏目ID列出主页静态化文章
	 * @param id
	 * @return
	 */
	public List<Topic> listIndexTopicByCid(int id,int max);
	
}
