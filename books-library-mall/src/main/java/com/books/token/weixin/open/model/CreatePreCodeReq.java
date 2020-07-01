package com.books.token.weixin.open.model;
/*
 * 获取预授权码
 */
public class CreatePreCodeReq {

	private String component_appid;///第三方平台方appid

	public String getComponent_appid() {
		return component_appid;
	}

	public void setComponent_appid(String component_appid) {
		this.component_appid = component_appid;
	}
	
	
}
