package com.books.util.token;

import lombok.Data;

/**
 * 登录用户身份权限
 *
 * @author baijiao
 */
@Data
public class TokenEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户唯一标识
     */
    private String token;

    /**
     * 商户
     */
    private Integer mid;

    /**
     * 门店
     */
    private Integer sid;

    /**
     * 用户
     */
    private Integer userId;

    /**
     * 角色类型（商户，会员）
     */
    private String userType;

    /**
     * 登陆时间
     */
    private Long loginTime;

    /**
     * 过期时间
     */
    private Long expireTime;

    /**
     * 登录IP地址
     */
    private String ipaddr;

    /**
     * 登录地点
     */
    private String loginLocation;

    /**
     * 登录平台
     */
    private String paltform;


    /**
     * 用户ID
     */
    private Integer id;
}
