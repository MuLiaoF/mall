package com.books.token.entity;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Table com_ver_tic
 * 
 * @author liaoxiang 2018-05-09
 * 
 */
@Data
@NoArgsConstructor
public class ComVerTic {
    private Integer id;

    private String comVerTic;

    private String appid;

    private String appSecret;

    private Integer expiresIn;

    private Long expiresTime;

    private Date gmtCreate;

    private Date gmtModify;

}