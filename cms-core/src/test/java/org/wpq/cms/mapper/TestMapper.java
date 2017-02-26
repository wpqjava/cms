package org.wpq.cms.mapper;

import java.sql.SQLException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wpq.cms.dao.IGroupDao;
import org.wpq.cms.dao.IRoleDao;
import org.wpq.cms.dao.IUserDao;
import org.wpq.cms.dao.IUserGroupDao;
import org.wpq.cms.dao.IUserRoleDao;
import org.wpq.cms.model.Group;
import org.wpq.cms.model.Pager;
import org.wpq.cms.model.Role;
import org.wpq.cms.model.RoleType;
import org.wpq.cms.model.SystemContext;
import org.wpq.cms.model.User;
import org.wpq.cms.model.UserGroup;
import org.wpq.cms.model.UserRole;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ApplicationContext.xml")
public class TestMapper extends TestDBUnitBase{
	private IDataSet ds;
	@Resource(name="userDao")
	private IUserDao ud;
	@Resource(name="groupDao")
	private IGroupDao gd;
	@Resource(name="roleDao")
	private IRoleDao rd;
	@Resource(name="userGroupDao")
	private IUserGroupDao ugd;
	@Resource(name="userRoleDao")
	private IUserRoleDao urd;
	
	@Before
	public void setUp() throws DatabaseUnitException, SQLException{
		backupAndCreateDs();
	}
	
	@After
	public void resumeData() throws DatabaseUnitException, SQLException{
		DatabaseOperation.TRUNCATE_TABLE.execute(dbunitCon, ds);
	}
	
	@Test
	public void testUserMapperAdd() throws DatabaseUnitException, SQLException{
		User user = new User();
		user.setUsername("test");
		user.setPassword("test");
		user.setNickname("test");
		user.setPhone("test");
		user.setEmail("test@test.test");
		user.setStatus(1);
		ud.add(user);
		User u = ud.load(4);
		Assert.assertArrayEquals(new Object[]{"test","test","test","test","test@test.test",1}, 
				new Object[]{u.getUsername(),u.getPassword(),u.getNickname(),
						u.getPhone(),u.getEmail(),u.getStatus()});
	}
	
	@Test(expected=org.springframework.dao.DataIntegrityViolationException.class)
	public void testUserMapperDelete() throws DatabaseUnitException, SQLException{
		ud.delete(3);
	}
	
	@Test
	public void testUserMapperUpdate() throws DatabaseUnitException, SQLException{
		User user = ud.load(1);
		user.setUsername("adminUpdate");
		ud.update(user);
		User u = ud.load(1);
		Assert.assertArrayEquals(new Object[]{1,"adminUpdate"}, new Object[]{u.getId(),u.getUsername()});
	}
	
	@Test
	public void testUserMapperLoad() throws DatabaseUnitException, SQLException{
		User u = ud.load(1);
		Assert.assertArrayEquals(new Object[]{1,"wpq"}, new Object[]{u.getId(),u.getUsername()});
	}
	
	@Test
	public void testUserMapperLoadByUsername() throws DatabaseUnitException, SQLException{
		User u = ud.loadByUsername("zwy");
		Assert.assertArrayEquals(new Object[]{3,"zwy"}, new Object[]{u.getId(),u.getUsername()});
	}
	
	@Test
	public void testUserMapperListAll() throws DatabaseUnitException, SQLException{
		List<User> ls = ud.listAll();
		User u = ls.get(0);
		Assert.assertArrayEquals(new Object[]{1,"wpq",3}, new Object[]{u.getId(),u.getUsername(),ls.size()});
	}
	
	@Test
	public void testUserMapperFind() throws DatabaseUnitException, SQLException{
		SystemContext.setPageOffset(0);
		SystemContext.setPageSize(10);
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("pageOffset", SystemContext.getPageOffset());
		params.put("pageSize", SystemContext.getPageSize());
		Pager<User> p = ud.find(params);
		List<User> ls = p.getDatas();
		User u = ls.get(0);
		for(User user :ls){
			System.out.println(user+", totalRecord="+p.getTotalRecord());
		}
		Assert.assertArrayEquals(new Object[]{1,"wpq"}, new Object[]{u.getId(),u.getUsername()});
	}
	
	@Test
	public void testGroupMapperAdd() throws DatabaseUnitException, SQLException{
		Group g= new Group();
		g.setName("test");
		g.setDescri("test");;
		gd.add(g);
		Group g2 = gd.load(4);
		Assert.assertArrayEquals(new Object[]{"test","test"}, new Object[]{g2.getName(),g2.getDescri()});
	}
	
