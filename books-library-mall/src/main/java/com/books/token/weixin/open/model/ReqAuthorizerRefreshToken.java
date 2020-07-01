package com.books.token.weixin.open.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 5、获取（刷新）授权公众号或小程序的接口调用凭据（令牌）
 * 该API用于在授权方令牌（authorizer_access_token）失效时，可用刷新令牌（authorizer_refresh_token）获取新的令牌。请注意，此处token是2小时刷新一次，开发者需要自行进行token的缓存，避免token的获取次数达到每日的限定额度。缓存方法可以参考：http://mp.weixin.qq.com/wiki/2/88b2bf1265a707c031e51f26ca5e6512.html
 * 
 * @author liaoxiang
 * @date 2018/05/08
 * @see https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1453779503&token=&lang=zh_CN
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqAuthorizerRefreshToken {

	/**
	 * 第三方平台appid
	 */
	private String component_appid;

	/**
	 * 授权方appid
	 */
	private String authorizer_appid;

	/**
	 * 授权方的刷新令牌，刷新令牌主要用于第三方平台获取和刷新已授权用户的access_token，只会在授权时刻提供，请妥善保存。一旦丢失，只能让用户重新授权，才能再次拿到新的刷新令牌
	 */
	private String authorizer_refresh_token;

}
