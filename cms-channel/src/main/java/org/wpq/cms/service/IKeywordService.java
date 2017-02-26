package org.wpq.cms.service;

import java.util.List;

public interface IKeywordService {
	/**
	 * 列表关键字
	 * @param con
	 * @return
	 */
	public List<String> listKeywordByCon(String con);
	/**
	 * 添加关键字
	 * @param str
	 */
	public void add(String str);
}
