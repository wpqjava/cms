package org.wpq.cms.dao;



import java.util.List;

import org.springframework.stereotype.Repository;
import org.wpq.cms.model.Keyword;
@Repository
public class KeywordDao extends BaseDao<Keyword> implements IKeywordDao {

	@Override
	public List<String> listKeywordByCon(String con) {
		String str = "%"+con+"%";
		return getSqlSession().selectList(getMethodPath("listKeywordByCon"),str);
	}

	@Override
	public Keyword loadByName(String name) {
		return getSqlSession().selectOne(getMethodPath("loadByName"),name);
	}

}