	@Test(expected=org.springframework.dao.DataIntegrityViolationException.class)
	public void testGroupMapperDelete() throws DatabaseUnitException, SQLException{
		gd.delete(3);
	}
	
	@Test
	public void testGroupMapperUpdate() throws DatabaseUnitException, SQLException{
		Group g = gd.load(3);
		g.setName("test");
		g.setDescri("test");
		gd.update(g);
		Group g2 = gd.load(3);
		Assert.assertArrayEquals(new Object[]{3,"test","test"}, new Object[]{g2.getId(),g2.getName(),g2.getDescri()});
	}
	
	@Test
	public void testGroupMapperLoad() throws DatabaseUnitException, SQLException{
		Group g = gd.load(1);
		Assert.assertArrayEquals(new Object[]{1,"财务处","这是财务处"}, new Object[]{g.getId(),g.getName(),g.getDescri()});
	}
	
	@Test
	public void testGroupMapperListAll() throws DatabaseUnitException, SQLException{
		List<Group> ls = gd.listAll();
		Group g = null;
		g = ls.get(0);
		Assert.assertArrayEquals(new Object[]{1,"财务处","这是财务处"}, new Object[]{g.getId(),g.getName(),g.getDescri()});
		g = ls.get(1);
		Assert.assertArrayEquals(new Object[]{2,"政教处","这是政教处"}, new Object[]{g.getId(),g.getName(),g.getDescri()});
		g = ls.get(2);
		Assert.assertArrayEquals(new Object[]{3,"宣传处","这是宣传处"}, new Object[]{g.getId(),g.getName(),g.getDescri()});
	}
	
	@Test
	public void testRoleMapperAdd() throws DatabaseUnitException, SQLException{
		Role role = new Role();
		role.setName("test");
		role.setRoleType(RoleType.AUDIT);
		rd.add(role);
		Role r = rd.load(4);
		Assert.assertArrayEquals(new Object[]{"test",RoleType.AUDIT}, new Object[]{r.getName(),r.getRoleType()});
	}
	
	@Test(expected=org.springframework.dao.DataIntegrityViolationException.class)
	public void testRoleMapperDelete() throws DatabaseUnitException, SQLException{
		rd.delete(1);
	}
	
	@Test
	public void testRoleMapperUpdate() throws DatabaseUnitException, SQLException{
		Role role = new Role();
		role.setId(1);
		role.setName("testUpdate");
		role.setRoleType(RoleType.AUDIT);
		rd.update(role);
		Role r = rd.load(1);
		Assert.assertArrayEquals(new Object[]{"testUpdate",RoleType.AUDIT}, new Object[]{r.getName(),r.getRoleType()});
	}
	
	@Test
	public void testRoleMapperLoad() throws DatabaseUnitException, SQLException{
		Role r = rd.load(1);
		Assert.assertArrayEquals(new Object[]{"admin",RoleType.ADMIN}, new Object[]{r.getName(),r.getRoleType()});
	}
	
	@Test
	public void testRoleMapperListAll() throws DatabaseUnitException, SQLException{
		List<Role> ls = rd.listAll();
		Role r = null;
		r = ls.get(0);
		Assert.assertArrayEquals(new Object[]{"admin",RoleType.ADMIN}, new Object[]{r.getName(),r.getRoleType()});
		r = ls.get(1);
		Assert.assertArrayEquals(new Object[]{"publish",RoleType.PUBLISH}, new Object[]{r.getName(),r.getRoleType()});
		r = ls.get(2);
		Assert.assertArrayEquals(new Object[]{"audit",RoleType.AUDIT}, new Object[]{r.getName(),r.getRoleType()});
	}
	
	@Test
	public void testUserGroupMapperAdd() throws DatabaseUnitException, SQLException{
		UserGroup ug = new UserGroup();
		ug.setUser(new User(2));
		ug.setGroup(new Group(1));
		ugd.add(ug);
		UserGroup ug2 = ugd.load(4);
		Assert.assertArrayEquals(new Object[]{2,"财务处"}, new Object[]{ug2.getUser().getId(),ug2.getGroup().getName()});
	}
	
	@Test
	public void testUserGroupMapperDelete() throws DatabaseUnitException, SQLException{
		ugd.delete(1);
		UserGroup u = ugd.load(1);
		Assert.assertNull(u);
	}
	
	@Test
	public void testUserGroupMapperDeleteByUserId() throws DatabaseUnitException, SQLException{
		ugd.deleteByUserId(1);
		UserGroup u = ugd.load(1);
		Assert.assertNull(u);
	}
	
