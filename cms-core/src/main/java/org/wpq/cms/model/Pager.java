package org.wpq.cms.model;

import java.util.List;
/**
 * 分页对象
 * @author Administrator
 *
 * @param <T>
 */
public class Pager<T> {
	/**
	 * 分页页码
	 */
	private int pageOffset;
	/**
	 * 分页大小
	 */
	private int pageSize;
	/**
	 * 分页总共的条数
	 */
	private long totalRecord;
	/**
	 * 分页数据
	 */
	private List<T> datas;

	public int getPageOffset() {
		return pageOffset;
	}

	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

}
