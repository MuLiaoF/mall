package com.books.token.service.impl;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.weupay.member.token.consts.WeiXinOpenConsts;
import com.weupay.member.token.service.WeiXinAPIService;
import com.weupay.member.token.util.HttpClientUtils;
import com.weupay.member.token.weixin.open.model.AuthorizationQueryReq;
import com.weupay.member.token.weixin.open.model.AuthorizationQueryRes;
import com.weupay.member.token.weixin.open.model.CreatePreCodeReq;
import com.weupay.member.token.weixin.open.model.CreatePreCodeRes;
import com.weupay.member.token.weixin.open.model.GetAuthorizerInfoReq;
import com.weupay.member.token.weixin.open.model.GetAuthorizerInfoRes;
import com.weupay.member.token.weixin.open.model.ReqAuthorizerRefreshToken;
import com.weupay.member.token.weixin.open.model.ReqComponentAccessToken;
import com.weupay.member.token.weixin.open.model.ResAuthorizerRefreshToken;
import com.weupay.member.token.weixin.open.model.ResComponentAccessToken;

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
