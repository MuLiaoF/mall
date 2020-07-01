package com.books.entity.token;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Table access_token
 * 
 * @author liaoxiang 2018-05-09
 */
@Data
@NoArgsConstructor
public class AccessToken {
    private Integer id;

    private String appname;

    private String thirdmid;

    private String appId;

    private String appSecret;

    private String appToken;

    private String encodingAESKey;

    private String accessToken;

    private Integer expiresIn;

    private Long expiresTime;

    private Integer type;

    private String channelMid;

    private String apiKey;

    private String certPath;

    private String certPwd;

    private String reserve1;

    private String reserve2;

    private Date createTime;

    private Integer agentId;

    private Integer parentId;

    private String isopen;

    private String refreshToken;

    private Date updateTime;

}