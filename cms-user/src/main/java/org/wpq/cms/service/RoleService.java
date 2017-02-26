package org.wpq.cms.service;

import java.util.List;

import javax.annotation.Resource;
import org.wpq.cms.dao.IRoleDao;
import org.springframework.stereotype.Service;
import org.wpq.cms.model.Role;
@Service
public class RoleService implements IRoleService {
	@Resource
	private IRoleDao roleDao;
	@Override
	public List<Role> listAll() {
		return roleDao.listAll();
	}
	
	@Override
	public Role load(int id) {
		return roleDao.load(id);
	}
	
	@Override
	public List<Role> listRoleByUserId(int id) {
		return roleDao.listRoleByUserId(id);
	}
}
