package org.wpq.cms.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.wpq.cms.model.Attachment;

public interface IAttachmentService {
	/**
	 * 添加附件
	 * @param a
	 * @param is
	 */
	public void add(Attachment a,InputStream is) throws IOException;
	/**
	 * 更新是否是主页图片
	 * @param id
	 */
	public void updateIntroPic(int id);
	/**
	 * 更新是否是专题图片
	 * @param id
	 */
	public void updateSpePic(int id);
	/**
	 * 更新是否是主页展示图片
	 * @param id
	 */
	public void updateShowPic(int id);
	/**
	 * 更新是否是文章附件
	 * @param id
	 */
	public void updateAttach(int id);
	/**
	 * 删除附件
	 * @param id
	 */
	public void delete(int id);
	/**
	 * 通过文章ID删除附件
	 * @param id
	 * @return
	 */
	public void deleteByTopidId(int id);
	/**
	 * 列表文章所带附件
	 * @param id
	 * @return
	 */
	public List<Attachment> listByTopicId(int id);
	/**
	 * 列表没有依附文章的垃圾附件
	 * @param id
	 * @return
	 */
	public List<Attachment> listUnusedAtt();
	/**
	 * 列表首页静态化附件
	 * @param cid
	 * @param max
	 * @return
	 */
	public List<Attachment> listIndexAtt(int cid,int max);
	
	/**
	 * 列表首页展示附件
	 * @param cid 文章所在栏目
	 * @param max
	 * @return
	 */
	public List<Attachment> listChannelShowAtt(int cid,int max);
	/**
	 * 通过关键字列表文章附件
	 * @param con
	 * @return
	 */
	public List<Attachment> listByCon(String con);
	
}
