package cn.wandingkeji.system.entity;

import java.util.Date;

import cn.wandingkeji.common.core.domain.BaseEntity;
import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户对象 sys_user
 *
 * @author baijiao
 */
@Data
public class SysAuthUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    
    private Integer id;

    private Integer mid;

    /** 用户ID */
    private Integer userId;

    /** 部门ID */
    private Integer deptId;

    /** 用户账号 */
    private String userName;

    /** 用户昵称 */
    private String nickName;

    /** 用户邮箱 */
    private String email;

    /** 手机号码 */
    private String phonenumber;

    /** 用户性别 */
    private String sex;

    /** 用户头像 */
    private String avatar;

    /** 密码 */
    private String password;

    /** 盐加密 */
    private String salt;

    /** 帐号状态（0正常 1停用） */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 最后登陆IP */
    private String loginIp;

    /** 最后登陆时间 */
    private Date loginDate;


    /** 角色组 */
    private Integer roleIds;

    /** 岗位组 */
    private Integer postIds;


    private String sessionKey;

    /**
     * 微信第三方用户唯一标识
     */
    private String unionid;

    private String avatarUrl;

    /**
     * 性别
     */
    private String gender;

    /**
     * 市
     */
    private String city;

    /**
     * 省
     */
    private String province;

    /**
     * 国家
     */
    private String country;

    /**
     * 语言
     */
    private String language;

    /**
     * 小程序APPID
     */
    private String appid;

    /**
     * 小程序OPENID
     */
    private String openid;

    private String reserve1;
    private String reserve2;
    
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("userId", getUserId())
                .append("deptId", getDeptId())
                .append("userName", getUserName())
                .append("nickName", getNickName())
                .append("email", getEmail())
                .append("phonenumber", getPhonenumber())
                .append("sex", getSex())
                .append("avatar", getAvatar())
                .append("password", getPassword())
                .append("salt", getSalt())
                .append("status", getStatus())
                .append("delFlag", getDelFlag())
                .append("loginIp", getLoginIp())
                .append("loginDate", getLoginDate())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
