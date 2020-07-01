package com.books.token.service;

import com.books.token.weixin.open.model.*;

/**
 * 
 * @author liaoxiang
 * @date 2018/05/09
 */
public interface WeiXinAPIService {

	/**
	 * 获取第三方平台component_access_token
	 * 第三方平台component_access_token是第三方平台的下文中接口的调用凭据，也叫做令牌（component_access_token）。每个令牌是存在有效期（2小时）的，且令牌的调用不是无限制的，请第三方平台做好令牌的管理，在令牌快过期时（比如1小时50分）再进行刷新。
	 * 
	 * 接口调用请求说明 http请求方式: POST（请使用https协议）
	 * https://api.weixin.qq.com/cgi-bin/component/api_component_token
	 * 
	 * @see https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1453779503&token=&lang=zh_CN
	 */
	ResComponentAccessToken getComponentAccessToken(ReqComponentAccessToken accessToken);

	/**
	 * 
	 * 获取（刷新）授权公众号或小程序的接口调用凭据（令牌）
	 * 该API用于在授权方令牌（authorizer_access_token）失效时，可用刷新令牌（authorizer_refresh_token）获取新的令牌。请注意，此处token是2小时刷新一次，开发者需要自行进行token的缓存，避免token的获取次数达到每日的限定额度。缓存方法可以参考：http://mp.weixin.qq.com/wiki/2/88b2bf1265a707c031e51f26ca5e6512.html
	 * 
	 * 当换取authorizer_refresh_token后建议保存。
	 * 
	 * 
	 * @param authorizerRefreshToken
	 * @return
	 * @see https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1453779503&token=&lang=zh_CN
	 */
	ResAuthorizerRefreshToken getMpAccessToken(String component_access_token,
                                               ReqAuthorizerRefreshToken authorizerRefreshToken);

	public CreatePreCodeRes createPreCode(CreatePreCodeReq createPreCodeReq, String component_access_token);

	public GetAuthorizerInfoRes getAuthorizerInfo(GetAuthorizerInfoReq authQueryReq, String component_access_token);

	public AuthorizationQueryRes getAuthorization(AuthorizationQueryReq authQueryReq, String component_access_token);

}
