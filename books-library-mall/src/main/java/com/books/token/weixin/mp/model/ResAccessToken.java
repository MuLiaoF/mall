package com.books.token.weixin.mp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author liaoxiang
 * @date 2018/05/08
 * @see https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140183
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResAccessToken {

	/**
	 * 获取到的凭证
	 */
	private String access_token;

	/**
	 * 凭证有效时间，单位：秒
	 */
	private Integer expires_in;

	/**
	 * -1 系统繁忙，此时请开发者稍候再试 0 请求成功 40001
	 * AppSecret错误或者AppSecret不属于这个公众号，请开发者确认AppSecret的正确性 40002
	 * 请确保grant_type字段值为client_credential 40164
	 * 调用接口的IP地址不在白名单中，请在接口IP白名单中进行设置。（小程序及小游戏调用不要求IP地址在白名单内。）
	 */
	private Integer errcode;

	private String errmsg;

}
