package com.books.token.weixin.open.model;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class ResComponentAccessToken {

	/**
	 * 第三方平台access_token
	 */
	private String component_access_token;

	/**
	 * 有效期
	 */
	private Integer expires_in;

}
