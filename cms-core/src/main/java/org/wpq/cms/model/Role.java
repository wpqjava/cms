package org.wpq.cms.model;

public class Role {
	/**
	 * 角色ID
	 */
	private int id;
	/**
	 * 角色名称
	 */
	private String name;
	/**
	 * 角色的枚举类型
	 */
	private RoleType roleType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RoleType getRoleType() {
		return roleType;
	}
	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}
	
	public Role() {
	}
	public Role(int id) {
		super();
		this.id = id;
	}
	
	
}
