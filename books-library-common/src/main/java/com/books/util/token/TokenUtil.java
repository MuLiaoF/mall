package com.books.util.token;

import lombok.Data;
/**
 * @authorff
 * @title: TokenEntity
 * @projectName ms
 * @description: TODO
 * @date 2019/7/1210:01
 */
@Data
public class TokenUtil {

    public final static String AUTH_SESSION_USER = "user";

    public static TokenEntity getSessionUser(HttpServletRequest request) {
        TokenEntity entity = (TokenEntity) request.getAttribute(AUTH_SESSION_USER);
        return entity;
    }


}
