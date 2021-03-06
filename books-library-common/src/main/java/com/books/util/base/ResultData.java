package com.books.util.base;

import java.io.Serializable;


/** 
* @Author 作者: Zhaoyongbing
* @Create at 创建时间：2019年10月6日 下午1:26:45 
* @Description 类说明 ：统一返回结果集 封装类
* @version 版本：1.0
* @since JDK 1.8.0_181
*/
public class ResultData<T> implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 2009099091294676135L;
	/**
	 * 返回码      200 / 10000
	 */
	private Integer code;
	/**
	 * 成功/失败  true / false
	 */
	private Boolean success;
	/**
	 * 返回信息
	 */
	private String msg;
	/**
	 * 返回主要数据结果集
	 */
	private T obj;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getObj() {
		return obj;
	}
	public void setObj(T obj) {
		this.obj = obj;
	}

	
}
 