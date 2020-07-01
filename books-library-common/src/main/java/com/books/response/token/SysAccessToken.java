package com.books.response.token;

import com.books.util.base.BaseEntity;
import lombok.Data;

/**
 * token对象 sys_access_token
 *
 * @author zye
 * @date 2020-06-03
 */
@Data
public class SysAccessToken extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 公众号名称
     */
    private String appname;

    /**
     * 第三方商户号标识
     */
    private String thirdmid;

    /**
     * 公众号appid
     */
    private String appid;

    /**
     * 公众号app_secret
     */
    private String appSecret;

    /**
     * 公众号app_token
     */
    private String appToken;

    /**
     * 公众号encodingAESKey
     */
    private String encodingaeskey;

    /**
     * 微信公众号接口唯一凭证
     */
    private String accessToken;

    /**
     * 多长时间后失效（单位秒)
     */
    private Integer expiresIn;

    /**
     * 失效截止时间
     */
    private Long expiresTime;

    /**
     * 类型(1-支付服务商4-普通公众号5-第三方公众号平台41-jsapi42-api)
     */
    private Integer type;

    /**
     * 渠道商户号
     */
    private String channelMid;

    /**
     * api_key
     */
    private String apiKey;

    /**
     * 证书路径
     */
    private String certPath;

    /**
     * 证书密码
     */
    private String certPwd;

    /**
     * 支付通知的通用订单模板ID
     */
    private String notifyTemplateId;

    /**
     * 备用1
     */
    private String reserve1;

    /**
     * 代理id
     */
    private Integer agentId;

    /**
     * 父access_token记录的ID
     */
    private Integer parentId;

    /**
     * 是否是开放平台授权
     */
    private String isopen;

    /**
     * 刷新token
     */
    private String refreshToken;

}
