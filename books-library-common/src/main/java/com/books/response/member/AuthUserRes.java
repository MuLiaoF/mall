package com.books.response.member;

import lombok.Data;

/**
 * 粉丝信息初始化接口
 * @author xzf
 */
@Data
public class AuthUserRes {

    private Boolean unionIdFlag;

    private String token;


}
