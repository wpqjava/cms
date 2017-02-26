package org.wpq.cms.model;

public class Attachment {
	/**
	 * id
	 */
	private int id;
	/**
	 * 附件原名
	 */
	private String oldName;
	/**
	 * 附件新名
	 */
	private String newName;
	/**
	 * 附件的contextType
	 */
	private String type;
	/**
	 * 附件后缀名
	 */
	private String suffix;
	/**
	 * 附件大小
	 */
	private long size;
	/**
	 * 是否是首页滚动图片
	 */
	private int isIntroPic;
	/**
	 * 是否是图片
	 */
	private int isImg;
	/**
	 * 是否为专题图片
	 */
	private int isSpePic;
	/**
	 * 是否为主页展示图片
	 */
	private int isShowPic;
	/**
	 * 所属文章
	 */
	private Topic topic;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOldName() {
		return oldName;
	}
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}
	public String getNewName() {
		return newName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public int getIsImg() {
		return isImg;
	}
	public void setIsImg(int isImg) {
		this.isImg = isImg;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public int getIsIntroPic() {
		return isIntroPic;
	}
	public void setIsIntroPic(int isIntroPic) {
		this.isIntroPic = isIntroPic;
	}
	public int getIsSpePic() {
		return isSpePic;
	}
	public void setIsSpePic(int isSpePic) {
		this.isSpePic = isSpePic;
	}
	public int getIsShowPic() {
		return isShowPic;
	}
	public void setIsShowPic(int isShowPic) {
		this.isShowPic = isShowPic;
	}
	@Override
	public String toString() {
		return "Attachment [id=" + id + ", oldName=" + oldName + ", newName=" + newName + ", type=" + type + ", suffix="
				+ suffix + ", size=" + size + ", isIntroPic=" + isIntroPic + ", isImg=" + isImg + ", isSpePic="
				+ isSpePic + ", isShowPic=" + isShowPic + "]";
	}
		
	
}
