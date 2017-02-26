package org.wpq.cms.dto;

import java.util.Date;

import org.wpq.cms.model.User;

public class UserDto {
	private int id;
	private String username;
	private String password;
	private String nickname;
	private String email;
	private String phone;
	private int status;
	private Date createDate;
	private int[] groupIds;
	//用,号连接group name方便前端操作
	private String groupNames;
	private int[] roleIds;
	//用,号连接role name方便前端操作
	private String roleNames;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public int[] getGroupIds() {
		return groupIds;
	}
	public void setGroupIds(int[] groupIds) {
		this.groupIds = groupIds;
	}
	public int[] getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(int[] roleIds) {
		this.roleIds = roleIds;
	}
	
	public String getGroupNames() {
		return groupNames;
	}
	public void setGroupNames(String groupNames) {
		this.groupNames = groupNames;
	}
	public String getRoleNames() {
		return roleNames;
	}
	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}
	public UserDto() {
	}
	public UserDto(User u,int[] groupIds,int[] roleIds) {
		this.id = u.getId();
		this.username = u.getUsername();
		this.password = u.getPassword();
		this.nickname = u.getNickname();
		this.email = u.getEmail();
		this.phone = u.getPhone();
		this.status = u.getStatus();
		this.createDate = u.getCreateDate();
		this.groupIds = groupIds;
		this.roleIds = roleIds;
	}
	public UserDto(User u,String groupNames,String roleNames) {
		this.id = u.getId();
		this.username = u.getUsername();
		this.password = u.getPassword();
		this.nickname = u.getNickname();
		this.email = u.getEmail();
		this.phone = u.getPhone();
		this.status = u.getStatus();
		this.createDate = u.getCreateDate();
		this.groupNames = groupNames;
		this.roleNames = roleNames;
	}
	public User getUser(){
		User u = new User(id, username, password, nickname, email, phone, status, createDate);
		return u;
	}
	
}
