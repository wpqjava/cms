package org.wpq.cms.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.wpq.cms.model.Topic;

public class TopicDto {
	public static SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
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
	 * 发布时间
	 */
	private String publishDate;
	/**
	 * 摘要
	 */
	private String summary;
	/**
	 * 栏目图片ID
	 */
	private int channelPicId;
	/**
	 * 作者,冗余字段
	 */
	private String author;
	/**
	 * 所属频道
	 */
	private int channelId;
	/**
	 * 作者
	 */
	private int userId;
	
	
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public TopicDto() {
	}
	
	public TopicDto(Topic t) {
		title=t.getTitle();
		keyword=t.getKeyword();
		recommend=t.getRecommend();
		content=t.getContent();
		publishDate=sd.format(t.getPublishDate());
		summary=t.getSummary();
		author=t.getAuthor();
		channelId=t.getChannel().getId();
		userId=t.getUser().getId();
	}
	
	public Topic getTopic(){
		Topic t = new Topic();
		t.setAuthor(author);
		t.setContent(content);
		t.setCreateDate(new Date());
		try {
			t.setPublishDate(sd.parse(publishDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		t.setRecommend(recommend);
		t.setSummary(summary);
		t.setStatus(0);
		t.setStatus(status);
		t.setTitle(title);
		return t;
	}
	@Override
	public String toString() {
		return "TopicDto [id=" + id + ", title=" + title + ", keyword=" + keyword + ", status=" + status
				+ ", recommend=" + recommend + ", content=" + content + ", publishDate=" + publishDate + ", summary="
				+ summary + ", channelPicId=" + channelPicId + ", author=" + author + ", channelId=" + channelId
				+ ", userId=" + userId + "]";
	}
	
	
}
