package org.wpq.cms.model;

public class Group {
	/**
	 * 组ID
	 */
	private int id;
	/**
	 * 组名称
	 */
	private String name;
	/**
	 * 组描述
	 */
	private String descri;
	
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
	public String getDescri() {
		return descri;
	}
	public void setDescri(String desc) {
		this.descri = desc;
	}
	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", descri=" + descri + "]";
	}
	
	public Group() {
	}
	public Group(int id) {
		super();
		this.id = id;
	}
	
}
