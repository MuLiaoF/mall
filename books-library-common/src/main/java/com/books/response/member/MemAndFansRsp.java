package cn.wandingkeji.auth.web.response;

import cn.wandingkeji.member.entity.MemMemberInfo;
import cn.wandingkeji.system.entity.SysAuthUser;
import lombok.Data;

/**
 * 登录返回粉丝还是会员
 * @author feng
 * @version 1.0
 * @date 2020/6/23 16:49
 */
@Data
public class MemAndFansRsp {

    /**
     * 是否是会员
     */
    private Boolean memFlag;

    /**
     * 是否是粉丝
     */
    private Boolean fansFlag;

    /**
     * 会员信息
     */
    private MemMemberInfo memMemberInfo;


    /**
     * 粉丝信息
     */
    private SysAuthUser authUser;
}
