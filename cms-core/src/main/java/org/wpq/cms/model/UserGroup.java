package org.wpq.cms.model;

/**
 * User和Groip的关联表的对象
 * 
 * @author Administrator
 *
 */
public class UserGroup {
	
	private int id;
	private User user;
	private Group group;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	public UserGroup() {
	}

	public UserGroup(User user, Group group) {
		super();
		this.user = user;
		this.group = group;
	}
	
	
	
}
