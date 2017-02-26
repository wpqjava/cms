package org.wpq.cms.dao;


import java.util.List;

import org.springframework.stereotype.Repository;
import org.wpq.cms.model.Role;
@Repository
public class RoleDao extends BaseDao<Role> implements IRoleDao {
	@Override
	public List<Role> listRoleByUserId(int id) {
		return getSqlSession().selectList(getMethodPath("listRoleByUserId"), id);
	}
}
