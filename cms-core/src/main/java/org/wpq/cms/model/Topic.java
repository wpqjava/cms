package org.wpq.cms.model;

import java.util.Date;

public class Topic {
	/**
	 * 文章ID
	 */
	private int id;
	/**
	 * 文章标题
	 */
	private String title;
	/**
	 * 关键字
	 */
	private String keyword;
	/**
	 * 是否发布0未发布;1已发布
	 */
	private int status;
	/**
	 * 是否推荐0不推荐,1推荐
	 */
	private int recommend;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 摘要
	 */
	private String summary;
	/**
	 * 栏目图片ID
	 */
	private int channelPicId;
	/**
	 * 创建日期
	 */
	private Date createDate;
	/**
	 * 发布日期
	 */
	private Date publishDate;
	/**
	 * 作者,冗余字段
	 */
	private String author;
	/**
	 * 所属频道
	 */
	private Channel channel;
	/**
	 * 作者
	 */
	private User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public int getChannelPicId() {
		return channelPicId;
	}
	public void setChannelPicId(int channelPicId) {
		this.channelPicId = channelPicId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Topic() {
	}
	
	public Topic(int id) {
		super();
		this.id = id;
	}
	@Override
	public String toString() {
		return "Topic [id=" + id + ", title=" + title + ", keyword=" + keyword + ", status=" + status + ", recommend="
				+ recommend + ", content=" + content + ", summary=" + summary + ", channelPicId=" + channelPicId
				+ ", createDate=" + createDate + ", publishDate=" + publishDate + ", author=" + author +"]";
	}
	
	
}
