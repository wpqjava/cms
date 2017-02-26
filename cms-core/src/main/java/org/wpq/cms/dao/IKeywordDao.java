package org.wpq.cms.dao;

import java.util.List;

import org.wpq.cms.model.Keyword;

public interface IKeywordDao extends IBaseDao<Keyword> {
	/**
	 * 通过con列表关键字
	 * @param con
	 * @return
	 */
	public List<String> listKeywordByCon(String con);
	/**
	 * 通过关键字查找关键字
	 * @param name
	 * @return
	 */
	public Keyword loadByName(String name);
}
