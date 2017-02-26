package org.wpq.cms.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.wpq.cms.model.UserGroup;
@Repository
public class UserGroupDao extends BaseDao<UserGroup> implements IUserGroupDao {

	@Override
	public List<UserGroup> listByUserId(int userId) {
		return getSqlSession().selectList(getMethodPath("listByUserId"), userId);
	}

	@Override
	public List<UserGroup> listByGroupId(int groupId) {
		return getSqlSession().selectList(getMethodPath("listByGroupId"), groupId);
	}

	@Override
	public void deleteByUserId(int id) {
		getSqlSession().delete(getMethodPath("deleteByUserId"), id);
	}

	@Override
	public List<Integer> listGroupIdByUserId(int userId) {
		return getSqlSession().selectList(getMethodPath("listGroupIdByUserId"), userId);
	}

	@Override
	public void deleteByUserIdAndGroupId(int userId, int groupId) {
		Map<String,Integer> params = new HashMap<String,Integer>();
		params.put("userId", userId);
		params.put("groupId", groupId);
		getSqlSession().delete(getMethodPath("deleteByUserIdAndGroupId"), params);
	}

	@Override
	public void deleteByGroupId(int groupId) {
		getSqlSession().delete(getMethodPath("deleteByGroupId"), groupId);
	}

}
