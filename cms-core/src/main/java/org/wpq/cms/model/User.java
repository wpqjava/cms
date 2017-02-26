package org.wpq.cms.model;

import java.util.Date;
import java.util.List;

public class User {
	/**
	 * 用户ID
	 */
	private int id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 用户昵称
	 */
	private String nickname;
	/**
	 * 用户邮件
	 */
	private String email;
	/**
	 * 用户电话
	 */
	private String phone;
	/**
	 * 用户状态0为停用，1为启用
	 */
	private int status;
	/**
	 * 用户创建时间
	 */
	private Date createDate;
	/**
	 * 用户角色列表
	 */
	private List<UserRole> urs;
	/**
	 * 用户组列表
	 */
	private List<UserGroup> ugs;
	
	
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int statu) {
		this.status = statu;
	}
	
	public List<UserRole> getUrs() {
		return urs;
	}
	public void setUrs(List<UserRole> urs) {
		this.urs = urs;
	}
	public List<UserGroup> getUgs() {
		return ugs;
	}
	public void setUgs(List<UserGroup> ugs) {
		this.ugs = ugs;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", nickname=" + nickname
				+ ", email=" + email + ", phone=" + phone + ", status=" + status + ", createDate=" + createDate + "]";
	}
	public User(int id) {
		super();
		this.id = id;
	}
	
	public User() {
	}
	
	public User(int id, String username, String password, String nickname, String email, String phone, int status,
			Date createDate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.email = email;
		this.phone = phone;
		this.status = status;
		this.createDate = createDate;
	}
	
	
}
