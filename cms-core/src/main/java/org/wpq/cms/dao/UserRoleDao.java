package org.wpq.cms.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.wpq.cms.model.UserRole;
@Repository
public class UserRoleDao extends BaseDao<UserRole> implements IUserRoleDao {

	@Override
	public List<UserRole> listByUserId(int userId) {
		return getSqlSession().selectList(getMethodPath("listByUserId"), userId);
	}

	@Override
	public List<UserRole> listByRoleId(int roleId) {
		return getSqlSession().selectList(getMethodPath("listByRoleId"), roleId);
	}

	@Override
	public void deleteByUserId(int id) {
		getSqlSession().delete(getMethodPath("deleteByUserId"), id);
	}

	@Override
	public List<Integer> listRoleIdByUserId(int userId) {
		return getSqlSession().selectList(getMethodPath("listRoleIdByUserId"),userId);
	}

	@Override
	public void deleteByUserIdAndRoleId(int userId, int roleId) {
		Map<String,Integer> params = new HashMap<String,Integer>();
		params.put("userId", userId);
		params.put("roleId", roleId);
		getSqlSession().delete(getMethodPath("deleteByUserIdAndRoleId"),params);
	}

}
