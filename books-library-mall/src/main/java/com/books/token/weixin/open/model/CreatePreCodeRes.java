package com.books.token.weixin.open.model;
/*
 * 获取预授权码返回结果
 */
public class CreatePreCodeRes {

	private String pre_auth_code;//预授权码
	private int expires_in;//有效期，为10分钟
	public String getPre_auth_code() {
		return pre_auth_code;
	}
	public void setPre_auth_code(String pre_auth_code) {
		this.pre_auth_code = pre_auth_code;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	
	
	
}
