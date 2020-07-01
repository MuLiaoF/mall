package com.books.token.entity;

import com.books.entity.token.AccessToken;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 
 * @author liaoxiang
 * @date 2018/05/09
 */
@Component
public class GlobalAccessToken {

    //private RedisTemplate<String, Object> redisGlobalAccessToken;

    //private ValueOperations<String, Object> valueOperations;

    private Map<String, AccessToken> accessTokenMap;
    /**
     * js-skd中js初始化config用的jsapitoken
     */
    private Map<String, AccessToken> jsapiTokenMap;
    /**
     * js-skd中js调用卡券时用的apitoken
     */
    private Map<String, AccessToken> apiTokenMap;
    /**
     * key=微信服务商商户号 ,value=AccessToken主键
     */
    private Map<String, String> serviceMap;
    /**
     * 开发平台的key为appid
     */
    private Map<String, AccessToken> openTokenMap;
    /**
     * key=AccessToken主键,value=第三方平台的appid
     */
    private Map<String, String> openServiceMap;
    /**
     * add by fjr 20171024 添加支付宝的token 支付宝授权token集合，key为表主键，value为token对象
     */
    private Map<String, AccessToken> aliAppAuthMap;

    /**
     * 小程序map的key为appid
     */
    private Map<String, AccessToken> miniTokenMap;




}
