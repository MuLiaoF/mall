package com.books.request.member;

import lombok.Data;

import javax.validation.constraints.NotNull;

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
