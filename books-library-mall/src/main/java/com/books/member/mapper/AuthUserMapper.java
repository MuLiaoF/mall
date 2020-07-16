package com.books.member.mapper;



import com.books.mapper.user.BaseAuthUserMapper;
import com.books.request.member.InitMemMiniFansReq;

/**
 * @author feng
 */
public interface AuthUserMapper extends BaseAuthUserMapper {

    int updateAuthUserSessionKey(InitMemMiniFansReq memMiniFans);
}
