package com.books.token.weixin.mp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 * @author liaoxiang
 * @date 2018/05/08
 * @see https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140183
 */
@Data
@AllArgsConstructor
public class ReqAccessToken {

	/**
	 * 获取access_token填写client_credential
	 */
	private String grant_type;

	/**
	 * 第三方用户唯一凭证
	 */
	private String appid;

	/**
	 * 第三方用户唯一凭证密钥，即appsecret
	 */
	private String secret;

}
