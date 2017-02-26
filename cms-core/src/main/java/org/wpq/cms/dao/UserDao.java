package org.wpq.cms.dao;



import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.wpq.cms.model.Pager;
import org.wpq.cms.model.SystemContext;
import org.wpq.cms.model.User;

@Repository
public class UserDao extends BaseDao<User> implements IUserDao {

	@Override
	public Pager<User> find(Map<String, Object> params) {
		Pager<User> pager = new Pager<User>();
		pager.setPageOffset(SystemContext.getPageOffset());
		pager.setPageSize(SystemContext.getPageSize());
		pager.setDatas(getSqlSession().selectList(getMethodPath("find"), params));
		return pager;
	}
	
	@Override
	public long findCount(Map<String, Object> params) {
		return getSqlSession().selectOne(getMethodPath("findRecord"), params);
	}

	@Override
	public User loadByUsername(String username) {
		return getSqlSession().selectOne(getMethodPath("loadByUsername"), username);
	}

	@Override
	public void updateStatus(int userId,int status) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userId", userId);
		if(status==1){
			params.put("status", 0);
		}else{
			params.put("status", 1);
		}
		getSqlSession().update(getMethodPath("updateStatus"), params);
	}




}
