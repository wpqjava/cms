package org.wpq.cms.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wpq.cms.dao.IKeywordDao;
import org.wpq.cms.model.Keyword;
import org.wpq.common.util.PinyinUtil;
@Service
public class KeywordService implements IKeywordService {
	@Resource
	private IKeywordDao keywordDao;
	
	@Override
	public List<String> listKeywordByCon(String con) {
		return keywordDao.listKeywordByCon(con);
	}

	@Override
	public void add(String str) {
		Keyword k = keywordDao.loadByName(str);
		if(k==null){
			k = new Keyword();
			k.setName(str);
			k.setFullPY(PinyinUtil.str2FullPinyin(str, ""));
			k.setShortPY(PinyinUtil.str2ShortPinyin(str));
			keywordDao.add(k);
		}
	}

}
