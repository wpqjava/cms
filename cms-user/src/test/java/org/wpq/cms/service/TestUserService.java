/*package org.wpq.cms.service;

import java.util.Arrays;
import java.util.List;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.wpq.cms.dao.IGroupDao;
import org.wpq.cms.dao.IRoleDao;
import org.wpq.cms.dao.IUserDao;
import org.wpq.cms.dao.IUserGroupDao;
import org.wpq.cms.dao.IUserRoleDao;
import org.wpq.cms.model.CmsException;
import org.wpq.cms.model.Group;
import org.wpq.cms.model.Pager;
import org.wpq.cms.model.Role;
import org.wpq.cms.model.SystemContext;
import org.wpq.cms.model.User;

public class TestUserService {
	private IMocksControl mc;
	private IUserService userService;
	private IUserDao userDao;
	private IGroupDao groupDao;
	private IRoleDao roleDao;
	private IUserGroupDao userGroupDao;
	private IUserRoleDao userRoleDao;
	
	public TestUserService() {
		mc = EasyMock.createStrictControl();
		userService = new UserService();
		userDao = mc.createMock(IUserDao.class);
		groupDao = mc.createMock(IGroupDao.class);
		roleDao = mc.createMock(IRoleDao.class);
		userGroupDao = mc.createMock(IUserGroupDao.class);
		userRoleDao = mc.createMock(IUserRoleDao.class);
		ReflectionTestUtils.setField(userService, "userDao", userDao, IUserDao.class);
		ReflectionTestUtils.setField(userService, "groupDao", groupDao, IGroupDao.class);
		ReflectionTestUtils.setField(userService, "roleDao", roleDao, IRoleDao.class);
		ReflectionTestUtils.setField(userService, "userGroupDao", userGroupDao, IUserGroupDao.class);
		ReflectionTestUtils.setField(userService, "userRoleDao", userRoleDao, IUserRoleDao.class);
	}
	@Test
	public void testAdd(){
		mc.reset();
		User u = new User(1);
		u.setUsername("1");
		Role r = new Role(1);
		Group g = new Group(1);
		int[] rids = new int[]{1,2};
		int[] gids = new int[]{1};
		EasyMock.expect(userDao.loadByUsername("1")).andReturn(null);
		userDao.add(u);
		EasyMock.expect(roleDao.load(EasyMock.gt(0))).andReturn(r);
		userRoleDao.add(EasyMock.anyObject());
		EasyMock.expect(roleDao.load(EasyMock.gt(0))).andReturn(r);
		userRoleDao.add(EasyMock.anyObject());
		EasyMock.expect(groupDao.load(EasyMock.gt(0))).andReturn(g);
		userGroupDao.add(EasyMock.anyObject());
		mc.replay();
		userService.add(u, rids, gids);
		mc.verify();
	}
	
	@Test(expected=CmsException.class)
	public void testAddException1(){
		mc.reset();
		User u = new User(1);
		u.setUsername("1");
		int[] rids = new int[]{1,2};
		int[] gids = new int[]{1};
		EasyMock.expect(userDao.loadByUsername("1")).andReturn(new User(1));
		mc.replay();
		userService.add(u, rids, gids);
		mc.verify();
	}
	
	@Test(expected=CmsException.class)
	public void testAddException2(){
		mc.reset();
		User u = new User(1);
		u.setUsername("1");
		int[] rids = new int[]{1};
		int[] gids = new int[]{1};
		EasyMock.expect(userDao.loadByUsername("1")).andReturn(null);
		userDao.add(u);
		EasyMock.expect(roleDao.load(EasyMock.gt(0))).andReturn(null);
		userRoleDao.add(EasyMock.anyObject());
		mc.replay();
		userService.add(u, rids, gids);
		mc.verify();
	}
	
	@Test(expected=CmsException.class)
	public void testAddException3(){
		mc.reset();
		User u = new User(1);
		u.setUsername("1");
		Role r = new Role(1);
		int[] rids = new int[]{1};
		int[] gids = new int[]{1};
		EasyMock.expect(userDao.loadByUsername("1")).andReturn(null);
		userDao.add(u);
		EasyMock.expect(roleDao.load(EasyMock.gt(0))).andReturn(r);
		userRoleDao.add(EasyMock.anyObject());
		EasyMock.expect(groupDao.load(EasyMock.gt(0))).andReturn(null);
		userGroupDao.add(EasyMock.anyObject());
		mc.replay();
		userService.add(u, rids, gids);
		mc.verify();
	}
	
	@Test
	public void testUpdateStatus(){
		int userId = 1;
		int status = 1;
		userDao.updateStatus(userId, status);
		EasyMock.expectLastCall();
		mc.replay();
		userService.updateStatus(userId, status);
		mc.verify();
	}
	
	@Test
	public void testUpdate(){
		User u = new User(1);
		int[] nids = {1,2};
		List<Integer> eids = Arrays.asList(2,3);
		EasyMock.expect(userRoleDao.listRoleIdByUserId(1)).andReturn(eids);
		EasyMock.expect(userGroupDao.listGroupIdByUserId(1)).andReturn(eids);
		userDao.update(u);
		userRoleDao.deleteByUserIdAndRoleId(1, 3);
		userRoleDao.add(EasyMock.anyObject());
		userGroupDao.deleteByUserIdAndGroupId(1, 3);
		userGroupDao.add(EasyMock.anyObject());
		mc.replay();
		userService.update(u, nids, nids);
		mc.verify();
	}
	
	
}
*/