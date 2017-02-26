package org.wpq.cms.web;

public interface IIndexService {
	/**
	 * 创建首页顶部导航内容静态化
	 */
	public void generateNav();
	
	/**
	 * 创建首页中部静态化
	 */
	public void generateBody();
	/**
	 * 创建首页底部静态化
	 */
	public void generateFoot();
}
