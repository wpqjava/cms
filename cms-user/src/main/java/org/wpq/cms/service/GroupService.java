package org.wpq.cms.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wpq.cms.dao.IGroupDao;
import org.wpq.cms.dao.IUserGroupDao;
import org.wpq.cms.model.Group;
@Service
public class GroupService implements IGroupService {
	@Resource
	private IGroupDao groupDao;
	@Resource
	private IUserGroupDao userGroupDao;
	
	@Override
	public void add(Group group) {
		groupDao.add(group);
	}

	@Override
	public void delete(int id) {
		userGroupDao.deleteByGroupId(id);
		groupDao.delete(id);
	}

	@Override
	public void update(Group group) {
		
		groupDao.update(group);
	}

	@Override
	public Group load(int id) {
		return groupDao.load(id);
	}

	@Override
	public List<Group> listAll() {
		return groupDao.listAll();
	}

}
