package org.wpq.cms.model;
/**
 * 组和栏目的关联表对象
 * @author Administrator
 *
 */
public class GroupChannel {
	private int id;
	private Group group;
	private Channel channel;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public GroupChannel() {
	}
	public GroupChannel(Group group, Channel channel) {
		super();
		this.group = group;
		this.channel = channel;
	}
	@Override
	public String toString() {
		return "GroupChannel [id=" + id + ", group=" + group.getName() + ", channel=" + channel.getName() + "]";
	}
	
}
