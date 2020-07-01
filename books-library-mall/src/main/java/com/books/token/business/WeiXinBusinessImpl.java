package com.books.token.business;

import com.books.entity.token.AccessToken;
import com.books.token.entity.ComVerTic;
import com.books.token.service.ComVerTicService;
import com.books.token.service.WeiXinAPIService;
import com.books.token.weixin.mp.model.ResAccessToken;
import com.books.token.weixin.mp.model.ResComponentAuthorizerAccessToken;
import com.books.token.weixin.open.model.ReqAuthorizerRefreshToken;
import com.books.token.weixin.open.model.ReqComponentAccessToken;
import com.books.token.weixin.open.model.ResAuthorizerRefreshToken;
import com.books.token.weixin.open.model.ResComponentAccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeiXinBusinessImpl implements WeiXinBusiness {

	@Autowired
	private ComVerTicService comVerTicService;
	@Autowired
	private WeiXinAPIService weiXinAPIService;

	@Override
	public ResAccessToken getComponentAccessToken(final AccessToken accessTokenCache) {
		ResAccessToken resAccessToken = new ResAccessToken();
		ComVerTic comVerTic = comVerTicService.selectByAppid(accessTokenCache.getAppId());
		if (comVerTic == null) {
			throw new NullPointerException(
					"comVerTic is null !! condition:[appid=" + accessTokenCache.getAppId() + "]");
		}
		ReqComponentAccessToken accessToken = new ReqComponentAccessToken();
		accessToken.setComponent_appid(accessTokenCache.getAppId());
		accessToken.setComponent_appsecret(accessTokenCache.getAppSecret());
		accessToken.setComponent_verify_ticket(comVerTic.getComVerTic());
		ResComponentAccessToken componentAccessToken = weiXinAPIService.getComponentAccessToken(accessToken);
		resAccessToken.setAccess_token(componentAccessToken.getComponent_access_token());
		resAccessToken.setExpires_in(componentAccessToken.getExpires_in());
		return resAccessToken;
	}

	@Override
	public ResComponentAuthorizerAccessToken getMpAccessToken(AccessToken openToken,
			AccessToken mpToken) {
		ResComponentAuthorizerAccessToken accessToken = new ResComponentAuthorizerAccessToken();
		String component_access_token = openToken.getAccessToken();
		ReqAuthorizerRefreshToken authorizerRefreshToken = new ReqAuthorizerRefreshToken(openToken.getAppId(),
				mpToken.getAppId(), mpToken.getRefreshToken());
		ResAuthorizerRefreshToken refreshToken = weiXinAPIService.getMpAccessToken(component_access_token,
				authorizerRefreshToken);
		accessToken.setAccess_token(refreshToken.getAuthorizer_access_token());
		accessToken.setExpires_in(refreshToken.getExpires_in());
		accessToken.setRefresh_token(refreshToken.getAuthorizer_refresh_token());
		return accessToken;
	}

}
