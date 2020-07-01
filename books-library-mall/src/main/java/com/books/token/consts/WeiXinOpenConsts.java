package com.books.token.consts;

/**
 * 
 * @author liaoxiang
 * @date 2018/05/09
 * 
 * @see https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1453779503&token=&lang=zh_CN
 */
public class WeiXinOpenConsts {

	/**
	 * 第三方平台component_access_token是第三方平台的下文中接口的调用凭据，也叫做令牌（component_access_token）。每个令牌是存在有效期（2小时）的，且令牌的调用不是无限制的，请第三方平台做好令牌的管理，在令牌快过期时（比如1小时50分）再进行刷新。
	 * http请求方式: POST（请使用https协议）
	 */
	public static final String COMPONENT_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/component/api_component_token";

	/**
	 * 获取（刷新）授权公众号或小程序的接口调用凭据（令牌）http请求方式: POST（请使用https协议）
	 */
	public static final String AUTHORIZER_REFRESH_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/component/api_authorizer_token?component_access_token=%s";

	/**
	 * 获取授权方的帐号基本信息
	 */
	public static final String CREATE_PREAUTHCODE = "https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?component_access_token=%s";

	/**
	 * 获取授权方的帐号基本信息
	 */
	public static final String GET_AUTHORIZER_INFO = "https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_info?component_access_token=%s";

	/**
	 * 使用授权码换取公众号或小程序的接口调用凭据和授权信息
	 */
	public static final String WX_QUERY_AUTH = "https://api.weixin.qq.com/cgi-bin/component/api_query_auth?component_access_token=%s";

}
