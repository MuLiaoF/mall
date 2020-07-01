package com.books.token.weixin.common.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author liaoxiang
 * @date 2018/05/09
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccessToken implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String thirdmid;

	private String appId;

	private String appSecret;

	private String appToken;

	private String encodingAESKey;

	private String access_token;

	private int expires_in;

	private long expiresTime;

	private int type;

	private String api_key;

	private String cert_path;

	private String cert_pwd;

	private String reserve1;

	private String reserve2;

	private int parent_id;

	private String isopen;

	private String refresh_token;

}
