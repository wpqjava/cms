package org.wpq.cms.model;

public class SystemContext {
	/**
	 * 分页页码
	 */
	private static ThreadLocal<Integer> pageOffset = new ThreadLocal<Integer>();
	/**
	 * 分页大小
	 */
	private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();
	/**
	 * 分页排序方式
	 */
	private static ThreadLocal<String> order = new ThreadLocal<String>();
	/**
	 * realPATH
	 */
	private static ThreadLocal<String> realPath = new ThreadLocal<String>();
	
	public static String getRealPath() {
		return realPath.get();
	}
	public static void setRealPath(String _realPath) {
		realPath.set(_realPath);;
	}
	public static void removeRealPath() {
		realPath.remove();
	}
	public static int getPageOffset() {
		return pageOffset.get();
	}
	public static void setPageOffset(int _pageOffset) {
		pageOffset.set(_pageOffset);;
	}
	public static void removePageOffset(){
		pageOffset.remove();
	}
	public static int getPageSize() {
		return pageSize.get();
	}
	public static void setPageSize(int _pageSize) {
		pageSize.set(_pageSize);;
	}
	public static void removePageSize(){
		pageSize.remove();
	}
	public static String getOrder() {
		return order.get();
	}
	public static void setOrder(String _order) {
		order.set(_order);
	}
	public static void removeOrder(){
		order.remove();
	}
	
	
}
