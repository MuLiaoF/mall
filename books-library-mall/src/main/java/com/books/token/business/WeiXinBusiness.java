package com.books.token.business;

import com.books.entity.token.AccessToken;
import com.books.token.weixin.mp.model.ResAccessToken;
import com.books.token.weixin.mp.model.ResComponentAuthorizerAccessToken;

public interface WeiXinBusiness {

	/**
	 * 获取第三方平台component_access_token
	 * 
	 * @param accessTokenCache
	 * @return
	 */
	ResAccessToken getComponentAccessToken(
            final AccessToken accessTokenCache);

	/**
	 * 获取（刷新）授权公众号或小程序的接口调用凭据（令牌）
	 * 
	 * @param openToken
	 * @param mpToken
	 * @return
	 */
	ResComponentAuthorizerAccessToken getMpAccessToken(AccessToken openToken,
													   AccessToken mpToken);

}
