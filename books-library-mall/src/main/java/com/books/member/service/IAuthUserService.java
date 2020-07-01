package com.books.member.service;

import com.books.entity.member.SysAuthUser;
import com.books.request.member.InitMemMiniFansReq;
import com.books.request.member.MemMiniFansReq;
import com.books.response.member.AuthUserRes;

/**
 * @author feng
 * @version 1.0
 * @date 2020/7/1 11:56
 */
public interface IAuthUserService {


    /**
     * 初始化粉丝信息
     * @param memMiniFansReq 粉丝信息包装类
     * @throws Exception
     */
    AuthUserRes initMiniFans(MemMiniFansReq memMiniFansReq) throws Exception;

    /**
     * 更新粉丝信息
     * @param memMiniFans
     * @return
     */
    SysAuthUser modifyAuthUser(InitMemMiniFansReq memMiniFans) throws Exception;


}
