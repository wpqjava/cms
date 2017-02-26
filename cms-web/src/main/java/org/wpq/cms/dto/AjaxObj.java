package org.wpq.cms.dto;

public class AjaxObj {
	/**
	 * 0失败 1成功
	 */
	private int result;
	private String message;
	private Object obj;
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	public AjaxObj() {
		this.result = 1;
	}
	public AjaxObj(int result, String message, Object obj) {
		super();
		this.result = result;
		this.message = message;
		this.obj = obj;
	}
	public AjaxObj(int result, String message) {
		super();
		this.result = result;
		this.message = message;
	}
	public AjaxObj(int result) {
		super();
		this.result = result;
	}
	
}
