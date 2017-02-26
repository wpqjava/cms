package org.wpq.cms.dao;

import java.util.List;

import org.wpq.cms.model.Attachment;

public interface IAttachmentDao extends IBaseDao<Attachment> {
	/**
	 * 更新附件所属文章
	 * @param aid
	 * @param tid
	 */
	public void updateAttachTopicId(int aid,int tid);
	/**
	 * 通过文章ID删除附件
	 * @param tid
	 */
	public void deleteByTopicId(int tid);
	
	/**
	 * 通过文章ID列表附件
	 * @param id
	 * @return
	 */
	public List<Attachment> listByTopicId(int id);
	/**
	 * 通过文章ID列表附件Id
	 * @param id
	 * @return
	 */
	public List<Integer> listIdByTopicId(int id);
	
	/**
	 * 列出没有使用的附件
	 * @param id
	 * @return
	 */
	public List<Attachment> listUnusedAtt();
	/**
	 *  列出首页静态化附件信息
	 * @param cid 所在栏目
	 * @param max 最大条数
	 * @return
	 */
	public List<Attachment> listIndexAtt(int cid,int max);
	
	/**
	 *  列出二级页面附件信息
	 * @param cid 所在栏目
	 * @param max 最大条数
	 * @return
	 */
	public List<Attachment> listChannelShowAtt(int cid,int max);
	
	/**
	 *  通过关键字查找附件文章对象
	 * @param con 关键字
	 * @param max 最大条数
	 * @return
	 */
	public List<Attachment> listByCon(String con,int max);
}
