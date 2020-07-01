package com.books.token.weixin.open.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取第三方平台component_access_token
 * 
 * @author liaoxiang
 * @date 2018/05/08
 * @see https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1453779503&token=&lang=zh_CN
 */
@Data
@NoArgsConstructor
public class ReqComponentAccessToken {

	/**
	 * 第三方平台appid
	 */
	private String component_appid;

	/**
	 * 第三方平台appsecret
	 */
	private String component_appsecret;

	/**
	 * 微信后台推送的ticket，此ticket会定时推送，具体请见本页的推送说明
	 * 
	 */
	private String component_verify_ticket;

}
