package com.books.token.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.books.token.consts.WeiXinOpenConsts;
import com.books.token.service.WeiXinAPIService;
import com.books.token.util.HttpClientUtils;
import com.books.token.weixin.open.model.*;
import org.springframework.stereotype.Service;

@Service
public class WeiXinAPIServiceImpl implements WeiXinAPIService {

	@Override
	public ResComponentAccessToken getComponentAccessToken(ReqComponentAccessToken accessToken) {
		String responseStr = HttpClientUtils.sendPost(WeiXinOpenConsts.COMPONENT_ACCESS_TOKEN, accessToken);
		ResComponentAccessToken resComponentAccessToken = JSONObject.parseObject(responseStr,
				ResComponentAccessToken.class);
		return resComponentAccessToken;
	}

	@Override
	public ResAuthorizerRefreshToken getMpAccessToken(String component_access_token,
													  ReqAuthorizerRefreshToken authorizerRefreshToken) {
		String responseStr = HttpClientUtils.sendPost(
				String.format(WeiXinOpenConsts.AUTHORIZER_REFRESH_TOKEN_URL, component_access_token),
				authorizerRefreshToken);
		ResAuthorizerRefreshToken refreshToken = JSONObject.parseObject(responseStr, ResAuthorizerRefreshToken.class);
		return refreshToken;
	}

	public CreatePreCodeRes createPreCode(CreatePreCodeReq createPreCodeReq, String component_access_token) {
		String responseStr = HttpClientUtils
				.sendPost(String.format(WeiXinOpenConsts.CREATE_PREAUTHCODE, component_access_token), createPreCodeReq);
		CreatePreCodeRes createPreCodeRes = JSONObject.parseObject(responseStr, CreatePreCodeRes.class);
		return createPreCodeRes;
	}

	@Override
	public GetAuthorizerInfoRes getAuthorizerInfo(GetAuthorizerInfoReq authQueryReq, String component_access_token) {
		String responseStr = HttpClientUtils
				.sendPost(String.format(WeiXinOpenConsts.GET_AUTHORIZER_INFO, component_access_token), authQueryReq);
		GetAuthorizerInfoRes getAuthorizerInfoRes = JSONObject.parseObject(responseStr, GetAuthorizerInfoRes.class);
		return getAuthorizerInfoRes;
	}

	@Override
	public AuthorizationQueryRes getAuthorization(AuthorizationQueryReq authQueryReq, String component_access_token) {
		String responseStr = HttpClientUtils
				.sendPost(String.format(WeiXinOpenConsts.WX_QUERY_AUTH, component_access_token), authQueryReq);
		AuthorizationQueryRes authorizationQueryRes = JSONObject.parseObject(responseStr, AuthorizationQueryRes.class);
		return authorizationQueryRes;
	}

}
