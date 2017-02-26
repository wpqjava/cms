package org.wpq.cms.dao;

import java.util.List;

import org.wpq.cms.model.Pager;
import org.wpq.cms.model.Topic;

public interface ITopicDao extends IBaseDao<Topic> {
	/**
	 * 通过作者ID,title关键字,栏目ID,状态查找文章对象
	 * @param uid
	 * @param con
	 * @param cid
	 * @return
	 */
	public Pager<Topic> findByUserIdConCIdStatus(int uid,String con,int cid,int status);
	
	/**
	 * 更新文章状态
	 * @param id
	 * @param status
	 */
	public void updateStatus(int id,int status);
	/**
	 * 通过栏目ID列出主页静态化文章
	 * @param id
	 * @return
	 */
	public List<Topic> listIndexTopicByCid(int id,int maxRecord);
}
