package com.books.member.service;

import com.books.entity.member.MemMemberInfo;
import com.books.entity.member.SysAuthUser;

/**
 * @author feng
 * @version 1.0
 * @date 2020/7/15 16:02
 */
public interface IMemberService {

    /**
     * 注册会员，开通账户，开通积分
     * @param user
     * @return
     * @throws Exception
     */
    MemMemberInfo regit(SysAuthUser user) throws Exception;
}
