package com.books.token.weixin.open.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 该API用于在授权方令牌（authorizer_access_token）失效时，可用刷新令牌（authorizer_refresh_token）获取新的令牌。请注意，此处token是2小时刷新一次，开发者需要自行进行token的缓存，避免token的获取次数达到每日的限定额度。缓存方法可以参考：http://mp.weixin.qq.com/wiki/2/88b2bf1265a707c031e51f26ca5e6512.html
 * 
 * @author liaoxiang
 * @date 2018/05/08
 * @see https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1453779503&token=&lang=zh_CN
 */
@Data
@AllArgsConstructor
public class ResAuthorizerRefreshToken {

	/**
	 * 授权方令牌
	 */
	private String authorizer_access_token;

	/**
	 * 有效期，为2小时
	 */
	private Integer expires_in;

	/**
	 * 刷新令牌
	 */
	private String authorizer_refresh_token;

}