	@Test
	public void testUserGroupMapperUpdate() throws DatabaseUnitException, SQLException{
		UserGroup ug = ugd.load(1);
		ug.setUser(new User(2));
		ug.setGroup(new Group(2));
		ugd.update(ug);
		UserGroup ug2 = ugd.load(1);
		Assert.assertArrayEquals(new Object[]{"臧洁冰","政教处"}, new Object[]{ug2.getUser().getNickname(),ug2.getGroup().getName()});
	}
	
	@Test
	public void testUserGroupMapperLoad() throws DatabaseUnitException, SQLException{
		UserGroup ug2 = ugd.load(1);
		Assert.assertArrayEquals(new Object[]{"王霈奇","财务处"}, new Object[]{ug2.getUser().getNickname(),ug2.getGroup().getName()});
	}
	
	@Test
	public void testUserGroupMapperListByUserId() throws DatabaseUnitException, SQLException{
		List<UserGroup> ls = ugd.listByUserId(1);
		UserGroup ug2 = ls.get(0);
		Assert.assertArrayEquals(new Object[]{"王霈奇","财务处"}, new Object[]{ug2.getUser().getNickname(),ug2.getGroup().getName()});
	}
	
	@Test
	public void testUserGroupMapperListByGroupId() throws DatabaseUnitException, SQLException{
		List<UserGroup> ls = ugd.listByGroupId(1);
		UserGroup ug2 = ls.get(0);
		Assert.assertArrayEquals(new Object[]{"王霈奇","财务处"}, new Object[]{ug2.getUser().getNickname(),ug2.getGroup().getName()});
	}
	
	@Test
	public void testUserRoleMapperAdd() throws DatabaseUnitException, SQLException{
		UserRole uri = new UserRole();
		uri.setUser(new User(1));
		uri.setRole(new Role(2));
		urd.add(uri);
		UserRole ur = urd.load(4);
		Assert.assertArrayEquals(new Object[]{"王霈奇",RoleType.PUBLISH}, new Object[]{ur.getUser().getNickname(),ur.getRole().getRoleType()});
	}
	
	@Test
	public void testUserRoleMapperDelete() throws DatabaseUnitException, SQLException{
		urd.delete(3);
		UserRole u = urd.load(3);
		Assert.assertNull(u);
	}
	
	@Test
	public void testUserRoleMapperDeleteByUserId() throws DatabaseUnitException, SQLException{
		urd.deleteByUserId(3);
		UserRole u = urd.load(3);
		Assert.assertNull(u);
	}
	
	@Test
	public void testUserRoleMapperUpdate() throws DatabaseUnitException, SQLException{
		UserRole ur = urd.load(1);
		ur.setUser(new User(1));
		ur.setRole(new Role(2));
		urd.update(ur);
		UserRole ur2 = urd.load(1);
		Assert.assertArrayEquals(new Object[]{"王霈奇",RoleType.PUBLISH}, new Object[]{ur2.getUser().getNickname(),ur2.getRole().getRoleType()});
	}
	
	@Test
	public void testUserRoleMapperLoad() throws DatabaseUnitException, SQLException{
		UserRole ur = urd.load(1);
		Assert.assertArrayEquals(new Object[]{"王霈奇",RoleType.ADMIN}, new Object[]{ur.getUser().getNickname(),ur.getRole().getRoleType()});
	}
	
	@Test
	public void testUserRoleMapperListByUserId() throws DatabaseUnitException, SQLException{
		List<UserRole> ls = urd.listByUserId(1);
		UserRole ur = ls.get(0);
		Assert.assertArrayEquals(new Object[]{"王霈奇",RoleType.ADMIN}, new Object[]{ur.getUser().getNickname(),ur.getRole().getRoleType()});
	}
	
	@Test
	public void testUserRoleMapperListByRoleId() throws DatabaseUnitException, SQLException{
		List<UserRole> ls = urd.listByRoleId(1);
		UserRole ur = ls.get(0);
		Assert.assertArrayEquals(new Object[]{"王霈奇",RoleType.ADMIN}, new Object[]{ur.getUser().getNickname(),ur.getRole().getRoleType()});
	}
	
	@Test
	public void testUserRoleMapperListRoleIdByUserId() throws DatabaseUnitException, SQLException{
		List<Integer> ls = urd.listRoleIdByUserId(1);
		Assert.assertArrayEquals(new Object[]{1}, new Object[]{ls.get(0)});
	}
	
	private void backupAndCreateDs() throws DatabaseUnitException, SQLException{
		ds = this.createDateSet("init");
		DatabaseOperation.TRUNCATE_TABLE.execute(dbunitCon, ds);
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
	}
	
}
