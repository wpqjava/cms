package org.wpq.cms.model;

public class ChannelTree {
	/**
	 * 栏目的ID
	 */
	private int id;
	/**
	 * 栏目名
	 */
	private String name;
	/**
	 * 父栏目ID
	 */
	private int pid;
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
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", pid=" + pid + "]";
	}
	public ChannelTree() {
	}
	public ChannelTree(int id, String name, int pid) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
	}
	
	
	
}
