package org.wpq.cms.model;

public class Channel {
	/**
	 * 栏目ID
	 */
	private int id;
	/**
	 * 栏目名
	 */
	private String name;
	/**
	 * 是否自定义链接
	 */
	private int customLink;
	/**
	 * 自定义链接地址
	 */
	private String customLinkUrl;
	/**
	 * 栏目类型
	 */
	private ChannelType channelType;
	/**
	 * 是否首页介绍栏目
	 */
	private int isTopIntro;
	/**
	 * 是否首页导航栏目
	 */
	private int isNav;
	/**
	 * 是否推荐
	 */
	private int isRecommend;
	/**
	 * 栏目状态
	 */
	private int status;
	/**
	 * 栏目排序
	 */
	private int orders;
	/**
	 * 父栏目
	 */
	private Channel channel;
    
	
	public int getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(int isRecommend) {
		this.isRecommend = isRecommend;
	}

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

	public int getCustomLink() {
		return customLink;
	}

	public void setCustomLink(int customLink) {
		this.customLink = customLink;
	}

	public String getCustomLinkUrl() {
		return customLinkUrl;
	}

	public void setCustomLinkUrl(String customLinkUrl) {
		this.customLinkUrl = customLinkUrl;
	}

	public ChannelType getChannelType() {
		return channelType;
	}

	public void setChannelType(ChannelType channelType) {
		this.channelType = channelType;
	}

	public int getIsTopIntro() {
		return isTopIntro;
	}

	public void setIsTopIntro(int isTopIntro) {
		this.isTopIntro = isTopIntro;
	}

	public int getIsNav() {
		return isNav;
	}

	public void setIsNav(int isNav) {
		this.isNav = isNav;
	}


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getOrders() {
		return orders;
	}

	public void setOrders(int orders) {
		this.orders = orders;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public Channel() {
	}
	
	public Channel(int id) {
		super();
		this.id = id;
	}
	@Override
	public String toString() {
		return "Channel [id=" + id + ", name=" + name + ", customLink=" + customLink + ", customLinkUrl="
				+ customLinkUrl + ", channelType=" + channelType + ", isTopIntro=" + isTopIntro + ", isNav=" + isNav
				+ ", isRecomman=" + isRecommend + ", status=" + status + ", orders=" + orders + ", channel=" + channel.id
				+ "]";
	}
	
	
}
