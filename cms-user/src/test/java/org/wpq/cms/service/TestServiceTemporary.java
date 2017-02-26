/*package org.wpq.cms.service;

import java.sql.SQLException;
import java.util.Date;
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
import org.wpq.cms.dao.UserDao;
import org.wpq.cms.model.Group;
import org.wpq.cms.model.Pager;
import org.wpq.cms.model.Role;
import org.wpq.cms.model.RoleType;
import org.wpq.cms.model.SystemContext;
import org.wpq.cms.model.User;
import org.wpq.cms.model.UserGroup;
import org.wpq.cms.model.UserRole;
import org.wpq.cms.util.NameUtil;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ApplicationContext.xml")
public class TestServiceTemporary {
	@Resource
	private IUserService us;

	@Test
	public void testInitDatas2(){
		Map<String, Object> params = new HashMap<>();
		SystemContext.setPageOffset(0);
		SystemContext.setPageSize(10);
		params.put("pageOffset", 0);
		params.put("pageSize", 10);
		System.out.println(us.findUsers().getDatas().size());

	}
}
*/