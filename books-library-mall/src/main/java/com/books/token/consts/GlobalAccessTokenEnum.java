package com.books.token.consts;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GlobalAccessTokenEnum {

	ACCESSTOKEN_MAP("accessTokenMap"),

	JSAPI_TOKEN_MAP("jsapiTokenMap"),

	API_TOKEN_MAP("apiTokenMap"),

	SERVICE_MAP("serviceMap"),

	OPEN_TOKEN_MAP("openTokenMap"),

	OPEN_SERVICE_MAP("openServiceMap"),

	ALI_APP_AUTH_MAP("aliAppAuthMap"),

	MINI_TOKEN_MAP("miniTokenMap");

	private String value;

}
