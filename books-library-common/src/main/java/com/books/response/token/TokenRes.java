package com.books.response.token;

import lombok.Data;

/**
 * @author jh
 * @Date
 * @since jdk1.8
 */
@Data
public class TokenRes {

    private int mid;
    private String tokenUrl;
    private int tokenType;
    private String appid;
}
