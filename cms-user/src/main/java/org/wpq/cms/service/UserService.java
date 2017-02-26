package org.wpq.cms.service;

import java.security.NoSuchAlgorithmException;

import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
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
import org.wpq.cms.model.UserGroup;
import org.wpq.cms.model.UserRole;
import org.wpq.common.util.SecuriyUtil;
import org.wpq.common.util.ServiceUtil;
@Service
public class UserService implements IUserService {
	@Resource
	private IUserDao userDao;
	@Resource
	private IRoleDao roleDao;
	@Resource
	private IGroupDao groupDao;
	@Resource
	private IUserRoleDao userRoleDao;
	@Resource
	private IUserGroupDao userGroupDao;

	@Override
	public void add(User user, int[] rids, int[] gids) {
		User ou = userDao.loadByUsername(user.getUsername());
		if(ou!=null) throw new CmsException("用户名已存在");
		//添加用户
		user.setCreateDate(new Date());
		try {
			String mdPassword = SecuriyUtil.md5(user.getPassword());
			user.setPassword(mdPassword);
		}catch (NoSuchAlgorithmException e) {throw new CmsException("加密出错");}
		userDao.add(user);
		//添加用户角色关联
		addUserRole(user, rids);
		//添加用户组关联
		addUserGroup(user, gids);
	}
	
	private void addUserRole(User user,int[] rids){
		Role role =null;
		UserRole ur = null;
		for(int i=0;i<rids.length;i++){
			role = roleDao.load(rids[i]);
			if(role==null) throw new CmsException("角色不存在");
			ur = new UserRole(user, role);
			userRoleDao.add(ur);
		}
	}
	
	private void addUserGroup(User user,int[] gids){
		Group g = null;
		UserGroup ug = null;
		for(int i=0;i<gids.length;i++){
			g = groupDao.load(gids[i]);
			if(g==null) throw new CmsException("组不存在");
			ug = new UserGroup(user, g);
			userGroupDao.add(ug);
		}
	}

	@Override
	public void delete(int id) {
		//TODO 删除用户文章
		
		//删除用户组关联
		userGroupDao.deleteByUserId(id);
		//删除用户角色关联
		userRoleDao.deleteByUserId(id);
		//删除用户
		userDao.delete(id);
	}

	@Override
	public void update(User user,int[] rids,int[] gids) {
		//处理角色ID
		List<Integer> existRids = userRoleDao.listRoleIdByUserId(user.getId());
		List<Integer> needDeleteRids = ServiceUtil.needDeleteId(existRids, ServiceUtil.ArrayToList(rids));
		List<Integer> needAddRids = ServiceUtil.needAddId(existRids, ServiceUtil.ArrayToList(rids));
		//处理组ID
		List<Integer> existGids = userGroupDao.listGroupIdByUserId(user.getId());
		List<Integer> needDeleteGids = ServiceUtil.needDeleteId(existGids, ServiceUtil.ArrayToList(gids));
		List<Integer> needAddGids = ServiceUtil.needAddId(existGids, ServiceUtil.ArrayToList(gids));
		//更新用户
		try {
			String mdPassword = SecuriyUtil.md5(user.getPassword());
			user.setPassword(mdPassword);
		}catch (NoSuchAlgorithmException e) {throw new CmsException("加密出错");}
		userDao.update(user);
		int userId = user.getId();
		//更新用户角色关联
		for(int roleId:needDeleteRids){
			userRoleDao.deleteByUserIdAndRoleId(userId, roleId);
		}
		UserRole ur = null;
		for(int roleId:needAddRids){
			ur = new UserRole(user, new Role(roleId));
			userRoleDao.add(ur);
		}
		//更新用户组关联
		for(int groupId:needDeleteGids){
			userGroupDao.deleteByUserIdAndGroupId(userId, groupId);
		}
		UserGroup ug = null;
		for(int gourpId:needAddGids){
			ug = new UserGroup(user, new Group(gourpId));
			userGroupDao.add(ug);
		}
		
	}
	
	@Override
	public void updateStatus(int userId,int status) {
		userDao.updateStatus(userId, status);
	}
	
	@Override
	public User load(int id) {
		User user = userDao.load(id);
		user.setUrs(userRoleDao.listByUserId(id));
		user.setUgs(userGroupDao.listByUserId(id));
		return user;
	}

	@Override
	public Pager<User> findUsers(String condition) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("pageOffset", SystemContext.getPageOffset());
		params.put("pageSize", SystemContext.getPageSize());
		String order = SystemContext.getOrder();
		if(order!=null)params.put("order", SystemContext.getOrder());
		if(condition!=null)params.put("condition", "%"+condition+"%");
		Pager<User> pager = userDao.find(params);
		pager.setTotalRecord(userDao.findCount(params));
		return pager;
	}

	@Override
	public Pager<User> findUsers() {
		return this.findUsers(null);
	}
	
	@Override
	public Map<String, int[]> listUserRoleIdsAndGroupIds(int id) {
		Map<String,int[]> map = new HashMap<String,int[]>();
		map.put("roleIds", ServiceUtil.ListToArrayInt(userRoleDao.listRoleIdByUserId(id)));
		map.put("groupIds", ServiceUtil.ListToArrayInt(userGroupDao.listGroupIdByUserId(id)));
		return map;
	}
	
	@Override
	public Map<String, String> listUserRoleNamesAndGroupNames(int id) {
		Map<String,String> map = new HashMap<String,String>();
		List<UserRole> urs = userRoleDao.listByUserId(id);
		String roleNames = null;
		for(int i=0;i<urs.size();i++ ){
			roleNames += urs.get(i).getRole().getName()+",";
		}
		List<UserGroup> ugs = userGroupDao.listByUserId(id);
		String groupNames = null;
		for(int i=0;i<ugs.size();i++ ){
			groupNames += ugs.get(i).getGroup().getName()+",";
		}
		map.put("roleNames", roleNames);
		map.put("groupNames", groupNames);
		return map;
	}
	
	@Override
	public List<User> listUserByGroupId(int groupId) {
		List<UserGroup> ugs = userGroupDao.listByGroupId(groupId);
		List<User> users = new ArrayList<User>();
		for(UserGroup ug:ugs){
			users.add(ug.getUser());
		}
		return users;
	}
	
	@Override
	public List<User> listUserByRoleId(int roleId) {
		List<UserRole> urs = userRoleDao.listByRoleId(roleId);
		List<User> users = new ArrayList<User>();
		for(UserRole ur:urs){
			users.add(ur.getUser());
		}
		return users;
	}
	
	@Override
	public User login(String username, String password) {
		User loginUser = userDao.loadByUsername(username);
		if(loginUser==null)throw new CmsException("用户名或密码错误");
		try {
			if(!loginUser.getPassword().equals(SecuriyUtil.md5(password)))throw new CmsException("用户名或密码错误");
		} catch (NoSuchAlgorithmException e) {
			throw new CmsException("加密出错");
		}
		return loginUser;
	}
	
	@Override
	public void updatePassword(User user) {
		try {
			String mdPassword = SecuriyUtil.md5(user.getPassword());
			user.setPassword(mdPassword);
		}catch (NoSuchAlgorithmException e) {throw new CmsException("加密出错");}
		
		userDao.update(user);
	}
	
	@Override
	public void updateOnlyUser(User user) {
		userDao.update(user);
	}
}
