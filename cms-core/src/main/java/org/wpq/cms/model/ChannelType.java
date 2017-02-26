package org.wpq.cms.model;

public enum ChannelType {
	NAV_CHANNEL("导航栏目"),TOPIC_LIST("文章列表栏目"),IMG_LIST("图片列表栏目");
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private ChannelType(String name) {
		this.name = name;
	}
	
}
