package com.books.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.books.entity.token.SysAccessToken;

/**
 * @author feng
 * @version 1.0
 * @date 2020/7/1 17:55
 */
public interface SysAccessTokenMapper extends BaseMapper<SysAccessToken> {

    /**
     * 根据APPID查询TOKEN值
     * @param appid
     * @return
     */
    SysAccessToken getByAppId(String appid) throws Exception;
}
