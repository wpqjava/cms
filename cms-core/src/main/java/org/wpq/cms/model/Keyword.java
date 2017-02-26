package org.wpq.cms.model;

public class Keyword {
	/**
	 * 关键字ID
	 */
	private int id;
	/**
	 * 关键字内容
	 */
	private String name;
	/**
	 * 关键字全拼
	 */
	private String fullPY;
	/**
	 * 关键字首字母
	 */
	private String shortPY;
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
	public String getFullPY() {
		return fullPY;
	}
	public void setFullPY(String fullPY) {
		this.fullPY = fullPY;
	}
	public String getShotPY() {
		return shortPY;
	}
	public void setShortPY(String shotPY) {
		this.shortPY = shotPY;
	}
	@Override
	public String toString() {
		return "Keyword [id=" + id + ", name=" + name + ", fullPY=" + fullPY + ", shortPY=" + shortPY + "]";
	}
	
	
}
