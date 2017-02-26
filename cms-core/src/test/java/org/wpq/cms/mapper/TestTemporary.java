package org.wpq.cms.mapper;

import java.security.NoSuchAlgorithmException;


import java.sql.SQLException;

import java.util.Date;

import javax.annotation.Resource;

import org.dbunit.DatabaseUnitException;
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
import org.wpq.cms.model.Role;
import org.wpq.cms.model.RoleType;
import org.wpq.cms.model.User;
import org.wpq.common.util.NameUtil;
import org.wpq.common.util.SecuriyUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ApplicationContext.xml")
public class TestTemporary {
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
	@Test
	public void testInitUserGroup() throws DatabaseUnitException, SQLException{
		User user = new User();
		user.setUsername("admin");
		user.setPassword("admin");
		user.setNickname("admin");
		user.setPhone("admin");
		user.setEmail("admin@admin.com");
		user.setStatus(1);
		user.setCreateDate(new Date());
		ud.add(user);
		user = new User();
		user.setUsername("1");
		user.setPassword("1");
		user.setNickname("1");
		user.setPhone("1");
		user.setEmail("2643996103@qq.com");
		user.setStatus(1);
		user.setCreateDate(new Date());
		ud.add(user);
		for(int i=0;i<50;i++){
			user = new User();
			String name = NameUtil.createName();
			user.setUsername(name);
			user.setPassword("123");
			user.setNickname(name);
			String phone = NameUtil.createPhone();
			user.setPhone(phone);
			user.setEmail(phone+"@qq.com");
			user.setStatus(1);
			user.setCreateDate(new Date());
			ud.add(user);
		}
		
		Group g1 = new Group();
		g1.setName("编辑发布组");
		g1.setDescri("主要职责:主要负责编辑和发布相关新闻热点等。");
		gd.add(g1);
		g1 = new Group();
		g1.setName("内容审核组");
		g1.setDescri("主要职责:审核并确认发布。");
		gd.add(g1);
		Role r = new Role();
		r.setName("管理员");
		r.setRoleType(RoleType.ADMIN);
		rd.add(r);
		r = new Role();
		r.setName("审核员");
		r.setRoleType(RoleType.AUDIT);
		rd.add(r);
		r = new Role();
		r.setName("编辑发布员");
		r.setRoleType(RoleType.PUBLISH);
		rd.add(r);
		
	}

	@Test
	public void testTest() throws NoSuchAlgorithmException{
		User user;
		for(int i=0;i<10;i++){
			user = new User();
			String name = NameUtil.createName();
			user.setUsername(name);
			user.setPassword(SecuriyUtil.md5("123"));
			user.setNickname(name);
			String phone = NameUtil.createPhone();
			user.setPhone(phone);
			user.setEmail(phone+"@qq.com");
			user.setStatus(1);
			user.setCreateDate(new Date());
			ud.add(user);
		}
	}
	
	
}
