package com.books.request.member;

import com.sun.istack.internal.NotNull;
import lombok.Data;

/**
 * 粉丝信息请求
 * @author feng
 */
@Data
public class MemMiniFansReq {

    @NotNull
    private Integer mid;

    @NotNull
    private String code;

    @NotNull
    private String appid;

}
