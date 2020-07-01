package com.books.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.books.entity.member.SysAuthUser;
import com.books.request.member.InitMemMiniFansReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author feng
 */
public interface BaseAuthUserMapper extends BaseMapper<SysAuthUser> {


}
